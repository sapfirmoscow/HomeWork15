package ru.sberbank.homework15.mvp;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class ImagePresenter {
    private MyImageView mView;
    private String mUrl;

    ImagePresenter(String url) {
        mUrl = url;
    }

    @SuppressLint("StaticFieldLeak")
    public void onResume() {
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void... voids) {
                Bitmap bitmap = null;
                try {
                    bitmap = Picasso.get().load(mUrl).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return bitmap;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                mView.setPicture(bitmap);
            }
        }.execute();
    }

    public void setActivity(MyImageView view) {
        mView = view;
    }
}

