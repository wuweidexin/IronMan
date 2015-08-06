package com.chen.test;

import java.sql.Time;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author ChenJunQuan
 * @version 2014-5-12 上午9:47:52
 */
public class TTest {
	public static void main(String[] args) {
		// String fieldtext = "dsf, f, fds, ffds, fdsaf";
		// int tempIndex = fieldtext.indexOf(",");
		// String[] PKs;
		// String temp = "";
		// if(tempIndex != -1){
		// PKs = fieldtext.split(",");
		// for (int i = 0; i < PKs.length; i++) {
		// PKs[i] = PKs[i].trim();
		// temp = temp + PKs[i];
		// if(i < PKs.length-1){
		// temp = temp + ",";
		// }
		// }
		//
		// }else{
		// PKs = new String[]{fieldtext};
		// }
		// for (int i = 0; i < PKs.length; i++) {
		// System.out.println(PKs[i]);
		// }
		// System.out.println(temp);

		// String s =
		// "{$valueType=const,dataType=String,value=COUNT(DEL_SYS_DEPT.ID)$}";
		// // int start = s.indexOf("(");
		// // int end = s.indexOf(")");
		// // s.substring(45, 61);
		// // System.out.println(start + "--" + end+"--"+s.substring(46, 61));
		// int index = s.lastIndexOf("=")+1;
		// int start = s.indexOf("(");
		// System.out.println(s.substring(index, start));
		// String s =
		// "f41e5be9cef24673b73b27ffd7aa6f65:100100210102,c2feba29835445c88ed7c84c5e4a8e13:100100210102";
		// String s = "f41e5be9cef24673b73b27ffd7aa6f65:100100210102";
		// String[] ss = s.split(",");
		// for (int i = 0; i < ss.length; i++) {
		// System.out.println(ss[i]);
		// }
		// Map<String, Object> map = new HashMap<String, Object>();
		// map.put("1", "fdsfsdf");
		// map.put("1", "dfsdf");
		// System.out.println(map);
//		String xmlString = "<html>" + "<head>" + "<title>dom4j解析一个例子</title>"
//				+ "<script>" + "<username>yangrong</username>"
//				+ "<password>123456</password>" + "</script>" + "</head>"
//				+ "<body>" + "<result>0</result>" + "<form>"
//				+ "<banlce>1000</banlce>" + "<subID>36242519880716</subID>"
//				+ "</form>" + "</body>" + "</html>";
//		Document document = null;
//		try {
//			document = DocumentHelper.parseText(xmlString);
//		} catch (DocumentException e) {
//			e.printStackTrace();
//		}
//		Element mxGraphModel = document.getRootElement();
//
//		Iterator root = mxGraphModel.elementIterator("head");
//		while (root.hasNext()) {
//			Element temp = (Element) root.next();
//			Iterator shapeIterator = temp.elementIterator("script");
//			while (shapeIterator.hasNext()) {
//				Element shapeTemp = (Element) shapeIterator.next();
//				String sid = shapeTemp.attributeValue("sid");
//				if (sid == null || sid.equals("") ) {
//					String uuid = "fdsf";
//					shapeTemp.addAttribute("sid", uuid);
//				}
//			}
//		}
//		String xmls = mxGraphModel.asXML();
//		System.out.println(xmls);
		
//		String s = "varchar(32)";
//		String ss = "varchar";
		
//		String s = "date";
//		String ss = "datetime";
//		if(s.indexOf("(") != -1){
//			s = s.split("\\(")[0];
//		}
//		if(s.equals(ss)){
//			System.out.println("相等");
//		}else{
//			System.out.println("不相等");
//			
//		}
//		String s = "30.0";
//		
//		if(s.indexOf("/.") == -1){
//			System.out.println("存在小数点");
//		}else{
//
//			System.out.println("bb存在小数点");
//		}
//		DecimalFormat df=new DecimalFormat(); 
//		df.setMaximumFractionDigits(3);
//		System.out.println(new Double(df.format("0.1254556").toString()));
//		String value = "2012-12-12";
//		String dateFormat = "yyyy-MM-dd HH:mm:ss";
//		try {
//			//Date d = new Date(value);
//			
//			Date val = new SimpleDateFormat(dateFormat).parse(value);
//			System.out.println(val);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String a = "0.1";
//		int v = a.indexOf(".");
//		System.out.println(v);
//		List list = new ArrayList();
//		list.add(1);
//		list.add(2);
//		//System.out.println(list.size());
//		list.add(null);
//		list.add(null);
//		//System.out.println(list.size());
//		for(int i =list.size()-1; i >=2; i --){
//			list.set(i, list.get(i-2));
//			
//		}
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		//String ss = "select DEL_SYS_DEPT.ID, DEL_SYS_DEPT.PARENT_ID, DEL_SYS_DEPT.COMPANY_ID, DEL_SYS_DEPT.CODE, DEL_SYS_DEPT.NAME, DEL_SYS_DEPT.GRADE, DEL_SYS_DEPT.SORT_NUM, DEL_SYS_DEPT.SEQ, DEL_SYS_DEPT.LEAF, DEL_SYS_DEPT.STATUS, DEL_SYS_DEPT.DEL_STATUS from DEL_SYS_DEPT  where 1=1 [and  DEL_SYS_DEPT.NAME='{$valueType=pageElem,type=String,value=2c92944246a7594a0146a890b4b00016#eb87f0d491d74eda8ec5e0325f597e30$}'] [and DEL_SYS_DEPT.CODE='{$valueType=pageElem,type=String,value=2c92944246a7594a0146a890b4b00016#feae770afe944ccda5e1274156427f76$}'] order by DEL_SYS_DEPT.SORT_NUM";
		//String ss = "select DEL_SYS_DEPT.ID, DEL_SYS_DEPT.PARENT_ID, DEL_SYS_DEPT.COMPANY_ID, DEL_SYS_DEPT.CODE, DEL_SYS_DEPT.NAME, DEL_SYS_DEPT.GRADE, DEL_SYS_DEPT.SORT_NUM, DEL_SYS_DEPT.SEQ, DEL_SYS_DEPT.LEAF, DEL_SYS_DEPT.STATUS, DEL_SYS_DEPT.DEL_STATUS from DEL_SYS_DEPT  where 1=1 [and  DEL_SYS_DEPT.NAME=\'{$valueType=pageElem,type=String,value=2c92944246a7594a0146a890b4b00016#eb87f0d491d74eda8ec5e0325f597e30$}\'] [and DEL_SYS_DEPT.CODE=\'{$valueType=pageElem,type=String,value=2c92944246a7594a0146a890b4b00016#feae770afe944ccda5e1274156427f76$}\'] order by DEL_SYS_DEPT.SORT_NUM";
//		String ss = "\'0\'";
//		String ss = "\\'china\\'";
		//String ss = "'0'";
//		Pattern pat=Pattern.compile("\\{\\$(.*?)\\$\\}");
//		Matcher mat = pat.matcher(ss);
//		while(mat.find()){
//			System.out.println(mat.group());
//			ss = ss.replace("'"+mat.group()+"'", "\\'"+mat.group()+"\\'");
//		}
//		
//		int index = ss.indexOf("\'");
//		
//		
//		ss = ss.replace("\\", "");
//		System.out.println(ss);
//		System.out.println();
//		String s = "fdsafsdf.fdsfsd.dfsd.fdssd";
//		String[] ss1 = s.split("\\.");
//		System.out.println(ss1);
//		String s= "select SYS_COMPANY.ID, SYS_COMPANY.PARENT_ID, SYS_COMPANY.CODE, SYS_COMPANY.NAME, SYS_COMPANY.SIMPLE_NAME, SYS_COMPANY.COMPANY_GRADE, SYS_COMPANY.GRADE, SYS_COMPANY.SEQ, SYS_COMPANY.SORT_NUM, SYS_COMPANY.LEAF, SYS_COMPANY.STATUS, SYS_COMPANY.DEL_STATUS  from SYS_COMPANY where  ((SYS_COMPANY.PARENT_ID is null or SYS_COMPANY.PARENT_ID = '')  or  (SYS_COMPANY.PARENT_ID = '{$parentId}')) and SYS_COMPANY.DEL_STATUS='0'";
//		s =s.replace("{$parentId}", "fdsafdfsdfds");
//		System.out.println(s);
//		String[] a = new String[]{"d"};
//		System.out.println(a[1]);
		//String temp ="Shang \\'Hai\\' Hong \\'Qiao\\' Fei 'Ji' Chang";
//		String temp ="Shang Hai Hong Qiao Fei 'Ji' 'Chang'";
//		String temp ="Shang Hai Hong Qiao \\Fei \\Ji Chang";
//		String temp = "sdsfdddfrsfs";
//		String value = temp;
//		String val = "dd";
//		String regEx = "^.(?i)(" + val+")";
//		Pattern pat = Pattern.compile(regEx);
//		Matcher mat = pat.matcher(value);
//		boolean rs = mat.find();
//		if(!rs){
//			value = value.replace("'", "\\'");
//		}
//		System.out.println(value);
//		String str = "Shang \\'Hai\\' Hong \\'Qiao\\' Fei 'Ji' Chang";
//		Pattern p = Pattern.compile("[^\\\\]'");
//		Matcher m = p.matcher(str);
//		boolean b = m.find();
//		while(m.find()) {
//			
//			MatchResult mr = m.toMatchResult();
//			System.out.println(m.group());
////			System.out.println(str.substring(mr.start(), mr.end()));
//		}
		/*String str = " 'Ji' Chang '' and \'day\'";
		str = str.replace("''", "\\'\\'");
		int firInd = str.indexOf("'");
		if(firInd == 0){
			str = "\\'" + str.substring(1);
		}
		Pattern p = Pattern.compile("[^\\\\]'");
		Matcher m = p.matcher(str);
		String s ="";
		String temps = "";
		int i = 0; 
		while(m.find()) {
			MatchResult mr = m.toMatchResult();
			int st = mr.start();
			int en = mr.end();
			s = mr.group();
			temps = s.replace("'", "\\'");
			String ss = str.substring(0, st+i);
			String sss = str.substring(en+i);
			str = ss + temps + sss;
			i ++ ;
			
		}
		System.out.println(str);*/
		
		int i = 3;
		if(i ==3){
			throw new RuntimeException("错误，i值不能为3");
		}
		System.out.println("Hello Java");
	}

}
