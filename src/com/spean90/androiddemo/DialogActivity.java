package com.spean90.androiddemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity extends Activity implements OnClickListener {
	
	private Button singleDialogBtn,multiDialogBtn,listChoice,designView;
	private String[] singleItems= {"男人","女人"};
	private String[] multiItems= {"篮球","足球","男人","女人"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogactivity_main);
		singleDialogBtn = (Button) findViewById(R.id.singleDialogBtn);
		multiDialogBtn = (Button) findViewById(R.id.multiDialogBtn);
		listChoice = (Button) findViewById(R.id.listChoice);
		designView = (Button) findViewById(R.id.designView);
		singleDialogBtn.setOnClickListener(this);
		multiDialogBtn.setOnClickListener(this);
		listChoice.setOnClickListener(this);
		designView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.singleDialogBtn:
			showMyDialog1();
			break;
		case R.id.multiDialogBtn:
			showMyDialog2();		
					break;
		case R.id.listChoice:
			showMyDialog3();
			break;
		case R.id.designView:
			showMyDialog4();
			break;

		default:
			break;
		}
	}

	private void showMyDialog4() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("自定义");
		LayoutInflater inflater = LayoutInflater.from(this);
		View view = inflater.inflate(R.layout.activity_main, null);
		builder.setView(view);
		AlertDialog dialog = builder.create();
		dialog.show();
	}

	private void showMyDialog3() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("list");
		builder.setItems(multiItems, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(DialogActivity.this, "选择了："+multiItems[which], Toast.LENGTH_LONG).show();
			}
		});
		AlertDialog dialog = builder.create();
		dialog.show();
	}

	private void showMyDialog2() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("多选");
		builder.setMultiChoiceItems(multiItems, null, new OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				if (isChecked) {
					Toast.makeText(DialogActivity.this, "喜欢："+multiItems[which], Toast.LENGTH_LONG).show();
				}else{
					Toast.makeText(DialogActivity.this, "不喜欢："+multiItems[which], Toast.LENGTH_LONG).show();
				}
			}
		});
		AlertDialog dialog = builder.create();
		dialog.show();
	}

	private void showMyDialog1() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("单选");
		builder.setSingleChoiceItems(singleItems, 0, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(DialogActivity.this, "选择了："+singleItems[which], Toast.LENGTH_LONG).show();
			}
		});
		AlertDialog dialog = builder.create();
		dialog.show();
	}

}
