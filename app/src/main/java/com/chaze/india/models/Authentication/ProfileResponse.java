package com.chaze.india.models.Authentication;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shridhar Goel on 26/12/18.
 */
public class ProfileResponse {

    @SerializedName("success")
    private boolean mSuccess;

    @SerializedName("results")
    private User user;

    public boolean ismSuccess() {
        return mSuccess;
    }

    public void setmSuccess(boolean mSuccess) {
        this.mSuccess = mSuccess;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
