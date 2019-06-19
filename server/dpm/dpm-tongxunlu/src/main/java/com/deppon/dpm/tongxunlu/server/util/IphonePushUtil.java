/**
 * MainSend.java
 * 版权所有(C) 2012 
 * 创建:cuiran 2012-07-24 11:31:35
 */
package com.deppon.dpm.tongxunlu.server.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javapns.back.PushNotificationManager;
import javapns.back.SSLConnectionHelper;
import javapns.data.Device;
import javapns.data.PayLoad;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 发送苹果的推送信息工具类.
 * 
 * @author 130126
 * 
 */
public class IphonePushUtil {
	/**
	 * log
	 */
	private static Log log = LogFactory.getLog(IphonePushUtil.class);
	/**
	 * 对一个苹果用户发送推送消息.
	 */
	public static void sendMessage(String token, String content,
			Map<String, String> extras) {
		try {
			// 定义消息模式
			PayLoad payLoad = new PayLoad();
			// 提示
			payLoad.addAlert(content);
			// 消息
			payLoad.addBadge(1);
			// 声音类型
			payLoad.addSound("default");
			// 添加消息上面自带的额外的参数.
			if (extras != null) {
				// 遍历
				Set<Entry<String, String>> s = extras.entrySet();
				// 迭代
				Iterator<Entry<String, String>> it = s.iterator();
				// 判断
				while (it.hasNext()) {
					// 是否含有下一个
					Entry<String, String> e = it.next();
					// 添加
					payLoad.addCustomDictionary(e.getKey(), e.getValue());
				}
			}
			// 注册deviceToken
			PushNotificationManager pushManager = PushNotificationManager.getInstance();
			// 属性
			pushManager.initializeConnection(PropertiesUtil.host,
					PropertiesUtil.port, PropertiesUtil.file,
					PropertiesUtil.pass,
					SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);
			// 添加设备1
			pushManager.addDevice("iPhone", token);
			// 添加设备1
			pushManager.addDevice("iPhone2", token);
			// 发送推送1
			Device client = pushManager.getDevice("iPhone");
			// 发送1
			pushManager.sendNotification(client, payLoad);
			// 发送推送2
			Device client2 = pushManager.getDevice("iPhone2");
			// 发送2
			pushManager.sendNotification(client2, payLoad);
			// 停止连接APNS
			pushManager.stopConnection();
			// 删除deviceToken
			pushManager.removeDevice("iPhone");
			// 删除deviceToken2
			pushManager.removeDevice("iPhone2");
		} catch (Exception ex) {
			// 打印错误信息
			ex.printStackTrace();
			// log
			log.error("推送消息错误", ex);
		}
	}

	/**
	 * 对多个苹果用户发送推送消息.
	 */
	public static int sendMessage(List<String> tokens, String content,
			Map<String, Object> extras) {
		if (extras == null) {
			// 异常抛出
			throw new IllegalArgumentException();
		}
		// 注册deviceToken
		PushNotificationManager pushManager = PushNotificationManager.getInstance();
		// 返回值
		int i = 0;
		try {
			// 定义消息模式
			PayLoad payLoad = new PayLoad();
			// 提示
			payLoad.addAlert(content);
			// 数量
			int sum = Integer.valueOf((String) extras.get("sum"));
			// 标签
			payLoad.addBadge(sum);
			// 声音
			payLoad.addSound("default");
			// 添加消息上面自带的额外的参数.
			Object url = extras.get("url");
			if (url != null && !"".equals((url + "").trim())) {
				// 版本更新是1
				extras.put("type", "1");
				// 其他情况是0
			} else {
				extras.put("type", "0");
			}
			pushManager.initializeConnection(PropertiesUtil.host,
					PropertiesUtil.port, PropertiesUtil.file,
					PropertiesUtil.pass,
					SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);
			// 循环
			for (String token : tokens) {
				// id
				String deviceId = "iPhone" + (i++);
				// 添加设备
				pushManager.addDevice(deviceId, token);
				// 获取设备
				Device client = pushManager.getDevice(deviceId);
				// 发送
				pushManager.sendNotification(client, payLoad);
			}
			// 返回
			return 1;
		} catch (Exception ex) {
			// 错误打印
			ex.printStackTrace();
			// log
			log.error("对多个苹果用户发送推送消息错误", ex);
			// 返回
			return 0;
		} finally {
			for (; i > 0; i--) {
				// 删除deviceToken
				try {
					// 删除设备
					pushManager.removeDevice("iPhone" + (i - 1));
				} catch (Exception e) {
					//错误打印
					e.printStackTrace();
				}
			}
			// 停止连接APNS
			try {
				// 链接停止
				pushManager.stopConnection();
			} catch (IOException e) {
				//错误打印
				e.printStackTrace();
			}
		}
	}
	/************************************************
	 * 测试推送服务器地址：gateway.sandbox.push.apple.com /2195
	 * 产品推送服务器地址：gateway.push.apple.com / 2195
	 * 
	 * 需要javaPNS_2.2.jar包
	 ***************************************************/
	/*public static void main(String[] args) throws Exception {
		try {
			// 从客户端获取的deviceToken
			String token = "d31b0f21cce48a7d843bd1b47610bb55930b391a4d661aa5e1388c2d10817be6";
			List<String> tt = new ArrayList<String>();
			tt.add(token);
			tt.add(token);
			IphonePushUtil.sendMessage(tt, "测试发送的推送信息...", null);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}*/
}
