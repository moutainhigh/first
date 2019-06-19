package com.deppon.dpm.module.fssc.server.action;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.service.IMonitorCountInfoService;
import com.deppon.dpm.module.common.server.util.Constants;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.fssc.server.service.IThingBeforeApplyService;
import com.deppon.dpm.module.fssc.shared.domain.PriorApplicationEntity;
import com.deppon.dpm.module.fssc.shared.domain.TheoneObjEntity;

/**
 * 将事前申请单信息和详情信息传给页面
 * Action类
 * @author JFfeng
 */
public class ThingBeforeApplyAction extends BaseAction {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(ThingBeforeApplyAction.class);
	
	/**
	 * thingbeforeapplyservice 接口
	 */
	private IThingBeforeApplyService thingbeforeapplyservice;
	
	/**
	 * 记录提交响应时长
	 */
	private IMonitorCountInfoService monitorCountInfoService;

	/**
	 * @return thingbeforeapplyservice 接口
	 */
	public IMonitorCountInfoService getMonitorCountInfoService() {
		return monitorCountInfoService;
	}

	/**
	 * @param monitorCountInfoService thingbeforeapplyservice 接口
	 */
	public void setMonitorCountInfoService(
			IMonitorCountInfoService monitorCountInfoService) {
		this.monitorCountInfoService = monitorCountInfoService;
	}

	public IThingBeforeApplyService getThingbeforeapplyservice() {
		return thingbeforeapplyservice;
	}

	public void setThingbeforeapplyservice(
			IThingBeforeApplyService thingbeforeapplyservice) {
		this.thingbeforeapplyservice = thingbeforeapplyservice;
	}
	
	
	/**
	 * applyEmpNo
	 */
	private String applyEmpNo;
	
	/**
	 * claimNo
	 */
	private String claimNo;
	
	/**
	 * @return claimNo
	 */
	public String getClaimNo() {
		return claimNo;
	}

	/**
	 * @param claimNo 
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getApplyEmpNo() {
		return applyEmpNo;
	}

	public void setApplyEmpNo(String applyEmpNo) {
		this.applyEmpNo = applyEmpNo;
	}
	
	
	/**
	 * 事前申请单的action响应
	 */
	public void getPriorApplication(){
		//日志
		logger.info("ThingBeforeApplyAction>>>>>>>>>>>进入事前申请单的action响应");
		//开始时间
		Date startDate = new Date();
		//设置页面响应实体
		String res="";
		HttpServletResponse response=ServletActionContext.getResponse();
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			//theoneObjEntity
			List<TheoneObjEntity> theoneObjEntity=thingbeforeapplyservice.queryAllInfo(applyEmpNo);
			//转json
			res=JsonUtil.beanToJsonString(theoneObjEntity);
			
		} catch (Exception ce) {
			//抛出异常
			logger.info("ThingBeforeApplyAction>>>>>>>>>>>进入事前申请单的action响应");
			ce.printStackTrace();
		}
		//结束时间
		Date endDate = new Date();
		//保存
		monitorCountInfoService.saveMonitorCountInfo(userId,startDate,endDate,Constants.TRAVEL_ASSISTANT);
		writeToPage(response,res );
	}
	
	

	/**
	 * 详细信息的显示
	 */
	public void getAllInfo(){
		logger.info("ThingBeforeApplyAction>>>>>>>>>>>进入详细信息的显示");
		//设置页面响应实体
		String res="";
		HttpServletResponse response=ServletActionContext.getResponse();
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			//得到对象
			PriorApplicationEntity priorApp=thingbeforeapplyservice.queryXiangxiInfo(claimNo);
			//转json
			res=JsonUtil.beanToJsonString(priorApp);
			
		} catch (Exception ce) {
			logger.info("ThingBeforeApplyAction>>>>>>>>>>>进入详细信息的显示异常");
			ce.printStackTrace();
		}
		//写入数据
		writeToPage(response,res );
	}
}
