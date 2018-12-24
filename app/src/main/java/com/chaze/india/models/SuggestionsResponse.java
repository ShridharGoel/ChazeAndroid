
package com.chaze.india.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SuggestionsResponse {

    @SerializedName("data")
    private List<Suggestion> mData;
    @SerializedName("success")
    private Boolean mSuccess;

    public List<Suggestion> getData() {
        return mData;
    }

    public void setData(List<Suggestion> data) {
        mData = data;
    }

    public Boolean getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Boolean success) {
        mSuccess = success;
    }

}
