package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.management.server.service.ISendParcelWorkService;
import com.deppon.dpm.module.management.shared.vo.EmpVO;
import com.deppon.dpm.module.management.shared.vo.ParcelListVO;

/**   
* @Description: 1.已领取接口 2.管理员权限 3.委托代领确认接口 4.委托代领(查询人员详细接口)
* @author 268087 张广波
* @date 2015-9-9 下午2:27:13 
* @version V1.0 
*/
public class SendParcelWorkAction extends BaseAction { 
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(SendParcelWorkAction.class);
	/** 
	* @Fields parcelService 收发室操作service
	*/ 
	private ISendParcelWorkService parcelService;
	
	/** 
	* @Description: 查询公告
	* @author 268087 张广波
	* @date 2015-11-16 下午2:28:00  
	*/
	public void queryNotice(){
		HttpServletResponse response = setPageHead();
		String res ="";
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		//只允许post请求方式进入
		if ("POST".equals(ServletActionContext.getRequest().getMethod())) {
			retMap.put("isPOST",true);
			retMap.put("resultFlag",false);
			retMap.put("failureReason","获取通告失败!");		
			try {
				//查询公告内容
				String content = parcelService.queryNotice();
				retMap.put("resultFlag",true);
				retMap.put("failureReason","获取通告成功!");
				retMap.put("content", content);	
				logger.info("====公告内容："+content);
			} catch (Exception e) {
				retMap.put("resultFlag",false);
				retMap.put("failureReason","获取通告失败!");	
			}
		}
		//返回
		res = JsonUtil.mapToJsonString(retMap);
		writeToPage(response,res);
	}
	
	/** 
	* @Description: 更新公告
	* @author 268087 张广波
	* @date 2015-11-16 下午2:28:22  
	*/
	public void updateNotice(){
		HttpServletResponse response = setPageHead();		
		String res = "";
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		//只允许post请求方式进入
		if("POST".equals(ServletActionContext.getRequest().getMethod())){			
			retMap.put("isPOST",true);
			retMap.put("resultFlag",false);
			retMap.put("failureReason","员工号获取不到!");			
			BufferedReader bu = null;
			String str = "";	
			try {
				//获取请求参数
				bu = ServletActionContext.getRequest().getReader();
				//转换为字符串
				str = StringUtil.bufferString(bu);
				logger.info("====收发室通告前端传过来的参数："+str);
				if (!com.deppon.foss.framework.shared.util.string.StringUtil.isBlank(str)) {
					//转换为jsonObject
					JSONObject jsonObject = new JSONObject().parseObject(str);
					//校验通告内容是否为空
					if (!com.deppon.foss.framework.shared.util.string.StringUtil.isBlank(jsonObject.getString("noticeContent"))) {
						//更新公告
						int retInt = parcelService.updateNotice(jsonObject.getString("noticeContent"));
						if (retInt>0) {
							retMap.put("resultFlag",true);
							retMap.put("failureReason","更新成功!");			
						}
						else {
							retMap.put("resultFlag",false);
							retMap.put("failureReason","更新失败!");			
						}
					}
				}
			} catch (Exception e) {
				retMap.put("resultFlag",false);
				retMap.put("failureReason","更新通告接口出现异常!");			
			}			
		}
		//返回
		res = JsonUtil.mapToJsonString(retMap);
		writeToPage(response,res);
	}
	
