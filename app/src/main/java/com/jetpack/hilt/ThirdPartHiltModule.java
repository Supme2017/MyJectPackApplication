package com.jetpack.hilt;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import okhttp3.OkHttpClient;

/**
 * 针对第三方，不能提供源代码时，使用hilt的一种方式
 * */
@Module
@InstallIn({ApplicationComponent.class})
public class ThirdPartHiltModule {


    @Singleton
    @Provides
    public static HashMap<String, String> bindHashMap(){
        HashMap<String, String> map  = new HashMap<>();
        map.put("testKey", "testValue");
        return map;
    }

    @Singleton
    @Provides
    public OkHttpClient bindOkHttpClient(){

        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .build();

    }

}
