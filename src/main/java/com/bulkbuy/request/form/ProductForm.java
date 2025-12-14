package com.bulkbuy.request.form;

import com.bulkbuy.response.ProductMediaData;

import java.time.Duration;
import java.time.LocalDateTime;

public class ProductForm {

    private Long productId;
    private String name;
    private String description;
    private ProductMediaData productMediaData;
    private int ordersRequired;
    private int ordersPlaced;
    private LocalDateTime orderCutOffDate;
    private double actualPrice;
    private double offerPrice;
    private LocalDateTime productLiveTime;
    private int interestedPeopleCount;

    public int getInterestedPeopleCount() {
        return interestedPeopleCount;
    }

    public void setInterestedPeopleCount(int interestedPeopleCount) {
        this.interestedPeopleCount = interestedPeopleCount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductMediaData getProductMediaData() {
        return productMediaData;
    }

    public void setProductMediaData(ProductMediaData productMediaData) {
        this.productMediaData = productMediaData;
    }

    public int getOrdersRequired() {
        return ordersRequired;
    }

    public void setOrdersRequired(int ordersRequired) {
        this.ordersRequired = ordersRequired;
    }

    public int getOrdersPlaced() {
        return ordersPlaced;
    }

    public void setOrdersPlaced(int ordersPlaced) {
        this.ordersPlaced = ordersPlaced;
    }

    public LocalDateTime getOrderCutOffDate() {
        return orderCutOffDate;
    }

    public void setOrderCutOffDate(LocalDateTime orderCutOffDate) {
        this.orderCutOffDate = orderCutOffDate;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }

    public LocalDateTime getProductLiveTime() {
        return productLiveTime;
    }

    public void setProductLiveTime(LocalDateTime productLiveTime) {
        this.productLiveTime = productLiveTime;
    }
}
