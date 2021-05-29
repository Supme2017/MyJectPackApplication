package com.jectpack.adapter;


import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterListChangedCallback<D>  extends ObservableList.OnListChangedCallback<ObservableArrayList<D>> {
    private RecyclerView.Adapter adapter;
    public AdapterListChangedCallback(RecyclerView.Adapter adapter) {
        super();
        this.adapter = adapter;
    }

    @Override
    public void onChanged(ObservableArrayList<D> sender) {
        adapter.notifyDataSetChanged();
    }

    //注意：此方法是在set(index, object)方法后才会调用
    //若在index位置上set了新对象，此自己自然会调用；
    //若只是更新了index上的对象内容，没有调用set方法，不会调用此方法，需要手动调用adapter.notifyItemChanged方法
    @Override
    public void onItemRangeChanged(ObservableArrayList<D> sender, int positionStart, int itemCount) {
        adapter.notifyItemRangeChanged(positionStart, itemCount);
    }

    @Override
    public void onItemRangeInserted(ObservableArrayList<D> sender, int positionStart, int itemCount) {
        adapter.notifyItemRangeInserted(positionStart, itemCount);
    }

    @Override
    public void onItemRangeMoved(ObservableArrayList<D> sender, int fromPosition, int toPosition, int itemCount) {
        if (itemCount == 1) {
            adapter.notifyItemMoved(fromPosition, toPosition);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemRangeRemoved(ObservableArrayList<D> sender, int positionStart, int itemCount) {
        adapter.notifyItemRangeRemoved(positionStart, itemCount);
    }

    public void release(){
        adapter = null;
    }
}
