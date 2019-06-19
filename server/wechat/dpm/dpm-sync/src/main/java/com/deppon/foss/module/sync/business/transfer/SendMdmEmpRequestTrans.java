/*
 * Copyright by Deppon and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about Deppon from
 *
 *      http://www.deppon.com
 *
 */
package com.deppon.foss.module.sync.business.transfer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.deppon.foss.module.sync.business.jms.SendMdmEmpRequest;
import com.deppon.foss.module.sync.esb.exception.ConvertException;
import com.deppon.foss.module.sync.esb.transfer.IMessageTransform;

/**
 * [接口改造]人员信息 消息转换类
 * <p style="display:none">
 * modifyRecord
 * </p>
 * <p style="display:none">
 * version:V1.0,author:150953,date:2015-3-25 下午3:23:57
 * </p>
 * 
 * @author 150953 冯世杰
 * @date 2015-3-25 下午3:23:57
 * @since
 * @version
 */
public class SendMdmEmpRequestTrans implements
		IMessageTransform<SendMdmEmpRequest> {
	/**
	 * The Constant CLZZ.
	 */
	private static final Class<SendMdmEmpRequest> CLZZ = SendMdmEmpRequest.class;
	/**
	 * JSON mapper
	 */
	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 *  把字符串转换为POJO.
	 */
	@Override
	public SendMdmEmpRequest toMessage(String string) throws ConvertException,
			UnsupportedEncodingException {
		// 发送请求实体
		SendMdmEmpRequest request = null;
		try {
			// string-->class
			request = mapper.readValue(string, CLZZ);
			// catch异常
		} catch (JsonParseException e) {
			// 抛出异常
			throw new ConvertException("反序列化" + CLZZ.getName() + "时失败！", e);
			// catch异常
		} catch (JsonMappingException e) {
			// 抛出异常
			throw new ConvertException("反序列化" + CLZZ.getName() + "时失败！", e);
			// catch异常
		} catch (IOException e) {
			// 抛出异常
			throw new ConvertException("反序列化" + CLZZ.getName() + "时失败！", e);
		}
		// 返回请求信息
		return request;
	}
	
	/**
	 * 把POJO转换为字符串.
	 */
	@Override
	public String fromMessage(SendMdmEmpRequest value) throws ConvertException {
		// 字符串
		String json = null;
		// mapper
		if (mapper == null) {
			// mapper为空,新建
			mapper = new ObjectMapper();
		}
		// 值为空
		if (value == null) {
			// 跳出
			return null;
		}
		try {
			// class-->string
			json = mapper.writeValueAsString(value);
			// catch异常
		} catch (JsonGenerationException e) {
			// 抛出异常
			throw new ConvertException("序列化" + value.getClass().getName() + "时失败！", e);
			// catch异常
		} catch (JsonMappingException e) {
			// 抛出异常
			throw new ConvertException("序列化" + value.getClass().getName() + "时失败！", e);
			// catch异常
		} catch (IOException e) {
			// 抛出异常
			throw new ConvertException("序列化" + value.getClass().getName() + "时失败！", e);
		}
		// 返回jsonString
		return json;
	}
}
