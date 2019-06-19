package com.deppon.dpm.module.management.server.service;

import com.deppon.dpm.module.management.shared.vo.LoginUserVO;

public interface IUserService {
	
	/**
	 * 获取登录的用户信息
	 * @param userNo
	 * @return
	 */
	public LoginUserVO getLoginUserVO(String userNo);
	
}
