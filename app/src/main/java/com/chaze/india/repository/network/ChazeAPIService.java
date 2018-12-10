package com.chaze.india.repository.network;


import com.chaze.india.models.SignUpResponse;
import com.chaze.india.models.LoginResponse;
import com.chaze.india.models.SignUpResponse;

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

}
