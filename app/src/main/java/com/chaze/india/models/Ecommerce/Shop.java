
package com.chaze.india.models.Ecommerce;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Shop {

    @Expose
    private String address;
    @Expose
    private Long category;
    @Expose
    private Long city;
    @SerializedName("close_time")
    private String closeTime;
    @SerializedName("common_id")
    private Long commonId;
    @Expose
    private Long contact;
    @SerializedName("firebase_token")
    private Object firebaseToken;
    @Expose
    private Long id;
    @SerializedName("image_url")
    private String imageUrl;
    @Expose
    private String message;
    @SerializedName("min_order")
    private Long minOrder;
    @Expose
    private String name;
    @SerializedName("open_time")
    private String openTime;
    @Expose
    private Long status;
    @Expose
    private Double tax;
    @SerializedName("tax_description")
    private String taxDescription;
    @SerializedName("week_breakdown")
    private Long weekBreakdown;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public Long getCommonId() {
        return commonId;
    }

    public void setCommonId(Long commonId) {
        this.commonId = commonId;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public Object getFirebaseToken() {
        return firebaseToken;
    }

    public void setFirebaseToken(Object firebaseToken) {
        this.firebaseToken = firebaseToken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getMinOrder() {
        return minOrder;
    }

    public void setMinOrder(Long minOrder) {
        this.minOrder = minOrder;
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

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public String getTaxDescription() {
        return taxDescription;
    }

    public void setTaxDescription(String taxDescription) {
        this.taxDescription = taxDescription;
    }

    public Long getWeekBreakdown() {
        return weekBreakdown;
    }

    public void setWeekBreakdown(Long weekBreakdown) {
        this.weekBreakdown = weekBreakdown;
    }

    public String getCode() {
        return String.valueOf(id);
    }

}
