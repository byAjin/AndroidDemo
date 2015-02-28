package com.spean90.androiddemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBarActivity extends Activity implements OnClickListener {
	
	private Button addBtn,delBtn;
	private TextView value;
	private ProgressBar progressBar;
	
	private Button showdialogBtn;
	private ProgressDialog progressDialog;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//在标题栏上显示processbar
		//1、启用窗口特性
		requestWindowFeature(Window.FEATURE_PROGRESS);//精确进度条
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);//不精确的进度条
		//启用窗口特性要在setcontentview之前；
		setContentView(R.layout.processbar_activity);
		//显示进度条
		setProgressBarVisibility(true);
		setProgressBarIndeterminateVisibility(true);
		//max=10000;
		setProgress(8888);
		
		init();
	}


	private void init() {
		progressBar = (ProgressBar) findViewById(R.id.progressBar_hori);
		
		value = (TextView) findViewById(R.id.progressbarvalue);
		addBtn = (Button) findViewById(R.id.addprogressbar);
		delBtn = (Button) findViewById(R.id.delprogressbar);
		addBtn.setOnClickListener(this);
		delBtn.setOnClickListener(this);
		value.setText("第一进度条："+(int)(progressBar.getProgress()/(float)progressBar.getMax()*100)+"%,第二进度条："+(int)(progressBar.getSecondaryProgress()/(float)progressBar.getMax()*100)+"%;");
		showdialogBtn = (Button) findViewById(R.id.showprogressbarbtn);
		showdialogBtn.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.addprogressbar:
				progressBar.incrementProgressBy(10);
				progressBar.incrementSecondaryProgressBy(10);
			break;
		case R.id.delprogressbar:
			progressBar.incrementProgressBy(-10);
			progressBar.incrementSecondaryProgressBy(-10);
		break;
		case R.id.showprogressbarbtn:
			progressDialog = new ProgressDialog(this);
			progressDialog.setTitle("进度条对话框");
			progressDialog.setIcon(R.drawable.ic_launcher);
			progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			progressDialog.incrementProgressBy(52); //设置当前进度
			progressDialog.setMax(100);
			progressDialog.setMessage("练习使用进度条对话框");
			//progressDialog.setIndeterminate(false);//设置精确显示进度条；
			progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "完成", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(ProgressBarActivity.this, "welcome!!", Toast.LENGTH_LONG).show();
				}
			});
			
			progressDialog.show();
		break;
		default:
			break;
		}
		value.setText("第一进度条："+(int)(progressBar.getProgress()/(float)progressBar.getMax()*100)+"%,第二进度条："+(int)(progressBar.getSecondaryProgress()/(float)progressBar.getMax()*100)+"%;");
	}

}
