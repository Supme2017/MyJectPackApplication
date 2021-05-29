package com.jectpack.impl;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jectpack.bean.NewsItem;

public class NewsOnClickListener{
    private static final String TAG = NewsOnClickListener.class.getSimpleName();

    public void onClick(View view, NewsItem data) {

        Toast.makeText(view.getContext(), "LinearLayout value = " + data.getTitle(), Toast.LENGTH_SHORT).show();
    }


    public void onClick(NewsItem data) {
        String s = data.getTitle() + data.getType();
        Log.e(TAG, "S = " + s);
    }


    public void onClick(NewsItem data, String text) {
        String s = text + " : " + data.getTitle() ;

        Log.e(TAG, "S = " + s);
    }
}
