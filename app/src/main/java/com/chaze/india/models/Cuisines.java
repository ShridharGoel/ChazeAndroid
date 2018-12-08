package com.chaze.india.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cuisines {
    /*String category;
    String image;

    public EcomerceCategory(String category, String image) {
        this.category = category;
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ecomerceCategory{" +
                "category='" + category + '\'' +
                ", image='" + image + '\'' +
                '}';
    }*/
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("url")
    @Expose
    private String url;

    public Cuisines(String name, String id, String url) {
        this.name = name;
        this.id = id;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "EcomerceShop{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
