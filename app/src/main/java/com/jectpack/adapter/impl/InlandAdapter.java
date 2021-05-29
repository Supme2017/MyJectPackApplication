package com.jectpack.adapter.impl;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.jectpack.adapter.BindingViewHolder;
import com.jectpack.adapter.iinterface.IRecycleAdapter;
import com.jectpack.bean.NewsItem;
import com.jectpack.impl.NewsOnClickListener;
import com.robert.jectpack.BR;
import com.robert.jectpack.R;
import com.robert.jectpack.databinding.LayoutRvItemInlandBinding;

public class InlandAdapter implements IRecycleAdapter<BindingViewHolder, LayoutRvItemInlandBinding, NewsItem> {

    public NewsOnClickListener listener = new NewsOnClickListener();

    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutRvItemInlandBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), getLayoutId(), parent, false);;
        return new BindingViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder holder, LayoutRvItemInlandBinding binding, int position, NewsItem data) {

        binding.setVariable(BR.news, data);
        binding.setVariable(BR.listener, listener);

    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_rv_item_inland;
    }

    @Override
    public boolean isProcess(NewsItem data) {
        return data.getType()%2 == 0;
    }
}
