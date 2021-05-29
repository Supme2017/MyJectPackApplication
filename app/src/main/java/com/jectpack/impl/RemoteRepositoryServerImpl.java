package com.jectpack.impl;

import android.app.Application;
import android.util.Log;

import com.jectpack.hilt.annotation.LocalServer;
import com.jectpack.iinterface.AbstractRepositoryServer;
import com.jectpack.iinterface.IRepositoryServer;

import javax.inject.Inject;


public class RemoteRepositoryServerImpl extends AbstractRepositoryServer {
    public static final String TAG = RemoteRepositoryServerImpl.class.getSimpleName();



    IRepositoryServer localServer;
    Application application;


    @Inject
    public RemoteRepositoryServerImpl(Application application){
        this.application = application;
    }


//    @Inject
//    public RemoteRepositoryServerImpl( @LocalServer IRepositoryServer localServer){
//        this.localServer = localServer;
//    }

    @Override
    public void request(String url) {

        if (localServer != null){
            Log.i(TAG, " IRepositoryServer request url " + url);
        } else {
            Log.i(TAG, " AbstractRepositoryServer request url " + url);
        }

    }
}
