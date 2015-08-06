package com.cissst.service;

import java.util.List;

import com.cissst.entity.TbUser;

/**
 * @ģ�����ƣ�IndexPageAction(��ҳ)
 * @�����ˣ�
 * @��          �ܣ�����IndexPageAction�����߼�
 * @����ʱ�䣺
 */
public interface IndexPageService
{
	//��ѯһ������
	public Object findObject(String str);
	//ͨ���û��˺Ų����û�
	public TbUser findUser(TbUser tbUser);
	//ͨ���û�id�����û�
	public TbUser findUser(int id);
	//ȫ��һ�����
	public List<?> findWithPage(String tbName, String del, String str);
	//��֤����Բ���
	public String checkLogin(TbUser tbUser);
	//��������������û�Ա
	public List<TbUser> findWithHireTime();
	
	public void updateObject(Object obj);
}
