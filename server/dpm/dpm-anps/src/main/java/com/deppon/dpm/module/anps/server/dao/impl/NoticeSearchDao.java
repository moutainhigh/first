package com.deppon.dpm.module.anps.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.anps.server.dao.INoticeSearchDao;
import com.deppon.dpm.module.anps.shared.domain.OrganizationEntity;
import com.deppon.dpm.module.common.shared.define.DpmConstants;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class NoticeSearchDao extends iBatis3DaoImpl  implements INoticeSearchDao {
	/**
	 * namespace
	 */
	private static final String NAME_SPACE =  "com.deppon.dpm.module.anps.server.dao.impl.NoticeSearchDao.";
	
	/**
	 * 根据组织名称搜索
	 * @param orgName
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OrganizationEntity> getOrgs(String orgName, String orgid) {
		// TODO Auto-generated method stub
		Map<String, String> params = new HashMap<String, String>();
		params.put("orgName", orgName);
		if (orgid != null) {
			params.put("orgid", "." + orgid + ".");
		}
		return this.getSqlSession().selectList(NAME_SPACE + "selectOrgs", params);
	}
	/**
	 * 根据工号或名字搜
	 * @param empCode
	 * @param empName
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeVO> getEmps(String empCode, String empName, String orgid,Integer pageNo) {
		// TODO Auto-generated method stub 
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("empCode",empCode);//工号
		params.put("empName",empName);//姓名
		if (orgid != null) {
			params.put("orgid", "." + orgid + ".");
		}
		
		if (pageNo != null) {
			params.put("pageNo", (pageNo - 1) * DpmConstants.anpsPageNumber);//第几页
			params.put("pageNumber", DpmConstants.anpsPageNumber);//每页多少条
		}
		
		return this.getSqlSession().selectList(NAME_SPACE + "selectEmps", params);
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * 根据组织获得员工
	 */
	@Override
	public List<EmployeeVO> getEmpByOrgId(String orgId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orgId",orgId);//工号
		//params.put("empName",empName);//姓名
		//int orgId=Integer.valueOf(orgIds);
		return this.getSqlSession().selectList(NAME_SPACE + "getEmpByOrgId", params);

	}
	
	@SuppressWarnings("unchecked")
	/**
	 * 根据组织获得员工
	 */
	@Override
	public OrganizationEntity getEmpDetailByOrgId(String orgId) {
		OrganizationEntity emp=null;
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("orgId",orgId);//工号
			//params.put("empName",empName);//姓名
			//int orgId=Integer.valueOf(orgIds);
			
			emp= (OrganizationEntity) this.getSqlSession().selectList(NAME_SPACE + "getEmpDetailByOrgId", params).get(0);
	       return emp;
		} catch (Exception e) {
			System.out.println(orgId);
			e.printStackTrace();
		}
		return emp;

	}
	
	/**
	 * 根据岗位跟 组织 获得员工
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeVO> getEmpByJobName(String memberCode, String memberName) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("orgId", Integer.valueOf(memberCode));
		map.put("jobName", memberName);
		return this.getSqlSession().selectList(NAME_SPACE + "getEmpByJobName", map);
	}
	
	/**
	 * 根据员工号 获取组织
	 * @param memberCode
	 * @param memberName
	 */
	@Override
	public OrganizationEntity getOrgByEmpCode(String userId) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		return (OrganizationEntity) this.getSqlSession().selectOne(NAME_SPACE + "getOrgByEmpCode", map);
	}
	/**
	 * 根据员工号 获取员工
	 * @param memberCode
	 * @param memberName
	 */
	@Override
	public EmployeeVO getEmpByEmpCode(String userId) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		return (EmployeeVO) this.getSqlSession().selectOne(NAME_SPACE + "getEmpByEmpCode", map);

	}

}
