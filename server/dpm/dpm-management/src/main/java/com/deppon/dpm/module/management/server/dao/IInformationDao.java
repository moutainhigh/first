package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.InformationSort;

/**
 * @author 
 * IInformationDao 接口
 */
public interface IInformationDao {

	/**
	 * @param userId 工号
	 * @param sortStr 排序
	 */
	void sort(String userId, String sortStr);

	/**
	 * @param userId 工号
	 * @return 返回数据
	 */
	String getSort(String userId);

	/**
	 * @param userId 工号
	 * @param infoId 参数
	 */
	void download(String userId, int infoId);

	/**
	 * @param userId 工号
	 * @return list
	 */ 
	List<InformationSort> list(String userId);

}
