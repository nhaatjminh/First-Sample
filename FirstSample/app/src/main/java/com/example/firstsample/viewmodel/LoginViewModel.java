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

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

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

    private void handleError(Throwable error) {
        msgLogin.set("Login Fail");
    }

    private void handleSuccess() {

    }

    private void handleResponse(User user) {
        msgLogin.set(user.toString());
    }

    public void Login(String userName, String password) {
        Observable<User> userObservable = ApiService.apiService.callUser(userName, password);
        userObservable.subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError);

    }

}
