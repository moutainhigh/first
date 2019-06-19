package com.deppon.dpm.module.common.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.common.server.service.impl.SmsService;
import com.deppon.dpm.module.common.shared.domain.SmsEntity;
import com.deppon.dpm.module.common.test.BaseTestCase;

public class SmsServiceTest extends BaseTestCase{
	
	@Autowired
	private SmsService smsService;

	@Test
	public void testQueryByEmpcode() {
		smsService.queryByEmpcode("116250");
	}

	@Test
	public void testDelete() {
		smsService.delete(1);
	}

	@Test
	public void testUpdate() {
		SmsEntity entity = new SmsEntity();
		entity.setId(1);
		entity.setSmsStatus("on");
		smsService.update(entity);
	}

	@Test
	public void testInsert() {
		SmsEntity entity = new SmsEntity();
		entity.setUserId("11625");
		entity.setSmsStatus("off");
		entity.setDeviceToken("123456789");
		smsService.insert(entity);
	}

}
