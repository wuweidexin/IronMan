package com.chen.service;

import java.util.List;

import com.chen.entity.Order;

public interface OrderService {
	void saveOrder(Order order);
	void deleteOrder(Order order);
	void updateOrder(Order order);
	void updateWithQuery(String HQL);
	Order findOneOrder(String HQL);
	List findWithPage(int startRow, int pageSize, String HQL);
	List findList(String HQL);
	int getRow();
}
