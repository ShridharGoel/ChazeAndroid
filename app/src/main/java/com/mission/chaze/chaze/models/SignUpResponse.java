package com.mission.chaze.chaze.models;

/**
 * Created by Shridhar Goel on 13/10/18.
 */

public class SignUpResponse {

    Boolean isSignUpError;
    String userName, mobile, pass;

    public SignUpResponse(Boolean isSignUpError, String userName, String mobile, String pass) {
        this.isSignUpError = isSignUpError;
        this.userName = userName;
        this.mobile = mobile;
        this.pass = pass;
    }

    public Boolean getSignUpError() {
        return isSignUpError;
    }

    public String getUserName() {
        return userName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPass() {
        return pass;
    }

}
