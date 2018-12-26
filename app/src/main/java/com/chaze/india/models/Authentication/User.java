
package com.chaze.india.models.Authentication;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class User {

    @SerializedName("address")
    private Object mAddress;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("facebook_id")
    private Object mFacebookId;
    @SerializedName("firebase_token")
    private Object mFirebaseToken;
    @SerializedName("gender")
    private String mGender;
    @SerializedName("id")
    private Long mId;
    @SerializedName("last_phone_otp")
    private String mLastPhoneOtp;
    @SerializedName("last_verified_email")
    private Object mLastVerifiedEmail;
    @SerializedName("last_verified_phone")
    private Object mLastVerifiedPhone;
    @SerializedName("merchant")
    private Long mMerchant;
    @SerializedName("name")
    private String mName;
    @SerializedName("phone")
    private Long mPhone;

    public Object getAddress() {
        return mAddress;
    }

    public void setAddress(Object address) {
        mAddress = address;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public Object getFacebookId() {
        return mFacebookId;
    }

    public void setFacebookId(Object facebookId) {
        mFacebookId = facebookId;
    }

    public Object getFirebaseToken() {
        return mFirebaseToken;
    }

    public void setFirebaseToken(Object firebaseToken) {
        mFirebaseToken = firebaseToken;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getLastPhoneOtp() {
        return mLastPhoneOtp;
    }

    public void setLastPhoneOtp(String lastPhoneOtp) {
        mLastPhoneOtp = lastPhoneOtp;
    }

    public Object getLastVerifiedEmail() {
        return mLastVerifiedEmail;
    }

    public void setLastVerifiedEmail(Object lastVerifiedEmail) {
        mLastVerifiedEmail = lastVerifiedEmail;
    }

    public Object getLastVerifiedPhone() {
        return mLastVerifiedPhone;
    }

    public void setLastVerifiedPhone(Object lastVerifiedPhone) {
        mLastVerifiedPhone = lastVerifiedPhone;
    }

    public Long getMerchant() {
        return mMerchant;
    }

    public void setMerchant(Long merchant) {
        mMerchant = merchant;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getPhone() {
        return mPhone;
    }

    public void setPhone(Long phone) {
        mPhone = phone;
    }

}
