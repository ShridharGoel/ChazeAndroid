package com.chaze.india.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shridhar Goel on 13/12/18.
 */
public class ChangePassResponse {


    boolean isPassChanged;

    @SerializedName("phone")
    String mobile;

    @SerializedName("password")
    String newPass;

    int otp;

    public ChangePassResponse(boolean isPassChanged, String mobile, int otp, String newPass) {
        this.isPassChanged = isPassChanged;
        this.mobile = mobile;
        this.otp = otp;
        this.newPass = newPass;
    }

    public boolean isPassChanged() {
        return isPassChanged;
    }

    public String getMobile() {
        return mobile;
    }

    public int getOtp() {
        return otp;
    }

    public String getNewPass() {
        return newPass;
    }
}
