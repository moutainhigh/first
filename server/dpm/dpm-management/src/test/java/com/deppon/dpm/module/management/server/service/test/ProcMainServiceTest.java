package com.deppon.dpm.module.management.server.service.test;


import java.io.IOException;

import org.apache.commons.httpclient.HttpException;
import org.junit.Before;
import org.junit.Test;

import com.deppon.dpm.module.management.server.ApplicationTestXML;
import com.deppon.dpm.module.management.server.service.IProcMainService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity;

public class ProcMainServiceTest  extends JunitTest{

	ApplicationTestXML xml = new ApplicationTestXML();
	
	private IProcMainService service = null;
	
	@Before
	public void setUp(){
		this.service = (IProcMainService) xml.getBean("procMainService");
	}

	@Test
	public void postMessage()
			throws Exception {
		ProcMaintainEntity entity = new ProcMaintainEntity();
		entity.setAdminID("123");
		entity.setAdminName("test");
		try{
			this.service.postMessage(entity);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void getDeptMessageFromPC() throws HttpException, IOException {
		String proName = "";
		this.service.getDeptMessageFromPC(proName);
	}

	@Test
	public void getProList() throws HttpException, IOException {
		this.service.getProList();
	}

	public IProcMainService getService() {
		return service;
	}

	public void setService(IProcMainService service) {
		this.service = service;
	}

}
