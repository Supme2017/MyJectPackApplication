package com.jetpack.socket.bean

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class SockeViewModel: ViewModel() {

    val message : ObservableField<String> = ObservableField("请输入消息")

}