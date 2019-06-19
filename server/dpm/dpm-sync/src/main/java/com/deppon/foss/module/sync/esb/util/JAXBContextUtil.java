package com.deppon.foss.module.sync.esb.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 获取JAXB上下文
 * 
 * @author 231586
 * 
 */
public class JAXBContextUtil {
	/**
	 * log
	 */
	private static Log log = LogFactory.getLog(JAXBContextUtil.class);

	/**
	 * Inits the context.
	 * 
	 * @return the jAXB context
	 */
	@SuppressWarnings("rawtypes")
	public static final JAXBContext initContext(Class clzz) {
		try {
			// 返回上下文
			return JAXBContext.newInstance(clzz);
		} catch (JAXBException e) {
			// log
			log.error(e.getMessage(), e);
		}
		// 跳出
		return null;
	}
}
