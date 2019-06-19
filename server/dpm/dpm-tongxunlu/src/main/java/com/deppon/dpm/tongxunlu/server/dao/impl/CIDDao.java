package com.deppon.dpm.tongxunlu.server.dao.impl;

import java.util.List;

import com.deppon.dpm.tongxunlu.server.dao.ICIDDao;
import com.deppon.dpm.tongxunlu.shared.domain.CIDEntity;
import com.deppon.dpm.tongxunlu.shared.vo.CIDEMP;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class CIDDao extends iBatis3DaoImpl implements ICIDDao{
	
	private static final String NAME_SPACE = "com.deppon.dpm.tongxunlu.server.dao.impl.CIDDao.";

	@SuppressWarnings("unchecked")
	@Override
	public List<CIDEntity> queryCIDByOsType(String osType) {
		return this.getSqlSession().selectList(NAME_SPACE + "queryCIDByOsType", osType);
	}

	@Override
	public void updateCID(CIDEntity cidEntity) {
		this.getSqlSession().update(NAME_SPACE + "updateCID", cidEntity);
	}

	@Override
	public void insertCID(CIDEntity entity) {
		this.getSqlSession().insert(NAME_SPACE + "insertCID", entity);
	}
	
	/**
	 * 根据手机号查询用户信息
	 * 
	 * @param iphoneNo
	 * @return
	 */
	@Override
	public List<CIDEMP> queryUserInfoByNo(String iphoneNo) {
		return this.getSqlSession().selectList(NAME_SPACE + "queryUserInfoByNo", iphoneNo);
	}
	
	/**
	 * 根据工号查询上级部门信息
	 * 
	 * @param iphoneNo
	 * @return
	 */
	@Override
	public String queryOrgIdByUserId(String userId) {
		String orgId = null;
		List<String> list = this.getSqlSession().selectList(NAME_SPACE + "queryOrgIdByUserId", userId);
		if(list != null && list.size()>0){
			orgId = list.get(0);
		}
		return orgId;
	}
}
