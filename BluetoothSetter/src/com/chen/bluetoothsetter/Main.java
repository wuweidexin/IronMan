package com.chen.bluetoothsetter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.chen.bluetoothutils.BluetoothService;
import com.chen.bluetoothutils.Util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Main extends Activity {
	private static final String TAG = "BluetoothSetter";
	private static final boolean D = true;
	private boolean connected = true;

	// handler�е���Ϣ����
	public static final int MESSAGE_STATE_CHANGE = 1;
	public static final int MESSAGE_READ = 2;
	public static final int MESSAGE_WRITE = 3;
	public static final int MESSAGE_DEVICE_NAME = 4;
	public static final int MESSAGE_TOAST = 5;

	// ��BluetoothService��������յ���keyֵ���ṩ��Handler�߳�
	public static final String DEVICE_NAME = "device_name";
	public static final String TOAST = "toast";
	//
	// ��ͼ������
	private static final int REQUEST_CONNECT_DEVICE = 1;
	private static final int REQUEST_ENABLE_BT = 2;
	// ���Բ���-��ͼ������
	private static final int REQUEST_ABSOLUTE_PARA = 3;
	// ��ѹ����
	private static final int REQUEST_PRESSURE_FLOW = 4;
	// ʱ��
	private static final int REQUEST_TIME = 5;
	// ���
	private static final int REQUEST_WATCH_NUM = 6;
	// ����
	private static final int REQUEST_OTHER = 7;

	// ���������豸
	private BluetoothAdapter mBluetoothAdapter = null;
	private BluetoothService mService;
	// //������񷵻ص��豸����
	private String deviceName;
	GridView gridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		if (D)
			Log.e(TAG, "+++ ON CREATE +++");
		super.onCreate(savedInstanceState);
		// ��ȡ������չ
		// requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.main);
		// ��չΪ���صı���
		// getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
		// R.layout.custom_title);
		// TextView title = (TextView)findViewById(R.id.title_left_text);
		// title.setText("����������");
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

		// ���������Ϊ�գ�˵������������ʹ��
		if (mBluetoothAdapter == null) {
			Toast.makeText(getApplicationContext(),
					"Bluetooth is not available", Toast.LENGTH_LONG).show();
			finish();
			return;
		}
		setView();
	}

	/**
	 * ��start�����п�������
	 */
	@Override
	protected void onStart() {
		super.onStart();
		if (!mBluetoothAdapter.isEnabled()) {
			Intent enableIntent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
		} else {
			if (mService == null)
				setupService();
		}

	}

	private void setupService() {
		Log.d(TAG, "setupService()");
		// ��ʼ��Bluetooth������
		mService = new BluetoothService(this, mHandler);
	}

	// ��ʼ������
	public void setView() {
		gridView = (GridView) findViewById(R.id.items_view);
		List<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		lstImageItem.add(getMap(R.drawable.search,
				R.string.connect_bluetooth));
		lstImageItem
				.add(getMap(R.drawable.pressure_flow, R.string.pressure_flow));
		lstImageItem
				.add(getMap(R.drawable.absolute_base, R.string.absolute_base));
		lstImageItem.add(getMap(R.drawable.time, R.string.time));
		lstImageItem.add(getMap(R.drawable.watch_num, R.string.watch_num));
		lstImageItem.add(getMap(R.drawable.ic_launcher, R.string.other));
		SimpleAdapter salmageItems = new SimpleAdapter(this, lstImageItem,
				R.layout.griditem, new String[] { "itemImage", "itemText" },
				new int[] { R.id.itemImage, R.id.itemText });

		gridView.setAdapter(salmageItems);
		gridView.setOnItemClickListener(new ItemClickListener());
	}

	// ��������ͼ�����¼�
	class ItemClickListener implements OnItemClickListener {
		public void onItemClick(AdapterView<?> adaView, View view,
				int location, long arg3) {
			HashMap<String, Object> item = (HashMap<String, Object>) adaView
					.getItemAtPosition(location);
			String s = (String) item.get("itemText");
			Intent intent = null;
			if (s.equals(Util.getResourcesString(Main.this,R.string.connect_bluetooth))) {
				intent = new Intent(Main.this, DeviceActivity.class);
				startActivityForResult(intent, REQUEST_CONNECT_DEVICE);
				return;
			}
			if (!connected) {
				Toast.makeText(Main.this,
						Util.getResourcesString(Main.this,R.string.unconnected),
						Toast.LENGTH_SHORT).show();
				return;
			}
			if (s.equals(Util.getResourcesString(Main.this,R.string.pressure_flow))) {
				intent = new Intent(Main.this, PressureFlow.class);
				startActivityForResult(intent, REQUEST_PRESSURE_FLOW);
			} else if (s.equals(Util.getResourcesString(Main.this,R.string.absolute_base))) {
				intent = new Intent(Main.this, AbsoluteBase.class);
				startActivityForResult(intent, REQUEST_ABSOLUTE_PARA);
			} else if (s.equals(Util.getResourcesString(Main.this,R.string.time))) {
				intent = new Intent(Main.this, Time.class);
				startActivityForResult(intent, REQUEST_TIME);
			} else if (s.equals(Util.getResourcesString(Main.this,R.string.watch_num))) {
				intent = new Intent(Main.this, WatchNum.class);
				startActivityForResult(intent, REQUEST_WATCH_NUM);
			} else if (s.equals(Util.getResourcesString(Main.this,R.string.other))) {
			} else {
				return;
			}

		}

	}

	private HashMap<String, Object> getMap(int imageView, int strId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String text = Util.getResourcesString(Main.this,strId);
		map.put("itemImage", imageView);
		map.put("itemText", text);
		return map;

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// ��ͼ���ش�����
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (D)
			Log.d(TAG, "onActivityResult " + resultCode);
		switch (requestCode) {
		case REQUEST_ABSOLUTE_PARA: {
			if (resultCode == Activity.RESULT_OK) {
				byte[] msg = data.getExtras().getByteArray(AbsoluteBase.ABSOLUTEPARA);
				sendMessage(msg);
			}
			break;
		}
		case REQUEST_PRESSURE_FLOW: {
			if (resultCode == Activity.RESULT_OK) {
				String msg = data.getExtras().getString(
						PressureFlow.PRESSUREFLOW);
				//sendMessage(msg);
			}
			break;
		}
		case REQUEST_TIME: {
			if (resultCode == Activity.RESULT_OK) {
				String msg = data.getExtras().getString(Time.TIME);
				sendMessage(msg.getBytes());
			}
			break;
		}
		case REQUEST_WATCH_NUM: {
			if (resultCode == Activity.RESULT_OK) {
				byte[] msg = data.getExtras().getByteArray(WatchNum.WATCHNUM);
				sendMessage(msg);
			}
			break;
		}
		case REQUEST_CONNECT_DEVICE:
			// When DeviceListActivity returns with a device to connect
			if (resultCode == Activity.RESULT_OK) {
				// ��ȡ�豸��Mac��ַ
				String address = data.getExtras().getString(
						DeviceActivity.EXTRA_DEVICE_ADDRESS);
				// ��ȡ�豸
				BluetoothDevice device = mBluetoothAdapter
						.getRemoteDevice(address);
				Toast.makeText(
						this,
						Util.getResourcesString(Main.this,R.string.connect_device)
								+ device.getName(), Toast.LENGTH_SHORT).show();
				// ��ȡ�豸����
				deviceName = device.getName();
				try {
					mService.connect(device);
					connected = true;
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
			break;
		case REQUEST_ENABLE_BT: {

			if (resultCode == Activity.RESULT_OK) {
				Toast.makeText(this, Util.getResourcesString(Main.this,R.string.bluetooth_ok),
						Toast.LENGTH_SHORT).show();
				// �������ã���ʼ������������
				setupService();
			} else {
				// ����������
				Log.d(TAG, "BT not enabled");
				Toast.makeText(this,
						Util.getResourcesString(Main.this,R.string.bluetooth_unexit),
						Toast.LENGTH_SHORT).show();
				finish();
			}
			break;
		}
		}
	}

	public void sendMessage(byte[] message) {
		// ������Ϣǰ���ȼ��飬��ǰ�ǲ����Ѿ����ӵ�״̬
		if (mService.getState() != BluetoothService.STATE_CONNECTED) {
			Toast.makeText(getApplicationContext(), R.string.not_connected,
					Toast.LENGTH_SHORT).show();
			return;
		}

		// У�鷢�͵���Ϣ�Ƿ�Ϊ��
		if (message.length > 0) {
//			byte[] send = message.getBytes();
			mService.write(message);
		}
	}

	/**
	 * ����Handler���������̵߳���Ϣ���������̵߳�UI
	 */
	private final Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case MESSAGE_STATE_CHANGE:{
				if (D)
					Log.i(TAG, "MESSAGE_STATE_CHANGE: " + msg.arg1);
				switch (msg.arg1) {
				case BluetoothService.STATE_CONNECTED: {
					Toast.makeText(getApplicationContext(),
							Util.getResourcesString(Main.this,R.string.connect_finish),
							Toast.LENGTH_SHORT).show();
					connected = true;
					break;
				}

				case BluetoothService.STATE_CONNECTING: {
					Toast.makeText(getApplicationContext(),
							Util.getResourcesString(Main.this,R.string.scanning),
							Toast.LENGTH_SHORT).show();
					break;
				}
				case BluetoothService.STATE_LISTEN:
					// TODO
				case BluetoothService.STATE_NONE:
					break;
				}
				break;
			}
				
			case MESSAGE_WRITE: {
				byte[] writeBuf = (byte[]) msg.obj;
				// construct a string from the buffer
				String writeMessage = new String(writeBuf);
				Log.e("���͵���Ϣ�ǣ�", writeMessage);
				// mConversationArrayAdapter.add("Me:  " + writeMessage);
				break;
			}

			case MESSAGE_READ: {
				byte[] readBuf = (byte[]) msg.obj;
				// construct a string from the valid bytes in the buffer
				String readMessage = new String(readBuf, 0, msg.arg1);
				Toast.makeText(getApplicationContext(),
						"���յ�����Ϣ�ǣ� " + readMessage, Toast.LENGTH_SHORT).show();
				break;
			}

			case MESSAGE_DEVICE_NAME:
				// save the connected device's name
				break;
			case MESSAGE_TOAST: {
				Toast.makeText(getApplicationContext(),
						msg.getData().getString(TOAST), Toast.LENGTH_SHORT)
						.show();
				break;
			}

			}
		}
	};

	@Override
	public synchronized void onResume() {
		super.onResume();
		if (D)
			Log.e(TAG, "+ ON RESUME +");

		// Performing this check in onResume() covers the case in which BT was
		// not enabled during onStart(), so we were paused to enable it...
		// onResume() will be called when ACTION_REQUEST_ENABLE activity
		// returns.
		if (mService != null) {
			// Only if the state is STATE_NONE, do we know that we haven't
			// started already
			if (mService.getState() == BluetoothService.STATE_NONE) {
				// Start the Bluetooth chat services
				mService.start();
			}
		}
	}

	@Override
	protected void onStop() {
		Log.d(TAG, "onStop()");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy()");
		super.onDestroy();
	}

	

}
