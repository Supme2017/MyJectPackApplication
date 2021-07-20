package com.jetpack.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseBindingRecyclerViewAdapter<D, VH extends BindingViewHolder> extends RecyclerView.Adapter<VH> {

    private ObservableArrayList<D> dataList = new ObservableArrayList<>();
    private AdapterListChangedCallback adapterListChangedCallback;

//    private AtomicInteger count = new AtomicInteger(0);

    public BaseBindingRecyclerViewAdapter(){
        adapterListChangedCallback = new AdapterListChangedCallback(this);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        dataList.addOnListChangedCallback(adapterListChangedCallback);

    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        dataList.removeOnListChangedCallback(adapterListChangedCallback);
        adapterListChangedCallback.release();

    }

    @Override
    public int getItemViewType(int position) {
        return getViewType(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return onCreateHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        ViewDataBinding binding = DataBindingUtil.getBinding(holder.itemView);

        onBindHolder(holder, binding, getDataList().get(position), position);
        binding.executePendingBindings();
    }


    public void setDataList(List<D> data){
        if (data != null && !data.isEmpty()){
            dataList.addAll(data);
        }
    }

    public ObservableArrayList<D> getDataList(){
        return dataList;
    }

    public void deletedDataList(){
        dataList.clear();
    }

    protected ViewDataBinding createBindingByLayoutId(@NonNull ViewGroup parent, int layoutId){
        return DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutId, parent, false);
    }

    protected abstract VH onCreateHolder(@NonNull ViewGroup parent, int viewType);

    protected abstract void onBindHolder(VH holder, ViewDataBinding binding, D item, int position);


    protected abstract int getViewType(D data);



}

