package com.jectpack.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.databinding.DataBindingUtil;

import com.jectpack.utils.NewsGeneratorUtils;
import com.robert.jectpack.DataBinderMapperImpl;
import com.robert.jectpack.R;
import com.robert.jectpack.databinding.LayoutRvItemForeignBinding;
import com.robert.jectpack.databinding.LayoutRvItemInlandBinding;
import com.robert.jectpack.databinding.LayoutRvItemInlandBindingImpl;
import com.robert.jectpack.databinding.LayoutRvItemPagingHorizontalBinding;

public class ItemInlandView extends LinearLayout {


    private LayoutRvItemInlandBinding binding;

    public ItemInlandView(Context context) {
        this(context, null);
    }

    public ItemInlandView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ItemInlandView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init(){

        View view = inflate(getContext(), R.layout.layout_rv_item_inland,this);
        view.setTag("layout/layout_rv_item_inland_0");
        binding = DataBindingUtil.bind(view);

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        binding.setNews(NewsGeneratorUtils.getNewsItem());
    }

}
