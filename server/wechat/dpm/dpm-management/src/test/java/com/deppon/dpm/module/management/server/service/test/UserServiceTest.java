package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;

import com.deppon.dpm.module.management.server.ApplicationTestXML;
import com.deppon.dpm.module.management.server.service.impl.UserService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;


public class UserServiceTest  extends JunitTest{
	
	//public LoginUserVO getLoginUserVO(String userNo);
	ApplicationTestXML xml = new ApplicationTestXML();
	
	UserService service = null;
	
	@Before
	public void setUp(){
		this.service = (UserService) xml.getBean("userServiceMs");
	}
	
	@Test
	public void getLoginUserVO(){
		this.service.getLoginUserVO("039794");
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	
	

}
