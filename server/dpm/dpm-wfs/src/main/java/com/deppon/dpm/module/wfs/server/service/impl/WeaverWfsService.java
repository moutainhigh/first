package com.deppon.dpm.module.wfs.server.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletOutputStream;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import weaver.workflow.webservices.IWorkflowServiceDeppon;
import weaver.workflow.webservices.WorkflowBaseInfo;
import weaver.workflow.webservices.WorkflowRequestInfo;
import weaver.workflow.webservices.WorkflowService;
import cn.jpush.api.utils.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.server.util.ParamUtils;
import com.deppon.dpm.module.common.shared.define.DpmConstants;
import com.deppon.dpm.module.management.shared.domain.CalendarInfo;
import com.deppon.dpm.module.wfs.server.action.WeaverWfsAction;
import com.deppon.dpm.module.wfs.server.dao.IBandApproveDao;
import com.deppon.dpm.module.wfs.server.dao.IEmployeeInfoDao;
import com.deppon.dpm.module.wfs.server.dao.IMonitorDao;
import com.deppon.dpm.module.wfs.server.service.INwfsPicpathService;
import com.deppon.dpm.module.wfs.server.service.IQueryEmployeeInfoService;
import com.deppon.dpm.module.wfs.server.service.IWeaverWfsService;
import com.deppon.dpm.module.wfs.server.service.IWorkItemsListService;
import com.deppon.dpm.module.wfs.server.service.IWorkflowPageService;
import com.deppon.dpm.module.wfs.shared.domain.BandApproveEntity;
import com.deppon.dpm.module.wfs.shared.domain.EmployeeInfo;
import com.deppon.dpm.module.wfs.shared.domain.NWorkflowInfoEntity;
import com.deppon.dpm.module.wfs.shared.domain.NwfsPicPathEntity;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowListEntity;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowMonitorEntity;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowPageInfo;
import com.deppon.dpm.module.wfs.shared.dto.WorkItemsDto;
import com.deppon.dpm.module.wfs.shared.vo.NwfsSearchVo;
import com.deppon.dpm.module.wfs.shared.vo.OaWorkItem;
import com.deppon.dpm.module.wfs.shared.vo.WeaverAttachments;
import com.deppon.dpm.module.wfs.shared.vo.WeaverWorkflowInfo;
import com.deppon.dpm.module.wfs.util.Constants;
/**
 * service实现层
 * @author 276344
 *
 */
public class WeaverWfsService implements IWeaverWfsService {
	// 日志
	private static Logger logger  = LoggerFactory.getLogger(WeaverWfsAction.class);
	/**
	 * dlp附件解密url
	 */
	private String appInterfaceUrl;
	//工作流详情对应页面service
	private IWorkflowPageService pageService;
	//根据工号查员工信息
	private IQueryEmployeeInfoService employeeService;
	//监控日志
	private IMonitorDao monitordao;
	//人员信息
	private IEmployeeInfoDao employeeDao;

	private IBandApproveDao bandApproveDao;
	//dubbox 引入
	@Autowired
	public WorkflowService workflowService;
	@Autowired
	public IWorkflowServiceDeppon workflowSearch;
	//@Autowired
	//public IWorkflowServiceDeppon MWorkflowServiceDeppon;
	/**
	 * service
	 */
	private INwfsPicpathService picService;
	//头像路径
	private String webUrl;
	//老工作流
	private IWorkItemsListService workItemsListService;
	
	/**
	 * 查询B10表信息
	 */
	@Override
	public List<BandApproveEntity> queryBandApproveEntity() {
		// TODO Auto-generated method stub
		return bandApproveDao.queryBandApproveEntity();
	}
	/**
	 * 根据工作流号查等级
	 */
	@Override
	public String getJoblevelByworkFlowId(String workflowId) {
		// TODO Auto-generated method stub
		return bandApproveDao.getJoblevelByworkFlowId(workflowId);
	}


	//待办工作流
	@Override
	public List<WorkflowListEntity> workflowList(String userId, String status, String pageNo) throws RemoteException {
		//拼接结果集
		List<WorkflowListEntity> listData = new ArrayList<WorkflowListEntity>(); 
//		WorkflowServicePortTypeProxy workflow = new WorkflowServicePortTypeProxy();
		
		// 工号转ID
//		int codeToID = workflowService.getUserIdByWorkCode(userId);
		//判断工号的规范性
		if(ParamUtils.checkUserId(userId)){
			// errorMessage
			logger.info("工号错误，不符合规范");
		}
		//查询待办总数
		int totalCount = workflowService.getToDoWorkflowRequestCount(userId,  null);
		/**
		 * 从左到右五个参数每个参数含意quchu
		 * int pageNo              --当前页数
		 * int pageSize            -- 每页显示的代办数量
		 * int recordCount         --代办总数
		 * int userId              --用户工号
		 * String[] conditions     --查询流程的条件,为字符串数组
		 *  
		 */
		//校验页数 必须为纯数字
//		String regex = "^[0-9]*$";
//		Pattern p = Pattern.compile(regex); 
//		Matcher m = p.matcher(pageNo);
		String page = StringEscapeUtils.escapeSql(pageNo);
		//查询待办列表
//		WorkflowRequestInfo[] requestInfos = workflow.getToDoWorkflowRequestList(Integer.parseInt(pageNo), DpmConstants.workflowPageNumber, totalCount, codeToID, null);
		weaver.workflow.webservices.WorkflowRequestInfo[] requestInfos = 
				workflowService.getToDoWorkflowRequestList(Integer.parseInt(page), DpmConstants.workflowPageNumber, totalCount, userId, null);
		//工作流详情对应页面
		List<WorkflowPageInfo> pageInfoArray = pageService.pageInfomation();
		// 数据匹配处理
		listData = dealData(requestInfos, pageInfoArray);
		//获取工作流对应头像地址
		if(listData != null){
			for(WorkflowListEntity workflow : listData){
				List<String> createId = new ArrayList<String>();
				//起草人id转工号
				String empcode = workflowService.getWorkflowUserCode(workflow.getRequestInfo().getCreatorId());
				if(ParamUtils.checkUserId(empcode)){
					// errorMessage
					logger.info("工号错误，不符合规范");
				}
				//起草人工号
				createId.add(empcode);
				//获取该起草人头像地址
				List<NwfsPicPathEntity> entitys = new ArrayList<NwfsPicPathEntity>();
				entitys = picService.picturePaths(createId);
				//数据库中获取的是保存的图片名，要把结果拼接成服务器图片路径地址
				StringBuffer sb = new StringBuffer();
				sb.append(webUrl + "/");
				sb.append("headPhoto/");
				for(NwfsPicPathEntity pic : entitys){
					pic.setPicPath(sb + pic.getPicPath());
				}
				//存入工作流待办实体
				if(entitys.size() == 0){
					NwfsPicPathEntity picentity = new NwfsPicPathEntity();
					picentity.setEmpCode(empcode);
					picentity.setGender("");
					picentity.setPicPath("");
					entitys.add(picentity);
				}
				workflow.setPicPaths(entitys);
			}	
		}
		return listData;
	}
	
