package com.deppon.dpm.module.management.server.dao;

import com.deppon.dpm.module.management.shared.vo.LoginUserVO;

public interface IUserDao {
	
	/**
	 * 根据工号查询用户信息
	 * @param userNo
	 * @return
	 */
	public LoginUserVO getLoginUserVO(String userNo);
}
