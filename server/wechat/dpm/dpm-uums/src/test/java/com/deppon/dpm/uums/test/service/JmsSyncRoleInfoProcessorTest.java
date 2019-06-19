package com.deppon.dpm.uums.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.uums.server.service.impl.JmsSyncRoleInfoProcessor;
import com.deppon.dpm.uums.test.BaseTestCase;
import com.deppon.dpm.uums.test.domain.SyncRoleInfoVo;
import com.deppon.esb.core.exception.ESBBusinessException;
import com.deppon.uums.inteface.domain.usermanagement.RoleInfo;

public class JmsSyncRoleInfoProcessorTest extends BaseTestCase{
	
	@Autowired
	private JmsSyncRoleInfoProcessor jmsSyncRoleInfoProcessor;
	
	@Test
	public void testProcess() throws ESBBusinessException{
		
		List<RoleInfo> roleInfoList = new ArrayList<RoleInfo>();
		RoleInfo roleInfo = new RoleInfo();
		roleInfo.setRoleId("0000ba78-45f3-42cc-b31b-05200712b6a7");
		roleInfo.setRoleName("总监1");
		roleInfo.setRoleBasCode("DPM005");
		roleInfo.setRoleEnCode("UTF-8");
		roleInfo.setRoleType("管理");
		roleInfo.setChangeType("1");
		roleInfo.setChangeDate(new Date());
		roleInfoList.add(roleInfo);
		SyncRoleInfoVo req = new SyncRoleInfoVo(roleInfoList);
		
		Object process = jmsSyncRoleInfoProcessor.process(req);
		System.out.println(process);
	}

}
