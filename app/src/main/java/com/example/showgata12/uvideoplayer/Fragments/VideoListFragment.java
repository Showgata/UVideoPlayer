package com.example.showgata12.uvideoplayer.Fragments;


import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Toast;


import com.example.showgata12.uvideoplayer.Adapters.VideoAdapter;
import com.example.showgata12.uvideoplayer.Adapters.VideoListAdapter;
import com.example.showgata12.uvideoplayer.R;


public class VideoListFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{


    private RecyclerView rvVideoList;
    private VideoAdapter adapter;

    private static final String STATE_IN_PERMISSION="inPermission";
    private static final int REQUEST_PERMS=137;
    private boolean isInPermission=false;

    public VideoListFragment() {

    }




    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        if (state!=null) {
            isInPermission=
                    state.getBoolean(STATE_IN_PERMISSION, false);
        }

        if (hasFilesPermission()) {
            loadVideos();
        }
        else if (!isInPermission) {
            isInPermission=true;

            ActivityCompat.requestPermissions(getActivity(),
                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_PERMS);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean(STATE_IN_PERMISSION, isInPermission);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions,
                                           int[] grantResults) {
        isInPermission=false;

        if (requestCode==REQUEST_PERMS) {
            if (hasFilesPermission()) {
                loadVideos();
            }
        }
    }


    private boolean hasFilesPermission() {
        return(ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.READ_EXTERNAL_STORAGE)==
                PackageManager.PERMISSION_GRANTED);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_video_list, container, false);
        rvVideoList =v.findViewById(R.id.videoList);
        adapter=new VideoAdapter(getActivity());
        rvVideoList.setAdapter(adapter);
        rvVideoList.setLayoutManager(new LinearLayoutManager(getActivity()));
        Toast.makeText(getActivity(), "Fragment Created", Toast.LENGTH_SHORT).show();
        return v;


    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(),
                    MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                    null,null,null,
                MediaStore.Video.Media.TITLE);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
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
}
