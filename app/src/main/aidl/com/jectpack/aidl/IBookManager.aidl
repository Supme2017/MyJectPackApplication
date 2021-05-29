package com.jectpack.aidl;

import com.jectpack.aidl.bean.Book;
import com.jectpack.aidl.IOnNewBookArrivedListener;

interface IBookManager {
     List<Book> getBookList();
     boolean addBook(in Book book);
     boolean registerListener(IOnNewBookArrivedListener listener);
     boolean unregisterListener(IOnNewBookArrivedListener listener);
}