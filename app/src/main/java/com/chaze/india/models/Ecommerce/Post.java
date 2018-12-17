
package com.chaze.india.models.Ecommerce;

import java.util.List;

import javax.annotation.Generated;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Post {

    @SerializedName("products")
    private List<Product> mProducts;
    @SerializedName("seller_id")
    private Long mSellerId;

    public List<Product> getProducts() {
        return mProducts;
    }

    public void setProducts(List<Product> products) {
        mProducts = products;
    }

    public Long getSellerId() {
        return mSellerId;
    }

    public void setSellerId(Long sellerId) {
        mSellerId = sellerId;
    }

    @Override
    public String toString() {
        String json = new GsonBuilder().create().toJson(mProducts);
        return json;
    }
}
