
package com.chaze.india.models.Ecommerce;

import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CartResponse {

    @SerializedName("error")
    private String mError;
    @SerializedName("results")
    private List<CartShop> cartShops;
    @SerializedName("success")
    private Boolean mSuccess;

    public String getmError() {
        return mError;
    }

    public void setmError(String mError) {
        this.mError = mError;
    }

    public List<CartShop> getCartShops() {
        return cartShops;
    }

    public void setCartShops(List<CartShop> mResults) {
        this.cartShops = mResults;
    }

    public Boolean getmSuccess() {
        return mSuccess;
    }

    public void setmSuccess(Boolean mSuccess) {
        this.mSuccess = mSuccess;
    }

}
