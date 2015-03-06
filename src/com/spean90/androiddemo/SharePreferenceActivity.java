package com.spean90.androiddemo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SharePreferenceActivity extends Activity {
	
	private EditText name,psw;
	private CheckBox ck;
	private Button loginBtn;
	private SharedPreferences preferences;
	private Editor editor;
	String nameStr,pswStr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreference_main);
		preferences = getSharedPreferences("userInfo", MODE_PRIVATE);
		editor = preferences.edit();
		ck = (CheckBox) findViewById(R.id.savepswck);
		name = (EditText) findViewById(R.id.name_et);
		psw = (EditText) findViewById(R.id.psw_et);
		
		nameStr = preferences.getString("name", "");
		pswStr = preferences.getString("psw", "");
		if (!nameStr.trim().equals("")) {
			name.setText(nameStr);
			psw.setText(pswStr);
			ck.setChecked(true);
		}
		
		loginBtn = (Button) findViewById(R.id.loginBtn);
		loginBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				nameStr = name.getText().toString();
				pswStr = psw.getText().toString();
				if (ck.isChecked()) {
					editor.putString("name", nameStr);
					editor.putString("psw", pswStr);
					editor.commit();
				}else{
					editor.putString("psw", "");
					editor.commit();
				}
				Toast.makeText(SharePreferenceActivity.this, "登录成功", Toast.LENGTH_LONG).show();
			}
		});
		
		
		
		
	}

}
