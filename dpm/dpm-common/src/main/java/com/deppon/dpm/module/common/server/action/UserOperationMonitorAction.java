package com.deppon.dpm.module.common.server.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.server.service.IUserOperationMonitorService;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.server.util.ThreadLocalUtil;
import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;
import com.deppon.dpm.module.common.shared.domain.UserOperationMonitorEntity;
import com.deppon.dpm.module.common.shared.domain.UserOperationMonitorTypeEntity;
import com.deppon.dpm.module.common.shared.vo.LoginResult;
import com.opensymphony.xwork2.ModelDriven;

public class UserOperationMonitorAction extends BaseAction implements ModelDriven<UserOperationMonitorEntity>{

	private static final Logger LOG = LoggerFactory.getLogger(UserOperationMonitorAction.class);
	
	private static final int EXPIRE = 86400;
	
	// 存入redis的用户操作监控编号名称对应关系的key
	private static final String KEY = "USER_OPERATION_MONITOR_TYPE";
	
	private static final DateFormat DATEF_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private UserOperationMonitorEntity entity = new UserOperationMonitorEntity();
	
	private IUserOperationMonitorService userOperationMonitorService;
	
	// redis
	private RedisService redisService;
	
	// getModel
	public UserOperationMonitorEntity getModel() {
		return entity;
	}

	// 保存监控信息
	public void save(){
		try {
			LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
			EmpExtensionEntity empExtensionEntity = loginResult.getEmpExtensionEntity();
			entity.setOsType(loginResult.getOsType());
			entity.setAppVersion(loginResult.getAppVersion());
			entity.setDeviceToken(empExtensionEntity == null ? null : empExtensionEntity.getDeviceToken());
			entity.setPhoneModel(loginResult.getPhoneModel());
			entity.setOsVersion(loginResult.getOsVersion());
			entity.setPhoneMac(empExtensionEntity == null ? null : empExtensionEntity.getPhoneMac());
		} catch (Exception e) {
			LOG.error("保存用户操作轨迹监控信息获取登录结果集出错>>>>",e);
		}
		try {
			userOperationMonitorService.save(entity);
		} catch (Exception e) {
			LOG.error("保存用户操作轨迹监控信息出错：" + entity.toString(),e);
		}
	}
	
	// 根据工号和时间查询操作轨迹
	public void queryByUserIdAndTime(){
		Map<String,Object> result = new HashMap<String,Object>();
		// 当前页
		int page = entity.getPage();
		// 每页条数
		int rows = entity.getRows();
		int start = 0;
		if(page != 0) {
			start = (page -1) * rows;
		}
		List<UserOperationMonitorEntity> list = userOperationMonitorService.queryByUserIdAndTime(start,rows,entity);
		// 总条数
		long count = userOperationMonitorService.queryCount(entity);
		result.put("total", count);
		result.put("rows", list);
		if(list.size() > 0){
			String redisStr = null;
			// 从缓存中获取操作监控编号名称对应关系
			try {
				redisStr = redisService.get(KEY);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Map<Integer,String> monitorTypeMap = new HashMap<Integer,String>();
			if(StringUtils.isEmpty(redisStr)){
				// 如果为空，查询数据库
				List<UserOperationMonitorTypeEntity> monitorTypes = userOperationMonitorService.queryUserOperationMonitorType();
				for (UserOperationMonitorTypeEntity userOperationMonitorTypeEntity : monitorTypes) {
					monitorTypeMap.put(userOperationMonitorTypeEntity.getId(), userOperationMonitorTypeEntity.getName());
				}
				
				// 将结果存进redis
				redisService.set(KEY, JSON.toJSONString(monitorTypeMap),EXPIRE);
			} else {
				monitorTypeMap = JSON.parseObject(redisStr, new HashMap<String,String>().getClass());
			}
			
			StringBuilder sb = new StringBuilder();
			for (UserOperationMonitorEntity userOperationMonitorEntity : list) {
				// 遍历之前先清空
				sb.delete(0, sb.length());
				try {
					// 解析用户操作
					String operation = userOperationMonitorEntity.getOperation();
					if(operation != null){
						String[] split = operation.split("\\$");
						for (String str : split) {
							String[] operationAndTime = str.split("@");
							String operat = monitorTypeMap.get(Integer.parseInt(operationAndTime[0]));
							String operationTime = DATEF_FORMAT.format(new Date(Long.parseLong(operationAndTime[1])));
							sb.append(operat + "["+operationTime+"]" + "--->@");
						}
						sb.delete(sb.length() - MagicNumber.NUM5, sb.length());
						// 设置处理后的操作
						userOperationMonitorEntity.setOperation(sb.toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		writeToPage(result);
	}

	// setter
	public void setUserOperationMonitorService(
			IUserOperationMonitorService userOperationMonitorService) {
		this.userOperationMonitorService = userOperationMonitorService;
	}

	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}
	
}
