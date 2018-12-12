package com.chaze.india.screens.Authentication.ForgotPassword;

import android.os.Bundle;

import com.chaze.india.R;
import com.chaze.india.screens.base.BaseActivity;


/**
 post request on /login
 param: req: OTP code( 6digit) + token


 return: {
 success:true/false
 error:msg to show if success is false
 token:secret key
 user:
 }

 **/

public class ForgotPasswordActivity extends BaseActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
}

