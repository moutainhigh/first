package com.deppon.dpm.module.lsp.server.dao.impl;

import com.deppon.dpm.module.lsp.server.dao.IReceiveStockTaskDao;
import com.deppon.dpm.module.lsp.shared.domain.PushAssetClearScrapeEntity;
import com.deppon.dpm.module.lsp.shared.domain.StockTaskingNotice;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 操作盘点任务的数据库操作类
 * @date 2015/03/18 10:28:00
 * @author 237986
 *
 */
public class ReceiveStockTaskDaoImpl extends iBatis3DaoImpl implements IReceiveStockTaskDao {
	/**
	 * 保存盘点任务
	 * @param stn
	 * @return
	 */
	@Override
	public int saveStockTaskingNotice(StockTaskingNotice stn) {
		//返回是否成功插入盘点任务的标志
		return this.getSqlSession().insert("com.deppon.dpm.module.lsp.server.dao.stocktask.insert", stn);
	}
	/**
	 * 保存资产更新
	 * @param pacse
	 * @return
	 */
	@Override
	public int saveAssetsClear(PushAssetClearScrapeEntity pacse) {
		//返回是否成功资产更新的标志
		return this.getSqlSession().insert("com.deppon.dpm.module.lsp.server.dao.stocktask.insertAssetsRenew",pacse);
	}
	
	/** 
	* @Description: 资产更新修改
	* @author 268087 张广波
	* @date 2015-9-14 上午8:17:18 
	*  @param pacse
	*  @return 
	*/
	public int updateAssetsRenew(PushAssetClearScrapeEntity pacse) {
		return this.getSqlSession().update("com.deppon.dpm.module.lsp.server.dao.stocktask.updateAssetsRenew",pacse);
	}
	/** 
	* @Description: 查询更新任务是否有重复
	* @author 268087 张广波
	* @date 2015-9-19 下午2:43:24 
	*  @param pacse
	*  @return 
	*/
	@Override
	public int queryIsRepeat(PushAssetClearScrapeEntity pacse) {
		return (Integer)this.getSqlSession().selectOne("com.deppon.dpm.module.lsp.server.dao.stocktask.queryIsRepeat",pacse);
	}
	
}
