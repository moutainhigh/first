package com.deppon.dpm.module.announce.server.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.announce.server.service.IDpmExpressService;
import com.deppon.dpm.module.announce.shared.domain.DpmExpress;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.define.DpmConstants;
import com.deppon.dpm.module.common.shared.domain.LoginCheckBean;
import com.deppon.dpm.module.common.shared.vo.Result;

/**
 * 
 * 早安资讯<br>
 * cxf的restful webservice服务
 */
@Path("dpmExpress")
public class DpmExpressAction {
	
	private static final Logger LOG = LoggerFactory.getLogger(DpmExpressAction.class);
	
	/**
	 * set injection
	 */
	private IDpmExpressService iExpressService;
	
	/**
	 * 注入RedisService
	 */
	private RedisService loginRedisService;

	/**
	 * 从oa同步早安资讯
	 */
	@Path("sync")
	// 请求类型
	@POST
	// 接收参数类型
	@Consumes(MediaType.APPLICATION_JSON)
	// 返回参数类型
	@Produces(MediaType.APPLICATION_JSON)
	public Object syncFromOa(DpmExpress dpmExpress) {
		// 返回结果集定义
		Result<Object> result = new Result<Object>();
		try {
			// 同步
			iExpressService.syncFromOa(dpmExpress);
			// result
			result.setResult("同步成功");
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(1);
			// errorMessage
			result.setErrorMessage("异常信息" + e.getMessage());
			// result
			result.setResult("同步失败");
		}
		// 返回结果
		return resultToResponse(result);
	}

	/**
	 * 获取最近一天的早安快递
	 */
	@Path("{type}/express/{userId}")
	// 请求类型
	@GET
	// 返回数据类型
	@Produces(MediaType.APPLICATION_JSON)
	public Object getExpressToday(@PathParam("type") int type,
			@PathParam("userId") String userId, @Context UriInfo uriInfo) {
		// 类型判断
		if (type == 1) {
			// 从url中获取userId
			userId = uriInfo.getQueryParameters().getFirst("userId");
		}
		// 定义返回的result
		Result<Object> result = new Result<Object>();
		//晨会类型
		String morningType = getMorningType(type);
		// 认证判断
		if (uriInfoToWhere(userId, uriInfo)) {
			try {
				// 刷新缓存
				loginRedisService.expire(RedisService.DPM_LOGIN_LOGININFO_KEY + userId, MagicNumber.NUM1800);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				//日志输出
				LOG.info("开始获取今日早安快递，参数>>>>>>{userId:"+userId+",morningType:"+morningType+"}");
				// 认证过，返回最近一天早安快递数据
				DpmExpress expressToday = iExpressService.getExpressToday(
						userId, morningType);
				// data
				result.setData(expressToday);
				// result
				result.setResult("查询成功");
			} catch (Exception e) {
				LOG.error("获取今日早安快递失败!!!参数>>>>>>{userId:"+userId+",morningType:"+morningType+"}",e);
				// errorCode
				result.setErrorCode(1);
				// errorMessage
				result.setErrorMessage("异常信息：" + e.getMessage());
				// result
				result.setResult("查询失败");
			}
		} else {
			// errorCode
			result.setErrorCode(DpmConstants.sessionInvalid);
			// errorMessage
			result.setErrorMessage("异常信息：" + "会话失效，请重新登陆");
			// result
			result.setResult("查询失败，请重新登陆");
		}
		// 返回
		return resultToResponse(result);
	}

