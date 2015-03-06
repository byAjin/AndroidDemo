package com.spean90.androiddemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends Activity implements OnClickListener {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.animationactivity_main);
		findViewById(R.id.btn_alpha).setOnClickListener(this);
		findViewById(R.id.btn_translate).setOnClickListener(this);
		findViewById(R.id.btn_scale).setOnClickListener(this);
		findViewById(R.id.btn_rotate).setOnClickListener(this);
		findViewById(R.id.btn_set).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		ImageView iv = (ImageView) findViewById(R.id.iv_anim);
		Animation anim = null;
		switch (v.getId()) {
		case R.id.btn_alpha:
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
			break;
		case R.id.btn_translate:
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
			break;
		case R.id.btn_scale:
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
			break;
		case R.id.btn_rotate:
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
			break;
		case R.id.btn_set:
			anim = AnimationUtils.loadAnimation(this, R.anim.anim_set);
			break;
		}
		iv.startAnimation(anim);
		
	}

}
