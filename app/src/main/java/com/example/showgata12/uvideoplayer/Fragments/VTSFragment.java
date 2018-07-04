package com.example.showgata12.uvideoplayer.Fragments;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.showgata12.uvideoplayer.Adapters.VideoListAdapter;
import com.example.showgata12.uvideoplayer.Generators.RandomSelector;
import com.example.showgata12.uvideoplayer.R;

import java.util.HashSet;
import java.util.Set;


public class VTSFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static Uri currentVideo=null;
    private VideoListAdapter adapter;
    private static final String TAG = "VTSFragment";


    public VideoPlayerListener listener=null;

    public VTSFragment() {
        // Required empty public constructor
    }


    public static VTSFragment newInstance(Uri videoUri) {
        VTSFragment fragment = new VTSFragment();
        currentVideo = videoUri;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadVideos();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_video_thumbnail_small, container, false);
        adapter=new VideoListAdapter();
        RecyclerView rv =v.findViewById(R.id.rv_video_list);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);
        return v;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        listener =(VideoPlayerListener)context;

    }

    @Override
    public void onDetach() {
        super.onDetach();

        if(listener!=null)
        {listener=null;}
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        String[] selArgs ={""+ContentUris.parseId(currentVideo)};
        String sel =MediaStore.Video.Media._ID+"!=?";

        Log.d(TAG, "onCreateLoader: "+sel+"!="+selArgs.toString());

        return new CursorLoader(getActivity(),
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                null,sel,selArgs,
                MediaStore.Video.Media.TITLE);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        Log.d(TAG, "onLoadFinished: count="+data.getCount());
        adapter.setVideos(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.setVideos(null);
    }

    void loadVideos()
    {
        getLoaderManager().initLoader(0,null,this);
    }


    public interface VideoPlayerListener
    {
        void updateVideo(Uri uri,String VideoName);
    }

}