	/**
	 * 根据id获取早安快递
	 */
	@Path("{type}/express/{userId}/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getMorningMeetingById(@PathParam("type") int type,
			@PathParam("userId") String userId, @PathParam("id") int id,
			@Context UriInfo uriInfo) {
		// 类型判断
		if (type == 1) {
			// 从url中获取userId
			userId = uriInfo.getQueryParameters().getFirst("userId");
		}
		// 定义返回的result
		Result<Object> result = new Result<Object>();
		// 认证判断
		if (uriInfoToWhere(userId, uriInfo)) {
			try {
				// 刷新缓存
				loginRedisService.expire(RedisService.DPM_LOGIN_LOGININFO_KEY + userId, MagicNumber.NUM1800);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				// 认证过，根据id获取早安快递
				DpmExpress expressById = iExpressService.getExpressById(userId,
						id, getMorningType(type));
				// data
				result.setData(expressById);
				// result
				result.setResult("查询成功");
			} catch (Exception e) {
				// errorCode
				result.setErrorCode(1);
				// errorMessage
				result.setErrorMessage("异常信息" + e.getMessage());
				// result
				result.setResult("查询失败");
			}
		} else {
			// errorCode
			result.setErrorCode(DpmConstants.sessionInvalid);
			// errorMessage
			result.setErrorMessage("异常信息：" + "会话失效，请重新登陆");
			// result
			result.setResult("查询失败，请重新登陆");
		}
		// 返回
		return resultToResponse(result);
	}

	/**
	 * 获取历史数据
	 */
	@Path("{type}/history/{userId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getExpressHistory(@PathParam("type") int type,
			@PathParam("userId") String userId, @Context UriInfo uriInfo) {
		// 类型判断
		if (type == 1) {
			// 从url中获取userId
			userId = uriInfo.getQueryParameters().getFirst("userId");
		}
		// 定义返回的result
		Result<Object> result = new Result<Object>();
		if (uriInfoToWhere(userId, uriInfo)) {
			try {
				// 刷新缓存
				loginRedisService.expire(RedisService.DPM_LOGIN_LOGININFO_KEY + userId, MagicNumber.NUM1800);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				// 认证过，获取历史数据
				List<DpmExpress> history = iExpressService.getHistory(userId,
						getMorningType(type));
				// data
				result.setData(history);
				// count
				result.setCount(history.size());
				// result
				result.setResult("查询成功");
			} catch (Exception e) {
				// errorCode
				result.setErrorCode(1);
				// errorMessage
				result.setErrorMessage("异常信息" + e.getMessage());
				// result
				result.setResult("查询失败");
			}
		} else {
			// errorCode
			result.setErrorCode(DpmConstants.sessionInvalid);
			// errorMessage
			result.setErrorMessage("异常信息：" + "会话失效，请重新登陆");
			// result
			result.setResult("查询失败，请重新登陆");
		}
		// 返回
		return resultToResponse(result);
	}

	/**
	 * 完成学习模块
	 */
	@Path("study/{userId}/{id}/{part}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object studyExpress(@PathParam("userId") String userId,
			@PathParam("id") int id, @PathParam("part") int part,
			@Context UriInfo uriInfo) {
		// 类型判断
		if ("userId".equals(userId)) {
			// 从url中获取userId
			userId = uriInfo.getQueryParameters().getFirst("userId");
		}
		// 定义返回的result
		Result<Object> result = new Result<Object>();
		if (uriInfoToWhere(userId, uriInfo)) {
			try {
				// 刷新缓存
				loginRedisService.expire(RedisService.DPM_LOGIN_LOGININFO_KEY + userId, MagicNumber.NUM1800);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				// 完成学习模块
				iExpressService.study(userId, id, part);
				// result
				result.setResult("学习成功");
			} catch (Exception e) {
				// errorCode
				result.setErrorCode(1);
				// errorMessage
				result.setErrorMessage("异常信息" + e.getMessage());
				// result
				result.setResult("学习失败");
			}
		} else {
			// errorCode
			result.setErrorCode(DpmConstants.sessionInvalid);
			// errorMessage
			result.setErrorMessage("异常信息：" + "会话失效，请重新登陆");
			// result
			result.setResult("查询失败，请重新登陆");
		}
		// 返回
		return resultToResponse(result);
	}

