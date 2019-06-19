package com.deppon.dpm.module.anps.server.dao.impl;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.anps.server.dao.INoticeGroupDao;
import com.deppon.dpm.module.anps.shared.domain.NoticeGroupEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class NoticeGroupDao extends iBatis3DaoImpl implements INoticeGroupDao{

	/**
	 * namespace
	 */
	private String NAME_SPACE = "com.deppon.dpm.module.anps.server.dao.impl.NoticeGroupDao.";
	
	
	/**
	 * 创建群组
	 */
	public int insertGroupInfo(List<NoticeGroupEntity> groupList){
		
		return this.getSqlSession().insert(NAME_SPACE + "insertGroupInfo", 
				groupList);
	}
	
	/**
	 * 插入群组成员
	 */
	public int insertGroupMember(List<NoticeGroupEntity> groupList){
		
		return this.getSqlSession().insert(NAME_SPACE + "insertGroupMember", 
				groupList);
	}
	
	/**
	 * 获取群组列表
	 */
	@SuppressWarnings("unchecked")
	public List<NoticeGroupEntity> getAllGroup(String userId){
		return getSqlSession().selectList(NAME_SPACE + "getAllGroup", 
				userId);
	}
	
	/**
	 * 获取群组成员
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<NoticeGroupEntity> getGroupMember(String groupId){
		
		return getSqlSession().selectList(NAME_SPACE + "getGroupMember", 
				groupId);
	}
	/**
	 * 获取员工部门
	 */
	public String getEmpOrgname(String empCode){

		return (String)getSqlSession().selectOne(NAME_SPACE + "getEmpOrgname", 
				empCode);
	}
	
	/**
	 * 群组重命名
	 */
	public int updateGroupName(Map<String,String> map){

		return this.getSqlSession().update(NAME_SPACE + "updateGroupName", 
				map);
	}
	
	/**
	 * 删除群组
	 */
	public int deleteGroup(String groupId){
		
		return this.getSqlSession().delete(NAME_SPACE + "deleteGroup", 
				groupId);
	}
	
	/**
	 * 删除群组成员
	 */
	public int deleteGroupMember(Map<String,String> map){
		
		return this.getSqlSession().delete(NAME_SPACE + "deleteGroupMember", 
				map);
	}
	
	/**
	 * 获得群组名数量
	 */
	public int getGroupNameCount(Map<String,String> map){
		
		return (Integer)getSqlSession().selectOne(NAME_SPACE + "getGroupNameCount", 
				map);
	}
    
	/**
	 * 查询群组成员重复数
	 */
	public int getMemberCount(Map<String,String> map){
		
		return (Integer)getSqlSession().selectOne(NAME_SPACE + "getMemberCount", 
				map);
	}
}
