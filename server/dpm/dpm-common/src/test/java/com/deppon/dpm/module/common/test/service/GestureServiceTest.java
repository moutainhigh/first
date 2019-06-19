package com.deppon.dpm.module.common.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.common.server.service.impl.GestureService;
import com.deppon.dpm.module.common.shared.domain.GestureEntity;
import com.deppon.dpm.module.common.test.BaseTestCase;

public class GestureServiceTest extends BaseTestCase{
	
	@Autowired
	private GestureService gestureService;

	@Test
	public void testQueryByEmpcode() {
		gestureService.queryByEmpcode("116250");
	}

	@Test
	public void testDeleteByEmpcode() {
		gestureService.deleteByEmpcode("116250");
	}

	@Test
	public void testUpdate() {
		GestureEntity entity = new GestureEntity();
		entity.setUserId("116250");
		entity.setGustureStatus("off");
		gestureService.update(entity);
	}

}
