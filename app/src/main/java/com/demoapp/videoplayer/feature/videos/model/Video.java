package com.demoapp.videoplayer.feature.videos.model;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

public class Video {

    @SerializedName("id")
    @Expose
    private String id;


    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("upload_time")
    @Expose
    private String uploadTime;

    @SerializedName("video_time")
    @Expose
    private String videoTime;

    @SerializedName("star_name")
    @Expose
    private String starName;

    @SerializedName("category")
    @Expose
    private String category;

    @SerializedName("video_url")
    @Expose
    private String videoUrl;

    @SerializedName("main_thumb")
    @Expose
    private String mainThumbnail;


    @SerializedName("image_thumb")
    @Expose
    private String imageThumbnails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(String videoTime) {
        this.videoTime = videoTime;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getMainThumbnail() {
        return mainThumbnail;
    }

    public void setMainThumbnail(String mainThumbnail) {
        this.mainThumbnail = mainThumbnail;
    }

    public List<String> getImageThumbnails() {
        String thumbnail = imageThumbnails;
        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>(){}.getType();
        List<String> urlsList = gson.fromJson(imageThumbnails, listType);
        return urlsList;
    }

    public void setImageThumbnails(String imageThumbnails) {
        this.imageThumbnails = imageThumbnails;
    }
}

