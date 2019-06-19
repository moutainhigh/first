package com.deppon.dpm.module.management.server.service;

/**
 * @author 268101 工程勘测详情service接口
 * 
 */
public interface IProcSurveyDetailsService {
	/**
	 * @param partCode
	 *            勘测部位code
	 * @return 勘测详情数据
	 */
	public String getProcDeatils(String partCode, String checkId);

	/**
	 * @param id
	 *            工程勘测检查表id
	 * @param partCode
	 *            勘测部位code
	 * @return str
	 */
	public String getProcSelect(int id, String partCode);

	/**
	 * @param checkId
	 *            检查id
	 * @return 综合详细数据
	 */
	public String getPhotoDetail(String checkId);
}
