package com.jetpack.iinterface;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

public interface IViewAttach {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public interface OnViewDetachedFromWindow {
        void onViewDetachedFromWindow(View v);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public interface OnViewAttachedToWindow {
        void onViewAttachedToWindow(View v);
    }
}
