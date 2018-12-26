
package com.chaze.india.models.Ecommerce;

import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Post {

    @Expose
    private Long key;

    @Expose
    private String name;
    @Expose
    private List<Product> products;

    public Long getKey() {
        return key;
    }

    public String getName(){return name;}

    public void setKey(Long key) {
        this.key = key;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
