package com.jectpack.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.jectpack.bean.NewsItem;
import com.jectpack.impl.NewsOnClickListener;
import com.jectpack.view.ItemForeignView;
import com.jectpack.view.ItemInlandView;

import org.jetbrains.annotations.NotNull;

public class MyBindingSectionRecyclerViewAdapter extends BaseBindingRecyclerViewAdapter<NewsItem, BindingViewHolder> {

    public static final int ITEM_INLAND = 0;
    public static final int ITEM_FOREIGN = 1;
    public NewsOnClickListener listener = new NewsOnClickListener();

    public MyBindingSectionRecyclerViewAdapter(){
       super();
    }

    @Override
    protected BindingViewHolder onCreateHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType){
            case ITEM_INLAND:
                view =  new ItemInlandView(parent.getContext());
                break ;
            case ITEM_FOREIGN:
                view =  new ItemForeignView(parent.getContext());
                break;
        }
        return new BindingViewHolder(view);
    }

    @Override
    protected void onBindHolder(BindingViewHolder holder, ViewDataBinding binding, NewsItem item, int position) {
//        binding.setVariable(BR.news, item);
//        binding.setVariable(BR.listener, listener);
    }


    @Override
    protected int getViewType(NewsItem data) {
        return data.getType()%2;
    }
}

