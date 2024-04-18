package com.demoapp.videoplayer.feature.videos.util;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.demoapp.videoplayer.feature.videos.model.Video;

public class VideoComparator extends DiffUtil.ItemCallback<Video> {
    @Override
    public boolean areItemsTheSame(@NonNull Video oldItem, @NonNull Video newItem) {
        return oldItem.getId().equals(newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Video oldItem, @NonNull Video newItem) {
        return oldItem.getId().equals(newItem.getId());
    }
}
