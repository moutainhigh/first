package com.deppon.dpm.uums.test.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.uums.server.domain.VersionEntity;
import com.deppon.dpm.uums.server.service.IVersionService;
import com.deppon.dpm.uums.test.BaseTestCase;

public class VersionServiceTest extends BaseTestCase{
	
	@Autowired
	private IVersionService versionService;
	
	@Test
	public void testUpdateVersion(){
		VersionEntity entity = new VersionEntity();
		entity.setVid(2);
		entity.setVersion("3.4.9");
		entity.setContent("测试版本更新");
		String str = versionService.updateVersion(entity);
		System.out.println(str);
	}
	
	@Test
	public void testSelectVersions(){
		List<VersionEntity> list = versionService.selectVersions();
		System.out.println(list.size());
	}

}
