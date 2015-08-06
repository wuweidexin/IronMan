package com.cissst.iService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import com.cissst.dao.IndexPageDao;
import com.cissst.entity.TbUser;
import com.cissst.service.IndexPageService;
import com.opensymphony.xwork2.ActionInvocation;
import com.sun.net.httpserver.Authenticator.Success;
/**
 * @ģ�����ƣ�IndexPageAction(��ҳ)
 * @�����ˣ�
 * @��          �ܣ�����IndexPageAction�����߼�
 * @����ʱ�䣺2012-8-23
 */
public class IndexPageServiceImp implements IndexPageService
{
	private IndexPageDao indexPageDao;

	public IndexPageDao getIndexPageDao()
	{
		return indexPageDao;
	}

	public void setIndexPageDao(IndexPageDao indexPageDao)
	{
		this.indexPageDao = indexPageDao;
	}
	//��ѯһ������
	public Object findObject(String str) {
		// TODO Auto-generated method stub
		return null;
	}
	//ͨ���û��˺��������û�
	public TbUser findUser(TbUser tbUser) {
		String HQL	= "from TbUser where UDel='0' and UAccount='"+tbUser.getUAccount()+"'";
		return (TbUser) indexPageDao.findByHQL(HQL);
	}
	//ͨ���û�id�����û�
	public TbUser findUser(int id) {
		String HQL	= "from TbUser where UDel='0' and UId="+id;
		return (TbUser) indexPageDao.findByHQL(HQL);
	}
	
	
	//ȫ��һ�����
	public List<?> findWithPage(String tbName, String del, String str)
	{
		String HQL = null;
		if(str!=null)
		{
			HQL = "from "+tbName+" where "+del+" = '"+"0"+"'"+str;
		}
		else
		{
			HQL = "from "+tbName+" where "+del+" = '"+"0"+"'";
		}
		
		List<?> list = indexPageDao.findList(HQL);
		ServletActionContext.getRequest().getSession().setAttribute("HQL", HQL);
		return list;
		
	}
	
	//��֤����Բ���
	public String checkLogin(TbUser tbUser) {
		
		//�������ݿ��и��û������û�
		TbUser findUser = this.findUser(tbUser);
		//������û������û�������
		if(null != findUser)
		{
			if(findUser.getUPwd().equalsIgnoreCase(tbUser.getUPwd()))
			{
				ServletActionContext.getRequest().getSession().setAttribute("user", findUser);
				return "SUCCESS";
			}
			else
			{
				ServletActionContext.getRequest().setAttribute("unsuccess", "unsuccess");
				return "UNSUCCESS";
			}
		}
		//������û��� ���û�����
		else
		{
			ServletActionContext.getRequest().setAttribute("unkown", "unkown");
			return "UNKOWN";
		}
		
	}
	//�޸�����
	public void updateObject(Object obj)
	{
		indexPageDao.update(obj);
	}
	
	
	//��������������û�Ա
	public List<TbUser> findWithHireTime() {
	
		List<TbUser> list = (List<TbUser>) findWithPage("TbUser", "UDel", null);
		List<TbUser> li = new ArrayList<TbUser>();
		SimpleDateFormat s =  new SimpleDateFormat("yyyyMMdd");
		int date = Integer.valueOf(s.format(new java.util.Date()));
		for(int i=0; i<list.size(); i++)
		{
			TbUser t = list.get(i);
			int dateH =Integer.valueOf(s.format(t.getUHiretime()));
			if(date-dateH>5)
			{
				
			}
			
		}
		return null;
	}

	
	
}
