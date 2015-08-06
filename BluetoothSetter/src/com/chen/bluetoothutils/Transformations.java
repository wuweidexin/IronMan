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
	//转码类
	public static Byte[] getByte(String s, int type){
		List<Byte> list = new ArrayList<Byte>();
		byte[] temp=s.getBytes();
		//帧长,数据长度加上固定的格式（68H、30H。。。）所占的字节数
		list.add((byte) (temp.length+6));
		//加入68、30H
		list.add((byte)0x68);
		list.add((byte)0x30);
		//加入类型
		list.add((byte)type);
		//加入数据长度
		list.add((byte)s.length());
		//添加数据的每一位
		for(Byte b:temp){
			list.add(b);
		}
		//计算“校验和字”
		Integer sum = 0;
		for(Byte b:list){
			sum+=b;
		}
		sum-=list.get(0);
		//由于结果是大于八位的数,移位操作得到第一个八位的字节表示
		Integer ii=(sum>>8);
		Byte b2=ii.byteValue();
		list.add(b2);
		//直接取getByte得到截取后的sum的字节表示
		list.add(sum.byteValue());
		return list.toArray(new Byte[list.size()]);
		
	}
	//14-9-24日改动，绝压基数，直接发送数字的十六进制数
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
