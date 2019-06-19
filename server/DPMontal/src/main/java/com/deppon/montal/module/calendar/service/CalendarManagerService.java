/**
 * Project Name:DPMotal_20140925
 * File Name:CalendarManagerService.java
 * Package Name:com.deppon.montal.module.calendar.service
 * Date:2014-10-14上午9:09:41
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.deppon.montal.module.calendar.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.xml.ws.Holder;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.deppon.dpm.webserviceclient.calendar.dip.portal.main.calendar.CalendarService;
import com.deppon.dpm.webserviceclient.calendar.dip.portal.main.calendar.JSONException;
import com.deppon.esb.header.ESBHeader;
import com.deppon.montal.util.JSONUtil;
import com.google.gson.Gson;

/**
 * ClassName:CalendarManagerService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * 
 * Date:     2014-10-14 上午9:09:41 <br/>
 * @author   157229-zxy
 * @version  
 * @since    JDK 1.6
 */
public class CalendarManagerService implements ICalendarManagerService{
	/**
	 * 日志
	 */
	private static Logger logger = Logger.getLogger(CalendarManagerService.class);

	@Resource
	private CalendarService calendarService;
	
	/**
	 * 返回处理结果标志 1成功 0失败
	 */
	private final static String STATUS_CODE = "statusCode";
	
	/**
	 * 操作码 1、查询2、增加3、修改、4删除
	 */
	private final static String CODE = "code";
	
	/**
	 * 返回详细信息
	 */
	private final static String MSG = "msg";
	
	/**
	 * OA处理成功标志
	 */
	private final static String STATUS_CODE_SUCCESS = "1";
	
	/**
	 * OA处失败标志
	 */
	private final static String STATUS_CODE_FAIL = "0";
	
	/**
	 * ESB处理SOAP HEADER帮助
	 */
	private Holder<ESBHeader> esbHeader;
	
	/**
	 * 版本号
	 */
	private static final String VERSION = "0.1";

	/**
	 * 业务ID
	 */
	private static final String BUSINESS_ID = "calendar";
	
	private static final String ESB_SERVICE_CODE = "ESB_DPM2ESB_DIP_CALENDAR";
	
	private void createHeader() {
		if (this.esbHeader == null) {
			esbHeader = new Holder<ESBHeader>();
			ESBHeader header = new ESBHeader();
			header.setVersion(VERSION);
			header.setBusinessId(BUSINESS_ID);
			header.setSourceSystem("DPM");
			header.setTargetSystem("OA");
			header.setMessageFormat("SOAP");
			header.setExchangePattern(1);
			esbHeader.value = header;
		}
	}
	
	@Override
	public void addSchedule(String content) throws Exception{
		createHeader();
		esbHeader.value.setRequestId(getUUID());
		esbHeader.value.setEsbServiceCode(ESB_SERVICE_CODE);
		String json = calendarService.handleCalendar(content,esbHeader);
		logger.info("新增日程操作返回报文:" + json);
//		Gson gson = new Gson();
		Map resultMap = JSONUtil.toMap(json,String.class,String.class);
		if(STATUS_CODE_FAIL.equals(resultMap.get(STATUS_CODE))){
			String code = (String) resultMap.get(CODE);
			String msg = (String) resultMap.get(MSG);
			throw new Exception("错误详情[code:" + code + ",msg:" + msg + "]");
		}
	}

	@Override
	public void updateSchedule(String content) throws Exception{
		createHeader();
		esbHeader.value.setRequestId(getUUID());
		esbHeader.value.setEsbServiceCode(ESB_SERVICE_CODE);
		String json = calendarService.handleCalendar(content,esbHeader);
		logger.info("更新日程操作返回报文:" + json);
		Map resultMap = JSONUtil.toMap(json,String.class,String.class);
		if(STATUS_CODE_FAIL.equals(resultMap.get(STATUS_CODE))){
			String code = (String) resultMap.get(CODE);
			String msg = (String) resultMap.get(MSG);
			throw new Exception("错误详情[code:" + code + ",msg:" + msg + "]");
		}
	}

