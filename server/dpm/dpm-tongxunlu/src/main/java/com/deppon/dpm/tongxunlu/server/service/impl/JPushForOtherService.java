package com.deppon.dpm.tongxunlu.server.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.server.service.IJPushNewMonitorService;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.Base64;
import com.deppon.dpm.module.common.server.util.DES;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.domain.JpushMonitorEntity;
import com.deppon.dpm.module.common.shared.vo.JPushParam;
import com.deppon.dpm.tongxunlu.server.job.MsgCentreRunnable;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;

public class JPushForOtherService {
	
	private static final Logger LOG = LoggerFactory.getLogger(JPushForOtherService.class);

	private IJPushNewService jPushNewService;
	
	private RedisService redisService;
	
	// 推送监控
	private IJPushNewMonitorService jPushNewMonitorService;
	
	private static final String JPUSH_SECRET_KEY = "JPUSH_SECRET_";
	
	private static final int EXPIRE = 600;
	
	@POST
	@Path("pushByUserIds")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response pushByUserIds(@Context HttpServletRequest request,String content) throws UnsupportedEncodingException {
		String headerAuthStr = null;
		String cacheAuthStr = null;
		JpushMonitorEntity monitorResult = null;
		
		// 获取请求头里面的验证信息
		headerAuthStr = request.getHeader("Authorization");
		// 解密
		String decodedHeaderAuthStr = new String(Base64.decode(headerAuthStr),"utf-8");
		
		JPushParam jPushParam = JSON.parseObject(content, JPushParam.class);
		// 从缓存获取验证信息
		cacheAuthStr = redisService.get(JPUSH_SECRET_KEY + jPushParam.getAppKey());
		// 认证
		if(!(StringUtils.isNotEmpty(decodedHeaderAuthStr) && decodedHeaderAuthStr.equals(cacheAuthStr))) {
			// 认证不成功
			LOG.info("JPushForOther.pushByUserIds安全验证失败!!! auth={解密后头验证信息:"+decodedHeaderAuthStr+",缓存验证信息:"+cacheAuthStr+"}");
			return Response.ok("{\"errcode\":1,\"data\":null,\"errMsg\":\"安全验证失败\"}").build();
		}
		
		// 推送监控结果
		String userIds = jPushParam.getUserIds();
		// 监控结果集封装
		monitorResult = new JpushMonitorEntity(
				jPushParam.getAppKey(),
				jPushParam.getUserIds(),
				jPushParam.getAlert(),
				jPushParam.getContent(),
				jPushParam.getIntoMC(),
				jPushParam.getIsEcc(),
				jPushParam.getLinktype(),
				jPushParam.getLinkaddr(),
				jPushParam.getExtras() == null ? null : jPushParam.getExtras().toString());
		if(StringUtils.isEmpty(userIds)) {
			monitorResult.setCount(0);
		} else {
			monitorResult.setCount(userIds.split(",").length);
		}
		// 打印日志
		LOG.info("["+jPushParam.getAppKey()+"]开始推送...content=" + content);
		
		monitorResult.setStartTime(new Date());
		try {
		// 推送
		jPushNewService.pushByUserIds(jPushParam);
		
		monitorResult.setPushResult(true);
		monitorResult.setEndTime(new Date());
		try {
			// 推送成功后将缓存对应的校验信息删除
			redisService.del(JPUSH_SECRET_KEY + jPushParam.getAppKey());
		} catch (Exception e) {
			LOG.error("JPushForOther.pushByUserIds删除缓存校验信息出错!!! key=" + JPUSH_SECRET_KEY + jPushParam.getAppKey(),e);
		}
		
		LOG.info("["+jPushParam.getAppKey()+"]推送成功...");
			
		} catch (Exception e) {
			LOG.error("JPushForOther.pushByUserIds出错!!! 请求头参数为>>>>"+headerAuthStr+",请求体参数为>>>>"+content,e);
		}
		

		// 插入推送成功监控信息
		try {
			jPushNewMonitorService.savePushInfo(monitorResult);
			// 开启线程来保存推送记录到消息中心
			new Thread(new MsgCentreRunnable(jPushParam, jPushNewService)).start();
			
			return Response.ok("{\"errcode\":0,\"data\":null,\"errMsg\":\"推送成功\"}").build();
		} catch (Exception e) {
			LOG.error("保存推送监控信息出错!!! " + monitorResult.toString(),e);
		}
		
		
		// 插入推送失败监控信息
		try {
			monitorResult.setEndTime(new Date());
			monitorResult.setPushResult(false);
			jPushNewMonitorService.savePushInfo(monitorResult);
		} catch (Exception e) {
			LOG.error("保存推送监控信息出错!!!" + monitorResult.toString(),e);
		}
		return Response.ok("{\"errcode\":1,\"data\":null,\"errMsg\":\"推送失败\"}").build();
	}
	
	/**
	 * 安全校验获取秘钥
	 * @param request
	 * @return
	 */
	@POST
	@Path("checkSecret")
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.TEXT_HTML)
	public Response checkSecret(@Context HttpServletRequest request) {
		String appKey = null;
		String masterSecret = null;
		try {
			// 获取请求头里面的验证信息
			String authStr = request.getHeader("Authorization");
			String authJsonStr = new String(Base64.decode(authStr),"utf-8");
			appKey = authJsonStr.split(":")[0];
			masterSecret = authJsonStr.split(":")[1];
			// 认证
			int i = jPushNewService.authSecret(appKey,masterSecret);
			if(i != 1) {
				// 认证不成功
				LOG.info("JPushForOther.checkSecret安全验证失败!!! auth={headerAuthInfo:"+authStr+",appKey:"+appKey+",masterSecret:"+masterSecret+"}");
				return Response.ok("{\"errcode\":1,\"data\":null,\"errMsg\":\"安全验证失败\"}").build();
			}
			// 认证成功，生成8位随机数秘钥
			Random  random = new Random();
	        StringBuilder sb = new StringBuilder(MagicNumber.NUM8);
	        for(int j = 0; j < MagicNumber.NUM8; j++) {
	        	sb.append(random.nextInt(MagicNumber.NUM10));
	        }
	        // 将验证信息加密存入缓存
	        String authInfo = DES.encryptDES(appKey + ":" + masterSecret, sb.toString());
	        // 将秘钥放入缓存10分钟后过期
			redisService.set(JPUSH_SECRET_KEY + appKey, authInfo, EXPIRE);
			return Response.ok("{\"errcode\":0,\"data\":\""+sb.toString()+"\",\"errMsg\":\"安全验证成功\"}").build();
		} catch (Exception e) {
			LOG.error("JPushForOther.checkSecret安全验证失败!!! auth={appKey:"+appKey+",masterSecret:"+masterSecret+"}",e);
		}
		// 返回
		return Response.ok("{\"errcode\":1,\"data\":null,\"errMsg\":\"安全验证失败\"}").build();
	}
	
	// setter
	public void setjPushNewService(IJPushNewService jPushNewService) {
		this.jPushNewService = jPushNewService;
	}

	// setter
	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}


	// setter
	public void setjPushNewMonitorService(
			IJPushNewMonitorService jPushNewMonitorService) {
		this.jPushNewMonitorService = jPushNewMonitorService;
	}
	
}
