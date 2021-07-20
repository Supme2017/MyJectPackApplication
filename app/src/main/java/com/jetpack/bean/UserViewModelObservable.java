package com.jetpack.bean;

import android.app.Application;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.Bindable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.jetpack.iinterface.IViewAttach;
import com.jetpack.utils.LoggerUtils;
import com.robert.jetpack.BR;


import java.util.Random;

public class UserViewModelObservable extends AndroidViewModelObservable implements IViewAttach.OnViewAttachedToWindow, IViewAttach.OnViewDetachedFromWindow {

    private UserInfo2 userInfo2 ;
    private MutableLiveData<UserInfo2> userInfoMutableLiveData = new MutableLiveData<>();
//    public ObservableInt progress = new ObservableInt(0);
    public MutableLiveData<Integer> progress = new MutableLiveData<>(0);
    public LiveData<String> showProgressString = Transformations.map(progress, (progress)-> progress.toString() + " progress");


    public UserViewModelObservable(){
        this(null);
    }

    public UserViewModelObservable(Application application){
        super(application);
        userInfo2 = new UserInfo2("小花" ,"女" , 20);
        userInfo2.setHeadIconURL("http://rongcloud-web.qiniudn.com/docs_demo_rongcloud_logo.png");
        userInfoMutableLiveData.setValue(userInfo2);
    }

    @Bindable
    public MutableLiveData<UserInfo2> getUserInfoMutableLiveData(){
        return userInfoMutableLiveData;
    }


    public void request(View view){
        String r = new Random().nextInt()+"";

        userInfo2.setName("小花" + r);
        userInfo2.setSex("女" + r);
        userInfo2.setAge(20);

        userInfoMutableLiveData.setValue(userInfo2);
        notifyPropertyChanged(BR.userInfoMutableLiveData);

    }

    public void tip(View view, String s){
        LoggerUtils.log("huijun", "tip s = " + s);
    }


    public void changeUserInfo(View view, UserInfo userInfo){
        String r = new Random().nextInt()+"";
        userInfo.setName("小花" + r);
        userInfo.setSex("女" + r);
        notifyPropertyChanged(BR.userInfo);

    }


    public void changeUserInfo( UserInfoObserable userInfoObserable){
        String r = new Random().nextInt()+"";
        userInfoObserable.setName("小花" + r);
        userInfoObserable.setSex("女" + r);
        notifyPropertyChanged(BR.userInfoObserable);

    }

    @Override
    public void onViewAttachedToWindow(View v) {
        Toast.makeText(v.getContext(), "onViewAttachedToWindow", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onViewDetachedFromWindow(View v) {
        Toast.makeText(v.getContext(), "onViewDetachedFromWindow", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        LoggerUtils.log("huijun",  "onCleared");

    }

}
