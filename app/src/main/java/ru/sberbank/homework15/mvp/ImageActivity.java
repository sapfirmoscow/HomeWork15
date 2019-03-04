package ru.sberbank.homework15.mvp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import ru.sberbank.homework15.R;

public class ImageActivity extends AppCompatActivity implements MyImageView {

    public static final String EXTRA_KEY = "URL";
    private ImageView mImageView;
    private ImagePresenter mPresenter;

    public static Intent newIntent(Context context, String url) {
        Intent intent = new Intent(context, ImageActivity.class);
        intent.putExtra(EXTRA_KEY, url);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        initViews();
        initActionBar();
        attachPresenter();
    }

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void initViews() {
        mImageView = findViewById(R.id.detial_imageView);
    }

    private void attachPresenter() {
        if (mPresenter == null) {
            mPresenter = new ImagePresenter(getIntent().getStringExtra(EXTRA_KEY));
        }
        mPresenter.setActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @Override
    public void setPicture(Bitmap bitmap) {
        mImageView.setImageBitmap(bitmap);
    }
}
