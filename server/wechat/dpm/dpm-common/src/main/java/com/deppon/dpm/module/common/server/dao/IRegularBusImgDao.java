package com.deppon.dpm.module.common.server.dao;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.RegularBusImgEntity;

public interface IRegularBusImgDao {

	void save(RegularBusImgEntity entity);

	List<RegularBusImgEntity> pageQuery(RegularBusImgEntity entity);

	Long queryTotalCount();

	List<RegularBusImgEntity> queryBusImgs();

	void delete(Integer id);

}
