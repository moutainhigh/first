package com.deppon.dpm.module.wfs.server.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import weaver.docs.webservices.DocInfo;
import weaver.docs.webservices.DocService;
import weaver.workflow.webservices.WorkflowService;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.DES;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.wfs.server.service.IWeaverWfsService;
import com.deppon.dpm.module.wfs.server.service.IWorkItemsListService;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowListEntity;
import com.deppon.dpm.module.wfs.shared.dto.WorkItemsDto;
import com.deppon.dpm.module.wfs.shared.vo.NwfsSearchVo;
import com.deppon.dpm.module.wfs.shared.vo.OaWorkItem;
import com.deppon.dpm.module.wfs.shared.vo.WeaverAttachments;
import com.deppon.dpm.module.wfs.shared.vo.WeaverWorkflowInfo;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.opensymphony.xwork2.ModelDriven;

public class WeaverWfsAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 日志
	 */
	private static Logger logger  = LoggerFactory.getLogger(WeaverWfsAction.class);
	// service层
	private IWeaverWfsService weaverService;

	//附件value
	//private int fieldValue;
	private String fieldValue;
	//请求id  请求工作流待办列表时会返回此字段 此字段用来请求工作流详情时需传入的参数
	private int requestId;
	//workflowID 获取退回节点时需传的参数 此参数在详情反回数据里获取
	private String workflowId;
	//退回的节点号
	private String nodeId;
	//密码
	private String password;
	//设备类型
	private String deviceType;
	//流程状态
	private String workflowStatus;
	//分页功能
	private String pageNo;
	@Autowired
	public WorkflowService workflowService;
	/**
	 * service
	 */
	private IWorkItemsListService workItemsListService;

	@Autowired
	DocService workflowAttachment;
	/**
	 * 文本输入框输入内容
	 */
	private String searchContent;


	//待办列表
	@CookieNotCheckedRequired
	public void workflowListQuery(){
		//跨域处理
		solveCrossDomain();
		//结果 集
		Result<List<WorkflowListEntity>> result = new Result<List<WorkflowListEntity>>();
		List<WorkflowListEntity> listData = new ArrayList<WorkflowListEntity>();
		try {		
			listData = weaverService.workflowList(userId,"", pageNo);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			//日志
			logger.error("------获取工作流待办列表失败-----"+e);
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		// count
		result.setCount(listData.size());
		// data
		result.setData(listData);
		// 返回
		writeToPage(result);
	}
	
	/**
	 * 新工作流+老工作流待办列表
	 */
	@CookieNotCheckedRequired
	public void workflowListAll(){
		//跨域处理
		solveCrossDomain();
		//结果 集
		Result<List<Object>> result = new Result<List<Object>>();
		//新工作流列表
		List<WorkflowListEntity> newlist = new ArrayList<WorkflowListEntity>();
		//老工作流列表
		WorkItemsDto dto = new WorkItemsDto();
		dto.setUserId(userId);
		List<OaWorkItem> oldlist = new ArrayList<OaWorkItem>();
		try {	
			//获取新工作流
			newlist = weaverService.workflowList(userId,"", pageNo);
			//添加状态(新)
			for(WorkflowListEntity workflowList : newlist){
				workflowList.setStatus("new");
			}
			//获取老工作流
			oldlist = workItemsListService.workitemslist1(dto);
			//添加状态(老)
			for(OaWorkItem oaWorkItem : oldlist){
				oaWorkItem.setStatus("old");
			}
		} catch (Exception e) {
			//日志
			logger.error("------获取工作流待办列表失败1-----"+e);
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		//合并新老工作流
		List<Object> listAll = new ArrayList<Object>();
		listAll.addAll(newlist);
		listAll.addAll(oldlist);
		//按创建时间排序
		ListSort(listAll);
		//返回前端
		// data
		result.setData(listAll);
		// errorCode
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		// errorMessage
		result.setErrorMessage(Constants.ACTIVE_YES);
		// 返回
		writeToPage(result);
	}
	
	//新老工作流列表按创建时间排序
	public static void ListSort(List<Object> list){
		Collections.sort(list, new Comparator<Object>(){
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				try{
					Date dt1 = new Date();
					Date dt2 = new Date();
					if (o1.getClass() == WorkflowListEntity.class) {
						//新工作流，String类型
						System.out.println("xin");
						dt1 = format.parse(((WorkflowListEntity)o1).getRequestInfo().getCreateTime());
					}else{
						//老工作流，Date类型
						System.out.println("lao");
						dt1 = ((OaWorkItem)o1).getCreatetime();
					}
					if (o2.getClass() == WorkflowListEntity.class) {
						dt2 = format.parse(((WorkflowListEntity)o2).getRequestInfo().getCreateTime());
					}else{
						dt2 = ((OaWorkItem)o2).getCreatetime();
					}
					if (dt1.getTime() < dt2.getTime()) {
						return 1;
					} else if (dt1.getTime() > dt2.getTime()) {
						return -1;
					} else {
						return 0;
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				return 0;
			}
	});	
	}

	/**
	 * 工作流详情
	 */
	@CookieNotCheckedRequired
	public void workflowInfo () {
		//跨域处理                                
		solveCrossDomain();
		Result<weaver.workflow.webservices.WorkflowRequestInfo> result = new Result<weaver.workflow.webservices.WorkflowRequestInfo>();
		weaver.workflow.webservices.WorkflowRequestInfo resultInfo = new weaver.workflow.webservices.WorkflowRequestInfo();
		try {
			resultInfo = weaverService.workflowInfo(userId, requestId);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			//日志
			logger.error("------获取工作流详情-----"+e);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		// count
		result.setCount(1);
		// data
		result.setData(resultInfo);
		// 返回
		writeToPage(result);
	}
	
	// 提交
	@CookieNotCheckedRequired
	public void submitWorkflowRequest () {
		                                                    
		//解决H5跨域
		solveCrossDomain();
		String str = null;
		//接收前端参数的实体类
		WeaverWorkflowInfo entity = null;
		//结果集
		Result<String> result = new Result<String>();
		String resultStirng = "";
		try {
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			//编码转换
			str = java.net.URLDecoder.decode(StringUtil.bufferString(bu), "utf-8");
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				//将前端传来的json转为实体类
				entity = JSONObject.parseObject(str,
						WeaverWorkflowInfo.class);
				//提交结果 
				resultStirng = weaverService.workflowSubmit(userId, entity);
				if (resultStirng.equals("failed")) {
					//失败的话打印日志
					logger.info("------调用泛微工作流提交接口返回failed-----");
				}
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				// errorMessage
				result.setErrorMessage(Constants.ACTIVE_YES);
			}else {
				logger.info("------提交工作流接口前端提交参数为空-----");
			}
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			//日志
			logger.error("------工作流提交异常-----"+e + "  工号" + userId);
		}
		//count
		result.setCount(1);
		//data
		result.setData(resultStirng);
		//返回前端
		writeToPage(result);
	}
	
	//不同意接口
	@CookieNotCheckedRequired
	public void disAgree() {
		//解决H5跨域
		solveCrossDomain();
		//结果集
		Result<String> result = new Result<String>();
		String resultString = "";
		try {
			resultString = weaverService.workflowtUnagree(userId, requestId);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			//日志
			logger.error("------调用工作流不同意接口失败：工号:"+userId + " reason:" + e);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		//count
		result.setCount(1);
		//data
		result.setData(resultString);
		//返回前端
		writeToPage(result);
	}

	/**
	 * 工作流附件列表接口
	 */
	@CookieNotCheckedRequired
	public void attachmentInfo() {
		//跨域处理
		solveCrossDomain();
		Result<List<WeaverAttachments>> result = new Result<List<WeaverAttachments>>();
		List<WeaverAttachments> docInfos = new ArrayList<WeaverAttachments>();
		try {
			/**
			 * 参数含义
			 * loginid：String 用户登陆名   
			 * password ：String 用户登陆密码  
			 * logintype：int 登陆方式(0 数据库验证;1 动态密码验证;2 LDAP验证)  
			 * ipaddress：String 服务器IP地址 
			 * 方法返回值 : String：登陆Session码
			 */
			
			String ipAdress = InetAddress.getLocalHost().getHostAddress();
			//密码解密
			password = new String(Base64.decodeBase64(DES.decryptDES(password)));
			String sessionId =  workflowAttachment.login(userId, password, 0, ipAdress);
			/**
			 * 参数含义： 参数1：fieldValue 此参数在详情里   参数2：登录session码
			 */
			//*******fieldValue要加非空判断在转换
			String[] file = fieldValue.split(",");
			for (String ss : file) {
				weaver.docs.webservices.DocInfo info = workflowAttachment.getDoc(Integer.parseInt(ss), sessionId);
				WeaverAttachments att = weaverService.valueToEntity(info);
				docInfos.add(att);
			}
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			logger.error("工作流附件接口异常："+e);
		}
		// count
		result.setCount(1);
		// data
		result.setData(docInfos);
		//反回给前端
		writeToPage(result);
	}
	
	/**
	 * 打开附件
	 */
	@CookieNotCheckedRequired
	public void openAttachmentInfo() {
		//解决H5跨域
		solveCrossDomain();
		weaver.docs.webservices.DocInfo docInfo = new weaver.docs.webservices.DocInfo();
		try {
			/**
			 * 参数含义
			 * loginid：String 用户登陆名   
			 * password ：String 用户登陆密码  
			 * logintype：int 登陆方式(0 数据库验证;1 动态密码验证;2 LDAP验证)  
			 * ipaddress：String 服务器IP地址 
			 * 方法返回值 : String：登陆Session码
			 */
			String ipAdress = InetAddress.getLocalHost().getHostAddress();
			//密码解密
			password = new String(Base64.decodeBase64(DES.decryptDES(password)));
			String sessionId =  workflowAttachment.login(userId, password, 0, ipAdress);
			/**
			 * 参数含义： 参数1：fieldValue 此参数在详情里   参数2：登录session码
			 */
			//*******fieldValue要加非空判断在转换
			docInfo = workflowAttachment.getDoc(Integer.parseInt(fieldValue), sessionId);
			dealAttachments(docInfo);
			return;
		} catch (Exception e) {

			logger.error("工作流附件接口异常："+e);
		}

	}
	
	
	/**
	 * 把string写成文件保存起来
	 * @param doc
	 * @throws IOException
	 */
	@CookieNotCheckedRequired
	private void dealAttachments(DocInfo doc) throws IOException {
		logger.info("开始创建workflowFile文件夹");
		
		weaver.docs.webservices.DocAttachment[] attachements = doc.getAttachments();
		//要保存的路径  此地要先在本地建一个workflowFile文件夹
		String path = "/dpmfile/emailattachment/";
		// 创建文件夹
		File dir = new File(path);

		// 不存在就创建
		if (!dir.exists()){
			logger.info("不存在此路径");
			dir.mkdirs();
			
		}
			
		
		for (weaver.docs.webservices.DocAttachment docAttachment : attachements) {
			// 文件名
			logger.info("开始将文件写入workflowFile");
			String filename = docAttachment.getFilename();
			// 保存文件到本地路径
			File file = new File(path + filename);
			//获取文件内容
			String filecontent = docAttachment.getFilecontent();
			byte[] bytes = Base64.decodeBase64(filecontent);
			FileUtils.writeByteArrayToFile(file, bytes);
			logger.info("件写入workflowFile完毕");
//			FileOutputStream out = new FileOutputStream(file);
//			out.write(bytes);
//			out.close();
			if(!file.exists()){
				// 附件不存在
				logger.info("写入workflowFile之后判断有没有写成功 40006");
				writeToPage("40006");
				return;
			}
			weaverService.decryptFile(userId, deviceType, filename, file);
		}
	}

	/**
	 * 自由回退节点
	 */
	@CookieNotCheckedRequired
	public void freedReject() {
		//解决H5跨域
		solveCrossDomain();
		// result
		Result<String> result = new Result<String>();
		// 请求结果
		String resultStr = "";
		try {
			/**
			 * 自由流程退回
			 * 
			 * @param requestid 流程请求ID
			 * @param empCode 工号
			 * @param  nodeid 需要退回的目标节点
			 * @param  nodeid 回退意见
			 * @return String 提交结果
			 */
			resultStr = workflowService.freedRejectRequest(requestId, userId, nodeId,"");
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			// 日志
			logger.error("工作流退回异常："+e);

		}
		// count
		result.setCount(1);
		// data
		result.setData(resultStr);
		// 返回给前端
		writeToPage(result);
	}

	/**
	 * 获取退回可选择节点
	 */
	@CookieNotCheckedRequired
	public void getRejectNode(){
		//解决H5跨域
		solveCrossDomain();
		// result
		Result<String> result = new Result<String>();
		String resultStr = "";
		try {
			/**
			 * 获取退回可选择节点
			 * 
			 * @param requestid 流程请求ID
			 * @param workflowId 工作流id
			 * @param  empcode 工号
			 * @return String 提交结果
			 */
			resultStr = workflowService.getRejectNode(requestId, Integer.parseInt(workflowId), userId);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			e.printStackTrace();
			logger.error("工作流获取回退节点号异常："+e);
		}
		// count
		result.setCount(1);
		// data
		result.setData(resultStr);
		// 返回给前端
		writeToPage(result);

	}
	
	/**
	 * 我的已办流程列表：getMyWorkflowRequestList  自己起草的审批完成的（没批的）
	 */
	@CookieNotCheckedRequired
	public void myWorkflowList() {
		//解决H5跨域
		solveCrossDomain();
		//结果 集
		Result<List<WorkflowListEntity>> result = new Result<List<WorkflowListEntity>>();
		List<WorkflowListEntity> listData = new ArrayList<WorkflowListEntity>(); 
		try {
			listData = weaverService.myWorkflowList(userId, workflowStatus, pageNo);
			// errorCodeworkflowStatus
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			e.printStackTrace();
			logger.error("获取我的已办流程列表失败：工号：" + userId + "reason:" + e);
		}
		// count
		result.setCount(listData.size());
		// data
		result.setData(listData);
		// 返回给前端
		writeToPage(result);
	}
	
	/**
	 * 我的已办理流程列表
	 */
	@CookieNotCheckedRequired
	public void getHendledWorkflowList(){	
		//解决H5跨域
		solveCrossDomain();
		//结果 集
		Result<List<WorkflowListEntity>> result = new Result<List<WorkflowListEntity>>();
		List<WorkflowListEntity> listData = new ArrayList<WorkflowListEntity>(); 
		try {
			//由于后业规则改动 此方法第三个参数无需传入 
			listData = weaverService.getHendledWorkflowList(userId,pageNo,"");
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			logger.error("已办理流程列表异常："+e);
		}
		// count
		result.setCount(listData.size());
		//data
		result.setData(listData);
		// 返回给前端
		writeToPage(result);
	}
	
	//工作流搜索接口
	@CookieNotCheckedRequired
	public void workflowSearch(){
		//解决H5跨域
		solveCrossDomain();
		//结果集
		Result<List<WorkflowListEntity>> result = new Result<List<WorkflowListEntity>>();
		List<WorkflowListEntity> requestInfos = new ArrayList<WorkflowListEntity>();
		//接收前端传来的json
		NwfsSearchVo entity = new NwfsSearchVo();
		try {
			BufferedReader bu =  ServletActionContext.getRequest().getReader();
			//编码转换
			String str = java.net.URLDecoder.decode(StringUtil.bufferString(bu), "utf-8");
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				//将前端传来的json转为实体类
				entity = JSONObject.parseObject(str,
						NwfsSearchVo.class);
				requestInfos = weaverService.workflowSearch(userId, entity);
			}
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			logger.error("工作流流搜索出现异常："+e +"工号："+userId);
			e.printStackTrace();
		}
		// count
		result.setCount(requestInfos.size());
		//data 
		result.setData(requestInfos);
		// 返回给前端
		writeToPage(result);
	}
	
	//搜索框搜索
	@CookieNotCheckedRequired
	public void textSearch(){
		//解决H5跨域
		solveCrossDomain();
		//结果集
		Result<List<WorkflowListEntity>> result = new Result<List<WorkflowListEntity>>();
		List<WorkflowListEntity> requestInfos = new ArrayList<WorkflowListEntity>();
		try {

			requestInfos = weaverService.textSearch(searchContent, userId);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			logger.error("工作流流搜索出现异常："+e +"工号："+userId);
			e.printStackTrace();
		}
		// count
		result.setCount(requestInfos.size());
		//data 
		result.setData(requestInfos);
		// 返回给前端
		writeToPage(result);
	}
	
	//删 除工作流接口
	@CookieNotCheckedRequired
	public void workflowDelete(){
		solveCrossDomain();
		//结果集
		Result<String> result = new Result<String>();
		String deleteResult = "";
		try {
			if (weaverService.workflowDelete(userId, requestId)) {
				deleteResult = "true";
			} else {
				deleteResult = "false";
			}
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			deleteResult = "删除接口异常";
			logger.error("工号：" + userId + "  删除工作流requestId:" + requestId + "出现异常 reason:" + e);
		}
		// count
		result.setCount(1);
		//data 
		result.setData(deleteResult);
		// 返回给前端
		writeToPage(result);
	}
	
	//工作流撤销接口
	@CookieNotCheckedRequired
	public void workflowRevoke(){
		solveCrossDomain();
		//结果集
		Result<String> result = new Result<String>();
		String revokeResult = "";
		try {
			if (weaverService.workflowRevoke(requestId, userId)) {
				revokeResult = "true";
			} else {
				revokeResult = "false";
			}
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			revokeResult = "撤销接口异常";
			logger.error("工号：" + userId + "  删除工作流requestId:" + requestId + "出现异常 reason:" + e);
		}
		// count
		result.setCount(1);
		//data 
		result.setData(revokeResult);
		// 返回给前端
		writeToPage(result);
	}
	
	/**
	 * 解决H5跨域
	 */
	public void solveCrossDomain(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	}
	
	/**
	 * 重写writeToPage
	 */
	@Override
	protected void writeToPage(Object result) {
		// TODO Auto-generated method stub
		// 定义输出流
		PrintWriter writer = null;
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			// 设置响应类型
			response.setContentType("text/html;charset=utf-8");
			// 跨域设置
			response.setHeader("Access-Control-Allow-Origin", "*");
			// 获取一个printWriter对象
			writer = response.getWriter();
			// 打印,将null值输出为空字符串
			// writer.write(JSON.toJSONString(result,
			// SerializerFeature.WriteNullStringAsEmpty));
			writer.write(JSON.toJSONString(result,
					SerializerFeature.DisableCircularReferenceDetect));
		} catch (IOException e) {
			// 错误打印
			e.printStackTrace();
		} finally {
			if (writer != null) {
				// 关闭流
				writer.close();
			}
		}
	}

	/**
	 * set
	 * @param requestId
	 */
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	/**
	 * get
	 * @return
	 */
	public int getRequestId() {
		return requestId;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	/**
	 * get
	 * @return
	 */
	public String getWorkflowId() {
		return workflowId;
	}
	/**
	 * set
	 * @param workflowId
	 */
	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}
	/**
	 * get
	 * @return
	 */
	public String getNodeId() {
		return nodeId;
	}
	/**
	 *set 
	 */
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	/**
	 * get
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * set
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * get
	 * @return
	 */
	public String getDeviceType() {
		return deviceType;
	}

	/**
	 * set
	 * @param deviceType
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	
	/**
	 * get
	 * @return
	 */
	public IWeaverWfsService getWeaverService() {
		return weaverService;
	}

	/**
	 * set
	 * @param weaverService
	 */
	public void setWeaverService(IWeaverWfsService weaverService) {
		this.weaverService = weaverService;
	}
	/**
	 * set
	 * @param workflowStatus
	 */
	public void setWorkflowStatus(String workflowStatus) {
		this.workflowStatus = workflowStatus;
	}
	
	/**
	 * set
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * get
	 * @return
	 */
	public IWorkItemsListService getWorkItemsListService() {
		return workItemsListService;
	}
    /**
     * set
     * @param workItemsListService
     */
	public void setWorkItemsListService(IWorkItemsListService workItemsListService) {
		this.workItemsListService = workItemsListService;
	}
	
	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
	
}
