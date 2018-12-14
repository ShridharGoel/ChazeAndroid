package com.chaze.india.screens.Authentication.ForgotPassword;

import com.chaze.india.screens.base.MvpContract;

public class ForgotPasswordContract {

    public interface View extends MvpContract.View {
        void startHomeActivity();
    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {
        void doChangePass(String mobile, int otp, String newPass);
    }
}
