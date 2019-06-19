package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.management.server.service.IReserveManWorkService;
import com.deppon.dpm.module.management.server.service.ISendParcelWorkService;
import com.deppon.dpm.module.management.shared.vo.EmpVO;
import com.deppon.dpm.module.management.shared.vo.ReserveManWorkVO;
import com.deppon.dpm.module.management.util.Constants;

/**   
* @Description: 场地预订
* @author 268087 张广波
* @date 2015-11-16 下午2:46:07 
* @version V1.0 
*/
public class ReserveManWorkAction  extends BaseAction {
	Logger logger = LoggerFactory.getLogger(ReserveManWorkAction.class);
	private static final long serialVersionUID = 1L;
	/** 
	* @Fields reserveManWorkService 场地预订操作service
	*/ 
	private IReserveManWorkService reserveManWorkService;
	/** 
	* @Fields parcelService 收发室操作service
	*/ 
	@Resource
	private ISendParcelWorkService parcelService;
	
	/** 
	* @Description: 判断当前用户是否是管理员
	* @author 268087 张广波
	* @date 2015-11-16 下午2:42:25  
	*/
	public void checkIsAdmin(){
		HttpServletResponse response = setPageHead();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		if ("POST".equals(ServletActionContext.getRequest().getMethod())) {			
			retMap.put("resultFlag",false);
			retMap.put("failureReason","员工号获取不到!");
			String res = "";
			BufferedReader bu = null;
			String str = "";
			try {
				bu = ServletActionContext.getRequest().getReader();
				str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
				//将前端传过来的参数写进日志
				logger.info("传入参数为：" + str);
				if (!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {				
					JSONObject json = new JSONObject().parseObject(str);
					//如果站点ID不为空
					if(json.getString("uid")!=null){
						String empCode = json.getString("uid");
						HashMap<String, String> paramHashMap = new HashMap<String, String>();
						//员工号
						paramHashMap.put("userNO", empCode);
						//活动管理组
						//paramHashMap.put("orgCode", "W01080101");
						paramHashMap.put("orgCode", "W0000033986");
						//传入当前登录用户的员工号，如果是管理员就返回int类型数值1
						//-- 1: 普通用户
						//-- 2: 超级管理员
						//-- 3: 普通管理员
						Constants cons = new Constants();
						int retInt = reserveManWorkService.checkIsAdmByOrgCode(paramHashMap);
						if (retInt==2||retInt==cons.IS_ADMIN) {
							retMap.put("isAdmin",retInt);
							retMap.put("resultFlag",true);
							retMap.put("failureReason","当前用户是管理员!");
						}
						else{
							retMap.put("isAdmin",retInt);
							retMap.put("resultFlag",true);
							retMap.put("failureReason","当前用户是普通用户!");
						}
					}	
				}			
				
			} catch (Exception e) {
				logger.info("====异常信息==》调用管理员权限判断接口出现异常!");
				retMap.put("failureReason","调用管理员权限判断接口出现异常!");
			}		
			res = JsonUtil.mapToJsonString(retMap);
			writeToPage(response, res);
		}
	}
	
	/** 
	* @Description: 查询员工信息
	* @author 268087 张广波
	* @date 2015-12-3 上午10:37:38  
	*/
	public void queryEmpInfoList(){
		HttpServletResponse response = setPageHead();		
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		if("POST".equals(ServletActionContext.getRequest().getMethod())){			
			retMap.put("isPOST",true);
			retMap.put("resultFlag",false);
			retMap.put("failureReason","前端数据获取不到!");			
			BufferedReader bu = null;
			String str = "";		
			try {
				bu = ServletActionContext.getRequest().getReader();
				str = StringUtil.bufferString(bu);
				logger.info("=====场地预订查询员工的参数："+str);
				if (!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
					JSONObject jsonObject = new JSONObject().parseObject(str);
					if ((jsonObject.getString("empCode")!=null&&!("").equals(jsonObject.getString("empCode").trim()))||(jsonObject.getString("empName")!=null&&!("").equals(jsonObject.getString("empName").trim()))) {
						String empCode = jsonObject.getString("empCode")==null?"":jsonObject.getString("empCode");
						String empName = jsonObject.getString("empName")==null?"":jsonObject.getString("empName");
						EmpVO empVO = new EmpVO(empCode,empName);
						//查询员工信息
						List<EmpVO> empVOs = parcelService.queryEmpInfoList(empVO);
						if (empVOs.size()>0) {
							retMap.put("empList", empVOs);
						}
						else {
							retMap.put("empList", "");
						}
					}
					retMap.put("resultFlag",true);
					retMap.put("failureReason","查询成功！");
				}
			} catch (Exception e) {
				logger.info("=====查询员工信息接口出现异常："+e.getMessage());
				retMap.put("resultFlag",false);
				retMap.put("failureReason","查询员工信息接口出现异常!");
			}						
		}
		else{			
			retMap.put("isPOST",false);
			retMap.put("resultFlag",false);
			retMap.put("failureReason","请求方式不是POST!");			
		}
		String  backData = JsonUtil.mapToJsonString(retMap);
		writeToPage(response,backData);
	}
	
	
	/** 
	* @Description: 获取预订列表
	* @author 268087 张广波
	* @date 2015-11-16 下午2:43:02  
	*/
	public void queryResList(){
		HttpServletResponse response = setPageHead();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		if ("POST".equals(ServletActionContext.getRequest().getMethod())) {			
			retMap.put("resultFlag",false);
			retMap.put("failureReason","员工号获取不到!");
			String res = "";
			BufferedReader bu = null;
			String str = "";
			try {
				bu = ServletActionContext.getRequest().getReader();
				str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
				//将前端传过来的参数写进日志
				logger.info("传入参数为：" + str);
				if (!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {				
					JSONObject json = new JSONObject().parseObject(str);
					//如果站点ID不为空
					if(json.getString("uid")!=null&&json.getString("reserveType")!=null){
						String userNo = json.getString("uid");
						String siteMark = json.getString("reserveType");
						HashMap<String, String> paramHashMap = new HashMap<String, String>();
						paramHashMap.put("userNo", userNo);
						//根据状态值，标识是羽毛球还是瑜伽室
						paramHashMap.put("siteMark", siteMark);
						//限制查询天数
						paramHashMap.put("limitDayNum", "1");
						//传入当前登录用户的员工号，如果是管理员就返回int类型数值1
						List<ReserveManWorkVO> vos = reserveManWorkService.queryResList(paramHashMap);
						if (vos!=null) {		
							retMap.put("voList", vos);
							retMap.put("resultFlag",true);
							retMap.put("failureReason","获取列表成功!");
						}
						else{
							retMap.put("resultFlag",false);
							retMap.put("failureReason","获取列表失败!");
						}
					}	
				}			
				res = JsonUtil.mapToJsonString(retMap);
				writeToPage(response, res);
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
	}
	
	

	/** 
	* @Description: 公共方法
	* @author 268087 张广波
	* @date 2015-11-17 上午8:46:54 
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
	* @Description: 获取场地预订service
	* @author 268087 张广波
	* @date 2015-11-16 下午5:25:58 
	*  @return 
	*/
	public IReserveManWorkService getReserveManWorkService() {
		return reserveManWorkService;
	}
	/** 
	* @Description: 设置场地预订service
	* @author 268087 张广波
	* @date 2015-11-16 下午5:26:10 
	*  @param reserveManWorkService 
	*/
	public void setReserveManWorkService(
			IReserveManWorkService reserveManWorkService) {
		this.reserveManWorkService = reserveManWorkService;
	}

/*	*//** 
	* @Description: 获取收发室操作service
	* @author 268087 张广波
	* @date 2015-12-3 上午9:18:41 
	*  @return 
	*//*
	public ISendParcelWorkService getParcelService() {
		return parcelService;
	}

	*//** 
	* @Description: 设置收发室操作service
	* @author 268087 张广波
	* @date 2015-12-3 上午9:18:50 
	*  @param parcelService 
	*//*
	public void setParcelService(ISendParcelWorkService parcelService) {
		this.parcelService = parcelService;
	}*/
	
	
	
}
