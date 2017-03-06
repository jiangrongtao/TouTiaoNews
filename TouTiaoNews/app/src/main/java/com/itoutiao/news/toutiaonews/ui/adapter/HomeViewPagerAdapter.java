package com.itoutiao.news.toutiaonews.ui.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：填充主页布局
 * 开发者：开发者的乐趣JRT
 * 创建时间：2017-3-5 15:09
 * CSDN地址：http://blog.csdn.net/Jiang_Rong_Tao/article
 * E-mail：jrtxb520@163.com
 **/

public class HomeViewPagerAdapter extends PagerAdapter {
    private String[] names = new String[]{};
    private List<TextView> views = new ArrayList<TextView>();
    private ViewPager mViewPager;

    public HomeViewPagerAdapter(String[] names, List<TextView> views, ViewPager viewPager) {
        this.names = names;
        this.views = views;
        this.mViewPager = viewPager;
    }

    //该方法一定要重写   和TabPagerIndicator联合使用的时候
    @Override
    public CharSequence getPageTitle(int position) {
        return names[position];
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //把这里的view换成你自己的View,也就加载自定义布局
        TextView view = views.get(position);
        mViewPager.addView(view);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        TextView view = views.get(position);
        mViewPager.removeView(view);
    }
}
