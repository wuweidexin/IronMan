package com.cissst.test;
/**
 * (2)�ֲ��ڲ��ࣺ���ⲿ��ķ����ж���� ���Ϊ�ֲ��ڲ���
 * <���η�>class�ⲿ�ڵ�����{
 * <�ⲿ�������>
 * <�ⲿ��ķ���  ���������η�/�����ķ���ֵ ��������{
 * <���η�>class�ڲ��ڵ�����{
 * <�ڲ��������>
 * <�ڲ���ķ���>
 * }
 * }
 * }
 */
public class Outer {
	
	/**
	 * �ⲿ�����ͨ����
	 */
	public void getInner(){
		/**
		 * ������һ���ֲ����ڲ���
		 *
		 */
		class Inner{
			/**
			 * �ڲ���ķ���
			 */
		public void innerMethod(){
			
			System.out.println("���Ǿֲ��ڲ���ķ���");
		}
			
		}
		Inner inner=new Inner();
		inner.innerMethod();
		//System.out.print("�����ⲿ��������Ϣ");
		
	}
	
	public static void main(String[] args) {
		Outer  outer=new Outer();
		
		outer.getInner();
	}


}
