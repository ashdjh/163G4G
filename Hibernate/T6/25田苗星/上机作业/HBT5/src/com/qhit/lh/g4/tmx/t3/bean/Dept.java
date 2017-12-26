package com.qhit.lh.g4.tmx.t3.bean;

import java.io.Serializable;

import org.hibernate.Criteria;

public class Dept implements Serializable{

	private Integer deptId;
	private String deptName;
	private String address;
	
	
	
	
	
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

	public Criteria getEmps() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Dept dept) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Dept dept) {
		// TODO Auto-generated method stub
		
	}

	

}
