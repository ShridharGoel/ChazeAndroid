
package com.chaze.india.models.Authentication;

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class LoginResponse {

    @SerializedName("result")
    private User mUser;
    @SerializedName("success")
    private Boolean mSuccess;
    @SerializedName("token")
    private String mToken;

    public User getmUser() {
        return mUser;
    }

    public void setmUser(User user) {
        mUser = user;
    }

    public Boolean getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Boolean success) {
        mSuccess = success;
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }

}
