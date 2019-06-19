package com.deppon.dpm.module.anps.server.service;

import java.util.List;

import com.deppon.dpm.module.anps.shared.domain.NoticeJobEntity;
import com.deppon.dpm.module.anps.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

/**
 * 公文接收对象service
 * @author 276344
 *
 */
public interface IReceiveObjectService {
	/**
	 * 根据Orgid获取其下面的所有子组织信息
	 * @param orgid
	 * @param 
	 * @return
	 */
	public List<OrganizationEntity> getChildOrgInfoByOrgid(String orgid);
	/**
	 * 递归查询组织下所有部门员工的总数
	 * @param orgid
	 * @return
	 */
	public Integer getDepartmentMemberNumByOrgid(String orgid);
	/**
	 * xx部门 下 xx 岗位人数
	 * @param orgid
	 * @param jobName
	 * @return
	 */
	public Integer jobNum(String orgid, String jobName);
	/**
	 * xx部门下的所有子部门  岗位为xx 的总人数 
	 * @param orgid 部门id
	 * @param jobName 岗位
	 * @return
	 */
	public List<OrganizationEntity> getJobNumber(String orgid, String jobName);
	/**
	 * 查询组织下面所有员工的信息
	 * @param orgid
	 * @return
	 */
	public List<EmployeeVO> getEmpInfoByOrgid(String orgid);
	/**
	 * 查询xx岗位xx组织所有员工信息
	 * @param orgid
	 * @return
	 */
	public List<EmployeeVO> getJobEmp(String orgid, String jobName);
	/**
	 * 根据员工工号获取部门id
	 * @param empCode
	 * @return
	 */
	public String getOrgidByEmpCode(String empCode);
	/**
	 * 获取岗位信息
	 * @return
	 */
	public List<NoticeJobEntity> getJobList(String orgid);
	
	public List<EmployeeVO> getLeaderEmpInfoByOrgid(String orgid);
	
	public List<String> getLeaderEmpByOrgid(String orgid);
	//根据工号获取下属领导工号
	List<String> isLead(String empCode);
}
