package com.cissst.service;

import java.util.List;

import com.cissst.entity.TbUser;

/**
 * @模块名称：IndexPageAction(首页)
 * @开发人：
 * @功          能：管理IndexPageAction所有逻辑
 * @开发时间：
 */
public interface IndexPageService
{
	//查询一个对象
	public Object findObject(String str);
	//通过用户账号查找用户
	public TbUser findUser(TbUser tbUser);
	//通过用户id查找用户
	public TbUser findUser(int id);
	//全查一组对象
	public List<?> findWithPage(String tbName, String del, String str);
	//验证密码对不对
	public String checkLogin(TbUser tbUser);
	//查找最近新增的用会员
	public List<TbUser> findWithHireTime();
	
	public void updateObject(Object obj);
}
