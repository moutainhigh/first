package com.deppon.dpm.module.anps.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.anps.server.dao.IReceiveObjectDao;
import com.deppon.dpm.module.anps.shared.domain.NoticeJobEntity;
import com.deppon.dpm.module.anps.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class ReceiveObjectDao extends iBatis3DaoImpl implements IReceiveObjectDao {
	
	/**
	 * namespace
	 */
	private static final String NAMESPACE = "com.deppon.dpm.module.anps.server.dao.impl.ReceiveObjectDao.";

	
	/**
	 * 根据组织ID 查询下面所有的子组织信息
	 * @param orgid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OrganizationEntity> getChildOrgInfoByOrgid(String orgid) {
		return this.getSqlSession().selectList(NAMESPACE + "selectChildOrgs", orgid);
	}

	/**
	 * 查询组织下面的所有员工信息
	 * @param orgid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeVO> getEmpInfoByOrgid(String orgid) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(NAMESPACE + "getEmps", orgid);
	}

	/**
	 * 根据工号查询组织id
	 * @param empCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String getOrgidByEmpCode(String empCode) {
		// TODO Auto-generated method stub
		return (String) this.getSqlSession().selectOne(NAMESPACE + "getOrgidByEmpCode", empCode);
	
	}

	/**
	 * 递归查询组织下所有部门员工的总数
	 * @param orgid
	 * @return
	 */
	@Override
	public Integer getDepartmentMemberNumByOrgid(String orgid) {
		// TODO Auto-generated method stub
		if ((Integer) this.getSqlSession().selectOne(NAMESPACE + "getTotalNum", orgid) == null) {
			//查询结果为Null时表明该部门下员工为0
			return 0;
		}
		
		return (Integer) this.getSqlSession().selectOne(NAMESPACE + "getTotalNum", orgid);
	}
	/**
	 * 创建群组时获取岗位信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NoticeJobEntity> getJobList(String orgid) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(NAMESPACE + "getNoticeJobInfo", orgid);
		

	}
	
	
	/**
	 * xx部门下的所有子部门  岗位为xx 的总人数 
	 * @param orgid 部门id
	 * @param jobName 岗位
	 * @return
	 */
	@Override
	public Integer getJobNumber(String orgid, String jobName) {
		Map<String, String> params = new HashMap<String, String>();
		orgid = "." + orgid + ".";
		params.put("orgid",orgid);
		params.put("jobName",jobName);
		Integer totalNum ;
		if (jobName.equals("所有管理人员") || jobName.equals("高级经理及以上管理人员")|| jobName.equals("总监及以上管理人员")) {
			//这三种岗位通过表字段可以控制
			totalNum =  (Integer)this.getSqlSession().selectOne(NAMESPACE + "getJobNumManager", params);

		}else {
			//其余岗位得通过查询其它表才可以得到 
			String jobId = null;
			if (jobName.equals("营业网点经理")) {
				jobId = "4";
			}
			if (jobName.equals("司机")) {
				jobId = "5";
			}
			if (jobName.equals("快递员")) {
				jobId = "6";
			}
			if (jobName.equals("营业员/接送货员/收银员")) {
				jobId = "7";
			}
			if (jobName.equals("理货员")) {
				jobId = "8";
			}
			params.put("jobId",jobId);
			totalNum =  (Integer)this.getSqlSession().selectOne(NAMESPACE + "getJobNumManagerOther", params);	
		}
		if (totalNum == null) {
			return 0;
		}
		return totalNum;

	}
	
	/**
	 * 查询xx岗位xx组织所有员工信息
	 * @param orgid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeVO> getJobEmp(String orgid, String jobName) {
		// TODO Auto-generated method stub
		Map<String, String> params = new HashMap<String, String>();
		params.put("orgId",orgid);
		params.put("jobName",jobName);
		
		if (jobName.equals("所有管理人员") || jobName.equals("高级经理及以上管理人员")|| jobName.equals("总监及以上管理人员")) {
			return this.getSqlSession().selectList(NAMESPACE + "getNoticeJobEmpManager", params);
		}else {
			//其余岗位得通过查询其它表才可以得到 
			String jobId = null;
			if (jobName.equals("营业网点经理")) {
				jobId = "4";
			}
			if (jobName.equals("司机")) {
				jobId = "5";
			}
			if (jobName.equals("快递员")) {
				jobId = "6";
			}
			if (jobName.equals("营业员/接送货员/收银员")) {
				jobId = "7";
			}
			if (jobName.equals("理货员")) {
				jobId = "8";
			}
			params.put("jobId",jobId);
			
			return this.getSqlSession().selectList(NAMESPACE + "getNoticeJobEmpOther", params);
		}
		
	}
	
	
	/**
	 * 获取组织领导
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeVO> getLeaderEmpInfoByOrgid(String orgid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orgId", orgid);
		return this.getSqlSession().selectList(NAMESPACE + "getLeadEmps", params);
	}

	@Override
	public EmployeeVO getLeaderEmp(String empCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("empCode", empCode);
		return (EmployeeVO) this.getSqlSession().selectOne(NAMESPACE + "getLeaderEmp", params);
	}
	/**
	 * 获取组织名称
	 * @return
	 */
	@Override
	public String getOrgNameByEmpCode(String empCode) {
		return (String) this.getSqlSession().selectOne(NAMESPACE + "getOrgNameByEmpCode", empCode);

	}

}
