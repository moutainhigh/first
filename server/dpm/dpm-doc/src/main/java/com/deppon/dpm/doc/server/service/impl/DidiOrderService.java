package com.deppon.dpm.doc.server.service.impl;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.doc.server.dao.IDidiOrderDao;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.service.IDidiOrderService;

public class DidiOrderService implements IDidiOrderService {

	private IDidiOrderDao didiOrderDao;
	
	@Override
	public Integer insert(DidiOrderEntity didiOrder) {
		
		return didiOrderDao.insert(didiOrder);
	}

	@Override
	public Integer insertdef(DidiOrderEntity didiOrder) {
		
		return didiOrderDao.insertdef(didiOrder);
	}
	
	@Override
	public Integer finddef(String order) {
		
		return didiOrderDao.finddef(order);
	}
	
	@Override
	public DidiOrderEntity find(DidiOrderEntity didiOrder) {
		return didiOrderDao.find(didiOrder);
	}

	@Override
	public Integer update(DidiOrderEntity didiOrder) {
		return didiOrderDao.update(didiOrder);
	}

	@Override
	public int delete(DidiOrderEntity didiOrder) {
		return 0;
	}

	@Override
	public int deleteBatch(String ids) {
		return didiOrderDao.deleteBatch(ids);
	}

	public IDidiOrderDao getDidiOrderDao() {
		return didiOrderDao;
	}

	public void setDidiOrderDao(IDidiOrderDao didiOrderDao) {
		this.didiOrderDao = didiOrderDao;
	}

	@Override
	public boolean statusCheck(String userId) {
		return didiOrderDao.statusCheck(userId);
	}

	@Override
	public List<DidiOrderEntity> Querymeeting(String userId,
			String meetingname, String date) {
		return didiOrderDao.Querymeeting(userId, meetingname, date);
	}

	@Override
	public Integer updatePhone(String userId, String phone) {
		return didiOrderDao.updatePhone(userId, phone);
	}

	@Override
	public List<DidiOrderEntity> accountOrder(String date) {
		return didiOrderDao.accountOrder(date);
	}

	@Override
	public List<DidiOrderEntity> dateOrder(String date) {
		return didiOrderDao.dateOrder(date);
	}
	
	@Override
	public List<DidiOrderEntity> dateOrderByOrderIds(List<Map<String,String>> list){
		return didiOrderDao.dateOrderByOrderIds(list);
	}

	@Override
	public List<DidiOrderEntity> query(String getDate, int pageNum) {
		// TODO Auto-generated method stub
		return didiOrderDao.query(getDate, pageNum);
	}

	@Override
	public DidiOrderEntity selectLastOrder(String userId) {
		return didiOrderDao.selectLastOrder(userId);

	}

}
