package com.chen.bluetoothutils;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;

public class MyEditText extends EditText{
	private Editable myText = null;
	Rect pfr ;
	public MyEditText(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public MyEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	public MyEditText(Context context, AttributeSet attrs, int defStyle) {
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
		Double temp;
		if(focused==false){
			switch (ea.length()) {
			case 0:{
				myText = ea.append("0.000");
				break;
			}
				
			case 1:{
				myText = ea.append(".000");
				break;
			}
				
			case 2:{
				myText = ea.append(".00");
				break;	
			}
				
				
			case 3:{
				temp = Double.valueOf(ea.toString());
				if(temp>0){
					myText = ea.append(".0");
				}else{
					myText = ea.append("00");
				}
				break;
			}
				
			case 4:{
				temp = Double.valueOf(ea.toString());
				if(temp>0){
					myText = ea.append("");
				}else{
					myText = ea.append("00");
				}
				break;
			}
				
			case 5:{
				myText = ea;
				break;
			}
				
			default:
				break;
			}
		}
		super.onFocusChanged(focused, direction, previouslyFocusedRect);
	}
	@Override
	public void setText(CharSequence text, BufferType type) {
		super.setText(myText, type);
	}
	public Editable getMyText(){
		this.onFocusChanged(false, FOCUS_DOWN, pfr);
		return super.getText();
	}
}
