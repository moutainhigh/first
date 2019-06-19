package com.deppon.dpm.module.wfs.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.wfs.server.dao.IWorkItemsListDao;
import com.deppon.dpm.module.wfs.server.service.IWorkItemsListService;
import com.deppon.dpm.module.wfs.server.util.F_Constants;
import com.deppon.dpm.module.wfs.shared.domain.NwfsPicPathEntity;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowListEntity;
import com.deppon.dpm.module.wfs.shared.dto.WorkItemsDto;
import com.deppon.dpm.module.wfs.shared.vo.OaShowDate;
import com.deppon.dpm.module.wfs.shared.vo.OaShowDateNew;
import com.deppon.dpm.module.wfs.shared.vo.OaWorkItem;
import com.deppon.dpm.module.wfs.shared.vo.WorkFlowDateList;
import com.deppon.dpm.module.wfs.shared.vo.WorkFlowItem;

/**
 * 
 * 工作流列表Service
 * 
 * <p style="display:none">
 * version:V1.0,author:195406 高春玲,date:2015-3-20 下午1:45:08,content:工作流列表
 * </p>
 * 
 * @author 195406 高春玲
 * @date 2015-3-30 下午1:45:08
 **/
public class WorkItemsListService implements IWorkItemsListService {

	private IWorkItemsListDao workItemsListDao;

	public IWorkItemsListDao getWorkItemsListDao() {
		return workItemsListDao;
	}

	public void setWorkItemsListDao(IWorkItemsListDao workItemsListDao) {
		this.workItemsListDao = workItemsListDao;
	}

	@Override
	public Map<String, Object> workitemslist(WorkItemsDto dto) {

		String processdefname = F_Constants.ALL_WORKFLOW_TYPES_FSSC + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_LSP + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_DWFS + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_ICRM + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_FIN_SELF + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_HR + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_WDGH + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_ACMS + ","
		        + F_Constants.ALL_WORKFLOW_TYPES_DPPM;
		dto.setProcessType(processdefname);
		List<OaWorkItem> workitemslist = workItemsListDao.workitemslist(dto);
		return getWorkFlowItem(workitemslist);
	}
	
	@Override
	public List<OaWorkItem> workitemslist1(WorkItemsDto dto) {

		String processdefname = F_Constants.ALL_WORKFLOW_TYPES_FSSC + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_LSP + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_DWFS + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_ICRM + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_FIN_SELF + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_HR + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_WDGH + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_ACMS + ","
		        + F_Constants.ALL_WORKFLOW_TYPES_DPPM;
		dto.setProcessType(processdefname);
		List<OaWorkItem> workitemslist = workItemsListDao.workitemslist(dto);
		//获取工作流对应头像地址
		/*for(OaWorkItem workflow : workitemslist){
			//起草人id
			List<String> createId = new ArrayList<String>();
			createId.add(workflow.getRequestInfo().getCreatorId());
			//获取该起草人头像地址
			List<NwfsPicPathEntity> entitys = new ArrayList<NwfsPicPathEntity>();
			entitys = picService.picturePaths(createId);
			//存入工作流待办实体
			workflow.setPicPaths(entitys);
		}	*/
		return workitemslist;
	}
	
	@Override
	public List<OaWorkItem> workitemslist2(WorkItemsDto dto) {

		String processdefname = F_Constants.ALL_WORKFLOW_TYPES_FSSC + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_LSP + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_DWFS + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_ICRM + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_FIN_SELF + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_HR + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_WDGH + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_ACMS + ","
		        + F_Constants.ALL_WORKFLOW_TYPES_DPPM;
		dto.setProcessType(processdefname);
		List<OaWorkItem> workitemslist = workItemsListDao.workitemslist(dto);
		return workitemslist;
	}

