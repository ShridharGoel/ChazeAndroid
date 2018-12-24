
package com.chaze.india.models.Ecommerce;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CategoriesShopResponse {

    @SerializedName("results")
    private List<ShopForCategory> mShopForCategories;
    @SerializedName("success")
    private Boolean mSuccess;

    public List<ShopForCategory> getmShopForCategories() {
        return mShopForCategories;
    }

    public void setmShopForCategories(List<ShopForCategory> shopForCategories) {
        mShopForCategories = shopForCategories;
    }

    public Boolean getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Boolean success) {
        mSuccess = success;
    }

}
