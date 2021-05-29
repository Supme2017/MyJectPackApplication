package com.jectpack.paging.adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;

import com.jectpack.adapter.AdapterDataChangedObserver;
import com.jectpack.adapter.BasePagingRecyclerViewAdapter;
import com.jectpack.adapter.BindingViewHolder;
import com.jectpack.paging.bean.UserResponse;
import com.robert.jectpack.BR;
import com.robert.jectpack.R;

public class Paging3Adapter extends BasePagingRecyclerViewAdapter<UserResponse.Data.User, BindingViewHolder> {

    public static final int ITEM_HORIZONTAL = 0;
    public static final int ITEM_VERTICAL = 1;

    public Paging3Adapter(){
        super(getItemCallback());

    }



    @Override
    protected BindingViewHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {

        View view = null;
        switch (viewType){
            case ITEM_HORIZONTAL:
                view = createBindingByLayoutId(parent, R.layout.layout_rv_item_paging_horizontal).getRoot();
                break;
            case ITEM_VERTICAL:
                view = createBindingByLayoutId(parent, R.layout.layout_rv_item_paging_vertical).getRoot();
                break;
        }

        return new BindingViewHolder(view);
    }

    @Override
    protected void onBindHolder(BindingViewHolder holder, ViewDataBinding binding, UserResponse.Data.User item, int position) {
        binding.setVariable(BR.user, item);
    }

    @Override
    protected int getViewType(UserResponse.Data.User data) {
        return data.getId()%2 ;
    }


    private static DiffUtil.ItemCallback<UserResponse.Data.User> getItemCallback(){
        return new DiffUtil.ItemCallback<UserResponse.Data.User>() {
            @Override
            public boolean areItemsTheSame(@NonNull UserResponse.Data.User oldItem, @NonNull UserResponse.Data.User newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @SuppressLint("DiffUtilEquals")
            @Override
            public boolean areContentsTheSame(@NonNull UserResponse.Data.User oldItem, @NonNull UserResponse.Data.User newItem) {
                return oldItem.getId() == newItem.getId();
            }
        };
    }

    public void change(int position){
        UserResponse.Data.User user = getItem(position);
        user.setId(user.getId() + 900000);
        user.setTitle("xxx ---" + user.getTitle());

        notifyItemChanged(position);



    }
}
