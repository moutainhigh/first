package com.deppon.dpm.module.login.test.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.login.server.domain.CasUserEntity;
import com.deppon.dpm.login.server.service.LoginService;
import com.deppon.dpm.module.common.server.util.DES;
import com.deppon.dpm.module.common.server.util.HttpUtil;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.foss.framework.server.context.SessionContext;
import com.deppon.foss.framework.server.web.session.ISession;

public class LoginTest extends MockHttpServletRequest {
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * 登录service
	 */
	private LoginService loginService;

	@Before
	public void setUp() {
		appContext = new ClassPathXmlApplicationContext(
				"com/deppon/dpm/login/test/META-INF/spring.xml",
				"com/deppon/dpm/login/test/META-INF/login-spring.xml");
		loginService = (LoginService) appContext.getBean("loginService");
	}

	@Test
	public void testuserLogin() throws Exception {

		String userName = "116250";
		String pwd = "qqqqqq";
		HttpSession session = this.getSession();
		ISession<Object> session1 = SessionContext.getSession();
		session1.init(session);
		// 用户登录
		CasUserEntity casUserEntity = loginService.userLogin(userName, pwd);
		// 获取用户信息
		UserEntity userEntity = loginService.queryUser(userName,
				casUserEntity.getRoleCodes());
	}
	
	/**
	 * 获取邦邦邦APP相关信息
	 * 
	 * */
	@Test
	public void getBangBangBangInfos(){
		String url = "http://rdvs.deppon.com/newevs-web/bangWoXue/queryLink.do";
		
		JSONObject fromBang = new JSONObject();//返回结果
		Map<String,Object> param = new HashMap<String,Object>();//Http 参数
		Map<String,String> header = new HashMap<String,String>();//Http Header 的相关数据
		header.put("loginName", "294299");
		header.put("X-RDVS-APP-CODE", "49ae91354a2549b8b5d14ac4029ca3d3");
		param.put("Header", header);
		try {
			String resultJson = HttpUtil.doPost2Header(url, param);
			fromBang = JSON.parseObject(resultJson);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("获取的邦邦邦信息："+fromBang.toString());
	}
	
	@Test
	public void register4outsource(){
		List<Map<String,Object>> registerList = new ArrayList<Map<String,Object>>();
		Map<String,Object> r = new HashMap<String,Object>();
		Map<String,String> org = new HashMap<String,String>();
		org.put("org_id", "478542");
		org.put("value", "移动办公");
		r.put("name", "liming9");
		r.put("psex", "f");
		r.put("scategory", "WA");
		r.put("passwd", "1qwerr");
		r.put("company", "依梦");
		r.put("telephone", "13312345678");
		r.put("mail", "qq3236@qq.com");
		r.put("project", "登榜意义");
		r.put("selectedDept", org);
		registerList.add(r);
		/*
		Map<String,Object> r2 = new HashMap<String,Object>();
		r2.put("name", "laowu6");
		r2.put("psex", "m");
		r2.put("category", "WB");
		r2.put("passwd", "1qwert");
		r2.put("company", "依梦");
		r2.put("telephone", "13112345678");
		r2.put("mail", "qq1236@qq.com");
		r2.put("project", "意义");
		r2.put("selectedDept", org);
		registerList.add(r2);
		*/
		System.out.println("registerList :" + JSON.toJSONString(registerList));
		Map<String,Object> checkResult = new HashMap<String,Object>();
		checkResult = loginService.check4outsource(registerList);
		System.out.println("checkResult :" + JSON.toJSONString(checkResult));
		if(checkResult == null || checkResult.isEmpty() 
				|| !"true".equalsIgnoreCase((String)checkResult.get("is_available"))){
			System.out.println("the regist info is not available!");
			return;
		}
		
		Map<String,Object> result = new HashMap<String,Object>();
		result = (Map<String,Object>)loginService.register4outsource(registerList);
		System.out.println("result size:" + JSON.toJSONString(result));
		
	}
	
	@Test
	public void login4outsource(){
		Map<String,Object> result = loginService.login4outsource("WA000001", "1qwerr");
		System.out.println("result: "+JSON.toJSONString(result));
	}
	
	/**
	 * outSourcing password encryption
	 * */
	private String outSourcePwdEncode(String pwd){
		try {
			pwd = DES.encryptDES(new String(Base64.encodeBase64(pwd.getBytes())));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return pwd;
	}
	
	@Test
	public void testEncode(){
		System.out.println("Encoded account id: "+outSourcePwdEncode("WA000001"));
		
	}
	
	@Test
	public void getOutSourceListByInnerUserId(){
		Map<String,Object> map = loginService.getOutSourceListByInnerUserId("275309", "WA000001");
		System.out.println(map.toString());
	}
	
	@Test
	public void updateOutSourceUser(){
		Map<String,Object> outSourceInfo = new HashMap<String,Object>();
		//construct outSourceInfo
		outSourceInfo.put("staff_id","WA000001");
		outSourceInfo.put("staff_name","qq");
		outSourceInfo.put("phone","12345654320");
		outSourceInfo.put("dpm_empcode","305628");//
		outSourceInfo.put("dpm_dept_id","478543");//
		outSourceInfo.put("dpm_dept","【H】廊坊大城县留各庄营业部");//
		outSourceInfo.put("dpm_project","【H】廊坊大城县留各庄营业部");//
		outSourceInfo.put("mail","qq433@qq.com");
		outSourceInfo.put("gender","f");
		outSourceInfo.put("company","依梦");
		outSourceInfo.put("contract_etime","2018-09-18");
		System.out.println(outSourceInfo.toString());
		Map<String,String> result = new HashMap<String,String>();
		try {
			result = loginService.updateOutSourceUser(outSourceInfo);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println(result.toString());
	}
	
	@Test
	public void testBase64MD5(){
		String pwd = "aaaaaa1!";
		String pwd_en = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			pwd_en = new String(Base64.encodeBase64(md5.digest(pwd.getBytes("utf-8"))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pwd_en);
	}
	
	@Test
	public void isWeakPwd(){
		boolean isWeak = loginService.isWeakPassword("JMgqTMuZrL6ruKFt1csbLw==");
		System.out.println(isWeak);
	}
	
	@Test
	public void isManager(){
		boolean isManager = loginService.isManagerUser("057051");
		System.out.println(isManager);
		
		boolean isManager2 = loginService.isManagerUser("275309");
		System.out.println(isManager2);
	}

}
