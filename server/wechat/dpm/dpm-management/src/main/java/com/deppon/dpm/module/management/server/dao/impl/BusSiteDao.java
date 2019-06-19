package com.deppon.dpm.module.management.server.dao.impl;

import java.util.Date;
import java.util.List;

import com.deppon.dpm.module.management.server.dao.IBusSiteDao;
import com.deppon.dpm.module.management.shared.domain.BusMessageView;
import com.deppon.dpm.module.management.shared.domain.BusSiteInfo;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 站点操作类
 * @author 268087
 *
 */
public class BusSiteDao extends iBatis3DaoImpl implements IBusSiteDao {
	String nameSpace = "com.deppon.dpm.module.management.server.dao.manWorkSet";
	
	/**
	 * 查询所有站点集合
	 * @return
	 */
	public List<BusSiteInfo> queryAllBusSite() {
		return this.getSqlSession().selectList(nameSpace+".selectAllBusSite");
	}
	
	/**
	 * 保存单个站点信息
	 * @param busSiteInfo
	 * @return
	 */
	public int updateBusSite(BusSiteInfo busSiteInfo) {		
		return this.getSqlSession().update(nameSpace+".updateBusSite", busSiteInfo);
	}
	
	/**
	 * 根据主键ID查询单个站点信息
	 * @param id
	 * @return
	 */
	public BusSiteInfo searchByID(int id) {
		return (BusSiteInfo)this.getSqlSession().selectOne(nameSpace+".selectBusSiteByID", id);
	}
	
	/**
	 * 根据线路ID删除线路
	 * @param id
	 * @return
	 */
	public int deleteBusLine(int id) {
		return this.getSqlSession().delete(nameSpace+".deleteBusLine", id);
	}
	
	/**
	 * 根据线路ID删除该线路的所有站点
	 * @param id
	 * @return
	 */
	public int deleteBusSiteOfLine(int id) {
		return this.getSqlSession().delete(nameSpace+".deleteBusSiteOfLine", id); 
	}
	
	/**
	 * 根据起始时间获取线路站点集合
	 * @param startDate
	 * @return
	 */
	public List<BusMessageView> selectBusSiteLineByTime(Date startDate) {
		return (List<BusMessageView>)this.getSqlSession().selectList(nameSpace+".selectSiteOfLineByTime",startDate);
	}
	
	/**
	 * 判断当前用户是否是管理员
	 * @param empCode
	 * @return
	 */
	public int checkIsAdmin(String empCode) {		
		return (Integer)this.getSqlSession().selectOne(nameSpace+".checkIsAdmin", empCode);
	}
}
