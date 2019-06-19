package com.deppon.dpm.tongxunlu.server.service;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.shared.domain.OutPersonEntity;
import com.deppon.dpm.tongxunlu.shared.domain.OutPersonTagEntity;

public interface IOutPersonService {
	/**
	 * 添加外部联系人
	 * @return
	 */
	public int addPerson(Map<String,Object> map);
	/**
	 * 获取外部联系人列表
	 * @param pagesize30 
	 * @param startNo 
	 * @return
	 */
	public List<OutPersonEntity> getOutPersonList(Map<String, Object> map);
	/**
	 * 添加外部联系人自定义标签
	 * @param mobileNo 
	 * @param userId 
	 * @return
	 */
	public int addPersonTag(String userId, String tag);
	/**
	 * 获取外部联系人自定义标签
	 * @return
	 */
	public List<OutPersonTagEntity> getPersonTag(String userId);
	/**
	 * 更新外部联系人
	 * @return
	 */
	public int updatePerson(Map<String, Object> map);
	/**
	 * 删除外部联系人
	 * @return
	 */
	public int deletePerson(int id);
	/**
	 * 删除外部联系人自定义标签
	 * @param mobileNo 
	 * @param userId 
	 * @return
	 */
	public int deletePersonTag(String userId, String tag);

}
