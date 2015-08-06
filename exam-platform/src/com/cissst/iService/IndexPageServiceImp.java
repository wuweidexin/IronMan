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
 * @模块名称：IndexPageAction(首页)
 * @开发人：
 * @功          能：管理IndexPageAction所有逻辑
 * @开发时间：2012-8-23
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
	//查询一个对象
	public Object findObject(String str) {
		// TODO Auto-generated method stub
		return null;
	}
	//通过用户账号来查找用户
	public TbUser findUser(TbUser tbUser) {
		String HQL	= "from TbUser where UDel='0' and UAccount='"+tbUser.getUAccount()+"'";
		return (TbUser) indexPageDao.findByHQL(HQL);
	}
	//通过用户id查找用户
	public TbUser findUser(int id) {
		String HQL	= "from TbUser where UDel='0' and UId="+id;
		return (TbUser) indexPageDao.findByHQL(HQL);
	}
	
	
	//全查一组对象
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
	
	//验证密码对不对
	public String checkLogin(TbUser tbUser) {
		
		//查找数据库中该用户名的用户
		TbUser findUser = this.findUser(tbUser);
		//如果该用户名的用户不存在
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
		//如果该用户名 的用户存在
		else
		{
			ServletActionContext.getRequest().setAttribute("unkown", "unkown");
			return "UNKOWN";
		}
		
	}
	//修改密码
	public void updateObject(Object obj)
	{
		indexPageDao.update(obj);
	}
	
	
	//查找最近新增的用会员
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
