package com.example.showgata12.uvideoplayer.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.showgata12.uvideoplayer.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.MyViewHolder> {



    public VideoListAdapter()
    {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_video_thumbnail,null);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        private CircleImageView videoOwner;
        private TextView videoTitle;
        private TextView videoDate;
        private TextView videoUserName;
        private VideoView videoView;

        public MyViewHolder(View v) {
            super(v);

            videoOwner = v.findViewById(R.id.videoOwner);
            videoTitle=v.findViewById(R.id.videoTitle);
            videoDate=v.findViewById(R.id.videoDate);
            videoView =v.findViewById(R.id.videoView);
            videoUserName=v.findViewById(R.id.videoUsername);
        }
    }
}
