package com.deppon.dpm.module.common.server.dao;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;
import com.deppon.dpm.module.common.shared.domain.LoginInfoEntity;
import com.deppon.dpm.module.common.shared.domain.SmsEntity;

/**
 * 登录信息dao层
 * 
 */
public interface ILoginInfoDao {
	/**
	 * 插入登录用户信息
	 * 
	 * @param user
	 * @return
	 */
	public int insert(LoginInfoEntity user);

	/**
	 * 添加设备用户信息
	 * 
	 * @param empExtensionEntity
	 * @return
	 */
	public int addDeviceToken(EmpExtensionEntity empExtensionEntity);

	/**
	 * 根据工号查询之前设备信息
	 * 
	 * @param empCode
	 * @return
	 */
	public List<String> queryDeviceNumByEmpCode(String empCode);

	/**
	 * 查询更多信息
	 * 
	 * @param empExtensionEntity
	 * @return
	 */
	public List<EmpExtensionEntity> queryMore(EmpExtensionEntity empExtensionEntity);

	/**
	 * 更新设备对应的状态
	 * 
	 * @param empExtensionEntity
	 * @return
	 */
	public int updateStatusByDeviceToken(EmpExtensionEntity empExtensionEntity);

	/**
	 * 短信
	 * 
	 * @param userId
	 * @param deviceToken
	 * @param flag
	 * @return
	 */
	public String existUserIdAndDeviceToken(String userId, String deviceToken, boolean flag);

	/**
	 * 保存短信对应状态
	 * 
	 * @param userId
	 * @param deviceToken
	 * @param smsStatus
	 */
	public void saveUserIdAndDeviceToken(String userId, String deviceToken, String smsStatus);

	/**
	 * 获取手机
	 * 
	 * @param userId
	 * @return
	 */
	public String getPhone(String userId);

	/**
	 * 通过userId查询信息
	 * 
	 * @param userId
	 * @return
	 */
	public List<SmsEntity> queryByUserId(String userId);

	/**
	 * 根据用户id查询出所有的在线登录信息
	 * @param userCode
	 * @return
	 */
	public List<EmpExtensionEntity> queryLoginInfoByEmpCode(String userCode);

	/**
	 * 批量更新登录状态
	 * @param ids
	 */
	public void updateStatusByIds(List<Integer> ids);
	
	/**
	 * 更新用户登录信息
	 * @param empExtensionEntity
	 */
	public void updateLoginInfoById(EmpExtensionEntity empExtensionEntity);

	/**
	 * 根据工号查询历史的登录设备信息
	 * @param empCode
	 * @return
	 */
	public List<EmpExtensionEntity> queryAllLoginInfoByEmpCode(String empCode,int start,int rows);

	/**
	 * 根据工号查询用户历史登录设备等信息总条数
	 */
	public long queryCountByEmpCode(String empCode);
}