	//获取工作流列表对应头像地址
	@Override
	public List<WorkflowListEntity> getListHeadpictures(List<WorkflowListEntity> listData){
		if(listData != null){
			for(WorkflowListEntity workflow : listData){
				List<String> createId = new ArrayList<String>();
				//起草人id转工号
				String empcode = workflowService.getWorkflowUserCode(workflow.getRequestInfo().getCreatorId());
				if(ParamUtils.checkUserId(empcode)){
					// errorMessage
					logger.info("工号错误，不符合规范");
				}
				//起草人工号
				createId.add(empcode);
				//获取该起草人头像地址
				List<NwfsPicPathEntity> entitys = new ArrayList<NwfsPicPathEntity>();
				entitys = picService.picturePaths(createId);
				//数据库中获取的是保存的图片名，要把结果拼接成服务器图片路径地址
				StringBuffer sb = new StringBuffer();
				sb.append(webUrl + "/");
				sb.append("headPhoto/");
				for(NwfsPicPathEntity pic : entitys){
					pic.setPicPath(sb + pic.getPicPath());
				}
				//存入工作流待办实体
				if(entitys.size() == 0){
					NwfsPicPathEntity picentity = new NwfsPicPathEntity();
					picentity.setEmpCode(empcode);
					picentity.setGender("");
					picentity.setPicPath("");
					entitys.add(picentity);
				}
				workflow.setPicPaths(entitys);
			}	
		}
		return listData;
	}
	
	//获取工作流详情页的头像地址
	@Override
	public WorkflowListEntity getInfoHeadpictures(WorkflowListEntity workflow){
		List<String> createId = new ArrayList<String>();
		if(workflow != null){
			//起草人工号
			createId.add(workflow.getRequestInfo().getCreatorId());
			//添加已审批人工号
			for(int i=0;i<workflow.getRequestInfo().getWorkflowRequestLogs().length;i++){
				//审批人id转工号
				String operatorCode = workflowService.getWorkflowUserCode(workflow.getRequestInfo().getWorkflowRequestLogs()[i].getOperatorId());
				workflow.getRequestInfo().getWorkflowRequestLogs()[i].setOperatorId(operatorCode);
				if(!createId.contains(operatorCode)){
					createId.add(operatorCode);
				}
			}
			//添加下个审批人工号
			if(!createId.contains(workflow.getRequestInfo().getUserid())){
				createId.add(workflow.getRequestInfo().getUserid());
			}
			//获取该起草人头像地址
			List<NwfsPicPathEntity> entitys = new ArrayList<NwfsPicPathEntity>();
			entitys = picService.picturePaths(createId);
			//数据库中获取的是保存的图片名，要把结果拼接成服务器图片路径地址
			StringBuffer sb = new StringBuffer();
			sb.append(webUrl + "/");
			sb.append("headPhoto/");
			for(NwfsPicPathEntity pic : entitys){
				pic.setPicPath(sb + pic.getPicPath());
			}
			//存入工作流待办实体
			if(entitys.size() == 0){
				NwfsPicPathEntity picentity = new NwfsPicPathEntity();
				picentity.setEmpCode(workflow.getRequestInfo().getCreatorId());
				picentity.setGender("");
				picentity.setPicPath("");
				entitys.add(picentity);
			}
			workflow.setPicPaths(entitys);
		}
		return workflow;
	}
	
	
	/**
	 * 拼接实体数据 返回给前端（已完成我提交的）
	 * @param requestInfoArray
	 * @return
	 */
	@Override
	public List<WorkflowListEntity> dealData(
			weaver.workflow.webservices.WorkflowRequestInfo[] requestInfoArray,
			List<WorkflowPageInfo> pageInfoArray) {
		if(requestInfoArray == null || pageInfoArray == null){
			return null;
		}
		//map中key值不存在重复  会有去重效果
		Map<String, WorkflowPageInfo> resultMap = new HashMap<String, WorkflowPageInfo>();
		//循环页面对应表
		for (WorkflowPageInfo pageInfo : pageInfoArray) {
			String workFlow = pageInfo.getWorkflowId();
			resultMap.put(workFlow, pageInfo);
		}
		//拼接实体集
		List<WorkflowListEntity> listEntity = new ArrayList<WorkflowListEntity>();
		for (weaver.workflow.webservices.WorkflowRequestInfo info : requestInfoArray) {
			//ID转工号
//			info = unoPeratorIdToUserID(info);
			//泛微待办实体
			weaver.workflow.webservices.WorkflowBaseInfo baseInfo = info.getWorkflowBaseInfo();
			//泛微工作流ID
			String workflowId = baseInfo.getWorkflowId();
			//判断oa的id和本库id是否相等
			if (resultMap.containsKey(workflowId)) {
				//如果两个工作流ID相同
				WorkflowListEntity entity = new WorkflowListEntity();
				WorkflowPageInfo wpInfo = resultMap.get(workflowId);
//				System.out.println("dealData---WorkflowPageInfo---ID:"+wpInfo.getWorkflowId()+"---PAGE:"+wpInfo.getWorkflowPage());
				//页面地址
				entity.setPageAdress(wpInfo.getWorkflowPage());
				//实体
				entity.setRequestInfo(info);
				listEntity.add(entity);
			}
			/*//循环页面对应表
			for (WorkflowPageInfo pageInfo : pageInfoArray) {
				if (workflowId.equals(pageInfo.getWorkflowId())) {
					//如果两个工作流ID相同
					WorkflowListEntity entity = new WorkflowListEntity();
					System.out.println("dealData---WorkflowPageInfo---ID:"+pageInfo.getWorkflowId()+"---PAGE:"+pageInfo.getWorkflowPage());
					//页面地址
					entity.setPageAdress(pageInfo.getWorkflowPage());
					//实体
					entity.setRequestInfo(info);
					listEntity.add(entity);
				}
			}*/
			
		}
		return listEntity;
	}
	
