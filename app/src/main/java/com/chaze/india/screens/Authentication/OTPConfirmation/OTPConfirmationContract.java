package com.chaze.india.screens.Authentication.OTPConfirmation;

import com.chaze.india.screens.base.MvpContract;

public class OTPConfirmationContract {

    public interface View extends MvpContract.View {
        void startHomeActivity();
        void startChangePassActivity();
    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {
        void doOTPConfirmation(String mobile, int otp);
        void doResendOTP(String mobile);
    }
}
