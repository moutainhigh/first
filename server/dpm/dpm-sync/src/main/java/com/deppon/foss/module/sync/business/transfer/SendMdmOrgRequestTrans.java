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
import com.deppon.foss.module.sync.business.jms.SendMdmOrgRequest;
import com.deppon.foss.module.sync.esb.exception.ConvertException;
import com.deppon.foss.module.sync.esb.transfer.IMessageTransform;

//import com.deppon.foss.module.sync.esb.util.JAXBContextUtil;

/**
 * [接口改造]部门信息 消息request转换类
 * <p style="display:none">
 * modifyRecord
 * </p>
 * <p style="display:none">
 * version:V1.0,author:150953,date:2015-3-25 下午7:32:04
 * </p>
 * 
 * @author 150953 冯世杰
 * @date 2015-3-25 下午7:32:04
 * @since
 * @version
 */
public class SendMdmOrgRequestTrans implements
		IMessageTransform<SendMdmOrgRequest> {
	/**
	 * The Constant CLZZ.
	 */
	private static final Class<SendMdmOrgRequest> CLZZ = SendMdmOrgRequest.class;
	/**
	 * The log.
	 */
	// private static Log log = LogFactory.getLog(SendMdmOrgRequestTrans.class);
	/**
	 * The context.
	 */
	// private static JAXBContext context = JAXBContextUtil.initContext(CLZZ);
	/**
	 * JSON mapper
	 */
	private ObjectMapper mapper = new ObjectMapper();
	/**
	 * <p>
	 * 转换成实体
	 * </p>
	 * 
	 * @author 150953 冯世杰
	 * @date 2015-3-25 下午7:34:10
	 * @param string
	 * @return
	 * @throws ConvertException
	 * @throws UnsupportedEncodingException
	 * @see com.deppon.foss.module.sync.esb.transfer.IMessageTransform#toMessage(java.lang.String)
	 */
	@Override
	public SendMdmOrgRequest toMessage(String string) throws ConvertException,
			UnsupportedEncodingException {
		// 发送请求实体
		SendMdmOrgRequest request = null;
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
		// if(context == null){
		// JAXBContextUtil.initContext(CLZZ);//再次尝试一次
		// if (context == null) {
		// throw new ConvertException("初始化JAXBContext失败！");
		// }
		// }
		// try {
		// ByteArrayInputStream stream = new
		// ByteArrayInputStream(string.getBytes("UTF-8"));
		// Unmarshaller unmarshaller = context.createUnmarshaller();
		// JAXBElement<SendMdmOrgRequest> element = unmarshaller.unmarshal(new
		// StreamSource(stream), CLZZ);
		// return element.getValue();
		// } catch (JAXBException e) {
		// throw new ConvertException("反序列化" + CLZZ.getName() + "时失败！", e);
		// }
	}

	/**
	 * <p>
	 * 转换成xml格式消息
	 * </p>
	 * 
	 * @author 150953 冯世杰
	 * @date 2015-3-25 下午7:34:10
	 * @param message
	 * @return
	 * @throws ConvertException
	 * @see com.deppon.foss.module.sync.esb.transfer.IMessageTransform#fromMessage(java.lang.Object)
	 */
	@Override
	public String fromMessage(SendMdmOrgRequest value) throws ConvertException {
		// 字符串
		String json = null;
		// mapper
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
		// if(context == null){
		// JAXBContextUtil.initContext(CLZZ);//再次尝试一次
		// if (context == null) {
		// throw new ConvertException("初始化JAXBContext失败！");
		// }
		// }
		// if (value == null) {
		// return null;
		// }
		// try {
		// StringWriter stringWriter = new StringWriter();
		// Marshaller marshaller = context.createMarshaller();
		// marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING,
		// "UTF-8");
		// JAXBElement<SendMdmOrgRequest> element = new
		// ObjectFactory().createSendMdmOrgRequest(value);
		// marshaller.marshal(element, stringWriter);
		// stringWriter.flush();
		// return stringWriter.toString();
		// } catch (PropertyException e) {
		// throw new ConvertException("序列化" + value.getClass().getName() +
		// "时失败！", e);
		// } catch (FactoryConfigurationError e) {
		// throw new ConvertException("序列化" + value.getClass().getName() +
		// "时失败！", e);
		// } catch (JAXBException e) {
		// throw new ConvertException("序列化" + value.getClass().getName() +
		// "时失败！", e);
		// }
	}
}
