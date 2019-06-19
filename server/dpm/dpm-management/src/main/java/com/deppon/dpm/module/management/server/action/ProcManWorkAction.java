package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.management.server.service.IProcManWorkService;
import com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity;

/**   
* @Description: 工程维修（实时暂存，暂存修改，查询详情等）
* @author 268087 张广波
* @date 2015-9-29 下午2:23:01 
* @version V1.0 
*/
public class ProcManWorkAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(ProcManWorkAction.class);
	/** 
	* @Fields workService 工程维修操作service
	*/ 
	@Resource
	private IProcManWorkService workService;
	
	/** 
	* @Description: 查询申请单详情 或 暂存维修单信息
	* @author 268087 张广波
	* @date 2015-9-29 下午2:22:58  
	*/
	public void queryProcManInfo(){
		HttpServletResponse response = setPageHead();
		String res = "";
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		if ("POST".equals(ServletActionContext.getRequest().getMethod())) {			
			retMap.put("resultFlag",false);
			retMap.put("failureReason","参数获取不到!");	
			try {
				//获取请求参数
				BufferedReader bu = ServletActionContext.getRequest().getReader();
				//将请求参数转换为字符串
				String str = StringUtil.bufferString(bu);
				logger.info("====查询维修单详情接口接收的参数："+str);
				if (!com.deppon.foss.framework.shared.util.string.StringUtil.isBlank(str)) {
					ProcMaintainEntity maintainEntity = new ProcMaintainEntity();
//					new JSONObject();
					//将请求参数转换为jsonobject
//					JSONObject jsonObject = new JSONObject().parseObject(str);
					JSONObject jsonObject = JSON.parseObject(str);
					if (!com.deppon.foss.framework.shared.util.string.StringUtil.isBlank(jsonObject.getString("pid"))) {
						maintainEntity = workService.queryForList(jsonObject.getString("pid"));
						retMap.put("maintainEntity",maintainEntity);
						retMap.put("resultFlag",true);
						retMap.put("failureReason","获取数据成功!");	
					}
					else {
						retMap.put("failureReason","===维修单主键获取不到!");
					}
				}
			} catch (Exception e) {
				//将异常信息记录到日志
				retMap.put("resultFlag",false);
				retMap.put("failureReason","查询维修单详情接口出现错误!");	
				logger.info("查询维修单详情接口出现错误!");
			}
			//返回
			res = JsonUtil.mapToJsonString(retMap);
			writeToPage(response, res);
		}
	}
	
	
	
	
	/** 
	* @Description: 保存暂存申请单 和 实时暂存
	* @author 268087 张广波
	* @date 2015-9-29 下午3:38:44  
	*/
	public void saveProcMan(){
		HttpServletResponse response = setPageHead();
		String res = "";
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		if ("POST".equals(ServletActionContext.getRequest().getMethod())) {	
			retMap.put("resultFlag",false);
			retMap.put("failureReason","参数获取不到!");
			try {
				//获取请求参数
				BufferedReader bu = ServletActionContext.getRequest().getReader();
				//将请求参数转换为字符串
				String str = StringUtil.bufferString(bu);
				if (!com.deppon.foss.framework.shared.util.string.StringUtil.isBlank(str)) {
					//将请求字符串转换为jsonobject
					JSONObject jsonObject = JSON.parseObject(str);
					//根据所传参数获取实体类
					ProcMaintainEntity maintainEntity = JsonUtil.jsonToEntity(JsonUtil.jsonStrToArray(str, "maintainEntity"), ProcMaintainEntity.class);
					if (maintainEntity!=null&&jsonObject!=null) {
						maintainEntity.setUserNo(jsonObject.getString("userNo"));
					}
					//修改
					if (maintainEntity!=null&&maintainEntity.getId()!=0) {
						maintainEntity.setApprovalMark(0);
						retMap=(HashMap<String, Object>)workService.updateProcMan(maintainEntity, retMap);
					}
					//添加
					else {
						if (maintainEntity!=null&&jsonObject!=null) {
							if (workService.checkIsRepMan(jsonObject.getString("userNo").trim())>0) {
								retMap.put("resultFlag",false);
								retMap.put("failureReason","不能重复提交!");
							}
							else {
								maintainEntity.setApprovalMark(2);
								retMap=(HashMap<String, Object>)workService.saveProcMan(maintainEntity, retMap);
							}						
						}
					}							
				}
			} catch (Exception e) {
				//将异常信息记录到日志
				retMap.put("resultFlag",false);
				retMap.put("failureReason","保存暂存申请单 和 实时暂存接口出现错误!");
				logger.info("保存暂存申请单 和 实时暂存接口出现错误!");
			}
		}
		//返回
		res = JsonUtil.mapToJsonString(retMap);
		writeToPage(response, res);
	}
	
	/** 
	* @Description: 工程勘测-更新勘测单状态
	* @author 268087 张广波
	* @date 2015-12-11 下午2:10:04  
	*/
	public void updateSurveyState(){
		HttpServletResponse response = setPageHead();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		if ("POST".equals(ServletActionContext.getRequest().getMethod())) {			
			retMap.put("resultFlag",false);
			retMap.put("failureReason","参数获取不到!");
			String res = "";
			BufferedReader bu = null;
			String str = "";
			try {
				//获取请求参数
				bu = ServletActionContext.getRequest().getReader();
				//将请求参数转换为字符串
				str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
				//将前端传过来的参数写进日志
				logger.info("传入参数为：" + str);
				if (!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {				
					JSONObject json = JSON.parseObject(str);
					//如果更新状态、主键id不为空
					if(json.getString("checkState")!=null&&json.getString("pkyId")!=null){
						String checkState = json.getString("checkState");
						String pkyId=json.getString("pkyId");
						HashMap<String, String> paramHashMap = new HashMap<String, String>();
						//更新状态
						paramHashMap.put("checkState", checkState);
						//主键id
						paramHashMap.put("pkyId", pkyId);
						int retInt = workService.updateSurveyState(paramHashMap);
						if (retInt==1) {
							retMap.put("resultFlag",true);
							retMap.put("failureReason","更新状态成功!");
						}
						else{
							retMap.put("resultFlag",true);
							retMap.put("failureReason","更新状态失败!");
						}
					}	
				}			
				
			} catch (Exception e) {
				//将异常信息记录到日志
				logger.info("====异常信息==》调用更新勘测单状态接口出现异常!");
				retMap.put("resultFlag",false);
				retMap.put("failureReason","调用更新勘测单状态接口出现异常!");
			}		
			//返回
			res = JsonUtil.mapToJsonString(retMap);
			writeToPage(response, res);
		}
	}
		
	/** 
	* @Description: 公共方法
	* @author 268087 张广波
	* @date 2016-1-6 上午11:37:32 
	*  @return 
	*/
	private HttpServletResponse setPageHead() {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		return response;
	}

	/** 
	* @Description: 获取操作service
	* @author 268087 张广波
	* @date 2016-1-5 下午3:46:46 
	*  @return 
	*/
	public IProcManWorkService getWorkService() {
		return workService;
	}

	/** 
	* @Description: 设置操作service
	* @author 268087 张广波
	* @date 2016-1-5 下午3:46:59 
	*  @param workService 
	*/
	public void setWorkService(IProcManWorkService workService) {
		this.workService = workService;
	}	
}
