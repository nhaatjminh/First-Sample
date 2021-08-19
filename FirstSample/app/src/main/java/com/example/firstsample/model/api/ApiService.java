package com.example.firstsample.model.api;

import com.example.firstsample.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-mm-dd HH:mm:ss")
            .create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);


    @FormUrlEncoded
    @POST("bd65fa35-85c4-4a03-b999-b2c6c0068814")
    Call<User> getUser(@Field("userName") String userName, @Field("password") String password);
}