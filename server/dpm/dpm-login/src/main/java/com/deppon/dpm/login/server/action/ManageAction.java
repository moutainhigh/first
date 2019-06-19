package com.deppon.dpm.login.server.action;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.deppon.dpm.login.server.domain.FailLoginInfoEntity;
import com.deppon.dpm.login.server.service.CasLoginService;
import com.deppon.dpm.login.server.service.ILoginService;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.CookieUtil;
import com.deppon.dpm.module.common.server.util.JdbcTemplateUtil;
import com.deppon.dpm.module.common.server.util.ServletUtil;

public class ManageAction extends BaseAction{

	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = -3435469965380081522L;
	
	private static final int MAXAGE = 3600;
	
	/**
	 * 请求传递的页面类型
	 */
	private String type;

	/**
	 * 登录名
	 */
	private String loginName;
	
	/**
	 * 登录密码
	 */
	private String password;
	
	/**
	 * Jdbc模板
	 */
	private JdbcTemplate jdbcTemplate;	
	
	/**
	 * cas服务注入
	 */
	private CasLoginService casLoginService;
	
	/**
	 * 请求角色信息的service
	 */
//	private IUUMSRoleService uUMSRoleService;
	/**
	 * UUMS-NEW loginservice
	 */
	private ILoginService loginService;
	
	/**
	 * 通用的模块页面跳转
	 */
	public String modulePage(){
		return type + "Page";
	}
	
	/**
	 * 登录成功后跳转到首页
	 */
	public String toHomePage(){
		//request
		HttpServletRequest request = ServletUtil.getRequest();
		//登录工号
		loginName = (String) request.getAttribute("loginName");
		//根据工号查询名字
		String sql = "SELECT empname FROM om_employee WHERE empcode = ?";
		loginName = JdbcTemplateUtil.queryForString(jdbcTemplate, sql, new String[]{loginName});
		request.setAttribute("loginName", loginName);
		return "toHomePage";
	}
	
