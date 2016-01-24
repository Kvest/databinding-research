package com.kvest.databindingresearch.utils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by kvest on 24.01.16.
 */
public class DataBindingUtils {
    @BindingAdapter(value={"imageUrl", "error"}, requireAll = true)
    public static void loadImage(ImageView imageView, String imageUrl, Drawable error) {
        Picasso.with(imageView.getContext()).load(imageUrl).error(error).into(imageView);
    }
}
