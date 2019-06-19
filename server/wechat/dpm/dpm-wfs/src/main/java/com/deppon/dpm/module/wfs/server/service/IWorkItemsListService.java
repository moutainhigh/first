package com.deppon.dpm.module.wfs.server.service;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.wfs.shared.dto.WorkItemsDto;
import com.deppon.dpm.module.wfs.shared.vo.OaWorkItem;

/**
 * 
 * 同步盘点资产信息 Interface
 * 
 * @author 195406 高春玲
 * @date 2015-3-20 下午1:45:08
 **/
public interface IWorkItemsListService {
	/**
	 * @author 195406 高春玲
	 * @date 2015-3-20 下午1:45:08
	 */
	public Map<String, Object> workitemslist(WorkItemsDto dto);
	
	public List<OaWorkItem> workitemslist1(WorkItemsDto dto);
	
	public List<OaWorkItem> workitemslist2(WorkItemsDto dto);
	
	public Map<String, Object> getWorkFlowDateList(List<Object> workflowdatelist);
	
	/**
	 * 获取代办列表数据条数
	 * @param userId
	 * @return
	 */
	public int queryWorkflowItems(String userId);

}
