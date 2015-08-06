package com.chen.service;

import java.util.List;

import com.chen.entity.Book;
import com.chen.entity.ShoppingCart;

public interface ShoppingCartService {
	void saveOneRecord(ShoppingCart shoppingCar);
	void updateOneRecord(ShoppingCart shoppingCar);
	void updateWithQuery(String HQL);
	void deleteOneRecord(int id);
	void deleteAllRecord();
	ShoppingCart findOneRecord(String HQL);
	List findWithPage(int startRow, int pageSize, String HQL);
	List findList(String HQL);
	int getRow();
}
