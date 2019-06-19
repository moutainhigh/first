package com.deppon.dpm.module.management.server.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.management.server.dao.IUserDao;
import com.deppon.dpm.module.management.server.service.IUserService;
import com.deppon.dpm.module.management.shared.vo.LoginUserVO;

/**
 * 
 * @author 王亚男
 *
 */
public class UserService implements IUserService {

	/**
	 * 日志 
	 */
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	/**
	 *  userDao 接口
	 */
	private IUserDao userDao;
	/**
	 * 获取登录的用户信息
	 * @param userNo
	 * @return
	 */
	public LoginUserVO getLoginUserVO(String userNo) {
		logger.info("获取"+userNo+"的信息");
		//返回人员信息
		return this.userDao.getLoginUserVO(userNo);
	}

	/**
	 * @return userDao
	 */
	public IUserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao dao接口
	 */
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	} 

}
