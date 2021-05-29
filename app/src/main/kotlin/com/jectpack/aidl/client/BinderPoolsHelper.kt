package com.jectpack.aidl.client

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.os.IBinder.DeathRecipient
import android.util.Log
import com.jectpack.MyJectPackApplication
import com.jectpack.aidl.IBinderPools
import com.jectpack.aidl.service.BinderPoolsService
import java.util.concurrent.CountDownLatch

class BinderPoolsHelper private constructor(){

    private var binderPools : IBinderPools?= null; //此时允许binding为空， 需要可空类型定义
    private val context = MyJectPackApplication.getApplication();

    private lateinit var countDownLatch : CountDownLatch

    private val binderPoolsConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            binderPools =  IBinderPools.Stub.asInterface(service)

            //注册binder的死亡监听
            binderPools?.asBinder()?.linkToDeath(binderDeathRecipient, 0)
            countDownLatch.countDown()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            binderPools = null;

        }
    }

    private var binderDeathRecipient: DeathRecipient = object : DeathRecipient {
        override fun binderDied() {

            binderPools?.asBinder()?.unlinkToDeath(this, 0)
            binderPools = null
            connectService(context)
        }
    }

    init {
       connectService(context)
    }

    companion object {
        fun getInstance(): BinderPoolsHelper {

            return Singleton.INSTANCES
        }
    }

    private object Singleton  {
        val INSTANCES = BinderPoolsHelper()
    }


    private fun connectService(context: Context){

        //binderPools
        countDownLatch = CountDownLatch(1)

        Intent(context, BinderPoolsService::class.java).also { intent ->
            context.bindService(intent, binderPoolsConnection, Context.BIND_AUTO_CREATE)
        }
        countDownLatch.await()
    }

    private fun stopService(context: Context){

        context.unbindService(binderPoolsConnection)

    }


    fun query(binderType: Int): IBinder?{

        return binderPools?.queryBinder(binderType)
    }


    fun onDestroy(){
        stopService(context)
    }

}