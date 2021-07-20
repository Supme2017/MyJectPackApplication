package com.jetpack.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableInt;

public class ProgressObserable extends BaseObservable {
    private ObservableInt progress = new ObservableInt(0);



    public ObservableInt getProgress() {
        return progress;
    }

    public void setProgress(int p) {
        progress.set(p);
    }
}
