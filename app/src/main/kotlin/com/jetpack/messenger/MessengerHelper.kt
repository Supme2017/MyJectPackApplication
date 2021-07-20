package com.jetpack.messenger

import android.app.Activity
import android.os.*
import com.jetpack.iinterface.MESSENGER_FROM_CLIENT
import com.jetpack.iinterface.MESSENGER_FROM_SERVER
import com.jetpack.utils.UIUtils

class MessengerHelper(val activity: Activity, val service: Messenger) {

    private val messengerHandler = object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                MESSENGER_FROM_SERVER -> {
                    UIUtils.showTip(activity, "来自服务端消息 ：" + msg.data.getString("reply"))
                }
                else -> super.handleMessage(msg)
            }
        }
    }

    private val clientMessenger = Messenger(messengerHandler)

    fun sendMessageFromClient(message: String){

        val msg: Message = Message.obtain(null, MESSENGER_FROM_CLIENT)
        val data = Bundle()
        data.putString("msg", message)
        msg.data = data
        msg.replyTo = clientMessenger
        try {
            service.send(msg)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }
}