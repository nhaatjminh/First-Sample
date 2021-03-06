package com.example.firstsample.di;

import android.app.Application;
import android.content.Context;

import com.example.firstsample.Api;
import com.example.firstsample.ApplicationContext;
import com.example.firstsample.model.User;
import com.example.firstsample.model.api.ApiService;
import com.example.firstsample.model.api.RequestManager;
import com.example.firstsample.viewmodel.LoginViewModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    App application;

    public AppModule(App app) {
        this.application = app;
    }

    @Provides
    @ApplicationContext
    public Context provideApplicationContext() {
        return  application;
    }

    @Provides
    public App provideApplication() {
        return application;
    }

    @Provides
    @Api
    public ApiService provideApiService() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-mm-dd HH:mm:ss")
                .create();

        Retrofit apiService = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return apiService.create(ApiService.class);
    }

}
