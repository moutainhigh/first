package com.deppon.dpm.tongxunlu.server.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.PushPayload.Builder;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.vo.JPushParam;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;
import com.deppon.dpm.tongxunlu.server.service.IJPushRegistBindService;
import com.deppon.dpm.tongxunlu.server.service.IJpushMsgCentreService;
import com.deppon.dpm.tongxunlu.server.service.ITongxunLuService;
import com.deppon.dpm.tongxunlu.shared.domain.JpushMsgCentreEntity;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;

public class JPushNewService implements IJPushNewService{
	
	private static final Logger LOG = LoggerFactory.getLogger(JPushNewService.class);
	
	private boolean APNSProduction;
	
	private IJPushRegistBindService jPushRegistBindService;
	
	private ITongxunLuService tongxunLuService;
	
	private JPushClient jpushClient;
	
	private JdbcTemplate jdbcTemplate;
	
	private IJpushMsgCentreService jpushMsgCentreService;
	
	/**
	 * 查询所有本部
	 */
	public List<OrganizationVO> queryPrimaryDept() {
		OrganizationVO searchVo = new OrganizationVO();
		searchVo.setParentId(MagicNumber.NUM104);
		return tongxunLuService.searchOrg(searchVo, 0, -1);
	}
	
	/**
	 * 校验验证信息
	 */
	public int authSecret(String appKey, String masterSecret) {
		String sql = "SELECT count(*) from jpush_auth_info where app_key = ? AND master_secret = ?";
		return (int) jdbcTemplate.queryForLong(sql, appKey,masterSecret);
	}
	
	// 发送推送消息到所有平台、所有设备
	private PushResult sendPush(Platform platform,Audience audience,Notification notification) throws APIConnectionException, APIRequestException {
		PushPayload payload = new Builder()
				.setPlatform(platform)
				.setAudience(audience)
				.setNotification(notification)
				.setOptions(
						Options.newBuilder().setApnsProduction(APNSProduction)
								.build())
				.build();

		// 发送
		return jpushClient.sendPush(payload);
	}
	
	private Map<String,String> setNotificationExtras(JPushParam entity) {
		Map<String,String> extras = new HashMap<String,String>();
		extras.put("a", entity.getIntoMC() + ""); // 是否进入消息中心
		extras.put("b", entity.getIsEcc() + ""); // 是否是ECC消息
		extras.put("c", entity.getLinktype() + ""); // 链接类型
		extras.put("d", entity.getLinkaddr()); // 链接地址
		extras.put("e", entity.getContent()); // 消息内容
		if(null == entity.getExtras()) {
			entity.setExtras(new HashMap<String,String>());
		}
		extras.put("z", JSON.toJSONString(entity.getExtras())); // 其他产品线的参数字段
		
		return extras;
	}
	
	/**
	 * 全员推送
	 * @throws APIRequestException 
	 * @throws APIConnectionException 
	 */
//	public PushResult pushAll(JPushParam entity) throws APIConnectionException, APIRequestException {
//		
//		// 设置通知
//		Notification notification = Notification.newBuilder()
//        .addPlatformNotification(IosNotification.newBuilder()
//                .setAlert(entity.getAlert())
//                .setBadge(1)
//                .setSound("sound")
//                .addExtras(this.setNotificationExtras(entity))
//                .build())
//        .addPlatformNotification(AndroidNotification.newBuilder()
//        		.setAlert(entity.getAlert())
//        		.addExtras(this.setNotificationExtras(entity))
//        		.build())
//        .build();
//        
//        return this.sendPush(Platform.all(),Audience.all(),notification);
//	}
	
