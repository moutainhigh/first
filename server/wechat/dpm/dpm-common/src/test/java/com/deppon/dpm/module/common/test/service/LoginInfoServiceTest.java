package com.deppon.dpm.module.common.test.service;

import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.deppon.dpm.module.common.server.service.ILoginInfoService;
import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;
import com.deppon.dpm.module.common.test.BaseTestCase;

public class LoginInfoServiceTest extends BaseTestCase{

	@Autowired
	private ILoginInfoService loginInfoService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void testSaveUserLogin(){
		String userCode = "292520";
		String loginType = "1";
		String osType = "iphone";
		String appVersion = "3.6.3";
		int i = loginInfoService.saveUserLogin(userCode, loginType, osType,appVersion);
		System.out.println(i);
	}
	
	@Test
	public void testCheckDevice(){
		
		//没有登录记录，新增操作
		String userCode3 = "292520";
		String deviceToken3 = "8091be0e-50be-430e-ad4e-10b4f0b058a2";
		String osType3 = "iphone";
		String latitude3 = "31.189";
		String longitude3 = "121.318";
		String location3 = "上海青浦区";
		EmpExtensionEntity parm3 = new EmpExtensionEntity(osType3, latitude3, longitude3, location3, 
				"", "", "","3.7.5");
		EmpExtensionEntity entity3 = loginInfoService.checkDevice(userCode3, deviceToken3, parm3);
		System.out.println(entity3);
		
		//已有登录记录，登录设备一致，执行更新
		String userCode1 = "292520";
		String deviceToken1 = "8091be0e-50be-430e-ad4e-10b4f0b058a2";
		String osType1 = "iphone";
		String latitude1 = "31.189";
		String longitude1 = "121.318";
		String location1 = "上海徐汇区";
		EmpExtensionEntity parm1 = new EmpExtensionEntity(osType1, latitude1, longitude1, location1, 
				"", "", "","3.7.5");
		EmpExtensionEntity entity1 = loginInfoService.checkDevice(userCode1, deviceToken1, parm1);
		System.out.println(entity1);
		
		//测试完成将这个userCode的所有记录清楚，以便下次测试
		jdbcTemplate.execute("delete from emp_extension where empCode = '292520'");
		
	}
	
	@Test
	public void testCheckDevice2(){
		//没有登录记录，新增操作
		String userCode3 = "292520";
		String deviceToken3 = "8091be0e-50be-430e-ad4e-10b4f0b058a2";
		String osType3 = "iphone";
		String latitude3 = "31.189";
		String longitude3 = "121.318";
		String location3 = "上海青浦区";
		EmpExtensionEntity parm3 = new EmpExtensionEntity(osType3, latitude3, longitude3, location3, 
				"", "", "","3.7.5");
		EmpExtensionEntity entity3 = loginInfoService.checkDevice(userCode3, deviceToken3, parm3);
		System.out.println(entity3);
		
		//已有登录记录，登录设备不一致，执行更新
		String userCode2 = "292520";
		String deviceToken2 = UUID.randomUUID().toString();
		String osType2 = "iphone";
		String latitude2 = "31.189";
		String longitude2 = "121.318";
		String location2 = "上海青浦区";
		EmpExtensionEntity parm2 = new EmpExtensionEntity(osType2, latitude2, longitude2, location2, 
				"", "", "","3.7.5");
		EmpExtensionEntity entity2 = loginInfoService.checkDevice(userCode2, deviceToken2,parm2);
		System.out.println(entity2);
		
		//测试完成将这个userCode的所有记录清楚，以便下次测试
		jdbcTemplate.execute("delete from emp_extension where empCode = '292520'");
	}
	
	
	@Test
	public void testCheckStatus(){
		String empCode = "219378";
		String deviceToken = "864150023241183";
		EmpExtensionEntity empExtensionEntity = loginInfoService.checkStatus(empCode, deviceToken);
		System.out.println(empExtensionEntity);
	}
	
	@Test
	public void testExistUserIdAndDeviceToken(){
		String userId = "219378";
		String deviceToken = "864150023241183";
		boolean flag = true;
		String str = loginInfoService.existUserIdAndDeviceToken(userId, deviceToken, flag);
		System.out.println(str);
	}
	
	@Test
	public void testSaveUserIdAndDeviceToken(){
		String userId = "007395";
		String deviceToken = "00f42370a42e0f85f623f14025b80523783a729d47c7a6e4d9910178e8f4b2a6";
		String smsStatus = "on";
		loginInfoService.saveUserIdAndDeviceToken(userId, deviceToken, smsStatus);
	}
	
	@Test
	public void testGetPhone(){
		String phone = loginInfoService.getPhone("007395");
		System.out.println(phone);
	}
	
	@Test
	public void testGetChange(){
		Map<String, Object> map = loginInfoService.getChange();
		for (Entry<String,Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	@Test
	public void testQueryAllLoginInfoByEmpCode(){
		loginInfoService.queryAllLoginInfoByEmpCode("T12652",1,5);
	}
}
