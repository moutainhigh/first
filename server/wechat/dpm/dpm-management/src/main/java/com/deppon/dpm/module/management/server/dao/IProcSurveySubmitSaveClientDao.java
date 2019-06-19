package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ProcSurveySubmitSaveClientEntity;

public interface IProcSurveySubmitSaveClientDao {

	/**保存到图片
	 * @param parBean
	 * @return
	 * @throws Exception
	 */
	public int saveNativeToPhoto(ProcSurveySubmitSaveClientEntity parBean) throws Exception;
	/**保存到关系表
	 * @param dateList
	 * @return
	 * @throws Exception
	 */
	public int saveNativeToRelation(List<ProcSurveySubmitSaveClientEntity> relaBean) throws Exception;
	/*
	 * 更新状态
	 */
	public int updateTaskStatus(int checkId) throws Exception;
	/*
	 * 检验任务id
	 */
	public int checkNativeToPhoto(int checkId) throws Exception;
	/*
	 * 检验任务保存提交错误日志
	 */
	public int saveToPCLog(ProcSurveySubmitSaveClientEntity parLog) throws Exception;
	/*
	 * 检验任务保存提交前保存日志
	 */
	public int saveToPCLogBefore(ProcSurveySubmitSaveClientEntity parLog) throws Exception;
	
}
