package com.example.showgata12.uvideoplayer.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.showgata12.uvideoplayer.Generators.RandomSelector;
import com.example.showgata12.uvideoplayer.R;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import de.hdodenhof.circleimageview.CircleImageView;

public class VideoListAdapter extends RecyclerView.Adapter<ControlRowII> {

    private Cursor c =null;
    private LayoutInflater inflater=null;
    private Uri currentVideo;
    private Set<Integer> selItems;

    private static final String TAG = "VideoListAdapter";


    public VideoListAdapter()
    {


    }


    @NonNull
    @Override
    public ControlRowII onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.snippet_layout_single_video_thumbnail,null);

        return new ControlRowII(v,c.getCount());
    }

    @Override
    public void onBindViewHolder(@NonNull ControlRowII holder, int position) {


        c.moveToPosition(position);
        holder.bindModel(c);


    }

    @Override
    public int getItemCount() {
        if(c == null){return 0;}

        return 10;
    }

    public void setVideos(Cursor c)
    {
        this.c =c;
        notifyDataSetChanged();


    }



//
//
//

}
