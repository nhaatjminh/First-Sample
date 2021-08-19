package com.example.firstsample.di;

import android.app.Application;
import android.content.Context;

import com.example.firstsample.ApplicationContext;
import com.example.firstsample.model.User;
import com.example.firstsample.model.api.ApiService;
import com.example.firstsample.viewmodel.LoginViewModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
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

}
