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
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

/**
 * 表格展示图片
* 
* @author Huangsp
* @date 2015-2-27 
*
 */
public class GridViewActivity extends Activity {
	
	private int[] icons = {R.drawable.address_book,R.drawable.calendar,R.drawable.camera,R.drawable.clock,R.drawable.games_control,
			R.drawable.messenger,R.drawable.ringtone,R.drawable.settings,R.drawable.speech_balloon,R.drawable.weather,
			R.drawable.world,R.drawable.youtube};
	private String[] iconsName = {"邮箱","时间","相机","闹钟","游戏","短信","电话","设置","微信","天气","浏览器","youtube"};
	private GridView gridView;
	private List<Map<String, Object>> datas;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridviewactivity);
		gridView = (GridView) findViewById(R.id.gridView);
		datas = new ArrayList<Map<String,Object>>();
		/**
		 * 参数1：context上下午
		 * 参数2:List<Map<String,Object>> 数据源；
		 * 参数3：item的布局文件
		 * 参数4：数据源中map的所有的key;
		 * 参数5：布局文件中与key相对应的id；
		 */
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, getData(), R.layout.gridview_item, new String[]{"pic","text"}, new int[]{R.id.gridview_pic,R.id.gridview_text});
		gridView.setAdapter(simpleAdapter);
		
		//设置点击item事件
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(GridViewActivity.this, iconsName[position], Toast.LENGTH_LONG).show();
			}
		});
	}

	public List<Map<String, Object>> getData() {
		for (int i = 0; i < icons.length; i++) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("pic", icons[i]);
			m.put("text", iconsName[i]);
			datas.add(m);
		}
		return datas;
	}
}
