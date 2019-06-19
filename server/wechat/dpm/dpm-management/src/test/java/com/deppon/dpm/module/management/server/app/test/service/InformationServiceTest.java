package com.deppon.dpm.module.management.server.app.test.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.management.server.app.test.BaseTestCase;
import com.deppon.dpm.module.management.server.service.IInformationService;
import com.deppon.dpm.module.management.shared.domain.InformationSort;

public class InformationServiceTest extends BaseTestCase{
	
	@Autowired
	private IInformationService informationService;
	
	@Test
	public void testList(){
		String userId = "116250";
		List<InformationSort> list = informationService.list(userId);
		System.out.println(list.size());
	}
	
	@Test
	public void testSort(){
		String userId = "001201";
		String sortStr = "1,3,2,7,4";
		informationService.sort(userId, sortStr);
	}
	
	@Test
	public void testGetSort(){
		String userId1 = "116250";
		String sort1 = informationService.getSort(userId1);
		System.out.println(sort1);
		
		String userId2 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String sort2 = informationService.getSort(userId2);
		System.out.println(sort2);
	}

}
