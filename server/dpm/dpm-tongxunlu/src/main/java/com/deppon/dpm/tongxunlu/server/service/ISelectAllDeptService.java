package com.deppon.dpm.tongxunlu.server.service;

import java.util.List;

import com.deppon.dpm.tongxunlu.shared.domain.SelectAllDeptEntity;
import com.deppon.dpm.tongxunlu.shared.vo.OrgMappingVO;
import com.deppon.dpm.tongxunlu.shared.vo.SelectAllDeptVO;
import com.deppon.dpm.tongxunlu.shared.vo.SelectNameAndPicVO;
import com.deppon.dpm.tongxunlu.shared.vo.DeptMappingVO;
/**
 * 
 * @author RY
 *智慧门店查询所有相关部门信息
 */
public interface ISelectAllDeptService {
	//智慧门店查询所有相关部门信息
	List<SelectAllDeptEntity> selectAllDept(String JOBNAME,String PARENTORGID);
	//智慧门店根据工号查询所有相关部门信息
	SelectAllDeptEntity selectAllDeptByempcode(String empCode);
	/**
	 * 查询专业部门人员信息
	 * @author XiaoTian
	 * @param  orgname = 门店服务部
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
	 * 根据工号查询智慧门店相关人员级别
	 * @author RY
	 */
	SelectAllDeptVO selectInfoByEmpCode(String empcode);
	/**
	 *  查询执行人
	 *  @author RY
	 */
	List<SelectAllDeptVO> selectUpInfo(String deptseq,String psnlevel,Integer nowPage,Integer pageSize,String searchInfo);
	/**
	 * 根据执行人查询下属所有营业部
	 * @author RY
	 */
	List<SelectAllDeptVO> selectAll(String empCode,String deptseq,String psnlevel,Integer nowPage,Integer pageSize,String searchInfo,Integer mark);
	/**
	 *  查询角色信息（个人信息如头像） 
	 */
	SelectAllDeptEntity selectdpmAdmin(String empCode);
	/**
	 * 根据工号list查询人员信息
	 * @author RY
	 */
	List<SelectAllDeptEntity> foreachInfoByEmpCode (String list);
	/**
	 * 组织映射
	 * @author RY
	 */
	List<OrgMappingVO> orgMapping();
	/**
	 * 
	 */
	List<SelectNameAndPicVO> selectNameAndPic(String list);
	/**
	 * 查询智能门店所有人员信息  映射
	 * @author RY
	 */
	List<DeptMappingVO> deptMapping();
}
