package com.jetpack.aidl.client.impl

import android.content.Context
import android.util.Log
import com.jetpack.aidl.bean.Book
import com.jetpack.aidl.IOnNewBookArrivedListener
import com.jetpack.utils.UIUtils

class NewBookArrivedListenerImpl (val context: Context) : IOnNewBookArrivedListener.Stub() {

    private val TAG = NewBookArrivedListenerImpl::class.java.simpleName
    override fun onNewBookArrived(list: MutableList<Book>?) {

        Log.i(TAG, "onNewBookArrived book size = " + list?.size)


        UIUtils.showTip(context, "onNewBookArrived book size = " + list?.size)
    }
}