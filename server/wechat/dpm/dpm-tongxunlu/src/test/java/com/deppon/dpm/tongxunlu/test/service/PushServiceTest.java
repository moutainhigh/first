package com.deppon.dpm.tongxunlu.test.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.tongxunlu.server.service.IJpushService;
import com.deppon.dpm.tongxunlu.test.BaseTestCase;

public class PushServiceTest extends BaseTestCase{
	
	@Autowired
	private IJpushService jpushService;
	
	@Test
	public void testSendNotification(){
		String sysCode = "dpm";
		String content = "嘻嘻呵呵哈哈";
		Map<String,Object> extras = new HashMap<String,Object>();
		extras.put("type", 2);
		extras.put("deviceType", "iphone");
		extras.put("sysCode", "dpm");
		extras.put("sum", "5");
		extras.put("url", "");
		String str = jpushService.sendNotification(sysCode, content, extras);
		System.out.println(str);
		/*****************************/
		
//		String sysCode2 = "dpm";
//		String content2 = "嘻嘻呵呵哈哈";
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("type", 1);
//		map.put("deviceType", "iphone");
//		map.put("sysCode", "dpm");
//		map.put("sum", "5");
//		map.put("url", "");
//		String str2 = jpushService.sendNotification(sysCode2, content2, map);
//		System.out.println(str2);
		
	
	}
	
	@Test
	public void testSendNotificationToOne(){
		String sysCode = "dpm";
		String userId = "143091";
		String content = "嘻嘻哈哈呵呵";
		Map<String,Object> extras = new HashMap<String,Object>();
		extras.put("type", 2);
		extras.put("sum", "5");
		String str = jpushService.sendNotificationToOne(sysCode, userId, content, extras);
		System.out.println(str);
	}
	
	@Test
	public void saveTagAndAlias(){
		String userId = "026363";
		String sysCode = "dpm";
		String deviceType = "android";
		String token = "e97a21b5f37ef785c6984ae2d3afb78e";
		String str1 = jpushService.saveTagAndAlias(userId, sysCode, deviceType, token);
		System.out.println(str1);
		
		String userId2 = "232747";
		String sysCode2 = "dpm";
		String deviceType2 = "android";
		String token2 = "183694f87a7b5eedbd38832370900b3028df3a447f05759e130fe464a12c7e45";
		String str2 = jpushService.saveTagAndAlias(userId2, sysCode2, deviceType2, token2);
		System.out.println(str2);
		
		String userId3 = "024441";
		String sysCode3 = "dpm";
		String deviceType3 = "iphone";
		String token3 = "7656a060668be3e00ddf4a8473abfe2a00bdf8d91deac3b9c174012cc88623a3";
		String str3 = jpushService.saveTagAndAlias(userId3, sysCode3, deviceType3, token3);
		System.out.println(str3);
		
		String userId4 = "010076";
		String sysCode4 = "dpm";
		String deviceType4 = "android";
		String token4 = "e97a21b5f37ef766c664ae2d3afb78e";
		String str4 = jpushService.saveTagAndAlias(userId4, sysCode4, deviceType4, token4);
		System.out.println(str4);
		
		
		String userId5 = "116250";
		String sysCode5 = "dpm";
		String deviceType5 = "android";
		String token5 = "687df5225675148a031b74e050cb3dc8";
		String str5 = jpushService.saveTagAndAlias(userId5, sysCode5, deviceType5, token5);
		System.out.println(str5);
		
		String userId6 = "116250";
		String sysCode6 = "dpm";
		String deviceType6 = "iphone";
		String token6 = "2185FE34-FF5B-4FDC-A37A-2780D60BCDBB";
		String str6 = jpushService.saveTagAndAlias(userId6, sysCode6, deviceType6, token6);
		System.out.println(str6);
		
		String userId7 = "116250";
		String sysCode7 = "dpm";
		String deviceType7 = "iphone";
		String token7 = UUID.randomUUID().toString();
		String str7 = jpushService.saveTagAndAlias(userId7, sysCode7, deviceType7, token7);
		System.out.println(str7);
	}

}
