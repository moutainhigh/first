package com.deppon.dpm.doc.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.doc.server.dao.IDidiOrderDao;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class DidiOrderDao extends iBatis3DaoImpl  implements IDidiOrderDao {
	
	private static final String NAME_SPACE="com.deppon.dpm.doc.server.dao.DidiOrderDao";

	@Override
	public Integer insert(DidiOrderEntity didiOrder) {
		this.getSqlSession().insert(NAME_SPACE+".insertDidiOrder", didiOrder);
		return 0;
	}

	@Override
	public DidiOrderEntity find(DidiOrderEntity didiOrder) {
		DidiOrderEntity list =  (DidiOrderEntity) this.getSqlSession().selectOne(NAME_SPACE+".listDidiOrder", didiOrder);
		return list;
	}

	@Override
	public Integer update(DidiOrderEntity didiOrder) {
		this.getSqlSession().update(NAME_SPACE+".updateDidiOrder", didiOrder);
		return 0;
	}

	@Override
	public int delete(DidiOrderEntity didiOrder) {
		return 0;
	}

	@Override
	public int deleteBatch(String ids) {
		this.getSqlSession().delete(NAME_SPACE+".deleteDidiOrder", ids);
		return 0;
	}

	@Override
	public boolean statusCheck(String userId) {
		@SuppressWarnings("unchecked")
		List<DidiOrderEntity> results =  getSqlSession().selectList(NAME_SPACE+".statusCheck",userId);
		if (results != null && results.size() > 0) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DidiOrderEntity> Querymeeting(String userId,
			String meetingname, String date) {
		Map<String,String> map = new HashMap<String,String>();
    	map.put("userId", userId);
    	map.put("meetingname", meetingname);
    	map.put("date", date);
		return this.getSqlSession().selectList(NAME_SPACE+".meetingdidiOrder",map);
	}

	@Override
	public Integer updatePhone(String userId, String phone) {
		Map<String,String> map = new HashMap<String,String>();
    	map.put("userId", userId);
    	map.put("phone", phone);
		return this.getSqlSession().update(NAME_SPACE+".updatePhone",map);
	}

	@Override
	public List<DidiOrderEntity> accountOrder(String date) {
		List<DidiOrderEntity> results =  getSqlSession().selectList(NAME_SPACE+".accountOrder",date);
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<DidiOrderEntity> dateOrder(String date) {
		List<DidiOrderEntity> results =  getSqlSession().selectList(NAME_SPACE+".dateOrder",date);
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<DidiOrderEntity> dateOrderByOrderIds(List<Map<String,String>> list) {
		List<DidiOrderEntity> results =  getSqlSession().selectList(NAME_SPACE+".dateOrderByOrderIds",list);
		return results;
	}

	@Override
	public Integer insertdef(DidiOrderEntity didiOrder) {
		this.getSqlSession().insert(NAME_SPACE+".insertdefentity", didiOrder);
		return 0;
	}
	@Override
	public Integer finddef(String order) {
		List<DidiOrderEntity> results = this.getSqlSession().selectList(NAME_SPACE+".finddefentity", order);
		if (results != null && results.size() > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public List<DidiOrderEntity> query(String getDate, int pageNum) {
		Map<String,String> map = new HashMap<String,String>();
    	map.put("getDate", getDate);
    	map.put("pageNum", String.valueOf(pageNum+0));
		return this.getSqlSession().selectList(NAME_SPACE+".selectFileMsg",map);
	}

	@Override
	public DidiOrderEntity selectLastOrder(String userId) {
		return (DidiOrderEntity) this.getSqlSession().selectOne(NAME_SPACE+".selectLastOrder",userId);		
	}

}
