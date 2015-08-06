package com.chen.bluetoothsetter;

import java.lang.reflect.Method;
import java.util.Set;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class DeviceActivity extends Activity {
	private static final String TAG = "BluetoothDataSender";
	public static String EXTRA_DEVICE_ADDRESS = "device_address";
	private static final boolean D = true;
	private BluetoothAdapter mBtAdapter = null;
	private Button button_scon = null;
	ArrayAdapter<String> a_paired_device, a_new_device;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.device);
		
		TextView t_paired_title = (TextView) findViewById(R.id.t_paired_device);
		ListView l_paired_device = (ListView) findViewById(R.id.l_paired_device);
		a_paired_device = new ArrayAdapter<String>(this, R.layout.device_name);
		l_paired_device.setAdapter(a_paired_device);
		//l_paired_device.setOnItemClickListener(itemClickListner);

		TextView t_new_title = (TextView) findViewById(R.id.t_new_devices);
		ListView l_new_device = (ListView) findViewById(R.id.l_new_devices);
		a_new_device = new ArrayAdapter<String>(this, R.layout.device_name);
		l_new_device.setAdapter(a_new_device);
		l_new_device.setOnItemClickListener(itemClickListner);

		button_scon = (Button) findViewById(R.id.button_scan);
		button_scon.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
				a_new_device.clear();
				a_new_device.notifyDataSetChanged();
				doDiscovery();
				v.setClickable(false);
				//v.setVisibility(View.GONE);
			}
		});

		IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		this.registerReceiver(newDeviceBC, filter);

		filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
		this.registerReceiver(newDeviceBC, filter);
		mBtAdapter = BluetoothAdapter.getDefaultAdapter();
		Set<BluetoothDevice> pairedDevice = mBtAdapter.getBondedDevices();
		if (pairedDevice.size() > 0) {
			findViewById(R.id.t_paired_device).setVisibility(View.VISIBLE);
			for (BluetoothDevice device : pairedDevice) {
				a_paired_device.add(device.getName() + "\n"
						+ device.getAddress());
			}
		} else {
			String noneDevice = getResources().getText(R.string.none_paired)
					.toString();
			a_paired_device.add(noneDevice);
		}

	}

	/**
	 * 发现设备
	 */
	public void doDiscovery() {
		if (D)
			Log.d(TAG, "doDiscovery()");

		// Indicate scanning in the title
		setProgressBarIndeterminateVisibility(true);
		setTitle(R.string.scanning);

		// Turn on sub-title for new devices
		findViewById(R.id.t_new_devices).setVisibility(View.VISIBLE);

		// If we're already discovering, stop it
		if (mBtAdapter.isDiscovering()) {
			mBtAdapter.cancelDiscovery();
		}

		// Request discover from BluetoothAdapter
		mBtAdapter.startDiscovery();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		// Make sure we're not doing discovery anymore
		if (mBtAdapter != null) {
			mBtAdapter.cancelDiscovery();
		}

		// Unregister broadcast listeners
		this.unregisterReceiver(newDeviceBC);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.device, menu);
		return true;
	}

	/**
	 * 点击菜单中的，一个是discover，一个是as device
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.clear: {
			Set<BluetoothDevice> setDevice = mBtAdapter.getBondedDevices();
			for(BluetoothDevice device : setDevice){
				 try {
					removeBond(device.getClass(), device);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			a_paired_device.clear();
			a_paired_device.notifyDataSetChanged();
			return true;
		}
		case R.id.clearAllFoundDevice : {
			a_new_device.clear();
			a_new_device.notifyDataSetChanged();
			return true;
		}
		default:
			break;
		}
		return false;
	}

	private OnItemClickListener itemClickListner = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			mBtAdapter.cancelDiscovery();

			// Get the device MAC address, which is the last 17 chars in the
			// View
			String info = ((TextView) arg1).getText().toString();
			if(info.equals("没有找到设备")){
				return;
			}
			String address = info.substring(info.length() - 17);

			// Create the result Intent and include the MAC address
			Intent intent = new Intent();
			intent.putExtra(EXTRA_DEVICE_ADDRESS, address);

			// Set result and finish this Activity
			setResult(Activity.RESULT_OK, intent);
			finish();
		}
	};
	/**
	 * 定义一个广播接收器，只要一发现设备，马上处理
	 */
	BroadcastReceiver newDeviceBC = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (BluetoothDevice.ACTION_FOUND.equals(action)) {
				
				BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                // If it's already paired, skip it, because it's been listed already
                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
                	String newDevice = device.getName() + "\n" + device.getAddress();
                	a_new_device.remove(device.getName() + "\n" + device.getAddress());
                	a_new_device.add(device.getName() + "\n" + device.getAddress());
                	a_new_device.notifyDataSetChanged();
                }

			} else if (action
					.equals(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)) {
				setProgressBarIndeterminateVisibility(false);
				setTitle(R.string.discoverFinish);
				if (a_new_device.getCount() == 0) {
					String noDevices = getResources().getText(
							R.string.none_found).toString();
					a_new_device.add(noDevices);
					a_new_device.notifyDataSetChanged();
				}
				button_scon.setClickable(true);
			} else {

			}
		}
	};
	 static public boolean removeBond(Class btClass,BluetoothDevice btDevice) throws Exception {  
	        Method removeBondMethod = btClass.getMethod("removeBond");  
	        Boolean returnValue = (Boolean) removeBondMethod.invoke(btDevice);  
	        return returnValue.booleanValue();  
	    }
}
