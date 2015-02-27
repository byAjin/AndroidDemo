package com.spean90.androiddemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
/**
 * simpleAdapterListview demo
* 
* @author Huangsp
* @date 2015-2-27 
*
 */
public class SimpleAdapterListViewActivity extends Activity {

	private ListView listView;
	private SimpleAdapter simpleAdapter;
	private List<Map<String, Object>> data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.listviewactivity);
		listView = (ListView) findViewById(R.id.listView);
		data = new ArrayList<Map<String,Object>>();
		simpleAdapter = new SimpleAdapter(this, getData(), R.layout.listitem, new String[]{"pic","text"}, new int[]{R.id.pic,R.id.text});
		listView.setAdapter(simpleAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
				//String text = listView.getItemAtPosition(position)+"";
				String text = ((TextView)view.findViewById(R.id.text)).getText().toString();
				Toast.makeText(SimpleAdapterListViewActivity.this, text, Toast.LENGTH_LONG).show();
			}
		});
	}
	public List<Map<String, Object>> getData() {
		for (int i = 0; i < 20; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("pic", R.drawable.ic_launcher);
			item.put("text", "项目"+i);
			data.add(item);
		}
		return data;
	}
}
