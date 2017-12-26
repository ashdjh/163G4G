package com.qhit.lh.g4.tmx.t3.bean;

import java.util.HashSet;
import java.util.Set;

public class Role {

	
	private Integer rolesId;
	private String rolename;
	private String memo;
	
	
	private Set<UserInfo> users = new HashSet<>();


	
	
	public Integer getRoles() {
		return rolesId;
	}



	public void setRoles(Integer roles) {
		this.rolesId = roles;
	}



	public String getRolename() {
		return rolename;
	}



	public void setRolename(String rolename) {
		this.rolename = rolename;
	}



	public String getMemo() {
		return memo;
	}



	public void setMemo(String memo) {
		this.memo = memo;
	}



	public Set<UserInfo> getUsers() {
		return users;
	}



	public void setUsers(Set<UserInfo> users) {
		this.users = users;
	}



	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Role(Integer roles, String rolename, String memo) {
		super();
		this.rolesId = roles;
		this.rolename = rolename;
		this.memo = memo;
	}



	public Role(Integer roles, String rolename, String memo,
			Set<UserInfo> users) {
		super();
		this.rolesId = roles;
		this.rolename = rolename;
		this.memo = memo;
		this.users = users;
	}
	
	
}
