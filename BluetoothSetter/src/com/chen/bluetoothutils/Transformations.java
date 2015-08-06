package com.chen.bluetoothutils;

import java.util.ArrayList;
import java.util.List;

public class Transformations {
	private String data;
	private int type;
	public Transformations(){}
	public Transformations(String data, int type){
		this.data = data;
		this.type = type;
	}
	//ת����
	public static Byte[] getByte(String s, int type){
		List<Byte> list = new ArrayList<Byte>();
		byte[] temp=s.getBytes();
		//֡��,���ݳ��ȼ��Ϲ̶��ĸ�ʽ��68H��30H����������ռ���ֽ���
		list.add((byte) (temp.length+6));
		//����68��30H
		list.add((byte)0x68);
		list.add((byte)0x30);
		//��������
		list.add((byte)type);
		//�������ݳ���
		list.add((byte)s.length());
		//������ݵ�ÿһλ
		for(Byte b:temp){
			list.add(b);
		}
		//���㡰У����֡�
		Integer sum = 0;
		for(Byte b:list){
			sum+=b;
		}
		sum-=list.get(0);
		//���ڽ���Ǵ��ڰ�λ����,��λ�����õ���һ����λ���ֽڱ�ʾ
		Integer ii=(sum>>8);
		Byte b2=ii.byteValue();
		list.add(b2);
		//ֱ��ȡgetByte�õ���ȡ���sum���ֽڱ�ʾ
		list.add(sum.byteValue());
		return list.toArray(new Byte[list.size()]);
		
	}
	//14-9-24�ոĶ�����ѹ������ֱ�ӷ������ֵ�ʮ��������
	public static byte[] getHexByte(String message) {
		if(null != message && !"".equals(message)){
			try {
				Double temp = Double.parseDouble(message);
				String s = Double.toHexString(temp);
				return s.getBytes();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	

}
