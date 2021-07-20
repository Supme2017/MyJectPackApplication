package com.jetpack.aidl.service

import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.os.IBinder
import android.util.Log
import com.jetpack.aidl.IBinderPools
import com.jetpack.aidl.service.impl.BinderPoolsImpl

class BinderPoolsService : Service() {

    private val TAG = BinderPoolsService::class.java.simpleName;
    val binderPools : IBinderPools.Stub = BinderPoolsImpl();

    override fun onBind(intent: Intent?): IBinder? {
        Log.i(TAG, "onBind thread name = " + Thread.currentThread().name)

        val check = checkCallingOrSelfPermission("com.robert.jectpack.permission.ACCESS_AIDL_SERVICE")
        return if (check == PackageManager.PERMISSION_DENIED) null  else binderPools;
    }


}