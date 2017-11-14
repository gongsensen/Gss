package com.example.lenovo.myprojects.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.example.lenovo.myprojects.R;
import com.example.lenovo.myprojects.adapter.MyFragPagerAdapter;
import com.example.lenovo.myprojects.myview.NoScrollViewPager;
import com.umeng.socialize.UMShareAPI;
import com.yinglan.alphatabs.AlphaTabsIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import find.view.FindFragment;
import home.view.HomeFragment;
import mine.view.MineFragment;
import shopcar.ShopCarFragment;
import type.view.TypeFragment;

public class MainActivity extends FragmentActivity {
    @BindView(R.id.viewpager)
    NoScrollViewPager viewpager;
    @BindView(R.id.alphaIndicator)
    AlphaTabsIndicator alphaIndicator;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        viewpager.setAdapter(new MyFragPagerAdapter(getSupportFragmentManager(), this, list));
        //底部栏配置viewpager
        alphaIndicator.setViewPager(viewpager);
    }

    private void initData() {
        list.add(new HomeFragment());
        list.add(new TypeFragment());
        list.add(new FindFragment());
        list.add(new ShopCarFragment());
        list.add(new MineFragment());
    }



//    //如果build.gradle 里的版本大于或者等于23的话，就要在回调方法里动态获取一下权限
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (Build.VERSION.SDK_INT >= 23) {
//            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                    Manifest.permission.ACCESS_FINE_LOCATION,
//                    Manifest.permission.CALL_PHONE,
//                    Manifest.permission.READ_LOGS,
//                    Manifest.permission.READ_PHONE_STATE,
//                    Manifest.permission.READ_EXTERNAL_STORAGE,
//                    Manifest.permission.SET_DEBUG_APP,
//                    Manifest.permission.SYSTEM_ALERT_WINDOW,
//                    Manifest.permission.GET_ACCOUNTS,
//                    Manifest.permission.WRITE_APN_SETTINGS};
//            ActivityCompat.requestPermissions(this, mPermissionList, 123);
//        }
//
//    }
}
