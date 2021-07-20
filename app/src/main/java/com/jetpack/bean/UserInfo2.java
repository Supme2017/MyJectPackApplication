package com.jetpack.bean;

import androidx.databinding.ObservableField;

public class UserInfo2 {
    private ObservableField<String> name;
    private String sex;
    private int age;
    private String headIconURL;

    public UserInfo2(String name, String sex, int age) {
        this.name = new ObservableField<>(name);
        this.sex = sex;
        this.age = age;
    }

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(String name) {

        this.name.set(name);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getHeadIconURL() {
        return headIconURL;
    }

    public void setHeadIconURL(String headIconURL) {
        this.headIconURL = headIconURL;
    }
}
