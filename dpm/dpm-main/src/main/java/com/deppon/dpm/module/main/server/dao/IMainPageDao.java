package com.deppon.dpm.module.main.server.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.main.shared.domain.NoticeCenterEntity;
import com.deppon.dpm.module.main.shared.domain.NoticeCenterIsTop;
import com.deppon.dpm.module.main.shared.domain.NoticeDetailEntity;


/**
 * 首页改版Dao接口层
 * 
 * @author 491275
 *
 */
public interface IMainPageDao {
	
	/**
	 * 消息类型
	 */
	public List<NoticeCenterEntity> getType();
	/**
	 * 更改通知类型状态
	 * @param ncEntity
	 * @return
	 */
	public int updateType(Map<String,String> map);
	/**
	 * 添加通知类型
	 * @param map
	 * @return
	 */
	public int addType(Map<String,String> map);
	/**
	 * 删除通知类型
	 * @param map
	 * @return
	 */
	public int delType(Map<String,String> map);
	
	/**
	 * 查询是否存在该条通知
	 * @param map
	 * @return
	 */
	public NoticeDetailEntity getNoticeDetail(Map<String,String> map);
	/**
	 * 添加未读通知
	 * @param map
	 * @return
	 */
	public int addNoticeDetail(Map<String,String> map);
	/**
	 * 更改未读状态
	 * @param map
	 * @return
	 */
	public int updateIsread(Map<String,String> map);
	/**
	 * 查询卡片编号
	 * @param nocard
	 * @return
	 */
	public List<String> getShowCard();
	/**
	 * 存入指定表
	 * @param map
	 * @return
	 */
	public int insertNoticeIsTop(Map<String, Object> map);
	/**
	 * 查询通知列表的顺序
	 */
	public List<NoticeCenterIsTop> selectNoticeIsTop(String userId);
	/**
	 *更改通知列表是否置顶
	 */
	public int updateNoticeIsTop(HashMap<String, Object> map);
	/**
	 * 更改卡片开启状态
	 * @param 
	 * @return
	 */
	public int updateCardType(Map<String, String> map);
	/**
	 * 获取未读通知首页最新的一条
	 * @param map
	 * @return
	 */
	public NoticeDetailEntity getNoticeCenter(Map<String, Object> map);
	/**
	 * 获取未读通知详情
	 * @param map
	 * @return
	 */
	public List<NoticeDetailEntity> getNoticeDetailList(Map<String, Object> map);
	/**
	 * 获取每天未读通知详情
	 * @param map
	 * @return
	 */
	public List<NoticeDetailEntity> getNoticeTodayList(Map<String, Object> map);

}
