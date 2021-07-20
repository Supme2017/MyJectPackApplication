package com.jetpack.impl;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jetpack.bean.NewsItem;
import com.jetpack.bean.NewsItem2;

public class News2OnClickListener {
    private static final String TAG = News2OnClickListener.class.getSimpleName();

    public void onClick(View view, NewsItem2 data) {

        Toast.makeText(view.getContext(), "LinearLayout value = " + data.getTitle(), Toast.LENGTH_SHORT).show();
    }


    public void onClick(NewsItem2 data) {
        String s = data.getTitle() + data.getType();
        Log.e(TAG, "S = " + s);
    }


    public void onClick(NewsItem2 data, String text) {
        String s = text + " : " + data.getTitle() ;

        Log.e(TAG, "S = " + s);
    }
}
