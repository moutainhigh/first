package com.deppon.dpm.tongxunlu.server.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.server.dao.IExternalMethodDao;
import com.deppon.dpm.tongxunlu.shared.domain.MyConsumptionRequestEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class ExternalMethodDao extends iBatis3DaoImpl implements IExternalMethodDao{

	/**
	 * namespace
	 */
	private String NAME_SPACE = "com.deppon.dpm.tongxunlu.server.dao.impl.ExternalMethodDao.";
	
	/**
	 * 根据工号查询员工信息
	 */
	public EmployeeVO getEmpInfo(String empCode){
		
		return (EmployeeVO) this.getSqlSession().selectOne(NAME_SPACE + "getEmpInfo", 
				empCode);
	}
	
	/**
	 * 根据工号获取部门信息
	 */
	public OrganizationVO getDeptByEmpcode(String empCode){
		
		return (OrganizationVO) this.getSqlSession().selectOne(NAME_SPACE + "getDeptByEmpcode", 
				empCode);
	}
	
	/**
	 * 根据部门id查询部门领导
	 */
	@SuppressWarnings("unchecked")
	public List<EmployeeVO> getLeaderInfo(int orgid){
		
		return getSqlSession().selectList(NAME_SPACE + "getLeaderInfo", orgid); 
	}

	/**
	 * 根据一组部门id查询部门领导
	 */
	@SuppressWarnings("unchecked")
	public List<EmployeeVO> getALLLeaderInfo(List<MyConsumptionRequestEntity> orglist){

		List<String> orgid = new ArrayList<String>();
		for(MyConsumptionRequestEntity mc : orglist){
			orgid.add(mc.getDeptId());
		}
		return getSqlSession().selectList(NAME_SPACE + "getALLLeaderInfo", orgid);
	}
	
	/**
	 * 判断员工所在部门是否有高于他等级的管理层
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EmployeeVO> getUpperManager(int orgid,String joblevel){
		Map map = new HashMap();
		map.put("orgid", orgid);
		map.put("joblevel", joblevel);
		return getSqlSession().selectList(NAME_SPACE + "getUpperManager", map); 
	}
	
	/**
	 * 根据部门id查询上级部门关系序列
	 */
	public String getUpperOrg(int orgid){
		
		return (String) this.getSqlSession().selectOne(NAME_SPACE + "getUpperOrg", 
				orgid);
	}
	
	/**
	 * 根据工号或姓名搜索员工(员工姓名工号，部门id名称，头像地址)
	 */
	@SuppressWarnings("unchecked")
	public List<EmployeeVO> getEmpInfolist(String employee){
		
		return getSqlSession().selectList(NAME_SPACE + "getEmpInfolist", employee); 
	}
	
	/**
	 * 根据工号获取工号，姓名，部门id，部门名
	 */
    public MyConsumptionRequestEntity getDept(String empNo){
    	return (MyConsumptionRequestEntity)getSqlSession().selectOne(NAME_SPACE + "getDept", empNo);	 
    }
	
    /**
     * 根据组织id查询所有子组织信息
     */
	@SuppressWarnings("unchecked")
	public List<MyConsumptionRequestEntity> getChildOrgs(String orgid){
		
		return getSqlSession().selectList(NAME_SPACE + "getChildOrgs", orgid); 
	}
	
	/**
	 * 查询一个大部门下的所有大小部门
	 * @param orgid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<MyConsumptionRequestEntity> getAllChilddept(String orgid){
		
		return getSqlSession().selectList(NAME_SPACE + "getAllChilddept", orgid); 
	}
	
	/**
	 * 查询相同部门的人的工号姓名
	 */
	@SuppressWarnings("unchecked")
	public List<MyConsumptionRequestEntity> getSameLevelEmp(String orgid,String empNo){
		Map<String,String> map = new HashMap<String,String>();
		map.put("orgid", orgid);
		map.put("empNo", empNo);
		return getSqlSession().selectList(NAME_SPACE + "getSameLevelEmp", map); 
	}
	
	/**
	 * 查询部门人数
	 */
	public int getEmpNum(String orgid){
		Integer EmpNum = (Integer) this.getSqlSession().selectOne(NAME_SPACE + "getEmpNum",orgid);
		if(EmpNum!=null){
			return EmpNum;
		}else{
			return  0;
		}
	}
	
	/**
	 * 判断是否有相同联系方式 
	 */
	public int getSameMobile (String mobileno){
		
		return (Integer) this.getSqlSession().selectOne(NAME_SPACE + "getSameMobile", 
				mobileno);
	}
	
	/**
	 * 根据部门名获取部门id
	 */
	public String getOrgnameById(String orgname){
		
		return (String) this.getSqlSession().selectOne(NAME_SPACE + "getOrgnameById", 
				orgname);
	}
	
	/**
	 * 根据手机号获取工号
	 */
	@SuppressWarnings("unchecked")
	public List<String> getEmpcodebyTel(List<String> moblist){
		
		return this.getSqlSession().selectList(NAME_SPACE + "getEmpcodebyTel", 
				moblist);
	}
}
