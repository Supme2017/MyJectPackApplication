package com.jetpack.bean;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.jetpack.utils.LoggerUtils;

public class ParamsViewModel extends ViewModel {

    String name2;
    public ParamsViewModel(@NonNull String name) {
        super();
        this.name2 = name;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        LoggerUtils.log("huijun",  "onCleared");

    }


    //如果viewmodel构造方法里需要传入额外的参数，需使用Factory实现
    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final String name;

        public Factory(@NonNull String name) {
            this.name = name;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            return (T) new ParamsViewModel(name);
        }
    }
}
