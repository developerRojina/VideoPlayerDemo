package com.demoapp.videoplayer.feature.videos.view.list.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.demoapp.videoplayer.databinding.ItemVideoBinding;
import com.demoapp.videoplayer.feature.videos.model.Video;
import com.demoapp.videoplayer.feature.videos.view.list.VideoListener;
import com.demoapp.videoplayer.utils.Utils;

import org.jetbrains.annotations.NotNull;

public class VideosAdapter extends PagingDataAdapter<Video, VideosAdapter.VideosViewHolder> {

    public static final int LOADING_ITEM = 0;
    // Define Movie ViewType
    public static final int VIDEO_ITEM = 1;
    VideoListener videoListener;


    public VideosAdapter(@NotNull DiffUtil.ItemCallback<Video> diffCallback, VideoListener videoListener) {
        super(diffCallback);
        this.videoListener = videoListener;
    }


    @NonNull
    @Override
    public VideosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new VideosViewHolder(ItemVideoBinding.inflate(inflater, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull VideosViewHolder holder, int position) {
        Video currentVideo = getItem(position);
        holder.bindView(currentVideo);

    }

    public class VideosViewHolder extends RecyclerView.ViewHolder {

        ItemVideoBinding binding;

        public VideosViewHolder(@NonNull ItemVideoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(Video video) {


            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    videoListener.onVideoClicked(video);
                }
            });
            Glide.with(binding.videoThumbnail)
                    .load(Utils.formatUrl(video.getVideoUrl()))
                    .into(binding.videoThumbnail);

            binding.tvVideoName.setText(video.getTitle());
            binding.tvVideoTime.setText(video.getVideoTime());

            //  binding.videoThumbnail.
        }
    }
}
