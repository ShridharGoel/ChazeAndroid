package com.chaze.india.models;

import com.chaze.india.models.Ecommerce.Post;
import com.chaze.india.models.Ecommerce.Post;

import java.util.ArrayList;

public class RecyclerItems {
    int typeOfPost;
    String categoryOfPost;
    ArrayList <Post> recyclerList;

    public RecyclerItems(int typeOfPost, String categoryOfPost, ArrayList<Post> recyclerList) {
        this.typeOfPost = typeOfPost;
        this.categoryOfPost = categoryOfPost;
        this.recyclerList = recyclerList;
    }

    public int getTypeOfPost() {
        return typeOfPost;
    }

    public void setTypeOfPost(int typeOfPost) {
        this.typeOfPost = typeOfPost;
    }

    public String getCategoryOfPost() {
        return categoryOfPost;
    }

    public void setCategoryOfPost(String categoryOfPost) {
        this.categoryOfPost = categoryOfPost;
    }

    public ArrayList<Post> getRecyclerList() {
        return recyclerList;
    }

    public void setRecyclerList(ArrayList<Post> recyclerList) {
        this.recyclerList = recyclerList;
    }
}
