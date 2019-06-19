package com.deppon.dpm.login.server.service;

import java.util.Map;

import com.deppon.dpm.login.server.domain.CasUserEntity;

public interface ICasLoginService {
	/**
	 * Cas登陆 login: <br/>
	 * 
	 * Date:2014-8-22下午12:56:33
	 * 
	 * @author 157229-zxy
	 * @param userId
	 * @param pass
	 * @return
	 * @since JDK 1.6
	 */
	public CasUserEntity login(String userId, String pass);

	/**
	 * 获取角色信息 getRole: <br/>
	 * 
	 * Date:2014-8-22下午12:56:46
	 * 
	 * @author 157229-zxy
	 * @param userId
	 * @param appId
	 * @return
	 * @since JDK 1.6
	 */
//	public String getRole(String userId, String appId);

	/**
	 * 
	 * fetchCASValidInfo: <br/>
	 * 
	 * Date:2014-8-22下午12:56:54
	 * 
	 * @author 157229-zxy
	 * @param validInfo
	 * @throws Exception
	 * @since JDK 1.6
	 */
	public void fetchCASValidInfo(Map<String, Object> validInfo,String userId)
			throws Exception;
}
