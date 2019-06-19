package com.deppon.dpm.module.common.server.action;

import java.util.HashMap;
import java.util.Map;

import com.deppon.dpm.module.common.server.service.ILoginInfoService;

/**
 * 内外网判断action
 * 
 * @author 231586
 * 
 */
public class CheckNetAction extends BaseAction {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3106939925691515933L;
	/**
	 * 工号
	 */
	private String userId;
	/**
	 * 设备号
	 */
	private String deviceToken;
	/**
	 * 判断是否需要更新service
	 */
	private ILoginInfoService loginInfoService;
	
	/**
	 * 内外网检查
	 */
	public void checkNet() {
		// 定义返回map
		Map<String, String> map = new HashMap<String, String>();
		// 获取是否需要更新
		Map<String, Object> change = loginInfoService.getChange();
		// 1代表内网
		map.put("result", "1");
		// change不为null
		if (null != change) {
			// 存入信息(更新)
			map.put((String) change.get("dict_name"),
					(String) change.get("dict_value"));
		} else {
			// 不更新
			map.put("is_resource_load", "N");
		}
		// 返回前端
		writeToPage(map);
	}

	/**
	 * get
	 * @return
	 */
	public ILoginInfoService getLoginInfoService() {
		return loginInfoService;
	}

	/**
	 * set
	 * @param loginInfoService
	 */
	public void setLoginInfoService(ILoginInfoService loginInfoService) {
		this.loginInfoService = loginInfoService;
	}
	/**
	 * get
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * get
	 * @return
	 */
	public String getDeviceToken() {
		return deviceToken;
	}

	/**
	 * set
	 * @param deviceToken
	 */
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
}
