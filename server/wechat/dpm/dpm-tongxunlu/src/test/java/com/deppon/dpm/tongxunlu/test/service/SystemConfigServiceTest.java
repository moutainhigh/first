package com.deppon.dpm.tongxunlu.test.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.tongxunlu.server.service.ISystemConfigService;
import com.deppon.dpm.tongxunlu.shared.domain.MonitorTime;
import com.deppon.dpm.tongxunlu.shared.vo.SystemConfig;
import com.deppon.dpm.tongxunlu.test.BaseTestCase;

public class SystemConfigServiceTest extends BaseTestCase{
	
	@Autowired
	private ISystemConfigService systemConfigService;
	
	@Test
	public void testQuerySingleSystemConfig(){
		SystemConfig param = new SystemConfig();
		param.setId(1);
		SystemConfig config = systemConfigService.querySingleSystemConfig(param);
		System.out.println(config);
	}
	
	@Test
	public void testUpdateSyncDateByLastSyncDate() throws ParseException{
		Date oldLastSynDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2015-10-23 13:58:29");
		Date newLastSynDate = new Date();
		int i = systemConfigService.updateSyncDateByLastSyncDate(oldLastSynDate, newLastSynDate);
		System.out.println(i);
	}
	
	@Test
	public void testFunctionAccessMonitor(){
		systemConfigService.functionAccessMonitor("116250", "201", "android");
	}
	
	@Test
	public void testDataMonitorTime(){
		MonitorTime monitorTime = new MonitorTime();
		monitorTime.setEmpCode("116250");
		monitorTime.setMonitorType("201");
		monitorTime.setOsType("android");
		monitorTime.setBeginTime(DateUtils.addHours(new Date(), -1));
		monitorTime.setEndTime(new Date());
		monitorTime.setTotalDuration("60");
		systemConfigService.dataMonitorTime(monitorTime);
	}
	
	@Test
	public void testDataMonitorDownload(){
		systemConfigService.dataMonitorDownload("116250", 13, 1, "ios");
	}

}
