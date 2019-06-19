package com.deppon.dpm.module.main.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.main.server.dao.IRollAdDao;
import com.deppon.dpm.module.main.shared.domain.RollAddDetailEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class RollAdDao extends iBatis3DaoImpl implements IRollAdDao{
	
	/**
	 * namespace
	 */
	private String NAME_SPACE = "com.deppon.dpm.module.main.server.dao.rollAd.";
	
	/**
	 * 上传广告
	 * @return 
	 */
	
	@Override
	public int upload(RollAddDetailEntity rollAdd) {
		return this.getSqlSession().insert(NAME_SPACE + "insert",rollAdd);
		
	}

	@Override
	public RollAddDetailEntity getRollAdDetail(int id) {
		// TODO Auto-generated method stub
		return (RollAddDetailEntity) this.getSqlSession().selectOne(NAME_SPACE + "getRollAdDetail", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RollAddDetailEntity> getRollAdList(String appType) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(NAME_SPACE + "getRollAdList",appType);
	}

	@Override
	public int deleteRollAd(int id) {
		// TODO Auto-generated method stub
		return this.getSqlSession().delete(NAME_SPACE + "deleteRollAd",id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RollAddDetailEntity> getAllRollAdList() {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(NAME_SPACE + "getAllRollAdList");
	}

	@Override
	public int update(RollAddDetailEntity rollAdd) {
		// TODO Auto-generated method stub
		return this.getSqlSession().update(NAME_SPACE + "update",rollAdd);
	}
	

}
