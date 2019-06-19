package com.deppon.dpm.module.management.server.dao;

import com.deppon.dpm.module.management.shared.domain.ServeOriginatorsInfoEntity;
import com.deppon.dpm.module.management.shared.domain.ServeParticipantsInfoEntity;

public interface IServeOrigWorkDao {
	/** 
	* @Description: 修改 或取消发布 拼车信息
	* @author 268087 张广波
	* @date 2015-11-2 下午5:07:39 
	*  @param infoEntity
	*  @return 
	*/
	public int updateOrigInfo(ServeOriginatorsInfoEntity infoEntity);
	
	/** 
	* @Description: 取消参与 或 拒绝参与者 
	* @author 268087 张广波
	* @date 2015-11-3 上午10:49:31 
	*  @param infoEntity
	*  @return 
	*/
	public int updatePartInfo(ServeParticipantsInfoEntity infoEntity);
	
}
