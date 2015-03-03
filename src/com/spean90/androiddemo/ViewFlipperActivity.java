package com.spean90.androiddemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class ViewFlipperActivity extends Activity {
	
	private ViewFlipper viewFlipper;
	private int[] pics = new int[]{R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4};
	private float startX;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewflipper_main);
		viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
		for (int i = 0; i < pics.length; i++) {
			viewFlipper.addView(getImageView(pics[i]));
		}
		//设置进入、出去的动画
		viewFlipper.setInAnimation(this, R.anim.left_in);
		viewFlipper.setOutAnimation(this, R.anim.left_out);
		//设置播放时间、毫秒
		viewFlipper.setFlipInterval(3000);
		viewFlipper.startFlipping();
	}


	private View getImageView(int i) {
		ImageView imageView = new ImageView(this);
		//显示为图片大小；
		//imageView.setImageResource(i);
		//作为背景显示，铺满窗口
		imageView.setBackgroundResource(i);
		
		return imageView;
	}
	
//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		switch (event.getAction()) {
//		//手指按下事件
//		case MotionEvent.ACTION_DOWN:
//			startX = event.getX();
//			break;
//		//移动事件
//		case MotionEvent.ACTION_MOVE:
//			if(event.getX()-startX>100){
//				viewFlipper.setInAnimation(this, R.anim.left_in);
//				viewFlipper.setInAnimation(this,R.anim.left_out);
//				viewFlipper.showPrevious();
//			}
//			if (startX-event.getX()>100) {
//				viewFlipper.setInAnimation(this,R.anim.right_in);
//				viewFlipper.setInAnimation(this, R.anim.right_out);
//				viewFlipper.showNext();
//			}
//			break;
//		default:
//			break;
//		}
//		return true;
//	}

}
