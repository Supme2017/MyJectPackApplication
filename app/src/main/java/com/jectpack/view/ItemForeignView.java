package com.jectpack.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.databinding.DataBindingUtil;

import com.jectpack.utils.NewsGeneratorUtils;
import com.robert.jectpack.R;
import com.robert.jectpack.databinding.LayoutRvItemForeignBinding;

public class ItemForeignView extends LinearLayout {

    private LayoutRvItemForeignBinding binding;

    public ItemForeignView(Context context) {
        this(context, null);
    }

    public ItemForeignView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ItemForeignView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init(){

        View view = inflate(getContext(), R.layout.layout_rv_item_foreign,this);
        view.setTag("layout/layout_rv_item_foreign_0");
        binding = DataBindingUtil.bind(view);

    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        binding.setNews(NewsGeneratorUtils.getNewsItem());
    }

}
