package com.jetpack.bean;

import com.jetpack.iinterface.IBean;

public class NewsItem /*extends BaseObservable*/ implements IBean {
    private String title;
    private String content;
    private int type;

    public NewsItem(String title, String content, int type ){
        this.title = title;
        this.content = content;
        this.type = type;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    // observable实现

//    @Bindable
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//        notifyPropertyChanged(BR.title);
//    }
//
//    @Bindable
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//        notifyPropertyChanged(BR.content);
//    }
//
//    @Bindable
//    public int getType() {
//        return type;
//    }
//
//    public void setType(int type) {
//        this.type = type;
//        notifyPropertyChanged(BR.type);
//    }

}
