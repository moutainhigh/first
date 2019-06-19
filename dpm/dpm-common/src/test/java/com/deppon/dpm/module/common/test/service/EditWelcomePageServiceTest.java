package com.deppon.dpm.module.common.test.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.common.server.service.IEditWelcomePageService;
import com.deppon.dpm.module.common.shared.domain.WelcomePageEntity;
import com.deppon.dpm.module.common.test.BaseTestCase;

public class EditWelcomePageServiceTest extends BaseTestCase{

	@Autowired
	private IEditWelcomePageService editWelcomePageService;
	
	/*@Test
	public void testSavePic(){
		
	}*/
	
	@Test
	public void testGetDetails(){
		List<WelcomePageEntity> list = editWelcomePageService.getDetails(null, true);
		for (WelcomePageEntity welcomePageEntity : list) {
			System.out.println(welcomePageEntity);
		}
	}
	
	@Test
	public void testDelWelcomePage(){
		int i = editWelcomePageService.delWelcomePage("7e1599fb-bfc4-4241-91d6-1ae6f003333e");
		System.out.println(i);
	}
	
	@Test
	public void testGetWelcomePageLinks(){
		editWelcomePageService.getWelcomePageLinks();
	}
	
	@Test
	public void testGetWelcomePageList(){
		editWelcomePageService.getWelcomePageList(0,3);
	}
	
	@Test
	public void testQueryCount(){
		editWelcomePageService.queryCount();
	}
}
