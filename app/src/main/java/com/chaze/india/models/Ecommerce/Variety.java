
package com.chaze.india.models.Ecommerce;

import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Variety {

    @SerializedName("key")
    private String mKey;
    @SerializedName("values")
    private List<String> mValues;

    public String getKey() {
        return mKey;
    }

    public void setKey(String key) {
        mKey = key;
    }

    public List<String> getValues() {
        return mValues;
    }

    public void setValues(List<String> values) {
        mValues = values;
    }

}
