package com.sunil.androidarchitecturesample.databinding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.sunil.androidarchitecturesample.R;
import com.sunil.androidarchitecturesample.util.Constant;

/**
 * Created by sunil on 16-09-2017.
 */

public final class ImageBindingAdapter {

    @BindingAdapter(value = "url")
    public static void loadImageUrl(ImageView view, String url) {
        if (url != null && !url.equals(""))
            Picasso.with(view.getContext())
                    .load(Constant.IMAGE_ENDPOINT_PREFIX + url)
                    .placeholder(R.drawable.placeholder)
                    .into(view);
    }

}