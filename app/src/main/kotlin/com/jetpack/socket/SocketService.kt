package com.jetpack.socket

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.jetpack.MyJectPackApplication
import com.jetpack.iinterface.SOCKET_PORT
import java.io.*
import java.net.ServerSocket
import kotlin.concurrent.thread

class SocketService: Service() {

    private val TAG = "SocketService"

    private val context = MyJectPackApplication.getApplication()
    private var mIsServiceDestoryed : Boolean = false
    var serverSocket :ServerSocket? = null


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.e(TAG , "onStartCommand" )
        if (serverSocket == null){
            thread {
                startService()

            }


        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun accept(){
        while (!mIsServiceDestoryed) {
            try {
                // 接受客户端请求
                val client = serverSocket?.accept()

                // 用于接收客户端消息
                val clientIn = BufferedReader(InputStreamReader(client?.getInputStream()))

                // 用于向客户端发送消息
                val clientOut = PrintWriter(BufferedWriter( OutputStreamWriter(client?.getOutputStream())), true)


                while (!mIsServiceDestoryed) {
                    val str = clientIn.readLine()

//                    UIUtils.showTip(context, "message from client: " + str)

                    //向client发送消息
                    clientOut.println("欢迎来sockect Server : ${str}")
                }

                client?.close()
                clientIn.close()
                clientOut.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun startService(){

        serverSocket = try {
            ServerSocket(SOCKET_PORT)
        } catch (e: IOException) {
            Log.e(TAG , "startService e = " + e.message )
            e.printStackTrace()
            return
        }

        Log.e(TAG , "startService serverSocket = " + serverSocket )

        accept()

    }

    override fun onDestroy() {
        super.onDestroy()
        serverSocket?.close()
        mIsServiceDestoryed = true
    }
}