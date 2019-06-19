package com.deppon.dpm.module.common.server.service.impl;

import java.io.File;
import java.util.List;

import com.deppon.dpm.module.common.server.dao.IRegularBusImgDao;
import com.deppon.dpm.module.common.server.service.IRegularBusImgService;
import com.deppon.dpm.module.common.shared.domain.RegularBusImgEntity;

public class RegularBusImgService implements IRegularBusImgService{
	
	private IRegularBusImgDao regularBusImgDao;
	
	private String serverHostPort;

	/**
	 * 保存图片
	 */
	public void save(RegularBusImgEntity entity) {
		regularBusImgDao.save(entity);
	}
	
	/**
	 * 分页查询
	 */
	public List<RegularBusImgEntity> pageQuery(RegularBusImgEntity entity) {
		List<RegularBusImgEntity> list = regularBusImgDao.pageQuery(entity);
		if(null != list && list.size() > 0) {
			for (RegularBusImgEntity regularBusImgEntity : list) {
				regularBusImgEntity.setImgUrl(serverHostPort.substring(0,serverHostPort.length() - 1) 
						+ regularBusImgEntity.getImgUrl().replace("/dpmfile", ""));
			}
		}
		return list;
	}
	
	/**
	 * 查询数据总条数
	 */
	public Long queryTotalCount() {
		return regularBusImgDao.queryTotalCount();
	}
	
	/**
	 * 查询上下班图片
	 */
	public List<RegularBusImgEntity> queryBusImgs() {
		List<RegularBusImgEntity> list = regularBusImgDao.queryBusImgs();
		if(null != list && list.size() > 0) {
			for (RegularBusImgEntity regularBusImgEntity : list) {
				regularBusImgEntity.setImgUrl(serverHostPort.substring(0,serverHostPort.length() - 1) 
						+ regularBusImgEntity.getImgUrl().replace("/dpmfile", ""));
			}
		}
		return list;
	}
	
	/**
	 * 删除班车图片信息
	 */
	public void delete(RegularBusImgEntity entity) {
		 regularBusImgDao.delete(entity.getId());
		// 删除图片
		File img = new File(entity.getImgUrl().replace(serverHostPort, "/"));
		if(img.exists()) {
			img.delete();
		}
	}

	// setter
	public void setRegularBusImgDao(IRegularBusImgDao regularBusImgDao) {
		this.regularBusImgDao = regularBusImgDao;
	}

	// setter
	public void setServerHostPort(String serverHostPort) {
		this.serverHostPort = serverHostPort;
	}

}
