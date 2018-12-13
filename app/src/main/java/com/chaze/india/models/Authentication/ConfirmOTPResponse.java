package com.chaze.india.models.Authentication;

/**
 * Created by Shridhar Goel on 11/12/18.
 */
public class ConfirmOTPResponse {

    Boolean isConfirmError;
    String mobile;
    int otp;

    public ConfirmOTPResponse(Boolean isConfirmError, String mobile, int otp) {
        this.isConfirmError = isConfirmError;
        this.mobile = mobile;
        this.otp = otp;
    }

    public Boolean getConfirmError() {
        return isConfirmError;
    }

    public String getMobile() {
        return mobile;
    }

    public int getOtp() {
        return otp;
    }
}
