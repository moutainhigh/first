package com.deppon.dpm.module.management.server.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.deppon.dpm.module.management.server.dao.IServeOriginatorsMessageDao;
import com.deppon.dpm.module.management.shared.domain.ServeOriginatorsInfoEntity;
import com.deppon.dpm.module.management.shared.domain.ServeParticipantsInfoEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 
 * @author wyn
 *
 */
public class ServeOriginatorsMessageDao extends iBatis3DaoImpl implements IServeOriginatorsMessageDao {
	
	String nameSpace = "com.deppon.dpm.module.management.server.dao.serveMessage";

	/**
	 * 保存参与者数据
	 */
	public int insertIntoServePart(ServeParticipantsInfoEntity entity) {
		return this.getSqlSession().insert(nameSpace+".insertPartInfo", entity);
	}

	/**
	 * 保存拼车记录信息
	 * @param entity
	 * @return
	 */
	public int insertIntoServeOriginator(ServeOriginatorsInfoEntity entity) {
		return this.getSqlSession().insert(nameSpace+".insertOriginatorInfo", entity);
	}

	/**
	 * 获取拼车主记录信息
	 * @param id
	 * @return
	 */
	public ServeOriginatorsInfoEntity getOriginatorsInfoById(int id) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return (ServeOriginatorsInfoEntity) this.getSqlSession().selectOne(nameSpace+".getOrigInfoById", map);
	}
	
	/** 
	* @Description: 校验保存信息是否重复
	* @author 268087 张广波
	* @date 2015-12-30 下午3:35:35 
	*  @param entity
	*  @return 
	*/
	public int checkOrigRepeat(ServeOriginatorsInfoEntity entity){
		return (Integer)this.getSqlSession().selectOne(nameSpace+".checkOrigRepeat", entity);
	}
	
	/** 
	* @Description: 校验报名参与是否重复
	* @author 268087 张广波
	* @date 2015-12-30 下午6:42:40 
	*  @param entity
	*  @return 
	*/
	public int checkPartRepeat(ServeParticipantsInfoEntity entity){
		return (Integer)this.getSqlSession().selectOne(nameSpace+".checkPartRepeat", entity);
	}
	
	/** 
	* @Description: 更新报名信息
	* @author 268087 张广波
	* @date 2015-12-30 下午6:45:26 
	*  @param entity
	*  @return 
	*/
	public int updatePartInfo(ServeParticipantsInfoEntity entity){
		return this.getSqlSession().update(nameSpace+".updatePartInfo", entity);
	}

}
