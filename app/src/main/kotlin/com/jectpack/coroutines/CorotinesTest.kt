package com.jectpack.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CorotinesTest {

    private val uiCorotines: CoroutineDispatcher = Dispatchers.Main
    private val bgCorotines: CoroutineDispatcher = Dispatchers.IO

    fun test(){
        GlobalScope.launch {

        }
    }
}