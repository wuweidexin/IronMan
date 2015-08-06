package com.chen.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ChenJunQuan
 * @version 2014-11-13 下午8:30:41
 */
public class MatchPhone {
	public static void main(String[] args) {
		String str = "ad ad";
		String regex = "(ad)*";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		boolean b = m.matches();
		System.out.println(b);
		while(m.find()){
			String temp = m.group();
			System.out.println(temp);
		}
	}

}
