package com.jectpack.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;


@BindingMethods({
//        @BindingMethod(type = TextView.class, attribute = "showMyCustomTip1", method = "showMyCustomTip1"),
        @BindingMethod(type = TextView.class, attribute = "mySetText", method = "heheMyText")
})
public class MyTextView extends androidx.appcompat.widget.AppCompatTextView {
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void heheMyText( String string){
        setText(string + " MySuffix");
    }
    public void setMySetText( String string){
        setText(string + " MySuffix");
    }

    public void mySetText( String string){
        setText(string + " MySuffix");
    }
}
