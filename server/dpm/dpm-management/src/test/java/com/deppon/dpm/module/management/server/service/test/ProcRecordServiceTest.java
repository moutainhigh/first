package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;

import com.deppon.dpm.module.management.server.ApplicationTestXML;
import com.deppon.dpm.module.management.server.service.IProcRecordService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class ProcRecordServiceTest  extends JunitTest{

	ApplicationTestXML xml = new ApplicationTestXML();
		
	private IProcRecordService service = null;
	
	@Before
	public void setUp(){
		this.service = (IProcRecordService) xml.getBean("procRecordService");
	}
	
	@Test
	public void getCheckTaskPage() {
		int pageNum = 0;
		int pageSize = 5;
		String deptName = "";
		String userId = "";
		this.service.getCheckTaskPage(pageNum, pageSize, deptName, userId);
	}

	@Test
	public void getCount() {
		String deptName = "";
		String userId = "";
		this.service.getCount(deptName, userId);
	}

	@Test
	public void getTaskToPC() {
		String number = "";
		this.service.getTaskToPC(number);
	}

	@Test
	public void getTaskForPC() {
		String json = "";
		this.service.getTaskForPC(json);
	}

	@Test
	public void getTaskSubmitEntity() {
		String number = "";
		this.service.getTaskSubmitEntity(number);
	}


}
