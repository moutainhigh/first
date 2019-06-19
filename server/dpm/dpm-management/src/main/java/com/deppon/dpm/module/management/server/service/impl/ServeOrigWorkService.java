package com.deppon.dpm.module.management.server.service.impl;

import com.deppon.dpm.module.management.server.dao.IServeOrigWorkDao;
import com.deppon.dpm.module.management.server.service.IServeOrigWorkService;
import com.deppon.dpm.module.management.shared.domain.ServeOriginatorsInfoEntity;
import com.deppon.dpm.module.management.shared.domain.ServeParticipantsInfoEntity;

public class ServeOrigWorkService implements IServeOrigWorkService {
	private IServeOrigWorkDao workDao;
	/** 
	* @Description: 修改 或 取消发布  信息接口
	* @author 268087 张广波
	* @date 2015-11-2 下午5:27:46 
	*  @param jsonStr
	*  @return 
	*/
	public int updateOrigInfo(ServeOriginatorsInfoEntity infoEntity){
		return workDao.updateOrigInfo(infoEntity);		
	}
	
	
	/** 
	* @Description: 取消参与 或 拒绝参与者 
	* @author 268087 张广波
	* @date 2015-11-3 上午10:49:31 
	*  @param infoEntity
	*  @return 
	*/
	public int updatePartInfo(ServeParticipantsInfoEntity infoEntity){
		return workDao.updatePartInfo(infoEntity);
	}
	
	
	public IServeOrigWorkDao getWorkDao() {
		return workDao;
	}
	public void setWorkDao(IServeOrigWorkDao workDao) {
		this.workDao = workDao;
	}	
}
