
package com.chaze.india.models.Ecommerce;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ShopForCategory {

    @SerializedName("name")
    private String mName;
    @SerializedName("seller_id")
    private Long mSellerId;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getSellerId() {
        return mSellerId;
    }

    public void setSellerId(Long sellerId) {
        mSellerId = sellerId;
    }

}
