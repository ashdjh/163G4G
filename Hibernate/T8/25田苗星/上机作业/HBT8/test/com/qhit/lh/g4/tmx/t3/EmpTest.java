package com.qhit.lh.g4.tmx.t3;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.qhit.lh.g4.tmx.t3.bean.Dept;
import com.qhit.lh.g4.tmx.t3.bean.Emp;
import com.qhit.lh.g4.tmx.t3.bean.UserInfo;
import com.qhit.lh.g4.tmx.t3.utils.HibernateSessionFactory;

public class EmpTest {



	private Dept baseService;
	@Test
	public void add() {

		//注册新员工
		Emp emp = new Emp();
		emp.setEname("李梦阳");
		emp.setEsex("M");
		emp.setBirthday("2011-4-5");
		//分配账户
		UserInfo userinfo = new UserInfo();
		userinfo.setUname("lmy");
		userinfo.setUpwd("123456");
		//关联员工和账户
		emp.setUserinfo(userinfo);
		userinfo.setEmp(emp);
		//分配到某些部门
		Dept dept = (baseService).getObjectById(Dept.class,1);
		//进行员工部门多对一
		emp.setDept(dept);
		//数据操作
		baseService.add(emp);
	}
	//删除员工信息
	@Test
	public void delete(){

		Dept dept = (Dept)baseService.getObjectById(Dept.class,1);
		baseService.delete(dept);

	}
	//更新员工信息
	@Test
	public void update(){

		Dept dept = baseService.getObjectById(Dept.class, 1);
		dept.setAddress("中国北京");
		baseService.update(dept);
	}

	
	@Test
	public void getEmpByName(){

		List<Emp> result = baseService.getEmpByName("张%");
		for(Emp emp : result){
			System.out.println(emp.getEid()+":"+emp.getEname());
		}
	}
	@Test
	public void getEmplikeName(Object obj){
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
	@Test
	public void getEmpListName(){
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Emp.class)
				.add(Restrictions.like("ename", "张%"));
		ProjectionList pList = Projections.projectionList()
				.add(Projections.property("ename"))
				.add(Projections.property("ese"))
				.add(Projections.property("birthday"));
		criteria.setProjection(pList);
		for(Object[] o : (List<Object[]>)criteria.list()){
			
			System.out.println(o[0] + "," + o[1] + "," + o[2]);
			
		}
	}
	
	@Test
	public void getDeptCount(){
		
	}


}
