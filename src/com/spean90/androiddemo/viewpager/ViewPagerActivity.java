package com.spean90.androiddemo.viewpager;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.spean90.androiddemo.R;

public class ViewPagerActivity extends FragmentActivity implements OnPageChangeListener {

	private ViewPager viewPager;
	private List<View> list;
	private List<String>titleList;
	private PagerTabStrip pagerTabStrip;
	private List<Fragment> fragmentList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewpager_main);
		list = new ArrayList<View>();
		View view1 = View.inflate(this, R.layout.viewpager_item, null);
		TextView tv = (TextView)(view1.findViewById(R.id.viewpagerItem));
		tv.setText("第一个页卡");
		View view2 = View.inflate(this, R.layout.viewpager_item, null);
		tv = (TextView)(view2.findViewById(R.id.viewpagerItem));
		tv.setText("第2个页卡");
		View view3 = View.inflate(this, R.layout.viewpager_item, null);
		tv = (TextView)(view3.findViewById(R.id.viewpagerItem));
		tv.setText("第3个页卡");
		View view4 = View.inflate(this, R.layout.viewpager_item, null);
		tv = (TextView)(view4.findViewById(R.id.viewpagerItem));
		tv.setText("第4个页卡");
		list.add(view1);
		list.add(view2);
		list.add(view3);
		list.add(view4);
		titleList = new ArrayList<String>();
		titleList.add("第一页");
		titleList.add("第2页");
		titleList.add("第3页");
		titleList.add("第4页");
		PagerAdapter pagerAdapter = new MyPagerAdapter(list,titleList);
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		//viewPager.setAdapter(pagerAdapter);
		pagerTabStrip = (PagerTabStrip) findViewById(R.id.viewpagertab);
		pagerTabStrip.setBackgroundColor(Color.GRAY);
		pagerTabStrip.setDrawFullUnderline(false);
		pagerTabStrip.setTabIndicatorColor(Color.GREEN);
		pagerTabStrip.setTextColor(Color.RED);
		
		fragmentList = new ArrayList<Fragment>();
		fragmentList.add(new Fragment1());
		fragmentList.add(new Fragment2());
		fragmentList.add(new Fragment3());
		fragmentList.add(new Fragment4());
		FragmentPagerAdapter fragmentPagerAdapter = new MyFragmentAdapter(getSupportFragmentManager(), fragmentList, titleList);
		viewPager.setAdapter(fragmentPagerAdapter);
		viewPager.setOnPageChangeListener(this);
		
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		Toast.makeText(this, "选择第"+(arg0+1)+"页", Toast.LENGTH_LONG).show();
	}
}
