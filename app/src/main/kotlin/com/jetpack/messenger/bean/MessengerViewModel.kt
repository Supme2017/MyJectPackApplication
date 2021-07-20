package com.jetpack.messenger.bean

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class MessengerViewModel: ViewModel() {

    val message : ObservableField<String> = ObservableField("请输入消息")

}