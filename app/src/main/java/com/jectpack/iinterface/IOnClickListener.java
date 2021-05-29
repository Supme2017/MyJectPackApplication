package com.jectpack.iinterface;

import android.view.View;

public interface IOnClickListener<V extends View, D> {
    void onClick(V view, D data);
}
