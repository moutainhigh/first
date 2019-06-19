package com.deppon.dpm.module.main.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;







import com.deppon.dpm.module.main.server.dao.IMainPageDao;
import com.deppon.dpm.module.main.shared.domain.NoticeCenterEntity;
import com.deppon.dpm.module.main.shared.domain.NoticeCenterIsTop;
import com.deppon.dpm.module.main.shared.domain.NoticeDetailEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class MainPageDao extends iBatis3DaoImpl implements IMainPageDao{
	
	/**
	 * namespace
	 */
	private String NAME_SPACE = "com.deppon.dpm.module.main.server.dao.mainPage.";
	
	/**
	 * 获取消息类型
	 */
	@SuppressWarnings("unchecked")
	public List<NoticeCenterEntity> getType(){
		
		return this.getSqlSession().selectList(NAME_SPACE + "getType");
	}
	
	/**
	 * 更改通知类型状态
	 */
	public int updateType(Map<String,String> map){
		
		return this.getSqlSession().update(NAME_SPACE + "updateType", map);
	}
	
	/**
	 * 添加通知类型
	 */
	public int addType(Map<String,String> map){
		
		return this.getSqlSession().insert(NAME_SPACE + "addType", map);
	}
	
	/**
	 * 删除通知类型
	 */
	public int delType(Map<String,String> map){
		
		return this.getSqlSession().delete(NAME_SPACE + "delType", map);
	}
	
	/**
	 * 查询是否存在该条通知
	 */
	public NoticeDetailEntity getNoticeDetail(Map<String,String> map){

		return (NoticeDetailEntity) getSqlSession().selectOne(NAME_SPACE + "getNoticeDetail", map);
	}
	
	/**
	 * 添加未读通知
	 */
	public int addNoticeDetail(Map<String,String> map){
		
		return this.getSqlSession().insert(NAME_SPACE + "addNoticeDetail", map);
	}
	
	/**
	 * 更改未读状态
	 */
	public int updateIsread(Map<String,String> map){
		
		return this.getSqlSession().update(NAME_SPACE + "updateIsread", map);
	}
	
	/**
	 * 查询卡片编号
	 */
	@SuppressWarnings("unchecked")
	public List<String> getShowCard(){
		
		return this.getSqlSession().selectList(NAME_SPACE + "getShowCard");
	}
    
	/**
	 * 插入指定表
	 */
	@Override
	public int insertNoticeIsTop(Map<String, Object> map) {
		 return this.getSqlSession().insert(NAME_SPACE + "insertNoticeIsTop", map);
		
	}
	/**
	 * 查询通知列表的顺序
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NoticeCenterIsTop> selectNoticeIsTop(String userId) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectNoticeIsTop", userId);
		
	}
	/**
	 *更改通知列表是否置顶
	 */
	@Override
	public int updateNoticeIsTop(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return this.getSqlSession().update(NAME_SPACE + "updateNoticeIsTop", map);
		
	}
	
	/**
	 * 更改卡片开启状态
	 * @param 
	 * @return
	 */
	public int updateCardType(Map<String, String> map){
		return  this.getSqlSession().update(NAME_SPACE + "updateCardStatus", map);
	}
    /**
     * 获取通知中心最新一条
     */
	@Override
	public NoticeDetailEntity getNoticeCenter(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (NoticeDetailEntity) getSqlSession().selectOne(NAME_SPACE + "getNoticeCenter", map);

	}
	/**
	 * 获取未读通知详情
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NoticeDetailEntity> getNoticeDetailList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(NAME_SPACE + "getNoticeDetailList", map);
	}
    
	/**
	 * 获取每天未读通知详情
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NoticeDetailEntity> getNoticeTodayList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(NAME_SPACE + "getNoticeTodayList", map);
	}

}
