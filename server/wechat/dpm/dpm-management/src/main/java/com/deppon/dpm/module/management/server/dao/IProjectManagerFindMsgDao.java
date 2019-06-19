package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.BaseQualityPollingEntity;
import com.deppon.dpm.module.management.shared.domain.ProIocBeanEntity;
import com.deppon.dpm.module.management.shared.domain.ProcCountEntity;
import com.deppon.dpm.module.management.shared.domain.ProcHistorySubmitEntity;
import com.deppon.dpm.module.management.shared.domain.ProjectManagerFindMsgEntity;

public interface IProjectManagerFindMsgDao {

	public List<BaseQualityPollingEntity> getHistoryInfo(ProjectManagerFindMsgEntity msgBean) throws Exception;
	public List<ProIocBeanEntity> getIocInfo() throws Exception;
	/**
	* <p>
	* Description: 计算工程巡检门店数据
	* </p>
	* 
	* @param mark
	* 参数
	* @return 工程数据
	* @throws Exception
	* 抛出异常
	*/
	public List<ProcCountEntity> getProcCount(String mark) throws Exception;

	/**
	* <p>Description: 得到工程巡检门店总数</p>
	* @return int
	* @throws Exception 抛出异常
	*/
	public int getCountStore() throws Exception;
	public int getTotalScore(ProjectManagerFindMsgEntity total) throws Exception;
	public int getAdrZeroScore(ProjectManagerFindMsgEntity bean) throws Exception;
	public int getCountProId(ProjectManagerFindMsgEntity bean) throws Exception;
	public List<ProjectManagerFindMsgEntity> getHisScoreOrZero(ProjectManagerFindMsgEntity bean) throws Exception;
	public List<ProjectManagerFindMsgEntity> getEmpInfo(String userNo) throws Exception;
	public List<ProcHistorySubmitEntity> hisSubmit(ProcHistorySubmitEntity hisSubmit) throws Exception;
	public int saveHisSubmit(ProcHistorySubmitEntity hisSubmit) throws Exception;
	public int updateHisSubmit(ProcHistorySubmitEntity hisSubmit) throws Exception;
	
	
	
}
