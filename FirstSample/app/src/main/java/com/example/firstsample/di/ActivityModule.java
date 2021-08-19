package com.example.firstsample.di;

import android.app.Activity;
import android.content.Context;

import com.example.firstsample.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity a) {
        this.activity = a;
    }

    @Provides
    @ActivityContext
    Context provideActivityContext(){
        return activity;
    }

    @Provides
    Activity provideActivity(){
        return activity;
    }
}
