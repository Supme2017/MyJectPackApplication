package com.jetpack.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.jetpack.aidl.IBookManager;

import javax.inject.Inject;

public class TestService extends Service {

    @Inject
    IBookManager.Stub bookManager;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
