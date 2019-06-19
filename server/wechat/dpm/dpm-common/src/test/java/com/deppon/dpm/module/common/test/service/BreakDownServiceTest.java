package com.deppon.dpm.module.common.test.service;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.common.server.service.IBreakDownService;
import com.deppon.dpm.module.common.shared.domain.BreakDownEntity;
import com.deppon.dpm.module.common.test.BaseTestCase;

public class BreakDownServiceTest extends BaseTestCase{

	@Autowired
	private IBreakDownService breakDownService;
	@Test
	public void testSaveBreakBownInfo() {
		BreakDownEntity entity = new BreakDownEntity();
		entity.setEmpCode("116250");
		entity.setOsType("IOS");
		entity.setOccurTime(new Date());
		entity.setReason("单元测试");
		entity.setVersion("3.5.9");
		breakDownService.saveBreakBownInfo(entity);
	}

}
