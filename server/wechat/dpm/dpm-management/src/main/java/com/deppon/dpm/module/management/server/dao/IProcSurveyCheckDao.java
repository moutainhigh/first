package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ProcSurveyCheck;

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
	 * @throws Exception
	 */
	public int saveprocSurvey(ProcSurveyCheck check) throws Exception;
	
	/**
	 * 是否存在重复数据
	 * @param checkName
	 * @param checkCode
	 * @return
	 * @throws Exception
	 */
	public List<ProcSurveyCheck> getCountByCode(String checkName, String checkCode)
			throws Exception;

	/**
	 * 根据id更新数据失效
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updSurveyMark(int id) throws Exception;
	
	
	/**
	 * 根据工号查出对应的信息 
	 * @param userNo
	 * @param keyWord
	 * @return
	 * @throws Exception
	 */
	public List<ProcSurveyCheck> getProjectList(String userNo, String keyWord) throws Exception;
}
