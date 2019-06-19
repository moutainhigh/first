package com.deppon.dpm.doc.server.service.impl;

import java.util.List;

import com.deppon.dpm.doc.server.dao.IDidiCitiesDao;
import com.deppon.dpm.doc.server.entity.DidiCityEntity;
import com.deppon.dpm.doc.server.service.IDidiCitiesService;

public class DidiCitiesService implements IDidiCitiesService {

	private IDidiCitiesDao didiCitiesDao;
	
	@Override
	public Integer insert(DidiCityEntity didicity) {
		return didiCitiesDao.insert(didicity);
	}

	@Override
	public DidiCityEntity find(DidiCityEntity didicity) {
		return didiCitiesDao.find(didicity);
	}

	@Override
	public Integer update(DidiCityEntity didicity) {
		return didiCitiesDao.update(didicity);
	}

	@Override
	public int delete(DidiCityEntity didicity) {
		return 0;
	}

	@Override
	public int deleteBatch(String ids) {
		return didiCitiesDao.deleteBatch(ids);
	}

	public IDidiCitiesDao getDidiCitiesDao() {
		return didiCitiesDao;
	}

	public void setDidiCitiesDao(IDidiCitiesDao didiCitiesDao) {
		this.didiCitiesDao = didiCitiesDao;
	}

	@Override
	public List<Integer> getCityId(String cityname){
		
		return didiCitiesDao.getCityId(cityname);
	}

}
