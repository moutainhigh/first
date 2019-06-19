package com.deppon.dpm.tongxunlu.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.shared.domain.OutPersonEntity;
import com.deppon.dpm.tongxunlu.shared.domain.OutPersonTagEntity;

public interface IOutPersonDao {
	/**
	 *添加外部联系人
	 * @param id
	 * @return
	 */
	public int addPerson(Map<String,Object> map);
	
	/**
	 *更新外部联系人
	 * @param id
	 * @return
	 */
	public int updatePerson(Map<String,Object> map);
	/**
	 *获取外部联系人列表
	 * @param id
	 * @return
	 */
	public List<OutPersonEntity> getOutPersonList(Map<String, Object> map);
	/**
	 *添加外部联系人标签
	 * @param id
	 * @return
	 */
	public int addPersonTag(Map<String, Object> map);
	/**
	 *获取外部联系人标签
	 * @param id
	 * @return
	 */
	public List<OutPersonTagEntity> getPersonTag(Map<String, Object> map);
	/**
	 *删除外部联系人
	 * @param id
	 * @return
	 */
	public int deletePerson(int id);
	/**
	 *删除外部标签
	 * @param id
	 * @return
	 */
	public int deletePersonTag(Map<String, Object> map);

}
