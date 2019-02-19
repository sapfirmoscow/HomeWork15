package ru.sberbank.homework15.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.sberbank.homework15.R;
import ru.sberbank.homework15.entity.Photo;

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {


    private List<Photo> mData;

    public ImageAdapter() {
        mData = new ArrayList<>();
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_item, viewGroup, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        imageViewHolder.setImage(mData.get(i).getUri());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addItem(Photo photo) {
        mData.add(photo);
        notifyDataSetChanged();
    }
}
