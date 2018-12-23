
package com.chaze.india.models.Ecommerce;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ProductListResponse {

    @SerializedName("results")
    private List<Product> mResults;
    @SerializedName("success")
    private Boolean mSuccess;

    public List<Product> getProducts() {
        return mResults;
    }

    public void setProducts(List<Product> results) {
        mResults = results;
    }

    public Boolean getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Boolean success) {
        mSuccess = success;
    }

}
