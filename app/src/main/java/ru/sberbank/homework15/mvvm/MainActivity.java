package ru.sberbank.homework15.mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import java.util.List;

import ru.sberbank.homework15.R;
import ru.sberbank.homework15.databinding.ActivityMainBinding;
import ru.sberbank.homework15.model.Picture;
import ru.sberbank.homework15.recycler.ImageAdapter;
import ru.sberbank.homework15.recycler.SpacesItemDecoration;

public class MainActivity extends AppCompatActivity {

    private ImageAdapter mAdapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mainBinding.recyclerView.addItemDecoration(new SpacesItemDecoration(25));
        mAdapater = new ImageAdapter(MainActivity.this);

        final MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        myViewModel.getPictures().observe(this, new Observer<List<Picture>>() {
            @Override
            public void onChanged(@Nullable List<Picture> pictures) {
                mAdapater.addItems(pictures);
                mainBinding.refreshLayout.setRefreshing(false);
            }
        });

        mainBinding.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                myViewModel.refreshPictures();
            }
        });


    }
}
