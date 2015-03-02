package com.spean90.androiddemo.viewpager;

import com.spean90.androiddemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.viewpager_item, container, false);
		TextView tv = (TextView)view.findViewById(R.id.viewpagerItem);
		tv.setText("222222222");
		return view;
	}

}
