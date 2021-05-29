package com.jectpack.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;


//@BindingMethods({
//        @BindingMethod(type = EditText.class, attribute = "showCustomTip", method = "showMyCustomTip"),
//        @BindingMethod(type = EditText.class, attribute = "text", method = "setMyText")
//})

@InverseBindingMethods({ @InverseBindingMethod(type = EditText.class, attribute = "showCustomTip", method = "setMyText")})
public class MyEditText extends androidx.appcompat.widget.AppCompatEditText {
    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public  void showCustomTip( String tip){
//        Toast.makeText(getContext(), tip, Toast.LENGTH_SHORT).show();
    }


    public void setMyText(String newValue){
        if (!getText().equals(newValue)){
            setText(newValue );
        }

    }
}
