package com.qhit.lh.g4.tmx.t3;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qhit.lh.g4.tmx.t3.bean.Role;
import com.qhit.lh.g4.tmx.t3.bean.UserInfo;
import com.qhit.lh.g4.tmx.t3.service.BaseService;
import com.qhit.lh.g4.tmx.t3.service.impl.BaseServiceImpl;

public class RoleTest {

	private BaseService baseService = new BaseServiceImpl();
	@Test
	public void add() {
		
		//新建角色
		Role role = new Role();
		role.setRolename("总理");
		role.setMemo("政治");
		//分配账户
		UserInfo userInfo = (UserInfo) baseService.getObjectById(UserInfo.class, 1);
		
		//建立多对多关系
		role.getUsers().add(userInfo);
		
		baseService.add(role);
		
	}
	@Test
	public void delete() {
		
		Role role = (Role) baseService.getObjectById(Role.class, 1);
		baseService.delete(role);
	}
	@Test
	public void update() {
		
		Role role = (Role) baseService.getObjectById(Role.class, 1);
		role.setMemo("党政军");
		
		UserInfo lmy = (UserInfo) baseService.getObjectById(UserInfo.class, 1);
		
		role.getUsers().add(lmy);
		
		baseService.update(role);
	}

}
