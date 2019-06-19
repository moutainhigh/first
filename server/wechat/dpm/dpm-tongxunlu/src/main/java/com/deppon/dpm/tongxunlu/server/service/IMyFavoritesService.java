package com.deppon.dpm.tongxunlu.server.service;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.foss.framework.service.IService;

/**
 * 常用联系人Service层
 * 
 * @author 231586
 * 
 */
public interface IMyFavoritesService extends IService {
	// 新增
	public int collectOne(Map<String, String> map);

	// 获取常用联系人
	public List<EmployeeVO> getFavorites(String userId);

	// 删除一个常用联系人
	public int removeOne(Map<String, String> map);

	// 删除所有常用联系人
	public int removeAll(String userId);
}
