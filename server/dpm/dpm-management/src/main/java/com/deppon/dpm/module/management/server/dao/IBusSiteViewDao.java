package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.BusSiteInfoByClick;
import com.deppon.dpm.module.management.shared.domain.BusSiteView;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 站点显示dao接口
 * @author 曹嵩
 * @date 2015.6.18
 */
public interface IBusSiteViewDao {

	/**
	 * 得到所有站点的状态和名称
	 * @return 得到站点状态和名称以及id
	 * @throws BusinessException
	 */
	public List<BusSiteView> getSiteNameAndState() throws BusinessException;
	
	/**
	 * 
	 * @return 得到途径时间
	 * @throws BusinessException
	 */
	public List<BusSiteInfoByClick> getSiteByRouteTime(BusSiteInfoByClick b) throws BusinessException;
	
	/**
	 * 
	 * @return 得到起点终点站名称以及时间
	 * @throws BusinessException
	 */
	public List<BusSiteInfoByClick> getSiteByLineInfo(BusSiteInfoByClick b) throws BusinessException;
	
	/**
	 * 
	 * @return 得到供应商信息
	 * @throws BusinessException
	 */
	public List<BusSiteInfoByClick> getSiteByApplyInfo(BusSiteInfoByClick b) throws BusinessException;
	
	/**
	 * 
	 * @return 获取所有的时间
	 * @throws BusinessException
	 */
	public List<BusSiteView> getTimeByAll() throws BusinessException;
	
	/**
	 * 
	 * @return 获取站点名称和地址
	 * @throws BusinessException
	 */
	public List<BusSiteInfoByClick> getSiteAddressAndSiteName(BusSiteInfoByClick b) throws BusinessException;
}
