package com.chen.reflection;


public class Test {
	public static void main(String[] args) {
		CommonReflection<Person> c = new CommonReflection<Person>("com.chen.reflection.Person");
//		c.getAllMethodsName();
//		c.excuteMethods("getPhone");
		c.excuteMethodsWithParam("getSum",new Class[]{double.class, double.class}, new Object[]{3.2,8});
	}
}
