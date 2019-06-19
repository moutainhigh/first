package com.deppon.dpm.module.management.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.server.dao.IpunchClockDao;
import com.deppon.dpm.module.management.shared.domain.PunchClockEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class PunchClockDao extends iBatis3DaoImpl implements IpunchClockDao{
   
	 //命名的工作空间
	private String NAME_SPACE = "com.deppon.dpm.module.management.server.dao.impl.PunchClockDao.";
    
	/**
	 * 考勤记录
	 */
	@Override
	public int syncRecord() {
		// TODO Auto-generated method stub
		return this.getSqlSession().insert(NAME_SPACE+"insert", "");
	}
    
	/**
	 * 查询打卡记录
	 */
	@Override
	public PunchClockEntity getPunchClockRecord(Map<String,Object> map) {
		return (PunchClockEntity) this.getSqlSession().selectOne(NAME_SPACE+"select", map);
	}
    /**
     * 插入打卡记录
     */
	@Override
	public int createRecord(Map<String,Object> map) {
		return this.getSqlSession().insert(NAME_SPACE+"insert", map);
	}

	@Override
	public int updateRecord(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.getSqlSession().update(NAME_SPACE+"update", map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PunchClockEntity> getPunchClockRecordList(String userId) {
		// TODO Auto-generated method stub
		Map<String, Object> hashMap = new HashMap<String,Object>();
		hashMap.put("empCode", userId);
		return this.getSqlSession().selectList(NAME_SPACE+"selectList", hashMap);
	}

	
}
