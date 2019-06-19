package com.deppon.dpm.module.management.server.app.test.service;

import java.util.Date;

import javax.ws.rs.core.Response;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.management.server.app.test.BaseTestCase;
import com.deppon.dpm.module.management.server.service.IAppraiseService;
import com.deppon.dpm.module.management.shared.domain.AppraiseEntity;

public class AppraiseServiceTest extends BaseTestCase{
	
	@Autowired
	private IAppraiseService appraiseService;
	
	@Test
	public void testAppraiseCommit() throws Exception{
		AppraiseEntity requestParam = new AppraiseEntity();
		requestParam.setFailReason("态度差");
		requestParam.setIsSolve("N");
		requestParam.setAppraiseLevel("3");
		
		requestParam.setOrderCode("2015010814210");
		requestParam.setCurrentUserCode("007731");
		requestParam.setOs("android");
		String str = appraiseService.appraiseCommit(requestParam);
		System.out.println(str);
	}
	
	@Test
	public void testConfirm(){
		
		AppraiseEntity appraiseEntity = new AppraiseEntity();
		appraiseEntity.setConfirmDate(new Date().getTime());
		appraiseEntity.setOrderCode("070682775");
		appraiseEntity.setCurrentUserCode("207530");
		appraiseEntity.setCurrentUserName("郭翔宇");
		appraiseEntity.setIsSolve("N");
		appraiseEntity.setReportType("word");
		
		String param = JSONObject.toJSONString(appraiseEntity);
		Response confirm = appraiseService.confirm(param);
		System.out.println(confirm);
	}

}
