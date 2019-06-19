package com.deppon.dpm.module.common.server.service;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;

/**
 * 登录信息service层
 * 
 */
public interface ILoginInfoService {

	/**
	 * 存储用户登录信息
	 * 
	 * @param userCode
	 * @param loginType
	 * @param osType
	 * @return
	 */
	public int saveUserLogin(String userCode, String loginType, String osType, String appVersion);

	/**
	 * 查询用户设备信息
	 * @param userId
	 * @param osType
	 * @param deviceToken
	 * @return
	 */
	public void saveUserDevice(String userId,String osType,String deviceToken);
	
	/**
	 * 判断用户是否登录
	 * 
	 * @param userCode
	 * @param deviceToken
	 * @param osType
	 * @param latitude
	 * @param longitude
	 * @param location
	 * @return
	 */
	/*public EmpExtensionEntity checkDevice(String userCode, String deviceToken,
			String osType, String latitude, String longitude, String location);*/
	public EmpExtensionEntity checkDevice(String userCode, String deviceToken,EmpExtensionEntity parm);

	/**
	 * 检查用户登陆状态
	 * 
	 * @param empCode
	 * @param deviceToken
	 * @return
	 */
	public EmpExtensionEntity checkStatus(String empCode, String deviceToken);

	/**
	 * 判断该用户的密码状态
	 * 
	 * @param userId
	 * @param deviceToken
	 * @param flag
	 * @return
	 */
	public String existUserIdAndDeviceToken(String userId, String deviceToken,
			boolean flag);

	/**
	 * 保存短信开关状态
	 * 
	 * @param userId
	 * @param deviceToken
	 * @param smsStatus
	 */
	public void saveUserIdAndDeviceToken(String userId, String deviceToken,
			String smsStatus);

	/**
	 * 获取手机号
	 * 
	 * @param userId
	 * @return
	 */
	public String getPhone(String userId);

	/**
	 * 判断是否需要更新
	 * 
	 * @return
	 */
	public Map<String, Object> getChange();

	/**
	 * 根据工号查询用户历史登录设备等信息
	 * @param empCode
	 * @return
	 */
	public List<EmpExtensionEntity> queryAllLoginInfoByEmpCode(String empCode,int start, int rows);

	/**
	 * 根据工号查询用户历史登录设备等信息总条数
	 * @param empCode
	 * @return
	 */
	public long queryCountByEmpCode(String empCode);
}
