package com.deppon.foss.module.sync.business.transfer;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.transform.stream.StreamSource;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

import com.deppon.foss.module.sync.business.jms.ObjectFactory;
import com.deppon.foss.module.sync.business.jms.SyncAdminOrgRequest;
import com.deppon.foss.module.sync.esb.exception.ConvertException;
import com.deppon.foss.module.sync.esb.transfer.IMessageTransform;
import com.deppon.foss.module.sync.esb.util.JAXBContextUtil;

/**
 * 异步组织请求转换
 */
public class SyncOrganizationRequestTrans implements
		IMessageTransform<SyncAdminOrgRequest> {
	/**
	 * The Constant CLZZ.
	 */
	private static final Class<SyncAdminOrgRequest> CLZZ = SyncAdminOrgRequest.class;
	/**
	 * The log.
	 */
	// private static Log log =
	// LogFactory.getLog(SyncOrganizationRequestTrans.class);
	/**
	 * The context.
	 */
	private static JAXBContext context = JAXBContextUtil.initContext(CLZZ);
	
	/**
	 * 把字符串转换为POJO.
	 */
	@Override
	public SyncAdminOrgRequest toMessage(String string) throws ConvertException, UnsupportedEncodingException {
		// 空判断
		if (context == null) {
			// 再次尝试一次
			JAXBContextUtil.initContext(CLZZ);
			// 依然为null
			if (context == null) {
				// 抛出异常
				throw new ConvertException("初始化JAXBContext失败！");
			}
		}
		try {
			// string-->ByteArrayInputStream
			ByteArrayInputStream stream = new ByteArrayInputStream(string.getBytes("UTF-8"));
			// 实例化Unmarshaller，用以xml和实体之间的转化
			Unmarshaller unmarshaller = context.createUnmarshaller();
			// 反序列化
			JAXBElement<SyncAdminOrgRequest> element = unmarshaller.unmarshal(new StreamSource(stream), CLZZ);
			// 获取对应的值
			return element.getValue();
			// catch异常
		} catch (JAXBException e) {
			// 异常抛出
			throw new ConvertException("反序列化" + CLZZ.getName() + "时失败！", e);
		}
	}
	/**
	 * 把POJO转换为字符串.
	 */
	@Override
	public String fromMessage(SyncAdminOrgRequest value) throws ConvertException {
		// context为null
		if (context == null) {
			// 再次尝试一次
			JAXBContextUtil.initContext(CLZZ);
			// 再次为null
			if (context == null) {
				// 实例化异常
				throw new ConvertException("初始化JAXBContext失败！");
			}
		}
		// 传入参数为null
		if (value == null) {
			// 跳出
			return null;
		}
		try {
			// 写出实例化
			StringWriter stringWriter = new StringWriter();
			// pojo-->xml实例化
			Marshaller marshaller = context.createMarshaller();
			// 设置属性,格式化输出
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// 编码格式
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
			// 序列化类创建
			JAXBElement<SyncAdminOrgRequest> element = new ObjectFactory().createSyncAdminOrgRequest(value);
			// 序列化
			marshaller.marshal(element, stringWriter);
			// 刷新
			stringWriter.flush();
			// 写出
			return stringWriter.toString();
			// catch异常
		} catch (PropertyException e) {
			// 抛出异常
			throw new ConvertException("序列化" + value.getClass().getName() + "时失败！", e);
			// catch异常
		} catch (FactoryConfigurationError e) {
			// 抛出异常
			throw new ConvertException("序列化" + value.getClass().getName() + "时失败！", e);
			// catch异常
		} catch (JAXBException e) {
			// 抛出异常
			throw new ConvertException("序列化" + value.getClass().getName() + "时失败！", e);
		}
	}
}