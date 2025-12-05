package com.bulkbuy.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class ProductMedia {

    @Column(name = "logo")
    private String logo;

    @ElementCollection
    @CollectionTable(
            name = "product_images",
            joinColumns = @JoinColumn(name = "product_id")
    )
    @Column(name = "image")
    private List<String> images = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "product_videos",
            joinColumns = @JoinColumn(name = "product_id")
    )
    @Column(name = "video")
    private List<String> videos = new ArrayList<>();

    @Column(name = "gif")
    private String gif;

    public ProductMedia() {
    }

    public ProductMedia(String logo, List<String> images, List<String> videos, String gif) {
        this.logo = logo;
        this.images = images != null ? images : new ArrayList<>();
        this.videos = videos != null ? videos : new ArrayList<>();
        this.gif = gif;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getVideos() {
        return videos;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }

    public String getGif() {
        return gif;
    }

    public void setGif(String gif) {
        this.gif = gif;
    }
}
