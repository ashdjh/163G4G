package com.qhit.lh.g4.tmx.t3.bean;

import java.sql.Date;

public class Emp {

	private int eid;
	private String ename;
	private String esex;
	private Date birthday;
	private Integer deptid;
	
	
	public Integer getDeptid() {
		return deptid;
	}



	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}



	public Emp(Integer deptid) {
		super();
		this.deptid = deptid;
	}



	private UserInfo userinfo;
	


	public Integer getEid() {
		return eid;
	}



	public void setEid(int dept) {
		this.eid = dept;
	}



	public String getEname() {
		return ename;
	}



	public void setEname(String ename) {
		this.ename = ename;
	}



	public String getEsex() {
		return esex;
	}



	public void setEsex(String esex) {
		this.esex = esex;
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	public UserInfo getUserinfo() {
		return userinfo;
	}



	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}



	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Emp(Integer eid, String ename, String esex, Date birthday) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esex = esex;
		this.birthday = birthday;
	}



	public Emp(Integer eid, String ename, String esex, Date birthday,
			UserInfo userinfo) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esex = esex;
		this.birthday = birthday;
		this.userinfo = userinfo;
	}



	public void setBirthday(String string) {
		// TODO Auto-generated method stub
		
	}



	public void setDept(Dept dept) {
		// TODO Auto-generated method stub
		
	}



	
}
