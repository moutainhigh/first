package com.deppon.dpm.doc.server.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.entity.AbnormalOrderEntity;
import com.deppon.dpm.doc.server.entity.OtherOffDutiesEntity;
import com.deppon.dpm.doc.server.service.IDoubtfulExAuditService;
import com.deppon.dpm.doc.server.service.IKeepOnRecordService;
import com.deppon.dpm.doc.server.service.IOtherOffDutiesService;
import com.deppon.dpm.doc.server.vo.DiDiRecordVO;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.service.IExternalMethodService;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

/**
 * 我的备案进页面默认带出数据
 * 1.用户权限
 * 2.我的备案待审核数据
 * 3.报销备案待审核条数，其他公务待审核条数，疑似异常审核待审核条数
 * 4.如果是管理族群，需要带出其他公务待我审核数据，疑似异常待我审核数据
 * 
 * @author Administrator
 *
 */

public class RecordExHandAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(RecordExHandAction.class);
	//备案数据查询接口
	private IKeepOnRecordService keepOnRecordService;
	//其他公务数据查询接口
	private IOtherOffDutiesService otherOffDutiesService;
	//判断是否为管理族群
	private IExternalMethodService externalMethodService;
	//疑似异常
	private IDoubtfulExAuditService doubtfulExAuditService;
	
	private static final int aa=10;
	
	private String userId;
	/**
	 * 带出默认未审核数据
	 * @author Administrator
	 *
	 */
	@CookieNotCheckedRequired
	public void findLevelPerson(){
		
		JSONObject jonum = new JSONObject();
		logger.info("<<<<<<<<<<根据用户工号查找我的备案数据开始>>>>>>>>>>>");
		//查询该用户全部数据
		List<DiDiRecordVO> list=keepOnRecordService.queryKeepRecordById(userId);
		//显示未审核数据的条数
		List<DiDiRecordVO> unauditedList=new ArrayList<DiDiRecordVO>();
		//组装默认显实的10条数据
		List<DiDiRecordVO> resultlist=new ArrayList<DiDiRecordVO>();
		//显示未审核数据的条数
		for(DiDiRecordVO temp : list){
			if(temp.getRecordstate().equals("0")){
				unauditedList.add(temp);
			}
		}
		//组装默认显实的10条数据
		for(int i=0;i<10;i++){
			if(list.size()>i && list.get(i).getRecordstate().equals("0")){
				DiDiRecordVO recordco = new DiDiRecordVO();
				recordco.setAmount(list.get(i).getAmount()==null?"":list.get(i).getAmount());
				recordco.setCarremark(list.get(i).getCarremark()==null?"":list.get(i).getCarremark());
				recordco.setComment(list.get(i).getComment()==null?"":list.get(i).getComment());
				recordco.setDept(list.get(i).getDept()==null?"":list.get(i).getDept());
				recordco.setFromName(list.get(i).getFromName()==null?"":list.get(i).getFromName());
				recordco.setRecordpic(list.get(i).getRecordpic()==null?"":list.get(i).getRecordpic());
				recordco.setUserPic(list.get(i).getUserPic()==null?"":list.get(i).getUserPic());
				recordco.setTaxidate(list.get(i).getTaxidate()==null?"":list.get(i).getTaxidate());
				recordco.setRecordtime(list.get(i).getRecordtime()==null?"":list.get(i).getRecordtime());
				resultlist.add(recordco);
			}
		}
		logger.info("<<<<<<<<<<组装备案默认显示备案数据结束>>>>>>>>>>>");
		String levelmsg = findLevelPerson(userId);//判断用户权限
		//其他公务待审核数据条数：
		int othersize = auditedQueryMethod();
		//其他公务待我审核数据条数（管理族群）：
		int otherleadersize = auditedMinMethod();
		//疑似异常待我审核数据条数（员工）：
		int erruser = auditederroeMethod();
		//疑似异常待我审核数据条数（管理族群）：
		int errleader = auditedLeaderMethod();
		if(levelmsg=="1"){
			jonum.put("leaderOtherListnum", otherleadersize);//其他公务待审核条数（管理族群）
			jonum.put("leaderExAuditnum", errleader);//疑似异常待审核条数（管理族群）
		}
		jonum.put("recordListnum", unauditedList.size());//我的备案待审核条数
		jonum.put("otherListnum", othersize);//其他公务待审核条数（普通员工）
		jonum.put("exAuditnum", erruser);//疑似异常待审核条数（普通员工）
		jonum.put("totalnum", getTotalPage(unauditedList));//返回总页数
		jonum.put("msg", "success");//返回信息
		jonum.put("levelmsg", levelmsg);//是否管理族群0-普通员工；1-管理族群
		jonum.put("List", resultlist);//我的备案默认显示10条未审核数据
		
		jonum.put("lastMonOther", lastMonByOther());//其他公务上月待审核条数
		jonum.put("lastMonByErroe", lastMonByerroeMethod());//其他公务上月待审核条数
		
		// 返回页面数据
		writeToPage(jonum);
		logger.debug("success");
		
	}
	
	/**
	 * 判断是否为管理族群
	 * @param userId
	 * @return 1为管理族群，0为普通员工
	 */
	@CookieNotCheckedRequired
	public String findLevelPerson(String userId) {
		List<EmployeeVO> employeeList = new ArrayList<EmployeeVO>();
		employeeList = externalMethodService.getEmpInfolist(userId);
		String levelmsg = null;
		for(EmployeeVO temp : employeeList){
			//1为管理族群，0为普通员工
			if("管理族群".equals(temp.getJobGroups())){
				levelmsg = "1";
			}else{
				levelmsg="0";
			}
		}
		return levelmsg;
	}
	
	/**
	 * 获取总页数
	 * @author lvdf
	 * 2018年1月22日09:58:13
	 * @return
	 */
	public int getTotalPage(List<DiDiRecordVO> list) {
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
	 * 其他公务员工点击，默认带出‘待审核’数据
	 */
	public int auditedQueryMethod(){
		List<OtherOffDutiesEntity> otherEntityList = otherOffDutiesService.auditedQueryMethod(userId, "3");
		List<OtherOffDutiesEntity> otherNewList = new ArrayList<OtherOffDutiesEntity>();
		for(OtherOffDutiesEntity temp : otherEntityList){
			if(temp.getRemark()!= null){
				if("0".equals(temp.getRecordstate())){
					otherNewList.add(temp);
				}
			}
		}
		int other = otherNewList.size();
		
		return other;
	}
	
	/**
	 * 其他公务上个月‘待审核’条数
	 */
	public int lastMonByOther(){
		//待审核数据
		List<OtherOffDutiesEntity> otherEntityList = otherOffDutiesService.auditedQueryMethod(userId, "3");
		List<OtherOffDutiesEntity> otherNewList = new ArrayList<OtherOffDutiesEntity>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ufdate = sdf.format(System.currentTimeMillis());
		String month = ufdate.substring(6,7);
		String newMonth = ufdate.substring(0, 6)+(Integer.parseInt(month)-1);
		for(OtherOffDutiesEntity temp : otherEntityList){
			if(temp.getRecordtime().startsWith(newMonth) && "0".equals(temp.getRecordstate())){
				otherNewList.add(temp);
			}
		}
		//待我审核数据
		List<OtherOffDutiesEntity> leaderNewList = otherOffDutiesService.leaderQueryResult(userId, "3");
		for(OtherOffDutiesEntity temp : leaderNewList){
			if(temp.getRemark()!= null){
				if("0".equals(temp.getRecordstate())){
					otherNewList.add(temp);
				}
			}
		}
		return otherNewList.size();
	}
	
	
	/**
	 * 其他公务管理族群点击我审核，默认带出‘待我审核’数据
	 */
	public int auditedMinMethod(){
		List<OtherOffDutiesEntity> otherEntityList = otherOffDutiesService.leaderQueryResult(userId, "3");
		List<OtherOffDutiesEntity> otherNewList = new ArrayList<OtherOffDutiesEntity>();
		for(OtherOffDutiesEntity temp : otherEntityList){
			if(temp.getRemark()!= null){
				if("0".equals(temp.getRecordstate())){
					otherNewList.add(temp);
				}
			}
		}
		
		
		int otherleader = otherNewList.size();
		
		return otherleader;
	}
	
	/**
	 * 疑似异常上个月‘待审核’条数
	 */
	public int lastMonByerroeMethod(){
		//待审核数据
		logger.info("用户查询审核结果(用户筛选)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<AbnormalOrderEntity> otherEntityList = doubtfulExAuditService.auditedQueryMethod(userId, "0");
		List<AbnormalOrderEntity> newList = new ArrayList<AbnormalOrderEntity> ();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ufdate = sdf.format(System.currentTimeMillis());
		String month = ufdate.substring(6,7);
		String newMonth = ufdate.substring(0, 6)+(Integer.parseInt(month)-1);
		
		for(AbnormalOrderEntity temp : otherEntityList){
			if(temp.getRecordtime().startsWith(newMonth) && temp.getRemark()!= null && ("0".equals(temp.getRecordstate())||"3".equals(temp.getRecordstate()))){
				newList.add(temp);
			}
		}
		//待我审核数据
		List<AbnormalOrderEntity> allleaderlist = doubtfulExAuditService.leaderQueryMethod(userId, "0");
		for(AbnormalOrderEntity temp : allleaderlist){
			if(temp.getRemark()!= null && ("0".equals(temp.getRecordstate())||"3".equals(temp.getRecordstate()))){
				newList.add(temp);
			}
		}
	
		return newList.size();
	}
	
	/**
	 * 疑似异常员工点击，默认带出‘待审核’数据
	 */
	public int auditederroeMethod(){
		
		logger.info("用户查询审核结果(用户筛选)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<AbnormalOrderEntity> otherEntityList = doubtfulExAuditService.auditedQueryMethod(userId, "0");
		List<AbnormalOrderEntity> newList = new ArrayList<AbnormalOrderEntity> ();
		for(AbnormalOrderEntity temp : otherEntityList){
			if(temp.getRemark()!= null && ("0".equals(temp.getRecordstate())||"3".equals(temp.getRecordstate()))){
				newList.add(temp);
			}
		}
	
		return newList.size();
	}
	
	/**
	 * 疑似异常领导点击，默认带出‘待我审核’数据
	 */
	public int auditedLeaderMethod(){
		
		logger.info("管理族群查询未审核数据(管理未审核)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<AbnormalOrderEntity> allleaderlist = doubtfulExAuditService.leaderQueryMethod(userId, "0");
		List<AbnormalOrderEntity> newList = new ArrayList<AbnormalOrderEntity> ();
		for(AbnormalOrderEntity temp : allleaderlist){
			if(temp.getRemark()!= null && ("0".equals(temp.getRecordstate())||"3".equals(temp.getRecordstate()))){
				newList.add(temp);
			}
		}
	
		return newList.size();
	}
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the keepOnRecordService
	 */
	public IKeepOnRecordService getKeepOnRecordService() {
		return keepOnRecordService;
	}

	/**
	 * @return the otherOffDutiesService
	 */
	public IOtherOffDutiesService getOtherOffDutiesService() {
		return otherOffDutiesService;
	}

	/**
	 * @return the externalMethodService
	 */
	public IExternalMethodService getExternalMethodService() {
		return externalMethodService;
	}

	/**
	 * @param keepOnRecordService the keepOnRecordService to set
	 */
	public void setKeepOnRecordService(IKeepOnRecordService keepOnRecordService) {
		this.keepOnRecordService = keepOnRecordService;
	}

	/**
	 * @param otherOffDutiesService the otherOffDutiesService to set
	 */
	public void setOtherOffDutiesService(
			IOtherOffDutiesService otherOffDutiesService) {
		this.otherOffDutiesService = otherOffDutiesService;
	}

	/**
	 * @param externalMethodService the externalMethodService to set
	 */
	public void setExternalMethodService(
			IExternalMethodService externalMethodService) {
		this.externalMethodService = externalMethodService;
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
	
}
