package com.deppon.dpm.tongxunlu.server.util;

import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class PropertiesUtil {
	// master secret
	public static String masterSecret = null;
	// app key
	public static String appKey = null;
	// 从消息推送时起，保存离线的时长。秒为单位。最多支持10天
	public static int timeToLive = 0;
	public static String host;
	public static String pass;
	public static String file;
	public static int port;
	public static String roleUrl;
	public static String cas_login_url;
	public static String auto_login_url;
	public static String cas_login_out;
	public static String cas_url;
	public static String main_page_url;
	static {
		Resource resource = new ClassPathResource("config.properties");
		try {
			Properties properties = PropertiesLoaderUtils
					.loadProperties(resource);
			auto_login_url= properties.getProperty("auto_login_url");
			cas_login_url = properties.getProperty("cas_login_url");
			cas_login_out = properties.getProperty("cas_login_out");
			cas_url = properties.getProperty("cas_url");
			main_page_url = properties.getProperty("main_page_url");
			masterSecret = properties.getProperty("MasterSecret");
			appKey = properties.getProperty("AppKey");
			// 从消息推送时起，保存离线的时长。秒为单位。最多支持10天
			timeToLive = Integer.parseInt(properties.getProperty("TimeToLive"));
			//sonar 整改
//			System.out.println("masterSecret=" + masterSecret + ",appKey="
//					+ appKey + ",timeToLive=" + timeToLive);

			host = properties.getProperty("iphone_host");
			file = properties.getProperty("iphone_file");
			pass = properties.getProperty("iphone_password");
			// 从消息推送时起，保存离线的时长。秒为单位。最多支持10天
			port = Integer.parseInt(properties.getProperty("iphone_port"));
			
			//sonar整改
//			System.out.println("iphone推送配置：host=" + host + ",file=" + file
//					+ ",pass=" + pass + ",port=" + port);

			roleUrl = properties.getProperty("roleurl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
