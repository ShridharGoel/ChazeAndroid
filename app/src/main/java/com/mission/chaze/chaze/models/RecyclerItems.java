package com.mission.chaze.chaze.models;

import java.util.ArrayList;

public class RecyclerItems {
    String typeOfPost;
    String categoryOfPost;
    ArrayList <PostItems> recyclerList;

    public RecyclerItems(String typeOfPost, String categoryOfPost, ArrayList<PostItems> recyclerList) {
        this.typeOfPost = typeOfPost;
        this.categoryOfPost = categoryOfPost;
        this.recyclerList = recyclerList;
    }

    public String getTypeOfPost() {
        return typeOfPost;
    }

    public void setTypeOfPost(String typeOfPost) {
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
