package com.deppon.dpm.module.login.test.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.login.server.domain.FailLoginInfoEntity;
import com.deppon.dpm.login.server.service.LoginService;
import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.dpm.uums.server.domain.ResourceEntity;

public class LoginServiceTest extends TestCase {
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * 登录service
	 */
	private LoginService loginService;

	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"com/deppon/dpm/login/test/META-INF/spring.xml");
		loginService = (LoginService) appContext.getBean("loginService");
	}
	
	@Test
	public void testQueryFailLoginInfo(){
		loginService.queryFailLoginInfo("116250");
	}
	
	@Test
	public void testSaveFailLoginInfo(){
		Random random = new Random();
		String result = "";
		for(int i = 0; i < 6; i++){
			result += random.nextInt(10);
		}
		FailLoginInfoEntity entity = new FailLoginInfoEntity();
		entity.setEmpCode(result);
		entity.setErrorCount(1);
		loginService.saveFailLoginInfo(entity);
	}
	
	@Test
	public void testUpdateFailLoginInfo(){
		FailLoginInfoEntity entity = new FailLoginInfoEntity();
		entity.setEmpCode("116250");
		entity.setErrorCount(1);
		entity.setLastErrorLoginTime(new Date());
		entity.setLockedTime(null);
		entity.setUpdateTime(new Date());
		loginService.updateFailLoginInfo(entity);
	}

	@Test
	public void testgetRole() {
		String userId = "231586";
		String appId = "9";
		// 获取角色权限
		String str = loginService.getRole(userId, appId);
	}

	@Test
	public void testuserLogin() throws Exception {
		// String userName = "231586";
		// String pwd = "qqqqqq";
		// // HttpServletRequest request = null;
		// //
		// // HttpSession session = request.getSession();
		//
		// ISession<Object> session= SessionContext.getSession();
		//
		// session = new Session<Object>();
		//
		// // 用户登录
		// CasUserEntity casUserEntity = loginService.userLogin(userName, pwd);
		//
		// // 验证用户信息是否有管理平台权限
		// boolean bo = loginService.validBpmWebUser(userName, casUserEntity);
		// System.out.println(bo);
	}

	@Test
	public void testdoSSOLogon() throws Exception {
		String userId = "231586";
		Map<String, Object> validInfo = new HashMap<String, Object>();
		// 得到CAS登录所需的验证信息
		loginService.fetchCASValidInfo(validInfo);

		// 移动门户单点登录
		String str = loginService.doSSOLogon(validInfo, userId);
	}

	@Test
	public void testfindResources() {
		String userCode = "231586";
		List<String> roles = Arrays.asList("DPM0012", "DPM0013", "DPM0016",
				"DPM0017", "DPM0014", "DPM0015", "DPM0006", "DPM0008",
				"DPM0018", "DPM001", "DPM002", "DPM0021");
		// 查询用户及权限信息
		UserEntity queryUser = loginService.queryUser(userCode, roles);
		String parentCode = "DPMNEWS";
		// 查询功能方法
		List<ResourceEntity> resNodes = loginService.findResources(parentCode,
				queryUser);
	}

	@Test
	public void testhasGesturePassword() {
		String userId = "231586";
		String status = "off";
		boolean bo = loginService.hasGesturePassword(userId);
		if (bo) {
			// 更新手势密码
			int result = loginService.updateGustureStatus(userId, status);
		} else {
			// 保存手势密码
			int result = loginService.saveGustureStatus(userId, status);
		}
	}

	@Test
	public void testupdateGesturePassword() {
		String userId = "231586";
		String password = "bA2VViaDU7mKu41pIiYZEg==";
		loginService.updateGesturePassword(userId, password);
	}

	@Test
	public void testvalidateGesturePassword() {
		String userId = "231586";
		String password = "bA2VViaDU7mKu41pIiYZEg==";
		// 验证手势密码是否正确
		boolean bo = loginService.validateGesturePassword(userId, password);
	}

	@Test
	public void testgetGustureStatus() {
		String userId = "231586";
		// 获取手势密码状态
		Map<String, Object> map = loginService.getGustureStatus(userId);
	}

	@Test
	public void testgetApplyStoreSort() {
		String userId = "000001";
		List<String> list = new ArrayList<String>();
		list.add("DPM0013");
		list.add("DPM0008");
		list.add("DPM0021");
		list.add("DPM0019");
		// 应用商店排序处理
		loginService.getApplyStoreSort(userId,"","",0,list,null,null);
	}

	@Test
	public void testgetInfoStoreSort() {
		String userId = "231586";
		// 获取应用商店排序
		String sort = loginService.getInfoStoreSort(userId);
	}
	
	@Test
	public void test() throws Exception {
		loginService.getJdbcTemplate();
		loginService.getCasLoginService();
		loginService.getEmployeeDao();
		loginService.getRoleResourceDao();
		loginService.getOrganizationDao();
		loginService.getResourceService();
		loginService.getPersonlyImageService();
	}
	
	@Test
	public void testSaveErrorLoginInfos(){
		loginService.saveErrorLoginInfos("123456", "android", "login error");
	}

}
