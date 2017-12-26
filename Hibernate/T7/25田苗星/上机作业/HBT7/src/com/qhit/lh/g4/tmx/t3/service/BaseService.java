package com.qhit.lh.g4.tmx.t3.service;

import java.util.List;

import com.qhit.lh.g4.tmx.t3.bean.UserInfo;

public interface BaseService {

	public void add(Object obj);
	public void delete(Object obj);
	public void update(Object obj);
	public List<Object> queryAll(String tableName);
	public Object getObjectById(Class clazz,int id);
	public UserInfo login();
	public UserInfo login(UserInfo user);
}
