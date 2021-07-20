package com.jetpack.messenger

import android.app.Service
import android.content.Intent
import android.os.*
import com.jetpack.MyJectPackApplication
import com.jetpack.iinterface.MESSENGER_FROM_CLIENT
import com.jetpack.iinterface.MESSENGER_FROM_SERVER
import com.jetpack.utils.UIUtils

class MessengerService : Service(){

    private val TAG = "MessengerService"
    private val context = MyJectPackApplication.getApplication()

    private val messengerHandler  =  object  : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                MESSENGER_FROM_CLIENT -> {
                    UIUtils.showTip(context, "来自客户端消息 ：" + msg.data.getString("msg"))
                    sendMessageFromService(msg)
                }
                else -> super.handleMessage(msg)
            }
        }
    }

    private val mMessenger = Messenger(messengerHandler)


    override fun onBind(intent: Intent?): IBinder? {
        return mMessenger.binder
    }


    fun sendMessageFromService(msg: Message){
        val client = msg.replyTo
        val relpyMessage: Message = Message.obtain(null, MESSENGER_FROM_SERVER)
        val bundle = Bundle()
        bundle.putString("reply", "发自messenger服务端的消息")
        relpyMessage.data = bundle

        client.send(relpyMessage)

    }

}