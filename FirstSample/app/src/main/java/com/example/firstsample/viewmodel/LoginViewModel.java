package com.example.firstsample.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.example.firstsample.ApplicationContext;

import com.example.firstsample.BR;
import com.example.firstsample.model.api.ApiService;
import com.example.firstsample.model.User;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class LoginViewModel extends BaseObservable {
    private Context context;
    private String userName;
    private String password;
    public ObservableField<String> msgLogin = new ObservableField<>();

    @Inject
    public LoginViewModel(@ApplicationContext Context c) {
        this.context = c;
        userName = "";
        password = "";
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.userName);
    }

    public void Login() {

        ApiService.apiService.getUser(getUserName(), getPassword()).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                User user = response.body();
                msgLogin.set(user.toString());

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                msgLogin.set("Login Fail");
            }
        });

    }
}
