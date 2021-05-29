package com.jectpack.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.ObservableInt;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.jectpack.bean.ProgressObserable;
import com.jectpack.bean.UserInfo;
import com.jectpack.bean.UserInfo2;
import com.jectpack.bean.UserInfoObserable;
import com.jectpack.bean.UserViewModel;
import com.jectpack.bean.UserViewModelObservable;
import com.robert.jectpack.BR;
import com.robert.jectpack.R;
import com.robert.jectpack.databinding.ActivityDatabindingBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DataBindingActivity extends AppCompatActivity {
    private static final String TAG = DataBindingActivity.class.getSimpleName();
    private ActivityDatabindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        绑定方式一
//        binding = ActivityDatabindingBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

//        绑定方式二
        binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);

//        UserViewModel viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        UserViewModelObservable viewModel = new ViewModelProvider(this).get(UserViewModelObservable.class);

//        viewModel.progress.set(30);

        UserInfo userInfo = new UserInfo("test", "未知", 29);
        UserInfoObserable userInfoObserable = new UserInfoObserable("test", "未知", 29);

        ProgressObserable progress = new ProgressObserable();
        progress.setProgress(24);

        binding.setUserViewModel(viewModel);
        binding.setUserInfo(userInfo);
        binding.setUserInfoObserable(userInfoObserable);
//        binding.setProgress(progress);

        binding.setLifecycleOwner(this);

        viewModel.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {

                if (propertyId == BR.userInfo){

                } else if (propertyId == BR.userInfoObserable){

                } else if (propertyId == BR.userInfoMutableLiveData){

                }

            }
        });

    }


}