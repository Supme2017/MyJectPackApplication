package com.jectpack.aidl.client.impl

import android.app.Activity
import android.content.Context
import android.nfc.Tag
import android.util.Log
import com.jectpack.aidl.bean.Book
import com.jectpack.aidl.IOnNewBookArrivedListener
import com.jectpack.utils.UIUtils

class NewBookArrivedListenerImpl (val context: Context) : IOnNewBookArrivedListener.Stub() {

    private val TAG = NewBookArrivedListenerImpl::class.java.simpleName
    override fun onNewBookArrived(list: MutableList<Book>?) {

        Log.i(TAG, "onNewBookArrived book size = " + list?.size)


        UIUtils.showTip(context, "onNewBookArrived book size = " + list?.size)
    }
}