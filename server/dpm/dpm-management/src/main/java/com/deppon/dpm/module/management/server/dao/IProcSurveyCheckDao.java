package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ProcSurveyCheck;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 工程勘测dao
 * 
 * @author 293888
 * 
 */
public interface IProcSurveyCheckDao {
	/**
	 * 保存工程信息
	 * 
	 * @param check
	 * @return
	 * @throws BusinessException
	 */
	public int saveprocSurvey(ProcSurveyCheck check) throws BusinessException;
	
	/**
	 * 是否存在重复数据
	 * @param checkName
	 * @param checkCode
	 * @return
	 * @throws BusinessException
	 */
	public List<ProcSurveyCheck> getCountByCode(String checkName, String checkCode)
			throws BusinessException;

	/**
	 * 根据id更新数据失效
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public int updSurveyMark(int id) throws BusinessException;
	
	
	/**
	 * 根据工号查出对应的信息 
	 * @param userNo
	 * @param keyWord
	 * @return
	 * @throws BusinessException
	 */
	public List<ProcSurveyCheck> getProjectList(String userNo, String keyWord) throws BusinessException;
}
