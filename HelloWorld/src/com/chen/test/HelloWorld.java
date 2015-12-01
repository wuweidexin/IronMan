package com.chen.test;
import org.jawin.COMException;
import org.jawin.DispatchPtr;


//我的第一个测试类
public class HelloWorld {
	public static void main(String[] args) {
		DispatchPtr p2f = null;
		try {
			p2f = new DispatchPtr("Print2Flash4.Server");
		} catch (Exception e) {
			//如果4不存在，那么就取3
			try {
				p2f =  new DispatchPtr("Print2Flash3.Server");
			} catch (COMException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		System.out.println("Hello");
		
	}
}
