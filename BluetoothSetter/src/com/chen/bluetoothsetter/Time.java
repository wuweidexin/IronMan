package com.chen.bluetoothsetter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Time extends Activity{
	private static final String TAG = "WatchNum";
	private static final boolean D = true;
	public static final String TIME = "TIME";
	//EditText dp;
	TextView ts;
	String date,date1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.time);
		TextView tv = (TextView)findViewById(R.id.time_tv);
		ts = (TextView)findViewById(R.id.time_ts);
		SimpleDateFormat  df = new SimpleDateFormat ("yyyy年MM月dd日HH时mm分ss秒");
		date1 = df.format(new Date()).toString();
		ts.setText(date1);
		//dp = (EditText)findViewById(R.id.editText1);
		
	}
	@Override
	protected void onStart() {
		if (D)Log.e(TAG, "+++ ON START +++");
		Button bt = (Button)findViewById(R.id.time_bt);
		bt.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//TODO
				SimpleDateFormat  df1 = new SimpleDateFormat ("yyyyMMdHHhmmss");
				date = df1.format(new Date()).toString();
//				String message = dp.toString();
				//String message = dp.getText().toString();
				Intent intent = new Intent();
				intent.putExtra(TIME, date);

				// Set result and finish this Activity
				setResult(Activity.RESULT_OK, intent);
//				et.setText("");
				finish();
			}
		});	
		super.onStart();
	}
	

	public String getResourcesString(int id) {
		return this.getResources().getString(id);
	}
	
}
