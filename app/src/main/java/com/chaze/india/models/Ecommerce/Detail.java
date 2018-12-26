
package com.chaze.india.models.Ecommerce;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Detail {

    @SerializedName("type")
    private String mType;
    @SerializedName("value")
    private String mValue;

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        mValue = value;
    }

}
