package com.chaze.india.repository.network;


import com.chaze.india.models.EcomerceCategory;
import com.chaze.india.models.Shop;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Define E-commerce API endpoints.
 * Retrofit
 * All REST methods such as GET, POST, PUT, UPDATE, DELETE can be stated in here.
 */

public interface ECommerceAPIService {

    @GET("shops/")
    Single<List<Shop>> getShopsList();


}
