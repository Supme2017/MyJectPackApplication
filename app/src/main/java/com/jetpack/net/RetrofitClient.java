package com.jetpack.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance;
    private Retrofit mRetrofit;


    public static RetrofitClient getInstance() {
        if (instance==null){
            instance=new RetrofitClient();
        }
        return instance;
    }

    public <T> T createApi(Class<T> cls){
        T t=mRetrofit.create(cls);
        return t;
    }

    private OkHttpClient getClient(){
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)//设置超时时间
                .readTimeout(30, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(30, TimeUnit.SECONDS);//设置写入超时时间
        return builder.build();
    }

    private RetrofitClient() {
        mRetrofit=new Retrofit.Builder()
                .baseUrl("http://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();

    }
}
