package com.example.app3;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import base.Myadapter;

public class MainActivity extends FragmentActivity {
    private String[] src = {"推荐", "头条", "国内"};
    private TabLayout tablayout;
    private ViewPager viewpager;
    private List<Fragment> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        infodata();
        initView();


    }

    private void infodata() {
        mList = new ArrayList<>();
        mList.add(new Fragment1().getfragment("gj"));
        mList.add(new Fragment1().getfragment("ss"));
        mList.add(new Fragment1().getfragment("cj"));
    }

    private void initView() {
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);



    tablayout.addTab(tablayout.newTab().setText(src[0]));
    tablayout.addTab(tablayout.newTab().setText(src[1]));
    tablayout.addTab(tablayout.newTab().setText(src[2]));

        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tablayout.setupWithViewPager(viewpager);
        viewpager.setAdapter(new Myadapter(getSupportFragmentManager(),src,mList));

    }
}