	/** 
	* @Description: 校验当前用户是否是管理员
	* @author 268087 张广波
	* @date 2015-11-16 下午2:36:10  
	*/
	public void checkIsSendAdm(){
		HttpServletResponse response = setPageHead();		
		String res = "";
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		if("POST".equals(ServletActionContext.getRequest().getMethod())){			
			retMap.put("isPOST",true);
			retMap.put("resultFlag",false);
			retMap.put("failureReason","员工号获取不到!");			
			BufferedReader bu = null;
			String str = "";		
			try {
				//获取请求参数
				bu = ServletActionContext.getRequest().getReader();
				//转换请求参数为字符串
				str = StringUtil.bufferString(bu);
				logger.info("=====收发室管理员权限判断接口传入的参数："+str);
				if (!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
					//将参数转换为jsonObject
					JSONObject jsonObject = new JSONObject().parseObject(str);
					//校验传入的员工号参数
					if (jsonObject.getString("empCode")!=null&&!("").equals(jsonObject.getString("empCode").trim())) {
						String empCode = jsonObject.getString("empCode");
						int retInt = 0;
						//是会务小组，T开头的
						if (empCode.indexOf("T")==0) {
							retInt = 1;
							retMap.put("failureReason","收发室登录用户是：T开头的会务小组员工");
							logger.info("=====收发室登录用户是：T开头的会务小组员工");							
						}
						//是会务小组，Z开头的
						else if (empCode.indexOf("Z")==0) {
							retInt = -1;
							retMap.put("failureReason","收发室登录用户是：Z开头的会务小组员工");
							logger.info("=====收发室登录用户是：Z开头的会务小组员工");
						}
						//是会务小组普通6位数工号，不是会务小组普通员工
						else {
							retInt = parcelService.checkIsSendAdm(empCode)==0?0:2;
							retMap.put("failureReason","收发室登录用户=>"+(retInt==0?"不是会务小组的普通员工":"是会务小组的普通6位数工号"));
							logger.info("=====收发室登录用户=>"+(retInt==0?"不是会务小组的普通员工":"是会务小组的普通6位数工号"));
						}		
						retMap.put("empMark", retInt);
						retMap.put("resultFlag",true);							
					}
				}
			} catch (Exception e) {
				//将异常信息记录入日志
				logger.info("=====判断是否收发室管理员接口出现异常："+e.getMessage());
				retMap.put("resultFlag",false);
				retMap.put("failureReason","判断是否收发室管理员接口出现异常!");
			}						
		}
		else{			
			retMap.put("isPOST",false);
			retMap.put("resultFlag",false);
			retMap.put("failureReason","请求方式不是POST!");			
		}
		//返回
		res = JsonUtil.mapToJsonString(retMap);
		writeToPage(response,res);
	}
	
	
	/** 
	* @Description: 保存代领人员信息
	* @author 268087 张广波
	* @date 2015-9-15 下午3:48:09  
	*/
	public void saveParcelAct(){
		HttpServletResponse response = setPageHead();		
		String res = "";
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		if("POST".equals(ServletActionContext.getRequest().getMethod())){	
			BufferedReader bu = null;
			String str = "";		
			try {
				//获取请求参数
				bu = ServletActionContext.getRequest().getReader();
				//将请求参数转换为字符串
				str = StringUtil.bufferString(bu);
				logger.info("=====保存代领人员信息接口传入的参数："+str);
				//保存代领人员信息
				retMap = (HashMap<String, Object>)parcelService.saveParcelAct(str, retMap);
			} catch (Exception e) {
				//将异常信息记录到日志
				logger.info("=====保存代领人员信息接口出现异常："+e.getMessage());
				retMap.put("resultFlag",false);
				retMap.put("failureReason","保存代领人员信息接口出现异常!");
			}						
		}
		else{			
			retMap.put("isPOST",false);
			retMap.put("resultFlag",false);
			retMap.put("failureReason","请求方式不是POST!");			
		}
		//返回
		res = JsonUtil.mapToJsonString(retMap);
		writeToPage(response,res);
	}
	
	
	/** 
	* @Description: 查询员工信息
	* @author 268087 张广波
	* @date 2015-9-12 上午10:27:33  
	*/
	public void queryEmpInfoList(){
		HttpServletResponse response = setPageHead();		
		String res = "";
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		if("POST".equals(ServletActionContext.getRequest().getMethod())){			
			retMap.put("isPOST",true);
			retMap.put("resultFlag",false);
			retMap.put("failureReason","前端数据获取不到!");			
			BufferedReader bu = null;
			String str = "";		
			try {
				//获取请求参数
				bu = ServletActionContext.getRequest().getReader();
				//将请求参数转换为字符串
				str = StringUtil.bufferString(bu);
				logger.info("=====收发室查询员工的参数："+str);
				if (!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
					//将参数转换为JsonObject
					JSONObject jsonObject = new JSONObject().parseObject(str);
					//校验工号，员工姓名
					if ((jsonObject.getString("empCode")!=null&&!("").equals(jsonObject.getString("empCode").trim()))||(jsonObject.getString("empName")!=null&&!("").equals(jsonObject.getString("empName").trim()))) {
						//工号
						String empCode = jsonObject.getString("empCode")==null?"":jsonObject.getString("empCode");
						//员工名称
						String empName = jsonObject.getString("empName")==null?"":jsonObject.getString("empName");
						EmpVO empVO = new EmpVO(empCode,empName);
						//查询员工信息
						List<EmpVO> empVOs = parcelService.queryEmpInfoList(empVO);
						res = "{\"empList\":";
						if (empVOs.size()>0) {
							res+=JsonUtil.beanToJsonString(empVOs);
						}
						else {
							res+="\"\"";
						}
						res+="}";
					}
					retMap.put("resultFlag",true);
					retMap.put("failureReason","查询成功！");
					retMap.put("empList", res);
				}
			} catch (Exception e) {
				//将异常信息记录到日志
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
		//返回
		String  backData = JsonUtil.mapToJsonString(retMap);
		writeToPage(response,backData);
	}
	
	
	
	/** 
	* @Description: 根据当前登录人工号查询已领取列表
	* @author 268087 张广波
	* @date 2015-9-15 下午12:12:29  
	*/
	public void queryParcelList(){
		HttpServletResponse response = setPageHead();		
		String res = "";
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		if("POST".equals(ServletActionContext.getRequest().getMethod())){			
			retMap.put("isPOST",true);
			retMap.put("resultFlag",false);
			retMap.put("failureReason","前端数据获取不到!");			
			BufferedReader bu = null;
			String str = "";		
			try {
				//获取请求参数
				bu = ServletActionContext.getRequest().getReader();
				//将请求参数转换为字符串
				str = StringUtil.bufferString(bu);
				logger.info("=====收发室查询已领取参数："+str);
				if (!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
					//将请求参数转换为jsonObject
					JSONObject jsonObject = new JSONObject().parseObject(str);
					if (jsonObject.getString("empCode")!=null&&!("").equals(jsonObject.getString("empCode").trim())) {
						String empCode = jsonObject.getString("empCode")==null?"":jsonObject.getString("empCode");
						ParcelListVO parcelListVO = new ParcelListVO(empCode);			
						//查询已领取列表
						List<ParcelListVO> parcelListVOs = parcelService.queryParcelList(parcelListVO);
						res = "{\"parcelList\":";
						if (parcelListVOs.size()>0) {
							res+=JsonUtil.beanToJsonString(parcelListVOs);
						}
						else {
							res+="\"\"";
						}
						res+="}";
					}
					retMap.put("resultFlag",true);
					retMap.put("failureReason","查询成功!");	
					retMap.put("parcelList", res);
				}
			} catch (Exception e) {
				//将异常信息记录到日志
				logger.info("=====收发室查询已领取接口出现异常："+e.getMessage());
				retMap.put("resultFlag",false);
				retMap.put("failureReason","收发室查询已领取接口出现异常!");
			}						
		}
		else{			
			retMap.put("isPOST",false);
			retMap.put("resultFlag",false);
			retMap.put("failureReason","请求方式不是POST!");			
		}
		//返回
		String backData = JsonUtil.mapToJsonString(retMap);
		writeToPage(response,backData);
	}
	

	/** 
	* @Description: 公共方法
	* @author 268087 张广波
	* @date 2016-1-6 上午11:20:31 
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
	* @date 2016-1-5 下午3:17:35 
	*  @return 
	*/
	public ISendParcelWorkService getParcelService() {
		return parcelService;
	}


	/** 
	* @Description: 设置操作service
	* @author 268087 张广波
	* @date 2016-1-5 下午3:17:39 
	*  @param parcelService 
	*/
	public void setParcelService(ISendParcelWorkService parcelService) {
		this.parcelService = parcelService;
	}	
}
