package com.jectpack.aidl.service.impl

import android.os.IBinder
import com.jectpack.aidl.IBinderPools
import com.jectpack.aidl.IBookManager
import com.jectpack.aidl.ISecurityCenter
import com.jectpack.iinterface.BINDER_BOOK_MANAGER
import com.jectpack.iinterface.BINDER_SECURITY
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