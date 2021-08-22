package com.example.firstsample;

import android.content.Context;

import androidx.databinding.ObservableField;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.firstsample.model.User;
import com.example.firstsample.model.api.ApiService;
import com.example.firstsample.viewmodel.LoginViewModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Observable;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginViewModelTest {
    User user;
    Throwable error;

    @Mock
    ApiService apiService;

    @Spy
    LoginViewModel loginViewModel = new LoginViewModel(apiService);

    @Before
    public void setUp() throws Exception {
        error = new Throwable();
        user = new User(1, "aa", "aa", "aa");
    }
    

    @Test
    public void loginTest() {

        when(apiService.callUser(any(), any()))
                .thenReturn(Observable.just(user));

        loginViewModel.setApiService(apiService);

        loginViewModel.Login("aa", "bb");

        verify(loginViewModel).notifySuccess();

//        verify(loginViewModel).handleResponse(any(User.class));

        //Assert.assertEquals(1, 1);
    }
}
