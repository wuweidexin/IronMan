package com.chen.test.dao;

import java.util.List;

import com.chen.test.model.User;

public interface UserDao{
	List<User> findAllUser();
}
