package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.IBusSiteViewDao;
import com.deppon.dpm.module.management.shared.domain.BusSiteInfoByClick;
import com.deppon.dpm.module.management.shared.domain.BusSiteView;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 站点显示dao接口的实现
 * 
 * @author 曹嵩
 * @date 2015.6.18
 */
@SuppressWarnings("unchecked")
public class BusSiteViewDao extends iBatis3DaoImpl implements IBusSiteViewDao {

	String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.bussiteview";

	/**
	 * 得到所有站点的状态和名称
	 * 
	 * @return 得到站点状态和名称以及id
	 * @throws Exception
	 */
	@Override
	public List<BusSiteView> getSiteNameAndState() throws Exception {
		return getSqlSession().selectList(
				mapperNameSpace + ".getSiteNameAndState");
	}

	/**
	 * 
	 * @return 得到途径时间
	 * @throws Exception
	 */
	@Override
	public List<BusSiteInfoByClick> getSiteByRouteTime(BusSiteInfoByClick b)
			throws Exception {
		return getSqlSession().selectList(
				mapperNameSpace + ".getSiteByRouteTime", b);
	}

	/**
	 * 
	 * @return 得到起点终点站名称以及时间
	 * @throws Exception
	 */
	@Override
	public List<BusSiteInfoByClick> getSiteByLineInfo(BusSiteInfoByClick b)
			throws Exception {
		return getSqlSession().selectList(
				mapperNameSpace + ".getSiteByLineInfo", b);
	}

	/**
	 * 
	 * @return 得到供应商信息
	 * @throws Exception
	 */
	@Override
	public List<BusSiteInfoByClick> getSiteByApplyInfo(BusSiteInfoByClick b)
			throws Exception {
		return getSqlSession().selectList(
				mapperNameSpace + ".getSiteByApplyInfo", b);
	}

	/**
	 * 
	 * @return 获取所有的时间
	 * @throws Exception
	 */
	@Override
	public List<BusSiteView> getTimeByAll() throws Exception {
		return getSqlSession().selectList(mapperNameSpace + ".getTimeByAll");
	}

	/**
	 * 
	 * @return 获取站点名称和地址
	 * @throws Exception
	 */
	@Override
	public List<BusSiteInfoByClick> getSiteAddressAndSiteName(
			BusSiteInfoByClick b) throws Exception {
		return getSqlSession().selectList(
				mapperNameSpace + ".getSiteAddressAndSiteName", b);
	}

}
