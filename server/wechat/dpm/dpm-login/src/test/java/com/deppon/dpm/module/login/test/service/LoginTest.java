package com.deppon.dpm.module.login.test.service;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;

import com.deppon.dpm.login.server.domain.CasUserEntity;
import com.deppon.dpm.login.server.service.LoginService;
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

}
