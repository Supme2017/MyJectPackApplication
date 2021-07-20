package com.jetpack.aidl.service.impl

import com.jetpack.aidl.ISecurityCenter
import javax.inject.Inject

class SecurityCenterImpl @Inject constructor() : ISecurityCenter.Stub() {


    override fun decrypt(password: String?): String {
        return "decrypt : " + password
    }

    override fun encrypt(content: String?): String {
        return "encrypt : " + content
    }
}