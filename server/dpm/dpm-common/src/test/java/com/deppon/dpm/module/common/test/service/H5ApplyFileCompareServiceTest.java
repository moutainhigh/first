package com.deppon.dpm.module.common.test.service;

import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.common.server.service.IH5ApplyFileCompareService;
import com.deppon.dpm.module.common.test.BaseTestCase;

public class H5ApplyFileCompareServiceTest extends BaseTestCase{

	@Autowired
	private IH5ApplyFileCompareService h5ApplyFileCompareService;
	
	@Test
	public void testSaveCount() {
		Random random = new Random();
		String result = "";
		for(int i =0;i < 6;i++){
			result += random.nextInt(10);
		}
		int count = 0;
		h5ApplyFileCompareService.saveCount(Integer.valueOf(result), count);
	}

	@Test
	public void testUpdateCount() {
		h5ApplyFileCompareService.updateCount(16, 27);
	}

	@Test
	public void testGetFileCount() {
		h5ApplyFileCompareService.getFileCount(13);
	}

	@Test
	public void testQueryList() {
		h5ApplyFileCompareService.queryList(0, 5);
	}

	@Test
	public void testQueryCount() {
		h5ApplyFileCompareService.queryCount();
	}

	@Test
	public void testInsert() {
		Random random = new Random();
		String result = "";
		for(int i =0;i < 6;i++){
			result += random.nextInt(10);
		}
		int count = 0;
		h5ApplyFileCompareService.insert(Integer.valueOf(result), count);
	}

	@Test
	public void testUpdate() {
		h5ApplyFileCompareService.update(16, 27);
	}

	@Test
	public void testDeleteByApplyCodes() {
		h5ApplyFileCompareService.deleteByApplyCodes("958137");
	}

}
