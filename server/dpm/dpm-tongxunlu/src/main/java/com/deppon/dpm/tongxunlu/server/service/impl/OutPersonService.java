package com.deppon.dpm.tongxunlu.server.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.server.dao.IOutPersonDao;
import com.deppon.dpm.tongxunlu.server.service.IOutPersonService;
import com.deppon.dpm.tongxunlu.shared.domain.OutPersonEntity;
import com.deppon.dpm.tongxunlu.shared.domain.OutPersonTagEntity;

public class OutPersonService implements IOutPersonService {
    
	/**
	 * 外部联系人接口
	 */
	private IOutPersonDao outPersonDao;
	
	
	@Override
	public int addPerson(Map<String,Object> map) {
		int count= outPersonDao.addPerson(map);
		
		return count;
	}
	/**
	 * 更新外部联系人
	 */
	@Override
	public int updatePerson(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return outPersonDao.updatePerson(map);
	}
	/**
	 * 删除外部联系人
	 */
	@Override
	public int deletePerson(int id) {
		// TODO Auto-generated method stub
		return outPersonDao.deletePerson(id);
	}
	
	/**
	 * 获取外部联系人列表
	 * @return
	 */
	public List<OutPersonEntity> getOutPersonList(Map<String, Object> map){
		
		return outPersonDao.getOutPersonList(map);
	}


	
	/**
	 * 添加外部联系人标签
	 * @return
	 */
	@Override
	public int addPersonTag(String userId, String tag) {
	   Map<String,Object> map = new HashMap<String,Object>();
	   map.put("userId", userId);
	   map.put("tag", tag);
	   int	count=   outPersonDao.addPersonTag(map);
	   return count;
	}
	
	/**
	 * 删除外部联系人自定义标签
	 * @return
	 */
	@Override
	public int deletePersonTag(String userId, String tag) {
		 Map<String,Object> map = new HashMap<String,Object>();
		   map.put("userId", userId);
		   map.put("tag", tag);
		   int	count=   outPersonDao.deletePersonTag(map);
		   return count;
	}
	
	
	@Override
	public  List<OutPersonTagEntity> getPersonTag(String userId) {
		Map<String,Object> map = new HashMap<String,Object>();
		  map.put("userId", userId);
		return  outPersonDao.getPersonTag(map);
	}
	
	public IOutPersonDao getOutPersonDao() {
		return outPersonDao;
	}


	public void setOutPersonDao(IOutPersonDao outPersonDao) {
		this.outPersonDao = outPersonDao;
	}
	
	

	


}
