package com.jetpack.aidl.service.impl

import android.os.RemoteCallbackList
import com.jetpack.aidl.bean.Book
import com.jetpack.aidl.IBookManager
import com.jetpack.aidl.IOnNewBookArrivedListener
import javax.inject.Inject

class BookManageImpl @Inject constructor() : IBookManager.Stub() {

    private val  books : MutableList<Book> = mutableListOf();
    private val callbackList : RemoteCallbackList<IOnNewBookArrivedListener> = RemoteCallbackList();


    override fun addBook(book: Book): Boolean {
        val isSuccess = books.add(book);
        notifyBooks();
        return isSuccess
    }


    override fun getBookList(): MutableList<Book> {

        return books;
    }

    override fun registerListener(listener: IOnNewBookArrivedListener?) : Boolean{
        return callbackList.register(listener);
    }

    override fun unregisterListener(listener: IOnNewBookArrivedListener?) : Boolean {
        return callbackList.unregister(listener);
    }

    private fun notifyBooks(){
        val count = callbackList.beginBroadcast(); //开启事务
        if (count > 0){
            var listener :IOnNewBookArrivedListener;
            for (i in 0 until count){
                listener = callbackList.getBroadcastItem(i);
                listener.onNewBookArrived(books);
            }
        }

        callbackList.finishBroadcast(); //结束事务
    }
}