	public void saveToMsgCentre (JPushParam entity, int pushConditionKey) {
		// 记录到推送记录表中
		JpushMsgCentreEntity msgCentreEntity = new JpushMsgCentreEntity();
		msgCentreEntity.setAlert(entity.getAlert());
		msgCentreEntity.setContent(entity.getContent());
		msgCentreEntity.setLinkType(entity.getLinktype());
		msgCentreEntity.setLinkAddr(entity.getLinkaddr());
		msgCentreEntity.setExtras(JSON.toJSONString(entity.getExtras()));
		msgCentreEntity.setPushConditionKey(pushConditionKey); // 推送类型
		msgCentreEntity.setCreateTime(new Date());
		
		if(StringUtils.isNotBlank(entity.getPushConditionValue())) {
			String[] conditionValArr = entity.getPushConditionValue().trim().split(",");
			for (String str : conditionValArr) {
				msgCentreEntity.setPushConditionVal(str); 
				try {
					jpushMsgCentreService.save(msgCentreEntity);
				} catch (Exception e) {
					LOG.error("保存推送记录到消息中心出错!!!  " + msgCentreEntity.toString(),e);
				}
			}
		}
	}
	
	/**
	 * 根据工号推送
	 * @throws APIRequestException 
	 * @throws APIConnectionException 
	 */
	public void pushByUserIds(JPushParam entity) throws APIConnectionException, APIRequestException {
		// 设置通知
		Notification notification = Notification.newBuilder()
        .addPlatformNotification(IosNotification.newBuilder()
                .setAlert(entity.getAlert())
                .setContentAvailable(true)
                .setBadge(1)
                .setSound("sound")
                .addExtras(this.setNotificationExtras(entity))
                .build())
        .addPlatformNotification(AndroidNotification.newBuilder()
        		.setAlert(entity.getAlert())
        		.addExtras(this.setNotificationExtras(entity))
        		.build())
        .build();
				
		String[] userIdArr = entity.getUserIds().split(",");
		// 推送的userId集合
		List<String> userIds = new ArrayList<String>();
		
		for (String userId : userIdArr) {
			
			if(StringUtils.isBlank(userId)) {
				continue;
			}
			userIds.add(userId);
			
			// 每一1000条推送一次
			if(userIds.size() == MagicNumber.NUM1000) {
				try {
					// 推送
					this.sendPush(Platform.all(),Audience.alias(userIds),notification);
				} catch (Exception e) {
					LOG.error("根据工号每1000条循环推送出错!!!",e);
				} 
				// 清空
				userIds.clear();
			}
		}
		
		// 不足1000条的
		if(userIds.size() > 0) {
			// 推送
			this.sendPush(Platform.all(),Audience.alias(userIds),notification);
		}
	}
	
	private void pushByJpushRegistIds(JPushParam entity,List<String> registIdList) throws APIConnectionException, APIRequestException {
		// 设置通知
		Notification notification = Notification.newBuilder()
        .addPlatformNotification(IosNotification.newBuilder()
                .setAlert(entity.getAlert())
                .setBadge(1)
                .setSound("sound")
                .addExtras(this.setNotificationExtras(entity))
                .build())
        .addPlatformNotification(AndroidNotification.newBuilder()
        		.setAlert(entity.getAlert())
        		.addExtras(this.setNotificationExtras(entity))
        		.build())
        .build();
				
		// 推送的注册id集合
		List<String> registrationIds = new ArrayList<String>();
		
		for (String registId : registIdList) {
			
			if(StringUtils.isBlank(registId)) {
				continue;
			}
			registrationIds.add(registId);
			
			// 每一1000条推送一次
			if(registrationIds.size() == MagicNumber.NUM1000) {
				try {
					// 推送
					this.sendPush(Platform.all(),Audience.registrationId(registrationIds),notification);
				} catch (Exception e) {
					LOG.error("根据工号每1000条循环推送出错!!!",e);
				} 
				// 清空
				registrationIds.clear();
			}
		}
		
		// 不足1000条的
		if(registrationIds.size() > 0) {
			// 推送
			this.sendPush(Platform.all(),Audience.registrationId(registrationIds),notification);
		}

	}
	
