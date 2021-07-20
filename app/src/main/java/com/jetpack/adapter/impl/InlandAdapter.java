package com.jetpack.adapter.impl;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.jetpack.adapter.BindingViewHolder;
import com.jetpack.adapter.iinterface.IRecycleAdapter;
import com.jetpack.bean.NewsItem;
import com.jetpack.bean.NewsItem2;
import com.jetpack.impl.News2OnClickListener;
import com.jetpack.impl.NewsOnClickListener;
import com.robert.jetpack.BR;
import com.robert.jetpack.R;
import com.robert.jetpack.databinding.LayoutRvItemInlandBinding;

public class InlandAdapter implements IRecycleAdapter<BindingViewHolder, LayoutRvItemInlandBinding, Object> {

    public News2OnClickListener listener = new News2OnClickListener();

    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutRvItemInlandBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), getLayoutId(), parent, false);;
        return new BindingViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder holder, LayoutRvItemInlandBinding binding, int position, Object data) {

        binding.setVariable(BR.news2, data);
        binding.setVariable(BR.listener, listener);

    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_rv_item_inland;
    }

    @Override
    public boolean isProcess(Object data) {
        return data instanceof NewsItem2;
    }
}
