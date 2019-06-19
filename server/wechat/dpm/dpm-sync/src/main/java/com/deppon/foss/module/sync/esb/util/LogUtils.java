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
package com.deppon.foss.module.sync.esb.util;

import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 日志记录工具类
 * <p style="display:none">modifyRecord</p>
 * <p style="display:none">version:V1.0,author:150953,date:2014-9-2 下午3:42:02 </p>
 * @author 150953 冯世杰
 * @date 2014-9-2 下午3:42:02
 * @since
 * @version
 */
public class LogUtils {
	private static final ObjectMapper mapper = new ObjectMapper();
	/**
	 * <p>写入日志信息</p> 
	 * @author 150953 冯世杰
	 * @date 2014-9-2 下午3:50:59
	 * @param logger 对应的日志类
	 * @param title 输入的标题
	 * @param entity 转换成JSON的实体
	 * @see
	 */
	public static void infoJSON(Log logger,String title,Object entity){
		if (logger==null) {
			return;
		}
		StringWriter stringWriter = new StringWriter();
		try {
			mapper.writeValue(stringWriter, entity);
			logger.info(title.concat(":").concat(stringWriter.toString()));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	/**
	 * <p>将对应的entity按JSON格式输出</p> 
	 * @author 150953 冯世杰
	 * @date 2014-9-2 下午3:53:26
	 * @param logger 对应的日志类
	 * @param title 输入的标题
	 * @param entity 转换成JSON的实体
	 * @see
	 */
	public static void errorJSON(Log logger,String title,Object entity){
		if (logger==null) {
			return;
		}
		StringWriter stringWriter = new StringWriter();
		try {
			mapper.writeValue(stringWriter, entity);
			logger.info(title.concat(stringWriter.toString()));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
