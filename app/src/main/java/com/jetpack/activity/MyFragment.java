package com.jetpack.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jetpack.bean.UserViewModel;
import com.jetpack.hilt.annotation.LocalServer;
import com.jetpack.hilt.annotation.RemoteServer;
import com.jetpack.iinterface.IRepositoryServer;

import java.util.HashMap;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import okhttp3.OkHttpClient;

@AndroidEntryPoint
public class MyFragment extends Fragment {

    @LocalServer
    @Inject
    IRepositoryServer localServer;

    @RemoteServer
    @Inject
    IRepositoryServer remoteServer;

//    @Inject
//    AbstractRepositoryServer abstractServer;

    @Inject
    HashMap<String, String> testMap;

    @Inject
    OkHttpClient okHttpClient;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserViewModel viewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
    }
}
