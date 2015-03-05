package com.spean90.androiddemo;

import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NotificationActivity extends Activity implements OnClickListener {
	
	private Button cancelNotification,sendNotification;
	private NotificationManager manager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification_main);
		cancelNotification = (Button) findViewById(R.id.cancelNotification);
		sendNotification = (Button) findViewById(R.id.sendNotification);
		sendNotification.setOnClickListener(this);
		cancelNotification.setOnClickListener(this);
		manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.sendNotification:
			sendNotifi();
			break;
		case R.id.cancelNotification:
			cancelNotifi();
			break;

		default:
			break;
		}
	}

	private void cancelNotifi() {
		manager.cancel(1);
	}

	private void sendNotifi() {
		Intent intent = new Intent(this, MainActivity.class);
		PendingIntent pintent = PendingIntent.getActivity(this, 0, intent, 0);
		Builder builder = new Builder(this);
		builder.setTicker("通知");
		builder.setContentTitle("通知标题");
		builder.setContentText("通知内容");
		builder.setContentIntent(pintent);
		builder.setSmallIcon(R.drawable.ic_launcher);
		Notification notification = builder.getNotification();
		manager.notify(1, notification);
	}

}
