package com.itoutiao.news.toutiaonews.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.itoutiao.news.toutiaonews.R;
import com.itoutiao.news.toutiaonews.base.BaseActivity;
import com.itoutiao.news.toutiaonews.constant.MainTab;
import com.itoutiao.news.toutiaonews.ui.view.MyFragmentTabHost;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 描述：应用的主界面，用来处理底部Tab的切换
 * 开发者：开发者的乐趣JRT
 * 创建时间：2017-3-5 14:29
 * CSDN地址：http://blog.csdn.net/Jiang_Rong_Tao/article
 * E-mail：jrtxb520@163.com
 **/

public class MainActivity extends BaseActivity implements TabHost.OnTabChangeListener {

    @InjectView(android.R.id.tabhost)
    MyFragmentTabHost mTabhost;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        showLoadingDialog();
        ButterKnife.inject(this);
    }
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==0){
                dismissDialog();
            }
            super.handleMessage(msg);
        }
    };
    @Override
    protected void initData() {
        // 初始化底部FragmentTabHost
        mTabhost.setup(this, getSupportFragmentManager(), R.id.main_frame);
        if (Build.VERSION.SDK_INT > 10) {
            mTabhost.getTabWidget().setShowDividers(0);
        }
        initTabs();
        mTabhost.setCurrentTab(0);

        mHandler.sendMessageDelayed(Message.obtain(mHandler,0),2000);//模拟加载网络数据
    }

    @Override
    protected void initListener() {
        mTabhost.setOnTabChangedListener(this);
    }
    @Override
    public void onTabChanged(String s) {
        if (getString(MainTab.MY_CENTER.getResName()).equals(s)){
//            doLogin();//检测是否登录
        }
    }
    private void initTabs() {
        MainTab[] tabs = MainTab.values();
        final int size = tabs.length;
        for (int i = 0; i < size; i++) {
            // 找到每一个枚举的Fragment对象
            MainTab mainTab = tabs[i];
            // 1. 创建一个新的选项卡
            TabHost.TabSpec tab = mTabhost.newTabSpec(getString(mainTab.getResName()));
            // ------------------------------------------------- 自定义选项卡 ↓
            View indicator = LayoutInflater.from(mContext)
                    .inflate(R.layout.tab_indicator, null);
            TextView title = (TextView) indicator.findViewById(R.id.tab_title);
            Drawable drawable = this.getResources().getDrawable(
                    mainTab.getResIcon());
            title.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null,
                    null);
            title.setText(getString(mainTab.getResName()));
            // 设置自定义选项卡
            tab.setIndicator(indicator);
            tab.setContent(new TabHost.TabContentFactory() {

                @Override
                public View createTabContent(String tag) {
                    return new View(MainActivity.this);
                }
            });
            // ------------------------------------------------- 以上 ↑

            Bundle bundle = new Bundle();
            bundle.putString("key", "content: " + getString(mainTab.getResName()));
            // 2. 把新的选项卡添加到TabHost中
            mTabhost.addTab(tab, mainTab.getClz(), bundle);
            // mTabHost.getTabWidget().getChildAt(i).setOnTouchListener(this);
        }
    }
}
