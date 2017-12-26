package com.qhit.lh.g4.tmx.t3.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.qhit.lh.g4.tmx.t3.bean.Emp;
import com.qhit.lh.g4.tmx.t3.bean.UserInfo;
import com.qhit.lh.g4.tmx.t3.dao.BaseDao;
import com.qhit.lh.g4.tmx.t3.dao.impl.BaseDaoImpl;
import com.qhit.lh.g4.tmx.t3.service.BaseService;
import com.qhit.lh.g4.tmx.t3.utils.HibernateSessionFactory;

public class BaseServiceImpl implements BaseService {

	private BaseDao baseDao = new BaseDaoImpl();

	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		baseDao.add(obj);
	}

	@Override
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		baseDao.delete(obj);
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		baseDao.update(obj);
	}

	@Override
	public List<Object> queryAll(String tableName) {
		// TODO Auto-generated method stub
		return baseDao.queryAll(tableName);
	}

	@Override
	public Object getObjectById(Class clazz, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo login() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Emp> getEmpByName(String name) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select emp from Emp emp where emp.eName like :name";
		Query query = session.createQuery(hql);
		query.setString("name", name);
		
		
		return query.list();
	}
	

	@Override
	public UserInfo login(UserInfo user) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String hql = "select user from UserInfo user where user.uname = :name and user.upwd = pwd";
		Query query = session.createQuery(hql);
		query.setString("name", user.getUname());
		query.setString("pwd", user.getUpwd());
		
		List<UserInfo> result = query.list();
		return result.get(0);
	}

}
