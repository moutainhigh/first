package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * @author 268101 IProcCheckFindScoreShowDao 接口
 * 
 */
public interface IProcCheckFindScoreShowDao {
	/*
	 * <!--获取初次、最终验收明细查询-->
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao
	 * #getHisScoreFind
	 * (com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	public List<ProcCheckScoreEntity> getHisScoreFind(
			ProcCheckScoreEntity paraBean) throws BusinessException;

	/*
	 * 状态1、2 统计扣分总数和扣分项
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao
	 * #getCountScore
	 * (com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	public List<ProcCheckScoreEntity> getCountScore(
			ProcCheckScoreEntity paraBean) throws BusinessException;

	/*
	 * 查询导航栏信息 (non-Javadoc)
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao
	 * #getNaviInfo
	 * (com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	public List<ProcCheckScoreEntity> getNaviInfo() throws BusinessException;

	/*
	 * 查询导航栏信息 (non-Javadoc)
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao
	 * #getNaviInfo
	 * (com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	public List<ProcCheckScoreEntity> getNaviItem(String navCode)
			throws BusinessException;

	/*
	 * <!--1 暂存时进入明细界面（初次按钮点击之前）--> (non-Javadoc)
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao
	 * #getNaviItemFirstBefore
	 * (com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	public List<ProcCheckScoreEntity> getNaviItemFirstBefore(
			ProcCheckScoreEntity paraBean) throws BusinessException;

	/*
	 * <!--2 暂存时进入明细界面（初次按钮点击之后）--> (non-Javadoc)
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao
	 * #getNaviItemFirstAfter
	 * (com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	public List<ProcCheckScoreEntity> getNaviItemFirstAfter(
			ProcCheckScoreEntity paraBean) throws BusinessException;

	/*
	 * 更新为暂存(0变1) (non-Javadoc)
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao
	 * #updateBranchIsCheck(java.lang.String)
	 */
	public int updateBranchIsCheck(String addressCode) throws BusinessException;

	/*
	 * <!--状态2点击最终提交按钮之后统计扣分项和扣分数（暂时没有用）-->
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao
	 * #getCountScoreEnd
	 * (com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	public List<ProcCheckScoreEntity> getCountScoreEnd(
			ProcCheckScoreEntity paraBean) throws BusinessException;

	/*
	 * <!--状态3暂存时进入明细界面（最终按钮点击之后）--> (non-Javadoc)
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao
	 * #getNaviItemFinish
	 * (com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	public List<ProcCheckScoreEntity> getNaviItemFinish(
			ProcCheckScoreEntity paraBean) throws BusinessException;

	/*
	 * <!--状态3统计扣分总数和扣分项（最终按钮点击之后）--> (non-Javadoc)
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao
	 * #getNaviItemFinish
	 * (com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	public List<ProcCheckScoreEntity> getCountScoreFinish(
			ProcCheckScoreEntity paraBean) throws BusinessException;

	/*
	 * <!--获取历史扣分记录--> (non-Javadoc)
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao
	 * #getHisPointsList
	 * (com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	public List<ProcCheckScoreEntity> getHisPointsList(
			ProcCheckScoreEntity paraBean) throws BusinessException;

}
