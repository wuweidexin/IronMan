package com.chen.service;

import java.util.List;
import com.chen.entity.Customer;
import com.chen.entity.Manager;

public interface ManagerService {
	void saveManager(Manager manager);
	void updateManager(Manager manager);
	void updateWithQuery(String HQL);
	void deleteManager(Manager manager);
	Manager findOneManager(String HQL);
	List findWithPage(int startRow, int pageSize, String HQL);
	int getRow();
}
