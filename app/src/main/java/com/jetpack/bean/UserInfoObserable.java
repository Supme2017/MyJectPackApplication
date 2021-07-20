package com.jetpack.bean;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.robert.jetpack.BR;

public class UserInfoObserable extends BaseObservable {
    private String name;
    private String sex;
    private int age;

    public UserInfoObserable(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }



    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        notifyPropertyChanged(BR.sex);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
}
