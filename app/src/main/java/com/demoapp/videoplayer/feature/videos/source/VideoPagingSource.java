package com.demoapp.videoplayer.feature.videos.source;

import androidx.annotation.Nullable;
import androidx.paging.PagingState;
import androidx.paging.rxjava3.RxPagingSource;

import com.demoapp.videoplayer.api.VideoApiService;
import com.demoapp.videoplayer.feature.videos.model.Video;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class VideoPagingSource extends RxPagingSource<Integer, Video> {

    VideoApiService apiService;

    @Inject
    VideoPagingSource(VideoApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Single<LoadResult<Integer, Video>> loadSingle(@NotNull LoadParams<Integer> loadParams) {
        try {
            int page = loadParams.getKey() != null ? loadParams.getKey() : 1;
            return apiService.getVideos(page, loadParams.getLoadSize())
                    .subscribeOn(Schedulers.io())
                    .map(videos -> toLoadResult(videos, page, loadParams.getLoadSize()))
                    .onErrorReturn(LoadResult.Error::new);
        } catch (Exception e) {
            return Single.just(new LoadResult.Error(e));
        }
    }

    private LoadResult<Integer, Video> toLoadResult(List<Video> movies, int page, int size) {
        return new LoadResult.Page(movies, page == 1 ? null : page - 1, (movies.size() < size || movies.isEmpty()) ? null : page + 1);
    }

    @Nullable
    @Override
    public Integer getRefreshKey(@NotNull PagingState<Integer, Video> pagingState) {
        return null;
    }
}
