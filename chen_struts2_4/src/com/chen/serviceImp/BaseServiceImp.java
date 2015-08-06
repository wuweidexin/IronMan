package com.chen.serviceImp;

import java.util.List;

import com.chen.dao.BaseDao;
import com.chen.daoImp.BaseDaoImp;
import com.chen.entity.Users;
import com.chen.service.BaseService;

public class BaseServiceImp implements BaseService{
	BaseDao baseDao = new BaseDaoImp();
	String HQL = null;
	public List findWithPage() {
		HQL = "from Users";
		return baseDao.findWithPage(HQL);
	}
	public Users findOne(int id) {
		HQL = "from Users where id="+id;
		return (Users) baseDao.findOne(HQL);
	}
	public Users findOne(String str) {
		HQL = "from Users as a where a.userName='"+str+ "'";
		Users user = new Users();
		user = (Users) baseDao.findOne(HQL);
		System.out.println(user.getPassWord());
		return user;
	}

}
