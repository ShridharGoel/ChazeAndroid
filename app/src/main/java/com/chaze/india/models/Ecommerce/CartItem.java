
package com.chaze.india.models.Ecommerce;

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CartItem {

    @SerializedName("business_name")
    private String mBusinessName;
    @SerializedName("category")
    private Long mCategory;
    @SerializedName("description")
    private Object mDescription;
    @SerializedName("discount")
    private Double mDiscount;
    @SerializedName("id")
    private Long mId;
    @SerializedName("image")
    private String mImage;
    @SerializedName("name")
    private String mName;
    @SerializedName("price")
    private Double mPrice;
    @SerializedName("quantity")
    private Long mQuantity;
    @SerializedName("rating")
    private Double mRating;
    @SerializedName("seller_id")
    private Long mSellerId;
    @SerializedName("stock")
    private Long mStock;

    public String getBusinessName() {
        return mBusinessName;
    }

    public void setBusinessName(String businessName) {
        mBusinessName = businessName;
    }

    public Long getCategory() {
        return mCategory;
    }

    public void setCategory(Long category) {
        mCategory = category;
    }

    public Object getDescription() {
        return mDescription;
    }

    public void setDescription(Object description) {
        mDescription = description;
    }

    public Double getDiscount() {
        return mDiscount;
    }

    public void setDiscount(Double discount) {
        mDiscount = discount;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(Double price) {
        mPrice = price;
    }

    public Long getQuantity() {
        return mQuantity;
    }

    public void setQuantity(Long quantity) {
        mQuantity = quantity;
    }

    public Double getRating() {
        return mRating;
    }

    public void setRating(Double rating) {
        mRating = rating;
    }

    public Long getSellerId() {
        return mSellerId;
    }

    public void setSellerId(Long sellerId) {
        mSellerId = sellerId;
    }

    public Long getStock() {
        return mStock;
    }

    public void setStock(Long stock) {
        mStock = stock;
    }

}
