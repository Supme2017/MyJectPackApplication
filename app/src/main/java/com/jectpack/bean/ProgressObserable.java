package com.jectpack.bean;

import android.text.method.TransformationMethod;
import android.view.animation.Transformation;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.Transformations;

import com.robert.jectpack.BR;

public class ProgressObserable extends BaseObservable {
    private ObservableInt progress = new ObservableInt(0);



    public ObservableInt getProgress() {
        return progress;
    }

    public void setProgress(int p) {
        progress.set(p);
    }
}
