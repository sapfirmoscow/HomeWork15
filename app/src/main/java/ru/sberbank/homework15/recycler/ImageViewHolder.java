package ru.sberbank.homework15.recycler;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import ru.sberbank.homework15.R;

public class ImageViewHolder extends RecyclerView.ViewHolder {

    ImageView mImageView;

    public ImageViewHolder(@NonNull View itemView) {
        super(itemView);
        mImageView = itemView.findViewById(R.id.imageView);
    }

    public void setImage(Uri uri) {
        Picasso.get().load(uri).into(mImageView);
    }

}
