package com.deppon.dpm.module.common.server.service;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.RegularBusImgEntity;

public interface IRegularBusImgService {

	void save(RegularBusImgEntity entity);

	List<RegularBusImgEntity> pageQuery(RegularBusImgEntity entity);

	Long queryTotalCount();

	List<RegularBusImgEntity> queryBusImgs();

	void delete(RegularBusImgEntity entity);

}
