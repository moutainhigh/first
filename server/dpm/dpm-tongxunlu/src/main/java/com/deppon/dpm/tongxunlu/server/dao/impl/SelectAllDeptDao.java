package com.deppon.dpm.tongxunlu.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.jpush.api.utils.StringUtils;

import com.deppon.dpm.tongxunlu.server.dao.ISelectAllDeptDao;
import com.deppon.dpm.tongxunlu.shared.domain.SelectAllDeptEntity;
import com.deppon.dpm.tongxunlu.shared.vo.OrgMappingVO;
import com.deppon.dpm.tongxunlu.shared.vo.SelectAllDeptVO;
import com.deppon.dpm.tongxunlu.shared.vo.SelectNameAndPicVO;
import com.deppon.dpm.tongxunlu.shared.vo.DeptMappingVO;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * //智慧门店查询所有相关部门信息
 * 
 * @author RY
 *
 */
public class SelectAllDeptDao extends iBatis3DaoImpl implements
		ISelectAllDeptDao {
	/**
	 * namespace
	 */
	private static final String NAMESPACE = "com.deppon.dpm.tongxunlu.server.dao.employee.";

	@SuppressWarnings("unchecked")
	@Override
	// 智慧门店查询所有相关部门信息
	public List<SelectAllDeptEntity> selectAllDept(String JOBNAME, String PARENTORGID) {
		// 将传值封装成map
				Map<String, String> map = new HashMap<String, String>();
				map.put("JOBNAME", JOBNAME);
				map.put("PARENTORGID", PARENTORGID);
			// 智慧门店查询所有相关部门信息
			return this.getSqlSession().selectList(NAMESPACE + "selectAllDept",map);
		
	}

	// 智慧门店根据工号查询所有相关部门信息
	@Override
	public SelectAllDeptEntity selectAllDeptByempcode(String empCode) {
		// TODO Auto-generated method stub
		// 智慧门店根据工号查询所有相关部门信息
		return (SelectAllDeptEntity) this.getSqlSession().selectOne(
				NAMESPACE + "selectAllDeptByempcode", empCode);
	}
	/**
	 * 查询专业部门人员信息
	 * @author XiaoTian
	 * @param  orgname = 门店服务部
	 * @return SelectAllDeptEntity
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectAllDeptEntity> findStoreServiceDepartment(String empcode) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(NAMESPACE + "findStoreServiceDepartment",empcode);
	}
	/**
	 * 根据员工号的list查询营业部头像
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectAllDeptEntity> selectAllDeptpic(List<String> empcodelist) {
		// TODO Auto-generated method stub
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("empcodelist", empcodelist);
		return this.getSqlSession().selectList(NAMESPACE + "selectAllDeptpic",map);
	}
	/**
	 * 根据工号查询德邦所有人员信息
	 */
	@Override
	public SelectAllDeptEntity selectUserByEmpcode(String empCode) {
		// 根据工号查询德邦所有人员信息
		return (SelectAllDeptEntity) this.getSqlSession().selectOne(NAMESPACE + "selectUserByEmpcode", empCode);
	}
	/**
	 * 根据工号查询智慧门店相关人员信息
	 * @author RY
	 */
	@Override
	public SelectAllDeptVO selectInfoByEmpCode(String empcode) {
		//根据工号查询智慧门店相关人员级别
		return  (SelectAllDeptVO) this.getSqlSession().selectOne(NAMESPACE + "selectPsnLevelByEmpCode", empcode);
	}
	/**
	 *  根据deptseq和jobname查询02人员领导
	 *  @author RY
	 */
	@SuppressWarnings("unchecked")
	@Override
	public SelectAllDeptVO selectUpInfo02(List<String> orgidlist, String jobname) {
		// 将传值封装成map
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("orgidlist", orgidlist);
		map.put("jobname", jobname);
		return (SelectAllDeptVO) this.getSqlSession().selectOne(NAMESPACE + "selectUpInfo02", map);
	}
	/**
	 *  根据deptseq和jobname查询03人员领导
	 *  @author RY
	 */
	@Override
	public SelectAllDeptVO selectUpInfo03(List<String> orgidlist, String jobname) {
		// 将传值封装成map
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("orgidlist", orgidlist);
		map.put("jobname", jobname);
		return (SelectAllDeptVO) this.getSqlSession().selectOne(NAMESPACE + "selectUpInfo03", map);
	}
	/**
	 * 登陆者为01级别则查询除02表所有角色
	 * @author RY
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectAllDeptVO> selectInfo02(Integer nowPage,Integer pageSize,String searchInfo) {
		// 登陆者为01级别则查询除02表所有角色
		// 将传值封装成map
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("rowBegin",nowPage==null?null:(nowPage-1)*pageSize);
		map.put("pageSize",nowPage==null?null:pageSize);
		map.put("searchInfo", searchInfo);
		return this.getSqlSession().selectList(NAMESPACE + "selectInfo02",map);
	}
	/**
	 * 02角色查询03角色信息
	 * @author RY
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectAllDeptVO> selectInfo03(String deptseq ,Integer nowPage,Integer pageSize,String searchInfo) {
		// 将传值封装成map
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("deptseq", deptseq);
		map.put("rowBegin",nowPage==null?null:(nowPage-1)*pageSize);
		map.put("pageSize",nowPage==null?null:pageSize);
		map.put("searchInfo", searchInfo);
		// 02角色查询03角色信息
		return this.getSqlSession().selectList(NAMESPACE + "selectInfo03",map);
	}
	/**
	 * 03角色查询04角色信息
	 * @author RY
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectAllDeptVO> selectInfo04(String deptseq ,Integer nowPage,Integer pageSize,String searchInfo) {
		// 将传值封装成map
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("deptseq", deptseq);
		map.put("rowBegin",nowPage==null?null:(nowPage-1)*pageSize);
		map.put("pageSize",nowPage==null?null:pageSize);
		map.put("searchInfo", searchInfo);
		// 02角色查询03角色信息
		return this.getSqlSession().selectList(NAMESPACE + "selectInfo04",map);
	}
	/**
	 * 04查询05角色和05查询05角色
	 * @author RY
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectAllDeptVO> selectInfo05(String deptseq ,Integer nowPage,Integer pageSize,String searchInfo) {
		// 将传值封装成map
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("deptseq", deptseq);
		map.put("rowBegin",nowPage==null?null:(nowPage-1)*pageSize);
		map.put("pageSize",nowPage==null?null:pageSize);
		map.put("searchInfo", searchInfo);
		// 02角色查询03角色信息
		return this.getSqlSession().selectList(NAMESPACE + "selectInfo05",map);
	}
	/**
	 * 管理员 查询05视图所有信息
	 * @author RY
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectAllDeptVO> selectSelfTest(Integer nowPage,Integer pageSize,String searchInfo,Integer mark) {
		// 将传值封装成map
		Map<Object, Object> map = new HashMap<Object, Object>();
		if(null==mark||mark!=1){
			map.put("rowBegin",nowPage==null?null:(nowPage-1)*pageSize);
			map.put("pageSize",nowPage==null?null:pageSize);
		}
		map.put("searchInfo", searchInfo);
		return this.getSqlSession().selectList(NAMESPACE + "selectSelfTest",map);
	}
	/**
	 *  查询角色信息（个人信息如头像） 
	 */
	@Override
	public SelectAllDeptEntity selectdpmAdmin(String empCode) {
		// 查询特殊角色信息 
		return (SelectAllDeptEntity) this.getSqlSession().selectOne(NAMESPACE + "selectdpmAdmin",empCode);
	}
	/**
	 * 02角色查询下属营业部
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectAllDeptVO> selectDeptBy02(String empCode,Integer nowPage,Integer pageSize,String searchInfo,Integer mark) {
		// 将传值封装成map
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("empCode", empCode);
		if(null==mark||mark!=1){
			map.put("rowBegin",nowPage==null?null:(nowPage-1)*pageSize);
			map.put("pageSize",nowPage==null?null:pageSize);
		}
		map.put("searchInfo", searchInfo);
		return this.getSqlSession().selectList(NAMESPACE + "selectDeptBy02",map);
	}
	/**
	 * 03角色查询下属营业部
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectAllDeptVO> selectDeptBy03(String empCode,Integer nowPage,Integer pageSize,String searchInfo,Integer mark) {
		// 将传值封装成map
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("empCode", empCode);
		if(null==mark||mark!=1){
			map.put("rowBegin",nowPage==null?null:(nowPage-1)*pageSize);
			map.put("pageSize",nowPage==null?null:pageSize);
		}
		map.put("searchInfo", searchInfo);
		return this.getSqlSession().selectList(NAMESPACE + "selectDeptBy03",map);
	}
	/**
	 * 04角色查询下属营业部
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectAllDeptVO> selectDeptBy04(String empCode,Integer nowPage,Integer pageSize,String searchInfo,Integer mark) {
		// 将传值封装成map
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("empCode", empCode);
		if(null==mark||mark!=1){
			map.put("rowBegin",nowPage==null?null:(nowPage-1)*pageSize);
			map.put("pageSize",nowPage==null?null:pageSize);
		}
		map.put("searchInfo", searchInfo);
		return this.getSqlSession().selectList(NAMESPACE + "selectDeptBy04",map);
	}
	/**
	 * 05角色查询下属营业部
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectAllDeptVO> selectDeptBy05(String empCode,String searchInfo) {
		// 将传值封装成map
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("empCode", empCode);
		map.put("searchInfo", searchInfo);
		return this.getSqlSession().selectList(NAMESPACE + "selectDeptBy05",map);
	}
	/**
	 * 根据工号查询seq
	 * @param empcode
	 * @return
	 */
	@Override
	public SelectAllDeptVO selectSeqByEmpCode(String empcode) {
		//根据工号查询智慧门店相关人员seq
		return  (SelectAllDeptVO) this.getSqlSession().selectOne(NAMESPACE + "selectSeqByEmpCode", empcode);
	}
	/**
	 * 根据工号list查询人员信息
	 * @author RY
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectAllDeptEntity> foreachInfoByEmpCode(List<String> list) {
		// 根据工号list查询人员信息
		return this.getSqlSession().selectList(NAMESPACE + "foreachInfoByEmpCode",list);
	}
	/**
	 * 组织映射
	 * @author RY
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OrgMappingVO> orgMapping() {
		// 组织映射
		return (List<OrgMappingVO>) this.getSqlSession().selectList(NAMESPACE + "orgMapping");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SelectNameAndPicVO> selectNameAndPic(List<String> list) {
		// 根据工号list查询人员信息
		return this.getSqlSession().selectList(NAMESPACE + "selectNameAndPic",list);
	}
	/**
	 * 查询智能门店所有人员信息  映射
	 * @author RY
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DeptMappingVO> deptMapping() {
		//查询智能门店所有人员信息  映射
		return (List<DeptMappingVO>) this.getSqlSession().selectList(NAMESPACE + "deptMapping");
	}
}
