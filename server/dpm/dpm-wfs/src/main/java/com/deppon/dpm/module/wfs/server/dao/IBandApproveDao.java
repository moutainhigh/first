package com.deppon.dpm.module.wfs.server.dao;

import java.util.List;

import com.deppon.dpm.module.wfs.shared.domain.BandApproveEntity;

/**
 * 查询B10表信息
 * @author duwenxue
 *
 */
public interface IBandApproveDao {
	/**
	 * 查询B10表
	 * @param empCode
	 * @return
	 */
	public List<BandApproveEntity> queryBandApproveEntity();
	
	/**
	 * 根据workflowid 查询 等级信息
	 * @param workflowId
	 * @return
	 */
	public String getJoblevelByworkFlowId(String workflowId);
	
}
