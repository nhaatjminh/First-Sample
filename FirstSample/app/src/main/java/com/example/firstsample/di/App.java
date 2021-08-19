package com.example.firstsample.di;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.firstsample.viewmodel.LoginViewModel;

import javax.inject.Inject;

import dagger.android.DaggerApplication;

public class App extends Application {
    AppComponent appComponent;

    @Inject
    LoginViewModel loginViewModel;

    public static App get(Context context) {
        return (App)context.getApplicationContext();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
