
package com.chaze.india.models.Ecommerce;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class OrderResponse {

    @SerializedName("results")
    private String mResults;
    @SerializedName("success")
    private Boolean mSuccess;

    public String getResults() {
        return mResults;
    }

    public void setResults(String results) {
        mResults = results;
    }

    public Boolean getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Boolean success) {
        mSuccess = success;
    }

}
