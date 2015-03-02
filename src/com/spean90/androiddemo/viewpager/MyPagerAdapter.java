package com.spean90.androiddemo.viewpager;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyPagerAdapter extends PagerAdapter {
	
	private List<View>viewList;
	private List<String>titleList;
	public MyPagerAdapter(List<View>viewList,List<String>titleList) {
		this.viewList = viewList;
		this.titleList = titleList;
	}

	@Override
	public int getCount() {
		return viewList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}
	
	/**
	 * 实例化一个页卡
	 */
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(viewList.get(position));
		return viewList.get(position);
	}
	/**
	 * 销毁一个页卡
	 */
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(viewList.get(position));
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		return titleList.get(position);
	}

}
