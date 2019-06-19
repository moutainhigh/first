package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ProcSurveySubmitSaveClientEntity;
import com.deppon.foss.framework.exception.BusinessException;

public interface IProcSurveySubmitSaveClientDao {

	/**保存到图片
	 * @param parBean
	 * @return
	 * @throws BusinessException
	 */
	public int saveNativeToPhoto(ProcSurveySubmitSaveClientEntity parBean) throws BusinessException;
	/**保存到关系表
	 * @param dateList
	 * @return
	 * @throws BusinessException
	 */
	public int saveNativeToRelation(List<ProcSurveySubmitSaveClientEntity> relaBean) throws BusinessException;
	/*
	 * 更新状态
	 */
	public int updateTaskStatus(int checkId) throws BusinessException;
	/*
	 * 检验任务id
	 */
	public int checkNativeToPhoto(int checkId) throws BusinessException;
	/*
	 * 检验任务保存提交错误日志
	 */
	public int saveToPCLog(ProcSurveySubmitSaveClientEntity parLog) throws BusinessException;
	/*
	 * 检验任务保存提交前保存日志
	 */
	public int saveToPCLogBefore(ProcSurveySubmitSaveClientEntity parLog) throws BusinessException;
	
}
