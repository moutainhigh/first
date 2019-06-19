package com.deppon.dpm.module.main.server.service;

import java.util.List;

import com.deppon.dpm.module.main.shared.domain.RollAddDetailEntity;

public interface IRollAdService {
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
	 /**
     * 获取所有的广告图片
     * @param id
     * @return
     */
	public List<RollAddDetailEntity> getAllRollAdList();
	/**
     * 更新所有的广告图片
     * @param id
     * @return
     */
	public int update(RollAddDetailEntity rollAdd);
    
	
	

}
