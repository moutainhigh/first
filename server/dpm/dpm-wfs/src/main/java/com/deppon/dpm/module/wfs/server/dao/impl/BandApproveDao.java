package com.deppon.dpm.module.wfs.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.wfs.server.dao.IBandApproveDao;
import com.deppon.dpm.module.wfs.shared.domain.BandApproveEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 查询B10表信息
 * @author duwenxue
 *
 */
public class BandApproveDao extends iBatis3DaoImpl implements IBandApproveDao {
	private static final String NAME_SPACE="com.deppon.dpm.module.wfs.server.dao.workitems.";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BandApproveEntity> queryBandApproveEntity() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(NAME_SPACE + "queryBandApproveEntity");
	}

	@Override
	public String getJoblevelByworkFlowId(String workflowId) {
		// TODO Auto-generated method stub
		return (String) getSqlSession().selectOne(NAME_SPACE + "getJoblevelByworkFlowId", workflowId);
	}

}
