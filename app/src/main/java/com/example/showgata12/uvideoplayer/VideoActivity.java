package com.example.showgata12.uvideoplayer;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.showgata12.uvideoplayer.Fragments.VTSFragment;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener,VTSFragment.VideoPlayerListener {

    private Intent videoIntent;
    private Uri videoUri=null;
    private String videoMimeType=null;

    private VideoView v;
    private MediaController mct;
    private TextView videoTitle;
    private String videoTitleString;

    private static final String TAG = "VideoActivity";

    private ImageButton btnLike;
    private ImageButton btnDisLike;
    private ImageButton btnShare;

    private TextView tvLike;
    private TextView tvDisLike;
    private TextView tvShare;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoIntent =getIntent();
        videoUri = videoIntent.getData();
        videoMimeType=videoIntent.getType();
        videoTitleString=videoIntent.getStringExtra("videoTitle");


        videoTitle=findViewById(R.id.videoTitle);
        v =findViewById(R.id.videoPlayer);

        btnLike=findViewById(R.id.btn_like);
        btnDisLike=findViewById(R.id.btn_dislike);
        btnShare=findViewById(R.id.btn_share);

        tvLike=findViewById(R.id.tv_likes);
        tvDisLike=findViewById(R.id.tv_dislike);
        tvShare=findViewById(R.id.tv_share);

        addListFragment(VTSFragment.newInstance(videoUri),"frag1");



        //set OnClickListener

        btnLike.setOnClickListener(this);
        btnDisLike.setOnClickListener(this);
        btnShare.setOnClickListener(this);
    }

    public void addListFragment(Fragment fragment, String tag)
    {
        FragmentTransaction transaction =getFragmentManager().beginTransaction();
        transaction.add(R.id.fragmentView,fragment,tag).commit();
    }


    @Override
    protected void onStart() {
        super.onStart();

      playVideo(videoUri,videoTitleString);

    }

    @Override
    public void onClick(View v) {
        activeButton(v);
    }

    void activeButton(View v)
    {
        int id= v.getId();

        switch (id)
        {
            case R.id.btn_like:

                break;
        }

    }


    public void playVideo(Uri uri,String videoName)
    {
        v.setVideoURI(uri);
        videoTitle.setText(videoName);
        mct=new MediaController(this);
        mct.setMediaPlayer(v);
        v.setMediaController(mct);
        v.requestFocus();
        v.start();
    }


    @Override
    public void updateVideo(Uri uri, String videoName) {
        playVideo(uri,videoName);
    }
}
