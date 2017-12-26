/**
 * 
 */
package com.qhit.lh.g4.tmx.t3.dao;

import java.util.List;

import javax.xml.crypto.Data;

import com.qhit.lh.g4.tmx.t3.bean.Emp;
import com.qhit.lh.g4.tmx.t3.bean.UserInfo;

public interface BaseDao {

	
	public void add(Object obj);
	public void delete(Object obj);
	public void update(Object obj);
	public List<Object> queryAll(String  tableName);
	public UserInfo login(UserInfo user);
	public List<Emp> getEmpByName(String  tableName);
	public Object getObjectById(Class clazz, int id);
	public List<Object[]> getObjects(String hql1);
	
	
	public List getObjects(Data chedCriteria );
}
