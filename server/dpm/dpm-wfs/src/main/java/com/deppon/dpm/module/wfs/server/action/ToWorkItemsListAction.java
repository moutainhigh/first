package com.deppon.dpm.module.wfs.server.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.ParamUtils;
import com.deppon.dpm.module.wfs.server.service.IWeaverWfsService;
import com.deppon.dpm.module.wfs.server.service.IWorkItemsListService;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowListEntity;
import com.deppon.dpm.module.wfs.shared.dto.WorkItemsDto;
import com.deppon.dpm.module.wfs.shared.vo.OaWorkItem;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.Result;

/**
 * 工作流列表
 * 
 * @version
 */
public class ToWorkItemsListAction extends BaseAction {

	private static final long serialVersionUID = 1397420409043898745L;

	/**
	 * service
	 */
	private IWorkItemsListService workItemsListService;
	/**
	 * 日志
	 */
	private static Logger logger  = LoggerFactory.getLogger(WeaverWfsAction.class);
	/**
	 * service
	 */
	private IWeaverWfsService weaverService;

	//分页功能
	private String pageNo;
	

	//用户ID
	private String userId;

	public void setWorkItemsListService(
			IWorkItemsListService workItemsListService) {
		this.workItemsListService = workItemsListService;
	}

	/**
	 * 获得所有工作流列表
	 * 
	 * @author 195406 高春玲
	 * @date 2015-3-30 下午2:45:08
	 */
	@CookieNotCheckedRequired
	public void workItemsList() {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("Access-Control-Allow-Origin", "*");
			WorkItemsDto dto = new WorkItemsDto();
			dto.setUserId(userId);
			Map<String, Object> list = workItemsListService
					.workitemslist(dto);
			writeToPage(response, JSON.toJSONString(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 新工作流+老工作流待办列表
	 */
	public void workflowListAll(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		//判断工号的规范性
		if(ParamUtils.checkUserId(userId)){
			// errorMessage
			logger.info("工号错误，不符合规范");
		}
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
			//合并新老工作流
			List<Object> listAll = new ArrayList<Object>();
			listAll.addAll(newlist);
			listAll.addAll(oldlist);
			//按创建时间排序
			listSort(listAll);
			//按时间时间处理
			Map<String, Object> list = workItemsListService.getWorkFlowDateList(listAll);
			writeToPage(response, JSON.toJSONString(list));
		} catch (Exception e) {
			//日志
			logger.error("------获取工作流待办列表失败2-----"+e);
			e.printStackTrace();
		}
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
	 * 获取代办列表数据条数
	 * @param userId
	 * @return
	 */
	public void queryWorkflowItems(){
		Result<Integer> res = new Result<Integer>();
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			//判断工号的规范性
			if(ParamUtils.checkUserId(userId)){
				// errorMessage
				logger.info("工号错误，不符合规范");
			}
			int count = workItemsListService.queryWorkflowItems(userId);
			res.setData(count);
			res.setErrorCode(Constants.SUCCESS);
		} catch (Exception e) {
			res.setData(0);
			res.setErrorMessage("获取信息失败！");
			res.setErrorCode(Constants.SERVICE_ERROR);
			e.printStackTrace();
		}
		
		writeToPage(response, JSON.toJSONString(res));
	}
	
	/**
	 * userId
	 */
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public IWeaverWfsService getWeaverService() {
		return weaverService;
	}

	public void setWeaverService(IWeaverWfsService weaverService) {
		this.weaverService = weaverService;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public IWorkItemsListService getWorkItemsListService() {
		return workItemsListService;
	}


}