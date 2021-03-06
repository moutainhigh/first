package com.deppon.foss.module.sync.esb.util;

/**
 * 
 * 常量定义
 * 
 * @author Administrator
 * @date 2013-7-30 下午1:21:16
 */
public class Constant {
	// 发送状态
	public static final String STATUS_QUEUE = "RQ_ESB_STATUS";
	// 发送异常
	public static final String EXCEPTION_QUEUE = "RQ_ESB_EXCEPTION";
	// 接收请求
	public static final String REQUEST_COME_IN_QUEUE = "QU_WDGH_REQUEST_COM_IN";
	// 接收响应
	public static final String RESPONSE_COME_IN_QUEUE = "QU_WDGH_RESPONSE_COM_IN";
	// 发送请求
	public static final String RESPONSE_COME_OUT_QUEUE = "RQ_WDGH_REQUEST_COM_OUT";
	// 发送响应
	public static final String REQUEST_COME_OUT_QUEUE = "RQ_WDGH_RESPONSE_COM_OUT";

	
	/*// CC接收请求
	public static final String CC_REQUEST_COME_IN_QUEUE = "QU_CCS_REQUEST_COM_IN";
	// CC接收响应
	public static final String CC_RESPONSE_COME_IN_QUEUE = "QU_CCS_RESPONSE_COM_IN";
	// CC发送请求
	public static final String CC_RESPONSE_COME_OUT_QUEUE = "RQ_CCS_REQUEST_COM_OUT";
	// CC发送响应
	public static final String CC_REQUEST_COME_OUT_QUEUE = "RQ_CCS_RESPONSE_COM_OUT";*/
	public static final String DPM_REQUEST_COME_IN_QUEUE = "QU_DPM_REQUEST_COM_IN";
	public static final String DPM_RESPONSE_COME_IN_QUEUE = "QU_DPM_RESPONSE_COM_IN";
	public static final String DPM_REQUEST_COME_OUT_QUEUE = "RQ_DPM_REQUEST_COM_OUT";
	public static final String DPM_RESPONSE_COME_OUT_QUEUE = "RQ_DPM_RESPONSE_COM_OUT";
	
	public static final String STATUS_302 = "ST_302";
	public static final String STATUS_305 = "ST_305";
	public static final String STATUS_308 = "ST_308";
	public static final String STATUS_999 = "ST_999";

	public static final String WDGH_ESB2WDGH_SYNC_CUSTINFO = "WDGH_ESB2WDGH_SYNC_CUSTINFO";

	public static final String WDGH_ESB2WDGH_SYNC_ORGANIZATION = "WDGH_ESB2WDGH_SYNC_ORGANIZATION";

	public static final String WDGH_ESB2WDGH_SYNC_DISTRICT = "WDGH_ESB2WDGH_SYNC_DISTRICT";

	public static final String WDGH_ESB2WDGH_SYNC_SALES_DEPARTMENT = "WDGH_ESB2WDGH_SYNC_SALES_DEPARTMENT";

	public static final String FOSS_ESB2FOSS_SYNC_RANGE_WORKFLOW = "FOSS_ESB2FOSS_SYNC_RANGE_WORKFLOW";

	public static final String VERSION = "0.1";

	public static final String SYSTEM_FOSS = "FOSS";

	public static final String SYSTEM_CRM = "CRM";

	public static final String SYSTEM_UUMS = "UUMS";

	public static final String MESSAGE_FORMAT_XML = "XML";

	public static final String EXCHANGE_PATTERN_WS = "1";

	public static final String EXCHANGE_PATTERN_JMS = "2";

	public static final String EXCHANGE_PATTERN_ONEWAY = "3";


	public static final String NUMERAL_S_ONE = "1";
	public static final String NUMERAL_S_TWO = "2";
	public static final String NUMERAL_S_THREE = "3";
	public static final String NUMERAL_S_FOUR = "4";

	public static final String DATA_RULE_OPERATE_ERROR = "数据规则异常";

	
	public static final String EXTERNAL_SYSTEM_UUMS_USER_ACCOUNT = "uums";

}