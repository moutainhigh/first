package com.deppon.foss.module.sync.esb.util;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import com.deppon.foss.module.sync.esb.header.ESBHeader;
import com.deppon.foss.module.sync.esb.header.StatusInfo;

/**
 * 与esb相适应
 * 
 * @author 231586
 *
 */
public class HeaderUtils {

	/**
	 * 把JMSPropertyProperty中与ESB相关的属性封装到ESBHeader中.
	 * 
	 * @param message
	 *            the message
	 * @return the eSB header
	 * @throws JMSException
	 *             the jMS exception
	 */
	public static ESBHeader fillServiceHeader(Message message) throws JMSException {
		// 实例化
		ESBHeader header = new ESBHeader();
		// 设置属性
		header.setBackServiceCode(message.getStringProperty(ServiceHeader.BACK_SERVICE_CODE));
		// 设置属性
		header.setBusinessDesc1(message.getStringProperty(ServiceHeader.BUSINESS_DESC1));
		// 设置属性
		header.setBusinessDesc2(message.getStringProperty(ServiceHeader.BUSINESS_DESC2));
		// 设置属性
		header.setBusinessDesc3(message.getStringProperty(ServiceHeader.BUSINESS_DESC3));
		// 设置属性
		header.setBusinessId(message.getStringProperty(ServiceHeader.BUSINESS_ID));
		// 设置属性
		header.setEsbServiceCode(message.getStringProperty(ServiceHeader.ESB_SERVICE_CODE));
		// 设置属性
		header.setExchangePattern(message.getIntProperty(ServiceHeader.EXCHANGE_PATTERN));
		// 设置属性
		header.setMessageFormat(message.getStringProperty(ServiceHeader.MESSAGE_FORMAT));
		// 设置属性
		header.setRequestId(message.getStringProperty(ServiceHeader.REQUEST_ID));
		// 设置属性
		header.setResponseId(message.getStringProperty(ServiceHeader.RESPONSE_ID));
		// 空判断
		if (message.propertyExists(ServiceHeader.RESULT_CODE)) {
			// 设置属性
			header.setResultCode(message.getIntProperty(ServiceHeader.RESULT_CODE));
		}
		// 设置属性
		header.setSourceSystem(message.getStringProperty(ServiceHeader.SOURCE_SYSTEM));
		// 设置属性
		header.setTargetSystem(message.getStringProperty(ServiceHeader.TARGET_SYSTEM));
		// 设置属性
		header.setVersion(message.getStringProperty(ServiceHeader.VERSION));
		// 返回消息头
		return header;
	}

	/**
	 * 把header里面的属性填充到JMSProperty中.
	 * 
	 * @param esbHeader
	 *            the esb header
	 * @param outMessage
	 *            the out message
	 * @throws JMSException
	 *             the jMS exception
	 */
	public static void header2JMSProperties(ESBHeader esbHeader, TextMessage outMessage) throws JMSException {
		// 属性设置
		outMessage.setStringProperty(ServiceHeader.VERSION, esbHeader.getVersion());
		// 属性设置
		outMessage.setStringProperty(ServiceHeader.BUSINESS_ID, esbHeader.getBusinessId());
		// 属性设置
		outMessage.setStringProperty(ServiceHeader.BUSINESS_DESC1, esbHeader.getBusinessDesc1());
		// 属性设置
		outMessage.setStringProperty(ServiceHeader.BUSINESS_DESC2, esbHeader.getBusinessDesc2());
		// 属性设置
		outMessage.setStringProperty(ServiceHeader.BUSINESS_DESC3, esbHeader.getBusinessDesc3());
		// 属性设置
		outMessage.setStringProperty(ServiceHeader.REQUEST_ID, esbHeader.getRequestId());
		// 属性设置
		outMessage.setStringProperty(ServiceHeader.SOURCE_SYSTEM, esbHeader.getSourceSystem());
		// 空判断
		if (esbHeader.getResponseId() != null) {
			// 属性设置
			outMessage.setStringProperty(ServiceHeader.RESPONSE_ID, esbHeader.getResponseId());
		}
		// 空判断
		if (esbHeader.getResultCode() != null) {
			// 属性设置
			outMessage.setIntProperty(ServiceHeader.RESULT_CODE, esbHeader.getResultCode());
		}
		// 空判断
		if (esbHeader.getBackServiceCode() != null) {
			// 属性设置
			outMessage.setStringProperty(ServiceHeader.BACK_SERVICE_CODE, esbHeader.getBackServiceCode());
		}
		// 空判断
		if (esbHeader.getTargetSystem() != null) {
			// 属性设置
			outMessage.setStringProperty(ServiceHeader.TARGET_SYSTEM, esbHeader.getTargetSystem());
		}
		// 属性设置
		outMessage.setStringProperty(ServiceHeader.ESB_SERVICE_CODE, esbHeader.getEsbServiceCode());
		// 属性设置
		outMessage.setStringProperty(ServiceHeader.MESSAGE_FORMAT, esbHeader.getMessageFormat());
		// 属性设置
		outMessage.setIntProperty(ServiceHeader.EXCHANGE_PATTERN, esbHeader.getExchangePattern());
		// 空判断
		if (esbHeader.getAuthentication() != null) {
			// 属性设置
			outMessage.setStringProperty(ServiceHeader.USERNAME, esbHeader.getAuthentication().getUsername());
			// 属性设置
			outMessage.setStringProperty(ServiceHeader.PASSWORD, esbHeader.getAuthentication().getPassword());
		}
		
		// 状态信息，根据ITA要求，把所有状态ID前加"ST_"
		if(esbHeader.getStatusList()!=null){
			// 循环
			for (StatusInfo statusInfo : esbHeader.getStatusList().getStatusInfoList()) {
				outMessage.setLongProperty(statusInfo.getStatusId(), statusInfo.getTimeStamp());
			}
		}
	}
}
