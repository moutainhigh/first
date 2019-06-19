package com.deppon.dpm.tongxunlu.server.service;

import java.util.List;

import com.deppon.dpm.tongxunlu.shared.domain.MyConsumptionRequestEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;

public interface IExternalMethodService {
	
	public EmployeeVO getLeaderInfo(String empCode);

	public OrganizationVO getDeptByEmpcode(String empCode);
	
	public List<EmployeeVO> getEmpInfolist(String employee);
	
	public List<MyConsumptionRequestEntity> getDeptInfo(String empNo);
	
	public int getOrgEmpNum(String orgid);
	
	public boolean getSameMobile(String mobileno);
	
	public List<String> getEmpcodebyTel(List<String> moblist);
	
	public EmployeeVO getEmpInfo(String empCode); 
}
