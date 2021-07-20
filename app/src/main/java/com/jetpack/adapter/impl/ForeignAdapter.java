package com.jetpack.adapter.impl;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.jetpack.adapter.BindingViewHolder;
import com.jetpack.adapter.iinterface.IRecycleAdapter;
import com.jetpack.bean.NewsItem;
import com.jetpack.impl.NewsOnClickListener;
import com.robert.jetpack.BR;
import com.robert.jetpack.R;
import com.robert.jetpack.databinding.LayoutRvItemForeignBinding;
import com.robert.jetpack.databinding.LayoutRvItemInlandBinding;

public class ForeignAdapter implements IRecycleAdapter/*<BindingViewHolder, LayoutRvItemInlandBinding, Object>*/ {

    public NewsOnClickListener listener = new NewsOnClickListener();

    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutRvItemForeignBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), getLayoutId(), parent, false);;
        return new BindingViewHolder(binding.getRoot());
    }

//    @Override
//    public void onBindViewHolder(@NonNull BindingViewHolder holder, LayoutRvItemForeignBinding binding, int position, Object data) {
//
//        binding.setVariable(BR.news, data);
//        binding.setListener(listener);
//
////        binding.setVariable(BR.news, data);
////        binding.setVariable(BR.listener, listener);
//
//    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, ViewDataBinding binding, int position, Object data) {

        binding.setVariable(BR.news, data);
        binding.setVariable(BR.listener, listener);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_rv_item_foreign;
    }

    @Override
    public boolean isProcess(Object data) {
        return data instanceof NewsItem;
    }
}
