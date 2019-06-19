package com.deppon.dpm.doc.server.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.entity.AbnormalOrderEntity;
import com.deppon.dpm.doc.server.service.IDoubtfulExAuditService;
import com.deppon.dpm.doc.server.service.IPersonIDService;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.tongxunlu.server.service.IExternalMethodService;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.foss.framework.shared.encypt.base64.BASE64Decoder;

/**
 * 疑似异常审核
 * @author Administrator
 *
 */

public class DoubtfulExAuditAction extends BaseAction {

	/**
	 * 构造方法
	 */
	public DoubtfulExAuditAction(){
		super();
	}
	private static final Logger logger = LoggerFactory.getLogger(DoubtfulExAuditAction.class);
	
	private static final long serialVersionUID = 1L;
	
	private IDoubtfulExAuditService doubtfulExAuditService;
	//根据工号查询人员信息
	private IPersonIDService personIDService;
	//根据工号查询直属上级
	private IExternalMethodService externalMethodService;
	// 推送消息服务
	private IJPushNewService jPushNewService;
	
	private RedisService redisService;
	
	JSONObject jonum = new JSONObject();
	
	private static final int aa=10;
	public String userId;
	public String id;
	public String recordstate;
	private int pageNum ;
	private String subordinate ;
	private static String filePath = "/dpmfile/didirecord/";
	private String remark ;
	public String orderId;
	public String leadernum;
	public String userName;

