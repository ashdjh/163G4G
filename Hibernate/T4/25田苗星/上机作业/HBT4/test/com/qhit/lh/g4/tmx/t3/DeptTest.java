package com.qhit.lh.g4.tmx.t3;

import static org.junit.Assert.*;

import javax.sql.rowset.BaseRowSet;

import org.junit.Test;

import com.qhit.lh.g4.tmx.t3.bean.Dept;
import com.qhit.lh.g4.tmx.t3.bean.Emp;
import com.qhit.lh.g4.tmx.t3.bean.UserInfo;
import com.qhit.lh.g4.tmx.t3.service.BaseService;
import com.qhit.lh.g4.tmx.t3.service.impl.BaseServiceImpl;

public class DeptTest {
	
	private BaseService baseService = new BaseServiceImpl();

		@Test
		public void add(){
			//新建部门
			Dept dept = new Dept();
			dept.setDeptName("国防部");
			dept.setAddress("北京");
			
			//没有员工
			//有员工：1，从老员工中调用
			Emp emp1 = (Emp) baseService.getObjectById(Emp.class, 1);
			dept.getEmps().add(emp1);
			
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
			dept.getEmps().add(emp2);
			//数据操作
			baseService.add(dept);
			
			
		}
		@Test
		public void delete(){
			
			Dept dept = (Dept) baseService.getObjectById(Dept.class, 1);
			baseService.delete(dept);
		}
		@Test
		public void update(){
			
			Dept dept = (Dept) baseService.getObjectById(Dept.class, 1);
			dept.setAddress("中国东京");
			baseService.update(dept);
		}
		@Test
		public void query(){
			
			Dept dept = (Dept) baseService.getObjectById(Dept.class, 1);
			for(Emp emp : dept.getEmps()){
				System.out.println(dept.getDeptName()+":"+emp.getEname());
			}
		}
	}


