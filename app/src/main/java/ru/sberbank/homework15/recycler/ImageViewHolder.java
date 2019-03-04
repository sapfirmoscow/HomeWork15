package ru.sberbank.homework15.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import ru.sberbank.homework15.R;
import ru.sberbank.homework15.databinding.ImageItemBinding;

public class ImageViewHolder extends RecyclerView.ViewHolder {

    private ImageView mImageView;
    private ImageItemBinding mItem;

    public ImageViewHolder(@NonNull ImageItemBinding itemBinding) {
        super(itemBinding.getRoot());
        mItem = itemBinding;
        mImageView = mItem.getRoot().findViewById(R.id.imageView);
    }

    public void setImage(String uri) {
        Picasso.get()
                .load(uri)
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .resize(300, 300)
                .into(mImageView);
    }

    ImageItemBinding getBinding() {
        return mItem;
    }

    ImageView getImageView() {
        return mImageView;
    }

}
