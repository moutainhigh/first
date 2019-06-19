package com.deppon.dpm.doc.server.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.deppon.dpm.doc.server.service.IDoubtfulExAuditService;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;


public class InsertScheduleAction extends BaseAction{
	
	private IDoubtfulExAuditService doubtfulExAuditService;
	
	private String stateList;
	
	//给人力提供接口，用于每天插入排班信息
	@CookieNotCheckedRequired
	public void insertScheduleState(){
		
		 List<Map> list = JSONArray.parseArray(stateList, Map.class);
		
		int result = doubtfulExAuditService.insertScheduleState(list);
		
		Map<String,String> jonum = new HashMap<String,String>();
		if(result!=0){
			jonum.put("msg", "success");
			jonum.put("errorCode", "0");
		}else{
			jonum.put("msg", "fail");
			jonum.put("errorCode", "1");
		}
		writeToPage(jonum);
	}

	public IDoubtfulExAuditService getDoubtfulExAuditService() {
		return doubtfulExAuditService;
	}

	public void setDoubtfulExAuditService(
			IDoubtfulExAuditService doubtfulExAuditService) {
		this.doubtfulExAuditService = doubtfulExAuditService;
	}

	public String getStateList() {
		return stateList;
	}

	public void setStateList(String stateList) {
		this.stateList = stateList;
	}
	
	
}
