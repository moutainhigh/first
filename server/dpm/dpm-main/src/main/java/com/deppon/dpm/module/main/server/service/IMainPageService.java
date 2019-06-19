package com.deppon.dpm.module.main.server.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.main.shared.domain.NoticeCenterEntity;
import com.deppon.dpm.module.main.shared.domain.NoticeDetailEntity;


public interface IMainPageService {
	/**
	 * 每个人所拥有的卡片
	 * @return
	 */
	public String cardDetailByUserId(String userId);
	/**
	 * 查询首页展示的卡片
	 * @param userId
	 * @param password
	 * @param pageNo
	 * @param ymd
	 * @return
	 */
	public Map<String,Object> cardshow(String userId, String password, String pageNo, Date ymd);
	/**
	 * 获取消息类型
	 * @return
	 */
	public List<NoticeCenterEntity> getType(String userId);
	/**
	 * 获取消息详情
	 * @param type 
	 * @return
	 */
	public List<NoticeDetailEntity> getNoticeDetail(String userId, String type);
	/**
	 * 未读变已读
	 * @param type
	 * @param noticeId
	 * @param userId
	 * @return
	 */
	public Boolean noticeIsread(String type, String noticeId, String userId);
	/**
	 * 更改通知类型状态
	 * @param 
	 * @return
	 */
	public Boolean updateType(String type, String status);
	/**
	 * 添加通知类型
	 * @param map
	 * @return
	 */
	public Boolean addType(String type, String typename, String status);
	/**
	 * 删除通知类型
	 * @param map
	 * @return
	 */
	public Boolean delType(String type, String typename);
	/**
	 * 通知置顶功能
	 * @param map
	 * @return
	 */
	public List<NoticeCenterEntity> setTop(String userId,String type);
	/**
	 * 取消置顶功能
	 * @param map
	 * @return
	 */
	public List<NoticeCenterEntity> notsetTop(String userId, String type);
	
	/**
	 * 更改卡片开启状态
	 * @param 
	 * @return
	 */
	public Boolean updateCardType(String type, String status);
	/**
	 * 同步通知
	 * @param map
	 * @return
	 */
	public int addNoticeDetail(Map<String, String> map);
	
}
