
package com.chaze.india.models.Ecommerce;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CartShop {

    @SerializedName("deliveryCharge")
    private Long mDeliveryCharge;
    @SerializedName("key")
    private Long mKey;
    @SerializedName("name")
    private String mName;
    @SerializedName("products")
    private List<CartItem> mProducts;

    public Long getDeliveryCharge() {
        return mDeliveryCharge;
    }

    public void setDeliveryCharge(Long deliveryCharge) {
        mDeliveryCharge = deliveryCharge;
    }

    public Long getKey() {
        return mKey;
    }

    public void setKey(Long key) {
        mKey = key;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<CartItem> getProducts() {
        return mProducts;
    }

    public void setProducts(List<CartItem> products) {
        mProducts = products;
    }

}
