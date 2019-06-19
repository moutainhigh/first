package com.deppon.dpm.module.wfs.server.dao;

import java.util.List;

import com.deppon.dpm.module.wfs.shared.domain.WorkflowInfo;
import com.deppon.dpm.module.wfs.shared.dto.WorkItemsDto;
import com.deppon.dpm.module.wfs.shared.vo.OaWorkItem;
/**
 * 
 * 同步盘点资产信息 Interface
 *
 * <p style="display:none">
 * version:V1.0,author:195406 高春玲,date:2015-3-20 下午1:45:08,content:固定资产 移动端与Lsp数据同步 
 * </p>
 * 
 * @author 195406 高春玲
 * @date 2015-3-20 下午1:45:08
 * @since
 * @version
 *  1、	在移动端接收任务通知后，在对应的盘点任务列表中或者首页直接点击扫一扫按钮，即可扫描固定资产；
	2、	移动端扫描时，将扫描的固定资产管理编码推送至LSP，LSP校验此资产是否已被扫描，未扫描则可进行以下操作，若已扫描则推送已扫描信息至移动端。
	3、	移动端扫描时，扫描结果选择完成时将信息推送至LSP
	4、	移动端扫描时，资产未在盘点任务列表中的扫描完成后将盘盈的资产信息推送至LSP，LSP系统将固定资产信息匹配完整后推送至移动端保存
	5、	移动端扫描时，资产在盘点任务列表中但未进行扫描，盘点列表信息暂存或者提交后将盘亏信息推送至LSP
	6、	扫描过程中信息同步到LSP中的“固定资产盘点单”中
	7、	扫描的固定资产不在任务盘点列表中则自动新增一条记录，自动新增的固定资产可删除，删除确认后将该固定资产信息推送至LSP
 **/
public interface IWorkItemsListDao {
	/**
	 * @author 195406 高春玲
	 * @date 2015-3-20 下午1:45:08
	 */
	public List<OaWorkItem> workitemslist(WorkItemsDto dto);
	/**
	 * 获取所有移动端迁移审批工作流
	 */
    public List<WorkflowInfo> queryAllWorkInfo();
    /**
     * 根据工作流流程定义id获得工作流名称 (报错预警使用)
     * 7.1 gcl
     */
    public WorkflowInfo queryWorkInfo(String workflowname);
    
    /**
     * 用户ID
     * @param userId
     * @return
     */
    public int queryWorkflowItems(String userId);

}
