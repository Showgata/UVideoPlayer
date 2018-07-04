package com.example.showgata12.uvideoplayer.Adapters;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.showgata12.uvideoplayer.R;
import com.example.showgata12.uvideoplayer.ShowAllVideosActivity;
import com.example.showgata12.uvideoplayer.VideoActivity;
import com.squareup.picasso.Picasso;

public class ControlRow extends RecyclerView.ViewHolder
            implements View.OnClickListener{
    
    private TextView videoTitle=null;
    private TextView videoDate=null;
    private TextView videoName=null;
    private ImageView videoView=null;

    private String videoTitleString;

    private Uri videoUri=null;
    private String videoMimeType=null;
    private Context activity;
    
    
    public ControlRow(View v) {
        super(v);

        this.activity = v.getContext();
        videoTitle = v.findViewById(R.id.videoTitle);
        videoDate=v.findViewById(R.id.videoDate);
        videoName=v.findViewById(R.id.videoUsername);
        videoView=v.findViewById(R.id.videoView);

        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(activity, VideoActivity.class);
        i.setDataAndType(videoUri,videoMimeType);
        i.putExtra("videoTitle",videoTitleString);
        videoTitle.getContext().startActivity(i);
    }

    public void bindModel(Cursor row)
    {
        videoTitleString = row.getString(row.getColumnIndex(
                MediaStore.Video.Media.TITLE));
        videoTitle.setText(videoTitleString);

        videoDate.setText(row.getString(row.getColumnIndex(
                MediaStore.Video.Media.DATE_ADDED)));

        videoName.setText(row.getString(row.getColumnIndex(
                MediaStore.Video.Media.ARTIST)));


        videoUri = ContentUris.withAppendedId(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                row.getInt(row.getColumnIndex(MediaStore.Video.Media._ID)));

        Picasso.get()
                .load(videoUri.toString())
                .fit().centerCrop()
                .placeholder(R.color.grey)
                .into(videoView);


        int mimeTypeColumnName
                = row.getColumnIndex(MediaStore.Video.Media.MIME_TYPE);

        videoMimeType = row.getString(mimeTypeColumnName);

    }
}
