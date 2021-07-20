package com.jetpack.aidl.client

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jetpack.aidl.IBookManager
import com.jetpack.aidl.IOnNewBookArrivedListener
import com.jetpack.aidl.bean.Book
import com.jetpack.aidl.client.impl.NewBookArrivedListenerImpl
import com.jetpack.aidl.service.AidlService
import com.jetpack.utils.UIUtils
import com.robert.jetpack.R
import com.robert.jetpack.databinding.ActivityAidlBinding
import kotlin.concurrent.thread

class AidlActivity : AppCompatActivity(), View.OnClickListener{

    private val TAG = AidlActivity::class.java.simpleName;

    private lateinit var binding : ActivityAidlBinding; //此时binding值不能为null, 只是延迟初始化
//    private var binding : ActivityAidlBinding? = null; //此时允许binding为空， 需要可空类型定义

    private var bookManager : IBookManager?= null; //此时允许binding为空， 需要可空类型定义

    private var bookIndex = 1;

    private val bookArrivedListener : IOnNewBookArrivedListener = NewBookArrivedListenerImpl(this)

    private val bookManagerConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            bookManager =  IBookManager.Stub.asInterface(service)

        }

        override fun onServiceDisconnected(name: ComponentName?) {
            bookManager = null;
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //绑定方式一：通过xml的生成类直接绑定布局
//        binding = ActivityAidlBinding.inflate(layoutInflater)

        //绑定方式二：通过DataBindingUtil 和 xml 来绑定布局
        binding = DataBindingUtil.setContentView(this, R.layout.activity_aidl)

        startService()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopService()
    }




    override fun onClick(v: View) {
        when(v.id){

            R.id.btn_aidl_add_service -> {
                thread { addBook() }
            }

            R.id.btn_aidl_getlist_service -> {

                thread { getList() }
            }

            R.id.btn_aidl_register_service -> {

                thread { registerBookListener() }
            }

            R.id.btn_aidl_unregister_service -> {

                thread { unRegisterBookListener() }
            }
        }
    }


    private fun addBook(){

        val book = Book(bookIndex, "书名" + bookIndex.toString())
        bookIndex++
        val flag = bookManager?.addBook(book)

        UIUtils.showTip(this, "add books", flag!!)
    }


    private fun getList() : MutableList<Book>? {
        var list :MutableList<Book>? = bookManager?.bookList;

        UIUtils.showTip(this, "books = " + list?.size);

        return list;
    }


    private fun registerBookListener(){
        val flag = bookManager?.registerListener(bookArrivedListener);
        UIUtils.showTip(this, "bookmanager registerBookListener", flag!!);
    }

    private fun unRegisterBookListener(){
        val flag = bookManager?.unregisterListener(bookArrivedListener);

        UIUtils.showTip(this, "bookmanager unRegisterBookListener", flag!!);

    }

    private fun startService(){
        Intent(this, AidlService::class.java).also { intent->
            bindService(intent, bookManagerConnection, Context.BIND_AUTO_CREATE)
        }
    }

    private fun stopService(){
        unbindService(bookManagerConnection)
    }

}