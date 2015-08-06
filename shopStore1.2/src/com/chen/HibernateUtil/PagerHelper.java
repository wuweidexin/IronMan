package com.chen.HibernateUtil;
import javax.servlet.http.HttpServletRequest;
public class PagerHelper {
	 public static Pager getPager(HttpServletRequest httpServletRequest,
             int totalRows) {
//����pager�������ڴ���ҳ��
Pager pager = new Pager(totalRows);
//��Request�����л�ȡ��ǰҳ��
String currentPage = httpServletRequest.getParameter("currentPage");
//�����ǰҳ��Ϊ�գ���ʾΪ�״β�ѯ��ҳ
//�����Ϊ�գ���ˢ��pager�������뵱ǰҳ�ŵ���Ϣ
if (currentPage != null) {
pager.refresh(Integer.parseInt(currentPage));
}
//��ȡ��ǰִ�еķ�������ҳ��ǰһҳ����һҳ��βҳ��
String pagerMethod = httpServletRequest.getParameter("pageMethod");
if (pagerMethod != null) { 
if (pagerMethod.equals("first")) {
pager.first();}
else if (pagerMethod.equals("previous")){pager.previous();}
else if (pagerMethod.equals("next")){pager.next();} 
else if (pagerMethod.equals("last")) { pager.last();}}return pager;}

}
