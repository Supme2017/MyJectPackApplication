package com.jetpack.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;

public abstract class BasePagingRecyclerViewAdapter<D, VH extends BindingViewHolder> extends PagingDataAdapter<D, VH> {

    private AdapterDataChangedObserver adapterDataChangedObserver;

    public BasePagingRecyclerViewAdapter(@NonNull DiffUtil.ItemCallback<D> diffCallback){
        super(diffCallback);
        adapterDataChangedObserver = new AdapterDataChangedObserver(this);
    }

    @Override
    public int getItemViewType(int position) {
        return getViewType(getItem(position));
    }


    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return onCreateHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        ViewDataBinding binding = DataBindingUtil.getBinding(holder.itemView);
        onBindHolder(holder, binding, getItem(position), position);
        binding.executePendingBindings();

    }


    protected ViewDataBinding createBindingByLayoutId(@NonNull ViewGroup parent, int layoutId){
        return DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutId, parent, false);
    }

    protected abstract VH onCreateHolder(@NonNull ViewGroup parent, int viewType);

    protected abstract void onBindHolder(VH holder, ViewDataBinding binding, D item, int position);


    protected abstract int getViewType(D data);

}

