package com.mission.chaze.chaze.repository.network;


import com.mission.chaze.chaze.models.EcomerceCategory;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Define E-commerce API endpoints.
 * Retrofit
 * All REST methods such as GET, POST, PUT, UPDATE, DELETE can be stated in here.
 */

public interface ECommerceAPIService {

    @GET("shops/")
    Single<List<EcomerceCategory>> getShopsList();

}
