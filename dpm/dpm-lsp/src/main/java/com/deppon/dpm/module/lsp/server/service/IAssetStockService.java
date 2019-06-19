package com.deppon.dpm.module.lsp.server.service;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.lsp.shared.domain.PushAssetClearScrapeEntity;
import com.deppon.dpm.module.lsp.shared.domain.StockByEndDateEntity;
import com.deppon.dpm.module.lsp.shared.domain.StockTaskingEntity;
import com.deppon.foss.framework.exception.BusinessException;



public interface IAssetStockService {

	/**
	 * 进入资产盘点首页时根据工号查询是否有盘点任务，若有任务则显示①
	 * @author 237986
	 *
	 */
	public List<StockTaskingEntity> getStockTaskNumber(Map<String, Object> map) throws BusinessException;
	
	/** 
	* @Description: 根据结束时间分组查询盘点任务
	* @author 268087 张广波
	* @date 2015-9-1 下午3:51:28 
	*  @param map
	*  @return
	*  @throws Exception 
	*/
	public List<StockByEndDateEntity> queryGroupByEndDate(Map<String, Object> map) throws BusinessException;	
	
	public String submitOrStorage(String  info);
	
	/**
	 * 资产更新扫描确认或回退接口
	 * @author 237986
	 * @return
	 */
	public String assetsRenew(String auditDecision,String flag);
	
	/**
	 * 获取更新资产的明细信息
	 * @data 2015/04/16 18:10:11
	 * @author 251624
	 * @param fnumber
	 * @return 资产明细
	 * @throws IOException
	 */
	public PushAssetClearScrapeEntity getAssetDetails(String fnumber) throws BusinessException;
	
	/**
     * 根据工号 获得 固定资产更新列表
     * @author gcl
     * @date 2015-4-16 下午5:58:08
     * @param pacse
     */
	public List<PushAssetClearScrapeEntity> queryAssetsClearList(PushAssetClearScrapeEntity pacse);
	/**
     * 根据工号 获得 固定资产更新数量
     * @author 237986
     * @date 2015-05-07 09:54:18
     * @param pacse
     */
	public int queryAssetsClearCount(PushAssetClearScrapeEntity pacse);
	

	/**
	 * 查询部门负责人同一部门下的所有员工工号
	 * @param empCode
	 * @return list
	 */
	public List<String> queryAllEmpCode(String empCode);
	
	/**
	 * 查询固定资产是否有任务
	 * @param empCode
	 * @return
	 */
	public String queryFixedAssetsCount(String empCode);
}
