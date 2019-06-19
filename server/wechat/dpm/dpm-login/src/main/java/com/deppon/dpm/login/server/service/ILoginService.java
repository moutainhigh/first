package com.deppon.dpm.login.server.service;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.login.server.domain.CasUserEntity;
import com.deppon.dpm.login.server.domain.FailLoginInfoEntity;
import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.dpm.uums.server.domain.ResourceEntity;

/**
 * 登陆service接口
 */
public interface ILoginService {
	
	/**
	 * 查询用户登录校验用户名密码错误记录
	 */
	public FailLoginInfoEntity queryFailLoginInfo(String userId);
	
	/**
	 * 更新错误登录记录
	 */
	public void updateFailLoginInfo(FailLoginInfoEntity entity);

	/**
	 * 保存错误登录记录
	 */
	public void saveFailLoginInfo(FailLoginInfoEntity entity);

	/**
	 * 获取角色 getRole: <br/>
	 * 
	 * Date:2014-8-22下午12:57:15
	 * 
	 * @author 157229-zxy
	 * @param userId
	 * @param appId
	 * @return
	 * @since JDK 1.6
	 */
	public String getRole(String userId, String appId);

	/**
	 * 用户登陆服务 userLogin: <br/>
	 * 
	 * Date:2014-8-22下午12:57:26
	 * 
	 * @author 157229-zxy
	 * @param userName
	 * @param pwd
	 * @return
	 * @throws Exception
	 * @since JDK 1.6
	 */
	public CasUserEntity userLogin(String userName, String pwd)
			throws Exception;
	
	/**
	 * web页面用户登录
	 */
	public CasUserEntity webUserLogin(String userName, String pwd, CasUserEntity casUserEntity);
	/**
	 * 单点登陆
	 * 
	 * @param validInfo
	 * @throws Exception
	 */
	public void fetchCASValidInfo(Map<String, Object> validInfo)
			throws Exception;

	/**
	 * 查询用户信息 queryUser: <br/>
	 * 
	 * Date:2014-8-22下午12:58:20
	 * 
	 * @author 157229-zxy
	 * @param userCode
	 * @param roles
	 * @return
	 * @since JDK 1.6
	 */
	public UserEntity queryUser(String userCode, List<String> roles);

	/**
	 * 查询下一级菜单资源 findResources: <br/>
	 * 
	 * Date:2014-8-22下午12:15:50
	 * 
	 * @author 157229-zxy
	 * @param parentCode
	 * @param userEntity
	 * @return
	 * @since JDK 1.6
	 */
	public List<ResourceEntity> findResources(String parentCode,
			UserEntity userEntity);

	/**
	 * 验证用户信息是否有管理平台权限 validBpmWebUser: <br/>
	 * 
	 * Date:2014-8-22下午12:26:52
	 * 
	 * @author 157229-zxy
	 * @param userCode
	 * @param casUserEntity
	 * @return
	 * @since JDK 1.6
	 */
	public boolean validBpmWebUser(String userCode, CasUserEntity casUserEntity);

	/**
	 * 判断是否有手势密码
	 * 
	 * @param userId
	 * @return
	 */
	public boolean hasGesturePassword(String userId);

	/**
	 * 保存手势密码
	 * 
	 * @param userId
	 * @param password
	 */
	public void updateGesturePassword(String userId, String password);

	/**
	 * 判断手势密码是否正确
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	public boolean validateGesturePassword(String userId, String password);

	/**
	 * 获取手势密码状态
	 * 
	 * @param empCode
	 * @return
	 */
	public Map<String, Object> getGustureStatus(String empCode);

	/**
	 * 更新手势密码状态
	 * 
	 * @param userId
	 * @param inGustureStatus
	 * @return
	 */
	public int updateGustureStatus(String userId, String inGustureStatus);

	/**
	 * 保存手势密码
	 * 
	 * @param userId
	 * @param inGustureStatus
	 * @return
	 */
	public int saveGustureStatus(String userId, String inGustureStatus);

	/**
	 * 获取app排序
	 * @param userId  用户ID
	 * @param deviceToken 设备号
	 * @param clearHistory 是否删除APP （ios）
	 * @param newVersion 版本号（12月24号兼容老版本）
	 * @return
	 */
	public Map<String,Object> getApplyStoreSort(String userId, String deviceToken,String clearHistory,int newVersion,List<String> rolesList,String osType,String appVersion);

	/**
	 * 获取公告排序
	 * 
	 * @param userId
	 * @return
	 */
	public String getInfoStoreSort(String userId);

	/**
	 * 查询用户模块异常监控开关
	 * @param userId
	 * @return
	 */
	public boolean queryUserFuncStatus(String userId);


}
