package com.jectpack.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.jectpack.adapter.iinterface.IRecycleAdapter;

import java.util.ArrayList;
import java.util.List;

public class MultiRecyclerViewAdapter<D> extends RecyclerView.Adapter {

    private ObservableArrayList<D> dataList = new ObservableArrayList<>();
    private AdapterListChangedCallback adapterListChangedCallback = new AdapterListChangedCallback(this);
    private List<IRecycleAdapter> adapterList = new ArrayList<>();

    public MultiRecyclerViewAdapter(){
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
        D data = getDataList().get(position);
        return adapterList.indexOf(findAdapter(data));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        IRecycleAdapter adapter = adapterList.get(viewType);
        return  adapter.onCreateViewHolder(parent, viewType);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewDataBinding binding = DataBindingUtil.getBinding(holder.itemView);
        IRecycleAdapter adapter = adapterList.get(holder.getItemViewType());
        adapter.onBindViewHolder(holder, binding, position, getDataList().get(position));
        binding.executePendingBindings();
    }

    public boolean addAdapter(IRecycleAdapter adapter){
        return adapterList.add(adapter);
    }

    public void setDataList(List<D> data){
        if (data != null && !data.isEmpty()){
            dataList.addAll(data);
//            notifyDataSetChanged();
        }
    }

    public ObservableArrayList<D> getDataList(){
        return dataList;
    }

    public void deletedDataList(){
        dataList.clear();
    }

    private IRecycleAdapter findAdapter(D data){
        IRecycleAdapter result = null;
        for (IRecycleAdapter adapter : adapterList){
            if (adapter.isProcess(data)){
                result = adapter;
                break;
            }
        }
        return result;
    }

}

