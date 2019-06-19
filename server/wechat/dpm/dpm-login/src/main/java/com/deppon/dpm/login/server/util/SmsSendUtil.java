package com.deppon.dpm.login.server.util;

import java.io.StringWriter;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.cxf.common.util.Base64Utility;
import org.codehaus.jackson.map.ObjectMapper;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.login.server.domain.SmsInfo;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.vo.Result;

/**
 * 短信发送
 */
public class SmsSendUtil {
	
	/**
	 * 根据短信内容发送短信消息
	 * 
	 * @param content
	 * @param phone
	 * @param url
	 * @param msgType
	 * @param msgSource
	 * @param smsEncrypt
	 * @return
	 * @throws Exception
	 */
	public static int sendVisitorMessage(String content,String phone, String url, String msgType,
			String msgSource, String smsEncrypt) throws Exception {
		// 创建post方法实例
		PostMethod postMethod = new PostMethod(url);
		// 创建Smsinfo对象
		SmsInfo info = new SmsInfo();
		// 手机号
		info.setMobile(phone);
		// 短信内容
		info.setMsgContent(content);
		// 业务类型
		info.setMsgType(msgType);
		// 系统来源
		info.setMsgSource(msgSource);
		// 唯一标识
		info.setUnionId("YWLX" + UUID.randomUUID().toString());
		// 发送时间
		info.setSendTime(new Timestamp(new Date().getTime()));
		// 服务类型(1、短信、2、语音、3、短信语音)
		info.setServiceType("1");
		// 创建list
		List<SmsInfo> list = new ArrayList<SmsInfo>();
		// 赋值list
		list.add(info);
		// 创建objectMapper
		ObjectMapper mapper = new ObjectMapper();
		// 创建StringWriter
		StringWriter stringWriter = new StringWriter();
		// 赋值stringWriter
		mapper.writeValue(stringWriter, list);
		// MD5加密
		String digest = encrypt(smsEncrypt);
		// 定义编码类型
		postMethod.getParams().setContentCharset("UTF-8");
		// 将表单的值放入到post方法中
		postMethod.setRequestBody(new NameValuePair[] {
				new NameValuePair("data_digest", digest),
				new NameValuePair("smsInfo", stringWriter.getBuffer()
						.toString()) });
		// 创建httpClient
		HttpClient httpClient = new HttpClient();
		// 使用httpClient发送post请求
		httpClient.executeMethod(postMethod);
		// 获取返回值
		String bodyAsString = postMethod.getResponseBodyAsString();
		// 获取resultCode
		String resultCode = (String) JSON.parseObject(bodyAsString).get(
				"resultCode");
		if ("1000".equals(resultCode)) {
			return 1;
		}else {
			return 0;
		}
	}
	
	/**
	 * 发送短信消息
	 * 
	 * @param phone
	 * @param url
	 * @param msgType
	 * @param msgSource
	 * @param smsEncrypt
	 * @return
	 * @throws Exception
	 */
	public static String sendMessage(String phone, String url, String msgType,
			String msgSource, String smsEncrypt) throws Exception {
		// 创建post方法实例
		PostMethod postMethod = new PostMethod(url);
		// 创建Smsinfo对象
		SmsInfo info = new SmsInfo();
		// 手机号
		info.setMobile(phone);
		// 获取验证码
		String code = getValidateCode();
		// 短信内容
		info.setMsgContent("本次登录验证码为：" + code
				+ "，验证码有效时间为两分钟。注：短信验证可到“移动办公-我-设置”中关闭。");
		// 业务类型
		info.setMsgType(msgType);
		// 系统来源
		info.setMsgSource(msgSource);
		// 唯一标识
		info.setUnionId("YWLX" + UUID.randomUUID().toString());
		// 发送时间
		info.setSendTime(new Timestamp(new Date().getTime()));
		// 服务类型(1、短信、2、语音、3、短信语音)
		info.setServiceType("1");
		// 创建list
		List<SmsInfo> list = new ArrayList<SmsInfo>();
		// 赋值list
		list.add(info);
		// 创建objectMapper
		ObjectMapper mapper = new ObjectMapper();
		// 创建StringWriter
		StringWriter stringWriter = new StringWriter();
		// 赋值stringWriter
		mapper.writeValue(stringWriter, list);
		// MD5加密
		String digest = encrypt(smsEncrypt);
		// 定义编码类型
		postMethod.getParams().setContentCharset("UTF-8");
		// 将表单的值放入到post方法中
		postMethod.setRequestBody(new NameValuePair[] {
				new NameValuePair("data_digest", digest),
				new NameValuePair("smsInfo", stringWriter.getBuffer()
						.toString()) });
		// 创建httpClient
		HttpClient httpClient = new HttpClient();
		// 使用httpClient发送post请求
		httpClient.executeMethod(postMethod);
		// 创建Result
		Result<Object> result = new Result<Object>();
		// 获取返回值
		String bodyAsString = postMethod.getResponseBodyAsString();
		// 获取resultCode
		String resultCode = (String) JSON.parseObject(bodyAsString).get(
				"resultCode");
		// 返回值赋值到result中
		result.setErrorMessage(bodyAsString);
		// 判断resultCode是否为1000
		if ("1000".equals(resultCode)) {
			// 验证码
			result.setData(code);
		}
		// 赋值result
		result.setErrorCode(Integer.parseInt(resultCode));
		// json转换
		return JSON.toJSONString(result);
	}

	/**
	 * 获取随机数（验证码）
	 * 
	 * @return
	 */
	private static String getValidateCode() {
		// 创建Random对象
		Random random = new Random();
		// 随机生成随机数
		int value = random.nextInt(MagicNumber.NUM899999) + MagicNumber.NUM100000;
		// 返回随机数
		return String.valueOf(value);
	}

	/**
	 * 使用MD5加密参数 base64对加密参数进行编码
	 * 
	 * @param param
	 * @return
	 */
	private static String encrypt(String param) {
		// 判断参数是否为空
		if (param == null) {
			// 如为空，直接返回
			return null;
		}
		// 定义返回值
		String result = null;
		try {
			// 使用MD5加密
			MessageDigest digest = MessageDigest.getInstance("MD5");
			// 对加密后的参数，进行base64编码
			result = Base64Utility
					.encode(digest.digest(param.getBytes("UTF-8")));
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
		}
		// 返回结果集
		return result;
	}

}