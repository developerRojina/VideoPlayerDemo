package com.demoapp.videoplayer.api;

import com.demoapp.videoplayer.feature.videos.model.Video;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VideoApiService {

    @GET("videos")
    Single<List<Video>> getVideos(@Query("page") int page, @Query("per_page") int perPage);
}
