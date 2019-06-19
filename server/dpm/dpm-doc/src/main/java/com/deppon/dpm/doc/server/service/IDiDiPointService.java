package com.deppon.dpm.doc.server.service;

import java.util.List;

import com.deppon.dpm.doc.server.vo.DiDiPointVo;

public interface IDiDiPointService {

	
	/*
	 * 查询提示
	 */
	public DiDiPointVo getPoint();
	
	/*
	 * 查询已添加的提示
	 */
	public List<DiDiPointVo> getAllPoint(int start,int pageSize);
	/*
	 * 添加提示
	 */
	public int insertPoint(DiDiPointVo pointVo);
	/*
	 * 查询条数
	 */
	public int getCount();
	/*
	 * 更新状态
	 */
	public int updateState(int pointId);
}
