package com.chaze.india.models.Ecommerce;

public class PostItems {
    String imageUrl;
    String text;
    int id;

    public PostItems(String imageUrl, String text, int id) {
        this.imageUrl = imageUrl;
        this.text = text;
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
