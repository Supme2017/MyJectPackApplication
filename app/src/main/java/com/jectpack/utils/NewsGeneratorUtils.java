package com.jectpack.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.jectpack.bean.NewsItem;

import java.util.concurrent.atomic.AtomicInteger;

public class NewsGeneratorUtils {

    private static AtomicInteger atomicInteger = new AtomicInteger(500);

    public static NewsItem getNewsItem(){
        int i = atomicInteger.incrementAndGet();
        return new NewsItem(" title -" + i, "content - " + i, i);
    }

}
