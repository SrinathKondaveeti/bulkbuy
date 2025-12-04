package com.bulkbuy.response;

import java.util.List;

public class MediaData {

    private String logo;

    private List<String> images;

    private List<String> videos;

    private String gif;

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
