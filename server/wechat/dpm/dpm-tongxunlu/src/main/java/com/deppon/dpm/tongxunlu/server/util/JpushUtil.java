package com.deppon.dpm.tongxunlu.server.util;


/**
 * jpush推送的api封装.
 * 
 * @author 130126
 * 
 */
public class JpushUtil { 
	/**
	 * 发送通知到全部的系统
	 * 
	 * @param content
	 * @return
	 */
//	public static MessageResult sendNotificationAll(String content) {
//		JPushClient jpushClient = new JPushClient(PropertiesUtil.masterSecret,
//				PropertiesUtil.appKey, PropertiesUtil.timeToLive,
//				DeviceEnum.Android, false);
//		return jpushClient.sendNotificationAll(content);
//	}

	/**
	 * 对指定tag的设备发送通知.
	 * 
	 * @param tag
	 * @param content
	 * @param extras
	 * @return
	 */
//	public static MessageResult sendNotificationByTag(String tag,
//			String content, Map<String, Object> extras) {
//		// 调用jpush官方提供的客户端发送推送信息.
//		JPushClient jpushClient = new JPushClient(PropertiesUtil.masterSecret,
//				PropertiesUtil.appKey, PropertiesUtil.timeToLive,
//				DeviceEnum.Android, false);
//
//		// 按照标签进行发送消息.
//		NotificationParams params = new NotificationParams();
//		params.setReceiverType(ReceiverTypeEnum.TAG);
//		params.setReceiverValue(tag);
//		return jpushClient.sendNotification(content, params, extras);
//	}

	/**
	 * 根据别名进行通知发送.
	 * 
	 * @param alias
	 * @param content
	 * @param extras
	 * @return
	 */
//	public static MessageResult sendNotificationByAlias(String alias,
//			String content, Map<String, Object> extras) {
//		// 调用jpush官方提供的客户端发送推送信息.
//		JPushClient jpushClient = new JPushClient(PropertiesUtil.masterSecret,
//				PropertiesUtil.appKey, PropertiesUtil.timeToLive,
//				DeviceEnum.Android, false);
//		// 按照别名进行发送消息.
//		NotificationParams params = new NotificationParams();
//		params.setReceiverType(ReceiverTypeEnum.ALIAS);
//		params.setReceiverValue(alias);
//		return jpushClient.sendNotification(content, params, extras);
//	}

	/**
	 * 根据标签发送推送.
	 * 
	 * @param tag
	 * @param title
	 * @param content
	 * @param extras
	 *            携带的额外参数信息.
	 * @return
	 */
//	public static MessageResult sendCustomerByTag(String tag, String title,
//			String content, Map<String, Object> extras) {
//		// 调用jpush官方提供的客户端发送推送信息.
//		JPushClient jpushClient = new JPushClient(PropertiesUtil.masterSecret,
//				PropertiesUtil.appKey, PropertiesUtil.timeToLive,
//				DeviceEnum.Android, false);
//		// 按照标签发送自定义消息.
//		CustomMessageParams params = new CustomMessageParams();
//		params.setReceiverType(ReceiverTypeEnum.TAG);
//		params.setReceiverValue(tag);
//		return jpushClient.sendCustomMessage(title, content, params, extras);
//	}

	/**
	 * 按照别名进行发送消息.
	 * 
	 * @param tag
	 * @param title
	 * @param content
	 * @return
	 */
//	public static MessageResult sendCustomerByAlias(String alias, String title,
//			String content, Map<String, Object> extras) {
//		JPushClient jpushClient = new JPushClient(PropertiesUtil.masterSecret,
//				PropertiesUtil.appKey, PropertiesUtil.timeToLive,
//				DeviceEnum.Android, false);
//		CustomMessageParams params = new CustomMessageParams();
//		params.setReceiverType(ReceiverTypeEnum.ALIAS);
//		params.setReceiverValue(alias);
//		return jpushClient.sendCustomMessage(title, content, params, extras);
//	}
}
