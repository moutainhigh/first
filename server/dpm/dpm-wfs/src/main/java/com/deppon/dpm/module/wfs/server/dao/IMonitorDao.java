package com.deppon.dpm.module.wfs.server.dao;

import java.util.List;

import weaver.workflow.webservices.WorkflowRequestInfo;

import com.deppon.dpm.module.wfs.shared.domain.NWorkflowInfoEntity;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowMonitorEntity;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowNewMonitorEntity;
import com.deppon.dpm.module.wfs.shared.vo.WfsMonitorVo;

/**
 * 工作流数据监控
 */
public interface IMonitorDao {
	/**
	 * @author 195406 高春玲
	 * @date 2015-6-1下午4:20:08
	 */
	public void addWfsMonitor(WfsMonitorVo vo) ;
	/**
	 * 添加工作流接口异常监控
	 * @param wmEntity
	 * @return
	 */
	public int insertMonitor(WorkflowMonitorEntity wmEntity);
	/**
	 * 添加新工作流审批接口监控--批准
	 * @param wmEntity
	 * @return
	 */
	public int insertApprovalMonitor(String userId, String joblevel,weaver.workflow.webservices.WorkflowRequestInfo requestInfo, String resultString);
	
	/**
	 * 添加老工作流审批接口监控--批准
	 * @param wmEntity
	 * @return
	 */
	public int insertApprovalMonitorOld(String userId, String joblevel,weaver.workflow.webservices.WorkflowRequestInfo requestInfo, String resultString);
	
	/**
	 * 添加老工作流 level为10以上 审批接口监控--批准
	 * @param wmEntity
	 * @return
	 */
	public int insertLevelMonitor(String userId, String joblevel,weaver.workflow.webservices.WorkflowRequestInfo requestInfo, String resultString);
	
	/**
	 * 查询老工作流 level为10以上监控表信息
	 * @param wmEntity
	 * @return
	 */
	public List<com.deppon.dpm.module.wfs.shared.domain.WorkflowLevelMonitorEntity> queryBandApproveMonitor(String userId);
	
	/**
	 * 监控表异常删除
	 * @param workflowName
	 * @return
	 */
	public int deleteLevelMonitor(String workflowName);
	/**
	 * 添加新工作流审批接口监控--不同意、回退
	 * @param userId
	 * @param jobLevel
	 * @param workflowName
	 * @param resultString
	 * @return
	 */
	public int insertUApprovalMonitor(WorkflowMonitorEntity wmEntity);
	/**
	 * 查询‘合伙人资质审核’工作流的id
	 * @return
	 */
	public String getPartnerWid();
	/**
	 * 新增一条工作流
	 * @param nworkflowinfo
	 * @return
	 */
	public int insertNWorkflow(NWorkflowInfoEntity nworkflowinfo);
	/**
	 * 更改一条工作流状态
	 * @param nworkflowinfo
	 * @return
	 */
	public int updateNWorkflowStatus(NWorkflowInfoEntity nworkflowinfo);
	
	/**
	 * 新增 old/new工作流监控表
	 * @param empCode
	 * @param joblevel
	 * @param requestInfo
	 * @param issuccess
	 * @param json
	 * @throws Exception 
	 */
	public int insertApprovalNewMonitor(String empCode, String joblevel,
			WorkflowRequestInfo requestInfo, String issuccess, String json, String isAttachment) throws Exception;
	/**
	 * 新增 old/new工作流监控表
	 * @param wmEntity
	 */
	public int insertApprovalEntityNewMonitor(WorkflowNewMonitorEntity wmEntity);
	
}