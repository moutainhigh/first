package com.deppon.dpm.module.main.server.service;

import java.util.List;

import com.deppon.dpm.doc.server.vo.DiDiPointVo;
import com.deppon.dpm.module.main.shared.domain.MessagePointVo;

public interface IMessagePointService {

	
	/*
	 * 查询提示
	 */
	public MessagePointVo getPoint(String appId);
	
	/*
	 * 查询已添加的提示
	 */
	public List<MessagePointVo> getAllPoint(int start,int pageSize);
	/*
	 * 添加提示
	 */
	public int insertPoint(MessagePointVo pointVo);
	/*
	 * 查询条数
	 */
	public int getCount();
	/*
	 * 更新状态
	 */
	public int updateState(int pointId);
}
