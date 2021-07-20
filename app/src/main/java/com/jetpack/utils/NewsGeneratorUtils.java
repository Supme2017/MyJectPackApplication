package com.jetpack.utils;

import com.jetpack.bean.NewsItem;
import com.jetpack.bean.NewsItem2;

import java.util.concurrent.atomic.AtomicInteger;

public class NewsGeneratorUtils {

    private static AtomicInteger atomicInteger = new AtomicInteger(500);

    public static NewsItem getNewsItem(){
        int i = atomicInteger.incrementAndGet();
        return new NewsItem(" title -" + i, "content - " + i, i);
    }

    public static NewsItem2 getNewsItem2(){
        int i = atomicInteger.incrementAndGet();
        return new NewsItem2(" title -" + i, "content - " + i, i);
    }

}
