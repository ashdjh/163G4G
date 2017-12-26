package com.qhit.lh.g4.tmx.t3;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qhit.lh.g4.tmx.t3.bean.UserInfo;
import com.qhit.lh.g4.tmx.t3.service.BaseService;
import com.qhit.lh.g4.tmx.t3.service.impl.BaseServiceImpl;

public class UserInfoTest {

	private BaseService baseService = new BaseServiceImpl();
	@Test
	public void login() {
		//user对象，表单提交时自动封装成了action中的对象
		UserInfo user = new UserInfo();
		user.setUname("lmy");
		user.setUpwd("123456");
		
		user = baseService.login(user);
		if(user != null){
			System.out.println("成功");
		}else{
			System.out.println("失败");
		}
		
	}

}
