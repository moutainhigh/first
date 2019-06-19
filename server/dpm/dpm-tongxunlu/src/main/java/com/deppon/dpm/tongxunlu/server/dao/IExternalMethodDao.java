package com.deppon.dpm.tongxunlu.server.dao;

import java.util.List;

import com.deppon.dpm.tongxunlu.shared.domain.MyConsumptionRequestEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;

public interface IExternalMethodDao {

	public EmployeeVO getEmpInfo(String empCode);

	public OrganizationVO getDeptByEmpcode(String empCode);
	
	public List<EmployeeVO> getLeaderInfo(int orgid);

	public List<EmployeeVO> getALLLeaderInfo(List<MyConsumptionRequestEntity> orglist);
	
	public List<EmployeeVO> getUpperManager(int orgid,String joblevel);
	
	public String getUpperOrg(int orgid);
	
	public List<EmployeeVO> getEmpInfolist(String employee);
	
	public MyConsumptionRequestEntity getDept(String empNo);
	
	public List<MyConsumptionRequestEntity> getChildOrgs(String orgid);
	
	public List<MyConsumptionRequestEntity> getAllChilddept(String orgid);
	
	public int getEmpNum(String orgid);
	
	public List<MyConsumptionRequestEntity> getSameLevelEmp(String orgid,String empNo);
	
	public int getSameMobile (String mobileno);
	
	public String getOrgnameById(String orgname);
	
	public List<String> getEmpcodebyTel(List<String> moblist);
}