	/**
	 * 拼接实体数据 返回给前端 （已完成我审批的 去除起草的工作流）
	 * @param requestInfoArray
	 * @return
	 */
	public List<WorkflowListEntity> dealData1(
			weaver.workflow.webservices.WorkflowRequestInfo[] requestInfoArray,
			List<WorkflowPageInfo> pageInfoArray,String userId) {
		if(requestInfoArray == null || pageInfoArray == null){
			return null;
		}
		//键：workflowid  值：对象 
		Map<String, WorkflowPageInfo> pageInfoMap = new HashMap<String, WorkflowPageInfo>();
		//循环页面对应表 封装到map
		for (WorkflowPageInfo pageInfo : pageInfoArray) {
			String workFlow = pageInfo.getWorkflowId();
			pageInfoMap.put(workFlow, pageInfo);
//			System.out.println(pageInfo.getWorkflowId()+"----"+pageInfo.getWorkflowName()+"----"+pageInfo.getWorkflowPage());
		}
		
		//拼接实体集
		List<WorkflowListEntity> listEntity = new ArrayList<WorkflowListEntity>();
		//获取开始时间
		long startTime2 = System.currentTimeMillis();    
		//拼接实体集
		for (weaver.workflow.webservices.WorkflowRequestInfo info : requestInfoArray) {
			//起草人工号
			String empCode = workflowService.getWorkflowUserCode(info.getCreatorId());
			//剔除我起草的工作流
			if(empCode.equals(userId)){
				continue;
			}else{
				/*//获取开始时间 8~185ms
				long startTime3 = System.currentTimeMillis();    
				//ID转工号
				info = unoPeratorIdToUserID(info);
				//获取结束时间
				long endTime3 = System.currentTimeMillis();    
				System.out.println("for unoPeratorIdToUserID 列表  我的已办理流程列表  - 程序运行时间  - 后台：" + (endTime3 - startTime3) + "ms");
				*/
				//泛微待办实体
				weaver.workflow.webservices.WorkflowBaseInfo baseInfo = info.getWorkflowBaseInfo();
				//泛微工作流ID
				String workflowId = baseInfo.getWorkflowId();
				
				if (pageInfoMap.containsKey(workflowId)) {
					//如果两个工作流ID相同
					WorkflowListEntity entity = new WorkflowListEntity();
					WorkflowPageInfo workflowInfo = pageInfoMap.get(workflowId);
//					System.out.println("dealData1---WorkflowPageInfo---ID:"+workflowInfo.getWorkflowId()+"---PAGE:"+workflowInfo.getWorkflowPage());
					//页面地址
					entity.setPageAdress(workflowInfo.getWorkflowPage());
					//实体
					entity.setRequestInfo(info);
					listEntity.add(entity);
				}
				
				/*//循环页面对应表 两层for循环嵌套 效率低  可以封装到map 取键值对
				for (WorkflowPageInfo pageInfo : pageInfoArray) {
					if (workflowId.equals(pageInfo.getWorkflowId())) {
						//如果两个工作流ID相同
						WorkflowListEntity entity = new WorkflowListEntity();
						System.out.println("dealData1---WorkflowPageInfo---ID:"+pageInfo.getWorkflowId()+"---PAGE:"+pageInfo.getWorkflowPage());
						//页面地址
						entity.setPageAdress(pageInfo.getWorkflowPage());
						//实体
						entity.setRequestInfo(info);
						listEntity.add(entity);
					}
				}*/
			}
		}
		long endTime2 = System.currentTimeMillis();    //获取结束时间
		logger.info("for OA列表  我的已办理流程列表  - 程序运行时间  - 后台：" + (endTime2 - startTime2) + "ms");
		return listEntity;
	}
	
	
	//工作流详情
	/*@Override
	public WorkflowRequestInfo workflowInfo(String userId, int requestId) throws RemoteException {
		WorkflowServicePortTypeProxy workflow = new WorkflowServicePortTypeProxy();
		int codeToId = workflow.getUserIdByWorkCode(userId);
		//参数含议  从左到右三个参数   1、 请求id requestid  2、用户id userid  3、从相关id的工作流过来 fromrequestid 默认为0
		WorkflowRequestInfo resultInfo = workflow.getWorkflowRequest(requestId , codeToId, 0);
		return resultInfo;
	}*/
	
	//工作流详情
	@Override
	public weaver.workflow.webservices.WorkflowRequestInfo workflowInfo(String userId, int requestId) throws RemoteException {
		//int codeToId = workflowService.getUserIdByWorkCode(userId);
		String requestid = String.valueOf(requestId);
		weaver.workflow.webservices.WorkflowRequestInfo resultInfo = null;
		//校验工作流号 必须为纯数字 0315
		java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("[0-9]*");
        java.util.regex.Matcher match=pattern.matcher(requestid);
        StringEscapeUtils.escapeSql(requestid);
        if(match.matches()){
        	//参数含议  从左到右三个参数   1、 请求id requestid  2、用户id userid  3、从相关id的工作流过来 fromrequestid 默认为0
    		resultInfo = workflowService.getWorkflowRequest(Integer.parseInt(requestid) , userId, 0);
    		
        }
		//id转工号
		resultInfo = createIdToUserID(resultInfo);
		return resultInfo;
	}
		
	// createID转工号
	private weaver.workflow.webservices.WorkflowRequestInfo createIdToUserID(weaver.workflow.webservices.WorkflowRequestInfo requestInfo) {
		if(requestInfo == null) 
			return null;
		String createId = requestInfo.getCreatorId();
		String userId = workflowService.getWorkflowUserCode(createId);
		requestInfo.setCreatorId(userId);
		return requestInfo;
	}
	
	//工作流提交
	@Override
	public String workflowSubmit(String userId, WeaverWorkflowInfo entity) throws RemoteException {
		long startTime = System.currentTimeMillis();    //获取开始时间
		long endTime = 0;
		long resultTime = 0;
		//int codeToId = workflowService.getUserIdByWorkCode(entity.getUserId());
		// 将前端传来的 工作流详情信息 由json转为实体
		weaver.workflow.webservices.WorkflowRequestInfo requestInfo = JSONObject.parseObject(entity.getWorkflowInfo(), weaver.workflow.webservices.WorkflowRequestInfo.class);
		String resultString = null;
		//提交结果 
		//获取合伙人资质审核工作流id
		String wid = monitordao.getPartnerWid();
		//“合伙人资质审核”工作流某个字段置空
		if(wid != null && requestInfo.getWorkflowBaseInfo().getWorkflowId().equals(wid)){
			requestInfo.setWorkflowMainTableInfo(null);
			logger.info("合伙人资质审核置空");
		}
		//判断工号的规范性
		if(ParamUtils.checkUserId(userId)){
			// errorMessage
			logger.info("工号错误，不符合规范");
		}
		
		String requestId = String.valueOf(entity.getRequestId());
		//过滤特殊符号
		String regEx="^[a-z0-9A-Z]+$"; 
		Pattern p = Pattern.compile(regEx); 
		Matcher m = p.matcher(entity.getSubmitType());
		//校验工作流号 必须为纯数字
		java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("[0-9]*");
        java.util.regex.Matcher match=pattern.matcher(requestId);
        startTime = System.currentTimeMillis();    //获取开始时间
		if(match.matches() || m.matches()){
			resultString = workflowService.submitWorkflowRequest(requestInfo, entity.getRequestId(), userId, entity.getSubmitType(), entity.getRemark());
		}
		
		//可返回报错信息
		String resultString1 = workflowService.getWorkflowCurrentnodeinfoNew(String.valueOf(entity.getRequestId()),userId);
		endTime = System.currentTimeMillis();    //获取结束时间
		resultTime = endTime - startTime;
		logger.info("新工作流同意（总时间） - 程序运行时间  - 后台：" + resultTime + "ms");
		if((resultString1.indexOf("errorcode") != -1) || (resultString1.indexOf("errorname") != -1)){
			//包含错误信息
			resultString = resultString1;
		}
		//监控信息
		String joblevel = employeeService.getJoblevel(userId);
		if(userId !=null && joblevel != null && requestInfo != null){
			try {
				//这个回退节点字段 暂存新老工作流 状态
				requestInfo.setRejectButtonName("new");
				//errorInfo
				requestInfo.setRemark(resultString);
				//最新包版本
				String version = String.valueOf(entity.getVersion());
				requestInfo.setForwardButtonName(version);
				//审批意见
				String remark = entity.getRemark();
				if(remark.length() >= 30){
					requestInfo.setMessageType(remark.substring(0, 30));
				}else{
					requestInfo.setMessageType(remark);
				}
				//暂存 调lsp系统返回时长字段
				requestInfo.setReceiveTime(String.valueOf(resultTime));
				//暂存接口名称
				requestInfo.setRequestName("weaverWfsService--workflowSubmit");
				monitordao.insertApprovalNewMonitor(userId,joblevel,requestInfo,resultString,resultString,"0");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				//暂时先不去掉 两张表都保存监控信息
				monitordao.insertApprovalMonitor(userId,joblevel,requestInfo,resultString);
			}
		}
		return resultString;
	}

