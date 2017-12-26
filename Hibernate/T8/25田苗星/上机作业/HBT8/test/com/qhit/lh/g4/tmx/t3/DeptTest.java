package com.qhit.lh.g4.tmx.t3;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.junit.Test;

import com.qhit.lh.g4.tmx.t3.bean.Dept;
import com.qhit.lh.g4.tmx.t3.bean.Emp;
import com.qhit.lh.g4.tmx.t3.bean.UserInfo;
import com.qhit.lh.g4.tmx.t3.service.BaseService;
import com.qhit.lh.g4.tmx.t3.service.impl.BaseServiceImpl;
import com.qhit.lh.g4.tmx.t3.utils.HibernateSessionFactory;

public class DeptTest {

	private BaseService baseService = new BaseServiceImpl();
	//添加部门
	@Test
	public void add(){
		Dept dept = new Dept();
		dept.setDeptName("国防部");
		dept.setAddress("北京");
		
		//没有员工
		//有员工：1，从老员工中调用
		Emp emp1 = (Emp) baseService.getObjectById(Emp.class, 1);
		dept.getEmps().add((Criterion) emp1);
		
		//有员工：2，招聘新员工
		Emp emp2 = new Emp();
		emp2.setEname("王城翔");
		emp2.setEsex("M");
		emp2.setBirthday("2017-01-01");
		//有员工，分配账户
		UserInfo user2 = new UserInfo();
		user2.setUname("wcx");
		user2.setUpwd("123456");
		//1-1关联
		emp2.setUserinfo(user2);
		user2.setEmp(emp2);
		baseService.add(emp2);
		//n-1关联
		emp2.setDept(dept);
		//1-n关联
		dept.getEmps().add((Criterion) emp2);
		//数据操作
		baseService.add(dept);
	}
	@Test
	public void getDeptInfo(){

		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Dept.class)
				.setFetchMode("emps", FetchMode.JOIN)
				.createAlias("emps", "e");

		ProjectionList pList = Projections.projectionList()
				.add(Projections.groupProperty("deptId"))
				.add(Projections.groupProperty("deptName"))
				.add(Projections.groupProperty("address"))
				.add(Projections.groupProperty("e.oid"));	
		criteria.setProjection(pList);
		List<Object[]> list = criteria.list(); 
		for(Object[] obj : list){
			System.out.println(obj[0] + "|"+obj[1] + "|"+obj[2] + "|" + obj[3]);
		}
	}
}


