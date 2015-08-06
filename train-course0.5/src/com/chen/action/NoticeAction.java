package com.chen.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.chen.HibernateUtil.NumberUtil;
import com.chen.entity.Notice;
import com.chen.service.NoticeService;
import com.chen.serviceImp.NoticeServiceImp;

public class NoticeAction {
	NoticeService ns = new NoticeServiceImp();
	HttpServletRequest request = ServletActionContext.getRequest();
	NumberUtil num = new NumberUtil();
	/*
	 * 查询所有通知信息
	 */
	public String queryListNotice(){
		List<Notice> list = ns.queryListNotice();
		request.setAttribute("nList", list);
		return "queryListNotice";
	}
	/*
	 * 删除通知
	 */
	public String delectNotice(){
		int id = Integer.valueOf(request.getParameter("id"));
		ns.delectNotice(id);
		return queryListNotice();
	}
	
	public String addNotice(){
		Notice n = new Notice();
		n.setNNumber(num.getNoticeNo());
		n.setNTitle(request.getParameter("n_title"));
		n.setNContent(request.getParameter("n_content"));
		n.setNTime(request.getParameter("n_time"));
		n.setColumn6("1");
		ns.addNotice(n);
		return queryListNotice();
		
	}

}
