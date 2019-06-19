package com.deppon.dpm.module.wfs.server.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;

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
import weaver.workflow.webservices.WorkflowService;

import cn.jpush.api.utils.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.ctc.wstx.util.StringUtil;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.define.DpmConstants;
import com.deppon.dpm.module.wfs.server.action.WeaverWfsAction;
import com.deppon.dpm.module.wfs.server.service.INwfsPicpathService;
import com.deppon.dpm.module.wfs.server.service.IQueryEmployeeInfoService;
import com.deppon.dpm.module.wfs.server.service.IWeaverWfsService;
import com.deppon.dpm.module.wfs.server.service.IWorkflowPageService;
import com.deppon.dpm.module.wfs.shared.domain.EmployeeInfo;
import com.deppon.dpm.module.wfs.shared.domain.NwfsPicPathEntity;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowListEntity;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowPageInfo;
import com.deppon.dpm.module.wfs.shared.vo.NwfsSearchVo;
import com.deppon.dpm.module.wfs.shared.vo.WeaverAttachments;
import com.deppon.dpm.module.wfs.shared.vo.WeaverWorkflowInfo;
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

	//dubbox 引入
	@Autowired
	public WorkflowService workflowService;
	@Autowired
	public IWorkflowServiceDeppon workflowSearch;
	/**
	 * service
	 */
	private INwfsPicpathService picService;
	

	//待办工作流
	@Override
	public List<WorkflowListEntity> workflowList(String userId, String status, String pageNo) throws RemoteException {
		//拼接结果集
		List<WorkflowListEntity> listData = new ArrayList<WorkflowListEntity>(); 
//		WorkflowServicePortTypeProxy workflow = new WorkflowServicePortTypeProxy();
		
		// 工号转ID
		int codeToID = workflowService.getUserIdByWorkCode(userId);
		//查询待办总数
		int totalCount = workflowService.getToDoWorkflowRequestCount(codeToID,  null);
		/**
		 * 从左到右五个参数每个参数含意quchu
		 * int pageNo              --当前页数
		 * int pageSize            -- 每页显示的代办数量
		 * int recordCount         --代办总数
		 * int userId              --用户工号
		 * String[] conditions     --查询流程的条件,为字符串数组
		 *  
		 */
		//查询待办列表
//		WorkflowRequestInfo[] requestInfos = workflow.getToDoWorkflowRequestList(Integer.parseInt(pageNo), DpmConstants.workflowPageNumber, totalCount, codeToID, null);
		long startTime = System.currentTimeMillis();    //获取开始时间
		logger.info("开始时间"+startTime);
		weaver.workflow.webservices.WorkflowRequestInfo[] requestInfos = workflowService.getToDoWorkflowRequestList(Integer.parseInt(pageNo), DpmConstants.workflowPageNumber, totalCount, codeToID, null);
		long endTime = System.currentTimeMillis();    //获取结束时间
		logger.info("结束时间"+endTime);
		logger.info("代办列表 - 程序运行时间：" + (endTime - startTime) + "ms" + " 工号："+ userId);
		logger.info("");
		//工作流详情对应页面
		List<WorkflowPageInfo> pageInfoArray = pageService.pageInfomation();
		// 数据匹配处理
		listData = dealData(requestInfos, pageInfoArray);
		//获取工作流对应头像地址
		for(WorkflowListEntity workflow : listData){
			/*String createId = workflow.getRequestInfo().getCreatorId();
			if( !(createIds.contains(createId)) ){
				createIds.add(createId);
			}*/
			List<String> createId = new ArrayList<String>();
			//起草人id转工号
			String empcode = workflowService.getWorkflowUserCode(workflow.getRequestInfo().getCreatorId());
			//起草人工号
			createId.add(empcode);
			//获取该起草人头像地址
			List<NwfsPicPathEntity> entitys = new ArrayList<NwfsPicPathEntity>();
			entitys = picService.picturePaths(createId);
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
		return listData;
	}
	
	/**
	 * 拼接实体数据 返回给前端
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
		//拼接实体集
		List<WorkflowListEntity> listEntity = new ArrayList<WorkflowListEntity>();
		for (weaver.workflow.webservices.WorkflowRequestInfo info : requestInfoArray) {
			//ID转工号
			info = unoPeratorIdToUserID(info);
			//泛微待办实体
			weaver.workflow.webservices.WorkflowBaseInfo baseInfo = info.getWorkflowBaseInfo();
			//泛微工作流ID
			String workflowId = baseInfo.getWorkflowId();
			//循环页面对应表
			for (WorkflowPageInfo pageInfo : pageInfoArray) {
				if (workflowId.equals(pageInfo.getWorkflowId())) {
					//如果两个工作流ID相同
					WorkflowListEntity entity = new WorkflowListEntity();
					//页面地址
					entity.setPageAdress(pageInfo.getWorkflowPage());
					//实体
					entity.setRequestInfo(info);
					listEntity.add(entity);
				}
			}

		}
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
		int codeToId = workflowService.getUserIdByWorkCode(userId);
		//参数含议  从左到右三个参数   1、 请求id requestid  2、用户id userid  3、从相关id的工作流过来 fromrequestid 默认为0
		long startTime = System.currentTimeMillis();    //获取开始时间
		logger.info("开始时间"+startTime);
		weaver.workflow.webservices.WorkflowRequestInfo resultInfo = workflowService.getWorkflowRequest(requestId , codeToId, 0);
		long endTime = System.currentTimeMillis();    //获取结束时间
		logger.info("结束时间"+endTime);
		logger.info("工作流详情 - 程序运行时间：" + (endTime - startTime) + "ms" + " 工号：" + userId);
		logger.info("");
		//id转工号
		resultInfo = createIdToUserID(resultInfo);
		return resultInfo;
	}
		
	// createID转工号
	private weaver.workflow.webservices.WorkflowRequestInfo createIdToUserID(weaver.workflow.webservices.WorkflowRequestInfo requestInfo) {
		if(requestInfo == null) return null;
		String createId = requestInfo.getCreatorId();
		String userId = workflowService.getWorkflowUserCode(createId);
		requestInfo.setCreatorId(userId);
		return requestInfo;
	}
	//工作流提交
	@Override
	public String workflowSubmit(String userId, WeaverWorkflowInfo entity) throws RemoteException {
		int codeToId = workflowService.getUserIdByWorkCode(entity.getUserId());
		// 将前端传来的 工作流详情信息 由json转为实体
		weaver.workflow.webservices.WorkflowRequestInfo requestInfo = JSONObject.parseObject(entity.getWorkflowInfo(), weaver.workflow.webservices.WorkflowRequestInfo.class);
		//提交结果 
		String resultStirng = workflowService.submitWorkflowRequest(requestInfo, entity.getRequestId(), codeToId, entity.getSubmitType(), entity.getRemark());
		return resultStirng;
	}

	//工作流回退接口
	@Override
	public String workflowtUnagree(String userId, int requestId) throws RemoteException {
		int codeToId = workflowService.getUserIdByWorkCode(userId);
		/**
		 * param1:requestID
		 * param2:userId
		 */
		String result =  workflowService.doForceOver(requestId, codeToId);
		return result;
	}
	
	//我的工作流
	@Override
	public List<WorkflowListEntity> myWorkflowList(String userId, String status, String pageNo) throws RemoteException {
		//拼接结果集
		List<WorkflowListEntity> listData = new ArrayList<WorkflowListEntity>();
		// 工号转ID
		int codeToID = workflowService.getUserIdByWorkCode(userId);
		//待办总条数
		int totalCount = workflowService.getMyWorkflowRequestCount(codeToID, null);
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
			conditions[0] = " ( t1.currentnodetype = 1 or t1.currentnodetype = 2 ) ";
		}else {
			conditions[0] = " t1.currentnodetype = " + status;
		}
		////currentnodetype 即状态
		long startTime = System.currentTimeMillis();    //获取开始时间
		logger.info("开始时间"+startTime);
		weaver.workflow.webservices.WorkflowRequestInfo[] info = workflowService.getMyWorkflowRequestList(Integer.parseInt(pageNo),  DpmConstants.workflowPageNumber, totalCount, codeToID, conditions);
		long endTime = System.currentTimeMillis();    //获取结束时间
		logger.info("结束时间"+endTime);
		logger.error("我提交的 - 程序运行时间：" + (endTime - startTime) + "ms" + " status="+ status +" 工号："+ userId);
		logger.info("");
		//工作流详情对应页面
		List<WorkflowPageInfo> pageInfoArray = pageService.pageInfomation();
		// 数据匹配处理
		listData = dealData(info, pageInfoArray);
		return listData;
	}
	
	/**
	 * 我的已办理流程列表
	 */
	@Override
	public List<WorkflowListEntity> getHendledWorkflowList(String userId,String pageNo,String workflowStatus){
		//拼接结果集
		List<WorkflowListEntity> listData = new ArrayList<WorkflowListEntity>();
		weaver.workflow.webservices.WorkflowRequestInfo[] resultList = new weaver.workflow.webservices.WorkflowRequestInfo[]{};
		try {
			//工号
			int codeToID = workflowService.getUserIdByWorkCode(userId);
			//待办总条数
			int totalCount = workflowService.getHendledWorkflowRequestCount(codeToID, null);
			String[] conditions = new String[1];
			//  0-我批过的未完成的，1-我批过的（已经完成）
//			conditions[0] = " 	t2.iscomplete = " + workflowStatus;
			conditions[0] = " (t2.iscomplete = 0 or t2.iscomplete = 1)";
			//参数：当前页数、每页的分页数量、总条数、用户ID、查询流程的条件
			long startTime = System.currentTimeMillis();    //获取开始时间
			logger.info("开始时间"+startTime);
			resultList = workflowService.getHendledWorkflowRequestList(Integer.parseInt(pageNo),  DpmConstants.workflowPageNumber, totalCount, codeToID, conditions);
			long endTime = System.currentTimeMillis();    //获取结束时间
			logger.info("结束时间"+endTime);
			logger.error("我审批的 - 程序运行时间：" + (endTime - startTime) + "ms" + " 工号："+ userId);
			logger.info("");
			//工作流详情对应页面
			List<WorkflowPageInfo> pageInfoArray = pageService.pageInfomation();
			// 数据匹配处理
			listData = dealData(resultList, pageInfoArray);
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
			logger.error("附件解密失败>>>>", e);
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
		int codeToID = workflowService.getUserIdByWorkCode(userId);
		
		/**
		 * int userid,String operatedateStart, String operatedateend, String syscode,String[] conditions)
		 */
		int totalCount = workflowSearch.getHendledWorkflowRequestCountCops(codeToID, entity.getStartTime(), entity.getEndTime(), entity.getSysCode(), null);
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
		
		//1、pageNo不得为空 否则会报异常  2、开始时间和结束时间得有 否则查到的数据为空 3、sysCode必传  否则查到数据为空
		weaver.workflow.webservices.WorkflowRequestInfo[] infos = workflowSearch.getHendledWorkflowRequestListCops(Integer.parseInt(entity.getPageNo()), DpmConstants.workflowPageNumber, totalCount, codeToID, entity.getStartTime(), entity.getEndTime(), entity.getSysCode(), conditions);
		
		
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
			int codeToID = workflowService.getUserIdByWorkCode(userId);
			/**
			 * int userid,String operatedateStart, String operatedateend, String syscode,String[] conditions)
			 */
			//默认查询近三个月据
			
			Date now = new Date(); 
			Calendar calendar = Calendar.getInstance();  
	        calendar.setTime(now);  
	        calendar.add(Calendar.MONTH, -1);//1月前  
	        Date threeDaysAgo = calendar.getTime(); 
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			
	    	String endTime = dateFormat.format( now );
	        String startTime = dateFormat.format(threeDaysAgo);
			String sysCode = "";//默认查询所有工作流系统
			int totalCount = workflowSearch.getHendledWorkflowRequestCountCops(codeToID, startTime, endTime, "", null);

			
			String[] conditions = new String[1];
			if (text.matches("[\u4E00-\u9FA5]+")){
				//姓名或工作流名称：   正则表达式 纯中文
				System.out.println("输入的是姓名或者工作流名称");
				conditions[0] = " (h.lastname like '%" + text + "%'" + " or t1.requestname like '%" + text + "%')";
			}else if (text.matches("^\\d{6}$")){
				//工号： 正则表达式 6位纯数字
				System.out.println("输入的是工号");
				int creatorID = workflowService.getUserIdByWorkCode(text);
				//按起草人工号搜索
				conditions[0] =  " t1.creater = " + creatorID;
			}else if (text.matches("^[a-zA-Z]{1}[a-zA-Z0-9]*[0-9]+[a-zA-Z0-9]*") && text.length() > 10 && text.length() < 30){
				//工作流号 判断规则  1、以字线开头 2、 必须包含字母和数字  3、总长度在10-30之间
				System.out.println("输入的是工作流号");
				conditions[0] = " t1.requestmark = '" + text + "'";
			}else {
				System.out.println("搜索的不符合规则");
				return listData;
			}
			/*conditions[1] = " order by t1.createdate ";*/
			//1、pageNo不得为空 否则会报异常  2、开始时间和结束时间得有 否则查到的数据为空 3、sysCode必传  否则查到数据为空
			weaver.workflow.webservices.WorkflowRequestInfo[] infos = workflowSearch.getHendledWorkflowRequestListCops(1, totalCount, totalCount, codeToID, startTime, endTime, "", conditions);
			
			//工作流详情对应页面
			List<WorkflowPageInfo> pageInfoArray = pageService.pageInfomation();
			// 数据匹配处理
			listData = dealDataSearch(infos, pageInfoArray);
			return listData;
		}
	
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
		if (!StringUtils.isNotEmpty(unoperator)) return info;
		String[] creatorIds = unoperator.split(",");
		String empNames = "";
		for (int i = 0; i < creatorIds.length; i++) {
			//只截取前三位工号
			if (i>2) continue;
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
				empNames = empNames + "," + empName ;
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
		if (entity.getCreatorId() != null && !entity.getCreatorId().equals("")) {
			int creatorID = workflowService.getUserIdByWorkCode(entity.getCreatorId());
			//按起草人工号搜索
			conditionList.add(" t1.creater = " + creatorID);
		} 
		if (entity.getCreatorName() != null && !entity.getCreatorName().equals("")){
			//按起草人姓名搜索
			conditionList.add(" h.lastname like '%" + entity.getWfsName() + "%'");
		} 
		if (entity.getWfsStatus() != null && !entity.getWfsStatus().equals("")){
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
			conditionList.add(" t1.requestmark = '" + entity.getWfsMark() + "'");
		}
		if (entity.getWfsName() != null && !entity.getWfsName().equals("")){
			//按工作流名称搜索
			conditionList.add(" t1.requestname like '%" + entity.getWfsName() + "%'");
		}
		String[] conditions = conditionList.toArray(new String[conditionList.size()]);
		return conditions;
	}
	
	//删除工作流
	@Override
	public boolean workflowDelete(String userId, int requestId)
			throws RemoteException {
		//工号
		int codeToID = workflowService.getUserIdByWorkCode(userId);
		/**
		 * int requestid:工作流id
		 * int userid:工号转id
		 */
		boolean deleteResult = workflowService.deleteRequest(requestId, codeToID);
		return deleteResult;
	}

	//撤销工作流
	@Override
	public boolean workflowRevoke(int requestId, String userId)
			throws RemoteException {
		//工号
		int codeToID = workflowService.getUserIdByWorkCode(userId);

		/**
		 * int requestid:工作流id
		 * int userid:工号转id
		 */
//		boolean deleteResult = workflowService.doRetract(requestId, codeToID);
//		return deleteResult;
		return false;
		
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

}
