package com.example.showgata12.uvideoplayer.Adapters;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.showgata12.uvideoplayer.R;
import com.squareup.picasso.Picasso;

public class ControlRow extends RecyclerView.ViewHolder
            implements View.OnClickListener{
    
    private TextView videoTitle=null;
    private TextView videoDate=null;
    private TextView videoName=null;
    private ImageView videoView=null;

    private Uri videoUri=null;
    private String videoMimeType=null;
    
    
    public ControlRow(View v) {
        super(v);
        
        videoTitle = v.findViewById(R.id.videoTitle);
        videoDate=v.findViewById(R.id.videoDate);
        videoName=v.findViewById(R.id.videoUsername);
        videoView=v.findViewById(R.id.videoView);

        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW);

        i.setDataAndType(videoUri,videoMimeType);
        videoTitle.getContext().startActivity(i);
    }

    public void bindModel(Cursor row)
    {
        videoTitle.setText(row.getString(row.getColumnIndex(
                MediaStore.Video.Media.TITLE)));

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
