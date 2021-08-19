package com.example.firstsample.di;

import com.example.firstsample.LoginActivity;
import com.example.firstsample.PerActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(LoginActivity loginActivity);
}
