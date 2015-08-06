package com.chen.service;

import java.util.List;

import com.chen.entity.Notice;

public interface NoticeService {
	public void addNotice(Notice n);
	public void delectNotice(int id);
	public Notice queryNotice(int id);
	public List<Notice> queryListNotice();
	public void updateNotice(Notice n);
}
