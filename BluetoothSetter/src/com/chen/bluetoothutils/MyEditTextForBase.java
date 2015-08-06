package com.chen.bluetoothutils;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;

public class MyEditTextForBase extends EditText {
	private Editable myText = null;
	Rect pfr;

	public MyEditTextForBase(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public MyEditTextForBase(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public MyEditTextForBase(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCheckIsTextEditor() {
		// TODO Auto-generated method stub
		return super.onCheckIsTextEditor();
	}

	@Override
	public boolean isInEditMode() {
		boolean b = super.isInEditMode();
		return b;
	}

	@Override
	protected void onFocusChanged(boolean focused, int direction,
			Rect previouslyFocusedRect) {
		Editable ea = this.getText();
		pfr = previouslyFocusedRect;
		if (focused == false) {
			if (focused == false) {
				String tempStr = ea.toString().trim();
				int sLen = tempStr.length();
				int idx = tempStr.indexOf(".");
				if (idx > -1) {
					String lastStr = tempStr.substring(idx + 1);
					int len = lastStr.length();
					switch (len) {
						case 0: {
							myText = ea.append("00");
							break;
						}
	
						case 1: {
							myText = ea.append("0");
							break;
						}
	
						case 2: {
							myText = ea;
							break;
						}
						default:{
							myText = ea.delete(idx+4, sLen);
							break;
						}
					}
				} else {
					if(ea.length() > 0){
						myText = ea.append(".000");
					}else{
						myText = ea.append("0.000");
					}
				}
			}
		}
		super.onFocusChanged(focused, direction, previouslyFocusedRect);
	}

	@Override
	public void setText(CharSequence text, BufferType type) {
		super.setText(myText, type);
	}

	public Editable getMyText() {
		this.onFocusChanged(false, FOCUS_DOWN, pfr);
		return super.getText();
	}
}
