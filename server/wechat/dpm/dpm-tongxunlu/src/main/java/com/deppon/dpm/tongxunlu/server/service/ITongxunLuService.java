package com.deppon.dpm.tongxunlu.server.service;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.domain.HotLine;
import com.deppon.dpm.tongxunlu.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;

/**
 * 通讯录
 */
public interface ITongxunLuService {
	/**
	 * 根据组织机构查询下面的人员列表.
	 */
	public List<EmployeeVO> getEmpByOrgId(String pid, int start, int limit);

	/**
	 * 查询组织机构下面的人员数量.
	 */
	public int getEmpByOrgIdCount(String pid);

	/**
	 * 查询节点详情.
	 */
	public EmployeeVO getEmpDetail(String id,String empCode);

	/**
	 * 获取组织详细信息
	 * @param id
	 * @return
	 */
	public OrganizationVO getOrgDetail(String id);

	/**
	 * 根据条件搜索子节点列表.
	 */
	public List<EmployeeVO> searchEmp(EmployeeVO condition, int start,
			int pageSize);
	
	/**
	 * 合伙人搜索人员
	 */
	public List<EmployeeVO> searchEmpForPartner(EmployeeVO searchVo, int start,
			int pageSize);

	/**
	 * 组织列表
	 * @param condition
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<OrganizationVO> searchOrg(OrganizationVO condition, int start,
			int pageSize);
	
	/**
	 * 查询合伙人权限的组织列表
	 * @param searchVo
	 * @param i
	 * @param j
	 * @return
	 */
	public List<OrganizationVO> searchOrgForPartner(OrganizationVO searchVo,
			int i, int j);

	/**
	 * 组织数量
	 * @param emp
	 * @return
	 */
	public int queryOrgSize(OrganizationVO emp);

	/**
	 * 人员数组
	 * @param emp
	 * @return
	 */
	public int queryEmpSize(EmployeeVO emp);

	/**
	 * 登陆.
	 */
	public String login(String userid, String password);

	/**
	 * 打电话匹配次数
	 * @param list
	 * @return
	 */
	public int updateCallQuntity(List<EmployeeVO> list);

	/**
	 * 数据监控
	 * @param monitorType
	 * @param empCode
	 * @param osType
	 */
	public void dataMonitor(int monitorType, String empCode, String osType);

	/**
	 * 查询推送人员
	 * @param json
	 * @return
	 */
	public List<Map<String, Object>> queryPushUser(String json);

	/**
	 * 广播推送，查询人员
	 * @return
	 */
	public List<Map<String, Object>> getAllUser();

	/**
	 * 热线
	 * @return
	 */
	public List<HotLine> hotLine();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<OrganizationEntity> searchOrgArchitecture(String id);
	
	/** uums同步员工开始 **/
	// 添加
	public int addEmployee(EmployeeVO vo);
	// 更新
	public int updateEmployee(EmployeeVO vo);
	// 删除
	public int delEmployee(String empCode);
	/**
	 * @author 付众  新增员工数量查询
	 * @date 2015-08-13
	 */
	public int uumsQuerySize(EmployeeVO vo);
	/** uums同步员工结束 **/
	
	/** uums同步组织开始 **/
	// 添加
	public int addOrg(OrganizationEntity entity);
	// 更新
	public int updateOrg(OrganizationEntity entity);
	// 删除
	public int delOrg(int orgId);
	// 删除和添加
	public int delAndAdd(EmployeeVO vo);
	/** uums同步组织结束 **/
	
	/*****点赞、鸡蛋*****/
	// 获取详情数据
	public Map<String, Object> getCount(String userId, String objId);
	// 点赞、扔鸡蛋
	public int operate(Map<String, String> map);
	// 发现
	public List<Map<String, Object>> getPersonPics(Map<String, Object> map);
	// 排序
	public List<Map<String, Object>> getSort(Map<String, String> map);
	/*****点赞、鸡蛋*****/
	
	/**
	 * 查询员工详情，无头像，屏蔽领导号码
	 * @param params
	 * @return
	 */
	public EmployeeEntity queryEmployeeByCode(EmployeeVO params);
	
	/**
	 * 查询员工详情
	 */
	public EmployeeEntity selectOne(EmployeeVO params);

	/*******最美微笑操作********/
	// 点赞、扔鸡蛋
	public int operateSmile(Map<String, String> map);
	// 获取详情数据
	public Map<String, Object> getSmileCount(String userId, String objId);
	// 最美微笑
	public List<Map<String, Object>> getSmilePersonPics(Map<String, Object> map);
	// 最美微笑排序
	public List<Map<String, Object>> getSmileSort(String userId);
	/*******最美微笑操作********/
	/**
	 * 插入通讯录leader信息
	 * 
	 * @param entity
	 * @return
	 */
	public int insertEmpleaderConfig(Map<String, String> map);

	/**
	 * 删除通讯录leader信息
	 * 
	 * @param entity
	 * @return
	 */
	public int deleteEmpleaderConfig(String id);

	/**
	 * 更新通讯录leader信息
	 */
	public int updateEmpleaderConfig(Map<String, String> map);

	/**
	 * 通讯录领导列表
	 * @return
	 */
	public List<String> getEmpleaderConfig();

	/**
	 * 根据ids查询人员信息
	 * @param userIdArray
	 * @return
	 */
	public List<EmployeeVO> queryEmpByUserIds(String[] userIdArray);

	/**
	 * 查询工号/名称map
	 * 
	 * @param empCode
	 * @return
	 */
	public Map<String,String> queryUserMap(String empCode,Map<String,String> usersMap);
	
	/**
	 * 通讯录监控记录：搜索vp用户
	 * 
	 * @param empCodeList
	 * @param empDetail
	 * @param remark
	 */
	public void monitorSearchVpInfo(List<String> empCodeList,EmployeeVO empDetail,String remark);
	
	/**
	 * 获取通讯录被搜索的VP用户List
	 * @return
	 */
	public List<String> queryMonitorEmpCodeList();
	
}
