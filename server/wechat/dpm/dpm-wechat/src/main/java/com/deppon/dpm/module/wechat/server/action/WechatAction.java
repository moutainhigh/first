package com.deppon.dpm.module.wechat.server.action;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.wechat.server.job.WechatUserUpdateJob;
import com.deppon.dpm.module.wechat.server.service.impl.WechatTongxunluService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
/**
 * 企业微信通讯录
 * @author 276344
 *
 */
public class WechatAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	private static Logger logger  = LoggerFactory.getLogger(WechatAction.class);
	WechatTongxunluService wechatService;
	//调用接口凭证
	String token;
	//利用此jobid获取异步执行结果
	String jobid;
	//要删除的员工的工号
	String empCode;
	//部门id 根据这个从企业微信通讯录拉取部门信息
	String departmentId;
	//部门id 获取的部门id
	private String department_id;
	//递归获取子部门下面的成员
	private String fetch_child;
	//要更新的人员工号
	private String sysUserId;
	//标签
	private String tagid;
	//标签名
	private String tagName;



	//全量更新员工信息  异步
	@CookieNotCheckedRequired
	public void getAccess_token(){
		//跨域处理
		solveCrossDomain();
		//结果 集
		Result<Object> result = new Result<Object>();
		JSONObject obj = new JSONObject();
		try {		
			obj = wechatService.getWechatAccess_token();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			//日志
			logger.error("WECHAT-全最更新员工列表失败-----："+e);
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		// count
		result.setCount(1);
		// data
		result.setData(obj);
		// 返回
		writeToPage(result);
	};
	
	
	@CookieNotCheckedRequired
	public void getJobResult(){
		//跨域处理
		solveCrossDomain();
		//结果 集
		Result<Object> result = new Result<Object>();
		JSONObject resultObj = new JSONObject();
		try {		
			resultObj = wechatService.getTaskResult(jobid);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			//日志
			logger.error("WECHAT-全最更新员工列表失败-----："+e);
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		// count
		result.setCount(1);
		// data
		result.setData(resultObj);
		// 返回
		writeToPage(result);
	};
	
	@CookieNotCheckedRequired
	public void sendMessage(){
		try {
			wechatService.sendMessage(0);
			wechatService.sendMessage(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新员工信息
	 */
	public void updateUserInfo(){
		//跨域处理
		solveCrossDomain();
		//要更新的人员工号
		String toSysUser = "";
		//结果 集
		Result<JSONObject> result = new Result<JSONObject>();
		if (userId.equals("091801") || userId.equals("039047")) {
			//陈育旺：091801  何俊敏：039047两个是超级管理员权限 
			if(isEmpty(sysUserId)) {
				result.setErrorCode(Constants.WRONG_REQUEST);
				result.setErrorMessage("要更新的工号不能为空");
				writeToPage(result);
				return;
			};
			toSysUser = sysUserId;
		}else {
			toSysUser = userId;
		}
		JSONObject object = new JSONObject();
		try {		
			object = wechatService.updateUserInfoByEmpcode(toSysUser);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			//日志
			logger.error("WECHAT-更新员工信息失败-----："+e);
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(e.toString());
		}
		// count
		result.setCount(1);
		// data
		result.setData(object);
		// 返回
		writeToPage(result);
	}
	
	/**
	 * 创建员工  先删除再创建
	 */
	public void createUser(){
		//跨域处理
		solveCrossDomain();
		//要更新的人员工号
		String toSysUser = "";
		//结果 集
		Result<JSONObject> result = new Result<JSONObject>();
		if (userId.equals("091801") || userId.equals("039047")) {
			//陈育旺：091801  何俊敏：039047两个是超级管理员权限 
			if(isEmpty(sysUserId)) {
				result.setErrorCode(Constants.WRONG_REQUEST);
				result.setErrorMessage("要更新的工号不能为空");
				writeToPage(result);
				return;
			};
			toSysUser = sysUserId;
		}else {
			toSysUser = userId;
		}
		JSONObject object = new JSONObject();
		try {
			//先删除员工信息  不管删除成功与否  之后都执行创建员工信息操作  先删除后创建的逻辑在service里面
			object = wechatService.createUserByEmpcode(toSysUser);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			//日志
			logger.error("WECHAT-创建员工信息失败-----："+e);
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(e.toString());
		}
		// count
		result.setCount(1);
		// data
		result.setData(object);
		// 返回
		writeToPage(result);
	}
	
	//全量更新部门  异步
	@CookieNotCheckedRequired
	public void updateDepponDepartmentAll(){
		//跨域处理
		solveCrossDomain();
		//结果 集
		Result<JSONObject> result = new Result<JSONObject>();
		JSONObject object = new JSONObject();
		try {		
			object = wechatService.updateDepponDepartmentAll();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			//日志
			logger.error("WECHAT-全量更新部门 失败-----："+e);
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		// count
		result.setCount(1);
		// data
		result.setData(object);
		// 返回
		writeToPage(result);
	};

	////增量更新员工信息  异步 
	@CookieNotCheckedRequired
	public void updateDepponpUserAll(){
		//跨域处理
		solveCrossDomain();
		//结果 集
		Result<JSONObject> result = new Result<JSONObject>();
		JSONObject object = new JSONObject();
		try {		
			object = wechatService.updateDepponUserAll();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			//日志
			logger.error("WECHAT-全最更新员工列表失败-----："+e);
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		// count
		result.setCount(1);
		// data
		result.setData(object);
		// 返回
		writeToPage(result);
	};
	
////全量更新员工信息  异步 
	@CookieNotCheckedRequired
	public void updateDepponpUserAllForOnce(){
		//跨域处理
		solveCrossDomain();
		//结果 集
		Result<JSONObject> result = new Result<JSONObject>();
		JSONObject object = new JSONObject();
		try {		
			object = wechatService.updateDepponUserAllForOnce();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			//日志
			logger.error("WECHAT-全最更新员工列表失败-----："+e);
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		// count
		result.setCount(1);
		// data
		result.setData(object);
		// 返回
		writeToPage(result);
	};
	
	/*
	 * 创建标签  {"tagid":1001,"tagname":"M7"},{"tagid":1002,"tagname":"M8"},{"tagid":1003,"tagname":"M9"},{"tagid":1004,"tagname":"M10"}]}
	 */
	@CookieNotCheckedRequired
	public void createTag(){
		//跨域处理
		solveCrossDomain();
		//结果 集
		Result<JSONObject> result = new Result<JSONObject>();
		JSONObject object = new JSONObject();
		try {		
			object = wechatService.createTag(tagName, tagid);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			//日志
			logger.error("WECHAT-创建标签失败-----："+e);
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
			String RESULT_ERROR = "{'ERROR_MSG':'" + e + "'}";
			object = JSONObject.fromObject(RESULT_ERROR);
		}
		// count
		result.setCount(1);
		// data
		result.setData(object);
		// 返回
		writeToPage(result);
	}
	
	/**
	 * 添加员工标签 只需参数写上tagid就可以增加  具体Tagid对应的tagname在sevice里写
	 */
	@CookieNotCheckedRequired
	public void addUserTag(){
		//跨域处理
		solveCrossDomain();
		//结果 集
		Result<JSONObject> result = new Result<JSONObject>();
		JSONObject object = new JSONObject();
		try {		
			object = wechatService.addTagUsers(tagid);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			//日志
			logger.error("WECHAT-增加用户标签失败-----："+e);
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			String RESULT_ERROR = "{'ERROR_MSG':'" + e + "'}";
			object = JSONObject.fromObject(RESULT_ERROR);
		}
		// count
		result.setCount(1);
		// data
		result.setData(object);
		// 返回
		writeToPage(result);
	};
	
	@CookieNotCheckedRequired
	public void methodTest(){
		//跨域处理
		solveCrossDomain();
		//结果 集
		Result<String> result = new Result<String>();
		String resultStr = "";
		try {		
			wechatService.methodTest();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
			resultStr = "SUCESS";
		} catch (Exception e) {
			//日志
			logger.error("WECHAT-全最更新员工列表失败-----："+e);
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			resultStr = "ERROR:" + e;
		}
		// count
		result.setCount(1);
		// data
		result.setData(resultStr);
		// 返回
		writeToPage(result);
	}
	
	/**
	 * 删除员工信息
	 */
	@CookieNotCheckedRequired
	public void deleteUser(){
		//跨域处理
		solveCrossDomain();
		//结果 集
		Result<String> result = new Result<String>();
		JSONObject object = new JSONObject();
		String resultStr = "";
		try {		
			wechatService.deleteUserInfo();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
			resultStr = "success";
		} catch (Exception e) {
			//日志
			logger.error("WECHAT-全最更新员工列表失败-----："+e);
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			resultStr = "error";
		}
		// count
		result.setCount(1);
		// data
		result.setData(resultStr);
		// 返回
		writeToPage(result);
	}
	
	/**
	 * 获取部门列表信息
	 */
	@CookieNotCheckedRequired
	public void departmentInfo(){
		//跨域处理
		solveCrossDomain();
		//结果 集
		Result<JSONObject> result = new Result<JSONObject>();
		JSONObject object = new JSONObject();
		try {		
			if (departmentId == null) {
				departmentId = "";
			}
			object = wechatService.getDepartmentInfoFromWechat(token, departmentId);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			//日志
			logger.error("WECHAT-全最更新员工列表失败-----："+e);
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		// count
		result.setCount(1);
		// data
		result.setData(object);
		// 返回
		writeToPage(result);
	}
	
	/**
	 * 获取员工信息
	 */
	@CookieNotCheckedRequired
	public void getUserInfo(){
		//跨域处理
		solveCrossDomain();
		//结果 集
		Result<JSONObject> result = new Result<JSONObject>();
		JSONObject object = new JSONObject();
		try {		
			if (departmentId == null) {
				departmentId = "";
			}
			object = wechatService.getUserInfoFromWechat(token, department_id, fetch_child);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			//日志
			logger.error("WECHAT-全最更新员工列表失败-----："+e);
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		// count
		result.setCount(1);
		// data
		result.setData(object);
		// 返回
		writeToPage(result);
	}
	
	/**
	 * 跨域处理
	 */
	public void solveCrossDomain(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	}
	//判断字符串为空
	private  boolean isEmpty(CharSequence str) {
		if (str == null || str.length() == 0)
			return true;
		else
			return false;
	}
	/**
	 * set
	 * @param wechatService
	 */
	public void setWechatService(WechatTongxunluService wechatService) {
		this.wechatService = wechatService;
	}
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getFetch_child() {
		return fetch_child;
	}
	public void setFetch_child(String fetch_child) {
		this.fetch_child = fetch_child;
	}

	public String getSysUserId() {
		return sysUserId;
	}
	public void setSysUserId(String sysUserId) {
		this.sysUserId = sysUserId;
	}

	public String getTagid() {
		return tagid;
	}


	public void setTagid(String tagid) {
		this.tagid = tagid;
	}


	public String getTagName() {
		return tagName;
	}


	public void setTagName(String tagName) {
		this.tagName = tagName;
	}



}
