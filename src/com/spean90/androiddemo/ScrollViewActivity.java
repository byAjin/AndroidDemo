package com.spean90.androiddemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import android.widget.TextView;

public class ScrollViewActivity extends Activity {
	
	private ScrollView scrollView;
	private TextView tv;
	String s ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scrollview_main);
		scrollView = (ScrollView) findViewById(R.id.scrollView);
		tv = (TextView) findViewById(R.id.scrollview_content);
		s = "新华网北京3月2日电（记者邹伟）中共中央总书记、国家主席、中央军委主席习近平近日对邹碧华同志先进事迹作出重要批示指出，邹碧华同志是新时期公正为民的好法官、敢于担当的好干部。他崇法尚德，践行党的宗旨、捍卫公平正义，特别是在司法改革中，敢啃硬骨头，甘当“燃灯者”，生动诠释了一名共产党员对党和人民事业的忠诚。广大党员干部特别是政法干部要以邹碧华同志为榜样，在全面深化改革、全面依法治国的征程中，坚定理想信念，坚守法治精神，忠诚敬业、锐意进取、勇于创新、乐于奉献，努力作出无愧于时代、无愧于人民、无愧于历史的业绩。"
			+"邹碧华生前是上海市高级人民法院副院长，投身司法事业26年。2014年12月，他突发心脏病经抢救无效因公殉职，终年47岁。邹碧华去世后，中宣部追授其“时代楷模”荣誉称号，最高人民法院追授其“全国模范法官”荣誉称号。他的先进事迹被媒体广泛报道，在全社会引起强烈反响。";
		tv.setText(s);
		tv.append(s);
		tv.append(s);
		scrollView.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_UP:
					/**
					 * getScrollY()---获取滚动条滑动的距离
					 * 
					 */
					//在顶部；
					if (scrollView.getScrollY()<=0) {
						Log.i("main", "顶部");
					}
					//在底部
					//textview的总高度<=屏幕的高度+滚动条滚动的高度
					if(scrollView.getChildAt(0).getMeasuredHeight()<=scrollView.getHeight()+scrollView.getScrollY()) {
						Log.i("main", "滑动到底部..");
						Log.i("main", "textview的高度："+tv.getMeasuredHeight()+"=="+scrollView.getChildAt(0).getMeasuredHeight());
						Log.i("main", "一屏幕高度："+scrollView.getHeight()+" 滑动高度："+scrollView.getScrollY());
					}
					break;

				default:
					break;
				}
				return false;
			}
		});
	}
	

}
