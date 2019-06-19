package com.deppon.dpm.tongxunlu.test.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.tongxunlu.server.service.ITongxunLuService;
import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.domain.HotLine;
import com.deppon.dpm.tongxunlu.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;
import com.deppon.dpm.tongxunlu.test.BaseTestCase;
import com.deppon.dpm.tongxunlu.test.domain.PushUserParam;

public class TongxunLuServiceTest extends BaseTestCase{
	
	@Autowired
	private ITongxunLuService tongxunLuService;
	
	@Test
	public void testSearchOrg(){
		OrganizationVO condition = new OrganizationVO();
		int start = 0;
		int pageSize = 10;
		List<OrganizationVO> list = tongxunLuService.searchOrg(condition, start, pageSize);
		for (OrganizationVO organizationVO : list) {
			System.out.println(organizationVO);
		}
	}
	
	@Test
	public void testGetEmpDetail(){
		String id = "17474";
		EmployeeVO empDetail = tongxunLuService.getEmpDetail(id,null);
		System.out.println(empDetail);
	}
	
	@Test
	public void testGetOrgDetail(){
		String id = "311";
		OrganizationVO orgDetail = tongxunLuService.getOrgDetail(id);
		System.out.println(orgDetail);
	}
	
	@Test
	public void testGetEmpByOrgId(){
		String pid = "257";
		int start = 0;
		int limit = 100;
		List<EmployeeVO> list = tongxunLuService.getEmpByOrgId(pid, start, limit);
		for (EmployeeVO employeeVO : list) {
			System.out.println(employeeVO);
		}
	}
	
	@Test
	public void testSearchEmp(){
		EmployeeVO condition = new EmployeeVO();
		condition.setEmpStatus("on");
		condition.setEmpName("萨斯");
		int start = 0;
		int pageSize = 20;
		List<EmployeeVO> list = tongxunLuService.searchEmp(condition, start, pageSize);
		for (EmployeeVO employeeVO : list) {
			System.out.println(employeeVO);
		}
	}
	
	@Test
	public void testQueryOrgSize(){
		OrganizationVO organizationVO = new OrganizationVO();
		organizationVO.setOrgName("总裁");
		int size = tongxunLuService.queryOrgSize(organizationVO);
		System.out.println(size);
	}
	
	@Test
	public void testQueryEmpSize(){
		EmployeeVO emp = new EmployeeVO();
		emp.setAddress("上海");
		int size = tongxunLuService.queryEmpSize(emp);
		System.out.println(size);
	}
	
	@Test
	public void testUumsQuerySize(){
		EmployeeVO emp = new EmployeeVO();
		emp.setEmpCode("008615");
		int size = tongxunLuService.uumsQuerySize(emp);
		System.out.println(size);
	}
	
	@Test
	public void testGetEmpByOrgIdCount(){
		String pid = "257";
		int count = tongxunLuService.getEmpByOrgIdCount(pid);
		System.out.println(count);
	}
	
	@Test
	public void testUpdateCallQuntity(){
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setEmpId(17460);
		int i = tongxunLuService.updateCallQuntity(list);
		System.out.println(i);
	}
	
	@Test
	public void testDataMonitor(){
		int monitorType = 10;
		String empCode = "666666";
		String osType = "android";
		tongxunLuService.dataMonitor(monitorType, empCode, osType);
	}
	
