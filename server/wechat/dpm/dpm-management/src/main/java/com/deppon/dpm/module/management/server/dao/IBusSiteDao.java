package com.deppon.dpm.module.management.server.dao;

import java.util.Date;
import java.util.List;

import com.deppon.dpm.module.management.shared.domain.BusMessageView;
import com.deppon.dpm.module.management.shared.domain.BusSiteInfo;

/**
 * 站点操作类
 * @author 268087
 *
 */
public interface IBusSiteDao {	
	/**
	 * 查询所有站点集合
	 * @return
	 */
	public List<BusSiteInfo> queryAllBusSite();
	/**
	 * 保存单个站点信息
	 * @param busSiteInfo
	 * @return
	 */
	public int updateBusSite(BusSiteInfo busSiteInfo);
	/**
	 * 根据主键ID查询单个站点信息
	 * @param id
	 * @return
	 */
	public BusSiteInfo searchByID(int id);
	/**
	 * 根据线路ID删除线路
	 * @param id
	 * @return
	 */
	public int deleteBusLine(int id); 
	/**
	 * 根据线路ID删除该线路的所有站点
	 * @param id
	 * @return
	 */
	public int deleteBusSiteOfLine(int id);
	
	/**
	 * 根据起始时间获取线路站点集合
	 * @param startDate
	 * @return
	 */
	public List<BusMessageView> selectBusSiteLineByTime(Date startDate);
	
	/**
	 * 判断当前用户是否是管理员
	 * @param empCode
	 * @return
	 */
	public int checkIsAdmin(String empCode);
}
