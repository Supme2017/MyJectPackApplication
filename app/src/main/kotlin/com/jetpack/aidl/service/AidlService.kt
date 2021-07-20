package com.jetpack.aidl.service

import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.os.IBinder
import android.util.Log
import com.jetpack.aidl.IBookManager
import com.jetpack.aidl.service.impl.BookManageImpl

class AidlService : Service() {

    private val TAG = AidlService::class.java.simpleName;
    val bookManage : IBookManager.Stub = BookManageImpl();

    override fun onBind(intent: Intent?): IBinder? {
        Log.i(TAG, "onBind thread name = " + Thread.currentThread().name)
        val check = checkCallingOrSelfPermission("com.robert.jectpack.permission.ACCESS_AIDL_SERVICE")
        return if (check == PackageManager.PERMISSION_DENIED) null  else bookManage;
//        return bookManage
    }


}