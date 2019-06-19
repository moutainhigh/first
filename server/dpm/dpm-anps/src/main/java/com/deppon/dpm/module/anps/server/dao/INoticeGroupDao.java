package com.deppon.dpm.module.anps.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.anps.shared.domain.NoticeGroupEntity;

public interface INoticeGroupDao {
	
	/**
	 * 创建群组
	 * @param groupEntity
	 * @return
	 */
	public int insertGroupInfo(List<NoticeGroupEntity> groupList);
	/**
	 * 插入群组成员
	 * @param groupList
	 * @return
	 */
	public int insertGroupMember(List<NoticeGroupEntity> groupList);
	/**
	 * 获取群组列表
	 * @param userId
	 * @return
	 */
	public List<NoticeGroupEntity> getAllGroup(String userId);
	/**
	 * 获取群组成员
	 * @return
	 */
	public List<NoticeGroupEntity> getGroupMember(String groupId);
	/**
	 * 获取员工部门
	 * @param empCode
	 * @return
	 */
	public String getEmpOrgname(String empCode);
	/**
	 * 群组重命名
	 * @param map
	 * @return
	 */
	public int updateGroupName(Map<String,String> map);
	/**
	 * 删除群组
	 * @param groupId
	 * @return
	 */
	public int deleteGroup(String groupId);
	/**
	 * 删除群组成员
	 * @param map
	 * @return
	 */
	public int deleteGroupMember(Map<String,String> map);
	/**
	 * 获得群组名数量
	 * @param groupName
	 * @return
	 */
	public int getGroupNameCount(Map<String,String> map);
	/**
	 * 查询群组成员重复数
	 * @param map
	 * @return
	 */
	public int getMemberCount(Map<String,String> map);

}
