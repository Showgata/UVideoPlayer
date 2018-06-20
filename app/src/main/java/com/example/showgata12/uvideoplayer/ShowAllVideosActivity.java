package com.example.showgata12.uvideoplayer;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.showgata12.uvideoplayer.Adapters.VideoPagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class ShowAllVideosActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private final int widthDp =24;
    private final int heightDp=24;

    private ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_videos);

        setBottomNavDefaultFeatures();

        toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");
        toolbar.setSubtitle("");


        pager =findViewById(R.id.viewPager);
        pager.setAdapter(new VideoPagerAdapter(getSupportFragmentManager()));



    }

    public void setBottomNavDefaultFeatures()
    {
        BottomNavigationViewEx bnve = findViewById(R.id.bottom_navbar);

        bnve.enableAnimation(false);
        bnve.enableShiftingMode(false);
        bnve.enableItemShiftingMode(false);
        bnve.setIconSize(widthDp, heightDp);
        bnve.setTextSize(10);

    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.nav_viewbar_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
//    }
}
