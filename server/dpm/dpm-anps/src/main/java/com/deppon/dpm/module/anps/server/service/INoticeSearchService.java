package com.deppon.dpm.module.anps.server.service;

import java.util.List;

import com.deppon.dpm.module.anps.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

/**
 * 公文搜索service
 * @author 276344
 *
 */
public interface INoticeSearchService {
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
	 * 根据组织id 跟岗位名称获取员工
	 * @param memberCode
	 * @param memberName
	 */
	public List<EmployeeVO> getEmpByJobName(String memberCode, String memberName);
	/**
	 * 根据员工号获取组织消息
	 * @param memberCode
	 * @param memberName
	 */
	public OrganizationEntity getOrgByEmpCode(String userId);
	/**
	 * 根据员工号获取员工信息
	 * @param memberCode
	 * @param memberName
	 */
	public EmployeeVO getEmpByEmpCode(String userId);
	/**
	 * 根据部门获取部门信息
	 * @param memberCode
	 * @param memberName
	 */
	public OrganizationEntity getEmpDetailByOrgId(String string);
}
