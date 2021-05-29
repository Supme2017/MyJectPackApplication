package com.jectpack.messenger

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.jectpack.messenger.bean.MessengerViewModel
import com.jectpack.socket.bean.SockeViewModel
import com.robert.jectpack.R
import com.robert.jectpack.databinding.ActivityMessengerBinding
import com.robert.jectpack.databinding.ActivitySocketClientBinding

class MessengerActivty : AppCompatActivity(){

    lateinit var binding :  ActivityMessengerBinding
    lateinit var mService: Messenger
    lateinit var messengerHelper: MessengerHelper

    private val connection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            mService = Messenger(service)

            messengerHelper = MessengerHelper(this@MessengerActivty, mService)
            binding.messengerHelper = messengerHelper
        }

        override fun onServiceDisconnected(className: ComponentName) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_messenger)
        val viewmodel = ViewModelProvider(this).get(MessengerViewModel::class.java)

        binding.messengerViewModel = viewmodel


        startService()

    }

    override fun onDestroy() {
        super.onDestroy()
        stopService()
    }

    private fun startService(){
        Intent(this, MessengerService::class.java).also {intent ->
            bindService(intent, connection, BIND_AUTO_CREATE)
        }

    }

    private fun stopService(){
        unbindService(connection)
    }

}