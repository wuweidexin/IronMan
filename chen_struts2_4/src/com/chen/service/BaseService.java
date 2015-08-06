package com.chen.service;

import java.util.List;

import com.chen.entity.Users;

public interface BaseService {
	List findWithPage();
	Users findOne(int id);
	Users findOne(String str);
}
