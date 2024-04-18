package com.demoapp.videoplayer.feature.videos.view.detail;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.demoapp.videoplayer.R;
import com.demoapp.videoplayer.databinding.ItemVideoThumbnailBinding;
import com.demoapp.videoplayer.utils.Utils;

import java.util.List;

import okhttp3.internal.Util;

public class VideoThumbnailAdapter extends RecyclerView.Adapter<VideoThumbnailAdapter.VideoThumbnailViewHolder> {

    private final List<String> thumbnails;

    public VideoThumbnailAdapter(List<String> thumbnails) {
        this.thumbnails = thumbnails;
    }

    @NonNull
    @Override
    public VideoThumbnailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new VideoThumbnailViewHolder(ItemVideoThumbnailBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoThumbnailViewHolder holder, int position) {

        holder.bind(thumbnails.get(position));
    }

    @Override
    public int getItemCount() {
        return thumbnails.size();
    }

    static class VideoThumbnailViewHolder extends RecyclerView.ViewHolder {

        ItemVideoThumbnailBinding binding;

        public VideoThumbnailViewHolder(@NonNull ItemVideoThumbnailBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String thumbnail) {
            Glide.with(binding.videoThumbnail)
                    .load(Utils.formatUrl(thumbnail))
                    .error(R.drawable.ic_launcher_background)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(binding.videoThumbnail);
        }
    }
}