	@Override
	public void deleteSchedule(String content) throws Exception{
		createHeader();
		esbHeader.value.setRequestId(getUUID());
		esbHeader.value.setEsbServiceCode(ESB_SERVICE_CODE);
		String json = calendarService.handleCalendar(content,esbHeader);
		logger.info("删除日程操作返回报文:" + json);
		Map resultMap = JSONUtil.toMap(json,String.class,String.class);
		if(STATUS_CODE_FAIL.equals(resultMap.get(STATUS_CODE))){
			String code = (String) resultMap.get(CODE);
			String msg = (String) resultMap.get(MSG);
			throw new Exception("错误详情[code:" + code + ",msg:" + msg + "]");
		}
	}

	@Override
	public String querySchedule(String content) throws Exception{
		String json = "";
		try {
			Map paramMap = JSONUtil.toMap(content,String.class,Object.class);
			String monthStr = (String)paramMap.get("month");
			Integer type = (Integer)paramMap.get("type");
			createHeader();
			esbHeader.value.setRequestId(getUUID());
			esbHeader.value.setEsbServiceCode(ESB_SERVICE_CODE);
			json = calendarService.handleCalendar(content,esbHeader);
			logger.info("查询日程操作返回报文:" + json);
			Map resultMap = JSONUtil.toMap(json,String.class,String.class);
			if(STATUS_CODE_FAIL.equals(resultMap.get(STATUS_CODE))){
				String code = (String) resultMap.get(CODE);
				String msg = (String) resultMap.get(MSG);
				logger.error("错误详情[code:" + code + ",msg:" + msg + "]");
				throw new Exception("查询日程操作返回失败");
			}
			Map returnMap = null;
			if(1 == type){
				returnMap = translateScheduleVoLst(resultMap,monthStr);
			}else{
				returnMap = translateScheduleVo(resultMap);
			}
			
			json = JSONUtil.encapsulateJsonObject(returnMap);
		} catch (JSONException e) {
			throw e;
		}
		
		return json;
	}
	
	private Map<String,Object> translateScheduleVo(Map param) throws JsonParseException, JsonMappingException, IOException{
		String dataStr = (String)param.get("msg");
		Map<String,Object> result = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(dataStr)){
			Map pMap = JSONUtil.toMap(dataStr, String.class,Object.class);
			List<Map<String,Object>> items = new ArrayList<Map<String,Object>>();
			Map<String,Object> item = new HashMap<String,Object>();
			item.put("type", pMap.get("type"));
			item.put("create", pMap.get("month"));
			item.put("operate", pMap.get("userid"));
			item.put("date", pMap.get("days"));
			item.put("classname", pMap.get("event"));
			item.put("isFinish", pMap.get("finish"));
			item.put("body", pMap.get("notice"));
			items.add(item);
			result.put("dataList", items);
		}
		return result;
	}
	
	private Map<String,Object> translateScheduleVoLst(Map param,String month) throws JsonParseException, JsonMappingException, IOException{
		String dataStr = (String)param.get("msg");
		Map<String,Object> result = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(dataStr)){
			//\r\n是转义符号，json转换报错
			dataStr = dataStr.replaceAll("\\r\\n", "\\\\r\\\\n");
			List<Map> lstMap = JSONUtil.toList(dataStr, Map.class);
			List<Map<String,Object>> items = new ArrayList<Map<String,Object>>();
			for(int i = 0; i < lstMap.size(); i++){
				Map<String,Object> pMap = lstMap.get(i);
				Map<String,Object> item = new HashMap<String,Object>();
				item.put("type", pMap.get("type"));
				item.put("create", pMap.get("month"));
				item.put("operate", pMap.get("userid"));
				item.put("date", month + "-" + pMap.get("days"));
				item.put("classname", "event");
				item.put("isFinish", pMap.get("finish"));
				item.put("body", pMap.get("NOTICE"));
				items.add(item);
			}
			result.put("dataList", items);
		}
		return result;
	}
	
	/**
	 * 获取UUID
	 * getUUID: <br/>
	 * 
	 * Date:2014-10-18上午9:03:03
	 * @author 157229-zxy
	 * @return
	 * @since JDK 1.6
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
}

