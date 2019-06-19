package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.IProcRecordService;
import com.deppon.dpm.module.management.shared.domain.ProcCheckTaskEntity;

/**
 * 
 * @author 王亚男
 * 工程验收
 */
public class ProcRecordAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3328273890416021756L;
	
	private Logger logger = LoggerFactory.getLogger(ProcRecordAction.class);
	
	/**
	 * 工程验收记录service
	 */
	private IProcRecordService procRecordService;
	
	/**
	 * 默认构造器
	 */
	public ProcRecordAction(){
		
	}
	
	/**
	 * 分页查询任务数据信息
	 */
	public void getProcTaskPage(){
		
		//设置响应头信息
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		//声明返回记录
		Result<List<ProcCheckTaskEntity>> result = null;
		BufferedReader bu = null;
		try{
			//出事化返回数据
			result = new Result<List<ProcCheckTaskEntity>>();
			bu = ServletActionContext.getRequest().getReader();
			String str = com.deppon.dpm.module.common.server.util.StringUtil
					.bufferString(bu);
			
			//str参数是否为空
			if(StringUtils.isNotEmpty(str)){
				//解析str为json
				JSONObject json = JsonUtil.parseObject(str);
				String pageSize = json.getString("pageSize");
				String pageNum = json.getString("pageNum");
				String deptName = json.getString("deptName");
				//判断项目名称是否为空
				if(StringUtils.isBlank(deptName)){
					deptName = null;
				}
				//判断分页信息中每页条数是否存在--为必填  前台H5传入
				if(StringUtils.isEmpty(pageSize)){
					result.setErrorMessage("没有参数传入  pageSize");
				}else{
					//设置默认页码
					if(StringUtils.isEmpty(pageNum)){
						pageNum = "1";
					}
					int pageNumInt = Integer.parseInt(pageNum)-1;
					int pageSizeInt = Integer.parseInt(pageSize);
					//获取用户工号
					String userId = getUserId();
					//获取数据信息
					List<ProcCheckTaskEntity> list = this.procRecordService.getCheckTaskPage(pageNumInt, pageSizeInt,deptName,userId);
					//获取数据总数
					int count = this.procRecordService.getCount(deptName,userId);
					result.setCount(count);
					result.setData(list);
				}
			}else{
				//设置异常返回信息
				result.setErrorMessage("没有参数传入  pageSize");
			}
		}catch (Exception e) {
			logger.info("has Error in getProcTaskPage");
			e.printStackTrace();
		}
		writeToPage(response,result);
	}
	
	/**
	 * 验收
	 * 最终提交 提交给PC端 并 本地保存
	 */
	public void submitData(){
		//设置响应头
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		//声明返回信息
		String result = "";
		BufferedReader bu = null;
		try{
			bu = ServletActionContext.getRequest().getReader();
			String str = com.deppon.dpm.module.common.server.util.StringUtil
					.bufferString(bu);
			//判断参数是否为空
			if(StringUtils.isNotEmpty(str)){
				//参数不为空,解析str为json
				JSONObject json = JsonUtil.parseObject(str);
				String number = json.getString("addressCode");
				//提交数据给PC端
				result = this.procRecordService.getTaskToPC(number);
			}else{
				//参数为空
				result = "{\"resultFlag\":false,\"failureReason\":\"提交参数为空!\"}";
			}
		}catch (Exception e) {
			//返回异常信息
			logger.info("has Error in getProcTaskPage");
			result = "{\"resultFlag\":false,\"failureReason\":\"异常!\"}";
			e.printStackTrace();
		}
		logger.info("result:"+result);
		//返回结果给页面
		writeToPage(response,result);
	}

	public IProcRecordService getProcRecordService() {
		return procRecordService;
	}

	public void setProcRecordService(IProcRecordService procRecordService) {
		this.procRecordService = procRecordService;
	}
	

}
