package com.spean90.androiddemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button simpleListView;
	private Button dateTimePicker;

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
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.datatimepicker:
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, DateTimePickerActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

}
