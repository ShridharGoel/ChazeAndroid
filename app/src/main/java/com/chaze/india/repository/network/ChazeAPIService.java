package com.chaze.india.repository.network;


import com.chaze.india.models.Authentication.ConfirmOTPResponse;
import com.chaze.india.models.Ecommerce.ResendOTPResponse;
import com.chaze.india.models.Authentication.SignUpResponse;
import com.chaze.india.models.Authentication.LoginResponse;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Define E-commerce API endpoints.
 * Retrofit
 * All REST methods such as GET, POST, PUT, UPDATE, DELETE can be stated in here.
 */

public interface ChazeAPIService {

    @FormUrlEncoded
    @POST("/signup")     //createuser
    Single<SignUpResponse> createUser(
            @Field("name") String name,
            @Field("phone") String mobile,
            @Field("gender") int gender,
            @Field("password") String pass);

    @FormUrlEncoded
    @POST("/login")     //userlogin
    Single<LoginResponse> loginUser(
            @Field("phone") String mobile,
            @Field("password") String pass);

    @FormUrlEncoded
    @POST("/otp")   //confirmOtp
    Single<ConfirmOTPResponse> confirmOtp(
            @Field("phone") String mobile,
            @Field("otp") int otp);

    @FormUrlEncoded
    @POST("/resendotp")   //resendOTP
    Single<ResendOTPResponse> resendOTP(
            @Field("phone") String mobile);

}
