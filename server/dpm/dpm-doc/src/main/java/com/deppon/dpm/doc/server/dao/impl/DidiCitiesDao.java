package com.deppon.dpm.doc.server.dao.impl;

import java.util.List;

import com.deppon.dpm.doc.server.dao.IDidiCitiesDao;
import com.deppon.dpm.doc.server.entity.DidiCityEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class DidiCitiesDao extends iBatis3DaoImpl implements IDidiCitiesDao {

	private static final String NAME_SPACE="com.deppon.dpm.doc.server.dao.DidiCitiesDao";
	
	@Override
	public Integer insert(DidiCityEntity didicity) {
		return this.getSqlSession().insert(NAME_SPACE+".insertDidiCity", didicity);
	}

	@Override
	public DidiCityEntity find(DidiCityEntity didicity) {
		DidiCityEntity list =  (DidiCityEntity) this.getSqlSession().selectOne(NAME_SPACE+".listDidiCity", didicity);
		return list;
	}

	@Override
	public Integer update(DidiCityEntity didicity) {
		return this.getSqlSession().update(NAME_SPACE+".updateDidiCity", didicity);
	}

	@Override
	public int delete(DidiCityEntity didicity) {
		return 0;
	}

	@Override
	public int deleteBatch(String ids) {
		return this.getSqlSession().delete(NAME_SPACE+".deleteDidiCity", ids);
	}
	
	@Override
	public List<Integer> getCityId(String cityname){
		return (List<Integer>) (this.getSqlSession().selectList(NAME_SPACE + ".getCityId", cityname));
				//selectList(NAME_SPACE + ".getCityId", cityname)==null?0:this.getSqlSession().selectList(NAME_SPACE + ".getCityId", cityname));
		 //(Integer) this.getSqlSession().selectOne(NAME_SPACE + ".getCityId", cityname);
	}

}
