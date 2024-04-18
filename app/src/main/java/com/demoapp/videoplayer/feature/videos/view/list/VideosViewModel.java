package com.demoapp.videoplayer.feature.videos.view.list;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.rxjava3.PagingRx;

import com.demoapp.videoplayer.feature.videos.model.Video;
import com.demoapp.videoplayer.feature.videos.source.VideoPagingSource;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.core.Flowable;
import kotlinx.coroutines.CoroutineScope;

@HiltViewModel
public class VideosViewModel extends ViewModel {
    public Flowable<PagingData<Video>> moviePagingDataFlowable;

    private final VideoPagingSource pagingSource;
    @Inject
    VideosViewModel(VideoPagingSource pagingSource) {
        this.pagingSource = pagingSource;
        init();
    }

    private void init() {
        // Define Paging Source

        // Create new Pager
        Pager<Integer, Video> pager = new Pager(
                // Create new paging config
                new PagingConfig(20,
                        20,
                        false,
                        20,
                        20 * 499),
                () -> pagingSource); // set paging source

        // inti Flowable
        moviePagingDataFlowable = PagingRx.getFlowable(pager);
        CoroutineScope coroutineScope = ViewModelKt.getViewModelScope(this);
        PagingRx.cachedIn(moviePagingDataFlowable, coroutineScope);

    }
}
