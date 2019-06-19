package com.deppon.dpm.module.management.server.dao;

import java.util.HashMap;

import com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity;

public interface IProcManWorkDao {
	/** 
	* @Description: 检查暂存是否重复
	* @author 268087 张广波
	* @date 2015-9-29 上午11:41:03 
	*  @return 
	*/
	public int checkIsRepMan(String userNo);
	/** 
	* @Description: 保存暂存
	* @author 268087 张广波
	* @date 2015-9-29 上午11:41:23 
	*  @return 
	*/
	public int saveProcMan(ProcMaintainEntity maintainEntity);
	/** 
	* @Description: 更新暂存
	* @author 268087 张广波
	* @date 2015-9-29 上午11:41:39 
	*  @return 
	*/
	public int updateProcMan(ProcMaintainEntity maintainEntity);
	
	/** 
	* @Description: 查询申请单详情
	* @author 268087 张广波
	* @date 2015-9-29 上午11:42:20 
	*  @return 
	*/
	public ProcMaintainEntity queryForList(String pid);
	
	
	/** 
	* @Description: 工程勘测-更新勘测单状态
	* @author 268087 张广波
	* @date 2015-12-14 下午2:04:04 
	*  @param paramHashMap
	*  @return 
	*/
	public int updateSurveyState(HashMap<String, String> paramHashMap);
}
