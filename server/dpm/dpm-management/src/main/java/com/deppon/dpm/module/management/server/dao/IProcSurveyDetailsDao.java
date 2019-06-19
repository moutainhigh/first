package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ProcSurveyMsg;
import com.deppon.dpm.module.management.shared.domain.ProcSurveyPhoto;

/**
 * @author 268101 工程勘测详情dao接口
 * 
 */
public interface IProcSurveyDetailsDao {
	/**
	 * @param partCode
	 *            勘测项目code
	 * @return 勘测详情
	 */
	public List<ProcSurveyMsg> getProcDeatils(String partCode);
	
	/**
	 * @return 求详情总数
	 */
	public int countDetail();
	
	/**
	 * @param partCode 勘测项目code
	 * @param checkId 勘测项id
	 * @return list
	 */
	public List<String> getListId(String partCode, String checkId);
	
	/**
	 * @param partCode 勘测项目code
	 * @return list
	 */
	public List<ProcSurveyMsg> lineIdList(String partCode,String proCode);
	
	/**
	 * @param checkId 已勘测的检查id
	 * @return 详细数据
	 */
	public List<ProcSurveyPhoto> getPhotoDetail(String checkId);
	
	

}
