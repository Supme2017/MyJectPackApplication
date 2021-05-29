package com.jectpack.adapter;

import android.util.Log;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class BindingViewHolder extends RecyclerView.ViewHolder{

    public BindingViewHolder(View view){
        super(view);

        /**
         * ViewHolder基本不会用到binding， 此处仅是提供一种获取ViewDataBinding的能力
         * */
        ViewDataBinding binding = DataBindingUtil.getBinding(view);
        
    }
}
