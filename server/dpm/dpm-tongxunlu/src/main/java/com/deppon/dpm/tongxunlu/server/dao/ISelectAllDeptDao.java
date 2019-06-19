package com.deppon.dpm.tongxunlu.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.deppon.dpm.tongxunlu.shared.domain.SelectAllDeptEntity;
import com.deppon.dpm.tongxunlu.shared.vo.OrgMappingVO;
import com.deppon.dpm.tongxunlu.shared.vo.SelectAllDeptVO;
import com.deppon.dpm.tongxunlu.shared.vo.SelectNameAndPicVO;
import com.deppon.dpm.tongxunlu.shared.vo.DeptMappingVO;

/**
 * //智慧门店查询所有相关部门信息
 * 
 * @author RY
 *
 */
public interface ISelectAllDeptDao {
	// 智慧门店查询所有相关部门信息
	List<SelectAllDeptEntity> selectAllDept(String JOBNAME, String PARENTORGID);

	// 智慧门店根据工号查询所有相关部门信息
	SelectAllDeptEntity selectAllDeptByempcode(String empCode);

	/**
	 * 查询专业部门人员信息
	 * 
	 * @author XiaoTian
	 * @param orgname
	 *            = 门店服务部
	 * @return SelectAllDeptEntity
	 */
	List<SelectAllDeptEntity> findStoreServiceDepartment(String empcode);

	/**
	 * 根据员工号的list查询营业部头像
	 */
	List<SelectAllDeptEntity> selectAllDeptpic(List<String> empcodelist);

	/**
	 * 根据工号查询德邦所有人员信息
	 */
	SelectAllDeptEntity selectUserByEmpcode(String empCode);

	/**
	 * 根据工号查询智慧门店相关人员信息
	 * 
	 * @author RY
	 */
	SelectAllDeptVO selectInfoByEmpCode(String empcode);

	/**
	 * 根据deptseq和jobname查询02人员领导
	 * 
	 * @author RY
	 */
	SelectAllDeptVO selectUpInfo02(List<String> orgidlist, String jobname);

	/**
	 * 根据deptseq和jobname查询03人员领导
	 * 
	 * @author RY
	 */
	SelectAllDeptVO selectUpInfo03(List<String> orgidlist, String jobname);

	/**
	 * 登陆者为01级别则查询除02表所有角色
	 * 
	 * @author RY
	 */
	List<SelectAllDeptVO> selectInfo02(Integer nowPage,Integer pageSize,String searchInfo);

	/**
	 * 02角色查询03角色信息
	 * 
	 * @author RY
	 */
	List<SelectAllDeptVO> selectInfo03(String deptseq,Integer nowPage,Integer pageSize,String searchInfo);

	/**
	 * 03角色查询04角色信息
	 * 
	 * @author RY
	 */
	List<SelectAllDeptVO> selectInfo04(String deptseq,Integer nowPage,Integer pageSize,String searchInfo);

	/**
	 * 04查询05角色和05查询05角色
	 * 
	 * @author RY
	 */
	List<SelectAllDeptVO> selectInfo05(String deptseq,Integer nowPage,Integer pageSize,String searchInfo);
	/**
	 * 管理员 查询05视图所有信息
	 * 
	 * @author RY
	 */
	List<SelectAllDeptVO> selectSelfTest(Integer nowPage, Integer pageSize,String searchInfo,Integer mark);

	/**
	 * 查询特殊角色信息
	 */
	SelectAllDeptEntity selectdpmAdmin(String empCode);

	/**
	 * 02角色查询下属营业部
	 */
	List<SelectAllDeptVO> selectDeptBy02(String empCode, Integer nowPage,Integer pageSize,String searchInfo,Integer mark);

	/**
	 * 03角色查询下属营业部
	 */
	List<SelectAllDeptVO> selectDeptBy03(String empCode, Integer nowPage,Integer pageSize,String searchInfo,Integer mark);

	/**
	 * 04角色查询下属营业部
	 */
	List<SelectAllDeptVO> selectDeptBy04(String empCode, Integer nowPage,Integer pageSize,String searchInfo,Integer mark);

	/**
	 * 05角色查询下属营业部
	 */
	List<SelectAllDeptVO> selectDeptBy05(String empCode,String searchInfo);
	/**
	 * 根据工号查询智慧门店相关人员seq
	 * 
	 * @author RY
	 */
	SelectAllDeptVO selectSeqByEmpCode(String empcode);
	/**
	 * 根据工号list查询人员信息
	 * @author RY
	 */
	List<SelectAllDeptEntity> foreachInfoByEmpCode (List<String> list);
	/**
	 * 组织映射
	 * @author RY
	 */
	List<OrgMappingVO> orgMapping();
	/**
	 * @author RY
	 */
	List<SelectNameAndPicVO> selectNameAndPic(List<String> list);
	/**
	 * 查询智能门店所有人员信息  映射
	 * @author RY
	 */
	List<DeptMappingVO> deptMapping();
}
