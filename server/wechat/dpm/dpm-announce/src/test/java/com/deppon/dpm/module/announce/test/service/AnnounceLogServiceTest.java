package com.deppon.dpm.module.announce.test.service;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.announce.server.service.IAnnounceLogService;
import com.deppon.dpm.module.announce.shared.domain.AnnounceLogEntity;
import com.deppon.dpm.module.announce.test.BaseTestCase;

public class AnnounceLogServiceTest extends BaseTestCase{
	
	@Autowired
	private IAnnounceLogService announceLogService;
	
	@Test
	public void insert(){
		
		AnnounceLogEntity entity = new AnnounceLogEntity();
		entity.setRequestparam("测试1111");
		entity.setCreateTime(new Date());
		entity.setStatus("success");
		int num = announceLogService.insert(entity);
		System.out.println(num);
	}

}
