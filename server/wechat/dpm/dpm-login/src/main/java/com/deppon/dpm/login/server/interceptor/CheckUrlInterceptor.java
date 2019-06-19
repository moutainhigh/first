package com.deppon.dpm.login.server.interceptor;

import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.ReflectionUtils;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.server.service.ILoginInfoService;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.server.util.ThreadLocalUtil;
import com.deppon.dpm.module.common.shared.define.DpmConstants;
import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;
import com.deppon.dpm.module.common.shared.domain.LoginCheckBean;
import com.deppon.dpm.module.common.shared.vo.LoginResult;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.Result;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 验证url请求里面的用户userId、casSessionId和cookie是否合理.
 */
public class CheckUrlInterceptor extends MethodFilterInterceptor {
	
	/**
	 * log
	 */
	private static Logger logger = Logger.getLogger(CheckUrlInterceptor.class);
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4758183403796317748L;
	/**
	 * set injection
	 */
	private ILoginInfoService loginInfoService;
	
	/**
	 * 注入RedisService
	 */
	private RedisService loginRedisService;

	/**
	 * 拦截器
	 */
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// zxy 20140821 start 新增:增加非受检类型
		Object target = invocation.getAction();
		// 获取方法名
		String methodName = invocation.getProxy().getMethod();
		// 获取方法类
		Method method = ReflectionUtils.findMethod(target.getClass(),
				methodName);
		// 查看是否包含这个注解
		if (method.isAnnotationPresent(CookieNotCheckedRequired.class)) {
			// 包含这个注解直接返回，不走拦截器
			return invocation.invoke();
		}
		// zxy 20140821 end 新增:增加非受检类型
		HttpServletRequest request = ServletActionContext.getRequest();
		// 获取response实体
		HttpServletResponse response = ServletActionContext.getResponse();
		// 获取请求uri
		String url = request.getRequestURI();
		// 请求人工号
		String userId = request.getParameter("userId");
		// casSessionId
		String casSessionId = request.getParameter("sessionId");
		// cookie
		String cookie = request.getParameter("casCookie");
		// 设备号
		String deviceToken = request.getParameter("deviceToken");
		// 用以验证
		LoginCheckBean bean = new LoginCheckBean(casSessionId, cookie);
		// 获取验证信息
		String checkValue = null; 
		try {
			checkValue = loginRedisService.get(RedisService.DPM_LOGIN_LOGININFO_KEY + userId);
		} catch (Exception e) {
			logger.error("["+userId+"]请求进入拦截器获取校验信息失败>>>>",e);
		}
		LoginResult loginResult = null;
		LoginCheckBean value = null;
		if(StringUtils.isNotBlank(checkValue)){
			loginResult = JSON.parseObject(checkValue, LoginResult.class);
		}
		if(null != loginResult){
			value = new LoginCheckBean(loginResult.getSessionId(),loginResult.getCasCookie());
		}
		// 不为空且相等
		if (value != null && value.equals(bean)) {
			try {
				// 校验成功，需要刷新缓存时间
				loginRedisService.expire(RedisService.DPM_LOGIN_LOGININFO_KEY + userId, MagicNumber.NUM1800);
			} catch (Exception e) {
				logger.error("["+userId+"]请求进入拦截器刷新校验信息时间失败>>>>",e);
			}
			// 将登录信息存入ThreadLocal，以便在业务代码中获取相关的信息
			ThreadLocalUtil.setThreadLocal(loginResult);
			// 通过
			return invocation.invoke();
		} else {
			// 置空
			ThreadLocalUtil.setThreadLocal(null);
			// 定义返回结果
			Result<Object> res = new Result<Object>();
			// errorCode
			res.setErrorCode(DpmConstants.sessionInvalid);
			/********************/
			// 地址对比
			if ("/dpm/dpm/login_checkEmpStatus.action".equals(url)) {
				// 状态检查
				EmpExtensionEntity empExtensionEntity = loginInfoService.checkStatus(userId, deviceToken);
				// 数据存储
				res.setData(empExtensionEntity);
			}
			/********************/
			// errorMessage
			res.setErrorMessage("会话已过期，请重新登录");
			// 类型
			response.setContentType("text/html;charset=UTF-8");
			// 消息头添加
			response.setHeader("Access-Control-Allow-Origin", "*");
			// 打印
			PrintWriter writer = response.getWriter();
			// 前端打印
			writer.write(JSON.toJSONString(res));
			// 关闭
			writer.close();
			// 返回
			return null;
		}
	}

	/**
	 * set
	 * 
	 * @param loginInfoService
	 */
	public void setLoginInfoService(ILoginInfoService loginInfoService) {
		this.loginInfoService = loginInfoService;
	}

	/**
	 * setter
	 * @param loginRedisService
	 */
	public void setLoginRedisService(RedisService loginRedisService) {
		this.loginRedisService = loginRedisService;
	}

}
