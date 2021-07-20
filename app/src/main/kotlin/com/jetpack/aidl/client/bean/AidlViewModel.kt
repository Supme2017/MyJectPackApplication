package com.jetpack.aidl.client.bean

import android.app.Activity
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.jetpack.aidl.IBookManager
import com.jetpack.aidl.IOnNewBookArrivedListener
import com.jetpack.aidl.ISecurityCenter
import com.jetpack.aidl.bean.Book
import com.jetpack.aidl.client.BinderPoolsHelper
import com.jetpack.aidl.client.impl.NewBookArrivedListenerImpl
import com.jetpack.iinterface.BINDER_BOOK_MANAGER
import com.jetpack.iinterface.BINDER_SECURITY
import com.jetpack.utils.UIUtils
import kotlin.concurrent.thread


class AidlViewModel:ViewModel (){

    var name: ObservableField<String>? = ObservableField("请输入值")


    lateinit var context : Activity
    private var bookIndex = 1;

    private val bookArrivedListener :IOnNewBookArrivedListener  by lazy { NewBookArrivedListenerImpl(context) }



    fun addBook(view: View){

        thread {
            val book = Book(bookIndex, "书名" + bookIndex.toString())
            bookIndex++
            addBook(book)
        }
    }

    fun getList(view: View){
        thread { getList() }
    }


    fun registerBookListener(view: View){
        thread { registerBookListener() }
    }

    fun unRegisterBookListener(view: View){
        thread { unRegisterBookListener() }
    }


//    fun decrypt(view: View){
//        thread { decrypt() }
//    }
//
//    fun encrypt(view: View){
//        thread { encrypt() }
//    }


    private fun addBook(book: Book){

        val bookManager = getBookManager()
        val flag = bookManager?.addBook(book);

        UIUtils.showTip(context, "add books", flag!!)
    }


    private fun getList() : MutableList<Book>? {
        val bookManager = getBookManager()
        var list :MutableList<Book>? = bookManager?.bookList;

        UIUtils.showTip(context, "books = " + list?.size);


        return list;
    }


    private fun registerBookListener(){
        val bookManager = getBookManager()
        val flag = bookManager?.registerListener(bookArrivedListener);
        UIUtils.showTip(context, "bookmanager registerBookListener", flag!!);
    }

    private fun unRegisterBookListener(){
        val bookManager = getBookManager()
        val flag = bookManager?.unregisterListener(bookArrivedListener);

        UIUtils.showTip(context, "bookmanager unRegisterBookListener", flag!!);

    }

    fun decrypt(text: String){

        thread {
            val decryptString =  getSecurityCenter()?.decrypt(text?:"this is a encrypt text")
            UIUtils.showTip(context, decryptString);
        }

    }

    fun encrypt(view: View, text: String){

        thread { encrypt(text) }
    }

    fun encrypt(text: String): String?{


        val encryptString = getSecurityCenter()?.encrypt(text?:"this is a text");

        UIUtils.showTip(context, encryptString);

        return encryptString
    }

    private fun getBookManager(): IBookManager? {
        var bookManager : IBookManager? = null
        try {
            val binder = BinderPoolsHelper.getInstance().query(BINDER_BOOK_MANAGER)
            bookManager = IBookManager.Stub.asInterface(binder)

        }catch (e: Exception){
            e.printStackTrace()
        }
        return bookManager
    }


    private fun getSecurityCenter(): ISecurityCenter? {
        var securityCenter : ISecurityCenter? = null
        try {
            val binder = BinderPoolsHelper.getInstance().query(BINDER_SECURITY)
            securityCenter = ISecurityCenter.Stub.asInterface(binder)
        }catch (e: Exception){
            e.printStackTrace()
        }
        return securityCenter
    }
}