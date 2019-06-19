package com.deppon.dpm.tongxunlu.server.dao;

import java.util.List;

import com.deppon.dpm.tongxunlu.shared.domain.CIDEntity;
import com.deppon.dpm.tongxunlu.shared.vo.CIDEMP;

public interface ICIDDao {

	List<CIDEntity> queryCIDByOsType(String osType);

	void updateCID(CIDEntity cidEntity);

	void insertCID(CIDEntity entity);

	/**
	 * 根据手机号查询用户信息
	 * 
	 * @param iphoneNo
	 * @return
	 */
	public List<CIDEMP> queryUserInfoByNo(String iphoneNo);
	
	/**
	 * 根据工号查询上级部门信息
	 * 
	 * @param iphoneNo
	 * @return
	 */
	public String queryOrgIdByUserId(String userId);
	
}
