package com.deppon.dpm.module.management.server.app.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.management.server.app.test.BaseTestCase;
import com.deppon.dpm.module.management.server.service.IApplyStoreService;
import com.deppon.dpm.module.management.shared.domain.ApplyDevice;
import com.deppon.dpm.module.management.shared.domain.ApplyStore;
import com.deppon.dpm.module.management.shared.domain.ApplyStoreAppraise;
import com.deppon.dpm.tongxunlu.server.service.ITongxunLuService;
import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

public class ApplyStoreServiceTest extends BaseTestCase {

	@Autowired
	private IApplyStoreService applyStoreService;
	
	@Autowired
	private ITongxunLuService tongxunLuService;

	@Test
	public void testList() {
		List<String> roleList = new ArrayList<String>();
		roleList.add("DPM0013");
		roleList.add("DPM100");
		roleList.add("DPM0014");
		roleList.add("DPM0006");
		roleList.add("DPM0008");
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setEmpCode("116250");
		EmployeeEntity entity = tongxunLuService.selectOne(employeeVO);
		List<ApplyStore> list = applyStoreService.list(entity,roleList,null,null);
		System.out.println(list.size());
	}

	@Test
	public void testDownload() {
		String userId = "027863";
		int id = 5;
		applyStoreService.download(userId, id);
	}

	@Test
	public void testSort() {
		String userId = "131273";
		String sortStr = "17,1,2,3,4,5,6,0,13";
		applyStoreService.sort(userId, sortStr);
	}

	@Test
	public void testGetSort() {
		String userId = "131273";
		String sort = applyStoreService.getSort(userId);
		System.out.println(sort);
	}

	@Test
	public void getApplyStoreListTest() {
		int appId = 1;
		int begin = 0;
		int pageSize = 2;
		applyStoreService.getApplyStoreList(appId, begin, pageSize);
	}

	@Test
	public void getApplyStoreCountTest() {
		applyStoreService.getApplyStoreCount();
	}

	@Test
	public void applyStoreTest() {
		// insert
		ApplyStore entity = new ApplyStore();
		entity.setAppId(99);
		entity.setCnName("99测试");
		entity.setEnName("99测试en");
		entity.setSummary("99sum");
		entity.setStatus("on");
		entity.setHasResources("0");
		entity.setDefaultApp("1");
		entity.setAppContent("99content");
		entity.setSize("2.4M");
		applyStoreService.insertApplyStore(entity);
		// update
		applyStoreService.updateApplyStore(entity);
		// delete
		applyStoreService.deleteApplyStore(entity);
	}

	@Test
	public void applyStoreDeviceTest() {
		ApplyDevice entity = new ApplyDevice();
		entity.setApplyStoreId(1);
		entity.setDeviceToken("99abcd");
		applyStoreService.getApplyDeviceList(entity);

		entity.setVersionType("1.0");
		entity.setOsType("ios");
		// save
		applyStoreService.saveApplyDeviceByAppId(entity,0);

		// delete
		applyStoreService.deleteApplyDevice(entity);
	}

	@Test
	public void getApplyStoreByIdTest() {
		int appId = 1;
		String userId = "231586";
		int begin = 0;
		int pageSize = 10;
		applyStoreService.getApplyStoreById(appId, userId, begin, pageSize);
	}

	@Test
	public void getApplyStoreAppraiseListTest() {
		ApplyStoreAppraise entity = new ApplyStoreAppraise();
		entity.setEmpcode("231586");
		entity.setAppId(1);
		int begin = 0;
		int pageSize = 10;
		applyStoreService.getApplyStoreAppraiseList(entity, begin, pageSize);
	}

	@Test
	public void testQueryHasUpdate(){
		applyStoreService.queryHasUpdate(13, "4614164121", "ios");
		
	}
}
