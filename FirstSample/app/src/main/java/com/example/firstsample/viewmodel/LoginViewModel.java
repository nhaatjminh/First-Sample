package com.example.firstsample.viewmodel;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.example.firstsample.Api;
import com.example.firstsample.BR;
import com.example.firstsample.model.api.ApiService;
import com.example.firstsample.model.User;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class LoginViewModel extends BaseObservable {
    private String userName;
    private String password;
    private ApiService apiService;
    public ObservableField<String> msgLogin = new ObservableField<>();


    @Inject
    public LoginViewModel(@Api ApiService api) {
        apiService = api;
        userName = "";
        password = "";
    }

    public ApiService getApiService() {
        return apiService;
    }
    public void setApiService(ApiService api) {
        this.apiService = api;
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

    public void handleError(Throwable error) {

        msgLogin.set("Login Fail");
    }

    public void handleSuccess() {
        Log.e("handleSuccess: ", "Success");
    }

    public void notifySuccess() {
        Log.e("STATUS", "Success");
    }

    public void notifyFail() {
        Log.e("STATUS", "Fail");
    }

    public void handleResponse(User user) {
        msgLogin.set(user.toString());
        handleSuccess();
    }

    public ObservableField<String> getMsgLogin() {
        return msgLogin;
    }

    public void Login(String userName, String password) {

        Observable<User> userObservable = apiService.callUser(userName, password);

        userObservable.subscribeOn(Schedulers.newThread())
                 .observeOn(Schedulers.io())
                 .doOnSubscribe(disposable -> notifySuccess())
                 .doAfterTerminate(()-> notifyFail())
                 .subscribe(this::handleResponse, this::handleError);

    }

}
