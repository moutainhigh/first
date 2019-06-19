package com.deppon.dpm.tongxunlu.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.tongxunlu.server.service.IBootyCallService;
import com.deppon.dpm.tongxunlu.shared.domain.BootyCallEntity;
import com.deppon.dpm.tongxunlu.test.BaseTestCase;

public class BootyCallServiceTest extends BaseTestCase{
	
	@Autowired
	private IBootyCallService bootyCallService;
	
	@Test
	public void testPublishBootyCallInfo(){
		BootyCallEntity entity = new BootyCallEntity();
		entity.setUserId("080808");
		entity.setDataType("movie");
		entity.setDataAddress("178影城");
		entity.setDataEmpCode("000090,116250,149994");
		entity.setDataGender("f");
		entity.setDataTime("2015-10-25 19:30");
		entity.setDataSubject("小黄人");
		int i = bootyCallService.publishBootyCallInfo(entity);
		System.out.println(i);
	}
	
	@Test
	public void testGetBootyCallInfo(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("gender", "f");
		map.put("intervalDay", 2);
		map.put("start", 0);
		map.put("pageSize", 10);
		List<Map<String, Object>> list = bootyCallService.getBootyCallInfo(map);
		for (Map<String, Object> map2 : list) {
			for(Entry<String,Object> entry : map2.entrySet()){
				System.out.println(entry.getKey() + " : " + entry.getValue().toString());
			}
		}
	}
	
	@Test
	public void testJoinBootyCall(){
		String userId = "025506";
		int id = 166;
		int i = bootyCallService.joinBootyCall(userId, id);
		System.out.println(i);
	}
	
	@Test
	public void testCheckExists(){
		String userId = "025506";
		String str = "000090,116250,149994,025506";
		boolean flag = bootyCallService.checkExists(userId, str);
		System.out.println(flag);
	}
	
	@Test
	public void testGetSelfBootyCallInfo(){
		List<Map<String,Object>> list = bootyCallService.getSelfBootyCallInfo("025506", 0, 20);
		for (Map<String, Object> map : list) {
			for(Entry<String,Object> entry : map.entrySet()){
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
	}
	
	@Test
	public void testQueryJoinEmpsByEmpCodes(){
		List<String> leaderList = new ArrayList<String>();
		leaderList.add("116250");
		bootyCallService.queryJoinEmpsByEmpCodes(new String[]{"116250"}, leaderList);
	}

}
