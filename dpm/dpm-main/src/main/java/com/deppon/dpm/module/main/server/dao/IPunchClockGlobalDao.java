package com.deppon.dpm.module.main.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.common.shared.vo.OrganizationEntity;
import com.deppon.dpm.module.main.shared.domain.PunchClockPositionGlobalEntity;

public interface IPunchClockGlobalDao {
	
	public int addClockPosition(PunchClockPositionGlobalEntity entity);
	
	public int updateClockPosition(PunchClockPositionGlobalEntity entity);
	
	public int updateClockPositionStatus(Map<String,Object> param);
	
	public List<OrganizationEntity> getOrgIdByEmpCode(String empCode);
	
	public List<PunchClockPositionGlobalEntity> getPunchClockPositionByOrgId(Map<String,String> param);
	
	public List<PunchClockPositionGlobalEntity> getPunchClockAvailablePosition(Map<String,String> param);
	
	public PunchClockPositionGlobalEntity getPunchClockPositionById(int id);
	
	public List<OrganizationEntity> getOrgById(String orgId);
	
	public List<PunchClockPositionGlobalEntity> getPositionByParentOrgId(Map<String,String> param);
	
	public String getManagerIdByEmpcode(String empcode);
	
}
