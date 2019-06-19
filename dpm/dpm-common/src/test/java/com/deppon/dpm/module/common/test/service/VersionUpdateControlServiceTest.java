package com.deppon.dpm.module.common.test.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.common.server.service.impl.VersionUpdateControlService;
import com.deppon.dpm.module.common.shared.domain.VersionUpdateControlEntity;
import com.deppon.dpm.module.common.test.BaseTestCase;

public class VersionUpdateControlServiceTest extends BaseTestCase{
	
	@Autowired
	private VersionUpdateControlService versionUpdateControlService;

	@Test
	public void testList() {
		versionUpdateControlService.list();
	}

	@Test
	public void testSave() {
		VersionUpdateControlEntity entity = new VersionUpdateControlEntity();
		entity.setFileName("ceshi");
		entity.setFilePath("/dpmfile/javafile");
		entity.setLoadStatus("on");
		entity.setCreateTime(new Date());
		entity.setUpdateTime(entity.getCreateTime());
		versionUpdateControlService.save(entity);
	}

	@Test
	public void testDeleteById() {
		List<VersionUpdateControlEntity> list = versionUpdateControlService.list();
		if(list.size() > 0) {
			VersionUpdateControlEntity entity = list.get(0);
			versionUpdateControlService.deleteById(entity.getId());
		}
	}

	@Test
	public void testUpdate() {
		VersionUpdateControlEntity entity = new VersionUpdateControlEntity();
		entity.setId(1);
		entity.setFilePath("/dpmfile/javafile");
		entity.setLoadStatus("on");
		versionUpdateControlService.update(entity);
	}

}
