package com.deppon.app.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import base.util.PropertiesTools;

/**
 * @title: LogClientUtil
 * @description: 日志客户端工具类
 * @author: wuyaqing
 * @date: 2014-4-17 下午4:31:26
 */
public class LogClientUtil {

	// 日志
	protected static Log logger = LogFactory.getLog(LogClientUtil.class);

	// 保存系统请求url
	public static String SYS_REQ_URL;

	// 请求次数常量
	public static final int COUNT = 10;

	// 请求参数
	public static final String DPMONTAL_REQ_PARAS = "dpmontal:reqInfoParas";
	// 调用接口密码key
	public static final String PASSWORD = "PassWord";
	// 应用英文简称key
	public static final String APPCODE = "AppCode";
	// 类全名+方法名key
	public static final String METHODNAME = "METHOD_NAME";
	// 命名空间key
	public static final String NAMESPACE = "NAMESPACE";
	// 用户账号key
	public static final String EMPCODE = "EmpCode";
	// 用户IP地址key
	public static final String CLIENTIP = "CLIENT_IP";
	// http请求url key
	public static final String REQUESTURL = "REQUEST_URL";
	// http请求参数信息key
	public static final String REQUESTPARA = "REQUEST_PARA";
	// http请求其他信息key
	public static final String REQUESTINFO = "REQUEST_INFO";
	// 业务系统IP地址key
	public static final String SERVERIP = "SERVER_IP";
	// 服务请求时间key
	public static final String REQTIME = "REQ_TIME";
	// 服务响应时间key
	public static final String RESPTIME = "RESP_TIME";

	// 调用接口密码value
	public static String PWD = null;
	// 应用英文简称value
	public static String APP_CODE = null;
	// 命名空间value 接口指的是mybatis文件里面的命名空间 DPM项目没有故用空串表示，不传接口报错
	public static final String NAME_SPACE = " ";

	// .分割符
	public static final String DECOLLATOR = ".";
	// 业务系统ip
	public static String serverIp = null;

	static {
		/**
		 * 初始化业务系统的ip
		 */
		try {
			InetAddress ip = null;
			Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
			while (interfaces.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) interfaces
						.nextElement();
				Enumeration inetAddresses = ni.getInetAddresses();
				while (inetAddresses.hasMoreElements()) {
					InetAddress inetAddress = (InetAddress) inetAddresses
							.nextElement();
					if (!inetAddress.isLoopbackAddress()) {
						ip = inetAddress;
					}
				}
			}
			if (ip == null) {
				ip = InetAddress.getLocalHost();
			}
			serverIp = ip.getHostAddress();
		} catch (Exception e) {
			serverIp = "unknowProducerIp";
		}
		APP_CODE = PropertiesTools.getPathTypeByConfigProperties("log_appcode");
		PWD = PropertiesTools.getPathTypeByConfigProperties("log_password");
		// 初始化系统请求url
		SYS_REQ_URL = PropertiesTools
				.getPathTypeByConfigProperties("log_service");
	}

	/**
	 * @MethodName: getNowDate
	 * @description: 按特定格式返回当前时间
	 * @author: wuyaqing
	 * @date: 2014-4-18 下午5:59:56
	 * @return String
	 */
	public static String getNowDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS");
		return formatter.format(currentTime);
	}

	/**
	 * @MethodName: getMethodName
	 * @description: 获取调用者的方法全名（类名+方法名）
	 * @author: wuyaqing
	 * @date: 2014-4-17 下午4:58:47
	 * @return String 类名+方法名
	 */
	public static String getMethodName() {

		// 获取调用者的类名,并赋值给StringBuffer类型的变量sb
		StringBuffer sb = new StringBuffer(
				new Exception().getStackTrace()[1].getClassName());
		// 调用者的类名与方法名直接用.分割
		sb.append(DECOLLATOR);
		// 获取调用者的方法名
		sb.append(new Exception().getStackTrace()[1].getMethodName());

		// 返回调用者的全名
		return sb.toString();
	}

}
