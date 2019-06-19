package com.deppon.dpm.module.main.server.service;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.common.shared.vo.OrganizationEntity;
import com.deppon.dpm.module.main.shared.domain.PunchClockPositionGlobalEntity;

public interface IPunchClockGlobalService {
	
	public int addClockPosition(PunchClockPositionGlobalEntity entity);
	
	public int updateClockPosition(PunchClockPositionGlobalEntity entity) throws Exception;
	
	public int updateClockPositionStatus(Map<String,Object> param) throws Exception;
	
	public boolean isDepartmentManager(String empCode) throws Exception;
	
	public List<OrganizationEntity> getOrgIdByEmpCode(String empCode) throws Exception;
	
	public List<PunchClockPositionGlobalEntity> getPunchClockPositionByOrgId(Map<String,String> param) throws Exception;
	
	public PunchClockPositionGlobalEntity getPunchClockPositionById(int id) throws Exception;
	
	public List<PunchClockPositionGlobalEntity> getPunchClockAvailablePosition(Map<String,String> param) throws Exception;
	
	public int addNoticeDetail(Map<String,String> notice);
	
	public List<OrganizationEntity> getOrgById(String orgId) throws Exception;
	
	public List<PunchClockPositionGlobalEntity> getPositionByParentOrgId(Map<String,String> param) throws Exception;

}
