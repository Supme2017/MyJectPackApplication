package com.jetpack.impl;

import android.util.Log;

import com.jetpack.iinterface.IRepositoryServer;

import javax.inject.Inject;

public class LocalIRepositoryServer implements IRepositoryServer {
    public static final String TAG = LocalIRepositoryServer.class.getSimpleName();

    @Inject
    public LocalIRepositoryServer(){

    }

    @Override
    public void request(String url) {
        Log.i(TAG, "LocalIRepositoryServer request url = " + url);
    }
}
