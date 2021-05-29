package com.jectpack.utils;

import android.widget.ImageView;
import android.widget.TextView;


import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class ImageLoaderUtils {

    @BindingAdapter("imageFromUrl")
    public static void loadImage(ImageView imageView, String imageUrl){
        Glide.with(imageView.getContext())
                .load(imageUrl.trim())
                .into(imageView);

    }

}
