package com.deppon.dpm.tongxunlu.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.shared.domain.BootyCallEntity;
import com.deppon.dpm.tongxunlu.shared.domain.BootyEntity;

/**
 * 约吧dao层
 * 
 * @author 231586
 * 
 */
public interface IBootyCallDao {
	// 发布约吧信息
	public int publishBootyCallInfo(BootyCallEntity entity);

	// 获取约吧信息
	public List<Map<String, Object>> getBootyCallInfo(Map<String, Object> map);

	// 参加约吧与否
	public int joinBootyCall(Map<String, Object> map);
	
	// 根据id查询参与人数
	public String getJoinedPerson(int id);

	//查询约吧参加人员信息
	public List<BootyEntity> queryJoinEmpsByEmpCodes(String[] ress);
}
