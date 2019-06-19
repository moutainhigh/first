package com.deppon.dpm.doc.server.dao;

import java.util.List;

import com.deppon.dpm.doc.server.entity.DidiCityEntity;



public interface IDidiCitiesDao {

	/**
	 * 新增
	 * @param didicity
	 * @return
	 */
	Integer insert(DidiCityEntity didicity) ;

//	/**
//	 * ��������ҳ��ѯ
//	 * @param didiOeder
//	 * @return
//	 */
//	Page queryPage(DidiOrderEntity didiOeder) ;
	
	/**
	 * 查询
	 * @param didicity
	 * @return didicity
	 */
	DidiCityEntity find(DidiCityEntity didicity) ;
	
	/**
	 * 更新
	 * @param didicity
	 * @return
	 */
	Integer update(DidiCityEntity didicity) ;

	/**
	 * 删除
	 * @param didicity
	 * @return
	 */
	int delete(DidiCityEntity didicity);
	
	/**
	 * pk删除
	 * @param ids
	 * @return
	 */
	int deleteBatch(String ids);
	/**
	 * 根据城市名查询城市id
	 * @param cityname
	 * @return
	 */
	public List<Integer> getCityId(String cityname);
}
