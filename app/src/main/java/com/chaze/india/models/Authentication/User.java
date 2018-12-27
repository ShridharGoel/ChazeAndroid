
package com.chaze.india.models.Authentication;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class User {

    @SerializedName("address")
    private String mAddress;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("facebook_id")
    private String mFacebookId;
    @SerializedName("firebase_token")
    private String mFirebaseToken;
    @SerializedName("gender")
    private String mGender;
    @SerializedName("id")
    private Long mId;
    @SerializedName("last_phone_otp")
    private Long mLastPhoneOtp;
    @SerializedName("last_verified_email")
    private String mLastVerifiedEmail;
    @SerializedName("last_verified_phone")
    private Long mLastVerifiedPhone;
    @SerializedName("merchant")
    private Long mMerchant;
    @SerializedName("name")
    private String mName;
    @SerializedName("phone")
    private Long mPhone;

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getFacebookId() {
        return mFacebookId;
    }

    public void setFacebookId(String facebookId) {
        mFacebookId = facebookId;
    }

    public String getFirebaseToken() {
        return mFirebaseToken;
    }

    public void setFirebaseToken(String firebaseToken) {
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

    public Long getLastPhoneOtp() {
        return mLastPhoneOtp;
    }

    public void setLastPhoneOtp(Long lastPhoneOtp) {
        mLastPhoneOtp = lastPhoneOtp;
    }

    public String getLastVerifiedEmail() {
        return mLastVerifiedEmail;
    }

    public void setLastVerifiedEmail(String lastVerifiedEmail) {
        mLastVerifiedEmail = lastVerifiedEmail;
    }

    public Long getLastVerifiedPhone() {
        return mLastVerifiedPhone;
    }

    public void setLastVerifiedPhone(Long lastVerifiedPhone) {
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
