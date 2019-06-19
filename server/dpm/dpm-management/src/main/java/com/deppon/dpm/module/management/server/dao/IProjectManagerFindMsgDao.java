package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.BaseQualityPollingEntity;
import com.deppon.dpm.module.management.shared.domain.ProIocBeanEntity;
import com.deppon.dpm.module.management.shared.domain.ProcCountEntity;
import com.deppon.dpm.module.management.shared.domain.ProcHistorySubmitEntity;
import com.deppon.dpm.module.management.shared.domain.ProjectManagerFindMsgEntity;
import com.deppon.foss.framework.exception.BusinessException;

public interface IProjectManagerFindMsgDao {

	public List<BaseQualityPollingEntity> getHistoryInfo(ProjectManagerFindMsgEntity msgBean) throws BusinessException;
	public List<ProIocBeanEntity> getIocInfo() throws BusinessException;
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
	public List<ProcCountEntity> getProcCount(String mark) throws BusinessException;

	/**
	* <p>Description: 得到工程巡检门店总数</p>
	* @return int
	* @throws BusinessException 抛出异常
	*/
	public int getCountStore() throws BusinessException;
	public int getTotalScore(ProjectManagerFindMsgEntity total) throws BusinessException;
	public int getAdrZeroScore(ProjectManagerFindMsgEntity bean) throws BusinessException;
	public int getCountProId(ProjectManagerFindMsgEntity bean) throws BusinessException;
	public List<ProjectManagerFindMsgEntity> getHisScoreOrZero(ProjectManagerFindMsgEntity bean) throws BusinessException;
	public List<ProjectManagerFindMsgEntity> getEmpInfo(String userNo) throws BusinessException;
	public List<ProcHistorySubmitEntity> hisSubmit(ProcHistorySubmitEntity hisSubmit) throws BusinessException;
	public int saveHisSubmit(ProcHistorySubmitEntity hisSubmit) throws BusinessException;
	public int updateHisSubmit(ProcHistorySubmitEntity hisSubmit) throws BusinessException;
	
	
	
}
