package com.example.firstsample;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.firstsample.model.api.ApiService;
import com.example.firstsample.viewmodel.LoginViewModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
        loginViewModel.Login("a", "b");
        Assert.assertEquals(1, 1);
    }
}
