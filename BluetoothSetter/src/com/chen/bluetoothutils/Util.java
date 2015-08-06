package com.chen.bluetoothutils;

import com.chen.bluetoothsetter.Main;
import com.chen.bluetoothsetter.R;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

public class Util{
	public Util(){}
	public static void showMessDialog(Context ctx,CharSequence mes){
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
		builder.setTitle("ÌבÊ¾");
		builder.setMessage(mes);
		builder.setPositiveButton("Ok", null);
		builder.create().show();

	}
	public static String getResourcesString(Context ctx,int id) {
		return ctx.getResources().getString(id);
	}
}
