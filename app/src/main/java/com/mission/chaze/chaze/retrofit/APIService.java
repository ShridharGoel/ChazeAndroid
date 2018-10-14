package com.mission.chaze.chaze.retrofit;

import com.mission.chaze.chaze.models.EcomerceCategory;
import com.mission.chaze.chaze.models.EcomerceShop;
import com.mission.chaze.chaze.models.EcomerceShopCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET(".")
    Call<List<EcomerceCategory>> getShopsList();
}
