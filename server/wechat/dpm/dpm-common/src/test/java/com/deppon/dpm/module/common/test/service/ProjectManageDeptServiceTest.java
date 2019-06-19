package com.deppon.dpm.module.common.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.common.server.service.IProjectManageDeptService;
import com.deppon.dpm.module.common.shared.domain.ProjectManageDeptEntity;
import com.deppon.dpm.module.common.test.BaseTestCase;

public class ProjectManageDeptServiceTest extends BaseTestCase{
	
	@Autowired
	private IProjectManageDeptService projectManageDeptService;

	@Test
	public void testList() {
		projectManageDeptService.list(0, 5);
	}

	@Test
	public void testDelete() {
		ProjectManageDeptEntity entity = new ProjectManageDeptEntity();
		entity.setOrgcode("123456");
		entity.setOrgname("测试部门");
		projectManageDeptService.save(entity);
		projectManageDeptService.delete(entity);
	}

	@Test
	public void testQueryCount() {
		projectManageDeptService.queryCount();
	}

}
