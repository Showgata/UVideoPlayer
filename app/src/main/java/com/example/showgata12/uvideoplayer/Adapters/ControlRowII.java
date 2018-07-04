package com.example.showgata12.uvideoplayer.Adapters;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.showgata12.uvideoplayer.Fragments.VTSFragment;
import com.example.showgata12.uvideoplayer.R;
import com.squareup.picasso.Picasso;

import java.util.Random;

public class ControlRowII extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView videoTitle;
    private TextView videoDate;
    private ImageView videoThumbnail;
    private Uri videoUri;
    private String videoMimeType=null;
    private Context activity;
    private Uri currentVideoUri;
    private int rand;

    private String videoTitleString;


    public ControlRowII(View v,int noOfItems) {
        super(v);

        this.activity = v.getContext();
        videoTitle=v.findViewById(R.id.videoTitleSmall);
        videoDate=v.findViewById(R.id.videoDateSmall);
        videoThumbnail =v.findViewById(R.id.videoThumbnail);

        v.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        VTSFragment fragment = new VTSFragment();
        fragment.listener.updateVideo(videoUri,videoTitleString);
    }


    public void bindModel(Cursor row)
    {
        videoTitleString =  row.getString(row.getColumnIndex(
                MediaStore.Video.Media.TITLE
        ));

        videoTitle.setText(videoTitleString);

        videoDate.setText(row.getString(row.getColumnIndex(
                MediaStore.Video.Media.DATE_ADDED
        )));

        videoUri=ContentUris.withAppendedId(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                row.getInt(row.getColumnIndex(MediaStore.Video.Media._ID)));

        Picasso.get()
                .load(videoUri.toString())
                .fit().centerCrop()
                .placeholder(R.color.grey)
                .into(videoThumbnail);


        int mimeTypeColumnName
                = row.getColumnIndex(MediaStore.Video.Media.MIME_TYPE);

        videoMimeType = row.getString(mimeTypeColumnName);

    }

}
