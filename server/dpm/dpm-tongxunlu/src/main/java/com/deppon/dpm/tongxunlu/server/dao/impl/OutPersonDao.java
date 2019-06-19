package com.deppon.dpm.tongxunlu.server.dao.impl;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.server.dao.IOutPersonDao;
import com.deppon.dpm.tongxunlu.shared.domain.OutPersonEntity;
import com.deppon.dpm.tongxunlu.shared.domain.OutPersonTagEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class OutPersonDao extends iBatis3DaoImpl implements IOutPersonDao{
    
	/**
	 * namespace
	 */
	private String NAME_SPACE = "com.deppon.dpm.tongxunlu.server.dao.outPerson.";
	
	
	/**
	 * 添加外部联系人
	 * @return
	 */
	@Override
	public int addPerson(Map<String,Object> map) {
		return this.getSqlSession().insert(NAME_SPACE + "addPerson",map);
	}
	/**
	 * genx外部联系人
	 * @return
	 */
	@Override
	public int updatePerson(Map<String,Object> map) {
		return this.getSqlSession().update(NAME_SPACE + "updatePerson",map);
	}
    /**
     * 删除外部联系人
     */
	@Override
	public int deletePerson(int id) {
		// TODO Auto-generated method stub
		return this.getSqlSession().delete(NAME_SPACE + "deletePerson",id);
	}
	
	/**
	 * 获取外部联系人列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<OutPersonEntity> getOutPersonList(Map<String,Object> map){
		
		return this.getSqlSession().selectList(NAME_SPACE + "getPersonList",map);
	}

	/**
	 * 添加外部联系人标签
	 * @return
	 */
	@Override
	public int addPersonTag(Map<String, Object> map) {
		return this.getSqlSession().insert(NAME_SPACE + "addPersonTag",map);
	}

   /**
    * 获得外部联系人标签
    */
	@SuppressWarnings({  "unchecked" })
	@Override
	public List<OutPersonTagEntity> getPersonTag(Map<String, Object> map) {
		return this.getSqlSession().selectList(NAME_SPACE + "getPersonTag",map);
	}
	
	
	/**
	 *删除外部联系人自定义标签
	 * @param id
	 * @return
	 */
	@Override
	public int deletePersonTag(Map<String, Object> map) {
		
		return this.getSqlSession().delete(NAME_SPACE + "deletePersonTag",map);
	}





	


	
}
