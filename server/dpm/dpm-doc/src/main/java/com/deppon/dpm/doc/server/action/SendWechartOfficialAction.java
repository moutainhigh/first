package com.deppon.dpm.doc.server.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.doc.server.service.ISendWechartOfficialService;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.ParamUtils;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.tongxunlu.server.util.Constants;

public class SendWechartOfficialAction extends BaseAction{

	//接收人
	private String sender;
	
	private static final Logger logger = LoggerFactory
			.getLogger(SendWechartOfficialAction.class);
	
	private static ArrayList<String> userIds;
	
	static{
		userIds = new ArrayList<String>();
		userIds.add("265564");
		userIds.add("063155");
		userIds.add("633728");
		userIds.add("275309");
		userIds.add("605923");
		userIds.add("500612");
		userIds.add("496837");
		userIds.add("245102");
		userIds.add("491275");
		userIds.add("357095");
		userIds.add("T21760");
	}
	//对接企业微信发送消息
	private ISendWechartOfficialService sendWechartOfficialService;
	public void sendWechartOfficial(){
		
		//解决漏洞问题，验证工号
		Result<Object> result = new Result<Object>();//修漏洞添加
		if(ParamUtils.checkUserId(sender)){
			   result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			   // errorMessage
			   result.setErrorMessage("工号错误，不符合规范");
			   writeToPage(result);
			   return;
			  }
		for(String userId:userIds){
			String result1 = sendWechartOfficialService.sendWechartOfficial("小主你好~现收到用户（工号："+sender+"）上报的问题，请至后台管理系统中查看~", userId);
			logger.info("企业微信发送结果>>>>>>" + result1);
			writeToPage(result1);
		}
		
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public ISendWechartOfficialService getSendWechartOfficialService() {
		return sendWechartOfficialService;
	}
	public void setSendWechartOfficialService(
			ISendWechartOfficialService sendWechartOfficialService) {
		this.sendWechartOfficialService = sendWechartOfficialService;
	}
	
}
