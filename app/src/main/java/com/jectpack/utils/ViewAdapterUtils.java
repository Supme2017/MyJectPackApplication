package com.jectpack.utils;


import android.os.Build;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingConversion;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.adapters.ListenerUtil;
import androidx.databinding.adapters.TextViewBindingAdapter;

import com.jectpack.MyJectPackApplication;
import com.jectpack.iinterface.IViewAttach;
import com.robert.jectpack.R;


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
