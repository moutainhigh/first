package com.deppon.dpm.module.common.test.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.common.server.service.INazaInvokeMonitorService;
import com.deppon.dpm.module.common.shared.domain.NazaInvokeMonitorEntity;
import com.deppon.dpm.module.common.test.BaseTestCase;

public class NazaInvokeMonitorServiceImplTest extends BaseTestCase{
	
	@Autowired
	private INazaInvokeMonitorService nazaInvokeMonitorService;

	@Test
	public void testSave() {
		NazaInvokeMonitorEntity entity = new NazaInvokeMonitorEntity();
		entity.setUserId("116250");
		entity.setIp("127.0.0.1");
		entity.setPhoneModel("iPhone6,2");
		entity.setOsVersion("9.3.1");
		entity.setOsType("IOS");
		entity.setAppVersion("3.7.7");
		entity.setAppName("Wages");
		entity.setNetwork("WIFI");
		entity.setNetProvider("中国移动");
		entity.setServiceName("download");
		entity.setInvokeTime(500);
		entity.setErrorInfo("测试用例");
		nazaInvokeMonitorService.save(entity);
	}

	@Test
	public void testQueryByCondition() throws ParseException {
		NazaInvokeMonitorEntity entity = new NazaInvokeMonitorEntity();
		entity.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-06-16 00:00:00"));
		entity.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-06-17 00:00:00"));
		entity.setOsType("IOS");
		nazaInvokeMonitorService.queryByCondition(entity);
	}

}
