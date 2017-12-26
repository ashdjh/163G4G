package com.qhit.lh.g4.tmx.t3.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Dept implements Serializable{

	private Integer deptId;
	private String deptName;
	private String address;
	
	
	//1-n的关联：当前部门有哪些员工
	private Set<Emp> emps;
	
	
	
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	public Dept() {
		super();
		
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Dept getObjectById(Class<Dept> class1, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(Emp emp) {
		// TODO Auto-generated method stub
		
	}

	public Dept getEmps() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Dept dept) {
		// TODO Auto-generated method stub
		
	}

	public void update(Dept dept) {
		// TODO Auto-generated method stub
		
	}

	

}
