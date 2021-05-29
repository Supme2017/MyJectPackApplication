package com.jectpack.coroutines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MyCoroutineActivity : AppCompatActivity(), CoroutineScope {

    var job: Job? = null

    fun startPresenting(){
        job = loadData()
    }

    fun stopPresenting(){
        job?.cancel()
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        job = loadData()
    }


    fun loadData() = launch {

    }
}