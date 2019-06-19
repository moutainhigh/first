package com.deppon.dpm.module.common.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.deppon.dpm.module.common.server.dao.ILoginInfoDao;
import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;
import com.deppon.dpm.module.common.shared.domain.LoginInfoEntity;
import com.deppon.dpm.module.common.shared.domain.SmsEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 操作登录用户信息的数据操作类
 * 
 * @author tianyong date
 * 
 */

public class LoginInfoDao extends iBatis3DaoImpl implements ILoginInfoDao {

	/**
	 * namespace
	 */
	private static final String NAMESPACE = "com.deppon.dpm.module.common.server.dao.logininfo.";
	
	/**
	 * 更新用户登录信息
	 */
	@Override
	public void updateLoginInfoById(EmpExtensionEntity empExtensionEntity) {
		this.getSqlSession().update(NAMESPACE + "updateLoginInfoById", empExtensionEntity);
	}
	/**
	 * 批量更新登录状态
	 */
	@Override
	public void updateStatusByIds(List<Integer> ids) {
		this.getSqlSession().update(NAMESPACE + "updateStatusByIds", ids);
	}
	
	/**
	 * 根据用户id查询出在线登录信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmpExtensionEntity> queryLoginInfoByEmpCode(String userCode) {
		return (List<EmpExtensionEntity>)this.getSqlSession().selectList(NAMESPACE + "queryLoginInfoByEmpCode", userCode);
	}

	/**
	 * 插入登录用户信息
	 */
	@Override
	public int insert(LoginInfoEntity user) {
		// 插入
		return this.getSqlSession().insert(NAMESPACE + "insert", user);
	}

	/**
	 * 插入设备信息
	 */
	@Override
	public int addDeviceToken(EmpExtensionEntity empExtensionEntity) {
		// 插入
		return this.getSqlSession().insert(NAMESPACE + "addDeviceToken", empExtensionEntity);
	}

	/**
	 * 根据工号查询设备信息
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<String> queryDeviceNumByEmpCode(String empCode) {
		// 查询
		return this.getSqlSession().selectList(NAMESPACE + "queryDeviceNumByEmpCode", empCode);
	}

	/**
	 * 更多信息查询
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmpExtensionEntity> queryMore(EmpExtensionEntity empExtensionEntity) {
		// 查询
		return this.getSqlSession().selectList(NAMESPACE + "queryMore", empExtensionEntity);
	}

	/**
	 * 更新设备信息
	 */
	@Override
	public int updateStatusByDeviceToken(EmpExtensionEntity empExtensionEntity) {
		// 更新
		return this.getSqlSession().update(NAMESPACE + "updateStatusByDeviceToken", empExtensionEntity);
	}

	/****************** 短信 ******************/
	/**
	 * 判断设备是否存在以及是否需要短信验证
	 */
	@Override
	public String existUserIdAndDeviceToken(String userId, String deviceToken, boolean flag) {
		// 是否登录过
		if (flag) {
			// 用以参数拼接
			Map<String, String> map = new HashMap<String, String>();
			// 工号
			map.put("userId", userId);
			// 设备号
			map.put("deviceToken", deviceToken);
			// 查询得到，表示登陆过
			int count = (Integer) getSqlSession().selectOne(NAMESPACE + "existUserIdAndToken", map);
			// 返回
			if (count > 0) {
				// 存在信息
				return "exist";
			}
		}
		// 查询对应设备短息开关状态
		String result = (String) this.getSqlSession().selectOne(NAMESPACE + "querySmsStatus", userId);
		// 没有值，表示不存在，默认短信关闭
		if (null == result) {
			// 返回off
			result = "off";
		}
		// 返回result
		return result;
	}

	/**
	 * 保存短信开关的状态
	 */
	@Override
	public void saveUserIdAndDeviceToken(String userId, String deviceToken, String smsStatus) {
		// 用以参数拼接
		Map<String, String> map = new HashMap<String, String>();
		// 工号
		map.put("userId", userId);
		// 设备号
		map.put("deviceToken", deviceToken);
		// 短信状态
		map.put("smsStatus", smsStatus);
		// 通过工号查询
		List<SmsEntity> smsList = queryByUserId(userId);
		// 没查询到，保存数据库
		if (null == smsList || smsList.size() == 0) {
			// 插入
			getSqlSession().insert(NAMESPACE + "saveUserIdAndDeviceToken", map);
		} else {
			// 更新
			Map<String, Object> updateData = new HashMap<String, Object>(); 
			updateData.put("smsList", smsList);
			updateData.put("deviceToken", deviceToken);
			updateData.put("smsStatus", smsStatus);
			// 更新设备
			getSqlSession().update(NAMESPACE + "updateUserIdAndDeviceToken", updateData);
		}
	}

	/**
	 * 获取手机号
	 */
	@Override
	public String getPhone(String userId) {
		// 查询
		return (String) getSqlSession().selectOne(NAMESPACE + "getPhone", userId);
	}

	/**
	 * 通过userId查询
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SmsEntity> queryByUserId(String userId) {
		// 查询
		return getSqlSession().selectList(NAMESPACE + "queryByUserId", userId);
	}
	/****************** 短信 ******************/
	
	/**
	 * 根据工号查询历史的登录设备信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmpExtensionEntity> queryAllLoginInfoByEmpCode(String empCode,int start,int rows) {
		
		return getSqlSession().selectList(NAMESPACE + "queryAllLoginInfoByEmpCode", empCode, new RowBounds(start, rows));
	}
	
	/**
	 * 根据工号查询用户历史登录设备等信息总条数
	 */
	@Override
	public long queryCountByEmpCode(String empCode) {
		return (Long) getSqlSession().selectOne(NAMESPACE + "queryCountByEmpCode", empCode);
	}
}
