package com.deppon.dpm.module.anps.server.dao;

import java.util.List;

import com.deppon.dpm.module.anps.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
/**
 * 公文搜索DAO
 * @author 276344
 *
 */
public interface INoticeSearchDao {
	/**
	 * 根据组织名称搜索
	 * @param orgName
	 */
	public List<OrganizationEntity> getOrgs(String orgName, String orgid);
	/**
	 * 根据工号或名字搜
	 * @param empCode
	 * @param empName
	 */
	public List<EmployeeVO> getEmps(String empCode, String empName, String orgid,Integer pageNo);
	/**
	 * 根据组织ID搜索部门员工
	 * @param orgId
	 */
	public List<EmployeeVO> getEmpByOrgId(String orgId);
	/**
	 *根据岗位获得员工
	 * @param memberCode
	 * @param memberName
	 * @return
	 */
	public List<EmployeeVO> getEmpByJobName(String memberCode, String memberName);
	
	/**
	 * 根据员工号 获取组织
	 * @param memberCode
	 * @param memberName
	 */
	public OrganizationEntity getOrgByEmpCode(String userId);
	/**
	 * 根据员工号 获取员工信息
	 * @param memberCode
	 * @param memberName
	 */
	public EmployeeVO getEmpByEmpCode(String userId);
	/**
	 * 根据组织ID获取部门信息
	 * @param orgId
	 */
	public OrganizationEntity getEmpDetailByOrgId(String orgId);

}
