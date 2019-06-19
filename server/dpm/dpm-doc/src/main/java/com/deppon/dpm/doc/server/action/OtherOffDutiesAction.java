package com.deppon.dpm.doc.server.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.entity.AbnormalOrderEntity;
import com.deppon.dpm.doc.server.entity.OtherOffDutiesEntity;
import com.deppon.dpm.doc.server.service.IDoubtfulExAuditService;
import com.deppon.dpm.doc.server.service.IOtherOffDutiesService;
import com.deppon.dpm.doc.server.service.IPersonIDService;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.service.IExternalMethodService;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.sensorsdata.analytics.javasdk.SensorsAnalytics;
import com.sensorsdata.analytics.javasdk.exceptions.InvalidArgumentException;

/**
 * 其他公务审核
 * @author Administrator
 *
 */
public class OtherOffDutiesAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(OtherOffDutiesAction.class);
	private IDoubtfulExAuditService doubtfulExAuditService;
	
	private IOtherOffDutiesService otherOffDutiesService;
	//根据工号查询人员信息
	private IPersonIDService personIDService;
	//根据工号查询直属上级
	private IExternalMethodService externalMethodService;
	// 推送消息服务
	private IJPushNewService jPushNewService;
	JSONObject jonum = new JSONObject();
	/**
	 * 构造方法
	 */
	public OtherOffDutiesAction(){
		super();
	}
	private static final int aa=10;
	public String userId;
	public String id;
	public String recordstate;
	private int pageNum = 0;
	private String subordinate ;
	public String orderId;
	public String leadernum;
	public String userName;

	private String leaderId;
	
	private String reason;
	private float amount;
	
	// 从神策分析获取的数据接收的 URL
	final String SA_SERVER_URL = 
			"http://39.105.252.204:8106/sa?project=default";
	// 使用 Debug 模式，并且导入 Debug 模式下所发送的数据 
	final boolean SA_WRITE_DATA = true;

	// 使用 DebugConsumer 初始化 SensorsAnalytics
	final SensorsAnalytics sa = new SensorsAnalytics(
			new SensorsAnalytics.DebugConsumer(SA_SERVER_URL, SA_WRITE_DATA)); 
	

	
	/*
	 * 移动办公消息接口（其他公务。疑似异常）数据
	 */
	@CookieNotCheckedRequired
	public void allMethod(){
		//疑似异常数据（待审核，带我审核）
		List<AbnormalOrderEntity> exList = doubtfulExAuditService.allList(userId);
		//其他公务数据（待审核，带我审核）
		List<OtherOffDutiesEntity> otherList = otherOffDutiesService.allList(userId);
		
		Map<String , Object> resultMap = new HashMap<String , Object>();
		resultMap.put("其他公务", otherList);
		resultMap.put("疑似异常", exList);
		jonum.put("map", resultMap);
		writeToPage(jonum);
//		return resultMap;
	}
	
	/**
	 * 用户查询审核结果(因公因私)
	 * 
	 * 其他公务员工点击默认显示数据
	 */
	@CookieNotCheckedRequired
	public void userQueryMethod(){
		
		int beginNum = getRecordIndex();// 定位请求的首条数据库位置
		
		logger.info("用户查询审核结果(用户筛选)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<OtherOffDutiesEntity> otherEntityList = otherOffDutiesService.auditedQueryMethod(userId, recordstate);
		List<OtherOffDutiesEntity> otherNewList = new ArrayList<OtherOffDutiesEntity>();
		for(OtherOffDutiesEntity temp : otherEntityList){
			if(temp.getRemark()!= null){
				if(recordstate.equals(temp.getRecordstate())){
					otherNewList.add(temp);
				}
			}
		}
		
		List<OtherOffDutiesEntity> resultlist = otherOffDutiesService.userQueryMethod(userId, recordstate, beginNum, aa);
		logger.info("用户查询审核结果(用户筛选)结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<OtherOffDutiesEntity> newresult = new ArrayList<OtherOffDutiesEntity> ();
		for(OtherOffDutiesEntity temp : resultlist){
			try{
				//逾期时间
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String nowdatetime = format.format(System.currentTimeMillis());
				Long beginL = format.parse(temp.getTaxidate()).getTime();
				Long endL = format.parse(nowdatetime).getTime();
				Long day = (endL - beginL)/86400000;
				temp.setDef2(String.valueOf(day)==null?"":String.valueOf(day));
				
			}catch(Exception ex){
				logger.info("判断逾期时间异常>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				ex.getMessage();
			}
			newresult.add(temp);
		}
		jonum.put("pageSize", getTotalPage(otherNewList));//返回总页数
		jonum.put("msg", "success");
		jonum.put("List", newresult);
		// 返回页面数据
		writeToPage(jonum);
		logger.debug("success");
	}
	
	/**
	 * 部门管理组群查询审核结果（管理族群已审核数据）
	 */
	@CookieNotCheckedRequired
	public void leaderQueryMethod(){
		int beginNum = getRecordIndex();// 定位请求的首条数据库位置
		logger.info("管理族群查询审核结果(管理筛选)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<OtherOffDutiesEntity> otherleaderlist = otherOffDutiesService.leaderQueryResult(userId, recordstate);
		List<OtherOffDutiesEntity> otherNewList = new ArrayList<OtherOffDutiesEntity>();
		for(OtherOffDutiesEntity temp : otherleaderlist){
			if(temp.getRemark()!= null){
				if("1".equals(temp.getRecordstate()) || "2".equals(temp.getRecordstate())){
					otherNewList.add(temp);
				}
			}
		}
		//查询出已审核数据
		List<OtherOffDutiesEntity> resultlist = otherOffDutiesService.leaderQueryMethod(userId, recordstate, beginNum, aa);
		logger.info("管理族群查询审核结果(管理筛选)完成>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		jonum.put("pageSize", getTotalPage(otherNewList));//返回总页数
		jonum.put("msg", "success");
		jonum.put("List", resultlist);
		// 返回页面数据
		writeToPage(jonum);
		logger.debug("success");
		
	}
	
	/**
	 * 其他公务员工点击，查询审核结果数据
	 */
	@CookieNotCheckedRequired
	public void auditedQueryMethod(){
		int beginNum = getRecordIndex();// 定位请求的首条数据库位置
		logger.info("用户查询审核结果(用户筛选)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<OtherOffDutiesEntity> otherlist = otherOffDutiesService.auditedQueryMethod(userId, recordstate);
		List<OtherOffDutiesEntity> otherNewList = new ArrayList<OtherOffDutiesEntity>();
		for(OtherOffDutiesEntity temp : otherlist){
			if(temp.getRemark()!= null){
				if("1".equals(temp.getRecordstate()) || "2".equals(temp.getRecordstate())){
					otherNewList.add(temp);
				}
			}
		}
		//查询出已审核数据
		List<OtherOffDutiesEntity> resultlist = otherOffDutiesService.empQueryResult(userId, recordstate, beginNum, aa);
		logger.info("用户查询审核结果(用户筛选)完成>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		jonum.put("pageSize", getTotalPage(otherNewList));//返回总页数
		jonum.put("msg", "success");
		jonum.put("List", resultlist);
		// 返回页面数据
		writeToPage(jonum);
		logger.debug("success");
	}
	
	/**
	 * 其他公务管理族群点击我审核，默认带出‘待我审核’数据
	 */
	@CookieNotCheckedRequired
	public void auditedMinMethod(){
		int beginNum = getRecordIndex();// 定位请求的首条数据库位置
		logger.info("管理族群查询未审核数据(管理未审核)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<OtherOffDutiesEntity> allleaderlist = otherOffDutiesService.leaderQueryResult(userId, recordstate);
		
		List<OtherOffDutiesEntity> otherNewList = new ArrayList<OtherOffDutiesEntity>();
		for(OtherOffDutiesEntity temp : allleaderlist){
			if(temp.getRemark()!= null){
				if(recordstate.equals(temp.getRecordstate())){
					otherNewList.add(temp);
				}
			}
		}
		
		//查询出待审核数据
		List<OtherOffDutiesEntity> otherleaderlist = otherOffDutiesService.auditedMinMethod(userId, recordstate, beginNum, aa);
		
		List<OtherOffDutiesEntity> newresult = new ArrayList<OtherOffDutiesEntity> ();
		for(OtherOffDutiesEntity temp : otherleaderlist){
			try{
				//逾期时间
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String nowdatetime = format.format(System.currentTimeMillis());
				Long beginL = format.parse(temp.getTaxidate()).getTime();
				Long endL = format.parse(nowdatetime).getTime();
				Long day = (endL - beginL)/86400000;
				temp.setDef2(String.valueOf(day)==null?"":String.valueOf(day));
				
			}catch(Exception ex){
				logger.info("判断逾期时间异常>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				ex.getMessage();
			}
			newresult.add(temp);
		}
		
		logger.info("管理族群查询未审核数据(管理未审核)完成>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		jonum.put("pageSize", getTotalPage(otherNewList));//返回总页数
		jonum.put("msg", "success");
		jonum.put("List", newresult);
		// 返回页面数据
		writeToPage(jonum);
		logger.debug("success");
		
	}
	
	/**
	 * 管理族群我已审核数据筛选
	 */
	@CookieNotCheckedRequired
	public void auditedDataScreen(){
		int beginNum = getRecordIndex();// 定位请求的首条数据库位置
		logger.info("管理族群查询未审核数据(管理未审核)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<OtherOffDutiesEntity> allleaderlist = otherOffDutiesService.allAuditedDataScreen(userId, recordstate, subordinate);
		//查询出待审核数据
		List<OtherOffDutiesEntity> otherleaderlist = otherOffDutiesService.auditedDataScreen(userId, recordstate, subordinate, beginNum, aa);
		logger.info("管理族群查询未审核数据(管理未审核)完成>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		jonum.put("pageSize", getTotalPage(allleaderlist));//返回总页数
		jonum.put("msg", "success");
		jonum.put("List", otherleaderlist);
		// 返回页面数据
		writeToPage(jonum);
		logger.debug("success");
		
	}
	
	/**
	 * 其他公务管理族群点击我审核更新
	 */
	@CookieNotCheckedRequired
	public void auditedMethodUpdate(){
		
		int update = otherOffDutiesService.auditedMethodUpdate(id, recordstate);
		
		// 用户的 Distinct Id
		String distinctId = userId;			
		Map<String, Object> properties = new HashMap<String, Object>();
		//订单id
		properties.put("trip_orderID", orderId);
		//订单金额
		properties.put("trip_order_amount", amount);
		//用车事由
		properties.put("trip_reason", reason);
		//因公因私用车  1  因私  2因公
		properties.put("trip_public_or_private", "");
		if(recordstate.equals("1")){
			properties.put("trip_public_or_private", "因私");
		}else if(recordstate.equals("2")){
			properties.put("trip_public_or_private", "因公");
		}
		
		// 记录用户浏览商品事件
		try {
			sa.track(distinctId, true, "app_trip_review_result", properties);
		} catch (InvalidArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 刷新一下，让埋点数据落到指定目录文件中
	    sa.flush();
		
		if(update==1){
			jonum.put("msg", "success");
			jonum.put("update", update);
		}else{
			jonum.put("msg", "error");
			jonum.put("update", update);
		}
		// 程序结束前，停止神策分析 SDK 所有服务
	    sa.shutdown();
		// 返回页面数据
		writeToPage(jonum);
		logger.debug("success");
	}

	/**
	 * 其他公务转办功能
	 */
	@CookieNotCheckedRequired
	public void transferMethod(){
		try{
			String empCode = userId;//转办人工号
			EmployeeVO evo = externalMethodService.getLeaderInfo(empCode);
			String leadernum = "";//转办直属上级工号
			String leadernumName = "";//转办直属上级姓名
			if(evo != null){
				leadernum = evo.getEmpCode();
				leadernumName = evo.getEmpName();
				logger.info("其他公务转办直属上级>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",leadernum);
			}
			if(leadernum != null){
				logger.info("调用转办接口开始>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				int update = otherOffDutiesService.transferMethod(userId, leadernum ,leadernumName);
				logger.info("调用转办接口结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",update);
				jonum.put("update", update);
			}
			
			jonum.put("msg", "success");
		} catch (Exception e) {
			logger.info("其他公务转办发生异常>>>>>>>>>" + e.getMessage());
			jonum.put("errno", 1);
			jonum.put("errmsg", "其他公务转办发生异常>>>>>>>>>" + e.getMessage());
		}
		// 返回页面数据
		writeToPage(jonum);
	}
	
	/**
	 * 后台修改审核人
	 */
	@CookieNotCheckedRequired
	public void transfer(){
		try{
			logger.info("其他公务转办直属上级(后台)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",leaderId);
            System.out.println(ServletActionContext.getRequest().getMethod());
			if(leaderId != null){
				logger.info("调用转办接口开始(后台)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				EmployeeVO evo = externalMethodService.getEmpInfo(leaderId);
				String leaderName = evo.getEmpName();
				int update = otherOffDutiesService.transferMethod(userId, leaderId ,leaderName);
				logger.info("调用转办接口结束(后台)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",update);			
				jonum.put("update", update);
			}
			
			jonum.put("msg", "success");
		} catch (Exception e) {
			logger.info("其他公务转办发生异常(后台)>>>>>>>>>" + e.getMessage());
			jonum.put("errno", 1);
			jonum.put("errmsg", "其他公务转办发生异常(后台)>>>>>>>>>" + e.getMessage());
		}
		// 返回页面数据
		writeToPage(jonum);
	}
	
	/**
	 * @return the otherOffDutiesService
	 */
	public IOtherOffDutiesService getOtherOffDutiesService() {
		return otherOffDutiesService;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @return the recordstate
	 */
	public String getRecordstate() {
		return recordstate;
	}

	/**
	 * @param otherOffDutiesService the otherOffDutiesService to set
	 */
	public void setOtherOffDutiesService(
			IOtherOffDutiesService otherOffDutiesService) {
		this.otherOffDutiesService = otherOffDutiesService;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @param recordstate the recordstate to set
	 */
	public void setRecordstate(String recordstate) {
		this.recordstate = recordstate;
	}

	/**
	 * @return the pageNum
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * @param pageNum the pageNum to set
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the subordinate
	 */
	public String getSubordinate() {
		return subordinate;
	}
	/**
	 * @param subordinate the subordinate to set
	 */
	public void setSubordinate(String subordinate) {
		this.subordinate = subordinate;
	}
	/**
	 * @return the personIDService
	 */
	public IPersonIDService getPersonIDService() {
		return personIDService;
	}
	/**
	 * @return the externalMethodService
	 */
	public IExternalMethodService getExternalMethodService() {
		return externalMethodService;
	}
	/**
	 * @param personIDService the personIDService to set
	 */
	public void setPersonIDService(IPersonIDService personIDService) {
		this.personIDService = personIDService;
	}
	/**
	 * @param externalMethodService the externalMethodService to set
	 */
	public void setExternalMethodService(
			IExternalMethodService externalMethodService) {
		this.externalMethodService = externalMethodService;
	}
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the jPushNewService
	 */
	public IJPushNewService getjPushNewService() {
		return jPushNewService;
	}
	/**
	 * @param jPushNewService the jPushNewService to set
	 */
	public void setjPushNewService(IJPushNewService jPushNewService) {
		this.jPushNewService = jPushNewService;
	}
	public IDoubtfulExAuditService getDoubtfulExAuditService() {
		return doubtfulExAuditService;
	}
	public void setDoubtfulExAuditService(
			IDoubtfulExAuditService doubtfulExAuditService) {
		this.doubtfulExAuditService = doubtfulExAuditService;
	}
	
	/**
	 * @return the leadernum
	 */
	public String getLeadernum() {
		return leadernum;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param leadernum the leadernum to set
	 */
	public void setLeadernum(String leadernum) {
		this.leadernum = leadernum;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取总页数
	 * @return
	 */
	public int getTotalPage(List<OtherOffDutiesEntity> list) {
		if (list == null) {
			return 0;
		}
		if (list.size() % aa == 0) {
			return list.size() / aa;
		}
		else {
			return list.size() / aa + 1;
		}
	}
	/**
	 * 当前页首条在数据库里的位置
	 * @return
	 */
	public int getRecordIndex() {
		return (pageNum - 1) * aa;
	}

	public String getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
}
