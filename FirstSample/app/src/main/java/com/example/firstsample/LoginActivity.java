package com.example.firstsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import com.example.firstsample.databinding.ActivityMainBinding;
import com.example.firstsample.di.ActivityComponent;
import com.example.firstsample.di.ActivityModule;
import com.example.firstsample.di.App;
import com.example.firstsample.di.DaggerActivityComponent;
import com.example.firstsample.viewmodel.LoginViewModel;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {

    @Inject
    LoginViewModel loginViewModel;

    private ActivityComponent activityComponent;

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .appComponent(App.get(this).getAppComponent())
                    .build();
        }
        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Log.e("onCreate: ", loginViewModel.toString());
        activityMainBinding.setLoginViewModel(loginViewModel);
    }
}