package com.chen.serviceImp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.chen.dao.BaseDao;
import com.chen.daoImp.BaseDaoImp;
import com.chen.entity.Manager;
import com.chen.entity.Student;
import com.chen.service.ManagerService;
import com.chen.service.StuService;

public class ManagerServiceImp implements ManagerService{
	BaseDao baseDao = new BaseDaoImp();
	/*
	 * ��֤��½��Ϣ
	 * @see com.chen.service.StuService#checkLogin()
	 */
	HttpServletRequest re = ServletActionContext.getRequest();
	
	public String checkLogin(String username, String password) {
		String HQL = "from Manager where column5 = '1' and  MNumber = '"+username+"'";
		Manager man = (Manager) baseDao.findObject(HQL);
		if(man != null)
		{
			//�������
			if( !man.getMPwd().endsWith(password))
			{
				return "pwdError";
			}else
			{
				//������ȷ
				re.getSession().setAttribute("muser", man);
				return "mPwdCorrect";
			}
			
		}else
		{
			//��ѯ���Ϊ�գ������û�������
			return "inexistence";
		}
		
	}
	public Manager findManager(String HQL) {
		Manager  m = (Manager)baseDao.findObject(HQL);
		return m;
	}
	public void delectManager(int id) {
		String HQL = "from Manager where column5 = '1' and   MId="+ id;
		Manager mm = (Manager) baseDao.findObject(HQL);
		mm.setColumn5("0");
		
		baseDao.updateObject(mm);
	}
	public void saveManager(Manager m) {
		baseDao.saveObject(m);
	}
	public void updateManager(Manager m) {
		baseDao.updateObject(m);
	}
	public List<Manager> queryListManager() {
		String HQL = "from Manager where column5 = '1'";
		List<Manager> lm = (List<Manager>)baseDao.findList(HQL);
		return lm;
	}

}
