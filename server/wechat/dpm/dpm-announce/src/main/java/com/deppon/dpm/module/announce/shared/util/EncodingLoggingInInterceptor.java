//package com.deppon.dpm.module.announce.shared.util;
//
//import org.apache.cxf.interceptor.Fault;
//import org.apache.cxf.interceptor.LoggingInInterceptor;
//import org.apache.cxf.message.Message;
//
//public class EncodingLoggingInInterceptor extends LoggingInInterceptor {
//
//	public EncodingLoggingInInterceptor() {
//		super();
//	}
//
//	@Override
//	public void handleMessage(Message message) throws Fault {
//		String encoding = System.getProperty("file.encoding");
//		encoding = encoding == null || encoding.equals("") ? "UTF-8" : encoding;
//		message.put(Message.ENCODING, encoding);
//		super.handleMessage(message);
//	}
//}