package com.jectpack.impl;

import android.util.Log;

import com.jectpack.iinterface.IRepositoryServer;

import javax.inject.Inject;


public class RemoteRepositoryServer implements IRepositoryServer {
    public static final String TAG = RemoteRepositoryServer.class.getSimpleName();

    @Inject
    public RemoteRepositoryServer(){

    }

    @Override
    public void request(String url) {
        Log.i(TAG, "RemoteRepositoryServer request url = " + url);
    }
}
