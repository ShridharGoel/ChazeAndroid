package com.chaze.india.repository.network;


import com.chaze.india.models.Authentication.ConfirmOTPResponse;
import com.chaze.india.models.Authentication.LoginResponse;
import com.chaze.india.models.Authentication.SignUpResponse;
import com.chaze.india.models.ChangePassResponse;
import com.chaze.india.models.Ecommerce.ResendOTPResponse;
import com.chaze.india.models.ForgotPassResponse;

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
    @POST("/signup")     //createUser
    Single<SignUpResponse> createUser(
            @Field("name") String name,
            @Field("phone") String mobile,
            @Field("gender") int gender,
            @Field("password") String pass);

    @FormUrlEncoded
    @POST("/signup")     //createUserWithEmail
    Single<SignUpResponse> createUserWithEmail(
            @Field("name") String name,
            @Field("email") String email,
            @Field("gender") int gender,
            @Field("password") String pass);

    @FormUrlEncoded
    @POST("/login")     //userLoginWithEmail
    Single<LoginResponse> loginUser(
            @Field("phone") String mobile,
            @Field("password") String pass);

    @FormUrlEncoded
    @POST("/login")     //userLoginWithEmail
    Single<LoginResponse> loginUserWithEmail(
            @Field("email") String email,
            @Field("password") String pass);

    @FormUrlEncoded
    @POST("/verifyPhone")   //confirmOtp
    Single<ConfirmOTPResponse> confirmOtp(
            @Field("phone") String mobile,
            @Field("otp") int otp);

    @FormUrlEncoded
    @POST("/verifyMail")   //confirmOtpWithMail
    Single<ConfirmOTPResponse> confirmOtpWithEmail(
            @Field("email") String email,
            @Field("otp") int otp);

    @FormUrlEncoded
    @POST("/resendPhone")   //resendOTP
    Single<ResendOTPResponse> resendOTP(
            @Field("phone") String mobile);

    @FormUrlEncoded
    @POST("/resendMail")   //resendOTPWithMail
    Single<ResendOTPResponse> resendOTPWithMail(
            @Field("email") String email);

    @FormUrlEncoded
    @POST("/requestForgotPassword")    //forgotPass
    Single<ForgotPassResponse> forgotPass(
            @Field("phone") String mobile);

    @FormUrlEncoded
    @POST("/requestForgotPassword")    //forgotPassWithEmail
    Single<ForgotPassResponse> forgotPassWithEmail(
            @Field("email") String email);

    @FormUrlEncoded
    @POST("/changeForgotPassword")    //changePass
    Single<ChangePassResponse> changePass(
            @Field("phone") String mobile,
            @Field("otp") int otp,
            @Field("password") String newPass);

    @FormUrlEncoded
    @POST("/changeForgotPassword")    //changePassWithEmail
    Single<ChangePassResponse> changePassWithEmail(
            @Field("email") String email,
            @Field("otp") int otp,
            @Field("password") String newPass);
}

