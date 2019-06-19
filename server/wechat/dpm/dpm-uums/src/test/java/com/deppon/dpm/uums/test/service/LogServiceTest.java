package com.deppon.dpm.uums.test.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.uums.server.service.ILogService;
import com.deppon.dpm.uums.server.vo.AppLogVo;
import com.deppon.dpm.uums.test.BaseTestCase;

public class LogServiceTest extends BaseTestCase{
	
	@Autowired
	private ILogService logService;
	
	@Test
	public void testSelect() throws ParseException{
		AppLogVo vo = new AppLogVo();
		vo.setStartTime(new SimpleDateFormat("yyyy-MM-dd").parse("2015-10-24"));
		vo.setEndTime(new SimpleDateFormat("yyyy-MM-dd").parse("2015-10-27"));
		AppLogVo select = logService.select(vo);
		System.out.println(select.getTotalCount());
		System.out.println(select.getLogList().size());
	}

}
