package com.chen.singleton;
/**
 * @author ChenJunQuan
 * @version 2014-3-27 上午11:34:14
 */
//单例模式
public class Singleton {
	public static Singleton singleton;

	private Singleton(){}
	
	public static Singleton getInstance(){
		if(singleton == null){
			singleton =  new Singleton();
		}
		return singleton;

	}
}
