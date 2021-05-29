package com.jectpack.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.jectpack.iinterface.IBean;
import com.robert.jectpack.BR;

public class NewsItemObservable extends BaseObservable implements IBean {
    private String title;
    private String content;
    private int type;

    public NewsItemObservable(String title, String content, int type ){
        this.title = title;
        this.content = content;
        this.type = type;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }

    @Bindable
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        notifyPropertyChanged(BR.type);
    }

}
