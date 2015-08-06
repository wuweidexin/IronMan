package com.chen.bluetoothsetter;
import com.chen.bluetoothutils.MyEditTextForBase;
import com.chen.bluetoothutils.Transformations;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AbsoluteBase extends Activity{
	private static final String TAG = "AbsolutePara";
	private static final boolean D = true;
	public static final String ABSOLUTEPARA= "ABSOLUTEPARA";
	private LinearLayout llContent = null;
	
	MyEditTextForBase et;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.absolute_base);
		
		TextView tv = (TextView)findViewById(R.id.ap_tv);
		et = (MyEditTextForBase)findViewById(R.id.ap_et);		
	}
	@Override
	protected void onStart() {
		super.onStart();
		if (D)Log.e(TAG, "+++ ON START +++");
		Button bt = (Button)findViewById(R.id.ap_bt);
		bt.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//TODO
				//String message =et.getMyText().toString()+"\0";
				//Byte[] msgByte = Transformations.getByte(message, 2);
				String message = et.getMyText().toString().trim();
				if(null != message && !"".equals(message)){
					byte[] msgbyte= Transformations.getHexByte(message);
					Intent intent = new Intent();
					intent.putExtra(ABSOLUTEPARA, msgbyte);
					// Set result and finish this Activity
					setResult(Activity.RESULT_OK, intent);
					finish();
				}
				
			}
		});	
		
	}
	

	public String getResourcesString(int id) {
		return this.getResources().getString(id);
	}
	
}
