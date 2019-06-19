package com.deppon.dpm.module.management.server.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.dao.IMonitorCountInfoDao;
import com.deppon.dpm.module.common.shared.domain.MonitorCountInfoEntity;
import com.deppon.dpm.module.management.server.dao.IBusSiteDao;
import com.deppon.dpm.module.management.server.service.IBusSiteService;
import com.deppon.dpm.module.management.shared.domain.BusMessageView;
import com.deppon.dpm.module.management.shared.domain.BusSiteInfo;
import com.deppon.dpm.module.news.server.service.impl.TpushNewsService;

/**   
* @Description: 班车服务操作service
* @author 268087 张广波
* @date 2016-1-5 下午3:50:48 
* @version V1.0 
*/
public class BusSiteService implements IBusSiteService{
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(ProcCheckTaskService.class);	
	/** 
	* @Fields busSiteDao 操作dao
	*/ 
	private IBusSiteDao busSiteDao;
	/** 
	* @Fields countInfoDao 数据监控dao
	*/ 
	private IMonitorCountInfoDao countInfoDao;
	/** 
	* @Fields tpushNewsService 消息提示所需service
	*/ 
	@Resource
	private TpushNewsService tpushNewsService;
	
	public BusSiteService() {	
	}

	/**查询所有站点
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.IBusSiteService#queryAllBusSite()
	 */
	@Override
	public List<BusSiteInfo> queryAllBusSite() {
		return busSiteDao.queryAllBusSite();
	}

	/** 更新线路站点
	 * @param busSiteInfo
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.IBusSiteService#updateBusSite(com.deppon.dpm.module.management.shared.domain.BusSiteInfo)
	 */
	@Override
	public int updateBusSite(BusSiteInfo busSiteInfo) {
		int retInt = busSiteDao.updateBusSite(busSiteInfo);
		return retInt;
	}
	
	/**删除线路
	 * @param id
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.IBusSiteService#deleteBusLine(int)
	 */
	
	@Override
	public int deleteBusLine(int id) {		
		int busLine =  busSiteDao.deleteBusLine(id);
		int busSiteOfLine = busSiteDao.deleteBusSiteOfLine(id);
		return (busLine+busSiteOfLine);
	}	
	
	/**根据时间获取线路信息
	 * @param startDate
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.IBusSiteService#selectBusSiteLineByTime(java.util.Date)
	 */
	@Override
	public List<BusMessageView> selectBusSiteLineByTime(Date startDate) {
		return busSiteDao.selectBusSiteLineByTime(startDate);
	}
	
	/**
	 * 数据监控
	 * @param countInfoEntity 数据监控实体类
	 * @return
	 */
	@Override
	public int busServiceWatch(MonitorCountInfoEntity countInfoEntity) {
		int retInt = countInfoDao.saveMonitorCountInfo(countInfoEntity);
		logger.info("监控类型："+countInfoEntity.getType());
		return retInt;
	}
	
	@Override
	/**
	 * 判断当前用户是否是班车管理员
	 */
	public int checkIsAdmin(String empCode) {
		return busSiteDao.checkIsAdmin(empCode);
	}
	
	/** 根据主键id查找线路信息
	 * @param id
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.IBusSiteService#searchByID(int)
	 */
	public BusSiteInfo searchByID(int id){
		return busSiteDao.searchByID(id);
	}
	
	
	/** 
	* @Description: 获取操作dao
	* @author 268087 张广波
	* @date 2016-1-5 下午3:56:21 
	*  @return 
	*/
	public IBusSiteDao getBusSiteDao() {
		return busSiteDao;
	}

	/** 
	* @Description: 设置操作dao
	* @author 268087 张广波
	* @date 2016-1-5 下午3:56:36 
	*  @param busSiteDao 
	*/
	public void setBusSiteDao(IBusSiteDao busSiteDao) {
		this.busSiteDao = busSiteDao;
	}

	/** 
	* @Description: 获取监控操作dao
	* @author 268087 张广波
	* @date 2016-1-5 下午3:56:46 
	*  @return 
	*/
	public IMonitorCountInfoDao getCountInfoDao() {
		return countInfoDao;
	}

	/** 
	* @Description: 设置监控操作dao
	* @author 268087 张广波
	* @date 2016-1-5 下午3:57:05 
	*  @param countInfoDao 
	*/
	public void setCountInfoDao(IMonitorCountInfoDao countInfoDao) {
		this.countInfoDao = countInfoDao;
	}	
}
