package com.deppon.dpm.tongxunlu.server.service;

import java.util.List;

import com.deppon.dpm.tongxunlu.shared.domain.CIDEntity;
import com.deppon.dpm.tongxunlu.shared.vo.CIDEMP;

public interface ICIDService {

	List<CIDEntity> queryCIDByOsType(String osType);

	boolean syncCIDBook();
	
	/**
	 * 根据手机号查询用户信息
	 * 
	 * @param iphoneNo
	 * @return
	 */
	public CIDEMP queryUserInfoByNo(String iphoneNo);
	
	/**
	 * 根据工号获取上级部门信息,用户是否是职能研发中心，1：是，0：否
	 */
	public int judgeOrgIdByUserId(String userId);

}
