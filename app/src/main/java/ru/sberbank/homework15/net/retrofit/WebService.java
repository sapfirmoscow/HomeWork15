package ru.sberbank.homework15.net.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.sberbank.homework15.model.Picture;

public interface WebService {


    @GET("photos/random")
    Call<List<Picture>> getPhotos(@Query("count") int countOfPhotos, @Query("client_id") String clientKey);
}
