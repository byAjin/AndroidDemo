package com.spean90.androiddemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class spinnerActivity extends Activity {
	private TextView textView;
	private Spinner spinner;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner_activity);
		textView = (TextView) findViewById(R.id.spinner_textview);
		spinner  = (Spinner) findViewById(R.id.spinner);
		List<String> list = new ArrayList<String>();
		list.add("北京");
		list.add("上海");
		list.add("广州");
		list.add("深圳");
		//使用简单的数组adapter，采用android自带的layout样式
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		//也可以使用simpleadapter 通过自定义布局实现复杂的下拉列表展示；
		
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				textView.setText("你选择的是："+adapter.getItem(position));
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}
	
}
