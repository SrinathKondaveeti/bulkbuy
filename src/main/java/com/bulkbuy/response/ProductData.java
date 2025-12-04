package com.bulkbuy.response;

import jakarta.persistence.Column;

import java.time.Duration;
import java.util.List;

public class ProductData {

    private String name;
    private String description;
    private MediaData media;
    private int ordersRequired;
    private int ordersPlaced;
    private Duration timeLeftToOrder;
    private double actualPrice;
    private double offerPrice;

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

    public MediaData getMedia() {
        return media;
    }

    public void setMedia(MediaData media) {
        this.media = media;
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

    public Duration getTimeLeftToOrder() {
        return timeLeftToOrder;
    }

    public void setTimeLeftToOrder(Duration timeLeftToOrder) {
        this.timeLeftToOrder = timeLeftToOrder;
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
}
