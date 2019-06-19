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

//import java.io.ByteArrayInputStream;
import java.io.IOException;
//import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBElement;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
//import javax.xml.bind.PropertyException;
//import javax.xml.bind.Unmarshaller;
//import javax.xml.stream.FactoryConfigurationError;
//import javax.xml.transform.stream.StreamSource;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

//import com.deppon.foss.module.sync.business.jms.ObjectFactory;
//import com.deppon.foss.module.sync.business.jms.SendMdmEmpRequest;
import com.deppon.foss.module.sync.business.jms.SendMdmEmpResponse;
import com.deppon.foss.module.sync.esb.exception.ConvertException;
import com.deppon.foss.module.sync.esb.transfer.IMessageTransform;

//import com.deppon.foss.module.sync.esb.util.JAXBContextUtil;

/**
 * [接口改造]人员信息 消息返回转换类
 * <p style="display:none">
 * modifyRecord
 * </p>
 * <p style="display:none">
 * version:V1.0,author:150953,date:2015-3-25 下午4:24:14
 * </p>
 * 
 * @author 150953 冯世杰
 * @date 2015-3-25 下午4:24:14
 * @since
 * @version
 */
public class SendMdmEmpResponseTrans implements
		IMessageTransform<SendMdmEmpResponse> {
	/**
	 * The Constant CLZZ.
	 */
	private static final Class<SendMdmEmpResponse> CLZZ = SendMdmEmpResponse.class;
	/**
	 * The log.
	 */
	// private static Log log =
	// LogFactory.getLog(SendMdmEmpResponseTrans.class);

	/**
	 * The context.
	 */
	// private static JAXBContext context = JAXBContextUtil.initContext(CLZZ);
	/**
	 * JSON mapper
	 */
	private ObjectMapper mapper = new ObjectMapper();

	/**
	 * 把字符串转换为POJO.
	 */
	@Override
	public SendMdmEmpResponse toMessage(String string) throws ConvertException,
			UnsupportedEncodingException {
		// 发送请求实体
		SendMdmEmpResponse response = null;
		try {
			// string-->class
			response = mapper.readValue(string, CLZZ);
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
		return response;
	}

	/**
	 * 把POJO转换为字符串.
	 */
	@Override
	public String fromMessage(SendMdmEmpResponse value) throws ConvertException {
		// 字符串
		String json = null;
//		// mapper
//		if (mapper == null) {
//			// mapper为空,新建
//			mapper = new ObjectMapper();
//		}
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
