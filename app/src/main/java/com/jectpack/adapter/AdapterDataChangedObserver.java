package com.jectpack.adapter;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterDataChangedObserver extends RecyclerView.AdapterDataObserver {

    private RecyclerView.Adapter adapter;

    public AdapterDataChangedObserver(RecyclerView.Adapter adapter){
        this.adapter = adapter;
    }


    @Override
    public void onChanged() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemRangeChanged(int positionStart, int itemCount) {
        adapter.notifyItemRangeChanged(positionStart, itemCount);
    }

    @Override
    public void onItemRangeChanged(int positionStart, int itemCount, @Nullable Object payload) {
       adapter.notifyItemRangeChanged(positionStart, itemCount, payload);
    }

    @Override
    public void onItemRangeInserted(int positionStart, int itemCount) {
        adapter.notifyItemRangeInserted(positionStart, itemCount);
    }

    @Override
    public void onItemRangeRemoved(int positionStart, int itemCount) {
        adapter.notifyItemRangeRemoved(positionStart, itemCount);
    }

    @Override
    public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
        if (itemCount == 1){
            adapter.notifyItemMoved(fromPosition, toPosition);
        } else {
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onStateRestorationPolicyChanged() {
        super.onStateRestorationPolicyChanged();
    }

    public void release(){
        adapter = null;
    }
}
