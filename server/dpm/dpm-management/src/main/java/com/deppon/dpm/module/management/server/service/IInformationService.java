package com.deppon.dpm.module.management.server.service;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.InformationSort;
/**
 * @author 
 * IInformationService 接口
 */
public interface IInformationService {
	/**
	 * @param userId 工号
	 * @param sortStr 排序
	 */
	public void sort(String userId, String sortStr);
	/**
	 * @param userId 工号
	 * @return 返回数据
	 */
	public String getSort(String userId);
	/**
	 * @param userId 工号
	 * @return list
	 */ 
	public List<InformationSort> list(String userId);

}