	/**
	 * 特殊处理，将今天，昨天和其它时间分类
	 */
	private Map<String, Object> getWorkFlowItem(
			List<OaWorkItem> workitemslist) {
		WorkFlowItem item = new WorkFlowItem();
		List<OaWorkItem> todayList = item.getTodayList();
		List<OaWorkItem> yesterdayList = item.getYesterdayList();
		List<OaWorkItem> otherList = item.getOtherList();
		String today = String.format("%tF", System.currentTimeMillis());
		String yesterday = String.format("%tF",
				System.currentTimeMillis() - 3600 * 1000 * 24);
		for (OaWorkItem oaWorkItem : workitemslist) {
			if (oaWorkItem.getShowDate().equals(today)) {
				todayList.add(oaWorkItem);
			} else if (oaWorkItem.getShowDate().equals(yesterday)) {
				yesterdayList.add(oaWorkItem);
			} else {
				otherList.add(oaWorkItem);
			}    
		}
		
		OaShowDate ot = null;
		List<OaShowDate> otherListC = new ArrayList<OaShowDate>();
		List<OaWorkItem> otSublist = null;
		for (OaWorkItem oaWorkItem : otherList) {
			if(ot == null){
				//new个实体对象
				ot = new OaShowDate();
				//new个otSublist对象
				otSublist = new ArrayList<OaWorkItem>();
				//给showdate赋值
				ot.setOaShowDate(oaWorkItem.getShowDate());
				//往otSublist里添加（add）
				otSublist.add(oaWorkItem);
				//给OtherList赋值
				ot.setOtherList(otSublist);
				//往otherListc里添加（add）
				otherListC.add(ot);
				continue;
			}
			
			if(ot.getOaShowDate().equals(oaWorkItem.getShowDate())){//判断showdate是否相等
				////往otSublist里添加（add）
				otSublist.add(oaWorkItem);
			}else{
				//new个实体对象
				ot = new OaShowDate();
				//new个otSublist对象
				otSublist = new ArrayList<OaWorkItem>();
				//给showdate赋值
				ot.setOaShowDate(oaWorkItem.getShowDate());
				//往otSublist里添加（add）
				otSublist.add(oaWorkItem);
				//给OtherList赋值
				ot.setOtherList(otSublist);
				//往otherListc里添加（add）
				otherListC.add(ot);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("todayList", todayList);
		map.put("yestList", yesterdayList);
		map.put("otherList", otherListC);
		return map;
	}
	
	/**
	 * 特殊处理，将今天，昨天和其它时间分类(新老工作流列表)
	 */
	@Override
	public Map<String, Object> getWorkFlowDateList(
			List<Object> workflowdatelist) {
		WorkFlowDateList item = new WorkFlowDateList();
		List<Object> todayList = item.getTodayList();
		List<Object> yesterdayList = item.getYesterdayList();
		List<Object> otherList = item.getOtherList();
		String today = String.format("%tF", System.currentTimeMillis());
		String yesterday = String.format("%tF",
				System.currentTimeMillis() - 3600 * 1000 * 24);
		for (Object obj : workflowdatelist) {
			if(obj.getClass() == WorkflowListEntity.class){
				if (((WorkflowListEntity)obj).getRequestInfo().getCreateTime().substring(0, 10).equals(today)) {
					todayList.add(obj);
				} else if (((WorkflowListEntity)obj).getRequestInfo().getCreateTime().substring(0, 10).equals(yesterday)) {
					yesterdayList.add(obj);
				} else {
					otherList.add(obj);
				} 
			}else{
				/*System.out.println(((OaWorkItem)obj).getShowDate());*/
				if (((OaWorkItem)obj).getShowDate().equals(today)) {
					todayList.add(obj);
				} else if (((OaWorkItem)obj).getShowDate().equals(yesterday)) {
					yesterdayList.add(obj);
				} else {
					otherList.add(obj);
				}   
			} 
		}
		
		OaShowDateNew ot = null;
		List<OaShowDateNew> otherListC = new ArrayList<OaShowDateNew>();
		List<Object> otSublist = null;
		for (Object otherlist : otherList) {
			if(ot == null){
				//new个实体对象
				ot = new OaShowDateNew();
				//new个otSublist对象
				otSublist = new ArrayList<Object>();
				//给showdate赋值
				if(otherlist.getClass() == WorkflowListEntity.class){
					ot.setOaShowDate(((WorkflowListEntity)otherlist).getRequestInfo().getCreateTime());
				}else{
					ot.setOaShowDate(((OaWorkItem)otherlist).getShowDate());
				}
				//往otSublist里添加（add）
				otSublist.add(otherlist);
				//给OtherList赋值
				ot.setOtherList(otSublist);
				//往otherListc里添加（add）
				otherListC.add(ot);
				continue;
			}
			
			String date = "";
			if(otherlist.getClass() == WorkflowListEntity.class){
				date = ((WorkflowListEntity)otherlist).getRequestInfo().getCreateTime();
			}else{
				date = ((OaWorkItem)otherlist).getShowDate();
			}
			if(ot.getOaShowDate().equals(date)){//判断showdate是否相等
				////往otSublist里添加（add）
				otSublist.add(otherlist);
			}else{
				//new个实体对象
				ot = new OaShowDateNew();
				//new个otSublist对象
				otSublist = new ArrayList<Object>();
				//给showdate赋值
				if(otherlist.getClass() == WorkflowListEntity.class){
					ot.setOaShowDate(((WorkflowListEntity)otherlist).getRequestInfo().getCreateTime());
				}else{
					ot.setOaShowDate(((OaWorkItem)otherlist).getShowDate());
				}
				//往otSublist里添加（add）
				otSublist.add(otherlist);
				//给OtherList赋值
				ot.setOtherList(otSublist);
				//往otherListc里添加（add）
				otherListC.add(ot);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("todayList", todayList);
		map.put("yestList", yesterdayList);
		map.put("otherList", otherListC);
		return map;
	}

	/**
	 * 用户ID
	 */
	@Override
	public int queryWorkflowItems(String userId) {
		return workItemsListDao.queryWorkflowItems(userId);
	}

}
