package com.chen.bluetoothsetter;
import com.chen.bluetoothutils.Transformations;
import com.chen.bluetoothutils.Util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WatchNum extends Activity{
	private static final String TAG = "WatchNum";
	private static final boolean D = true;
	public static final String WATCHNUM = "WATCHNUM";
	EditText et;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.watch_num);
		TextView tv = (TextView)findViewById(R.id.wn_tv);
		et = (EditText)findViewById(R.id.wn_et);
		
	}
	@Override
	protected void onStart() {
		if (D)Log.e(TAG, "+++ ON START +++");
		Button bt = (Button)findViewById(R.id.wn_bt);
		bt.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//TODO
				String message = et.getText().toString()+"\0";
				if(message.length()!=14){
					String error = Util.getResourcesString(WatchNum.this,R.string.watchnum_error);
					Util.showMessDialog(WatchNum.this,error );
					return;
				}
				Byte[] msgByte = Transformations.getByte(message, 7);
				byte[] msgbyte= new byte[msgByte.length];
				for(int i=0;i<msgByte.length;i++){
					msgbyte[i] = msgByte[i].byteValue();
				}
				Intent intent = new Intent();
				intent.putExtra(WATCHNUM, msgbyte);
				// Set result and finish this Activity
				setResult(Activity.RESULT_OK, intent);
				//et.setText("");
				finish();
			}
		});	
		super.onStart();
	}
	

	public String getResourcesString(int id) {
		return this.getResources().getString(id);
	}
	
}
