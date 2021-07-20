package com.jetpack.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.databinding.DataBindingUtil;

import com.jetpack.utils.NewsGeneratorUtils;
import com.robert.jetpack.R;
import com.robert.jetpack.databinding.LayoutRvItemInlandBinding;

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

        binding.setNews2(NewsGeneratorUtils.getNewsItem2());
    }

}
