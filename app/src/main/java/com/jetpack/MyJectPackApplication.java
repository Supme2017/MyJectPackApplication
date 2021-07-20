package com.jetpack;

import androidx.multidex.MultiDexApplication;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class MyJectPackApplication extends MultiDexApplication {

    private static MyJectPackApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static MyJectPackApplication getApplication(){
        return application;
    }
}
