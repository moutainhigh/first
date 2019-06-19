package com.deppon.dpm.module.management.server.dao.impl;

import com.deppon.dpm.module.management.server.dao.IUserDao;
import com.deppon.dpm.module.management.shared.vo.LoginUserVO;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 
 * @author 王亚男
 * 获取用户信息
 */
public class UserDao extends iBatis3DaoImpl implements IUserDao {

	private String mapperNameSpace="com.deppon.dpm.module.management.server.dao.user";
	
	/**
	 * 根据工号查询用户信息
	 * @param userNo
	 * @return
	 */
	public LoginUserVO getLoginUserVO(String userNo) {
		return (LoginUserVO) this.getSqlSession().selectOne(mapperNameSpace+".getUserVo", userNo);
	}
	
}
