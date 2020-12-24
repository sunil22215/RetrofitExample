package com.example.retrofitexample;

import com.example.retrofitexample.modelResponse.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface Api {
    @POST("register.php")
    Call<RegisterResponse> register(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password
    );
}
