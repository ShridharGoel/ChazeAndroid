package com.chaze.india.repository.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface DeliveryAPIService {

    @FormUrlEncoded
    @POST("/insert/")
    Call<Void> send_fcm_token(@Field("fcm_token") String fcm_token);
}
