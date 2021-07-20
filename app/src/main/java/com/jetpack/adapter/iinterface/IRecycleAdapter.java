package com.jetpack.adapter.iinterface;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public interface IRecycleAdapter<VH extends RecyclerView.ViewHolder, B extends ViewDataBinding,  D> {

    VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    void onBindViewHolder(@NonNull VH holder,B binding, int position, D data);

    int getLayoutId();

    boolean isProcess(D data);
}