	private boolean uriInfoToWhere(String userId, UriInfo uriInfo) {
		// 参数
		Map<String, Object> where = new HashMap<String, Object>();
		// 循环遍历key
		for (String key : uriInfo.getQueryParameters().keySet()) {
			// 存储
			putWhereValue(key, uriInfo.getQueryParameters().get(key), where);
		}
		// casCookie
		String casCookie = String.valueOf(where.get("casCookie"));
		// sessionId
		String sessionId = String.valueOf(where.get("sessionId"));
		// bean
		LoginCheckBean bean = new LoginCheckBean(sessionId, casCookie);
		// 校验是否登录
//		LoginCheckBean value = DpmCacheManager.getCookieAndSession(userId);
		String checkValue = null;
		LoginCheckBean value = null;
		try {
			checkValue = loginRedisService.get(RedisService.DPM_LOGIN_LOGININFO_KEY + userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(StringUtils.isNotBlank(checkValue)){
			String redisSessionId = (String) JSON.parseObject(checkValue).get("sessionId");
			String redisCasCookie = (String) JSON.parseObject(checkValue).get("casCookie");
			value = new LoginCheckBean(redisSessionId,redisCasCookie);
		}
		// sonar整改
		// if (value != null && bean.equals(value)) {
		// return true;
		// } else {
		// return false;
		// }
		// 返回
		return (value != null) && bean.equals(value);
	}

	/**
	 * restful协议的UriInfo获取url问号后面的请求参数
	 */
	private void putWhereValue(String key, List<String> values,
			Map<String, Object> where) {
		// 如果values为空
		if (values.isEmpty()){
			// 跳出
			return;
		}
		// 获取值为空
		if (values.size() == 1 && values.get(0) == null){
			// 跳出
			return;
		}
		// 获取值
		String value = values.get(0).trim();
		// 值为空
		if (value.isEmpty()){
			// 跳出
			return;
		}
		try {
			// 值不为空
			if (values.size() == 1){
				// 存入
				where.put(key, values.get(0));
				// 大于1
			} else if (values.size() > 1){
				// 集合存入
				where.put(key + "_in", values);
			}
		} catch (Exception e) {
			// 抛出异常
//			throw new RuntimeException(e);
			System.out.println(e.toString());
		}
	}

	/**
	 * 封装数据返回给response
	 */
	private Response resultToResponse(Result<Object> result) {
		// 即如果返回
		return Response
				.ok()
				// json返回
				.entity(JSON.toJSONString(result))
				// 头消息类型
				.header(HttpHeaders.CONTENT_TYPE,
						MediaType.APPLICATION_JSON + ";charset=UTF-8")
				// 跨域请求处理
				.header("Access-Control-Allow-Origin", "*").build();
	}

	/**
	 * 根据type字段，获取是资讯的哪个模块
	 */
	private String getMorningType(int type) {
		// 前后端类型 1 = 快递营业部晨会
		if (type == 1) {
			return "快递营业部晨会";
		// 前后端类型 2 = 营业部晨会
		} else if (type == 2) {
			return "营业部晨会";
		// 前后端类型 3 = 外场晨会
		} else if (type == MagicNumber.NUM3) {
			return "外场晨会";
		// 前后端类型 4 = 接送货司机晨会
		} else if (type == MagicNumber.NUM4) {
			return "接送货司机晨会";
		}
		// 抛出异常
		throw new IllegalArgumentException("请求参数错误");
	}
	
	/**
	 * get
	 * @return
	 */
	public IDpmExpressService getiExpressService() {
		return iExpressService;
	}

	/**
	 * set
	 * @param iExpressService
	 */
	public void setiExpressService(IDpmExpressService iExpressService) {
		this.iExpressService = iExpressService;
	}

	/**
	 * setter
	 * @param loginRedisService
	 */
	public void setLoginRedisService(RedisService loginRedisService) {
		this.loginRedisService = loginRedisService;
	}

}
