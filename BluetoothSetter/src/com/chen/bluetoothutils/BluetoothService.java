package com.chen.bluetoothutils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import com.chen.bluetoothsetter.Main;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

public class BluetoothService{
	// handler中的消息机制
	public static final int MESSAGE_STATE_CHANGE = 1;
	public static final int MESSAGE_READ = 2;
	public static final int MESSAGE_WRITE = 3;
	public static final int MESSAGE_DEVICE_NAME = 4;
	public static final int MESSAGE_TOAST = 5;

	// 从BluetoothService服务类接收到的key值，提供给Handler线程
	public static final String DEVICE_NAME = "device_name";
	public static final String TOAST = "toast";

	private static final boolean D = true;
	private static final String TAG = "BluetoothService";
	private Handler handler;
	private BluetoothAdapter mAdapter;
	private ConnectThread conThread;
	private ConnectedThread conEdThread;
	// Unique UUID for this application
	// 00001101-0000-1000-8000-00805F9B34FB
	private static final UUID MY_UUID = UUID
			.fromString("fa87c0d0-afac-11de-8a39-0800200c9a66");
	// private static final UUID MY_UUID = UUID
	// .fromString("00001101-0000-1000-8000-00805F9B34FB");
	/*
	 * 下面几个变量，定义蓝牙的不同链接状态
	 */
	public static final int STATE_NONE = 0; // we're doing nothing
	public static final int STATE_LISTEN = 1; // now listening for incoming
												// connections
	public static final int STATE_CONNECTING = 2; // now initiating an outgoing
													// connection
	public static final int STATE_CONNECTED = 3; // now connected to a remote
													// device
	private int nowState;// now state

	public BluetoothService(Context content, Handler handler) {
		this.mAdapter = BluetoothAdapter.getDefaultAdapter();
		this.handler = handler;
	}
	public BluetoothService() {
	}

	public synchronized void start() {
		if (D)
			Log.d(TAG, "start");

		// Cancel any thread attempting to make a connection
		if (conThread != null) {
			conThread.cancle();
			conThread = null;
		}

		// Cancel any thread currently running a connection
		if (conEdThread != null) {
			conEdThread.cancel();
			conEdThread = null;
		}

		setState(STATE_LISTEN);
	}

	public synchronized void connect(BluetoothDevice device) {
		if (nowState == STATE_CONNECTED) {
			if (conThread != null) {
				conThread.cancle();
				conThread = null;
			}

		}
		if (conEdThread != null) {
			conEdThread.cancel();
			conEdThread = null;
		}
		conThread = new ConnectThread(device);
		conThread.start();
		setState(STATE_CONNECTING);
	};

	/**
	 * 该线程主要是链接其他蓝牙设备
	 * 
	 * @author Administrator
	 * 
	 */
	class ConnectThread extends Thread {
		private final BluetoothSocket mmSocket;
		private final BluetoothDevice mmDevice;

		public ConnectThread(BluetoothDevice device) {
			mmDevice = device;
			BluetoothSocket tmp = null;
			try {
				tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
			} catch (Exception e) {
				Log.e(TAG, "create connectThread failed", e);
			}
			mmSocket = tmp;
		}

		public void run() {
			mAdapter.cancelDiscovery();
			try {
				mmSocket.connect();
			} catch (Exception e) {
				connectFailed();
				try {
					mmSocket.close();
				} catch (Exception e2) {
					Log.e(TAG, "Connect Socket close Failed" + e2);
				}
				BluetoothService.this.start();
				return;
			}

			synchronized (BluetoothService.this) {
				conThread = null;
			}

			// Start the connected thread
			connected(mmSocket, mmDevice);
		}

		public void cancle() {
			if (D)
				Log.d(TAG, "cancel " + this);
			try {
				mmSocket.close();
			} catch (IOException e) {
				Log.e(TAG, "close() of server failed", e);
			}
		}

	}

