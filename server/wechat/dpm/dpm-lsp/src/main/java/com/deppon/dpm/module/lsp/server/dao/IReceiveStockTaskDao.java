package com.deppon.dpm.module.lsp.server.dao;

import com.deppon.dpm.module.lsp.shared.domain.PushAssetClearScrapeEntity;
import com.deppon.dpm.module.lsp.shared.domain.StockTaskingNotice;

/**
 * 操作盘点任务的数据库操作类
 * @date 2015/03/18 10:28:00
 * @author 237986
 *
 */
public interface IReceiveStockTaskDao {
	/**
	 * 保存盘点任务
	 * @param stn
	 * @return
	 */
	public int saveStockTaskingNotice(StockTaskingNotice stn);
	
	/**
	 * 保存资产更新
	 * @param pacse
	 * @return
	 */
	public int saveAssetsClear(PushAssetClearScrapeEntity pacse);
	
	/** 
	* @Description: 资产更新修改
	* @author 268087 张广波
	* @date 2015-9-14 上午8:17:18 
	*  @param pacse
	*  @return 
	*/
	public int updateAssetsRenew(PushAssetClearScrapeEntity pacse);
	
	/** 
	* @Description: 查询更新任务是否有重复
	* @author 268087 张广波
	* @date 2015-9-19 下午2:43:24 
	*  @param pacse
	*  @return 
	*/
	public int queryIsRepeat(PushAssetClearScrapeEntity pacse);
}
