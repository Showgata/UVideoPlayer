package com.example.showgata12.uvideoplayer.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.showgata12.uvideoplayer.Fragments.VideoListFragment;

public class VideoPagerAdapter extends FragmentPagerAdapter {

    public VideoPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return new VideoListFragment();
    }

    @Override
    public int getCount() {
        return 1;
    }
}
