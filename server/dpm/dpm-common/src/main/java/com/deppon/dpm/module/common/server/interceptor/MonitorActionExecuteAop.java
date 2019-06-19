package com.deppon.dpm.module.common.server.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.server.service.IMonitorActionInfoService;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.CommonConstant;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.server.util.MonitorActionRunnableUtil;
import com.deppon.dpm.module.common.shared.domain.MonitorActionInfo;

/**
 * AOP切点
 *
 */
public class MonitorActionExecuteAop {

	/**
	 * log
	 */
	private static final Logger log = LoggerFactory.getLogger(MonitorActionExecuteAop.class);
	
	/**
	 * monitorActionInfoService
	 */
	private IMonitorActionInfoService monitorActionInfoService;
	/**
	 * redisService
	 */
	private RedisService redisService;
	
	/**
	 * action执行时长监控
	 */
	private static List<String> MONITOR_ACTION_NAME = null;
	static {
		MONITOR_ACTION_NAME = new ArrayList<String>();
		MONITOR_ACTION_NAME.add("com.deppon.dpm.tongxunlu.server.action.TongxunluAction.search");
	}
	
	/**
	 * aop切点监控action执行情况
	 * 
	 * @param pjp
	 * @throws Throwable
	 */
	public void monitorAction(ProceedingJoinPoint pjp)  {
		// 获取系统时间
		long beginTime = System.currentTimeMillis();
		// 执行方法
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		// 获取系统时间
		long endTime = System.currentTimeMillis();

        // 使用线程，保存监控数据
        // 操作时间、action地址、执行时长、操作人、请求参数、返回参数
        long duration = endTime - beginTime;
        // 获取request
 		HttpServletRequest request =ServletActionContext.getRequest();
        // 调用方法
        monitorActionInfo(duration,pjp,request);
	}
	
	/**
	 * 保存监控数据
	 * 
	 * @param duration
	 * @param actionUrl
	 * @param map
	 */
	private void monitorActionInfo(long duration,ProceedingJoinPoint pjp,HttpServletRequest request){
		try{
	 		// 请求人工号
	 		String empCode = request.getParameter("userId");
			// 工号判断
			if(empCode != null){
				// 需要验证的empcodeList
				List<String> empCodeList =getMonitorUserIdList();
				// action地址
				String actionUrl = pjp.getSignature().getDeclaringType().getName()+"."+ pjp.getSignature().getName();
				// 是否需要保存action监控数据
				if(empCodeList.contains(empCode) || (actionUrl != null && MONITOR_ACTION_NAME.contains(actionUrl))){
					// 请求参数map
			 		Map map = request.getParameterMap();
					String reqParameter = JSON.toJSONString(map);
					// 保存监控实体类
					MonitorActionInfo info = new MonitorActionInfo();
					info.setEmpCode(empCode);
					info.setActionUrl(actionUrl);
					info.setDuration(String.valueOf(duration));
					info.setReqParameter(reqParameter);
					
					// 线程保存工具类
					MonitorActionRunnableUtil monitorActionUtil = new MonitorActionRunnableUtil();
					monitorActionUtil.monitorActionService = monitorActionInfoService;
					monitorActionUtil.actionInfo = info;
					// 另起线程保存
					Thread thread = new Thread(monitorActionUtil);
					thread.start();
				}
			}else{
				log.info("MonitorActionExecuteAop-----AOP执行，参数中无userid");
			}
		}catch(Exception e){
			log.info("MonitorActionExecuteAop-----保存AOP监控action详细信息出错"+e);
		}
	}
	
	/**
	 * 获取监控userid列表
	 * @return
	 */
	private List<String> getMonitorUserIdList(){
		// 需要验证的empcodeList
		List<String> empCodeList = new ArrayList<String>();
		// 从redis中获取数据
		String empList = redisService.get(CommonConstant.REDIS_KEY_MONITORACTIONEMPCODE_LIST);
		if(StringUtils.isNotEmpty(empList)){
			// 需要验证的empcodeList
			empCodeList = JSON.parseArray(empList, String.class);
		} else{
			empCodeList = monitorActionInfoService.queryMonitorEmpCodeList();
			// 将需要验证的empcodeList放入缓存中
			redisService.set(CommonConstant.REDIS_KEY_MONITORACTIONEMPCODE_LIST, JSON.toJSONString(empCodeList), MagicNumber.NUM1000);
		}
		// 返回
		return empCodeList;
	}
	
	/**
	 * set
	 * @param monitorActionInfoService
	 */
	public void setMonitorActionInfoService(
			IMonitorActionInfoService monitorActionInfoService) {
		this.monitorActionInfoService = monitorActionInfoService;
	}

	/**
	 * set
	 * @param redisService
	 */
	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}
	
}