	@Test
	public void testQueryPushUser(){
		PushUserParam param = new PushUserParam();
		param.setEmpname("");
		param.setEmpcode("");
		param.setJoblevel("");
		param.setJobname("大区总经理");
		param.setOrgname("");
		String json = JSONObject.toJSONString(param);
		List<Map<String, Object>> list = tongxunLuService.queryPushUser(json);
		for (Map<String, Object> map : list) {
			for(Entry<String,Object> entry : map.entrySet()){
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
	}
	
	@Test
	public void testQueryEmployeeByCode(){
		EmployeeVO params = new EmployeeVO();
		params.setEmpId(0);
		params.setEmpCode("039409");
		EmployeeEntity entity = tongxunLuService.queryEmployeeByCode(params);
		System.out.println(entity);
	}
	
	@Test 
	public void testGetAllUser(){
		List<Map<String,Object>> list = tongxunLuService.getAllUser();
		System.out.println(list.size());
	}
	
/*	@Test
	public void testAddEmployee() throws ParseException{
		EmployeeVO vo = new EmployeeVO();
		vo.setEmpCode("390098");
		vo.setEmpName("赵齐");
		vo.setGender("m");
		vo.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1992-02-27"));
		vo.setEmpStatus("on");
		vo.setCardNo("421083199202271010");
		vo.setInDate(new Date());
		vo.setEmail("zhaoqi@deppon.com");
		vo.setMobileNo("18602273220");
		vo.setEmailPassword("zhaoqi@deppon.com");
		vo.setOrgId(123455);
		vo.setJobName("接送货员");
		vo.setJobGroups("营运执行族群");
		vo.setJobLevel("04");
		vo.setCreateTime(new Date());
		int i = tongxunLuService.addEmployee(vo);
		System.out.println(i);
	}*/
	
	@Test
	public void testUpdateEmployee(){
		EmployeeVO vo = new EmployeeVO();
		vo.setEmpCode("251991");
		int i = tongxunLuService.updateEmployee(vo);
		System.out.println(i);
	}
	
	@Test
	public void testDelEmployee(){
		int i = tongxunLuService.delEmployee("390098");
		System.out.println(i);
	}
	
	@Test
	public void testHotLine(){
		List<HotLine> hotLine = tongxunLuService.hotLine();
		for (HotLine line : hotLine) {
			System.out.println(line);
		}
	}
	
/*	@Test
	public void testAddOrg(){
		OrganizationEntity entity = new OrganizationEntity();
		entity.setOrgId(19999867);
		entity.setOrgCode("W5678");
		entity.setOrgName("IT开发部");
		entity.setOrgLevel(0);
		entity.setParentOrgId(104);
		entity.setOrgAddr("上海市青浦区");
		entity.setManagerId("004182");
		entity.setAppSysCode("DIP");
		entity.setParentCompCode("德邦物流");
		entity.setOrgProperty("3");
		entity.setFinaSysCode("DP09876");
		entity.setCreateTime(new Date());
		int i = tongxunLuService.addOrg(entity);
		System.out.println(i);
	}*/
	
	@Test
	public void testUpdateOrg(){
		OrganizationEntity entity = new OrganizationEntity();
		entity.setOrgId(41);
		entity.setEmail("zhaoqi@deppon.com");
		entity.setOrgProperty("1");
		entity.setCreateTime(new Date());
		entity.setFinaSysCode("DP28634");
		int i = tongxunLuService.updateOrg(entity);
		System.out.println(i);
	}
	
//	@Test
//	public void testAddOrg() {
//		OrganizationEntity entity = new OrganizationEntity();
//		entity.setOrgId(41);
//		entity.setOrgCode("W01000301040401");
//		entity.setOrgName("流程引擎平台开发组");
//		entity.setOrgLevel(8);
//		entity.setParentOrgId(104);
//		entity.setOrgAddr("上海市青浦区");
//		entity.setZipCode("000000");
//		entity.setManagerId("073857");
//		entity.setLinkTel("13888888888");
//		entity.setEmail("zhaoqi@deppon.com");
//		entity.setArea("上海大区");
//		entity.setRemark("哈哈");
//		entity.setAppSysCode("W01000301040104");
//		entity.setParentCompCode("平台系统开发部");
//		entity.setOrgProperty("3");
//		entity.setFinaSysCode("DP28634");
//		entity.setCreateTime(new Date());
//		entity.setLastUpdate(new Date());
//		System.out.println(tongxunLuService.addOrg(entity));
//	}
	@Test
	public void testDelOrg(){
		int i = tongxunLuService.delOrg(19999837);
		System.out.println(i);
	}

	@Test
	public void testSearchOrgArchitecture(){
		String orgName = "IT开发部";
		List<OrganizationEntity> list = tongxunLuService.searchOrgArchitecture(orgName);
		for (OrganizationEntity organizationEntity : list) {
			System.out.println(organizationEntity);
		}
	}
	
	@Test
	public void testOperate(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("desEmpcode", "1000098");
		map.put("operateType", "praise");
		map.put("configType", "Y");
		int i = tongxunLuService.operate(map);
		System.out.println(i);
	}
	
	@Test
	public void testGetCount(){
		String userId = "231586";
		String objId = "231586";
		System.out.println(tongxunLuService.getCount(userId, objId));
	}
	
	@Test
	public void testGetPersonPics(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("chooseGender", "f");
		map.put("start", 0);
		map.put("pageSize", 30);
		List<Map<String, Object>> list = tongxunLuService.getPersonPics(map);
		System.out.println(list.size());
	}
	
	@Test
	public void testGetSort(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", "231586");
		map.put("gender", "f");
		List<Map<String, Object>> list = tongxunLuService.getSort(map);
		System.out.println(list.size());
	}
	
	@Test
	public void testDelAndAdd() throws ParseException{
		EmployeeVO vo = new EmployeeVO();
		vo.setEmpCode("390098");
		vo.setEmpName("赵齐");
		vo.setGender("m");
		vo.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1992-02-27"));
		vo.setEmpStatus("on");
		vo.setCardNo("421083199202271010");
		vo.setInDate(new Date());
		vo.setEmail("zhaoqi@deppon.com");
		vo.setMobileNo("18602273220");
		vo.setEmailPassword("zhaoqi@deppon.com");
		vo.setOrgId(123455);
		vo.setJobName("接送货员");
		vo.setJobGroups("营运执行族群");
		vo.setJobLevel("04");
		vo.setCreateTime(new Date());
		int delAndAdd = tongxunLuService.delAndAdd(vo);
		System.out.println(delAndAdd);
	}
	
	@Test
	public void testOperateSmile(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("desEmpcode", "231586");
		map.put("operateType", "praise");
		map.put("configType", "Y");
		int i = tongxunLuService.operateSmile(map);
		System.out.println(i);
	}
	
	@Test
	public void testGetSmileSort(){
		String userId = "231586";
		List<Map<String,Object>> list = tongxunLuService.getSmileSort(userId);
		System.out.println(list.size());
	}
	
	@Test
	public void testGetSmilePersonPics(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", "231586");
		map.put("start", 0);
		map.put("pageSize", 50);
		List<Map<String,Object>> list = tongxunLuService.getSmilePersonPics(map);
		System.out.println(list.size());
	}
	
	@Test
	public void testGetSmileCount(){
		String userId = "231586";
		String objId = "231586";
		Map<String, Object> map = tongxunLuService.getSmileCount(userId, objId);
		for (Entry<String,Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
	
	/********************************************************/
	@Test
	public void testInsertEmpleaderConfig(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("empcode", "231586");
		int i = tongxunLuService.insertEmpleaderConfig(map);
		System.out.println(i);
	}
	
	@Test
	public void testUpdateEmpleaderConfig(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "10");
		map.put("empcode", "231586");
		map.put("status", "");
		int i = tongxunLuService.updateEmpleaderConfig(map);
		System.out.println(i);
	}
	
	@Test
	public void testDeleteEmpleaderConfig(){
		String id = "10";
		int i = tongxunLuService.deleteEmpleaderConfig(id);
		System.out.println(i);
	}
}
