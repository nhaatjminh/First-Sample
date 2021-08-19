package com.example.firstsample.di;

import android.app.Application;
import android.content.Context;

import com.example.firstsample.ApplicationContext;
import com.example.firstsample.viewmodel.LoginViewModel;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(App app);

    @ApplicationContext
    Context getApplicationContext();

    App getApplication();

    LoginViewModel getLoginViewModel();
}
