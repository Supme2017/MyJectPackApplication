package com.jetpack.aidl;

import com.jetpack.aidl.bean.Book;
import com.jetpack.aidl.IOnNewBookArrivedListener;

interface IBookManager {
     List<Book> getBookList();
     boolean addBook(in Book book);
     boolean registerListener(IOnNewBookArrivedListener listener);
     boolean unregisterListener(IOnNewBookArrivedListener listener);
}