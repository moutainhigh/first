package com.deppon.dpm.module.management.server.service;

import java.util.Date;
import java.util.List;
import javax.ws.rs.Path;

import com.deppon.dpm.module.common.shared.domain.MonitorCountInfoEntity;
import com.deppon.dpm.module.management.shared.domain.BusMessageView;
import com.deppon.dpm.module.management.shared.domain.BusSiteInfo;


/**
 * 站点管理service
 * @author 268087
 *
 */
@Path("IBusSiteService")
public interface IBusSiteService {
	public List<BusSiteInfo> queryAllBusSite();	
	public int updateBusSite(BusSiteInfo busSiteInfo);
	public BusSiteInfo searchByID(int id);
	/**
	 * 删除某条线路
	 * @return
	 */
	public int deleteBusLine(int id);
	/**
	 * 根据起始站点获取线路站点集合
	 * @param startDate
	 * @return
	 */
	public List<BusMessageView> selectBusSiteLineByTime(Date startDate);
	/**
	 * 判断当前用户是否是班车管理员
	 * @param empCode
	 * @return
	 */
	public int checkIsAdmin(String empCode);
	/**
	 * 数据监控
	 * @param countInfoEntity 数据监控实体类
	 * @return
	 */
	public int busServiceWatch(MonitorCountInfoEntity countInfoEntity);
}
