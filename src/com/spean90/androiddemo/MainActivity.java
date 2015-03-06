package com.spean90.androiddemo;

import com.spean90.androiddemo.viewpager.ViewPagerActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button simpleListView;  //跳转到listview界面
	private Button dateTimePicker; //跳转到日期时间选择器界面
	private Button gridviewBtn;//跳转到gridview界面
	private Button spinnerBtn;//跳转到下拉列表界面
	private Button progressBarBtn;//processbar
	private Button webViewBtn; //webview
	private Button viewPagerBtn;//viewPager
	private Button viewFlipperBtn;//viewFlipper
	private Button scrollViewBtn;//scrollViewBtn
	private Button dialogBtn;//dialogBtn
	private Button notificationBtn;//notificationBtn
	private Button animationBtn;//notificationBtn
	private Button sharedPreferenceBtn;//sharedPreferenceBtn
	private Button fileBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		simpleListView = (Button) findViewById(R.id.button1);
		simpleListView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, SimpleAdapterListViewActivity.class);
				startActivity(intent);
			}
		});
		dateTimePicker = (Button) findViewById(R.id.datatimepicker);
		dateTimePicker.setOnClickListener(this);
		gridviewBtn = (Button) findViewById(R.id.gridviewBtn);
		gridviewBtn.setOnClickListener(this);
		spinnerBtn = (Button) findViewById(R.id.spinnerBtn);
		spinnerBtn.setOnClickListener(this);
		progressBarBtn = (Button) findViewById(R.id.processBarBtn);
		progressBarBtn.setOnClickListener(this);
		webViewBtn = (Button) findViewById(R.id.webviewBtn);
		webViewBtn.setOnClickListener(this);
		viewPagerBtn = (Button) findViewById(R.id.viewPagerBtn);
		viewPagerBtn.setOnClickListener(this);
		viewFlipperBtn = (Button) findViewById(R.id.viewFlipperBtn);
		viewFlipperBtn.setOnClickListener(this);
		scrollViewBtn = (Button) findViewById(R.id.scrollViewBtn);
		scrollViewBtn.setOnClickListener(this);
		dialogBtn = (Button) findViewById(R.id.dialogBtn);
		dialogBtn.setOnClickListener(this);
		notificationBtn = (Button) findViewById(R.id.notificationBtn);
		notificationBtn.setOnClickListener(this);
		animationBtn = (Button) findViewById(R.id.animationBtn);
		animationBtn.setOnClickListener(this);
		sharedPreferenceBtn = (Button) findViewById(R.id.sharedPreferenceBtn);
		sharedPreferenceBtn.setOnClickListener(this);
		fileBtn = (Button) findViewById(R.id.fileBtn);
		fileBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.datatimepicker:
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, DateTimePickerActivity.class);
			startActivity(intent);
			break;
		case R.id.gridviewBtn:
			intent = new Intent();
			intent.setClass(MainActivity.this, GridViewActivity.class);
			startActivity(intent);
			break;
		case R.id.spinnerBtn:
			intent = new Intent();
			intent.setClass(MainActivity.this, spinnerActivity.class);
			startActivity(intent);
			break;
		case R.id.processBarBtn:
			intent = new Intent();
			intent.setClass(MainActivity.this, ProgressBarActivity.class);
			startActivity(intent);
			break;
		case R.id.webviewBtn:
			intent = new Intent();
			intent.setClass(MainActivity.this, WebViewActivity.class);
			startActivity(intent);
			break;
		case R.id.viewPagerBtn:
			intent = new Intent();
			intent.setClass(MainActivity.this, ViewPagerActivity.class);
			startActivity(intent);
			break;
		case R.id.viewFlipperBtn:
			intent = new Intent();
			intent.setClass(MainActivity.this, ViewFlipperActivity.class);
			startActivity(intent);
			break;
		case R.id.scrollViewBtn:
			intent = new Intent();
			intent.setClass(MainActivity.this, ScrollViewActivity.class);
			startActivity(intent);
			break;
		case R.id.dialogBtn:
			intent = new Intent();
			intent.setClass(MainActivity.this, DialogActivity.class);
			startActivity(intent);
			break;
		case R.id.notificationBtn:
			intent = new Intent();
			intent.setClass(MainActivity.this, NotificationActivity.class);
			startActivity(intent);
			break;
		case R.id.animationBtn:
			intent = new Intent();
			intent.setClass(MainActivity.this, AnimationActivity.class);
			startActivity(intent);
			break;
		case R.id.sharedPreferenceBtn:
			intent = new Intent();
			intent.setClass(MainActivity.this, SharePreferenceActivity.class);
			startActivity(intent);
			break;
		case R.id.fileBtn:
			intent = new Intent();
			intent.setClass(MainActivity.this, FileActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

}
