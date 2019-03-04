package ru.sberbank.homework15.mvp;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class ImagePresenter {
    private MyImageView mView;
    private String mUrl;

    ImagePresenter(String url) {
        mUrl = url;
    }

    public void onResume() {
        Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                mView.setPicture(bitmap);
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
            }
        };

        Picasso.get().load(mUrl).into(target);
    }

    public void setActivity(MyImageView view) {
        mView = view;
    }
}

