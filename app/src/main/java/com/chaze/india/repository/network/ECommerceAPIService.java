package com.chaze.india.repository.network;


import com.chaze.india.models.Ecommerce.CartResponse;
import com.chaze.india.models.Ecommerce.CartUpdateResponse;
import com.chaze.india.models.Ecommerce.CategoriesResponse;
import com.chaze.india.models.Ecommerce.CategoriesShopResponse;
import com.chaze.india.models.Ecommerce.PostsResponse;
import com.chaze.india.models.Ecommerce.ProductListResponse;
import com.chaze.india.models.Ecommerce.Shop;
import com.chaze.india.models.Ecommerce.ShopListResponse;
import com.chaze.india.models.Ecommerce.SubCategoriesResponse;
import com.chaze.india.models.SuggestionsResponse;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Head;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
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


    @GET("products/posts/")
    Single<PostsResponse> getPostsForShop(@Query("shop") Long id);

    @GET("categories/children/")
    Single<CategoriesResponse> getCategories();

    @GET("products/posts/")
    Single<PostsResponse> getPostsForShopAndCategory(@Query("shop") Long shop, @Query("category") Long category);

    @GET("products/posts/")
    Single<PostsResponse> getPostsForCategory(@Query("category") Long category);

    @GET("categories/subcategories/")
    Single<SubCategoriesResponse> getSubCategories(@Query("shop") Long shop, @Query("category") Long category);

    @GET("shops/{shop}")
    Single<ShopListResponse> getShop(@Path("shop") Long id);

    @GET("products/shopAndCategory")
    Single<ProductListResponse> getProductsByShopAndCategory(@Query("category") Long categoryId, @Query("shop") Long shopId);

    @GET("products/suggestions")
    Single<SuggestionsResponse> getSuggestions(@Query("query") String query);

    @GET("shops/category/{category}")
    Single<CategoriesShopResponse> getShopForCategory(@Path("category") Long category);

    @GET("cart")
    Single<CartResponse> getCart(@Header("token") String token);


    @FormUrlEncoded
    @POST("cart/addToCart")
    Single<CartUpdateResponse> addItemToCart(@Header("token") String token, @Field("product_id") Long productId, @Field("quantity") Long quantity, @Field("description") String description);

    @FormUrlEncoded
    @POST("cart/removeFromCart")
    Single<CartUpdateResponse> remoteItemFromCart(@Header("token") String token, @Field("product_id") Long productId);
}
