package com.example.showgata12.uvideoplayer.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.showgata12.uvideoplayer.R;

public class VideoAdapter extends RecyclerView.Adapter<ControlRow> {

    private Cursor c =null;
    private LayoutInflater inflater=null;

    public VideoAdapter(Context context)
    {
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ControlRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return (new ControlRow(inflater.inflate(R.layout.layout_video_thumbnail,parent,false)));
    }

    @Override
    public void onBindViewHolder(@NonNull ControlRow holder, int position) {
        c.moveToPosition(position);
        holder.bindModel(c);
    }

    @Override
    public int getItemCount() {
        if(c == null){return 0;}

        return c.getCount();
    }

    public void setVideos(Cursor c)
    {
        this.c =c;
        notifyDataSetChanged();
    }
}
