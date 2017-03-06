package com.itoutiao.news.toutiaonews.constant;


import com.itoutiao.news.toutiaonews.R;
import com.itoutiao.news.toutiaonews.ui.fragment.AttentionFragment;
import com.itoutiao.news.toutiaonews.ui.fragment.HomeFragment;
import com.itoutiao.news.toutiaonews.ui.fragment.MyCenterFragment;
import com.itoutiao.news.toutiaonews.ui.fragment.SunVideoFragment;

/**
 * 描述：用枚举来管理主页数据
 * 开发者：开发者的乐趣JRT
 * 创建时间：2017-3-5 15:09
 * CSDN地址：http://blog.csdn.net/Jiang_Rong_Tao/article
 * E-mail：jrtxb520@163.com
 **/
public enum MainTab {

	HOME(0, R.string.tab_home, R.drawable.tab_select_home,
			HomeFragment.class),
	SUNVIDOE(1, R.string.tab_sun_video, R.drawable.tab_select_sun_video,
			SunVideoFragment.class),
	ATTENTION(2, R.string.tab_attention, R.drawable.tab_select_attetion,
			AttentionFragment.class),
	MY_CENTER(3, R.string.tab_my_center, R.drawable.tab_select_my_center,
			MyCenterFragment.class);
	private int idx;
	private int resName;
	private int resIcon;
	private Class<?> clz;

	private MainTab(int idx, int resName, int resIcon, Class<?> clz) {
		this.idx = idx;
		this.resName = resName;
		this.resIcon = resIcon;
		this.clz = clz;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getResName() {
		return resName;
	}

	public void setResName(int resName) {
		this.resName = resName;
	}

	public int getResIcon() {
		return resIcon;
	}

	public void setResIcon(int resIcon) {
		this.resIcon = resIcon;
	}

	public Class<?> getClz() {
		return clz;
	}

	public void setClz(Class<?> clz) {
		this.clz = clz;
	}
}