	//工作流不同意接口
	@SuppressWarnings("finally")
	@Override
	public String workflowtUnagree(String userId, int requestId, String workflowName, String sysCode, String version) throws RemoteException {
		//我要获取当前的日期
		Date begindate = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createDate = sdf.format(begindate);
        long startTime = System.currentTimeMillis();    //获取开始时间
		long endTime = 0;
		long resultTime = 0;
		//int codeToId = workflowService.getUserIdByWorkCode(userId);
		/**
		 * param1:requestID
		 * param2:userId
		 */
		//String result =  workflowService.doForceOver(requestId, userId);
		startTime = System.currentTimeMillis();    //获取开始时间
		String result = workflowService.doForceOverNew(requestId, userId, "");
		endTime = System.currentTimeMillis();    //获取结束时间
		//审批监控
		String jobLevel = employeeService.getJoblevel(userId);
		resultTime = endTime - startTime;
		logger.info("工作流不同意接口（总时间） - 程序运行时间  - 后台：" + resultTime + "ms");
		try {
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
			requestInfo.setRemark(result);
			requestInfo.setSubmitButtonName("不同意");
			requestInfo.setUserid(userId);
			requestInfo.setWorkflowBaseInfo(baseInfo);
			//审批意见   前端没有传这个参数
			requestInfo.setMessageType("");
			//这个回退节点字段 暂存新老工作流 状态
			requestInfo.setRejectButtonName("new");
			//暂存接口名称
			requestInfo.setRequestName("workflowtUnagree");
			//暂存 调oa系统返回时长字段
			requestInfo.setReceiveTime(String.valueOf(resultTime));
			//暂存 版本号
			requestInfo.setForwardButtonName(version);
			monitordao.insertApprovalNewMonitor(userId,jobLevel,requestInfo,result,result,"0");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
				wmEntity.setResult(result);
				if(result.equals("success")){
					wmEntity.setIsSuccess(1);
				}
			}
			wmEntity.setInterfaceName("workflowtUnagree");
			monitordao.insertUApprovalMonitor(wmEntity);
			return result;
		}
	}
	
	/**
	 * 我的工作流
	 * 老版工作流 调用 --- 没有分页功能 
	 * workflowPageNumber：200  分页显示条数  默认200
	 */
	@Override
	public List<WorkflowListEntity> myWorkflowList(String userId, String status, String pageNo) throws RemoteException {
		//拼接结果集
		List<WorkflowListEntity> listData = new ArrayList<WorkflowListEntity>();
		//List<WorkflowListEntity> listOldData = new ArrayList<WorkflowListEntity>();
		// 工号转ID
		//int codeToID = workflowService.getUserIdByWorkCode(userId);
		//待办总条数
		int totalCount = workflowService.getMyWorkflowRequestCount(userId, null);
		//int totalCountOld = workflowSearch.getOldMyWorkflowRequestCount(userId, null);
		/**
		 * int pageNo:当前页数
		 * int pageSize:每页的分页数量
		 * int recordCount:总行数
		 * int userId:用户id
		 * String[] conditions:查询流程的条件,为字符串数组类型
		 */
		String[] conditions = new String[1];
		//  0-起草了但没提交（草搞箱），1-起草了也提交了（审批中），2-批准（审批中），3-起草了也提交了（审批完成）
		//前端传来的“1”表示进行中的          "3"表示已完成的
		if (status.equals("1")) {
			conditions[0] = " ( t1.currentnodetype = 1 or t1.currentnodetype = 2 or t1.currentnodetype = 0) ";   /*or t1.currentnodetype = 0*/
		}else {
			conditions[0] = " t1.currentnodetype = " + status;
		}
		/*String[] conditions1 = new String[1];
	    if (status.equals("1")) {
	      conditions1[0] = " ( t.condition = 1 or t.condition = 2 or t.condition = 3) ";  
	     }else {
	      conditions1[0] = " t.condition in ('4','5') ";
	    }*/

		//currentnodetype 即状态
		//weaver.workflow.webservices.WorkflowRequestInfo[] info1 = workflowSearch.getMyOldWorkflowRequestList(Integer.parseInt(pageNo),  DpmConstants.workflowPageNumber, totalCountOld, userId, conditions1);
		weaver.workflow.webservices.WorkflowRequestInfo[] info = 
				workflowService.getMyWorkflowRequestList(Integer.parseInt(pageNo),  DpmConstants.workflowPageNumber, totalCount, userId, conditions);
		//工作流详情对应页面
		List<WorkflowPageInfo> pageInfoArray = pageService.pageInfomation();
		//获取开始时间
		long startTime3 = System.currentTimeMillis();    
		// 数据匹配处理
		listData = dealData(info, pageInfoArray);
		//获取结束时间
		long endTime3 = System.currentTimeMillis();    
		logger.info("dealData已完成 我的工作流 起草的工作流：不包含分页 - 程序运行时间  - 后台：" + (endTime3 - startTime3) + "ms");
		return listData;
	}
	
		/**
		 * 我的工作流
		 * 新版工作流 调用 --  分页功能  每页显示20条 
		 * workflowMyPageNumber：20  分页显示条数
		 */
		@Override
		public List<WorkflowListEntity> myWorkflowPageList(String userId, String status, String pageNo) throws RemoteException {
			//拼接结果集
			List<WorkflowListEntity> listData = new ArrayList<WorkflowListEntity>();
			//List<WorkflowListEntity> listOldData = new ArrayList<WorkflowListEntity>();
			// 工号转ID
			//int codeToID = workflowService.getUserIdByWorkCode(userId);
			//待办总条数
			int totalCount = workflowService.getMyWorkflowRequestCount(userId, null);
			//int totalCountOld = workflowSearch.getOldMyWorkflowRequestCount(userId, null);
			/**
			 * int pageNo:当前页数
			 * int pageSize:每页的分页数量
			 * int recordCount:总行数
			 * int userId:用户id
			 * String[] conditions:查询流程的条件,为字符串数组类型
			 */
			String[] conditions = new String[1];
			//  0-起草了但没提交（草搞箱），1-起草了也提交了（审批中），2-批准（审批中），3-起草了也提交了（审批完成）
			//前端传来的“1”表示进行中的          "3"表示已完成的
			if (status.equals("1")) {
				conditions[0] = " ( t1.currentnodetype = 1 or t1.currentnodetype = 2 or t1.currentnodetype = 0) ";   /*or t1.currentnodetype = 0*/
			}else {
				conditions[0] = " t1.currentnodetype = " + status;
			}
			/*String[] conditions1 = new String[1];
		    if (status.equals("1")) {
		      conditions1[0] = " ( t.condition = 1 or t.condition = 2 or t.condition = 3) ";  
		     }else {
		      conditions1[0] = " t.condition in ('4','5') ";
		    }*/

			//currentnodetype 即状态
			//weaver.workflow.webservices.WorkflowRequestInfo[] info1 = workflowSearch.getMyOldWorkflowRequestList(Integer.parseInt(pageNo),  DpmConstants.workflowPageNumber, totalCountOld, userId, conditions1);
			weaver.workflow.webservices.WorkflowRequestInfo[] info = 
					workflowService.getMyWorkflowRequestList(Integer.parseInt(pageNo),  DpmConstants.workflowMyPageNumber, totalCount, userId, conditions);
			//工作流详情对应页面
			List<WorkflowPageInfo> pageInfoArray = pageService.pageInfomation();
			//获取开始时间
			long startTime3 = System.currentTimeMillis();    
			// 数据匹配处理
			listData = dealData(info, pageInfoArray);
			//获取结束时间
			long endTime3 = System.currentTimeMillis();    
			logger.info("dealData已完成 我的工作流 起草的工作流：包含分页 - 程序运行时间  - 后台：" + (endTime3 - startTime3) + "ms");
			return listData;
		}
	
	/**
	 * 我的已办理流程列表
	 * 没有分页功能  默认显示200条
	 */
	@Override
	public List<WorkflowListEntity> getHendledWorkflowList(String userId,String pageNo,String workflowStatus){
		//拼接结果集
		List<WorkflowListEntity> listData = new ArrayList<WorkflowListEntity>();
		//List<WorkflowListEntity> listData1 = new ArrayList<WorkflowListEntity>();
		weaver.workflow.webservices.WorkflowRequestInfo[] resultList = new weaver.workflow.webservices.WorkflowRequestInfo[]{};
		//weaver.workflow.webservices.WorkflowRequestInfo[] resultList1 = new weaver.workflow.webservices.WorkflowRequestInfo[]{};
		try {
			//工号
			//int codeToID = workflowService.getUserIdByWorkCode(userId);
			//待办总条数
			int totalCount = workflowService.getHendledWorkflowRequestCount(userId, null);
			//int totalCountOld = workflowSearch.getOldHendledWorkflowRequestCount(userId, null);
			
			String[] conditions = new String[1];
			//String[] conditions1 = new String[1];
			//  0-我批过的未完成的，1-我批过的（已经完成）
//			conditions[0] = " 	t2.iscomplete = " + workflowStatus;
			conditions[0] = " (t2.iscomplete = 0 or t2.iscomplete = 1)";
			//conditions1[0] = " (t.condition = '3' or t.condition = '4' or t.condition = '5') and a.currentstate = '12' ";
			//参数：当前页数、每页的分页数量、总条数、用户ID、查询流程的条件
			resultList = workflowService.getHendledWorkflowRequestList(Integer.parseInt(pageNo),  DpmConstants.workflowPageNumber, totalCount, userId, conditions);
			//resultList1 = workflowSearch.getOldHendledWorkflowRequestList(Integer.parseInt(pageNo),  DpmConstants.workflowPageNumber, totalCount, userId, conditions1);
			//工作流详情对应页面
			List<WorkflowPageInfo> pageInfoArray = pageService.pageInfomation();
			// 数据匹配处理
			//listData = dealData(resultList, pageInfoArray);
			//获取老工作流 
			long startTime3 = System.currentTimeMillis();    //获取开始时间
			listData = dealData1(resultList, pageInfoArray,userId);
			long endTime3 = System.currentTimeMillis();    //获取结束时间
			logger.info("dealData1我的已办理流程列表  去除起草的工作流 - 程序运行时间  - 后台：" + (endTime3 - startTime3) + "ms");
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("已办理流程列表异常："+e);
		}	
		return listData;
	}
	
	/**
	 * 我的已办理流程列表
	 * 分页功能 每页显示20条
	 */
	@Override
	public List<WorkflowListEntity> getHendledWorkflowPageList(String userId,String pageNo,String workflowStatus){
		//拼接结果集
		List<WorkflowListEntity> listData = new ArrayList<WorkflowListEntity>();
		weaver.workflow.webservices.WorkflowRequestInfo[] resultList = new weaver.workflow.webservices.WorkflowRequestInfo[]{};
		try {
			//待办总条数
			int totalCount = workflowService.getHendledWorkflowRequestCount(userId, null);
			String[] conditions = new String[1];
			//  0-我批过的未完成的，1-我批过的（已经完成）
			conditions[0] = " (t2.iscomplete = 0 or t2.iscomplete = 1)";
			//参数：当前页数、每页的分页数量、总条数、用户ID、查询流程的条件
			resultList = workflowService.getHendledWorkflowRequestList(Integer.parseInt(pageNo),  DpmConstants.workflowMyPageNumber, totalCount, userId, conditions);
			//工作流详情对应页面
			List<WorkflowPageInfo> pageInfoArray = pageService.pageInfomation();
			//获取老工作流 
			long startTime3 = System.currentTimeMillis();    //获取开始时间
			listData = dealData1(resultList, pageInfoArray,userId);
			long endTime3 = System.currentTimeMillis();    //获取结束时间
			logger.info("dealData1我的已办理流程列表  去除起草的工作流 - 程序运行时间  - 后台：" + (endTime3 - startTime3) + "ms");
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("已办理流程列表异常："+e);
		}	
		return listData;
	}
	
	//附件解密
	@Override
	public void decryptFile(String userId, String deviceType, String filename,
			File file) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null; 
		ServletOutputStream out = null;
		InputStream in = null;
		
		logger.info("用户"+userId+"附件解密开始>>>>");
		try {
			// 获取response的输出流
			out = ServletActionContext.getResponse().getOutputStream();
			httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(appInterfaceUrl);
			// 上传的文件
			FileBody bin = new FileBody(file);
			StringBody userIdParam = new StringBody(userId,ContentType.create("text/plain",Consts.UTF_8));
			StringBody deviceTypeParam = new StringBody(deviceType,ContentType.create("text/plain",Consts.UTF_8));
			StringBody filenameParam = new StringBody(filename,ContentType.create("text/plain",Consts.UTF_8));
			// 构造表单
			HttpEntity reqEntity = MultipartEntityBuilder.create()
					.addPart("file", bin)
					.addPart("userId", userIdParam)
					.addPart("deviceType", deviceTypeParam)
					.addPart("filename", filenameParam)
					.build();
			 // 设置参数
		    RequestConfig config = RequestConfig.custom()
					.setConnectTimeout(MagicNumber.NUM3000) // 创建连接的最长时间
					.setConnectionRequestTimeout(MagicNumber.NUM500) // 从连接池中获取到连接的最长时间
					.setSocketTimeout(MagicNumber.NUM60000) // 数据传输的最长时间（1分钟）
					.setStaleConnectionCheckEnabled(true) // 提交请求前测试连接是否可用
					.build();
		    // 设置参数
			httpPost.setEntity(reqEntity);
			httpPost.setConfig(config);
		
			// 请求dlp
			response = httpClient.execute(httpPost);
			byte[] buff = new byte[MagicNumber.NUM1024];
			int len = 0;
			if(response.getStatusLine().getStatusCode() == MagicNumber.NUM200){
				// 获取响应数据
				HttpEntity entity = response.getEntity();
				if(null != entity){
					in = entity.getContent();
					// 将解密后的文件数据写出
					while ((len = in.read(buff)) != -1) {
						out.write(buff, 0, len);
					}
				}
			}
		} catch (Exception e) {
			logger.error("用户"+userId+"附件解密失败>>>>", e);
			try {
				if(null != out){
					// 异常返回
					out.write("40007".getBytes());
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally {
			// 释放资源
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// 释放资源
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			// 释放资源
            if(response!=null){
                try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
            
            if(httpClient != null){
            	try {
            		// 关闭连接
            		httpClient.close();
            	} catch (IOException e) {
            		e.printStackTrace();
            	}
            }
		}

	}
	//附件接口处理
	@Override
	public WeaverAttachments valueToEntity(weaver.docs.webservices.DocInfo docInfo) {
		WeaverAttachments attachments = new WeaverAttachments();
		weaver.docs.webservices.DocAttachment[] attachements = docInfo.getAttachments();
		for (weaver.docs.webservices.DocAttachment docAttachment : attachements) {
			attachments.setDocid(docAttachment.getDocid());
			attachments.setFilename(docAttachment.getFilename());
			}
		return attachments;
	}
	
	
	/**
	 * 工作流查询接口
	 */
	@Override
	public List<WorkflowListEntity> workflowSearch(String userId, NwfsSearchVo entity)
			throws RemoteException {
		//拼接结果集
		List<WorkflowListEntity> listData = new ArrayList<WorkflowListEntity>(); 
//		IWorkflowServiceDepponPortTypeProxy search = new IWorkflowServiceDepponPortTypeProxy();
		//工号
		//int codeToID = workflowService.getUserIdByWorkCode(userId);
		
		/**
		 * int userid,String operatedateStart, String operatedateend, String syscode,String[] conditions)
		 */
		//验证日期是yyyy-MM-dd HH:mm:ss支持闰年的正则表达式
		/*Pattern pattern = Pattern.compile("((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s((([0-1][0-9])|(2?[0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))");
		Matcher matcherS = pattern.matcher(entity.getStartTime());
		Matcher matcherE = pattern.matcher(entity.getEndTime());*/
		//判断工号的规范性
		if(ParamUtils.checkUserId(userId)){
			// errorMessage
			logger.info("工号错误，不符合规范");
		}
		int totalCount = workflowSearch.getHendledWorkflowRequestCountCops(userId, entity.getStartTime(), entity.getEndTime(), entity.getSysCode(), null);
		//		int totalCount = 20;
		/**
		 * int pageNo:当前页数
		 * int pageSize:每页的分页数量
		 * int recordCount:总行数
		 * int userid:工号转id
		 * String operatedateStart:开始时间
		 * String operatedateend:结束时间
		 * String syscode:系统编码
		 * String[] conditions:其它条件 暂时写null 
		 * 目前缺少的搜索条件
		 * 按工作流名称搜索
		 * 按工作流号搜索
		 * 按工作流状态搜索 1111
		 * 按工作流起草人 1111
		 * 按工作流起草人工号
		 * 
		 */
		
		//conditions[0] = " t1.requestname like '%系统%'";//工作流名称
		//conditions[0] = " t1.creater = '1754'";//申请人工号(先将工号转ID)
		//conditions[0] = " t1.requestmark = ‘WFS-GRDNOAFOSSZC20170808000025’";//工作流号
//		conditions[0] = " t1.currentnodetype = 3 ";//状态 未提交：0  ，已提交：1，  批准：2，归档：3，审批中：不为0不为3，
//		conditions[0] = " h.lastname like '%孙%' ";//申请人姓名
		
		String[] conditions = dealSql(entity);
		//String[] conditions1 = dealSql1(entity);
		//1、pageNo不得为空 否则会报异常  2、开始时间和结束时间得有 否则查到的数据为空 3、sysCode必传  否则查到数据为空
		weaver.workflow.webservices.WorkflowRequestInfo[] infos = workflowSearch.getHendledWorkflowRequestListCops(Integer.parseInt(entity.getPageNo()), DpmConstants.workflowPageNumber, totalCount, userId, entity.getStartTime(), entity.getEndTime(), entity.getSysCode(), conditions);
		//weaver.workflow.webservices.WorkflowRequestInfo[] infos1 = 
		//		workflowSearch.getOldRequestListCops(Integer.parseInt(entity.getPageNo()), DpmConstants.workflowPageNumber, totalCount, userId, entity.getStartTime(), entity.getEndTime(), entity.getSysCode(), conditions1);
		//oa数据进行倒序
		//Collections.reverse(Arrays.asList(infos));
		checkSortByCaleandarTime(Arrays.asList(infos));
		//工作流详情对应页面
		List<WorkflowPageInfo> pageInfoArray = pageService.pageInfomation();
		// 数据匹配处理
		listData = dealDataSearch(infos, pageInfoArray);
		
		return listData;
	}
	

	//搜索框搜索
	public List<WorkflowListEntity> textSearch(String text, String userId) throws RemoteException{
		//拼接结果集
		List<WorkflowListEntity> listData = new ArrayList<WorkflowListEntity>(); 
		//int codeToID = workflowService.getUserIdByWorkCode(userId);
		/**
		 * int userid,String operatedateStart, String operatedateend, String syscode,String[] conditions)
		 */
		//默认查询近三个月据

		Date now = new Date(); 
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(now);  
		calendar.add(Calendar.YEAR, -1);//1年前 
//		calendar.add(Calendar.MONTH, -6);//半年前  
		Date threeDaysAgo = calendar.getTime(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		//默认查询从2000年到当前日期的数据
		String endTime = dateFormat.format( now );
		String startTime = dateFormat.format(threeDaysAgo);
		//String sysCode = "";//默认查询所有工作流系统
		int totalCount = workflowSearch.getHendledWorkflowRequestCountCops(userId, startTime, endTime, "", null);
		//查询待办总数
//		int total = workflowService.getToDoWorkflowRequestCount(userId,  null);
		//转义参数 防止sql注入
		text = StringEscapeUtils.escapeSql(text);
		String[] conditions = new String[1];
		if (text.matches("[\u4E00-\u9FA5]+")){
			//姓名或工作流名称：   正则表达式 纯中文
			System.out.println("输入的是姓名或者工作流名称");
			conditions[0] = " (h.lastname like '%" + text + "%'" + " or t1.requestname like '%" + text + "%')";
		}else if (text.matches("^[R]{1}(\\d{4,10})$")){
			//id号： 正则表达式 R开头6位纯数字【以后可能7位数】
			System.out.println("输入的是requestid号");
			text = text.replaceAll("R", "");// 去掉R标志 只保留纯数字
			//按requestid搜索
			conditions[0] =  " t1.requestid = " + text ;
		//原始判断text.matches("^[a-zA-Z]{1}[a-zA-Z0-9]*[0-9]+[a-zA-Z0-9]*") && text.length() > Constants.MIN_LENGTH && text.length() < Constants.MAX_LENGTH
		}else if (text.matches("^\\d{4,10}$") || text.matches("^[T]{1}(\\d{4,10})$") ){
			//工号： 正则表达式 4-10位纯数字 或者T开头的合伙人工号
			System.out.println("输入的是工号");
			int creatorID = workflowService.getUserIdByWorkCode(text);
			//按起草人工号搜索
			conditions[0] =  " t1.creater = " + creatorID;
		//原始判断text.matches("^[a-zA-Z]{1}[a-zA-Z0-9]*[0-9]+[a-zA-Z0-9]*") && text.length() > Constants.MIN_LENGTH && text.length() < Constants.MAX_LENGTH
		}else if (text.matches("^[a-zA-Z]{1}\\w{9,29}$")){
			//工作流号 判断规则  1、以字线开头 2、 必须包含字母和数字  3、总长度在10-30之间
			System.out.println("输入的是工作流号");
			conditions[0] = " t1.requestmark = '" + text + "'";
		}else {
			System.out.println("搜索的不符合规则");
			return listData;
		}
		/*conditions[1] = " order by t1.createdate ";*/
		//1、pageNo不得为空 否则会报异常  2、开始时间和结束时间得有 否则查到的数据为空 3、sysCode必传  否则查到数据为空
		//(int pageNo, int pageSize, int recordCount, String workcode, String operatedateStart, String operatedateend, String syscode, String[] conditions);
		weaver.workflow.webservices.WorkflowRequestInfo[] infos = workflowSearch.getHendledWorkflowRequestListCops(1, totalCount, totalCount, userId, startTime, endTime, "", conditions);
		
		/*weaver.workflow.webservices.WorkflowRequestInfo[] requestInfos = 
		workflowService.getToDoWorkflowRequestList(1, DpmConstants.workflowPageNumber, total, userId, conditions);
		//已完成  待办接口查询记录 合并
		WorkflowRequestInfo[] work = new WorkflowRequestInfo[infos.length + requestInfos.length];
		for(int i = 0; i < work.length; i++){
			if(i < infos.length){
				work[i] = infos[i];
			}else{
				work[i] = requestInfos[i - infos.length ];
			}
		}*/
		
		//oa数据进行倒序
		//List<WorkflowRequestInfo> asList = Arrays.asList(infos);
		checkSortByCaleandarTime(Arrays.asList(infos));
		//Collections.reverse(Arrays.asList(infos));
		//工作流详情对应页面
		List<WorkflowPageInfo> pageInfoArray = pageService.pageInfomation();
		// 数据匹配处理
		listData = dealDataSearch(infos, pageInfoArray);
		return listData;
	}
	
	/**
	 * sort排序 --倒序
	 * 根绝list集合中 creatTime时间倒序
	 * @param list
	 */
	private void checkSortByCaleandarTime(List<WorkflowRequestInfo> list) {
		
		final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		if (sort) {
			// 自定义排序
			Collections.sort(list, new Comparator<WorkflowRequestInfo>() {
				@Override
				public int compare(WorkflowRequestInfo info1, WorkflowRequestInfo info2) {
					// 按照开始时间进行判断
					long time;
					int flag = 0;
					try {
						time = format.parse(info2.getCreateTime()).getTime() - format.parse(info1.getCreateTime()).getTime();
						System.out.println("info2: "+info2.getCreateTime());
						System.out.println("time:  "+time);
						System.out.println("info1: "+info1.getCreateTime());
						// > 0
						if (time > 0)
							flag= 1;
						else if (time == 0) {
							flag= 0;
						} else
							flag= -1;
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return flag;
				}
			});
		}
//	}
	
	
	/**
	 * 拼接搜索实体  返回给前端  因为PC给过来的两个文件一样  但目录不一样 所以此方法写了两遍 只是 参数的路径不一样
	 * @param requestInfoArray
	 * @return
	 */
	private List<WorkflowListEntity> dealDataSearch(
			weaver.workflow.webservices.WorkflowRequestInfo[] requestInfoArray,
			List<WorkflowPageInfo> pageInfoArray) {
		//拼接实体集
		List<WorkflowListEntity> listEntity = new ArrayList<WorkflowListEntity>();
		for (weaver.workflow.webservices.WorkflowRequestInfo info : requestInfoArray) {
			//泛微待办实体
			weaver.workflow.webservices.WorkflowBaseInfo baseInfo = info.getWorkflowBaseInfo();
			//泛微工作流ID
			String workflowId = baseInfo.getWorkflowId();
			//循环页面对应表
			for (WorkflowPageInfo pageInfo : pageInfoArray) {
				if (workflowId.equals(pageInfo.getWorkflowId())) {
					//如果两个工作流ID相同
					WorkflowListEntity entity = new WorkflowListEntity();
					info = unoPeratorIdToUserID(info);
					//页面地址
					entity.setPageAdress(pageInfo.getWorkflowPage());
					//实体
					entity.setSearchRequestInfo(info);
					listEntity.add(entity);
				}
			}

		}
		return listEntity;
	}
	
	//我提交的审批中的 把审批人 由Id转为工号
	private weaver.workflow.webservices.WorkflowRequestInfo unoPeratorIdToUserID(weaver.workflow.webservices.WorkflowRequestInfo info) {
		String unoperator = info.getUnoperator();
		if (!StringUtils.isNotEmpty(unoperator)) 
			return info;
		String[] creatorIds = unoperator.split(",");
		String empNames = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < creatorIds.length; i++) {
			//只截取前三位工号
			if (i>2) 
			continue;
			String creatorId = creatorIds[i];
			String userId = workflowService.getWorkflowUserCode(creatorId);
			EmployeeInfo entity = employeeService.queryEmployeeInfoByEmpcode(userId);
			String empName;
			if (entity == null) {
				empName  = "无此工号信息:" + userId;
			}else {
				empName = entity.getEmpName();
			}

			if (i == 0) {
				empNames = empName;
			}else {
				empNames = sb.append(empNames).append(",").append(empName).toString() ;
				//empNames = empNames + "," + empName ;
			}
			
		}
		
		info.setUnoperator(empNames);
		return info;
	}
	
	
	private String[] dealSql(NwfsSearchVo entity) throws RemoteException{
		if(entity == null){
			return null;
		}
		/*String[] conditions  = new String[5];*/
		List<String> conditionList = new ArrayList<String>();
		//判断工号的规范性
		if(ParamUtils.checkUserId(entity.getCreatorId())){
			// errorMessage
			logger.info("工号错误，不符合规范");
		}
		//验证只包含数字和字母
		Pattern pa = Pattern.compile("^[A-Za-z0-9]+$"); 
		Matcher ma = pa.matcher(entity.getWfsStatus());
		//转义参数 防止sql注入
		String wfsName = StringEscapeUtils.escapeSql(entity.getWfsName());
		String wfsMark = StringEscapeUtils.escapeSql(entity.getWfsMark());
		if (entity.getCreatorId() != null && !entity.getCreatorId().equals("")) {
			int creatorID = workflowService.getUserIdByWorkCode(entity.getCreatorId());
			//按起草人工号搜索
			conditionList.add(" t1.creater = " + creatorID);
		} 
		if (entity.getCreatorName() != null && !entity.getCreatorName().equals("")){
			//按起草人姓名搜索
			conditionList.add(" h.lastname like '%" + wfsName + "%'");
		} 
		if (ma.matches() && entity.getWfsStatus() != null && !entity.getWfsStatus().equals("")){
			//按工作流状态搜索  未提交：0  ，已提交：1，  批准：2，归档：3，     审批中：4
			if (entity.getWfsStatus().equals("4")) {
				// 泛微数据库中只有3个状态      审批中状态需自己拼接 即状态为1和2的查出来所有结果
				conditionList.add("( t1.currentnodetype = 1 or t1.currentnodetype = 2 )");
			}else{
				conditionList.add(" t1.currentnodetype = " + entity.getWfsStatus());
			}	
		} 
		if (entity.getWfsMark() != null && !entity.getWfsMark().equals("")){
			//按工作流号搜索
			conditionList.add(" t1.requestmark = '" + wfsMark + "'");
		}
		if (entity.getWfsName() != null && !entity.getWfsName().equals("")){
			//按工作流名称搜索
			conditionList.add(" t1.requestname like '%" + wfsName + "%'");
		}
		String[] conditions = conditionList.toArray(new String[conditionList.size()]);
		return conditions;
	}
	
	//老工作流
	/*private String[] dealSql1(NwfsSearchVo entity) throws RemoteException{
		if(entity == null){
			return null;
		}
		List<String> conditionList = new ArrayList<String>();
		if (entity.getCreatorId() != null && !entity.getCreatorId().equals("")) {
			int creatorID = workflowService.getUserIdByWorkCode(entity.getCreatorId());
			//按起草人工号搜索
			conditionList.add(" t.applerid = '" + entity.getCreatorId() + "'");

		} 
		if (entity.getCreatorName() != null && !entity.getCreatorName().equals("")){
			//按起草人姓名搜索
			conditionList.add(" t.appler like '%" + entity.getWfsName() + "%'");

		} 
		if (entity.getWfsStatus() != null && !entity.getWfsStatus().equals("")){
			//按工作流状态搜索  未提交：0  ，已提交：1，  批准：2，归档：3，     审批中：4
			if (entity.getWfsStatus().equals("4")) {
				// 泛微数据库中只有3个状态      审批中状态需自己拼接 即状态为1和2的查出来所有结果
				conditionList.add("( t.condition = 3 or t.condition = 4 )");
			}else{
				conditionList.add(" t.condition = " + entity.getWfsStatus());
			}	
		} 
		if (entity.getWfsMark() != null && !entity.getWfsMark().equals("")){
			//按工作流号搜索
			conditionList.add(" t.busino = '" + entity.getWfsMark() + "'");
		}
		if (entity.getWfsName() != null && !entity.getWfsName().equals("")){
			//按工作流名称搜索
			conditionList.add(" t.processchname like '%" + entity.getWfsName() + "%'");
		}
		String[] conditions = conditionList.toArray(new String[conditionList.size()]);
		return conditions;
	}*/
	
	/**
	 * 添加工作流接口异常监控
	 */
	public int insertMonitor(WorkflowMonitorEntity wmEntity){
		return monitordao.insertMonitor(wmEntity);
	}
	
	/**
	 * 添加新工作流审批接口监控-退回
	 */
	public int insertApprovalMonitor(WorkflowMonitorEntity wmEntity){
		return monitordao.insertUApprovalMonitor(wmEntity);
	}
	
	/**
	 * 新增一条工作流
	 * @return
	 */
	public int insertNWorkflow(String workflowId,String workflowName,String workflowPage){
		NWorkflowInfoEntity nworkflowinfo = new NWorkflowInfoEntity();
		nworkflowinfo.setWorkflowId(workflowId);
		nworkflowinfo.setWorkflowName(workflowName);
		nworkflowinfo.setWorkflowPage(workflowPage);
		return monitordao.insertNWorkflow(nworkflowinfo);
	}
	
	/**
	 * 更改一条工作流状态
	 * @return
	 */
	public int updateNWorkflowStatus(String workflowId,String workflowStatus){
		NWorkflowInfoEntity nworkflowinfo = new NWorkflowInfoEntity();
		nworkflowinfo.setWorkflowId(workflowId);
		nworkflowinfo.setWorkflowStatus(workflowStatus);
		return monitordao.updateNWorkflowStatus(nworkflowinfo);
	}
	
	
	//删除工作流
	@Override
	public boolean workflowDelete(String userId, int requestId)
			throws RemoteException {
		//工号
		//int codeToID = workflowService.getUserIdByWorkCode(userId);
		/**
		 * int requestid:工作流id
		 * int userid:工号转id
		 */
		boolean deleteResult = workflowService.deleteRequest(requestId, userId);
		return deleteResult;
	}

	//撤销工作流
	@Override
	public boolean workflowRevoke(int requestId, String userId)
			throws RemoteException {
		//工号
		//int codeToID = workflowService.getUserIdByWorkCode(userId);

		/**
		 * int requestid:工作流id
		 * int userid:工号转id
		 */
//		boolean deleteResult = workflowService.doRetract(requestId, codeToID);
//		return deleteResult;
		return false;
		
	}
	
	/*
	 * 通知中心-审批通知——一条
	 */
	public List<Object> workflowNotice(String userId, String pageNo){

		//新工作流列表
		List<WorkflowListEntity> newlist = new ArrayList<WorkflowListEntity>();
		//老工作流列表
		WorkItemsDto dto = new WorkItemsDto();
		dto.setUserId(userId);
		List<OaWorkItem> oldlist = new ArrayList<OaWorkItem>();
		List<Object> workflowNo = new ArrayList<Object>();
		try { 
			//获取新工作流
			newlist = this.workflowList(userId,"", pageNo);
			int nNum = 0;
			WorkflowListEntity newOne = new WorkflowListEntity();
			if(newlist != null && newlist.size() > 0){
				nNum = newlist.size();
				newOne = newlist.get(0);
				//添加状态(新)
				newOne.setStatus("new");
			}
			
			//获取老工作流
			oldlist = workItemsListService.workitemslist1(dto);
			int oNum = 0;
			OaWorkItem oldOne = new OaWorkItem();
			if(oldlist != null && oldlist.size() > 0){
				oNum = oldlist.size();
				oldOne = oldlist.get(0);
				//添加状态(老)
				oldOne.setStatus("old");
			}
			
			//比较创建时间,添加创建时间更晚的一个
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date newct = format.parse(newOne.getRequestInfo().getCreateTime());
		
			if(nNum != 0 && oNum != 0){
				//相等则返回0，newct大返回1，否则返回-1
				int res = newct.compareTo(oldOne.getCreatetime());
				if(res >= 0){
					workflowNo.add(newOne);
				}
			}else if(nNum != 0){
				workflowNo.add(newOne);
			}else{
				workflowNo.add(oldOne);
			}
			//待审批条数
			workflowNo.add(nNum + oNum);
		} catch (Exception e) {
			//日志
			logger.error("------通知首页获取工作流待办列表失败-----" + e);
			e.printStackTrace();
		}
		return workflowNo;

	}
	
	/*
	 * 通知中心-审批通知列表
	 */
	public List<Object> workflowNoticeList(String userId, String pageNo){
		//新工作流列表
		List<WorkflowListEntity> newlist = new ArrayList<WorkflowListEntity>();
		//老工作流列表
		WorkItemsDto dto = new WorkItemsDto();
		dto.setUserId(userId);
		List<OaWorkItem> oldlist = new ArrayList<OaWorkItem>();
		List<Object> workflowlist = new ArrayList<Object>();
		try { 
			//获取新工作流
			newlist = this.workflowList(userId,"", pageNo);
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
			
			//合并新老工作流
			workflowlist.addAll(newlist);
			workflowlist.addAll(oldlist);
			//按创建时间排序
			listSort(workflowlist);
		} catch (Exception e) {
			//日志
			logger.error("------通知列表获取工作流待办列表失败-----" + e);
			e.printStackTrace();
		}
		return workflowlist;

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
	 * get
	 * @return
	 */
	public String getAppInterfaceUrl() {
		return appInterfaceUrl;
	}
	
	/**
	 * set
	 * @param appInterfaceUrl
	 */
	public void setAppInterfaceUrl(String appInterfaceUrl) {
		this.appInterfaceUrl = appInterfaceUrl;
	}
	/**
	 * set
	 * @param pageService
	 */
	public void setPageService(IWorkflowPageService pageService) {
		this.pageService = pageService;
	}
	
	public INwfsPicpathService getPicService() {
		return picService;
	}

	public void setPicService(INwfsPicpathService picService) {
		this.picService = picService;
	}
	/**
	 * set
	 * @param employeeService
	 */
	public void setEmployeeService(IQueryEmployeeInfoService employeeService) {
		this.employeeService = employeeService;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}
	
	public IMonitorDao getMonitordao() {
		return monitordao;
	}

	public void setMonitordao(IMonitorDao monitordao) {
		this.monitordao = monitordao;
	}

	public IEmployeeInfoDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(IEmployeeInfoDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public IWorkItemsListService getWorkItemsListService() {
		return workItemsListService;
	}

	public void setWorkItemsListService(IWorkItemsListService workItemsListService) {
		this.workItemsListService = workItemsListService;
	}

	public IBandApproveDao getBandApproveDao() {
		return bandApproveDao;
	}

	public void setBandApproveDao(IBandApproveDao bandApproveDao) {
		this.bandApproveDao = bandApproveDao;
	}

	
}
