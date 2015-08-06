package com.chen.service;

import java.util.List;
import com.chen.entity.Customer;

public interface CustomerService {
	void saveCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void updateWithQuery(String HQL);
	void deleteCustomer(Customer customer);
	Customer findOneCustomer(String HQL);
	List findWithPage(int startRow, int pageSize, String HQL);
	int getRow();
}
