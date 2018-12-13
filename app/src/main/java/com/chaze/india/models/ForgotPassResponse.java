package com.chaze.india.models;

/**
 * Created by Shridhar Goel on 13/12/18.
 */
public class ForgotPassResponse {

    boolean isPassForgotten;
    String mobile;

    public ForgotPassResponse(boolean isPassForgotten, String mobile) {
        this.isPassForgotten = isPassForgotten;
        this.mobile = mobile;
    }

    public boolean isPassForgotten() {
        return isPassForgotten;
    }

    public String getMobile() {
        return mobile;
    }
}
