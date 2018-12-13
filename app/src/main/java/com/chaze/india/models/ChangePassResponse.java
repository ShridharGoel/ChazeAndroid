package com.chaze.india.models;

/**
 * Created by Shridhar Goel on 13/12/18.
 */
public class ChangePassResponse {

    String mobile, newPass;

    public ChangePassResponse(String mobile, String newPass) {
        this.mobile = mobile;
        this.newPass = newPass;
    }

    public String getMobile() {
        return mobile;
    }

    public String getNewPass() {
        return newPass;
    }
}
