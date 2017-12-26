package com.qhit.lh.g4.tmx.t3.bean;

public class UserInfo {

	private Integer uid;
	private String uname;
	private String upwd;
	
	private String Emp;
	

	
	
	public UserInfo(Integer uid, String uname, String upwd, String emp) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		Emp = emp;
	}



	public String getEmp() {
		return Emp;
	}



	public void setEmp(String emp) {
		Emp = emp;
	}



	public Integer getUid() {
		return uid;
	}



	public void setUid(Integer uid) {
		this.uid = uid;
	}



	public String getUname() {
		return uname;
	}



	public void setUname(String uname) {
		this.uname = uname;
	}



	public String getUpwd() {
		return upwd;
	}



	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}





	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UserInfo(Integer uid, String uname, String upwd) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
	}



	public UserInfo(Integer uid, String uname, String upwd, Emp emp) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		
	}



	public void setEmp(Emp emp2) {
		// TODO Auto-generated method stub
		
	}
	
	
}
