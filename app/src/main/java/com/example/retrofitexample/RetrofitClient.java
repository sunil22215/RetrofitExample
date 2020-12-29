package com.example.retrofitexample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static String BASE_URL = "http://192.168.0.107/userdata/";
    private static RetrofitClient retrofitClient;
    private static Retrofit retrofit;


    private RetrofitClient() {
<<<<<<< HEAD
=======

       /* Gson gson = new GsonBuilder()
                .setLenient()
                .create();
*/
>>>>>>> 004173b205b6d4d245ce77e901d138d9c3427239
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create( ))
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }
}
