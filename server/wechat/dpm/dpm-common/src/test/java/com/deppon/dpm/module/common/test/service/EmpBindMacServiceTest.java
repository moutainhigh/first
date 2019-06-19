package com.deppon.dpm.module.common.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.common.server.service.impl.EmpBindMacService;
import com.deppon.dpm.module.common.shared.domain.EmpBindMacEntity;
import com.deppon.dpm.module.common.test.BaseTestCase;

public class EmpBindMacServiceTest extends BaseTestCase{
	
	@Autowired 
	private EmpBindMacService empBindMacService;

	@Test
	public void testSave() {
		EmpBindMacEntity entity = new EmpBindMacEntity();
		entity.setEmpCode("116250");
		entity.setOsType("android");
		entity.setPhoneMac("123456789");
		empBindMacService.save(entity);
	}

	@Test
	public void testQueryEmpCodeByMacAndOstype() {
		EmpBindMacEntity entity = new EmpBindMacEntity();
		entity.setOsType("android");
		entity.setPhoneMac("123456789");
		empBindMacService.queryEmpCodeByMacAndOstype(entity);
	}

}
