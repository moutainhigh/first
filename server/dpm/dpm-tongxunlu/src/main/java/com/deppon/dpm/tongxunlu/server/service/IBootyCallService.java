package com.deppon.dpm.tongxunlu.server.service;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.shared.domain.BootyCallEntity;
import com.deppon.dpm.tongxunlu.shared.domain.BootyEntity;
import com.deppon.foss.framework.service.IService;

/**
 * 约会service层
 * 
 * @date 2015-09-14
 * @author 231586
 * 
 */
public interface IBootyCallService extends IService {
	// 发布约吧信息
	public int publishBootyCallInfo(BootyCallEntity entity);

	// 根据条件查询约吧信息
	public List<Map<String, Object>> getBootyCallInfo(Map<String, Object> map);

	// 加入约吧信息
	public int joinBootyCall(String userId, int id);
	
	// 判断是否存在
	public boolean checkExists(String userId, Object str);

	// 查询自己的约会信息
	public List<Map<String, Object>> getSelfBootyCallInfo(String userId, int start, int pageSize);

	// 删除
	public int delete(int dateId);

	//查询参加约吧的人员信息
	public List<BootyEntity> queryJoinEmpsByEmpCodes(String[] ress,
			List<String> leaderList);
}
