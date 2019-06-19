package com.deppon.dpm.module.management.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.server.dao.IAppDetailDao;
import com.deppon.dpm.module.management.shared.domain.AppCommentEntity;
import com.deppon.dpm.module.management.shared.domain.AppDetailEntity;
import com.deppon.dpm.module.management.shared.domain.ApplyStore;
import com.deppon.dpm.module.management.shared.domain.NQHandleEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 应用详情Dao实现层
 * 
 * @author 491275
 *
 */
public class AppDetailDao extends iBatis3DaoImpl implements IAppDetailDao{
	
	/**
	 * namespace
	 */
	private String NAME_SPACE = "com.deppon.dpm.module.management.server.dao.impl.AppDetailDao.";
	
	/**
	 * 查询应用商店所有app的id和名字 
	 */
	@SuppressWarnings("unchecked")
	public List<ApplyStore> selectAllAppId(){
		// 查询所有
	    List<ApplyStore> list = getSqlSession().selectList(NAME_SPACE + "selectAllAppId");
		if(list != null && list.size() > 0){
		// 返回
		   return list;
		}
		// 返回
		return null;
	}
	
	/**
	 * 根据id查询app名字
	 */
	public String selectAppNameById(int appId){
		return (String)getSqlSession().selectOne(NAME_SPACE + "selectAppNameById", 
				appId);
	}
	
	/**
	 * 插入应用详情
	 */
	@Override
	public int insertAppDetail(Map<Object, Object> map){
		return getSqlSession().insert(NAME_SPACE + "insertAppDetail", 
				map);
	}
	
	/**
	 * 详情表中某应用的数量
	 */
	public int getappdetailCount(String appName){
		return (Integer)getSqlSession().selectOne(NAME_SPACE + "getappdetailCount", 
				appName);
	}
	
	/**
	 * 根据id查询应用详情
	 */
	public AppDetailEntity selectAppDetailById(int appstoreId){
		return (AppDetailEntity)getSqlSession().selectOne(NAME_SPACE + "selectAppDetailById", 
				appstoreId);
	}
	
	/**
	 * 查询应用详情列表-后台
	 */
	@SuppressWarnings("unchecked")
	public List<AppDetailEntity> getAppDetailList(String userId){
		return getSqlSession().selectList(NAME_SPACE + "getAppDetailList", userId);
	}
	/**
	 * 274727可显示全部应用详情
	 */
	@SuppressWarnings("unchecked")
	public List<AppDetailEntity> getAllDetailList(String userId){
		return getSqlSession().selectList(NAME_SPACE + "getAllDetailList", userId);
	}
	
	/**
	 * 修改应用详情
	 */
	public int updateAppDetail(Map<Object, Object> map){
		return getSqlSession().update(NAME_SPACE + "updateAppDetail", 
				map);
	}
	
	/**
	 * 修改应用对接人
	 * @param map
	 * @return
	 */
	public int updateAppManager(Map<Object, Object> map){
		return getSqlSession().update(NAME_SPACE + "updateAppManager", 
				map);
	}
	
	public NQHandleEntity getNQHandleByApp(String appName){
		return (NQHandleEntity) getSqlSession().selectOne(NAME_SPACE + "getNQHandleByApp", appName);
	}
	
	public NQHandleEntity getNQHandlebyCode(String empCode){
		return (NQHandleEntity) getSqlSession().selectOne(NAME_SPACE + "getNQHandlebyCode", empCode);
	}
	
	/**
	 * 修改快捷帮助对接人
	 * @param map
	 * @return
	 */
	public int updateNQHandle(Map<Object, Object> map){
		return getSqlSession().update(NAME_SPACE + "updateNQHandle", 
				map);
	}
	
	public int deleteNQHandle(int id){
		return getSqlSession().delete(NAME_SPACE + "deleteNQHandle", id);
	}
	
	public int insertNQHandle(Map<Object, Object> map){
		return getSqlSession().insert(NAME_SPACE + "insertNQHandle",map);
	}
	
	/**
	 * 计算应用评分
	 */
	public Double getAppScore(int appId){
		return (Double)getSqlSession().selectOne(NAME_SPACE + "getAppScore", 
				appId);
	}
	
	/**
	 * 插入应用评论
	 */
	@Override
	public int insertAppComment(AppCommentEntity appCommentEntity){
		return getSqlSession().insert(NAME_SPACE + "insertAppComment", 
				appCommentEntity);
	}
	
	/**
	 * 获取应用评分
	 */
	public Double getAppScoreById(int appId){
		return (Double)getSqlSession().selectOne(NAME_SPACE + "getAppScoreById", 
				appId);
	}
	
	/**
	 * 更新应用评分
	 */
	public int updateTotalScore(Map<Object, Object> map){
		return getSqlSession().update(NAME_SPACE + "updateTotalScore", 
				map);
	}
	
	/**
	 * 获得该工号的评论数
	 */
	public int getEmpCodeCount(String empCode){
		return (Integer)getSqlSession().selectOne(NAME_SPACE + "getEmpCodeCount", 
				empCode);
	}
	
	/**
	 * 分页展示评论列表
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<AppCommentEntity> getCommentList(int appId,int startNo,int pageSize){
		//参数拼接
		Map map = new HashMap();
		//应用id
		map.put("appId", appId);
		//起始条数
		map.put("startNo", startNo);
		//每页数量
		map.put("pageSize", pageSize);
		
		return this.getSqlSession().selectList(NAME_SPACE + "getCommentList", 
				map);
	}
	
	/**
	 * 获取有回复权限的工号
	 */
	public List<String> getExcEmpcodeList(){
		return getSqlSession().selectList(NAME_SPACE + "getExcEmpcodeList");
	}
	
	/**
	 * 获得该应用的评论条数
	 */
	public int getCommentCount(int appId){
		return (Integer)getSqlSession().selectOne(NAME_SPACE + "getCommentCount", 
				appId);
	}
	
	/**
	 * 添加评论回复
	 */
	public int updateCommentReply(AppCommentEntity appCommentEntity){
		return getSqlSession().update(NAME_SPACE + "updateCommentReply", 
				appCommentEntity);
	}
}
