package com.chen.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chen.test.dao.UserDao;
import com.chen.test.model.User;
import com.chen.test.service.UserService;
@Service(value="userService")
public class UserServiceImpl implements UserService{
	
	UserDao userDao;
	@Transactional
	public List<User> findAllUser(){
		return userDao.findAllUser();
	}
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
