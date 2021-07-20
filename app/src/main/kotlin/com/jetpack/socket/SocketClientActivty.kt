package com.jetpack.socket

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.jetpack.socket.bean.SockeViewModel
import com.robert.jetpack.R
import com.robert.jetpack.databinding.ActivitySocketClientBinding

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