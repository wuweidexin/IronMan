package com.chen.serviceImp;

import java.util.List;

import com.chen.dao.BaseDao;
import com.chen.daoImp.BaseDaoImp;
import com.chen.entity.Notice;
import com.chen.service.NoticeService;

public class NoticeServiceImp implements NoticeService{
	BaseDao baseDao = new BaseDaoImp();
	public void addNotice(Notice n) {
		baseDao.saveObject(n);
		
	}

	public void delectNotice(int id) {
		
		Notice n = queryNotice(id);
		n.setColumn6("0");
		baseDao.updateObject(n);
	}

	public List<Notice> queryListNotice() {
		String HQL = "from Notice where column6 = '1'";
		
		return (List<Notice>)baseDao.findList(HQL);
	}

	public Notice queryNotice(int id) {
		String HQL = "from Notice where column6='1' and NId="+id;
		
		return (Notice) baseDao.findObject(HQL);
	}

	public void updateNotice(Notice n) {
		baseDao.updateObject(n);
	}

}
