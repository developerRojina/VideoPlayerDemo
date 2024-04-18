package com.demoapp.videoplayer.feature.videos.view.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.demoapp.videoplayer.databinding.ActivityVideoDetailBinding;
import com.demoapp.videoplayer.feature.player.VideoPlayerActivity;
import com.demoapp.videoplayer.feature.videos.model.Video;
import com.demoapp.videoplayer.utils.Utils;
import com.google.gson.Gson;

import java.util.ArrayList;

public class VideoDetailActivity extends AppCompatActivity {

    ActivityVideoDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        String videoInfo = getIntent().getStringExtra(Utils.ARG_VIDEO_INFO);
        Video video = new Gson().fromJson(videoInfo, Video.class);


        setSupportActionBar(binding.toolbarDetail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        binding.toolbarDetail.setTitle("");

        binding.tvVideoTitle.setText(video.getTitle());
        binding.chipActionType.setText(video.getCategory());
        binding.chipMovieLength.setText(video.getVideoTime());
        binding.chipActorName.setText(video.getStarName());

        ArrayList<String> items = new ArrayList<>(video.getImageThumbnails());

        VideoThumbnailAdapter adapter = new VideoThumbnailAdapter(items);
        binding.viewPagerThumbnail.setAdapter(adapter);
        binding.viewPagerThumbnail.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);


        binding.btnPlayVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoDetailActivity.this, VideoPlayerActivity.class);
                intent.putExtra(Utils.ARG_VIDEO_URL, video.getVideoUrl());
                startActivity(intent);
            }
        });

    }
}