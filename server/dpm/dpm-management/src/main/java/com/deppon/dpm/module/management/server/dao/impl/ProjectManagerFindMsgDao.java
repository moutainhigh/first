package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.IProjectManagerFindMsgDao;
import com.deppon.dpm.module.management.shared.domain.BaseQualityPollingEntity;
import com.deppon.dpm.module.management.shared.domain.ProIocBeanEntity;
import com.deppon.dpm.module.management.shared.domain.ProcCountEntity;
import com.deppon.dpm.module.management.shared.domain.ProcHistorySubmitEntity;
import com.deppon.dpm.module.management.shared.domain.ProjectManagerFindMsgEntity;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
import com.deppon.foss.framework.shared.util.string.StringUtil;

public class ProjectManagerFindMsgDao extends iBatis3DaoImpl implements IProjectManagerFindMsgDao{
	static String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.busmanager.projectManagerFindMsgDao";
	
	/* (non-Javadoc)
	 * <p>Title: getHistoryInfo</p>
	 * <p>Description:获取历史评分信息 </p>
	 * @param msgBean
	 * @return
	 * @see com.deppon.dpm.module.management.server.dao.IProjectManagerFindMsgDao#getHistoryInfo(com.deppon.dpm.module.management.shared.domain.ProjectManagerFindMsgEntity)
	 */
	@Override
	public List<BaseQualityPollingEntity> getHistoryInfo(ProjectManagerFindMsgEntity msgBean) {
		return this.getSqlSession().selectList(mapperNameSpace+".getHistoryInfo",msgBean);
	}

	/* (non-Javadoc)
	 * <p>Title: getIocInfo</p>
	 * <p>Description:获取评分项和图片的关系</p>
	 * @return
	 * @throws BusinessException
	 * @see com.deppon.dpm.module.management.server.dao.IProjectManagerFindMsgDao#getIocInfo()
	 */
	@Override
	public List<ProIocBeanEntity> getIocInfo() throws BusinessException {
		return this.getSqlSession().selectList(mapperNameSpace+".getIocInfo");
	}

	/**
	* <p>
	* Description: 计算工程巡检门店数据
	* </p>
	* 
	* @param mark
	* 参数
	* @return 工程数据
	* @throws BusinessException
	* 抛出异常
	*/
	@SuppressWarnings("unchecked")
	public List<ProcCountEntity> getProcCount(String mark) throws BusinessException {
		if (!StringUtil.isEmpty(mark)) {
			return this.getSqlSession().selectList(mapperNameSpace + ".getProcCount", mark);
			}
		return null;
	}

	/**
	* <p>
	* Description: 得到工程巡检门店总数
	* </p>
	* 
	* @return int
	* @throws BusinessException
	* 抛出异常
	*/
	public int getCountStore() throws BusinessException {
	return (Integer) this.getSqlSession().selectOne(
	mapperNameSpace + ".getCountStore");

	}

	/* (non-Javadoc)
	 * <p>Title: getTotalScore</p>
	 * <p>Description:统计历史总评分数</p>
	 * @return
	 * @throws BusinessException
	 * @see com.deppon.dpm.module.management.server.dao.IProjectManagerFindMsgDao#getTotalScore()
	 */
	@Override
	public int getTotalScore(ProjectManagerFindMsgEntity total) throws BusinessException {
		return (Integer)this.getSqlSession().selectOne(mapperNameSpace+".getTotalScore",total);
	}

	@Override
	public int getAdrZeroScore(ProjectManagerFindMsgEntity bean)
			throws BusinessException {
		return (Integer)this.getSqlSession().selectOne(mapperNameSpace+".getAdrZeroScore",bean);
	}

	@Override
	public int getCountProId(ProjectManagerFindMsgEntity bean) throws BusinessException {
		return (Integer)this.getSqlSession().selectOne(mapperNameSpace+".getCountProId",bean);
	}

	/* (non-Javadoc)
	 * <p>Title: getHitScoreOrZero</p>
	 * <p>Description:提交前统计历史总记录</p>
	 * @param bean
	 * @return
	 * @throws BusinessException
	 * @see com.deppon.dpm.module.management.server.dao.IProjectManagerFindMsgDao#getHitScoreOrZero(com.deppon.dpm.module.management.shared.domain.ProjectManagerFindMsgEntity)
	 */
	@Override
	public List<ProjectManagerFindMsgEntity> getHisScoreOrZero(ProjectManagerFindMsgEntity bean)
			throws BusinessException {
		return this.getSqlSession().selectList(mapperNameSpace + ".getHisScoreOrZero",bean);
		
	}

	/* (non-Javadoc)
	 * <p>Title: getEmpInfo</p>
	 * <p>Description:获取员工信息</p>
	 * @param userNo
	 * @return
	 * @throws BusinessException
	 * @see com.deppon.dpm.module.management.server.dao.IProjectManagerFindMsgDao#getEmpInfo(java.lang.String)
	 */
	@Override
	public List<ProjectManagerFindMsgEntity> getEmpInfo(String userNo)
			throws BusinessException {
		return this.getSqlSession().selectList(mapperNameSpace + ".getEmpInfo",userNo);
		
	}

	/* <p>Title: hisSubmit  最近历史提交记录</p>
	 * <p>Description: 最近历史提交记录</p>
	 * @param proAdress
	 * @param userNo
	 * @return
	 * @throws BusinessException
	 * @see com.deppon.dpm.module.management.server.dao.IProjectManagerFindMsgDao#hisSubmit(java.lang.String, java.lang.String)
	 */
	@Override
	public List<ProcHistorySubmitEntity> hisSubmit(ProcHistorySubmitEntity hisSubmit) throws BusinessException {
		return this.getSqlSession().selectList(mapperNameSpace + ".hisSubmit",hisSubmit);
	}

	@Override
	public int saveHisSubmit(ProcHistorySubmitEntity hisSubmit)
			throws BusinessException {
		return this.getSqlSession().insert(mapperNameSpace+".saveHisSubmit",hisSubmit);
	}

	@Override
	public int updateHisSubmit(ProcHistorySubmitEntity hisSubmit)
			throws BusinessException {
		return this.getSqlSession().update(mapperNameSpace+".updateHisSubmit",hisSubmit);
	}

	

	
}
