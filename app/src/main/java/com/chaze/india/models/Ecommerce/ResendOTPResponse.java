package com.chaze.india.models.Ecommerce;

/**
 * Created by Shridhar Goel on 11/12/18.
 */
public class ResendOTPResponse {
    boolean isResendError;
    String mobile;

    public ResendOTPResponse(boolean isResendError, String mobile) {
        this.isResendError = isResendError;
        this.mobile = mobile;
    }

    public boolean isResendError() {
        return isResendError;
    }

    public String getMobile() {
        return mobile;
    }
}