	public synchronized void connected(BluetoothSocket mmSocket2,
			BluetoothDevice mmDevice2) {

		if (conThread != null) {
			conThread.cancle();
			conThread = null;
		}
		if (conEdThread != null) {
			conEdThread.cancel();
			conEdThread = null;
		}

		conEdThread = new ConnectedThread(mmSocket2);
		conEdThread.start();

		// Send the name of the connected device back to the UI Activity
		Message msg = handler.obtainMessage(MESSAGE_DEVICE_NAME);
		Bundle bundle = new Bundle();
		bundle.putString(DEVICE_NAME, mmDevice2.getName());
		msg.setData(bundle);
		handler.sendMessage(msg);

		setState(STATE_CONNECTED);

	}

	public void connectFailed() {
		setState(STATE_NONE);
		Message msg = handler.obtainMessage(MESSAGE_TOAST);
		Bundle data = new Bundle();
		data.putString(TOAST, "无法连接设备，建议重新启动双方软件");
		msg.setData(data);
		handler.sendMessage(msg);
	}

	/**
	 * 处理已经链接的蓝牙设备
	 * 
	 * @author Administrator
	 * 
	 */
	class ConnectedThread extends Thread {
		private final BluetoothSocket mmSocket;
		private final InputStream mmInStream;
		private final OutputStream mmOutStream;

		public ConnectedThread(BluetoothSocket socket) {
			Log.d(TAG, "create ConnectedThread");
			mmSocket = socket;
			InputStream tmpIn = null;
			OutputStream tmpOut = null;

			// Get the BluetoothSocket input and output streams
			try {
				tmpIn = socket.getInputStream();
				tmpOut = socket.getOutputStream();
			} catch (IOException e) {
				Log.e(TAG, "temp sockets not created", e);
			}

			mmInStream = tmpIn;
			mmOutStream = tmpOut;
		}

		public void run() {
			Log.i(TAG, "BEGIN mConnectedThread");
			byte[] buffer = new byte[1024];
			int bytes;
			while (true) {
				try {
					// Read from the InputStream
					bytes = mmInStream.read(buffer);

					// Send the obtained bytes to the UI Activity
					handler.obtainMessage(MESSAGE_READ, bytes, -1, buffer)
							.sendToTarget();
				} catch (IOException e) {
					Log.e(TAG, "disconnected", e);
					connectionLost();
					break;
				}
			}
		}

		public void write(byte[] buffer) {
			try {
				mmOutStream.write(buffer);
				handler.obtainMessage(MESSAGE_WRITE, -1, -1, buffer)
						.sendToTarget();
			} catch (IOException e) {
				Log.e(TAG, "Exception during write", e);
			}
		}

		public void cancel() {
			try {
				mmSocket.close();
			} catch (IOException e) {
				Log.e(TAG, "close() of connect socket failed", e);
			}
		}
	}

	private void connectionLost() {
		setState(STATE_LISTEN);

		// Send a failure message back to the Activity
		Message msg = handler.obtainMessage(MESSAGE_TOAST);
		Bundle bundle = new Bundle();
		bundle.putString(TOAST, "连接丢失");
		msg.setData(bundle);
		handler.sendMessage(msg);
	}

	/**
	 * Write to the ConnectedThread in an unsynchronized manner
	 * 
	 * @param out
	 *            The bytes to write
	 * @see ConnectedThread#write(byte[])
	 */
	public void write(byte[] out) {
		ConnectedThread r;
		// Synchronize a copy of the ConnectedThread
		synchronized (this) {
			if (nowState != STATE_CONNECTED)
				return;
			r = conEdThread;
		}
		// Perform the write unsynchronized
		r.write(out);
	}

	private synchronized void setState(int state) {
		if (D)
			Log.d(TAG, "setState() " + nowState + " -> " + state);
		nowState = state;
		// 给Handler发送消息，通知UI改变
		handler.obtainMessage(MESSAGE_STATE_CHANGE, state, -1).sendToTarget();
	}

	/**
	 * Return the current connection state.
	 */
	public synchronized int getState() {
		return nowState;
	}

	/**
	 * Stop all threads
	 */
	public synchronized void stop() {
		if (D)
			Log.d(TAG, "stop");
		if (conThread != null) {
			conThread.cancle();
			conThread = null;
		}
		if (conEdThread != null) {
			conEdThread.cancel();
			conEdThread = null;
		}
		setState(STATE_NONE);
	}
}
