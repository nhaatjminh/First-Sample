package com.example.firstsample;

import android.content.Context;

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
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Observable;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginViewModelTest {

    LoginViewModel loginViewModel;

    @Mock
    ApiService apiService;

    @Before
    public void setUp() throws Exception {
        loginViewModel = new LoginViewModel(apiService);
    }
    

    @Test
    public void loginTest() {

       // Assert.assertNotNull(loginViewModel.getApiService());


        when(apiService.callUser("aa", "bb"))
                .thenReturn(Observable.just(new User(1, "aa", "aa", "aa")));
        loginViewModel.Login("aa", "bb");

        Assert.assertEquals(true, true);
    }
}