	/**
	 * 登录
	 */
	public String login(){
		
		/*******验证用户名和密码   start********/
		//健壮性判断
		if(StringUtils.isBlank(loginName) || StringUtils.isBlank(password)){
			//提示用户名或密码不能为空
			this.addActionError("用户名和密码不能为空!");
			return INPUT;
		}
		
		// 先查询用户的锁定状态和错误次数
		FailLoginInfoEntity failLoginInfoEntity = loginService
				.queryFailLoginInfo(userId);
		// 如果有记录
		if (null != failLoginInfoEntity) {
			// 当前时间
			Date currentTime = new Date();
			// 被锁定时间
			Date lockedTime = failLoginInfoEntity.getLockedTime();
			// 如果已被锁定并且锁定时间还未过期，则跳出
			if (null != lockedTime
					&& currentTime.getTime() < (DateUtils.addMinutes(
							lockedTime, 1).getTime())) {
				// errorMessage
				this.addActionError("用户名或密码错误!账号已被锁定，请一分钟后再试");
				return INPUT;
			}
		}
		
		
		
		//接UUMS第一次上线   保险期间 一部分人走UU验证      一部人走CAS 走CAS用245102验证  老的CAS中无其他人信息  
		if (loginName.equals("500612") || loginName.equals("265564")|| loginName.equals("491275")  || loginName.equals("496837")|| loginName.equals("245102")|| loginName.equals("275309")) {
			//走UUMS-NEW验证
			try {
				String loginResultCode = loginService.backgroundManagerLoginFromUUMS(loginName, password);
//				String loginResult = "";
				if (loginResultCode.equals("100")) {
					//100:失败  获取错误信息
					this.addActionError("用户名或密码错误!");
					return INPUT;
				}else if (loginResultCode.equals("200")) {
					//200 登录成功 
					if (null != failLoginInfoEntity) {
						// 不用每次校验账号密码成功后都清除状态和次数
						if (null != failLoginInfoEntity.getLockedTime()
								|| failLoginInfoEntity.getErrorCount() != 0) {
							// 设置错误次数为0
							failLoginInfoEntity.setErrorCount(0);
							// 清除锁定时间
							failLoginInfoEntity.setLockedTime(null);
							// 更新时间
							failLoginInfoEntity.setUpdateTime(new Date());
							// 更新
							loginService.updateFailLoginInfo(failLoginInfoEntity);
						}
					}
					
				}else if (loginResultCode.equals("300")) {
					//登录成功，人员信息不存在
					this.addActionError("登录成功，人员信息不存在");
					return INPUT;
				}else if (loginResultCode.equals("400")) {
					//登录成功，人员信息不存在
					this.addActionError("登录方法抛异常 具体异常原因请查看日志信息");
					return INPUT;
				}
			
			
			} catch (Exception e) {
				// TODO: handle exception
				//提示用户错误信息
				this.addActionError("用户名或密码错误!");
				return INPUT;
			}
		}else {
			//CAS验证
			try {
				// 提交验证服务器验证用户信息
				casLoginService.login(loginName, password);
			} catch (Exception e) {
				//提示用户错误信息
				this.addActionError("用户名或密码错误!");
				return INPUT;
			}
		}
		
		
		
		
		/*******验证用户名和密码   end********/
		
/*		if(loginName.equals("245102")){
			//权限表里加后台管理权限 appid=100表示后对口管理系统
		}else{
			*//*******判断是否有登录管理系统的角色********//*
			//获取角色list
			String roles = uUMSRoleService.getRoles(loginName);
			String roleStr = JSONObject.parseObject(roles).getString("roleCodes");
			List<String> roleCodes = JSONObject.parseArray(roleStr, String.class);
			// 判断
			if(null == roleCodes){
				//提示错误信息
				this.addActionError("您没有访问权限!");
				//返回登录页面
				return INPUT;
			}
			//判断是否包含登录管理系统的角色
			if(!roleCodes.contains(DpmConstants.back_manage_Role)){
				//提示错误信息
				this.addActionError("您没有访问权限!");
				//返回登录页面
				return INPUT;
			}
		}*/
 		if(loginName.equals("500612") || loginName.equals("265564") || loginName.equals("491275") || loginName.equals("496837")|| loginName.equals("245102")|| loginName.equals("275309")){
			//权限表里加后台管理权限 appid=100表示后对口管理系统
		}else{
			//提示错误信息
			this.addActionError("您没有访问权限!");
			//返回登录页面
			return INPUT;
		}
		/*******判断是否有登录管理系统的角色********/
		/*//获取角色list
		String roles = uUMSRoleService.getRoles(loginName);
		String roleStr = JSONObject.parseObject(roles).getString("roleCodes");
		List<String> roleCodes = JSONObject.parseArray(roleStr, String.class);
		// 判断
		if(null == roleCodes){
			//提示错误信息
			this.addActionError("您没有访问权限!");
			//返回登录页面
			return INPUT;
		}
		//判断是否包含登录管理系统的角色
		if(!roleCodes.contains(DpmConstants.back_manage_Role)){
			//提示错误信息
			this.addActionError("您没有访问权限!");
			//返回登录页面
			return INPUT;
		}*/
		
		//登录成功，需要将登录令牌存入cookie并记录到数据库
		//登录令牌，用户名+当前时间
		String loginToken = loginName + System.currentTimeMillis();
		//sql
		String delSql = "DELETE FROM om_logintoken WHERE userId = ?";
		String insertSql = "INSERT INTO om_logintoken (token,userId) VALUES (?,?);";
		try {
			//删除该用户的登录记录
			this.jdbcTemplate.update(delSql, loginName);
			//记录到数据库
			this.jdbcTemplate.update(insertSql,loginToken,loginName);
			//记录cookie
			Cookie loginCookie = new Cookie("loginToken",loginToken); 
			//设定有效时间  1个小时
			loginCookie.setMaxAge(MAXAGE); 
			//设置Cookie路径和域名
			loginCookie.setPath("/") ;
			//将cookie添加到响应中
			ServletUtil.getResponse().addCookie(loginCookie);
		} catch (Exception e) {
			//提示错误
			this.addActionError("系统出错，请重新登录!");
			//返回登录页面
			return INPUT;
		} 
	    //跳转
		return "loginSuccess";
	}
	
	/**
	 * 登出
	 */
	public String logout(){
		//删除表中的登录令牌信息，并清除cookie
		Cookie[] cookies = CookieUtil.getCookies();
		//获取cookie中的登录令牌
		String loginToken = CookieUtil.getValFromCookie(cookies, "loginToken");
		//删除该token
		String sql = "delete from om_logintoken where token = ?";
		this.jdbcTemplate.update(sql, loginToken);
		//清除cookie
		CookieUtil.cleanCookie(cookies,"loginToken");
		return INPUT;
	}
	

	/**
	 * getter
	 */
	public String getType() {
		return type;
	}

	/**
	 * setter
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * getter
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * setter
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * getter
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * setter
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * setter
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * setter
	 */
	public void setCasLoginService(CasLoginService casLoginService) {
		this.casLoginService = casLoginService;
	}

	/**
	 * setter
	 */
//	public void setuUMSRoleService(IUUMSRoleService uUMSRoleService) {
//		this.uUMSRoleService = uUMSRoleService;
//	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}
	
}
