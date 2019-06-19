package com.deppon.dpm.module.common.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.test.BaseTestCase;

public class RedisServiceTest extends BaseTestCase{
	
	@Autowired
	private RedisService redisService;
	
	@Test
	public void testSet() {
		redisService.set("abc", "123");
	}

	@Test
	public void testExpire() {
		redisService.set("abc", "123", 60*60*2);
	}

	@Test
	public void testGet() {
		redisService.get("abc");
	}

	@Test
	public void testDel() {
		redisService.del("abc");
	}

}
