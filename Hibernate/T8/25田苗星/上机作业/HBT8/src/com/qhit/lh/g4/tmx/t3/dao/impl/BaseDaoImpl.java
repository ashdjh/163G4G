package com.qhit.lh.g4.tmx.t3.dao.impl;

import java.util.List;

import javax.xml.crypto.Data;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.g4.tmx.t3.bean.Emp;
import com.qhit.lh.g4.tmx.t3.bean.UserInfo;
import com.qhit.lh.g4.tmx.t3.dao.BaseDao;
import com.qhit.lh.g4.tmx.t3.utils.HibernateSessionFactory;

public class BaseDaoImpl implements BaseDao {

	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		//2,先获取session对象
		Session session = HibernateSessionFactory.getSession();
		//3,Hibernate是以事务驱动的ORM框架，需要开启事务
		Transaction ts = session.beginTransaction();
		//4,操作对象-->完成数据的CRUD
		session.save(obj);
		//5,提交事务
		ts.commit();
		//6,关闭session，释放资源
		HibernateSessionFactory.closeSession();
	}


	@Override
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		//2,先获取session对象
		Session session = HibernateSessionFactory.getSession();
		//3,Hibernate是以事务驱动的ORM框架，需要开启事务
		Transaction ts = session.beginTransaction();
		//4,操作对象-->完成数据的CRUD
		session.delete(obj);
		//5,提交事务
		ts.commit();
		//6,关闭session，释放资源
		HibernateSessionFactory.closeSession();
	}


	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		//2,先获取session对象
		Session session = HibernateSessionFactory.getSession();
		//3,Hibernate是以事务驱动的ORM框架，需要开启事务
		Transaction ts = session.beginTransaction();
		//4,操作对象-->完成数据的CRUD
		session.update(obj);
		//5,提交事务
		ts.commit();
		//6,关闭session，释放资源
		HibernateSessionFactory.closeSession();
	}


	@Override
	public List<Object> queryAll(String tableName) {
		// TODO Auto-generated method stub
		//2,先获取session对象
		Session session = HibernateSessionFactory.getSession();
		//3,Hibernate是以事务驱动的ORM框架，需要开启事务
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery(tableName);
		//4,查询
		List<Object> list = query.list();
		//5,提交事务
		ts.commit();
		//6,关闭session，释放资源
		HibernateSessionFactory.closeSession();
		return list;
		
	}


	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.xjl.t3.dao.BaseDao#getObjectById(java.lang.Class, int)
	 */
	@Override
	public Object getObjectById(Class clazz, int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Emp> getEmpByName(String tableName) {
		// TODO Auto-generated method stub
		BaseDao basedao = new BaseDaoImpl();
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select emp from Emp emp where emp.eName like :name";
		Query query = session.createQuery(hql);
		query.setString("name", hql);
		
	
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


	@Override
	public List<Object[]> getObjects(String hql1) {
		// TODO Auto-generated method stub
		BaseDao basedao = new BaseDaoImpl();
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select d.deptname ,count(e) from Dept d left join d.emps e group by d.deptname";
		List<Object[]> result = basedao.getObjects(hql);
		for(Object[] o : result){
			System.out.println(o[0] + "人数" + o[1]);
		}
		
		return null;
	}


	@Override
	public List getObjects(Data chedCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
