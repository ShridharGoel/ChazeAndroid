
package com.chaze.india.models.Ecommerce;

import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CartResponse {

    @SerializedName("results")
    private List<CartShop> mCartShops;
    @SerializedName("success")
    private Boolean mSuccess;

    public List<CartShop> getmCartShops() {
        return mCartShops;
    }

    public void setmCartShops(List<CartShop> cartShops) {
        mCartShops = cartShops;
    }

    public Boolean getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Boolean success) {
        mSuccess = success;
    }

}
