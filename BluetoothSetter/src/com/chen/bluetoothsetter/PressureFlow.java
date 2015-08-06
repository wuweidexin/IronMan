package com.chen.bluetoothsetter;

import com.chen.bluetoothutils.MyEditText;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PressureFlow extends Activity{
	private static final String TAG = "WatchNum";
	private static final boolean D = true;
	public static final String PRESSUREFLOW = "PRESSUREFLOW";
	private int numEditText = 7;
	LinearLayout lin;
	EditText et;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pressure_flow);
		
		lin = (LinearLayout) findViewById(R.id.ap_linearLayout);
		lin.removeAllViews();  
		TextView t = null;
		 View v = null;
		LayoutInflater inflater = null;
		
//		inflater = LayoutInflater.from(this); 
//		v = (View) inflater.inflate(  
//                R.layout.text_edit, null);  
//	    t = (TextView)v.findViewById(R.id.text1);
//	    t.setText("倍  率：");
//        lin.addView(v); 
		
        inflater = LayoutInflater.from(this); 
        v = (View) inflater.inflate(  
                R.layout.text_edit, null);  
	    t = (TextView)v.findViewById(R.id.text1);
	    t.setText("始动量 ：");
        lin.addView(v);
		
		for(int i = 0; i < numEditText; i++){
			inflater = LayoutInflater.from(this);  
		    v = (View) inflater.inflate(  
	                R.layout.text_edit, null);  
		    t = (TextView)v.findViewById(R.id.text1);
		    t.setText("差压"+i+"：");
	        lin.addView(v); 
		}
		
		for(int i = 0; i < numEditText; i++){
			inflater = LayoutInflater.from(this);  
		    v = (View) inflater.inflate(  
	                R.layout.text_edit, null);  
		    t = (TextView)v.findViewById(R.id.text1);
		    t.setText("流量"+i+"：");
	        lin.addView(v); 
		}
	}
	@Override
	protected void onStart() {
		if (D)Log.e(TAG, "+++ ON START +++");
		Button bt = (Button)findViewById(R.id.pf_bt);
		bt.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//TODO
				String message = "";
				
				 StringBuffer sb = new StringBuffer();
					for (int j = 0; j < numEditText; j++) {
						MyEditText et = (MyEditText)lin.getChildAt(j).findViewById(R.id.editText1);
						String s = et.getMyText().toString();
						sb.append(s+",");
					}
				
				
				Intent intent = new Intent();
				intent.putExtra(PRESSUREFLOW, message);

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
