package com.jetpack.aidl.service.impl

import android.os.IBinder
import com.jetpack.aidl.IBinderPools
import com.jetpack.aidl.IBookManager
import com.jetpack.aidl.ISecurityCenter
import com.jetpack.iinterface.BINDER_BOOK_MANAGER
import com.jetpack.iinterface.BINDER_SECURITY
import javax.inject.Inject

class BinderPoolsImpl @Inject constructor() : IBinderPools.Stub() {


    val bookManager : IBookManager.Stub = BookManageImpl();
    val securityCenter : ISecurityCenter.Stub = SecurityCenterImpl();

    override fun queryBinder(binderFlag: Int): IBinder? {
        var binder : IBinder? = null;
        when(binderFlag){
            BINDER_BOOK_MANAGER -> binder = bookManager
            BINDER_SECURITY -> binder = securityCenter
        }
        return binder
    }
}