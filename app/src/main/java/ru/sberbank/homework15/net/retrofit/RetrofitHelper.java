package ru.sberbank.homework15.net.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    public static final String BASE_URL = "https://api.unsplash.com/";

    public WebService getService() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                //   .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(WebService.class);
    }
}
