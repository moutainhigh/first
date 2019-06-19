package com.deppon.dpm.tongxunlu.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.tongxunlu.server.service.IMyFavoritesService;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.dpm.tongxunlu.test.BaseTestCase;

public class MyFavoritesServiceTest extends BaseTestCase{
	
	@Autowired
	private IMyFavoritesService myFavoritesService;
	
	@Test
	public void testCollectOne(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", "149994");
		map.put("collectEmpCode", "");
		int i = myFavoritesService.collectOne(map);
		System.out.println(i);
	}
	
	@Test
	public void testGetFavorites(){
		String userId = "149994";
		List<EmployeeVO> list = myFavoritesService.getFavorites(userId);
		System.out.println(list.size());
	}
	
	@Test
	public void testRemoveOne(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", "149994");//078425
		map.put("collectEmpCode", "078425");
		int i = myFavoritesService.removeOne(map);
		System.out.println(i);
	}
	
	@Test
	public void testRemoveAll(){
		String userId = "231586";
		int i = myFavoritesService.removeAll(userId);
		System.out.println(i);
	}

}
