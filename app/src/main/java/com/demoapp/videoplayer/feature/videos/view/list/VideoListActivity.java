package com.demoapp.videoplayer.feature.videos.view.list;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.demoapp.videoplayer.databinding.ActivityVideoListBinding;
import com.demoapp.videoplayer.feature.videos.model.Video;
import com.demoapp.videoplayer.feature.videos.util.VideoComparator;
import com.demoapp.videoplayer.feature.videos.view.detail.VideoDetailActivity;
import com.demoapp.videoplayer.feature.videos.view.list.adapter.VideoLoadStateAdapter;
import com.demoapp.videoplayer.feature.videos.view.list.adapter.VideosAdapter;
import com.demoapp.videoplayer.utils.Utils;
import com.google.gson.Gson;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class VideoListActivity extends AppCompatActivity {


    VideosViewModel viewModel;
    ActivityVideoListBinding binding;
    VideosAdapter videosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityVideoListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(VideosViewModel.class);

        videosAdapter = new VideosAdapter(new VideoComparator(), new VideoListener() {
            @Override
            public void onVideoClicked(Video video) {
                Intent intent = new Intent(VideoListActivity.this, VideoDetailActivity.class);
                intent.putExtra(Utils.ARG_VIDEO_INFO, new Gson().toJson(video));
                startActivity(intent);
            }
        });

        binding.recyclerViewVideos.setAdapter(
                videosAdapter.withLoadStateFooter(
                        new VideoLoadStateAdapter(v -> {
                            videosAdapter.retry();
                        }))
        );


        viewModel.moviePagingDataFlowable.subscribe(moviePagingData -> {
            Log.d("TAG","inside size is:"+moviePagingData);
            videosAdapter.submitData(getLifecycle(), moviePagingData);
        });
    }
}