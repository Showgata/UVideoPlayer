package com.example.showgata12.uvideoplayer.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.showgata12.uvideoplayer.Adapters.VideoListAdapter;
import com.example.showgata12.uvideoplayer.R;


public class VideoListFragment extends Fragment {


    private RecyclerView rvVideoList;
    private VideoListAdapter adapter;

    public VideoListFragment() {

    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_video_list, container, false);
        rvVideoList =v.findViewById(R.id.videoList);
        adapter=new VideoListAdapter();
        rvVideoList.setAdapter(adapter);
        rvVideoList.setLayoutManager(new LinearLayoutManager(getActivity()));
        Toast.makeText(getActivity(), "Fragment Created", Toast.LENGTH_SHORT).show();
        return v;


    }

}
