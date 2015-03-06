package com.spean90.androiddemo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FileActivity extends Activity implements OnClickListener {
	
	private EditText et;
	private TextView tv;
	private String s;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fileactivity_main);
		findViewById(R.id.saveToFile).setOnClickListener(this);
		findViewById(R.id.readFromFile).setOnClickListener(this);
		et = (EditText) findViewById(R.id.contextText);
		tv = (TextView) findViewById(R.id.fileContent);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.saveToFile:
			try {
				FileOutputStream fout = openFileOutput("t.txt", MODE_PRIVATE);//默认路径    /data/data/xxx.xxx.xxx/t.txt
				fout.write(et.getText().toString().getBytes());
				fout.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.readFromFile:
			try {
				FileInputStream fin = openFileInput("t.txt");
				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				int len = 0;
				while((len = fin.read(buf))!=-1) {
					bout.write(buf);
				}
				tv.setText(bout.toString());
				fin.close();
				bout.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
	}
	
	

}
