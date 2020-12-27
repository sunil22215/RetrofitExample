package com.example.retrofitexample;

import com.example.retrofitexample.modelResponse.DeleteResponse;
import com.example.retrofitexample.modelResponse.FetchUserResponse;
import com.example.retrofitexample.modelResponse.LoginResponse;
import com.example.retrofitexample.modelResponse.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("register.php")
    Call<RegisterResponse> register(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password
    );
 @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("fetchuser.php")
    Call<FetchUserResponse> fetchUsers();

    @FormUrlEncoded
    @POST("update.php")
    Call<LoginResponse> updateUserAccount(
            @Field("id") int userid,
            @Field("username") String username,
            @Field("email") String email
    );

    @FormUrlEncoded
    @POST("delete.php")
    Call<DeleteResponse> deleteUserAccount(
            @Field("id") int userid

    );
}
