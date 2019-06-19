package com.deppon.dpm.module.anps.server.dao;

import java.util.List;

import com.deppon.dpm.module.anps.shared.domain.NoticeJobEntity;
import com.deppon.dpm.module.anps.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

/**
 * 公文接收对象DAO层
 * @author 276344
 *
 */
public interface IReceiveObjectDao {
	/**
	 * 根据组织ID 查询下面所有的子组织信息
	 * @param orgid
	 *
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
	 * xx部门下的所有子部门  岗位为xx 的总人数 
	 * @param orgid 部门id
	 * @param jobName 岗位
	 * @return
	 */
	public Integer getJobNumber(String orgid, String jobName);
	
	/**
	 * 查询组织下面的所有员工信息
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
	 * 根据工号查询组织id
	 * @param empCode
	 * @return
	 */
	public String getOrgidByEmpCode(String empCode);
	/**
	 * 创建群组时获取岗位信息
	 * @return
	 */
	public List<NoticeJobEntity> getJobList(String orgid);
	
	/**
	 * 获取组织领导
	 * @return
	 */
	public List<EmployeeVO> getLeaderEmpInfoByOrgid(String orgid);
	public EmployeeVO getLeaderEmp(String empCode);
	/**
	 * 获取组织名称
	 * @return
	 */
	public String getOrgNameByEmpCode(String empCode);

}
