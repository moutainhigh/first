package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.MonitorCountInfoEntity;
import com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity;
import com.deppon.dpm.module.management.shared.domain.ProcCheckStandardNameEntity;
/**
 * @author yuanzhonghua 
 * @date  8yue 7hao 
 */

public interface IProcCheckScoreDao {
    /**
     * 保存扣分详情工程验收导航栏表
     * @param procCheckScoreEntity
     * @return int
     */
	public int savaCheckRecord(ProcCheckScoreEntity procCheckScoreEntity);
	/**
     * 保存扣分详情工程验收扣分表
     * @param procCheckScoreEntity
     * @return int
     */
	public int savaCheckScore(ProcCheckScoreEntity procCheckScoreEntity);
	/**
     * 修改工程验收扣分表数据
     * @param procCheckScoreEntity
     * @return int
     */
	public int updateCheckScore(ProcCheckScoreEntity procCheckScoreEntity);
	/**
     * 修改工程验收导航栏表数据
     * @param procCheckScoreEntity
     * @return int
     */
	public int updateCheckRecord(ProcCheckScoreEntity procCheckScoreEntity);
	/**
     * 修改工程验收导航栏表数据
     * @param procCheckScoreEntity
     * @return int
     */
	public int updateCheckRecordAll(ProcCheckScoreEntity procCheckScoreEntity);
	/**
     * 查询工程验收导航栏表ID
     * @param procCheckScoreEntity
     * @return int
     */
	public String selectCheckRecordId(ProcCheckScoreEntity procCheckScoreEntity);
	/**
     * 查询工程验收扣分表ID
     * @param procCheckScoreEntity
     * @return int
     */
	public String selectProcCheckScoreId(ProcCheckScoreEntity procCheckScoreEntity);
	/**
     * 修改工程验收推送表状态
     * @param procCheckScoreEntity
     * @return int
     */
	public int updateCheckTask(ProcCheckScoreEntity procCheckScoreEntity);

	/**
     * 查询工程验收导航栏表1次得分数据
     * @param procCheckScoreEntity
     * @return int
     */

	public List<ProcCheckScoreEntity> getProcCheckRecordAll(ProcCheckScoreEntity procCheckScoreEntity);
	/**
     * 查询工程验收扣分表1次得分数据
     * @param procCheckScoreEntity
     * @return int
     */
	public List<ProcCheckScoreEntity> getProcCheckScoreAll(List<ProcCheckScoreEntity> id);

	/**
     * 批量保存工程验收扣分表2次得分数据
     * @param procCheckScoreEntity
     * @return int
     */
	public int savaProcCheckScoreAll(ProcCheckScoreEntity procCheckScoreEntity);
	/**
     * 批量保存工程验收导航栏表2次得分数据
     * @param procCheckScoreEntity
     * @return int
     */
	public int savaProcCheckRecordAll(List<ProcCheckScoreEntity> procCheckScoreEntity);
	/**
     * 查询未保存分数数据
     * @param procCheckScoreEntity
     * @return int
     */
    public String getProcCheckStandardName(ProcCheckStandardNameEntity p);
    
    /**
     * 查询扣分保存分数数据
     * @param procCheckScoreEntity
     * @return int
     */
    public ProcCheckStandardNameEntity getProcCheckSelectStandard(ProcCheckStandardNameEntity p);
    
    /**
     * 数据访问量保存
     * @param MonitorCountInfoEntity
     * @return int
     */
    public int savaCheckControl(MonitorCountInfoEntity m);
    

}
