package com.chen.serviceImp;

import java.util.ArrayList;
import java.util.List;

import com.chen.dao.BaseDao;
import com.chen.daoImp.BaseDaoImp;
import com.chen.entity.Customer;
import com.chen.entity.Manager;
import com.chen.service.ManagerService;

public class ManagerServiceImp implements ManagerService{
	BaseDao dao = new BaseDaoImp();
	public void deleteManager(Manager manager) {
		dao.deleteObject(manager);
		
	}

	public Manager findOneManager(String HQL) {
		
		return (Manager)dao.findObject(HQL);
	}

	public List findWithPage(int startRow, int pageSize, String HQL) {
		List<Manager> list = new ArrayList<Manager>();
		list = dao.findList(HQL);
		return list;
	}

	public int getRow() {
		
		return 0;
	}

	public void saveManager(Manager manager) {
		dao.saveObject(manager);
		
	}

	public void updateManager(Manager manager) {
		dao.updateObject(manager);
		
	}

	public void updateWithQuery(String HQL) {
		dao.updateWithQuery(HQL);
		
	}

}
