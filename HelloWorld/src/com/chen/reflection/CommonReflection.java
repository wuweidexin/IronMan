package com.chen.reflection;

import java.lang.reflect.Method;

public class CommonReflection<T> {
	Class<T> cla = null;
	public CommonReflection(){}
	//初始化
	public CommonReflection(String name){
		try {
			cla = (Class<T>) Class.forName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//获取全部方法
	public void getAllMethodsName(){
		Method[] mes = cla.getMethods();
		for(Method m : mes) {
			System.out.println(m.getName());
		}
	}
	//执行某个方法
	public void excuteMethods(String mn){
		try {
			T t = cla.newInstance();
			Method m = cla.getMethod(mn, null);
			String re = (String)m.invoke(t);
			System.out.println(re);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//执行某个方法
	public void excuteMethodsWithParam(String mn, Class[] cn ,Object[] oarr){
		try {
			T t = cla.newInstance();
			Method m = cla.getMethod(mn, cn);
			String re = String.valueOf(m.invoke(t, oarr));
			System.out.println(re);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//获取属性
}
