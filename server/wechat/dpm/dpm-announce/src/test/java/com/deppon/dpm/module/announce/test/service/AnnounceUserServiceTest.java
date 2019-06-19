package com.deppon.dpm.module.announce.test.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.announce.server.service.IAnnounceService;
import com.deppon.dpm.module.announce.server.service.IAnnounceUserService;
import com.deppon.dpm.module.announce.shared.define.ConstansUtil;
import com.deppon.dpm.module.announce.shared.domain.AnnounceEntity;
import com.deppon.dpm.module.announce.shared.domain.AnnounceUserEntity;
import com.deppon.dpm.module.announce.shared.util.UUIDUtils;
import com.deppon.dpm.module.announce.test.BaseTestCase;

public class AnnounceUserServiceTest extends BaseTestCase{
	@Autowired
	private IAnnounceUserService announceUserService;
	@Autowired
	private IAnnounceService announceService;
	
	@Test
	public void insert(){
		AnnounceUserEntity entity = new AnnounceUserEntity();
		entity.setEmpCode(UUIDUtils.getUUID());
		entity.setAppAnnounceId(UUIDUtils.getUUID());
		entity.setType(ConstansUtil.READ);
		int num = announceUserService.insert(entity);
		System.out.println(num);
	}
	
	@Test
	public void updateAnnounceUser(){
		AnnounceUserEntity queryParam = new AnnounceUserEntity();
		queryParam.setEmpCode("176d998e-4d1e-4bb6-ba5e-402d4ccf32d7");
		List<AnnounceUserEntity> list = announceUserService.queryCommonAll(queryParam);
		if(null != list && list.size() > 0){
				AnnounceUserEntity entity = list.get(0);
				entity.setTitle("wahaha...");
				int num = announceUserService.update(entity);
				System.out.println(num);
		}
	}
		
	
	private static String splitTitle(String title){
		String newTitle = title;
		int length = title.length();
		if(length > 4){
			String subString = title.substring(4, length-3);
			return subString;
		}
		return newTitle;
	}
	
}
