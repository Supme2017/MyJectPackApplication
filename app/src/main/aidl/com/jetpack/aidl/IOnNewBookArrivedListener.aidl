package com.jetpack.aidl;

import com.jetpack.aidl.bean.Book;

interface IOnNewBookArrivedListener {
    void onNewBookArrived(in List<Book> list);
}
