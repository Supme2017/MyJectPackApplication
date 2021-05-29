package com.jectpack.paging.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.paging.LoadState;
import androidx.paging.LoadStateAdapter;

import com.jectpack.adapter.BindingViewHolder;
import com.jectpack.paging.bean.FooterBean;
import com.robert.jectpack.BR;
import com.robert.jectpack.R;

import org.jetbrains.annotations.NotNull;

public class FooterAdapter extends LoadStateAdapter<BindingViewHolder> {

    @Override
    public void onBindViewHolder(@NotNull BindingViewHolder bindingViewHolder, @NotNull LoadState loadState) {
        ViewDataBinding binding = DataBindingUtil.getBinding(bindingViewHolder.itemView);
        binding.setVariable(BR.footer, converter(loadState));
        binding.executePendingBindings();
    }

    @NotNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, @NotNull LoadState loadState) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.layout_rv_paging_footer, viewGroup, false);;
        return new BindingViewHolder(binding.getRoot());

    }

    private FooterBean converter(@NotNull LoadState loadState){
        FooterBean footer = new FooterBean();
        String msg = null;
        if (loadState instanceof LoadState.NotLoading){

            msg = ((LoadState.NotLoading)loadState).getEndOfPaginationReached() == true ? "没有更多了 ！！！" : "还有更多 ！！！";
        } else if (loadState instanceof LoadState.Loading){
            msg = ((LoadState.Loading)loadState).getEndOfPaginationReached() == true ? "正在加载中。。。" : "没有更多了";
        } else if (loadState instanceof LoadState.Error){
            msg = ((LoadState.Error)loadState).getError().getMessage();
        }

        footer.setMessage(msg);

        return footer;
    }
}
