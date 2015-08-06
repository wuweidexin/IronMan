package com.chen.service;

import java.util.List;

import com.chen.entity.Book;

public interface BookService {
	void saveBook(Book book);
	void updateBook(Book book);
	void updateWithQuery(String HQL);
	void deleteBook(int id);
	Book findOneBook(String HQL);
	List findWithPage(int startRow, int pageSize, String HQL);
	List findList(String HQL);
	int getRow();
}
