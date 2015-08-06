package com.chen.service;

import java.util.List;

import com.chen.entity.*;

public interface ManagerService {
	/*
	 * ��֤��½
	 */
	public String checkLogin(String username, String password);
	/*
	 * ����һ������Ա
	 */
	public Manager findManager(String HQL);
	
	/*
	 * ����һ������Ա
	 */
	public void saveManager(Manager m);
	/*
	 * ɾ��һ������Ա
	 */
	public void delectManager(int id);
	/*
	 * �޸�һ������Ա
	 */
	public void updateManager(Manager m);
	/*
	 * ��ѯȫ������Ա
	 */
	public List<Manager> queryListManager();

}
