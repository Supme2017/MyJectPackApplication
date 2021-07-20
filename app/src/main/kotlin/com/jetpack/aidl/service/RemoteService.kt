package com.jetpack.aidl.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.jetpack.aidl.IBookManager
import com.jetpack.aidl.service.impl.BookManageImpl

class RemoteService : Service() {


    val bookManager : IBookManager.Stub = BookManageImpl();

    override fun onBind(intent: Intent?): IBinder? {
        return bookManager;
    }

}