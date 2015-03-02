package com.spean90.androiddemo.viewpager;

import java.util.ArrayList;
import java.util.List;

import com.spean90.androiddemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

public class ViewPagerActivity extends Activity {

	private ViewPager viewPager;
	private List<View> list;
	
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
		PagerAdapter pagerAdapter = new MyPagerAdapter(list);
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		viewPager.setAdapter(pagerAdapter);
	}
}
