package com.itoutiao.news.toutiaonews.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.itoutiao.news.toutiaonews.R;
import com.itoutiao.news.toutiaonews.base.BaseFragment;
import com.itoutiao.news.toutiaonews.ui.adapter.HomeViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 描述：加载主页布局以及处理主页的逻辑
 * 开发者：开发者的乐趣JRT
 * 创建时间：2017-3-5 15:09
 * CSDN地址：http://blog.csdn.net/Jiang_Rong_Tao/article
 * E-mail：jrtxb520@163.com
 **/
public class HomeFragment extends BaseFragment {
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.tablayout)
    TabLayout mTablayout;
    @InjectView(R.id.home_viewpager)
    ViewPager mViewpager;
    @InjectView(R.id.iv_add_tab)
    ImageView mAddTab;
    private List<TextView> views = new ArrayList<TextView>();
    private String[] names = new String[]{
            "体育", "都市", "娱乐", "八卦", "旅游", "女性", "育儿", "购物", "音乐"
    };

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        ButterKnife.inject(this, mContentView);
        mToolbar.setTitle("首页");
        //初始化数据
        for (String name : names) {
            TextView tv = new TextView(getActivity());
            tv.setText(name);
            tv.setTextSize(28);
            tv.setTextColor(Color.BLACK);
            tv.setGravity(Gravity.CENTER);
            views.add(tv);
        }
        mViewpager.setAdapter(new HomeViewPagerAdapter(names, views, mViewpager));
        // 将ViewPager和TabLayout绑定
        mTablayout.setupWithViewPager(mViewpager);
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick(R.id.iv_add_tab)
    public void onClick() {
        Toast.makeText(mContext, "待做", Toast.LENGTH_SHORT).show();
    }
}
