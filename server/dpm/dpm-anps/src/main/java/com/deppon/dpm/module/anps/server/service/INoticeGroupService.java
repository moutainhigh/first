package com.deppon.dpm.module.anps.server.service;

import java.util.List;
import com.deppon.dpm.module.anps.shared.domain.NoticeGroupEntity;
import com.deppon.dpm.module.anps.shared.vo.GroupMemberVo;

public interface INoticeGroupService {
	
	/**
	 * 创建群组
	 * @param groupEntity
	 * @return
	 */
	public int insertGroupInfo(String groupName, String groupOwner, List<GroupMemberVo> groupMemberVo);
	/**
	 * 插入群组成员
	 * @param groupName
	 * @param groupOwner
	 * @param groupMemberVo
	 * @return
	 */
	public int insertGroupMember(String groupId, String groupName, String groupOwner, List<GroupMemberVo> groupMemberVo);
	/**
	 * 获取群组列表
	 * @param userId
	 * @return
	 */
	public List<NoticeGroupEntity> getAllGroup(String userId);
	/**
	 * 获取群组成员
	 * @param groupId
	 * @return
	 */
	public List<NoticeGroupEntity> getGroupMember(String groupId);
	/**
	 * 群组重命名
	 * @param map
	 * @return
	 */
	public int updateGroupName(String groupId,String groupName,String groupOwner);
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
	public int deleteGroupMember(String groupId,String memberType,String memberCode,String positionDep);

}
