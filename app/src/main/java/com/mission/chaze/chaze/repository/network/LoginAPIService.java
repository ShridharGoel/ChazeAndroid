package com.mission.chaze.chaze.repository.network;

import com.mission.chaze.chaze.models.LoginResponse;
import com.mission.chaze.chaze.models.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Define E-commerce API endpoints.
 * Retrofit
 * All REST methods such as GET, POST, PUT, UPDATE, DELETE can be stated in here.
 */

public interface LoginAPIService {

    @FormUrlEncoded
    @POST("/accounts")     //createuser
    Call<SignUpResponse> createUser(
            @Field("name") String name,
            @Field("mobile") String mobile,
            @Field("password") String pass);

    @FormUrlEncoded
    @POST("/accounts")     //userlogin
    Call<LoginResponse> loginUser(
            @Field("mobile") String mobile,
            @Field("password") String pass);


}
