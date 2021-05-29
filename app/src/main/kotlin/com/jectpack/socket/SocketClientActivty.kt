package com.jectpack.socket

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.jectpack.socket.bean.SockeViewModel
import com.robert.jectpack.R
import com.robert.jectpack.databinding.ActivitySocketClientBinding

class SocketClientActivty : AppCompatActivity(){

    lateinit var  binding :  ActivitySocketClientBinding
    val socketHelper = SocketHelper(this@SocketClientActivty)





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_socket_client)
        val viewmodel = ViewModelProvider(this).get(SockeViewModel::class.java)

        binding.socketViewModel = viewmodel
        binding.socketHelper = socketHelper

        startSocketService()
        socketHelper.connectSocketServer()

    }




    override fun onDestroy() {
        super.onDestroy()
        socketHelper.disconnetSocketClient()
        stopSocketService()
    }

    private fun startSocketService(){
        Intent(this, SocketService::class.java).also {intent ->
            startService(intent)
        }

    }

    private fun stopSocketService(){
        Intent(this, SocketService::class.java).also {intent ->
            stopService(intent)
        }

    }
}