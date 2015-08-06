package com.chen.service;

import java.util.List;

import com.chen.entity.*;

public interface ManagerService {
	/*
	 * 验证登陆
	 */
	public String checkLogin(String username, String password);
	/*
	 * 查找一个管理员
	 */
	public Manager findManager(String HQL);
	
	/*
	 * 增加一个管理员
	 */
	public void saveManager(Manager m);
	/*
	 * 删除一个管理员
	 */
	public void delectManager(int id);
	/*
	 * 修改一个管理员
	 */
	public void updateManager(Manager m);
	/*
	 * 查询全部管理员
	 */
	public List<Manager> queryListManager();

}
