package com.deppon.dpm.module.common.test.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.common.server.service.IMonitorCountInfoService;
import com.deppon.dpm.module.common.test.BaseTestCase;

public class MonitorCountInfoServiceTest extends BaseTestCase{
	
	@Autowired
	private IMonitorCountInfoService monitorCountInfoService;
	
	@Test
	public void testSaveMonitorCountInfo() throws ParseException{
		String userId  = "252520";
		Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse("2015-08-01");
		Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse("2015-10-27");
		int type = 42;
		int i = monitorCountInfoService.saveMonitorCountInfo(userId, startDate, endDate, type);
		System.out.println(i);
		
	}
	
	@Test
	public void testSaveClackCountInfo(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", "939210");
		map.put("startDt", new Date());
		map.put("endDt", new Date());
		map.put("type", 43);
		map.put("billNo", "测试");
		map.put("count", 5);
		int i = monitorCountInfoService.saveClackCountInfo(map);
		System.out.println(i);
	}
	
	@Test
	public void testQueryCountInfoCount(){
		int i = monitorCountInfoService.queryCountInfoCount("测试");
		System.out.println(i);
	}

}
