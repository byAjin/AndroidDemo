package com.spean90.androiddemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button simpleListView;  //跳转到listview界面
	private Button dateTimePicker; //跳转到日期时间选择器界面
	private Button gridviewBtn;//跳转到gridview界面
	private Button spinnerBtn;//跳转到下拉列表界面
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
		default:
			break;
		}
	}

}
