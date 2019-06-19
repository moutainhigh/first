package com.deppon.dpm.module.main.server.dao.impl;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.common.shared.vo.OrganizationEntity;
import com.deppon.dpm.module.main.server.dao.IPunchClockGlobalDao;
import com.deppon.dpm.module.main.shared.domain.PunchClockPositionGlobalEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class PunchClockGlobalDao extends iBatis3DaoImpl implements IPunchClockGlobalDao {

	/**
	 * nameSpace
	 */
	private String NAME_SPACE = "com.deppon.dpm.module.main.server.dao.punchClockGlobal.";
	
	
	@Override
	public int addClockPosition(PunchClockPositionGlobalEntity entity) {
		
		return this.getSqlSession().insert(NAME_SPACE + "addClockPosition",entity);
	}

	@Override
	public int updateClockPosition(PunchClockPositionGlobalEntity entity) {
		
		return this.getSqlSession().insert(NAME_SPACE + "updateClockPosition",entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrganizationEntity> getOrgIdByEmpCode(String empCode) {
		
		return this.getSqlSession().selectList(NAME_SPACE + "getOrgIdByEmpCode", empCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PunchClockPositionGlobalEntity> getPunchClockPositionByOrgId(
			Map<String, String> param) {
		
		return this.getSqlSession().selectList(NAME_SPACE + "getPunchClockPositionByOrgId", param);
	}

	@Override
	public PunchClockPositionGlobalEntity getPunchClockPositionById(int id) {
		
		return (PunchClockPositionGlobalEntity)this.getSqlSession().selectOne(NAME_SPACE + "getPunchClockPositionById", id);
	}

	@Override
	public int updateClockPositionStatus(Map<String, Object> param) {
		
		return this.getSqlSession().update(NAME_SPACE + "updateClockPositionStatus", param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PunchClockPositionGlobalEntity> getPunchClockAvailablePosition(
			Map<String, String> param) {
		return this.getSqlSession().selectList(NAME_SPACE + "getPunchClockAvailablePosition", param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrganizationEntity> getOrgById(String orgId) {
		
		return this.getSqlSession().selectList(NAME_SPACE + "getOrgById", orgId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PunchClockPositionGlobalEntity> getPositionByParentOrgId(
			Map<String, String> param) {
		
		return this.getSqlSession().selectList(NAME_SPACE + "getPositionByParentOrgId", param);
	}
	
	@Override
	public String getManagerIdByEmpcode(String empcode){
		
		return (String) this.getSqlSession().selectOne(NAME_SPACE + "getManagerIdByEmpcode", empcode);
	}

}
