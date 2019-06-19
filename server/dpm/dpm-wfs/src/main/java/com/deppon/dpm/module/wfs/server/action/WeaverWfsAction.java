package com.deppon.dpm.module.wfs.server.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import weaver.docs.webservices.DocAttachment;
import weaver.docs.webservices.DocInfo;
import weaver.docs.webservices.DocService;
import weaver.workflow.approvalopinion.ApprovalopinionService;
import weaver.workflow.webservices.WorkflowBaseInfo;
import weaver.workflow.webservices.WorkflowRequestInfo;
import weaver.workflow.webservices.WorkflowService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.DecryptNewFile;
import com.deppon.dpm.module.common.server.util.ParamUtils;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.wfs.server.dao.IMonitorDao;
import com.deppon.dpm.module.wfs.server.service.IQueryEmployeeInfoService;
import com.deppon.dpm.module.wfs.server.service.IWeaverWfsService;
import com.deppon.dpm.module.wfs.server.service.IWorkItemsListService;
import com.deppon.dpm.module.wfs.server.util.RestfulUtil;
import com.deppon.dpm.module.wfs.shared.domain.BandApproveEntity;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowLevelMonitorEntity;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowListEntity;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowMonitorEntity;
import com.deppon.dpm.module.wfs.shared.dto.WorkItemsDto;
import com.deppon.dpm.module.wfs.shared.vo.NwfsSearchVo;
import com.deppon.dpm.module.wfs.shared.vo.OaWorkItem;
import com.deppon.dpm.module.wfs.shared.vo.WeaverAttachments;
import com.deppon.dpm.module.wfs.shared.vo.WeaverWorkflowInfo;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

