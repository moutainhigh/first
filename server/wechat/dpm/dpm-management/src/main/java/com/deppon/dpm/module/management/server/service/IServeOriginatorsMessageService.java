package com.deppon.dpm.module.management.server.service;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.shared.domain.ServeOriginatorsInfoEntity;
import com.deppon.dpm.module.management.shared.domain.ServeParticipantsInfoEntity;


public interface IServeOriginatorsMessageService {
	
	/**
	 * 获取用户信息
	 * @param List<String> 用户工号list
	 * @return Map<String,String>  key:userNo,value:httpUrl 
	 */
	public Map<String,String> getImageUrl(List<String> list);
	
	/**
	 * 保存参与者信息
	 * @param entity
	 * @return true 保存成功    	false 保存失败
	 */
	public boolean saveServePartInfo(ServeParticipantsInfoEntity entity);
	
	/**
	 * 保存拼车记录信息
	 * @param entity
	 * @return
	 */
	public boolean saveServeOriginatorInfo(ServeOriginatorsInfoEntity entity);
	
	/**
	 * 获取用户头像
	 * @param userNo 用户工号
	 * @return 用户头像的URL
	 */
	public String getImageURL(String userNo);
	
	/**
	 * 获取该记录的上限人数
	 * @param id
	 * @return ServeOriginatorsInfoEntity
	 */
	public ServeOriginatorsInfoEntity getLimitSize(int id);
	
	/** 
	* @Description: 校验提交信息是否重复
	* @author 268087 张广波
	* @date 2015-12-30 下午3:39:31 
	*  @param entity
	*  @return 
	*/
	public boolean checkOrigRepeat(ServeOriginatorsInfoEntity entity);
	
	/** 
	* @Description: 校验报名参与是否重复
	* @author 268087 张广波
	* @date 2015-12-30 下午6:42:40 
	*  @param entity
	*  @return 
	*/
	public boolean checkPartRepeat(ServeParticipantsInfoEntity entity);
	
	/** 
	* @Description: 更新报名信息
	* @author 268087 张广波
	* @date 2015-12-30 下午6:45:26 
	*  @param entity
	*  @return 
	*/
	public boolean updatePartInfo(ServeParticipantsInfoEntity entity);
	
}
