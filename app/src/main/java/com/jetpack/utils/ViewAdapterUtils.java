package com.jetpack.utils;


import android.os.Build;
import android.view.View;

import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingConversion;
import androidx.databinding.adapters.ListenerUtil;

import com.jetpack.iinterface.IViewAttach;
import com.robert.jetpack.R;


public class ViewAdapterUtils {


    @BindingConversion
    public static String conversionString(String newValue) {
        // Important to break potential infinite loops.
        return  newValue;
    }

//    @BindingAdapter(value = {"android:text"})
//    public static void setTextViewText(TextView textView, String oldValue, String newValue){
//
//    }

    @BindingAdapter(value = {"android:onViewDetachedFromWindow", "android:onViewAttachedToWindow"}, requireAll=false)
    public static void setListener(View view, IViewAttach.OnViewDetachedFromWindow detach, IViewAttach.OnViewAttachedToWindow attach) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            View.OnAttachStateChangeListener newListener;
            if (detach == null && attach == null) {
                newListener = null;
            } else {
                newListener = new View.OnAttachStateChangeListener() {
                    @Override
                    public void onViewAttachedToWindow(View v) {
                        if (attach != null) {
                            attach.onViewAttachedToWindow(v);
                        }
                    }
                    @Override
                    public void onViewDetachedFromWindow(View v) {
                        if (detach != null) {
                            detach.onViewDetachedFromWindow(v);
                        }
                    }
                };
            }

            View.OnAttachStateChangeListener oldListener = ListenerUtil.trackListener(view, newListener, R.id.onAttachStateChangeListener);
            if (oldListener != null) {
                view.removeOnAttachStateChangeListener(oldListener);
            }
            if (newListener != null) {
                view.addOnAttachStateChangeListener(newListener);
            }
        }
    }
}
