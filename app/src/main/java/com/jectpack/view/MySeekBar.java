package com.jectpack.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.SeekBar;

import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;

import com.robert.jectpack.R;

@InverseBindingMethods({@InverseBindingMethod(type = MySeekBar.class, attribute = "myProgress", event = "myProgressAttrChanged", method = "getMyProgress")}) @BindingMethods({@BindingMethod(type = MySeekBar.class, attribute = "myProgress", method = "setMyProgress")})
public class MySeekBar extends androidx.appcompat.widget.AppCompatSeekBar {

    private static InverseBindingListener mInverseBindingListener;

    public MySeekBar(Context context) {
        this(context, null);

    }

    public MySeekBar(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.seekBarStyle);
    }

    public MySeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (mInverseBindingListener != null) {
                    mInverseBindingListener.onChange();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    /**
     * 以下是基于@BindingMethods， @InverseBindingMethods实现的自定义数据双向绑定
     *
     * */
    public void setMyProgress(int progress) {
        if (getMyProgress() != progress) {
            setProgress(progress);
        }

    }

    public int getMyProgress() {
        return getProgress();
    }

    public void setMyProgressAttrChanged(/*MySeekBar seekBar, */InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            Log.e("错误！", "InverseBindingListener为空!");
        } else {
            mInverseBindingListener = inverseBindingListener;
        }
    }


    /**
     * 以下另一种基于@BindingAdapter， @InverseBindingAdapter实现的自定义数据双向绑定
     *
     * */

//    @BindingAdapter(value = "myProgress", requireAll = false)
//    public static void setMyProgress(MySeekBar seekBar, int progress) {
//        if (getMyProgress(seekBar) != progress) {
//            seekBar.setProgress(progress);
//        }
//    }
//
//    @InverseBindingAdapter(attribute = "myProgress", event = "myProgressAttrChanged")
//    public static int getMyProgress(MySeekBar seekBar) {
//        return seekBar.getProgress();
//    }
//
//    @BindingAdapter(value = {"myProgressAttrChanged"}, requireAll = false)
//    public static void setMyProgressAttrChanged(MySeekBar seekBar, InverseBindingListener inverseBindingListener) {
//        if (inverseBindingListener == null) {
//            Log.e("错误！", "InverseBindingListener为空!");
//        } else {
//            mInverseBindingListener = inverseBindingListener;
//        }
//    }

}
