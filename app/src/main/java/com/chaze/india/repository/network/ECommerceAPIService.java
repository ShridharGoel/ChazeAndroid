package com.chaze.india.repository.network;


import com.chaze.india.models.Ecommerce.PostsResponse;
import com.chaze.india.models.Ecommerce.Shop;
import com.chaze.india.models.Ecommerce.ShopListResponse;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Define E-commerce API endpoints.
 * Retrofit
 * All REST methods such as GET, POST, PUT, UPDATE, DELETE can be stated in here.
 */

public interface ECommerceAPIService {

    @GET("shops/")
    Single<ShopListResponse> getShopsList(@Query("offset") int offset);


    @GET("products/posts/")
    Flowable<PostsResponse> getPosts(@Query("limit") int limit);

}
