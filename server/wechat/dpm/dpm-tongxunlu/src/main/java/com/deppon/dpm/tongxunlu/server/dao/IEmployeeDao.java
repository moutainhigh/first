package com.deppon.dpm.tongxunlu.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

/**
 * 职员操作. TODO(描述类的职责)
 * <p style="display:none">
 * modifyRecord
 * </p>
 * <p style="display:none">
 * version:V1.0,author:130126,date:2014-4-10 上午11:11:58,content:TODO
 * </p>
 * 
 * @author 130126
 * @date 2014-4-10 上午11:11:58
 * @since
 * @version
 */
public interface IEmployeeDao {
	/**
	 * 添加人员.
	 * <p>
	 * TODO(方法详细描述说明、方法参数的具体涵义)
	 * </p>
	 * 
	 * @author 130126
	 * @date 2014-4-10 下午4:35:26
	 * @param emp
	 * @see
	 */
	public int insert(EmployeeEntity emp);

	/**
	 * 人员添加
	 * 
	 * @param vo
	 * @return
	 */
	public int insert(EmployeeVO vo);

	/**
	 * 更新职员.
	 * 
	 * @param emp
	 */
	public int update(EmployeeVO emp);

	/**
	 * 删除用户
	 * 
	 * @param empId
	 */
	public int del(int empId);

	/**
	 * 根据工号删除
	 * 
	 * @param empCode
	 * @return
	 */
	public int deleteByEmpcode(String empCode);

	/**
	 * 查询人员.
	 * <p>
	 * TODO(方法详细描述说明、方法参数的具体涵义)
	 * </p>
	 * 
	 * @author 130126
	 * @date 2014-4-10 下午4:35:33
	 * @param emp
	 * @return
	 * @see
	 */
	public List<EmployeeVO> query(EmployeeVO emp, int start, int pageSize);
	
	/**
	 * 合伙人搜索人员
	 * @param condition
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<EmployeeVO> queryForPartner(EmployeeVO condition, int start,
			int pageSize);

	/**
	 * 返回记录数量.
	 * 
	 * @param emp
	 * @return
	 */
	public int querySize(EmployeeVO emp);

	/**
	 * 
	 * @param pid
	 * @return
	 */
	public int getEmpByOrgIdCount(String pid);

	/**
	 * 根据工号查询，屏蔽领导号码
	 * 
	 * @param params
	 * @return
	 */
	public EmployeeEntity queryEmployeeByCode(EmployeeVO params);
	
	/**
	 * 根据工号查询
	 */
	public EmployeeEntity selectOne(EmployeeVO params);

	/**
	 * @author 045925
	 * @param empid
	 * @return
	 */
	public int updateCallQuntityByEmpId(int empId);

	/**
	 * 查询推送人员
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> queryPushUser(Map<String, String> map);

	/**
	 * 查询全部人员
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getAllUser();

	/****************** 手势密码 ******************/
	/**
	 * 获取手势密码
	 * 
	 * @param empCode
	 * @return
	 */
	public Map<String, Object> getGustureStatus(String empCode);

	/**
	 * 更新手势密码状态
	 * 
	 * @param empCode
	 * @param inGustureStatus
	 * @return
	 */
	public int updateGustureStatus(String empCode, String inGustureStatus);

	/**
	 * 更新手势密码
	 * 
	 * @param userId
	 * @param password
	 */
	public void updateGesturePassword(String userId, String password);

	/**
	 * 查询手势密码
	 * 
	 * @param userId
	 * @return
	 */
	public String queryGesturePassword(String userId);

	/**
	 * 保存手势密码
	 * 
	 * @param userId
	 * @param password
	 */
	public void saveGesturePassword(String userId, String password);

	/**
	 * 保存手势密码状态
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	public int saveGustureStatus(String userId, String password);

	/****************** 手势密码 ******************/

	/*** 点赞、鸡蛋 ***/
	/**
	 * 获取数据
	 * 
	 * @param objId
	 * @return
	 */
	public Map<String, Object> getCount(String objId);

	/**
	 * 鸡蛋操作
	 * 
	 * @param map
	 * @return
	 */
	public int operate(Map<String, String> map);

	/**
	 * 发现
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getPersonPics(Map<String, Object> map);

	/**
	 * 获取排序
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getSort(Map<String, String> map);

	/**
	 * 判断是否存在
	 * 
	 * @param userId
	 * @param objId
	 * @return
	 */
	public List<String> checkExist(String userId, String objId);

	/*** 点赞、鸡蛋 ***/

	/**
	 * @author 付众 新增员工数量查询
	 * @date 2015-08-13
	 */
	public int uumsQuerySize(EmployeeVO vo);

	/******* 最美微笑操作 ********/
	/**
	 * 获取最美微笑数量
	 * 
	 * @param objId
	 * @return
	 */
	public Map<String, Object> getSmileCount(String objId);

	/**
	 * 操作
	 * 
	 * @param map
	 * @return
	 */
	public int operateSmile(Map<String, String> map);

	/**
	 * 最美微笑
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getSmilePersonPics(Map<String, Object> map);

	/**
	 * 最美微笑排序
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getSmileSort();

	/**
	 * 查看是否存在
	 * 
	 * @param userId
	 * @param objId
	 * @return
	 */
	public List<String> checkSmileExist(String userId, String objId);

	/******* 最美微笑操作 ********/

	/**
	 * 通讯录leader列表
	 * 
	 * @return
	 */
	public List<String> getEmpleaderConfig();

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
	 * 根据userids查询人员信息
	 * @param userIdArray
	 * @return
	 */
	public List<EmployeeVO> queryEmpByUserIds(String[] userIdArray);

	/**
	 * 同步来电显示通讯录查询所有人员信息
	 * @return
	 */
	public List<EmployeeVO> queryAllForCID();
	
	/**
	 * 通讯录被搜索的vp用户List
	 * 
	 * @return
	 */
	public List<String> queryMonitorEmpCodeList();

	/**
	 * 保存通讯录搜索vp日志
	 * 
	 * @param map
	 * @return
	 */
	public int insertmonitorVpSearch(Map<String, String> map);

}
