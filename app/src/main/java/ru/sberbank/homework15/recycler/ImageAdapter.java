package ru.sberbank.homework15.recycler;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.sberbank.homework15.R;
import ru.sberbank.homework15.databinding.ImageItemBinding;
import ru.sberbank.homework15.model.Picture;
import ru.sberbank.homework15.mvp.ImageActivity;

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> implements PictureEventListener {
    private List<Picture> mData;
    private Context mContext;

    public ImageAdapter(Context context) {
        mData = new ArrayList<>();
        mContext = context;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ImageItemBinding imageItemBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.image_item, viewGroup, false);
        return new ImageViewHolder(imageItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        imageViewHolder.setImage(mData.get(i).getUrls().getThumb());
        imageViewHolder.getBinding().setPicture(mData.get(i));
        imageViewHolder.getBinding().setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addItem(Picture picture) {
        mData.add(picture);
        notifyDataSetChanged();
    }

    public void addItems(List<Picture> pictures) {
        mData.clear();
        mData.addAll(pictures);
        notifyDataSetChanged();
    }

    @Override
    public void openPicture(Picture picture) {
        mContext.startActivity(ImageActivity.newIntent(mContext, picture.getUrls().getRegular()));
    }
}
