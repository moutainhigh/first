package com.deppon.dpm.module.management.server.dao;

import com.deppon.dpm.module.management.shared.domain.ServeOriginatorsInfoEntity;
import com.deppon.dpm.module.management.shared.domain.ServeParticipantsInfoEntity;

/**
 * 
 * @author wyn
 *
 */
public interface IServeOriginatorsMessageDao {

	/**
	 * 保存参与者信息
	 * @param entity
	 * @return
	 */
	public int insertIntoServePart(ServeParticipantsInfoEntity entity);
	
	/**
	 * 保存拼车记录信息
	 * @param entity
	 * @return
	 */
	public int insertIntoServeOriginator(ServeOriginatorsInfoEntity entity);
	
	/**
	 * 获取拼车主记录信息
	 * @param id
	 * @return
	 */
	public ServeOriginatorsInfoEntity getOriginatorsInfoById(int id);
	
	/** 
	* @Description: 校验保存信息是否重复
	* @author 268087 张广波
	* @date 2015-12-30 下午3:35:35 
	*  @param entity
	*  @return 
	*/
	public int checkOrigRepeat(ServeOriginatorsInfoEntity entity);
	
	
	/** 
	* @Description: 校验报名参与是否重复
	* @author 268087 张广波
	* @date 2015-12-30 下午6:42:40 
	*  @param entity
	*  @return 
	*/
	public int checkPartRepeat(ServeParticipantsInfoEntity entity);
	
	
	/** 
	* @Description: 更新报名信息
	* @author 268087 张广波
	* @date 2015-12-30 下午6:45:26 
	*  @param entity
	*  @return 
	*/
	public int updatePartInfo(ServeParticipantsInfoEntity entity);
	
	
}
