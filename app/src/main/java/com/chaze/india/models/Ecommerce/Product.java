
package com.chaze.india.models.Ecommerce;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Product {

    @SerializedName("business_name")
    private String businessName;
    @SerializedName("close_time")
    private String closeTime;
    @Expose
    private Double discount;
    @Expose
    private Long id;
    @SerializedName("image_first")
    private String imageFirst;
    @SerializedName("image_second")
    private String imageSecond;
    @SerializedName("image_third")
    private String imageThird;
    @Expose
    private String name;
    @SerializedName("open_time")
    private String openTime;
    @Expose
    private Double price;
    @Expose
    private Double rating;
    @SerializedName("rating_count")
    private Long ratingCount;
    @SerializedName("seller_id")
    private Long sellerId;
    @Expose
    private Long stock;
    @SerializedName("week_breakdown")
    private Long weekBreakdown;

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageFirst() {
        return imageFirst;
    }

    public void setImageFirst(String imageFirst) {
        this.imageFirst = imageFirst;
    }

    public String getImageSecond() {
        return imageSecond;
    }

    public void setImageSecond(String imageSecond) {
        this.imageSecond = imageSecond;
    }

    public String getImageThird() {
        return imageThird;
    }

    public void setImageThird(String imageThird) {
        this.imageThird = imageThird;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Long getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Long ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getWeekBreakdown() {
        return weekBreakdown;
    }

    public void setWeekBreakdown(Long weekBreakdown) {
        this.weekBreakdown = weekBreakdown;
    }

}
