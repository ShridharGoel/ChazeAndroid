
package com.chaze.india.models.Ecommerce;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PostByShopsResponse {

    @SerializedName("results")
    private List<Post> mPosts;
    @SerializedName("success")
    private Boolean mSuccess;

    public List<Post> getPosts() {
        return mPosts;
    }

    public void setResults(List<Post> posts) {
        mPosts = posts;
    }

    public Boolean getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Boolean success) {
        mSuccess = success;
    }

}
