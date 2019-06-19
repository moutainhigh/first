package com.deppon.dpm.module.management.server.service;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.BusSiteInfoByClick;
import com.deppon.dpm.module.management.shared.domain.BusSiteView;

/**
 * 站点显示service接口
 * @author 曹嵩
 * @date 2015.6.18
 */
public interface IBusSiteViewService {

	/**
	 * 
	 * @return 得到站点状态和名称以及id
	 * @throws Exception
	 */
	public List<BusSiteView> getSiteNameAndState(String time) throws Exception;
	
	/**
	 * 
	 * @return 得到途径时间
	 * @throws Exception
	 */
	public List<BusSiteInfoByClick> getSiteByRouteTime(BusSiteInfoByClick b) throws Exception;
	
	/**
	 * 
	 * @return 得到起点终点站名称以及时间
	 * @throws Exception
	 */
	public List<BusSiteInfoByClick> getSiteByLineInfo(BusSiteInfoByClick b) throws Exception;
	
	/**
	 * 
	 * @return 得到供应商信息
	 * @throws Exception
	 */
	public List<BusSiteInfoByClick> getSiteByApplyInfo(BusSiteInfoByClick b) throws Exception;
	
	/**
	 * 
	 * @return 获取站点名称和地址
	 * @throws Exception
	 */
	public List<BusSiteInfoByClick> getSiteAddressAndSiteName(BusSiteInfoByClick b) throws Exception;
	
}
