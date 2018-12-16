
package com.chaze.india.models.Ecommerce;

import java.util.List;
import javax.annotation.Generated;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Post {

    @Expose
    private List<Item> items;
    @Expose
    private int type;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {

        String json = new GsonBuilder().create().toJson(items);

        return json;
    }
}
