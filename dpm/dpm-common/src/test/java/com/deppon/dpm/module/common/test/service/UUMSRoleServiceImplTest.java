package com.deppon.dpm.module.common.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.common.server.service.IUUMSRoleService;
import com.deppon.dpm.module.common.test.BaseTestCase;

public class UUMSRoleServiceImplTest extends BaseTestCase{

	@Autowired
	private IUUMSRoleService uUMSRoleService;
	@Test
	public void testGetRoles() {
		uUMSRoleService.getRoles("116250");
	}

}
