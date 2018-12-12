package com.chaze.india.models.Authentication;

/**
 * Created by Shridhar Goel on 13/10/18.
 */

public class LoginResponse {

    Boolean isLoginError;
    String userName, userId, mobile, email, pass;

    public LoginResponse(Boolean isLoginError, String userName, String userId, String mobile, String email, String pass) {
        this.isLoginError = isLoginError;
        this.userName = userName;
        this.userId = userId;
        this.mobile = mobile;
        this.email = email;
        this.pass = pass;
    }

    public Boolean getLoginError() {
        return isLoginError;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }
}
