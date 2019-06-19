package com.deppon.dpm.module.main.server.dao;

import java.util.List;

import com.deppon.dpm.module.main.shared.domain.RollAddDetailEntity;


/**
 * 首页改版Dao接口层
 * 
 * @author 491275
 *
 */
public interface IRollAdDao {
	
	/**
	 * 上传广告
	 * @param rollAdd 
	 */
	public int upload(RollAddDetailEntity rollAdd);

	public RollAddDetailEntity getRollAdDetail(int id);

	public List<RollAddDetailEntity> getRollAdList(String appType);
    /**
     * 删除滚动广告
     * @param id
     * @return
     */
	public int deleteRollAd(int id);

	public List<RollAddDetailEntity> getAllRollAdList();
    
	public int update(RollAddDetailEntity rollAdd);
	

}
