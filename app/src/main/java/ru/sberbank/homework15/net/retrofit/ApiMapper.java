package ru.sberbank.homework15.net.retrofit;


import java.io.IOException;
import java.util.List;

import retrofit2.Callback;
import ru.sberbank.homework15.model.Picture;

public class ApiMapper {
    private RetrofitHelper mHelper;
    private static final String KEY = "55b011812162d0ec5e2e8628d3892bffffb66d6699f99c0d0e235315a166f5a3";

    public ApiMapper(RetrofitHelper helper) {
        mHelper = helper;
    }

    public List<Picture> getPhotosSync(int countOfPhotos) throws IOException {
        return mHelper.getService().getPhotos(countOfPhotos, KEY).execute().body();
    }

    public void getPhotosAsync(int coountOfPhotos, Callback<List<Picture>> callback) {
        mHelper.getService().getPhotos(coountOfPhotos, KEY).enqueue(callback);
    }

}
