package com.deppon.dpm.module.lsp.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.lsp.shared.domain.PushAssetClearScrapeEntity;
import com.deppon.dpm.module.lsp.shared.domain.StockByEndDateEntity;
import com.deppon.dpm.module.lsp.shared.domain.StockTaskingEntity;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 资产盘点首页显示是否有盘点任务
 * @author 237986
 *
 */
public interface IAssetStockDao {
	/**
	 * 根据员工工号获取盘点任务编号
	 * @param empCode
	 * @return
	 */
	public List<StockTaskingEntity> getStockTaskNumber(Map<String, Object> map) throws BusinessException;
	
	public int updateStockNumber(String stockTaskingNumber);
	
	/** 
	* @Description: 根据时间分组来查询盘点表
	* @author 268087 张广波
	* @date 2015-9-1 下午3:17:28 
	*  @return 
	*/
	public List<StockByEndDateEntity> queryGroupByEndDate(Map<String, Object> map) throws BusinessException ;
	
	
	/**
	 * 根据单据编号查询单据的明细
	 * @param fnumber
	 * @return
	 * @throws Exception
	 */
	public PushAssetClearScrapeEntity queryAssetDetail(String fnumber)throws BusinessException;
	
	/**
     * 根据工号 获得 固定资产更新列表
     * @author gcl
     * @date 2015-4-16 下午5:48:08
     * @param pacse
     */
	public List<PushAssetClearScrapeEntity> queryAssetsClearList(PushAssetClearScrapeEntity pacse);

	
	/**
	 * 当扫描确认或回退成功后删除资产更新信息
	 *@author 237986
	 * @param fnumber
	 * @return
	 */
	public int delAssetsRenew(String fnumber);
	/**
     * 根据工号 获得 固定资产更新数量
     * @author 237986
     * @date 2015-5-07 上午09:46:13
     * @param pacse
     */
	public int queryAssetsClearCount(PushAssetClearScrapeEntity pacse);
	
	/**
	 * 查询盘点任务是否超时
	 * @author 237986
	 * @date 2015-5-11 上午09:58:13
	 * @param stockTaskingFnumber
	 * @return
	 */
	public int queryStockTimeOut(String stockTaskingFnumber);
	
	/**
	 * 删除超时的盘点任务
	 * @author 237986
	 * @date 2015-5-11 上午10:19:35
	 * @param stockTaskingFnumber
	 * @return
	 */
	public int delStockTask(String stockTaskingFnumber);
	
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
	public int queryFixedAssetsCount(String empCode);
	
	/**
	 * PC端回退盘点工作流后修改盘点任务状态为未提交
	 * @author 237986
	 * @date 2015-06-19 10:44:33
	 * @param stockTaskingNumber
	 * @return
	 */
	public int updateStockTask(String stockTaskingNumber);
}
