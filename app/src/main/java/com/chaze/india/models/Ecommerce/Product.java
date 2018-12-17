
package com.chaze.india.models.Ecommerce;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Product {

    @SerializedName("business_name")
    private String mBusinessName;
    @SerializedName("close_time")
    private String mCloseTime;
    @SerializedName("discount")
    private Double mDiscount;
    @SerializedName("id")
    private Long mId;
    @SerializedName("image_first")
    private String mImageFirst;
    @SerializedName("image_second")
    private String mImageSecond;
    @SerializedName("image_third")
    private String mImageThird;
    @SerializedName("name")
    private String mName;
    @SerializedName("open_time")
    private String mOpenTime;
    @SerializedName("price")
    private Double mPrice;
    @SerializedName("rating")
    private Double mRating;
    @SerializedName("rating_count")
    private Long mRatingCount;
    @SerializedName("seller_id")
    private Long mSellerId;
    @SerializedName("stock")
    private Long mStock;
    @SerializedName("week_breakdown")
    private Long mWeekBreakdown;

    public String getBusinessName() {
        return mBusinessName;
    }

    public void setBusinessName(String businessName) {
        mBusinessName = businessName;
    }

    public String getCloseTime() {
        return mCloseTime;
    }

    public void setCloseTime(String closeTime) {
        mCloseTime = closeTime;
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

    public String getImageFirst() {
        return mImageFirst;
    }

    public void setImageFirst(String imageFirst) {
        mImageFirst = imageFirst;
    }

    public String getImageSecond() {
        return mImageSecond;
    }

    public void setImageSecond(String imageSecond) {
        mImageSecond = imageSecond;
    }

    public String getImageThird() {
        return mImageThird;
    }

    public void setImageThird(String imageThird) {
        mImageThird = imageThird;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getOpenTime() {
        return mOpenTime;
    }

    public void setOpenTime(String openTime) {
        mOpenTime = openTime;
    }

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(Double price) {
        mPrice = price;
    }

    public Double getRating() {
        return mRating;
    }

    public void setRating(Double rating) {
        mRating = rating;
    }

    public Long getRatingCount() {
        return mRatingCount;
    }

    public void setRatingCount(Long ratingCount) {
        mRatingCount = ratingCount;
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

    public Long getWeekBreakdown() {
        return mWeekBreakdown;
    }

    public void setWeekBreakdown(Long weekBreakdown) {
        mWeekBreakdown = weekBreakdown;
    }

}
