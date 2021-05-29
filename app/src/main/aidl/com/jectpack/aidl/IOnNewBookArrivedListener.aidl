package com.jectpack.aidl;

import com.jectpack.aidl.bean.Book;

interface IOnNewBookArrivedListener {
    void onNewBookArrived(in List<Book> list);
}
