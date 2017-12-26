package com.qhit.lh.g4.tmx.t3;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qhit.lh.g4.tmx.t3.bean.Dept;
import com.qhit.lh.g4.tmx.t3.bean.Emp;
import com.qhit.lh.g4.tmx.t3.bean.UserInfo;

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

		
	}

