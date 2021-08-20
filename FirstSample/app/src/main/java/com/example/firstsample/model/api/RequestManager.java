package com.example.firstsample.model.api;

import com.example.firstsample.model.User;

import io.reactivex.Observable;

public class RequestManager implements ApiService {

//    private ApiService apiService;
//
//    @Inject
//    public RequestManager(@ApiInfo ApiService api) {
//        this.apiService = api;
//    }
//
    @Override
    public Observable<User> callUser(String userName, String password) {
        return apiService.callUser(userName, password);
    }
}
