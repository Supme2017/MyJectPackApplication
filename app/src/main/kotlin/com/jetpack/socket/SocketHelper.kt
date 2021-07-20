package com.jetpack.socket

import android.content.Intent
import android.os.SystemClock
import com.jetpack.iinterface.SOCKET_PORT
import com.jetpack.utils.UIUtils
import java.io.*
import java.net.Socket
import kotlin.concurrent.thread

class SocketHelper (val activty: SocketClientActivty){

    var socketClient:Socket? = null
    var printWriter: PrintWriter? = null

    
    fun connectSocketServer() {

        thread {
            while (socketClient == null){

                try {
                    socketClient = Socket("localhost", SOCKET_PORT)
                }catch (e : IOException){
                    SystemClock.sleep(1000)
                }
            }

            if (printWriter == null){
                printWriter = PrintWriter(BufferedWriter(OutputStreamWriter(socketClient?.getOutputStream())), true)
            }

            receiver()

        }

    }

    fun conService(){
        Intent(activty, SocketService::class.java).also { intent ->
            activty.startService(intent)
        }
    }

    private fun receiver(){
        try {
            // 接收服务器端的消息
            val br = BufferedReader(InputStreamReader( socketClient?.getInputStream()))

            while (!activty.isFinishing()) {
                val msg = br.readLine()
                UIUtils.showTip(activty, "message from server: " + msg)
            }

            br.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun disconnetSocketClient(){
        socketClient?.close()
    }

    fun send(message: String){

        thread { printWriter?.println(message) }

    }

}