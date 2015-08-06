package com.chen.HibernateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.chen.dao.BaseDao;
import com.chen.daoImp.BaseDaoImp;

public class NumberUtil {
	BaseDao baseDao = new BaseDaoImp();
	/**
	 * ��ñ��(	QN20120920001)
	 */

	//���ѧ�����
	public String getStuNo()
	{
		long temp =   baseDao.getRow("from Student where column10 = '1'");

		String stuNum = this.getNum("S",temp );

		return stuNum;
	}
	//��ð༶���
	public String getClaNo()
	{
		long temp =   baseDao.getRow("from Classes where column5 = '1'");

		String claNum = this.getNum("CL",temp );

		return claNum;
	}

	//��ÿγ�
	public String getCourseNo()
	{
		long temp =   baseDao.getRow("from Course where column5 = '1'");

		String courseNum = this.getNum("C",temp );

		return courseNum;
	}


	//�����ʦ���
	public String getTeaNo()
	{
		long temp =  baseDao.getRow("from Teacher where column5 = '1'");

		String teaNum = this.getNum("T",temp );

		return teaNum;
	}
	//��ù���
	public String getNoticeNo()
	{
		long temp =  baseDao.getRow("from Notice where column6='1'");

		String noticeNum = this.getNum("G",temp );

		return noticeNum;
	}


	//�����������й�����
	public String getNum(String str, long temp)
	{
		StringBuilder builder = new StringBuilder(str);

		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String date_str = format.format(d);
		builder.append(date_str);

		int countNo = (int)temp + 1;
		if(countNo<10) {
			builder.append("00");
			builder.append(countNo);
		} else if (countNo<100) {
			builder.append("0");
			builder.append(countNo);
		} else {
			builder.append(countNo);
		}

		String num = builder.toString();
		return num;
	}


}
