package com.chaze.india.models;

import java.util.ArrayList;

public class RecyclerItems {
    int typeOfPost;
    String categoryOfPost;
    ArrayList <PostItems> recyclerList;

    public RecyclerItems(int typeOfPost, String categoryOfPost, ArrayList<PostItems> recyclerList) {
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

    public ArrayList<PostItems> getRecyclerList() {
        return recyclerList;
    }

    public void setRecyclerList(ArrayList<PostItems> recyclerList) {
        this.recyclerList = recyclerList;
    }
}
