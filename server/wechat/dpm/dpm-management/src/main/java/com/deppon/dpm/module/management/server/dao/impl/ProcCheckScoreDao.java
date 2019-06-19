package com.deppon.dpm.module.management.server.dao.impl;


import java.util.List;

import com.deppon.dpm.module.common.shared.domain.MonitorCountInfoEntity;
import com.deppon.dpm.module.management.server.dao.IProcCheckScoreDao;
import com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity;
import com.deppon.dpm.module.management.shared.domain.ProcCheckStandardNameEntity;

import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class ProcCheckScoreDao extends iBatis3DaoImpl implements IProcCheckScoreDao{
	
	private  String mappernamespace="com.deppon.dpm.module.management.server.dao.procCheckScoreDao.";

	 /**
     * 保存扣分详情工程验收导航栏表
     * @param procCheckScoreEntity
     * @return int
     */
	public int savaCheckRecord(ProcCheckScoreEntity procCheckScoreEntity) {
		// TODO Auto-generated method stub
		return this.getSqlSession().insert(mappernamespace+"savaCheckRecord", procCheckScoreEntity);
	}

	/**
     * 保存扣分详情工程验收扣分表
     * @param procCheckScoreEntity
     * @return int
     */
	public int savaCheckScore(ProcCheckScoreEntity procCheckScoreEntity) {
		// TODO Auto-generated method stub
		return this.getSqlSession().insert(mappernamespace+"savaCheckScore", procCheckScoreEntity);
	}

	/**
     * 修改工程验收扣分表数据
     * @param procCheckScoreEntity
     * @return int
     */
	public int updateCheckScore(ProcCheckScoreEntity procCheckScoreEntity) {
		// TODO Auto-generated method stub
		return this.getSqlSession().update(mappernamespace+"updateCheckScore", procCheckScoreEntity);
	}

	/**
     * 修改工程验收导航栏表数据
     * @param procCheckScoreEntity
     * @return int
     */
	public int updateCheckRecord(ProcCheckScoreEntity procCheckScoreEntity) {
		// TODO Auto-generated method stub
	    return this.getSqlSession().update(mappernamespace+"updateCheckRecord", procCheckScoreEntity);
	}
	/**
     * 修改工程验收导航栏表数据
     * @param procCheckScoreEntity
     * @return int
     */
	public int updateCheckRecordAll(ProcCheckScoreEntity procCheckScoreEntity) {
		// TODO Auto-generated method stub
		return this.getSqlSession().update(mappernamespace+"updateCheckRecordAll", procCheckScoreEntity);
	}
	/**
     * 查询工程验收导航栏表ID
     * @param procCheckScoreEntity
     * @return int
     */
	public String selectCheckRecordId(ProcCheckScoreEntity procCheckScoreEntity) {
		// TODO Auto-generated method stub
		return  (String) this.getSqlSession().selectOne(mappernamespace+"getProcCheckRecordId", procCheckScoreEntity);
	}
	/**
     * 查询工程验收扣分表ID
     * @param procCheckScoreEntity
     * @return int
     */
	public String selectProcCheckScoreId(ProcCheckScoreEntity procCheckScoreEntity) {
		// TODO Auto-generated method stub
		return (String) this.getSqlSession().selectOne(mappernamespace+"getProcCheckScoreId", procCheckScoreEntity);
	}

	/**
     * 修改工程验收推送表状态
     * @param procCheckScoreEntity
     * @return int
     */
	public int updateCheckTask(ProcCheckScoreEntity procCheckScoreEntity) {
		// TODO Auto-generated method stub
		return this.getSqlSession().update(mappernamespace+"updateCheckTask", procCheckScoreEntity);
	}

	
	
	
	/**
     * 查询工程验收导航栏表1次得分数据
     * @param procCheckScoreEntity
     * @return int
     */
	public List<ProcCheckScoreEntity> getProcCheckRecordAll(
			ProcCheckScoreEntity procCheckScoreEntity) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(mappernamespace+"getProcCheckRecordAll", procCheckScoreEntity);
	}
	/**
     * 查询工程验收扣分表1次得分数据
     * @param procCheckScoreEntity
     * @return int
     */
	public List<ProcCheckScoreEntity> getProcCheckScoreAll(
			List<ProcCheckScoreEntity> id) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(mappernamespace+"getProcCheckScoreAll", id);
	}
	/**
     * 批量保存工程验收扣分表2次得分数据
     * @param procCheckScoreEntity
     * @return int
     */
	public int savaProcCheckScoreAll(
			ProcCheckScoreEntity procCheckScoreEntity) {
		// TODO Auto-generated method stub
		return this.getSqlSession().insert(mappernamespace+"savaProcCheckScoreAll", procCheckScoreEntity);
	}
	/**
     * 批量保存工程验收导航栏表2次得分数据
     * @param procCheckScoreEntity
     * @return int
     */
	public int savaProcCheckRecordAll(
			List<ProcCheckScoreEntity> procCheckScoreEntity) {
		// TODO Auto-generated method stub
		return this.getSqlSession().insert(mappernamespace+"savaProcCheckRecordAll", procCheckScoreEntity);
	}

	/**
     * 查询未保存分数数据
     * @param procCheckScoreEntity
     * @return int
     */
	public String getProcCheckStandardName(ProcCheckStandardNameEntity p) {
		// TODO Auto-generated method stub
		
		return (String) this.getSqlSession().selectOne(mappernamespace+"getProcCheckStandardName",  p);
	}
	 /**
     * 查询扣分保存分数数据
     * @param procCheckScoreEntity
     * @return int
     */
	public ProcCheckStandardNameEntity getProcCheckSelectStandard(
			ProcCheckStandardNameEntity p) {
		// TODO Auto-generated method stub
		return (ProcCheckStandardNameEntity) this.getSqlSession().selectOne(mappernamespace+"getProcCheckSelectStandard",  p);
	}
	/**
     * 数据访问量保存
     * @param MonitorCountInfoEntity
     * @return int
     */
	public int savaCheckControl(MonitorCountInfoEntity m) {
		// TODO Auto-generated method stub
		return this.getSqlSession().insert(mappernamespace+"savaCheckControl", m);
	}

	
}