	private String leaderId;

	
	/**
	 * 疑似异常转办功能
	 */
	@CookieNotCheckedRequired
	public void transferMethod(){
		try {
			String empCode = userId;//转办人工号
			EmployeeVO evo = externalMethodService.getLeaderInfo(empCode);
			/*String leaderCode = redisService.get(RedisService.DPM_DOC_LEADER_CODE_KEY + empCode);
			EmployeeVO evo = new EmployeeVO();
			if(leaderCode == null || leaderCode.trim().length() == 0){
				evo = externalMethodService.getLeaderInfo(empCode);
			}else{
				evo = externalMethodService.getEmpInfo(empCode);
			}*/
			String leadernum = "";//转办直属上级工号
			String leadernumName = "";//转办直属上级姓名
			if(evo != null){
				leadernum = evo.getEmpCode();
				leadernumName = evo.getEmpName();
				logger.info("其他公务转办直属上级>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",leadernum);
			}
			if(leadernum != null){
				logger.info("调用转办接口开始>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				int update = doubtfulExAuditService.transferMethod(userId, leadernum ,leadernumName);
				logger.info("调用转办接口结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",update);
				jonum.put("update", update);
			}
			jonum.put("msg", "success");
		} catch (Exception e) {
			logger.info("疑似异常转办发生异常>>>>>>>>>" + e.getMessage());
			jonum.put("errno", 1);
			jonum.put("errmsg", "疑似异常转办发生异常>>>>>>>>>" + e.getMessage());
		}
		// 返回页面数据
		writeToPage(jonum);
	}
	
	/**
	 * 后台修改审核人
	 */
	@CookieNotCheckedRequired
	public void transfer(){
		try {

			logger.info("疑似异常转办直属上级(后台)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",leaderId);

			if(leaderId != null){
				logger.info("调用转办接口开始(后台)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				EmployeeVO evo = externalMethodService.getEmpInfo(leaderId);
				String leaderName = evo.getEmpName();
				int update = doubtfulExAuditService.transferMethod(userId, leaderId ,leaderName);
				logger.info("调用转办接口结束(后台)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",update);
				jonum.put("update", update);
			}
			jonum.put("msg", "success");
		} catch (Exception e) {
			logger.info("疑似异常转办发生异常(后台)>>>>>>>>>" + e.getMessage());
			jonum.put("errno", 1);
			jonum.put("errmsg", "疑似异常转办发生异常(后台)>>>>>>>>>" + e.getMessage());
		}
		// 返回页面数据
		writeToPage(jonum);
	}
	
	
	/**
	 * 用户查询审核结果(因公因私)
	 * 
	 * 员工（我提交）审核结果筛选
	 */
	@CookieNotCheckedRequired
	public void userQueryMethod(){
		
		int beginNum = getRecordIndex();// 定位请求的首条数据库位置
		
		logger.info("用户查询审核结果(用户筛选)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<AbnormalOrderEntity> otherEntityList = doubtfulExAuditService.auditedQueryMethod(userId, recordstate);
		List<AbnormalOrderEntity> newList = new ArrayList<AbnormalOrderEntity> ();
		for(AbnormalOrderEntity temp : otherEntityList){
			if(temp.getRemark()!= null){
				if(remark.equals(temp.getRemark()) && recordstate.equals(temp.getRecordstate())){
					newList.add(temp);
				}
			}
		}
		List<AbnormalOrderEntity> resultlist = doubtfulExAuditService.userQueryMethod(userId, recordstate, remark, beginNum, aa);
		logger.info("用户查询审核结果(用户筛选)结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<AbnormalOrderEntity> newresult = new ArrayList<AbnormalOrderEntity> ();
		String[] aa = {};
		for(AbnormalOrderEntity temp : resultlist){
			if(temp.getRecordpicArray()== null){
				temp.setRecordpicArray(aa);
			}else{
				String recordpic = temp.getRecordpic();
				String[] recordpicArray = recordpic.split(",");
				temp.setRecordpicArray(recordpicArray);
			}
			newresult.add(temp);
		}
		List<AbnormalOrderEntity> abnoNewList = pictureProcess(newresult);
		jonum.put("pageSize", getTotalPage(newList));//返回总页数
		jonum.put("msg", "success");
		jonum.put("List", abnoNewList);
		// 返回页面数据
		writeToPage(jonum);
		logger.debug("success");
	}
	/**
	 * 员工筛选
	 * 
	 */
	@CookieNotCheckedRequired
	public void userQueryInitial(){
		
		int beginNum = getRecordIndex();// 定位请求的首条数据库位置
		
		logger.info("用户查询审核结果(用户筛选)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<AbnormalOrderEntity> otherEntityList = doubtfulExAuditService.auditedQueryMethod(userId, recordstate);
		List<AbnormalOrderEntity> newList = new ArrayList<AbnormalOrderEntity> ();
		for(AbnormalOrderEntity temp : otherEntityList){
			if(temp.getRemark()!= null && ("0".equals(temp.getRecordstate())||"3".equals(temp.getRecordstate()))){
				newList.add(temp);
			}
		}
		List<AbnormalOrderEntity> newresult = new ArrayList<AbnormalOrderEntity> ();
		List<AbnormalOrderEntity> resultlist = doubtfulExAuditService.auditedQuertInitial(userId, beginNum, aa);
		logger.info("用户查询审核结果(用户筛选)结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		String[] aa = {};
		for(AbnormalOrderEntity temp : resultlist){
			try{
				//逾期时间
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String nowdatetime = format.format(System.currentTimeMillis());
				Long beginL = format.parse(temp.getTaxidate()).getTime();
				Long endL = format.parse(nowdatetime).getTime();
				Long day = (endL - beginL)/86400000;
				temp.setDef2(String.valueOf(day)==null?"0":String.valueOf(day));
				
				if(temp.getRecordpicArray()== null){
					temp.setRecordpicArray(aa);
				}else{
					String recordpic = temp.getRecordpic();
					String[] recordpicArray = recordpic.split(",");
					temp.setRecordpicArray(recordpicArray);
				}
			}catch(Exception ex){
				logger.info("判断逾期时间异常>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				ex.getMessage();
			}
			newresult.add(temp);
		}
		
		List<AbnormalOrderEntity> abnoNewList = pictureProcess(newresult);
		jonum.put("pageSize", getTotalPage(newList));//返回总页数
		jonum.put("msg", "success");
		jonum.put("List", abnoNewList);
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
		List<AbnormalOrderEntity> otherlist = doubtfulExAuditService.auditedQueryMethod(userId, recordstate);
		List<AbnormalOrderEntity> newList = new ArrayList<AbnormalOrderEntity> ();
		for(AbnormalOrderEntity temp : otherlist){
			if(temp.getRemark()!= null && ("1".equals(temp.getRecordstate())||"2".equals(temp.getRecordstate()))){
				newList.add(temp);
			}
		}
		//查询出已审核数据
		List<AbnormalOrderEntity> resultlist = doubtfulExAuditService.empQueryResult(userId, recordstate, beginNum, aa);
		logger.info("用户查询审核结果(用户筛选)完成>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<AbnormalOrderEntity> newresult = new ArrayList<AbnormalOrderEntity> ();
		String[] aa = {};
		for(AbnormalOrderEntity temp : resultlist){
			if(temp.getRecordpicArray()== null){
				temp.setRecordpicArray(aa);
			}else{
				String recordpic = temp.getRecordpic();
				String[] recordpicArray = recordpic.split(",");
				temp.setRecordpicArray(recordpicArray);
			}
			
			newresult.add(temp);
		}
		
		List<AbnormalOrderEntity> abnoNewList = pictureProcess(newresult);
		jonum.put("pageSize", getTotalPage(newList));//返回总页数
		jonum.put("msg", "success");
		jonum.put("List", abnoNewList);
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
		List<AbnormalOrderEntity> allleaderlist = doubtfulExAuditService.leaderQueryMethod(userId, recordstate);
		List<AbnormalOrderEntity> newList = new ArrayList<AbnormalOrderEntity> ();
		for(AbnormalOrderEntity temp : allleaderlist){
			if(temp.getRemark()!= null && ("0".equals(temp.getRecordstate())||"3".equals(temp.getRecordstate()))){
				newList.add(temp);
			}
		}
		
		//查询出待审核数据
		List<AbnormalOrderEntity> otherleaderlist = doubtfulExAuditService.auditedMinMethod(userId, recordstate, beginNum, aa);
		logger.info("管理族群查询未审核数据(管理未审核)完成>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<AbnormalOrderEntity> newresult = new ArrayList<AbnormalOrderEntity> ();
		String[] aa = {};
		for(AbnormalOrderEntity temp : otherleaderlist){
			try{
				//逾期时间
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String nowdatetime = format.format(System.currentTimeMillis());
				Long beginL = format.parse(temp.getTaxidate()).getTime();
				Long endL = format.parse(nowdatetime).getTime();
				Long day = (endL - beginL)/86400000;
				temp.setDef2(String.valueOf(day)==null?"":String.valueOf(day));
				
				if(temp.getRecordpicArray()== null){
					temp.setRecordpicArray(aa);
				}else{
					String recordpic = temp.getRecordpic();
					String[] recordpicArray = recordpic.split(",");
					temp.setRecordpicArray(recordpicArray);
				}
			}catch(Exception ex){
				logger.info("判断逾期时间异常>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				ex.getMessage();
			}
			newresult.add(temp);
		}
		
		List<AbnormalOrderEntity> abnoNewList = pictureProcess(newresult);
		jonum.put("pageSize", getTotalPage(newList));//返回总页数
		jonum.put("msg", "success");
		jonum.put("List", abnoNewList);
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
		List<AbnormalOrderEntity> allleaderlist = doubtfulExAuditService.leaderQueryMethod(userId, recordstate);
		List<AbnormalOrderEntity> newList = new ArrayList<AbnormalOrderEntity> ();
		for(AbnormalOrderEntity temp : allleaderlist){
			if(temp.getRemark()!= null && ("1".equals(temp.getRecordstate())||"2".equals(temp.getRecordstate()))){
				newList.add(temp);
			}
		}
		//查询出已审核数据
		List<AbnormalOrderEntity> resultlist = doubtfulExAuditService.auditedMethodResult(userId, recordstate, beginNum, aa);
		logger.info("管理族群查询审核结果(管理筛选)完成>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<AbnormalOrderEntity> newresult = new ArrayList<AbnormalOrderEntity> ();
		String[] aa = {};
		for(AbnormalOrderEntity temp : resultlist){
			if(temp.getRecordpicArray()== null){
				temp.setRecordpicArray(aa);
			}else{
				String recordpic = temp.getRecordpic();
				String[] recordpicArray = recordpic.split(",");
				temp.setRecordpicArray(recordpicArray);
			}
			newresult.add(temp);
		}
		
		List<AbnormalOrderEntity> abnoNewList = pictureProcess(newresult);
		jonum.put("pageSize", getTotalPage(newList));//返回总页数
		jonum.put("msg", "success");
		jonum.put("List", abnoNewList);
		// 返回页面数据
		writeToPage(jonum);
		logger.debug("success");
		
	}
	/**
	 * 其他公务管理族群点击我审核更新
	 */
	@CookieNotCheckedRequired
	public void auditedMethodUpdate(){
		int update = doubtfulExAuditService.auditedMethodUpdate(id, recordstate);
		if(update==1){
			jonum.put("msg", "success");
			jonum.put("update", update);
		}else{
			jonum.put("msg", "error");
			jonum.put("update", update);
		}
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
		List<AbnormalOrderEntity> allleaderlist = doubtfulExAuditService.allAuditedDataScreen(userId, recordstate, subordinate);
		//查询出待审核数据
		List<AbnormalOrderEntity> newList = new ArrayList<AbnormalOrderEntity> ();
		for(AbnormalOrderEntity temp : allleaderlist){
			if(temp.getRemark()!= null){
				if(remark.equals(temp.getRemark()) && recordstate.equals(temp.getRecordstate())){
					newList.add(temp);
				}
			}
		}
		List<AbnormalOrderEntity> otherleaderlist = doubtfulExAuditService.auditedDataScreen(userId, recordstate, subordinate, beginNum, aa);
		logger.info("管理族群查询未审核数据(管理未审核)完成>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<AbnormalOrderEntity> newresult = new ArrayList<AbnormalOrderEntity> ();
		String[] aa = {};
		for(AbnormalOrderEntity temp : otherleaderlist){
			if(remark.equals(temp.getRemark())){
				if(temp.getRecordpicArray()== null){
					temp.setRecordpicArray(aa);
				}else{
					String recordpic = temp.getRecordpic();
					String[] recordpicArray = recordpic.split(",");
					temp.setRecordpicArray(recordpicArray);
				}
				newresult.add(temp);
			}
		}
		
		List<AbnormalOrderEntity> abnoNewList = pictureProcess(newresult);
		jonum.put("pageSize", getTotalPage(newList));//返回总页数
		jonum.put("msg", "success");
		jonum.put("List", abnoNewList);
		// 返回页面数据
		writeToPage(jonum);
		logger.debug("success");
		
	}
	
	/**
	 * feedback
	 * 疑似异常用户反馈接口
	 */
	@CookieNotCheckedRequired
	public void userFeedback(){
		int update = doubtfulExAuditService.auditedUpdateById(getvalue("id"), getvalue("comment"),getvalue("recordpic"));
		if(update==1){
			jonum.put("msg", "success");
			jonum.put("update", update);
		}else{
			jonum.put("msg", "error");
			jonum.put("update", update);
		}
		
		// 返回页面数据
		writeToPage(jonum);
		logger.debug("success");
		
	}
	
	/**
	 * 前台取值处理方法
	 * @return the json
	 */
	public String getvalue(String key) {
		Object[] values;
		String value="";
		HttpServletRequest request = ServletActionContext.getRequest();
		if(key == "recordpic"){
			values = (Object[]) request.getParameterMap().get("recordpic[]");
		}else{
			values = (Object[]) request.getParameterMap().get(key);
		}
		try{
			if(values != null){
				if(values.length!=0){
					if(key == "recordpic"){
						for(int i=0;i<values.length;i++){
							//前台获取image
							String recordpic = values[i].toString();//
							//得到文件格式
							String spcode = recordpic.substring(recordpic.lastIndexOf("."));
//							//去掉后缀
							String imagecode = recordpic.substring(0,recordpic.lastIndexOf("."));
							StringBuilder sb = new StringBuilder();
							// 文件名用UUID防止重复
							sb.append(UUID.randomUUID().toString());
							//文件名fileName
							String fileName = sb.toString()+spcode;
							byte[] buffer = new BASE64Decoder().decodeBuffer(imagecode.replaceAll("(?s)'.*'", "").replaceAll(" ", "+"));
							OutputStream out = null;
							out = new FileOutputStream(new File(filePath,fileName));
							out.write(buffer);
							if(i == values.length-1){
								value = value + fileName;
							}else{
								value = value + fileName+",";
							}
						}
					}else{
						value = values[0].toString();
					}
				}
			}
		}catch (Exception e) {
			e.getMessage();
			logger.error("保存图片发生错误 ", e);
		}
		return value;
	}
	/**
	 * 获取总页数
	 * @return
	 */
	public int getTotalPage(List<AbnormalOrderEntity> list) {
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
	
	/**
	 * 反馈图片处理类
	 */
	public List<AbnormalOrderEntity> pictureProcess(List<AbnormalOrderEntity> abnoList){
		
		List<AbnormalOrderEntity> abnoNewList = new ArrayList<AbnormalOrderEntity>();
		for(AbnormalOrderEntity temp : abnoList){
			String pciture = temp.getRecordpic();
			if(pciture != null && !"".equals(pciture)){
				String[] picArray = pciture.split(",");	
				temp.setRecordpicArray(picArray);
				abnoNewList.add(temp);
			}else{
				abnoNewList.add(temp);
			}
		}
		//处理会议图片
		for(AbnormalOrderEntity temp : abnoNewList){
			String picture = temp.getMeetingPic();
			if(picture != null && !"".equals(picture)){
				String[] mpicArray = picture.split(",");	
				temp.setMeetingPicArray(mpicArray);
				//abnoNewList.add(temp);
			}else{
				//abnoNewList.add(temp);
				String[] ma = {};
				temp.setMeetingPicArray(ma);	
			}
		}
		return abnoNewList;
	}
	
	/**
	 * @return the doubtfulExAuditService
	 */
	public IDoubtfulExAuditService getDoubtfulExAuditService() {
		return doubtfulExAuditService;
	}
	/**
	 * @param doubtfulExAuditService the doubtfulExAuditService to set
	 */
	public void setDoubtfulExAuditService(
			IDoubtfulExAuditService doubtfulExAuditService) {
		this.doubtfulExAuditService = doubtfulExAuditService;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the recordstate
	 */
	public String getRecordstate() {
		return recordstate;
	}

	/**
	 * @return the pageNum
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param recordstate the recordstate to set
	 */
	public void setRecordstate(String recordstate) {
		this.recordstate = recordstate;
	}

	/**
	 * @param pageNum the pageNum to set
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
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
	 * @return the filePath
	 */
	public static String getFilePath() {
		return filePath;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public static void setFilePath(String filePath) {
		DoubtfulExAuditAction.filePath = filePath;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
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
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public String getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}

	public RedisService getRedisService() {
		return redisService;
	}

	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}
	
	
	
}
