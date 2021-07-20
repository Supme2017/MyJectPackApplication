package com.jetpack.utils;

import android.widget.ImageView;


import androidx.databinding.BindingAdapter;


import com.bumptech.glide.Glide;

public class ImageLoaderUtils {

    @BindingAdapter("imageFromUrl")
    public static void loadImage(ImageView imageView, String imageUrl){
        Glide.with(imageView.getContext())
                .load(imageUrl.trim())
                .into(imageView);

    }

}
