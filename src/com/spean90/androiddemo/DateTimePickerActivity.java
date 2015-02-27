package com.spean90.androiddemo;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

/**
 * 时间日期选择器，以activity方式显示
* 
* @author Huangsp
* @date 2015-2-27 
*
 */
public class DateTimePickerActivity extends Activity implements OnClickListener {
	
	private DatePicker datePicker;
	private TimePicker timePicker;
	private Button dateBtn,timeBtn;
	Calendar calendar = Calendar.getInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datetimeactivity);
		datePicker = (DatePicker) findViewById(R.id.datePicker);
		timePicker = (TimePicker) findViewById(R.id.timePicker);
		
		datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DAY_OF_MONTH) , new OnDateChangedListener() {
			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				setTitle(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
			}
		});
		timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				setTitle(hourOfDay+":"+minute);
			}
		});
		
		dateBtn = (Button) findViewById(R.id.datepicker_dialog);
		timeBtn = (Button) findViewById(R.id.timepicker_dialog);
		dateBtn.setOnClickListener(this);
		timeBtn.setOnClickListener(this);
	}
	
	

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.datepicker_dialog:
			new DatePickerDialog(this, new OnDateSetListener() {
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
					setTitle(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
				}
			}, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
			break;
		case R.id.timepicker_dialog:
			new TimePickerDialog(this, new OnTimeSetListener() {
				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
					setTitle(hourOfDay+":"+minute);
				}
			}, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show();
			break;
		default:
			break;
		}
		
	}

}
