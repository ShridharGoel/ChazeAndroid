package com.chaze.india.models;

/**
 * Created by Shridhar Goel on 13/10/18.
 */

public class SignUpResponse {

    Boolean isSignUpError;
    String userName, mobile, pass;
    int gender;

    public SignUpResponse(Boolean isSignUpError, String userName, String mobile, String pass, int gender) {
        this.isSignUpError = isSignUpError;
        this.userName = userName;
        this.mobile = mobile;
        this.pass = pass;
        this.gender = gender;
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

    public int getGender() { return gender; }

}