	/**
	 * 根据机型推送
	 * @param entity
	 * @throws APIConnectionException
	 * @throws APIRequestException
	 */
//	private void pushByOsType(JPushParam entity) throws APIConnectionException, APIRequestException {
//		Notification notification = null;
//		Platform platform = null;
//		// 推送到ios
//		if("iphone".equalsIgnoreCase(entity.getPushConditionValue().trim())) {
//			notification = Notification.newBuilder()
//			        .addPlatformNotification(IosNotification.newBuilder()
//			                .setAlert(entity.getAlert())
//			                .setBadge(1)
//			                .setSound("sound")
//			                .addExtras(this.setNotificationExtras(entity))
//			                .build())
//			        .build();
//			platform = Platform.ios();
//		} 
//		
//		// 推送到android
//		else if("android".equalsIgnoreCase(entity.getPushConditionValue().trim())) {
//			notification = Notification.newBuilder()
//					.addPlatformNotification(AndroidNotification.newBuilder()
//			        		.setAlert(entity.getAlert())
//			        		.addExtras(this.setNotificationExtras(entity))
//			        		.build())
//	        		.build();
//			platform = Platform.android();
//		}
//        
//        this.sendPush(platform,Audience.all(),notification);
//	}
	
	/**
	 * 根据层级推送
	 * @param entity
	 * @throws APIConnectionException
	 * @throws APIRequestException
	 */
	private void pushByJoblevel(JPushParam entity) throws APIConnectionException, APIRequestException {
		List<String> jpushRegistIds = jPushRegistBindService.queryJpushRegistIdsByJoblevels(entity.getPushConditionValue().trim());
		this.pushByJpushRegistIds(entity,jpushRegistIds);
	}
	
	/**
	 * 根据岗位推送
	 * @param entity
	 * @throws APIConnectionException
	 * @throws APIRequestException
	 */
	private void pushByJobname(JPushParam entity) throws APIConnectionException, APIRequestException {
		List<String> jpushRegistIds = jPushRegistBindService.queryJpushRegistIdsByJobnames(entity.getPushConditionValue().trim());
		
		this.pushByJpushRegistIds(entity,jpushRegistIds);
	}
	
	/**
	 * 根据本部推送
	 * @param entity
	 * @throws APIConnectionException
	 * @throws APIRequestException
	 */
	private void pushByPrimaryDept(JPushParam entity) throws APIConnectionException, APIRequestException {
		List<String> jpushRegistIds = jPushRegistBindService.queryJpushRegistIdsByPrimaryDepts(entity.getPushConditionValue().trim());
		this.pushByJpushRegistIds(entity,jpushRegistIds);
	}
	
	/**
	 * 根据条件推送
	 * @throws APIRequestException 
	 * @throws APIConnectionException 
	 */
	public void pushByCondition(JPushParam entity) throws APIConnectionException, APIRequestException {

		String conditionKey = entity.getPushConditionKey().trim();
		
//		if("osType".equalsIgnoreCase(conditionKey)) {
//			// 根据机型推送
//			this.pushByOsType(entity);	
//		} 
		
		if("joblevel".equalsIgnoreCase(conditionKey)) {
			// 根据层级推送
			this.pushByJoblevel(entity);	
			
			// 保存推送记录
			this.saveToMsgCentre(entity, 1);
		} else if("jobname".equalsIgnoreCase(conditionKey)) {
			// 根据岗位推送
			this.pushByJobname(entity);
			
			// 保存推送记录
			this.saveToMsgCentre(entity, 2);
		} else if("dept".equalsIgnoreCase(conditionKey)) {
			// 根据本部推送
			this.pushByPrimaryDept(entity);
		}
	}

	// setter
	public void setjPushRegistBindService(
			IJPushRegistBindService jPushRegistBindService) {
		this.jPushRegistBindService = jPushRegistBindService;
	}

	// setter
	public void setAPNSProduction(boolean aPNSProduction) {
		this.APNSProduction = aPNSProduction;
	}

	public void setTongxunLuService(ITongxunLuService tongxunLuService) {
		this.tongxunLuService = tongxunLuService;
	}

	public void setJpushClient(JPushClient jpushClient) {
		this.jpushClient = jpushClient;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setJpushMsgCentreService(
			IJpushMsgCentreService jpushMsgCentreService) {
		this.jpushMsgCentreService = jpushMsgCentreService;
	}

}
