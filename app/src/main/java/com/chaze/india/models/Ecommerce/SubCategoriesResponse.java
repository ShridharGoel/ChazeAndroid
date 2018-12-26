
package com.chaze.india.models.Ecommerce;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SubCategoriesResponse {

    @SerializedName("results")
    private List<SubCategory> mSubCategories;
    @SerializedName("success")
    private Boolean mSuccess;

    public List<SubCategory> getResults() {
        return mSubCategories;
    }

    public void setResults(List<SubCategory> subCategories) {
        mSubCategories = subCategories;
    }

    public Boolean getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Boolean success) {
        mSuccess = success;
    }

}
