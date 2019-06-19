package com.deppon.dpm.module.common.server.interceptor;

import javax.servlet.http.Cookie;

import org.springframework.jdbc.core.JdbcTemplate;

import com.deppon.dpm.module.common.server.util.CookieUtil;
import com.deppon.dpm.module.common.server.util.JdbcTemplateUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 自定义拦截器，拦截未登录的访问
 *
 */
public class LoginInterceptor extends MethodFilterInterceptor{

	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = -131946486831563639L;
	
	/**
	 * Jdbc模板
	 */
	private JdbcTemplate jdbcTemplate;

	/**
	 * 复写的方法
	 */
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		ActionSupport action = (ActionSupport) invocation.getAction();
		//查看是否有携带正确的登录令牌
		//获取cookie
		Cookie[] cookies = CookieUtil.getCookies();
		//处理cookie
		String loginToken = CookieUtil.getValFromCookie(cookies,"loginToken");
		//如果没有携带loginToken，说明未登录
		if( null == loginToken){
			//错误提示
			action.addActionError("会话已过期，请重新登录!");
			//返回到登录页面
			return "input";
		}
		
		//查询数据库中是否有此token
		String sql = "select token from om_logintoken where token = ?";
		//查询数据库
		String result = JdbcTemplateUtil.queryForString(jdbcTemplate, sql, new String[]{loginToken});
		//如果没有，说明还未登录
		if(null == result){
			//错误提示
			action.addActionError("会话已过期，请重新登录!");
			//返回到登录页面
			return "input";
		}
		//放行
		return invocation.invoke();
	}

	/**
	 *getter 
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 *setter 
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
}
