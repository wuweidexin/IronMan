package com.cissst.test;
/**
 * (2)局部内部类：在外部类的方法中定义的 类称为局部内部类
 * <修饰符>class外部内的名称{
 * <外部类的属性>
 * <外部类的方法  方法的修饰符/方法的返回值 方法名称{
 * <修饰符>class内部内的名称{
 * <内部类的属性>
 * <内部类的方法>
 * }
 * }
 * }
 */
public class Outer {
	
	/**
	 * 外部类的普通方法
	 */
	public void getInner(){
		/**
		 * 该类是一个局部类内部类
		 *
		 */
		class Inner{
			/**
			 * 内部类的方法
			 */
		public void innerMethod(){
			
			System.out.println("这是局部内部类的方法");
		}
			
		}
		Inner inner=new Inner();
		inner.innerMethod();
		//System.out.print("这是外部类的输出信息");
		
	}
	
	public static void main(String[] args) {
		Outer  outer=new Outer();
		
		outer.getInner();
	}


}
