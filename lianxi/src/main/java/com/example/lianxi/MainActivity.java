package com.example.lianxi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SlidingMenu menu = new SlidingMenu(this);
        //设置侧滑菜单的位置可选值LEFT , RIGHT , LEFT_RIGHT
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式 可选只MARGIN , CONTENT
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //来设置阴影的宽度
        menu.setShadowWidthRes(R.dimen.shadow_width);
        //滑动菜单的阴影效果
        menu.setShadowDrawable(R.mipmap.ic_launcher);

        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        //把滑动菜单添加进所有的Activity中，可选值SLIDING_CONTENT ， SLIDING_WINDOW
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        menu.setMenu(R.layout.layout2);

    }
}
