package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao;
import com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * @author 268101
 * ProcCheckFindScoreShowDao 接口实现
 *
 */
public class ProcCheckFindScoreShowDao extends iBatis3DaoImpl implements IProcCheckFindScoreShowDao{

	private String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.ProcCheckFindScoreShowDao";

	/* <!--获取初次、最终验收明细查询-->
	 * @see com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao#getHisScoreFind(com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	@Override
	public List<ProcCheckScoreEntity> getHisScoreFind(ProcCheckScoreEntity paraBean) throws Exception{
		return this.getSqlSession().selectList(mapperNameSpace+".getHisScoreFind",paraBean);
	}

	/*状态1、2 统计扣分总数和扣分项
	 * @see com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao#getCountScore(com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	@Override
	public List<ProcCheckScoreEntity> getCountScore (
			ProcCheckScoreEntity paraBean) throws Exception{
		return this.getSqlSession().selectList(mapperNameSpace+".getCountScore",paraBean);
	}

	/* 查询导航栏信息
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao#getNaviInfo(com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	@Override
	public List<ProcCheckScoreEntity> getNaviInfo() throws Exception{
		return this.getSqlSession().selectList(mapperNameSpace+".getNaviInfo");
	}

	/* 0 获取导航栏下的检查项的信息
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao#getNaviItem(java.lang.String)
	 */
	@Override
	public List<ProcCheckScoreEntity> getNaviItem(String navCode)
			throws Exception {
		return this.getSqlSession().selectList(mapperNameSpace+".getNaviItem",navCode);
	}

	/* <!--1 暂存时进入明细界面（初次按钮点击之前）-->
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao#getNaviItemFirstBefore(com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	@Override
	public List<ProcCheckScoreEntity> getNaviItemFirstBefore(ProcCheckScoreEntity paraBean)
			throws Exception {
		return this.getSqlSession().selectList(mapperNameSpace+".getNaviItemFirstBefore",paraBean);
	}
	
	/* <!--2 暂存时进入明细界面（初次按钮点击之后）-->
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao#getNaviItemFirstAfter(com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	@Override
	public List<ProcCheckScoreEntity> getNaviItemFirstAfter(
			ProcCheckScoreEntity paraBean) throws Exception {
		return this.getSqlSession().selectList(mapperNameSpace+".getNaviItemFirstAfter",paraBean);
	}

	/* 更新为暂存(0变1)
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao#updateBranchIsCheck(java.lang.String)
	 */
	@Override
	public int updateBranchIsCheck(String addressCode)
			throws Exception {
		return this.getSqlSession().update(mapperNameSpace+".updateBranchIsCheck",addressCode);
	}

	/*<!--状态2点击最终提交按钮之后统计扣分项和扣分数（暂时没有用）-->
	 * @see com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao#getCountScoreEnd(com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	@Override
	public List<ProcCheckScoreEntity> getCountScoreEnd(
			ProcCheckScoreEntity paraBean) throws Exception {
		return this.getSqlSession().selectList(mapperNameSpace+".getCountScoreEnd",paraBean);
	}

	/* <!--状态3暂存时进入明细界面（最终按钮点击之后）-->
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao#getNaviItemFinish(com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	@Override
	public List<ProcCheckScoreEntity> getNaviItemFinish(
			ProcCheckScoreEntity paraBean) throws Exception {
		return this.getSqlSession().selectList(mapperNameSpace+".getNaviItemFinish",paraBean);
	}
	/* <!--状态3统计扣分总数和扣分项（最终按钮点击之后）-->
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao#getNaviItemFinish(com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	@Override
	public List<ProcCheckScoreEntity> getCountScoreFinish(
			ProcCheckScoreEntity paraBean) throws Exception {
		return this.getSqlSession().selectList(mapperNameSpace+".getCountScoreFinish",paraBean);
	}

	/*  <!--获取历史扣分记录-->
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao#getHisPointsList(com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity)
	 */
	@Override
	public List<ProcCheckScoreEntity> getHisPointsList(
			ProcCheckScoreEntity paraBean) throws Exception {
		return this.getSqlSession().selectList(mapperNameSpace+".getHisPointsList",paraBean);
	}
	

}