/**
 * 待办列表
 * 注：数据库新增一条数据  需要重启接口服务  才会在待办列表中显示
 *   生产环境 在数据库 新增数据 也需要重启服务
 * @author 245102
 *
 */
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
	private ApprovalopinionService approvalopinionService;
	//监控日志
	private IMonitorDao monitordao;
	//附件value
	//private int fieldValue;
	private String fieldValue;
	//请求id  请求工作流待办列表时会返回此字段 此字段用来请求工作流详情时需传入的参数
	private int requestId;
	//workflowID 获取退回节点时需传的参数 此参数在详情反回数据里获取
	private String workflowId;
	//工作流名
	private String workflowName;
	//跳转详情页面路径
	private String workflowPage;
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
	//版本号
	private String version;
	//审批意见 【电子签章 不同意时  用到】
	private String remark;
	@Autowired
	public WorkflowService workflowService;
	//员工信息
	private IQueryEmployeeInfoService employeeService;
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
	//所属系统
	private String sysCode;
	private String creatorId;
	private String flowType;

	//文件发布申请 附件列表http://10.230.47.31:8999/workflow/fileUpload/initFileListForOldFile?
	private String attachmentList;
	//文件发布申请 打开附件http://10.230.47.31:8999/workflow/fileUpload/getOldFile?
	private String openAttachments;
	//文件发布申请 表名称
	private String attList;
	//请求id  请求工作流待办列表时会返回此字段 此字段用来请求工作流详情时需传入的参数
	private String requestid;
	//区分文件发布申请工作流字段
	private String htmlpath;
	//文件名
	private String fileName;
	
	//全局静态变量  详情页面赋值  附件使用
	private static String workFlowId;
	//详情工号和附件工号匹配
 	private static String empcode;
 	//工作流名称
 	private static String workFlowName;
 	private static String creatorid;
 	private static String fileDocId;
	//工号等级
  	private String joblevel;
  	//详情requestid和附件/删除接口的requestid匹配
	private static int requestIds;
	//待办列表
	public void workflowListQuery(){
		//跨域处理
		solveCrossDomain();
		//结果 集
		Result<List<WorkflowListEntity>> result = new Result<List<WorkflowListEntity>>();
		List<WorkflowListEntity> listData = new ArrayList<WorkflowListEntity>();
		try {		
			//判断工号的规范性
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
			listData = weaverService.workflowList(userId,"", StringEscapeUtils.escapeSql(pageNo));
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
			//日志
			logger.error("------工作流提交异常-----"+e + "  工号" + userId);
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
	public void workflowListAll(){
		//跨域处理
		solveCrossDomain();
		//结果 集
		Result<List<Object>> result = new Result<List<Object>>();
		//新工作流列表
		List<WorkflowListEntity> newlist = new ArrayList<WorkflowListEntity>();
		//判断工号的规范性
		if(ParamUtils.checkUserId(userId)){
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			writeToPage(result);
			return;
		}
		//老工作流列表
		WorkItemsDto dto = new WorkItemsDto();
		dto.setUserId(userId);
		//查询所有系统老工作流列表
		List<OaWorkItem> oldlist = new ArrayList<OaWorkItem>();
		//查询所有系统老工作流列表
		List<Object> listAll = new ArrayList<Object>();
		//根据工作流号 获取等级
		String joblevelByFlowId;
		//获取本库工作流号
		String workflowId;
		try { 
			//获取新工作流
			newlist = weaverService.workflowList(userId,"", StringEscapeUtils.escapeSql(pageNo));
			//添加状态(新)
			for(WorkflowListEntity workflowList : newlist){
				workflowList.setStatus("new");
			}
			//获取老工作流
			long startTime3 = System.currentTimeMillis();    //获取开始时间
			//只查询lsp老工作流
			List<BandApproveEntity> offEntity = weaverService.queryBandApproveEntity();
			//OA获取员工等级
			String joblevel = employeeService.getJoblevel(userId);
			oldlist = workItemsListService.workitemslist1(dto);
			for(int l = 0;l < offEntity.size(); l++){
				BandApproveEntity ba = offEntity.get(l);
				workflowId = ba.getWorkflowId();
				if(offEntity == null || workflowId == null || offEntity.equals("") || workflowId.equals("")){
					logger.info("待办列表（老工作流lsp） - 查询为  - null");
					//显示所有的 老工作流
					oldlist = workItemsListService.workitemslist1(dto);
				}else{
					//显示所有的 老工作流
					oldlist = workItemsListService.workitemslist1(dto);
					//倒序删除
					for(int i = oldlist.size()-1;i >= 0;i--){
						OaWorkItem oa = oldlist.get(i);
						//获取OA老工作流 workflowid列表
						flowType = oa.getFlowtype();
						
						if(flowType != null && flowType == workflowId || !("").equals(flowType) && (workflowId).equals(flowType)){
							//根据工作流号 获取等级
							joblevelByFlowId = weaverService.getJoblevelByworkFlowId(flowType);
							//隐藏 <=10以下的等级 采购合同工作流
							if((joblevelByFlowId != null) && (joblevel != null) && (joblevel.equals("C") || joblevel.equals("D"))){
								oldlist = workItemsListService.workitemslist1(dto);	
							}else{
								if(Integer.parseInt(joblevel) >= Integer.parseInt(joblevelByFlowId)){
									oldlist = workItemsListService.workitemslist1(dto);	
								}else{
									logger.info("id:"+oa.getFlowtype()+"----name:"+oa.getProcessinstname()+"----订单busino:"+oa.getBusino());
									oldlist.remove(i);
								}
							}
							//没有等级为15的  目的是全查
							if(joblevelByFlowId.equals("15") || joblevelByFlowId == "15"){
								logger.info("id:"+oa.getFlowtype()+"----name:"+oa.getProcessinstname()+"----订单busino:"+oa.getBusino());
								oldlist.remove(i);
							}
						}
					}
				}
			}
			
			long endTime3 = System.currentTimeMillis();    //获取结束时间
			logger.info("待办列表（老工作流方法） - 程序运行时间  - 后台：" + (endTime3 - startTime3) + "ms");
//			System.out.println("待办列表（老工作流方法） - 程序运行时间  - 后台：" + (endTime3 - startTime3) + "ms");
			
			//添加状态(老)
			for(OaWorkItem oaWorkItem : oldlist){
				oaWorkItem.setStatus("old");
			}
			
			//获取开始时间
			long startTime4 = System.currentTimeMillis();    
			/**
			 * 查询监控表等级10以上的错误信息 匹配 待办数据
			 */
			//只查询fssc老工作流 根据工号查询所有的错误信息
			List<WorkflowLevelMonitorEntity> wlme = monitordao.queryBandApproveMonitor(userId);
			//map中key值不存在重复  会有去重效果
			Map<String, WorkflowLevelMonitorEntity> resultMap = new HashMap<String, WorkflowLevelMonitorEntity>();
			//循环等级监控表数据 封装到map
			for (WorkflowLevelMonitorEntity info : wlme) {
				String workFlowName = info.getWorkflowName();
				resultMap.put(workFlowName, info);
			}
			
			//监控信息表  匹配 新工作流待办数据
			Iterator<WorkflowListEntity> newIterator = newlist.iterator();
			String busino = null;
			while(newIterator.hasNext()){
				WorkflowListEntity wle = newIterator.next();
				//新工作流，订单编号
				busino = wle.getRequestInfo().getRequestMark();
				if (resultMap.containsKey(busino)) {
					//注意：
					newIterator.remove();
					//将匹配到的订单编号 在监控表暂时隐藏
					resultMap.remove(busino);
				}
	        }
			//合并新老工作流
			listAll.addAll(newlist);
			
			//监控信息表  匹配 老工作流待办数据
			Iterator<OaWorkItem> oldIterator = oldlist.iterator();
			while(oldIterator.hasNext()){
				OaWorkItem oi = oldIterator.next();
				//新工作流，订单编号
				busino = oi.getBusino();
				if (resultMap.containsKey(busino)) {
					//注意：匹配到数据 隐藏待办列表数据  如果数据库删除该条
					oldIterator.remove();
					//将匹配到的订单编号 在监控表暂时隐藏
					resultMap.remove(busino);
				}
	        }
			//合并新老工作流
			listAll.addAll(oldlist);
			
			//将其他map中没有匹配到的数据  监控表移除
			Iterator<Entry<String, WorkflowLevelMonitorEntity>> iter = resultMap.entrySet().iterator();
			while (iter.hasNext()) {
//				Map.Entry entry = (Map.Entry) iter.next();
				Entry<String, WorkflowLevelMonitorEntity> entry = iter.next();
				String workflowName = entry.getKey();
//				Object val = entry.getValue();
				//删除等级监控表 未匹配到的数据
				monitordao.deleteLevelMonitor(workflowName);
			}
				
			long endTime4 = System.currentTimeMillis();    //获取结束时间
			logger.info("待办列表匹配监控表（老工作流方法） - 程序运行时间  - 后台：" + (endTime4 - startTime4) + "ms");
//			System.out.println("待办列表匹配监控表（老工作流方法） - 程序运行时间  - 后台：" + (endTime4 - startTime4) + "ms");
			
			//合并新老工作流
//			listAll.addAll(newlist);
//			listAll.addAll(oldlist);
			//按创建时间排序
			listSort(listAll);
			
			// data
			result.setData(listAll);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			//日志
			logger.error("------获取工作流待办列表失败1-----" + e);
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO + "获取工作流待办列表失败" + e);
			//日志
			logger.error("------工作流待办列表异常-----"+e + "  工号" + userId);
		}
		//返回前端
		writeToPage(result);
	}
	
	/**
	 * 新工作流+老工作流待办列表——for首页，放最新三条展示
	 */
	public void workflowListAllforhp(){
		//跨域处理
		solveCrossDomain();
		//结果 集
		Result<List<Object>> result = new Result<List<Object>>();
		//新工作流列表
		List<WorkflowListEntity> newlist = new ArrayList<WorkflowListEntity>();
		//老工作流列表
		WorkItemsDto dto = new WorkItemsDto();
		//判断工号的规范性
		if(ParamUtils.checkUserId(userId)){
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			writeToPage(result);
			return;
		}
		dto.setUserId(userId);
		List<OaWorkItem> oldlist = new ArrayList<OaWorkItem>();
		List<Object> listAll = new ArrayList<Object>();
		try { 
			//获取新工作流
			newlist = weaverService.workflowList(userId,"", StringEscapeUtils.escapeSql(pageNo));
			//取最新三条
			List<WorkflowListEntity> threeNew = new ArrayList<WorkflowListEntity>();
			if(newlist != null && newlist.size() > 3){
				threeNew = newlist.subList(0, 3);
			}else{
				threeNew = newlist;
			}
			//添加状态(新)
			for(WorkflowListEntity workflowList : threeNew){
				workflowList.setStatus("new");
			}
			
			//获取老工作流
			oldlist = workItemsListService.workitemslist1(dto);
			//取最新三条
			List<OaWorkItem> threeOld = new ArrayList<OaWorkItem>();
			if(oldlist != null && oldlist.size() > 3){
				//threeOld = oldlist.subList(0, 3);
				for (int i = 1;i <= 3 ;i++){
					threeOld.add(oldlist.get(oldlist.size()-i));
				}
			}else{
				threeOld = oldlist;
			}
			//添加状态(老)
			for(OaWorkItem oaWorkItem : threeOld){
				oaWorkItem.setStatus("old");
			}
			
			//合并新老工作流
			listAll.addAll(threeNew);
			listAll.addAll(threeOld);
			
			//按创建时间排序
			listSort(listAll);
            //取前三条
			List<Object> threeAll = new ArrayList<Object>();
			if(listAll != null && listAll.size() > 3){
				threeAll = listAll.subList(0, 3);
			}else{
				threeAll = listAll;
			}
			// data
			result.setData(threeAll);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			//日志
			logger.error("------获取工作流待办列表失败11-----" + e);
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO + "获取工作流待办列表失败" + e);
		}
		//返回前端
		writeToPage(result);
		return;
	}
	
	//新老工作流列表按创建时间排序
	public static void listSort(List<Object> list){
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
						/*System.out.println("xin");*/
						dt1 = format.parse(((WorkflowListEntity)o1).getRequestInfo().getCreateTime());
					}else{
						//老工作流，Date类型
						/*System.out.println("lao");*/
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
	public void workflowInfo () {
		//跨域处理                                
		solveCrossDomain();
		long startTime = System.currentTimeMillis();    //获取开始时间
		long endTime = 0;
		long startTime1 = 0;    //获取开始时间
		long endTime1 = 0;    //获取结束时间
		Result<WorkflowListEntity> result = new Result<WorkflowListEntity>();
		weaver.workflow.webservices.WorkflowRequestInfo resultInfo = new weaver.workflow.webservices.WorkflowRequestInfo();
		WorkflowListEntity workflow = new WorkflowListEntity();
		//判断工号的规范性
		if(ParamUtils.checkUserId(userId)){
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			writeToPage(result);
			return;
		}
		String joblevel = employeeService.getJoblevel(userId);
		String errorInfo = "";
		try {
			startTime1 = System.currentTimeMillis();    //获取开始时间
			resultInfo = weaverService.workflowInfo(userId, requestId);
			requestIds = requestId;
			workFlowId = resultInfo.getWorkflowBaseInfo().getWorkflowId();
			workFlowName = resultInfo.getWorkflowBaseInfo().getWorkflowName();
        	empcode = userId;
			endTime1 = System.currentTimeMillis();    //获取结束时间
			logger.info("工作流详情（方法） - 程序运行时间  - 后台：" + (endTime1 - startTime1) + "ms");
			logger.info("");
			//拼接实体，获取头像地址
			if(resultInfo != null){
				workflow.setRequestInfo(resultInfo);
				workflow = weaverService.getInfoHeadpictures(workflow);
			}
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
			
			endTime = System.currentTimeMillis();    //获取结束时间
			logger.info("工作流详情（总时间） - 程序运行时间  - 后台：" + (endTime - startTime) + "ms");
			logger.info("");
		} catch (Exception e) {
			//日志
			logger.error("------获取工作流详情-----"+e);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			//异常信息
			errorInfo = e.toString() + "   e.getMessage() = " + e.getMessage();
			System.out.println(errorInfo);
		}finally{
			//异常监控 band10以上
			if(joblevel != null && joblevel.equals("C") || joblevel != null &&joblevel.equals("D") 
					|| joblevel != null &&joblevel.equals("10")){
				WorkflowMonitorEntity wm = new WorkflowMonitorEntity();
				int isSuccess = 0;
				if(result.getErrorCode() == 0){
					isSuccess = 1;
				}
				wm.setEmpCode(userId);
				wm.setWorkflowId(requestId);
				wm.setJobLevel(joblevel);
				wm.setIsSuccess(isSuccess);
				wm.setErrorInfo(errorInfo);
				wm.setMethodtimeCops((endTime1 - startTime1) + "ms");
				wm.setMethodtimeTotal((endTime - startTime) + "ms");
				wm.setInterfaceName("workflowInfo" + "-" + "工作流详情");
				if(resultInfo != null){
					wm.setResultLength(1);
				}else{
					wm.setResultLength(0);
				}			
				weaverService.insertMonitor(wm);
			}
		}
		// count
		if(resultInfo != null){
			result.setCount(1);
		}else{
			result.setCount(0);
		}
		// data
		result.setData(workflow);
		// 返回
		writeToPage(result);
	}
	
	// 提交
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
			//判断工号的规范性
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
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
	public void disAgree() {
		//解决H5跨域
		solveCrossDomain();
		//结果集
		Result<String> result = new Result<String>();
		String resultString = "";
		try {
			//判断工号的规范性
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
			resultString = weaverService.workflowtUnagree(userId, requestId,workflowName,sysCode,version);
			if(resultString.equals("success") || resultString == "success"){
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				// errorMessage
				result.setErrorMessage(Constants.ACTIVE_YES);
				//日志
				logger.info("------调用工作流不同意接口成功：工号:"+userId + " reason:" + resultString);
			}else{
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage(Constants.ACTIVE_NO);
				//日志
				logger.error("------调用工作流不同意接口失败：工号:"+userId + " reason:" + resultString);
			}
			
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
	
	//审批意见接口 【只用于电子签章申请 工作流 不同意】
	public void approvalopinion() throws Exception {
		//我要获取当前的日期
		Date begindate = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createDate = sdf.format(begindate);
        long startTime = System.currentTimeMillis();    //获取开始时间
		long endTime = 0;
		long resultTime = 0;
		
		//解决H5跨域
		solveCrossDomain();
		//结果集
		Result<String> result = new Result<String>();
		String resultString = "";
		
		try {
			//判断工号的规范性
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
			startTime = System.currentTimeMillis();    //获取开始时间
			resultString = approvalopinionService.approvalopinion(remark, String.valueOf(requestId));
			endTime = System.currentTimeMillis();    //获取结束时间
			
			if(resultString.equals("success") || resultString == "success"){
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				// errorMessage
				result.setErrorMessage(Constants.ACTIVE_YES);
				//日志
				logger.info("------电子签章工作流不同意接口成功：工号:"+userId + " reason:" + resultString);
			}else{
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage(Constants.ACTIVE_NO);
				//日志
				logger.error("------电子签章工作流不同意接口失败：工号:"+userId + " reason:" + resultString);
			}
			
			//count
			result.setCount(1);
			//data
			result.setData(resultString);
			//返回前端
			writeToPage(result);
			
			resultTime = endTime - startTime;
			logger.info("电子签章不同意接口（总时间） - 程序运行时间  - 后台：" + resultTime + "ms");
			
		} catch (Exception e) {
			//日志
			logger.error("------电子签章工作流不同意接口失败：工号:"+userId + " reason:" + e);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}finally{
			
			//审批监控
			String jobLevel = employeeService.getJoblevel(userId);
			
			//封装实体数据
			WorkflowBaseInfo baseInfo = new WorkflowBaseInfo();
			baseInfo.setWorkflowId("");
			baseInfo.setWorkflowName(workflowName);
			baseInfo.setWorkflowTypeName(sysCode);
			//封装实体数据
			WorkflowRequestInfo requestInfo = new WorkflowRequestInfo();
			requestInfo.setRequestId(String.valueOf(requestId));
			requestInfo.setCreateTime(createDate);
			//errorInfo
			requestInfo.setRemark(resultString);
			requestInfo.setSubmitButtonName("不同意");
			requestInfo.setUserid(userId);
			requestInfo.setWorkflowBaseInfo(baseInfo);
			//审批意见   前端没有传这个参数
			requestInfo.setMessageType("");
			//这个回退节点字段 暂存新老工作流 状态
			requestInfo.setRejectButtonName("new");
			//暂存接口名称
			requestInfo.setRequestName("approvalopinion");
			//暂存 调oa系统返回时长字段
			requestInfo.setReceiveTime(String.valueOf(resultTime));
			//暂存 版本号
			requestInfo.setForwardButtonName(version);
			monitordao.insertApprovalNewMonitor(userId,jobLevel,requestInfo,resultString,resultString,"0");
			
			
			//拼装实体
			WorkflowMonitorEntity wmEntity = new WorkflowMonitorEntity();
			//拼装实体
			wmEntity.setEmpCode(userId);
			wmEntity.setJobLevel(jobLevel);
			wmEntity.setWorkflowId(requestId);
			wmEntity.setWorkflowName(workflowName);
			wmEntity.setSysCode(sysCode);
			wmEntity.setApprovalOption("不同意");
			if(!"".equals(version) && version != null){
				//暂存版本号
				wmEntity.setRejectNode(version);
			}else{
				wmEntity.setRejectNode("");
			}
			if(result != null){
				wmEntity.setResult(resultString);
				if(resultString.equals("success")){
					wmEntity.setIsSuccess(1);
				}
			}
			wmEntity.setInterfaceName("approvalopinion");
			monitordao.insertUApprovalMonitor(wmEntity);
		}
	}

	/**
	 * 工作流附件列表接口
	 */
	public void attachmentInfo() {
		//跨域处理
		solveCrossDomain();
		Result<List<WeaverAttachments>> result = new Result<List<WeaverAttachments>>();
		List<WeaverAttachments> docInfos = new ArrayList<WeaverAttachments>();
		try {
			//判断工号的规范性
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
			//是不是文件发布申请 附件列表
			if(htmlpath.equals("workflow_coreFilePublish")){
				logger.info("dwfs workflow file param is :  requestid=" + requestid + " htmlpath=" + htmlpath );
		        if(StringUtil.isEmpty(requestid) || StringUtil.isEmpty(htmlpath)){
		            logger.info("请求参数为空,查询列表失败！");
		        }else{
		        	//formtable_main_1083
		        	String attachmentLists = attachmentList+"requestId="+requestid+attList;
	        		logger.info("oa attachment list http："+attachmentLists);
	        		//文件发布申请工作流 附件列表
	        		String json = RestfulUtil.restfulWork(attachmentLists, this.requestid, this.htmlpath, "dwfs");
	        		
	        		JSONObject obj = JSONObject.parseObject(json);
	        		logger.info("oa返回数据json结果："+obj.get("success"));
	        		List<Map<String, Object>> data = (List<Map<String, Object>>) obj.get("data");
	        		logger.info("oa返回数据 data："+data);
	        		if("".equals(data) || data == null || StringUtil.isEmpty(data.toString()) ){
	        			logger.info("oa返回数据 data 为空："+data);
	        			// count
	        			result.setCount(0);
	        			// errorCode
	        			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
	        			// errorMessage
	        			result.setErrorMessage(Constants.ACTIVE_NO);
	        		}else{
	        			for (Map<String, Object> map : data) {
			    			WeaverAttachments wa = new WeaverAttachments();
							int docid = (Integer)map.get("FILEID");
							String filename = (String)map.get("FILENAME");
//							String filepath = (String)map.get("FILEPATH");
							wa.setDocid(docid);
							wa.setFilename(filename);
//							wa.setFilepath(filepath);
							docInfos.add(wa);
						}
	        		}
		        }
		        // errorCode
		        result.setErrorCode(Constants.ACTION_RESULT_SUC);
				// errorMessage
				result.setErrorMessage(Constants.ACTIVE_YES);
			}else{
				/**
    			 * 参数含义： 参数1：fieldValue 此参数在详情里
    			 */
    			//*******fieldValue要加非空判断在转换
    			String[] file = fieldValue.split(",");
    			logger.info("oa back file message start：");
    			for (String ss : file) {
    				logger.info("oa back attachments message userId："+userId);
    				weaver.docs.webservices.DocInfo info = workflowAttachment.getDocNew(Integer.parseInt(ss), userId);
    				//需要判断info返回空的逻辑  不然会抛空指针异常
//    				if(!"".equals(info) || info != null){
    				WeaverAttachments att = weaverService.valueToEntity(info);
    				logger.info("oa back attachments docId："+att.getDocid()+"----print attachment fileName:"+att.getFilename());
    				docInfos.add(att);
//    				}else{
//    					logger.info("oa back attachments info is null："+info.getVersionId());
//    				}
    			}
    			// errorCode
    			result.setErrorCode(Constants.ACTION_RESULT_SUC);
    			// errorMessage
    			result.setErrorMessage(Constants.ACTIVE_YES);
			}
			
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
	public void openAttachmentInfo() {
		//解决H5跨域
		solveCrossDomain();
		//解决H5跨域
		HttpServletResponse response = ServletActionContext.getResponse();
		weaver.docs.webservices.DocInfo docInfo = new weaver.docs.webservices.DocInfo();
		try {
			//判断工号的规范性
			if(ParamUtils.checkUserId(userId)){
				// errorMessage
				logger.info("工号错误，不符合规范");
			}
			/**
			 * 参数含义： 参数1：fieldValue 此参数在详情里 
			 */
			if(htmlpath.equals("workflow_coreFilePublish") || htmlpath.equals("zonStAtResolve")){
				if(StringUtil.isEmpty(deviceType) || StringUtil.isEmpty(fileName) || StringUtil.isEmpty(userId)){
		            logger.info("请求参数为空,附件下载失败！");
		        }else{
		        	fileDocId = fieldValue; 
		        	String openAttachment = openAttachments+"fileDocId="+fieldValue;
					logger.info("oa download attachment http："+openAttachment);
					dealAttachments(userId,openAttachment,fileName,deviceType,response);
		        }
			}else{
				creatorid = creatorId;
				fileDocId = fieldValue; 
				docInfo = workflowAttachment.getDocNew(Integer.parseInt(fieldValue),creatorId);
				logger.info("open attachments message docInfo："+docInfo.getAttachments());
				dealAttachments(docInfo);
				return;
			}
		} catch (Exception e) {

			logger.error("工作流附件接口异常："+e);
		}

	}
	/**
	 * 文件发布申请附件下载
	 * @param userId
	 * @param filePath
	 * @param fileName
	 * @param syscode
	 * @param response
	 * @throws Exception 
	 */
	public void dealAttachments(String userId, String filePath, String fileName, String deviceType, HttpServletResponse response) throws Exception {
		//我要获取当前的日期
		Date begindate = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createDate = sdf.format(begindate);
        long startTime = System.currentTimeMillis();    //获取开始时间
		long endTime = 0;
		long resultTime = 0;
		//构造url
        URL url = new URL(filePath);
        try {
        	//要保存的路径  测试环境 及 生产环境 要先在本地建一个workflowFile文件夹，没有权限自动创建
    		String path = "/dpmfile/emailattachment/";
    		//保存文件到本地路径
    		File file = new File(path + fileName);
    		//打开连接
            URLConnection con = url.openConnection();
            //输入流
            InputStream is = con.getInputStream();
			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流
			OutputStream os = new FileOutputStream(file);
			// 开始读取
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			// 完毕，关闭所有链接
			os.close();
			is.close();
			startTime = System.currentTimeMillis();    //获取开始时间
            //调用解密 方法
            //weaverService.decryptFile(userId, deviceType, fileName, file);
            DecryptNewFile.delFile(userId,deviceType,fileName,file);
            endTime = System.currentTimeMillis();    //获取结束时间	
            resultTime = endTime - startTime;
    		logger.info("文件发布申请附件解密（总时间） - 程序运行时间  - 后台：" + resultTime + "ms");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	//审批人 等级
        	joblevel = employeeService.getJoblevel(userId);
        	if(userId != "" && userId.equals(empcode) || empcode != "" && empcode.equals(userId)){
        		//封装实体数据
				WorkflowBaseInfo baseInfo = new WorkflowBaseInfo();
				baseInfo.setWorkflowId(workFlowId);
				baseInfo.setWorkflowName(workFlowName);
				baseInfo.setWorkflowTypeName("新工作流(文件发布申请)-附件");
	        	WorkflowRequestInfo requestInfo = new WorkflowRequestInfo();
	        	requestInfo.setUserid(userId);
	        	//只有新工作流附件才存在fileDocId
	        	requestInfo.setCreatorId("");
	        	requestInfo.setCurrentNodeName(fileName);
	        	requestInfo.setLastOperatorName(filePath);
	        	requestInfo.setNodename(deviceType);
	        	requestInfo.setType(String.valueOf(1));
	        	requestInfo.setCreateTime(createDate);
	        	requestInfo.setWorkflowBaseInfo(baseInfo);
				requestInfo.setRequestId(String.valueOf(requestIds));
				requestInfo.setRemark("");
				requestInfo.setSubmitButtonName("");
				//暂存附件的docId
				requestInfo.setCurrentNodeId(fileDocId);
				requestInfo.setMessageType("");
				//这个回退节点字段 暂存新老工作流 状态
				requestInfo.setRejectButtonName("new");
				//暂存接口名称
				requestInfo.setRequestName("dealAttachments(文件发布申请)");
				//暂存 调lsp系统返回时长字段
				requestInfo.setReceiveTime(String.valueOf(resultTime));
	        	monitordao.insertApprovalNewMonitor(userId,joblevel,requestInfo,"success","","1");
            }
        }
    }
	
	/**
	 * 把string写成文件保存起来
	 * @param doc
	 * @throws Exception 
	 */
	@SuppressWarnings("all")
	private void dealAttachments(DocInfo doc) throws Exception {
		logger.info("开始创建workflowFile文件夹");
		//我要获取当前的日期
		Date begindate = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createDate = sdf.format(begindate);
        long startTime = 0;    //获取开始时间
		long endTime = 0;
		long resultTime = 0;
		DocAttachment[] attachements = doc.getAttachments();
		String filename = "";
		String filePath = "";
		//审批人 等级
    	joblevel = employeeService.getJoblevel(userId);
		//要保存的路径  此地要先在本地建一个workflowFile文件夹
		String path = "/dpmfile/emailattachment/";
		
		try {
			for (DocAttachment docAttachment : attachements) {
				ServletOutputStream out = null;
				InputStream in = null;
				// 文件名
				logger.info("开始将文件写入workflowFile");
				filename = docAttachment.getFilename();
				filePath = docAttachment.getFilerealpath();
//				System.out.println(filePath);
				// 保存文件到本地路径
				File file = new File(path + filename);
				logger.info("download attachments message file："+file);
				//获取文件内容
				String filecontent = docAttachment.getFilecontent();
				logger.info("download attachments message filecontent length："+filecontent.length() + "---字符："+filecontent.substring(0, 32));
				byte[] bytes = Base64.decodeBase64(filecontent);
				FileUtils.writeByteArrayToFile(file, bytes);
				logger.info("件写入workflowFile完毕" + bytes.length);
//				FileOutputStream out = new FileOutputStream(file);
//				out.write(bytes);
//				out.close();
				if(!file.exists()){
					// 附件不存在
					logger.info("写入workflowFile之后判断有没有写成功 40006");
					writeToPage("40006");
					return;
				}
				startTime = System.currentTimeMillis();    //获取开始时间
				//weaverService.decryptFile(userId, deviceType, filename, file);
				DecryptNewFile.delFile(userId,deviceType,filename,file);
				endTime = System.currentTimeMillis();    //获取结束时间	
			    resultTime = endTime - startTime;
				logger.info("新工作流附件解密（总时间） - 程序运行时间  - 后台：" + resultTime + "ms");
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(userId != "" && userId.equals(empcode) || empcode != "" && empcode.equals(userId)){
	    		//封装实体数据
				WorkflowBaseInfo baseInfo = new WorkflowBaseInfo();
				baseInfo.setWorkflowId(workFlowId);
				baseInfo.setWorkflowName(workFlowName);
				baseInfo.setWorkflowTypeName("新工作流-附件");
	        	WorkflowRequestInfo requestInfo = new WorkflowRequestInfo();
	        	requestInfo.setUserid(userId);
	        	//只有新工作流附件才存在fileDocId
	        	requestInfo.setCreatorId(creatorid);
	        	requestInfo.setCurrentNodeName(filename);
	        	requestInfo.setLastOperatorName(filePath);
	        	requestInfo.setNodename(deviceType);
	        	requestInfo.setType(String.valueOf(1));
	        	requestInfo.setCreateTime(createDate);
	        	requestInfo.setWorkflowBaseInfo(baseInfo);
				requestInfo.setRequestId(String.valueOf(requestIds));
				requestInfo.setRemark("");
				requestInfo.setSubmitButtonName("");
				requestInfo.setMessageType("");
				//暂存附件的docId
				requestInfo.setCurrentNodeId(fileDocId);
				//这个回退节点字段 暂存新老工作流 状态
				requestInfo.setRejectButtonName("new");
				//暂存接口名称
				requestInfo.setRequestName("dealAttachments(新工作流附件)");
				//暂存 调lsp系统返回时长字段
				requestInfo.setReceiveTime(String.valueOf(resultTime));
	        	monitordao.insertApprovalNewMonitor(userId,joblevel,requestInfo,"success","","1");
	        }
		}
	}

	/**
	 * 自由回退节点
	 * @throws Exception 
	 */
	@CookieNotCheckedRequired
	public void freedReject() throws Exception {
		//解决H5跨域
		solveCrossDomain();
		// result
		Result<String> result = new Result<String>();
		// 请求结果
		String resultStr = "";
		String errorInfo = "";
		String resultString = "";
		//我要获取当前的日期
		Date begindate = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//获取String类型的时间
        String createDate = sdf.format(begindate);
        long startTime = System.currentTimeMillis();    //获取开始时间
		long endTime = 0;
		long resultTime = 0;
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
			//判断工号的规范性
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
			logger.error("---调用工作流退回接口参数：工号:"+userId + ", requestId:" + requestId + ", version:" + version + ", nodeId:" + nodeId);
			String requestid = String.valueOf(requestId);
			//校验工作流号 必须为纯数字
			java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("[0-9]*");
	        java.util.regex.Matcher match=pattern.matcher(requestid);
			if(match.matches()){
				startTime = System.currentTimeMillis();    //获取开始时间
				resultStr = workflowService.freedRejectRequest(requestId, userId, nodeId,"");
				endTime = System.currentTimeMillis();    //获取结束时间
				if(resultStr.equals("success") || resultStr == "success"){
					resultString = "success";
					errorInfo = "退回返回结果：" + resultStr;
					// errorCode
					result.setErrorCode(Constants.ACTION_RESULT_SUC);
					// errorMessage
					result.setErrorMessage(Constants.ACTIVE_YES);
					//日志
					logger.error("------调用工作流退回接口成功：工号:"+userId + " reason:" + resultStr);
				}else{
					resultString = "error";
					errorInfo = "退回返回结果：" + resultStr;
					// errorCode
					result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					// errorMessage
					result.setErrorMessage(Constants.ACTIVE_NO);
					//日志
					logger.error("------调用工作流退回接口失败：工号:"+userId + " reason:" + resultStr);
				}
			}
			resultTime = endTime - startTime;
			logger.info("工作流详情（总时间） - 程序运行时间  - 后台：" + resultTime + "ms");
		} catch (Exception e) {
			resultString = "error";
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			// 日志
			logger.error("工作流退回异常："+e);
			//异常信息
			errorInfo = e.toString() + "   e.getMessage() = " + e.getMessage();
		}finally{
			//审批监控
			String jobLevel = employeeService.getJoblevel(userId);
			/**
			 * 新加 监控信息表
			 */
			//封装实体数据
			WorkflowBaseInfo baseInfo = new WorkflowBaseInfo();
			baseInfo.setWorkflowId("");
			baseInfo.setWorkflowName(workflowName);
			baseInfo.setWorkflowTypeName(sysCode);
			//封装实体数据
			WorkflowRequestInfo requestInfo = new WorkflowRequestInfo();
			requestInfo.setRequestId(String.valueOf(requestId));
			requestInfo.setCreateTime(createDate);
			//errorInfo信息
			requestInfo.setRemark(errorInfo);
			requestInfo.setSubmitButtonName("退回");
			requestInfo.setUserid(userId);
			requestInfo.setWorkflowBaseInfo(baseInfo);
			//审批意见   前端没有传这个参数
			requestInfo.setMessageType("");
			//这个回退节点字段 暂存新老工作流 状态
			requestInfo.setRejectButtonName("new");
			//暂存接口名称
			requestInfo.setRequestName("freedReject");
			//暂存 调lsp系统返回时长字段
			requestInfo.setReceiveTime(String.valueOf(resultTime));
			//暂存 版本号
			requestInfo.setForwardButtonName(version);
			monitordao.insertApprovalNewMonitor(userId,jobLevel,requestInfo,resultString,resultStr,"0");
			
			/**
			 * 原始监控信息表
			 */
			//拼装实体
			WorkflowMonitorEntity wmEntity = new WorkflowMonitorEntity();
			//拼装实体
			wmEntity.setEmpCode(userId);
			wmEntity.setJobLevel(jobLevel);
			wmEntity.setWorkflowId(requestId);
			wmEntity.setWorkflowName(workflowName);
			wmEntity.setSysCode(sysCode);
			wmEntity.setApprovalOption("退回");
			if(!"".equals(version) && version != null){
				//暂存 版本号
				wmEntity.setRejectNode(version);
			}else{
				wmEntity.setRejectNode("");
			}
			if(resultStr != null){
				wmEntity.setResult(resultStr);
				if(resultStr.equals("success")){
					wmEntity.setIsSuccess(1);
				}
			}
			wmEntity.setErrorInfo(errorInfo);
			wmEntity.setInterfaceName("freedRejectRequest");
			//int monitor = weaverService.insertApprovalMonitor(wmEntity);
			 weaverService.insertApprovalMonitor(wmEntity);
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
			//判断工号的规范性
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
			String requestid = String.valueOf(requestId);
			java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("[0-9]*");
	        java.util.regex.Matcher m1=pattern.matcher(requestid);
	        java.util.regex.Matcher m2=pattern.matcher(workflowId);
	        String workFlowId = StringEscapeUtils.escapeSql(workflowId);
	        if(m1.matches() || m2.matches()){
	        	resultStr = workflowService.getRejectNode(requestId, Integer.parseInt(workFlowId), userId);
	        	// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				// errorMessage
				result.setErrorMessage(Constants.ACTIVE_YES);
	        }else{
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage(Constants.ACTIVE_NO);
				logger.error("工作流获取回退节点号异常,requestId："+requestId + "--workFlowId:"+workFlowId);
	        }
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
	 * 老版工作流 调用  没有分页功能
	 * 我的已办流程列表：getMyWorkflowRequestList  自己起草的审批完成的（没批的）
	 * 进行中--我提交的      已完成--我提交
	 */
	public void myWorkflowList() {
		//解决H5跨域
		solveCrossDomain();
		//结果 集
		Result<List<WorkflowListEntity>> result = new Result<List<WorkflowListEntity>>();
		List<WorkflowListEntity> listData = new ArrayList<WorkflowListEntity>(); 
		try {
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
	        //获取我提交的列表数据
			listData = weaverService.myWorkflowList(userId, StringEscapeUtils.escapeSql(workflowStatus), StringEscapeUtils.escapeSql(pageNo));
			
			//获取头像地址
			listData = weaverService.getListHeadpictures(listData);
			// errorCodeworkflowStatus哦
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
	 * 新版工作流 调用改接口 分页--每页显示20条
	 * 我的已办流程列表：getMyWorkflowRequestList  自己起草的审批完成的（没批的）
	 * 进行中--我提交的      已完成--我提交
	 */
	public void myWorkflowPageList() {
		//解决H5跨域
		solveCrossDomain();
		//结果 集
		Result<List<WorkflowListEntity>> result = new Result<List<WorkflowListEntity>>();
		List<WorkflowListEntity> listData = new ArrayList<WorkflowListEntity>(); 
		try {
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
	        //获取我提交的列表数据
			listData = weaverService.myWorkflowPageList(userId, StringEscapeUtils.escapeSql(workflowStatus), StringEscapeUtils.escapeSql(pageNo));
			
			//获取头像地址
			listData = weaverService.getListHeadpictures(listData);
			// errorCodeworkflowStatus哦
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
	 *  已完成--我审批
	 *  没有分页功能 ==== 默认显示200条
	 */
	public void getHendledWorkflowList(){	
		//解决H5跨域
		solveCrossDomain();
		//结果 集
		Result<List<WorkflowListEntity>> result = new Result<List<WorkflowListEntity>>();
		List<WorkflowListEntity> listData = new ArrayList<WorkflowListEntity>(); 
		try {
			//判断工号的规范性
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
        	//由于后业规则改动 此方法第三个参数无需传入 
			listData = weaverService.getHendledWorkflowList(userId,StringEscapeUtils.escapeSql(pageNo),"");
			//获取头像地址
			listData = weaverService.getListHeadpictures(listData);
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
	
	/**
	 * 我的已办理流程列表
	 *  已完成--我审批
	 *  分页功能==每页显示20条
	 */
	public void getHendledWorkflowPageList(){	
		//解决H5跨域
		solveCrossDomain();
		//结果 集
		Result<List<WorkflowListEntity>> result = new Result<List<WorkflowListEntity>>();
		List<WorkflowListEntity> listData = new ArrayList<WorkflowListEntity>(); 
		try {
			//判断工号的规范性
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
        	//由于后业规则改动 此方法第三个参数无需传入 
			listData = weaverService.getHendledWorkflowPageList(userId,StringEscapeUtils.escapeSql(pageNo),"");
			//获取头像地址
			listData = weaverService.getListHeadpictures(listData);
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
				//判断工号的规范性
				if(ParamUtils.checkUserId(userId)){
					result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					// errorMessage
					result.setErrorMessage("工号错误，不符合规范");
					writeToPage(result);
					return;
				}
				//将前端传来的json转为实体类
				entity = JSONObject.parseObject(str,
						NwfsSearchVo.class);
				//验证日期是yyyy-MM-dd HH:mm:ss支持闰年的正则表达式
				/*Pattern pattern = Pattern.compile("((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s((([0-1][0-9])|(2?[0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))");
				Matcher matcherS = pattern.matcher(entity.getStartTime());
				Matcher matcherE = pattern.matcher(entity.getEndTime());*/
				if(entity.getPageNo() != null && !entity.getPageNo().equals("") 
						|| isLeapYear(entity.getStartTime()) || isLeapYear(entity.getEndTime()) 
						|| entity.getSysCode() != null && !entity.getSysCode().equals("") ){
					requestInfos = weaverService.workflowSearch(userId, entity);
				}
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
	
	/*
	 * validate date time string and the year is leap year or not*/
	private static boolean isLeapYear(String dateStr){
		if(dateStr == null)
			return false;
		boolean isRegx = dateStr.matches("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?"
				+ "((((0?[13578])|(1[02]))[\\-\\/\\s]?"
				+ "((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?"
				+ "((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?"
				+ "((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?"
				+ "((((0?[13578])|(1[02]))[\\-\\/\\s]?"
				+ "((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?"
				+ "((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?"
				+ "((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s((([0-1][0-9])|(2?[0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))$");
		if(!isRegx){
			return false;
		}
		int year = Integer.valueOf(dateStr.substring(0, 4));
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
			return true;
		}else{
			return false;
		}
	}
	
	//搜索框搜索
	public void textSearch(){
		//解决H5跨域
		solveCrossDomain();
		//结果集
		Result<List<WorkflowListEntity>> result = new Result<List<WorkflowListEntity>>();
		List<WorkflowListEntity> requestInfos = new ArrayList<WorkflowListEntity>();
		try {
			//判断工号的规范性
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
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
	public void workflowDelete(){
		solveCrossDomain();
		//结果集
		Result<String> result = new Result<String>();
		String deleteResult = "";
		try {
			//判断工号的规范性
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
			//防止漏洞 刷新详情获取id值 匹配到才可以删除对应的工作流
			if(requestIds==requestId){
				if (weaverService.workflowDelete(userId, requestId)) {
					deleteResult = "true";
				} else {
					deleteResult = "false";
				}
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				// errorMessage
				result.setErrorMessage(Constants.ACTIVE_YES);
			}else{
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage(Constants.ACTIVE_NO);
			}
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
	public void workflowRevoke(){
		solveCrossDomain();
		//结果集
		Result<String> result = new Result<String>();
		String revokeResult = "";
		try {
			//判断工号的规范性
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
			//防止漏洞  刷新详情获取id值 匹配到才可以撤销对应的工作流
			if(requestIds==requestId){
				if (weaverService.workflowRevoke(requestId, userId)) {
					revokeResult = "true";
				} else {
					revokeResult = "false";
				}
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				// errorMessage
				result.setErrorMessage(Constants.ACTIVE_YES);
			}else{
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage(Constants.ACTIVE_NO);
			}
			
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
	 * 新增一条工作流
	 */
	public void insertNWorkflow(){
		Result<Integer> result = new Result<Integer>();
		int res = 0;
		try {
			//校验工作流号  判断规则  1、 包含字母和数字  仅数字也可以
			Pattern pattern = Pattern.compile("^[a-z0-9A-Z]+$");
			Matcher matcher = pattern.matcher(workflowId);
			if(matcher.matches()){
				// 参数是否正确
				res = weaverService.insertNWorkflow(workflowId, workflowName,workflowPage);
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				// errorMessage
				result.setErrorMessage(Constants.ACTIVE_YES);
			}
		} catch (Exception e) {
			// TODO: handle exception
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		//data 
		result.setData(res);
		// 返回给前端
		writeToPage(result);
	}
	
	/**
	 * 更改一条工作流状态
	 */
	public void updateNWorkflowStatus(){
		Result<Integer> result = new Result<Integer>();
		int res = 0;
		try {
			res = weaverService.updateNWorkflowStatus(workflowId, workflowStatus);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// TODO: handle exception
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		//data 
		result.setData(res);
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

	public IQueryEmployeeInfoService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(IQueryEmployeeInfoService employeeService) {
		this.employeeService = employeeService;
	}
	
	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public String getWorkflowPage() {
		return workflowPage;
	}

	public void setWorkflowPage(String workflowPage) {
		this.workflowPage = workflowPage;
	}

	public String getWorkflowStatus() {
		return workflowStatus;
	}
	public String getSysCode() {
		return sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getFlowType() {
		return flowType;
	}

	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPageNo() {
		return pageNo;
	}

	public IMonitorDao getMonitordao() {
		return monitordao;
	}

	public void setMonitordao(IMonitorDao monitordao) {
		this.monitordao = monitordao;
	}

	public String getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(String attachmentList) {
		this.attachmentList = attachmentList;
	}

	public String getOpenAttachments() {
		return openAttachments;
	}

	public void setOpenAttachments(String openAttachments) {
		this.openAttachments = openAttachments;
	}

	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}

	public String getHtmlpath() {
		return htmlpath;
	}

	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public static int getRequestIds() {
		return requestIds;
	}

	public static void setRequestIds(int requestIds) {
		WeaverWfsAction.requestIds = requestIds;
	}

	public String getAttList() {
		return attList;
	}

	public void setAttList(String attList) {
		this.attList = attList;
	}

	public String getJoblevel() {
		return joblevel;
	}

	public void setJoblevel(String joblevel) {
		this.joblevel = joblevel;
	}

	public static String getWorkFlowId() {
		return workFlowId;
	}

	public static void setWorkFlowId(String workFlowId) {
		WeaverWfsAction.workFlowId = workFlowId;
	}

	public static String getEmpcode() {
		return empcode;
	}

	public static void setEmpcode(String empcode) {
		WeaverWfsAction.empcode = empcode;
	}

	public static String getWorkFlowName() {
		return workFlowName;
	}

	public static void setWorkFlowName(String workFlowName) {
		WeaverWfsAction.workFlowName = workFlowName;
	}

	public static String getCreatorid() {
		return creatorid;
	}

	public static void setCreatorid(String creatorid) {
		WeaverWfsAction.creatorid = creatorid;
	}

	public static String getFileDocId() {
		return fileDocId;
	}

	public static void setFileDocId(String fileDocId) {
		WeaverWfsAction.fileDocId = fileDocId;
	}

	public ApprovalopinionService getApprovalopinionService() {
		return approvalopinionService;
	}

	public void setApprovalopinionService(
			ApprovalopinionService approvalopinionService) {
		this.approvalopinionService = approvalopinionService;
	}

	public WorkflowService getWorkflowService() {
		return workflowService;
	}

	public void setWorkflowService(WorkflowService workflowService) {
		this.workflowService = workflowService;
	}
	
}
