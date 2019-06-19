package com.deppon.dpm.module.lsp.server.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.lsp.server.dao.IAssetStockDao;
import com.deppon.dpm.module.lsp.shared.domain.PushAssetClearScrapeEntity;
import com.deppon.dpm.module.lsp.shared.domain.StockByEndDateEntity;
import com.deppon.dpm.module.lsp.shared.domain.StockTaskingEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 资产盘点首页显示是否有盘点任务
 * @author 237986
 *
 */
public class AssetStockDao extends iBatis3DaoImpl implements IAssetStockDao {
	static String mapperNameSpace = "com.deppon.dpm.module.lsp.server.dao.stocktask";

	/**
	 * 根据工号查询盘点任务编号
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StockTaskingEntity> getStockTaskNumber(Map<String, Object> map)
			throws Exception {
		//返回数据
		return this.getSqlSession().selectList(
				mapperNameSpace + ".getStockTaskNumber", map);
	}

	/**
	 * 提交后将STATUS改为1，标识一提交
	 */
	@Override
	public int updateStockNumber(String stockTaskingNumber) {
		// System.out.println("提交成功后修改=======================");
		return this.getSqlSession().update(
				mapperNameSpace + ".updateStockTaskBystockTaskingNumber",
				stockTaskingNumber);
	}

	/**
	 * 根据工号查询验收任务结束时间列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StockByEndDateEntity> queryGroupByEndDate(
			Map<String, Object> map) throws Exception {
		//返回数据
		return this.getSqlSession().selectList(
				mapperNameSpace + ".groupByEndDate", map);
	}

	/**
	 * 查询更新资产明细
	 */
	@Override
	public PushAssetClearScrapeEntity queryAssetDetail(String fnumber)
			throws Exception {
		//返回数据
		return (PushAssetClearScrapeEntity) this.getSqlSession().selectOne(
				mapperNameSpace + ".selectAssetDetail", fnumber);
	}

	/**
	 * 根据工号 获得 固定资产更新列表
	 * 
	 * @author gcl
	 * @date 2015-4-16 下午5:48:08
	 * @param pacse
	 */
	@Override
	public List<PushAssetClearScrapeEntity> queryAssetsClearList(
			PushAssetClearScrapeEntity pacse) {
		//返回数据
		return this.getSqlSession().selectList(
				mapperNameSpace + ".queryAssetsRenewList", pacse);
	}

	/**
	 * 删除超时的盘点任务
	 * 
	 * @author 237986
	 * @date 2015-5-11 上午10:19:35
	 * @param stockTaskingFnumber
	 * @return
	 */
	@Override
	public int delAssetsRenew(String fnumber) {
		//返回数据
		return this.getSqlSession()
				.delete(mapperNameSpace + ".delete", fnumber);
	}

	/**
	 * 根据工号 获得 固定资产更新列表
	 * 
	 * @author gcl
	 * @date 2015-4-16 下午5:48:08
	 * @param pacse
	 */
	@Override
	public int queryAssetsClearCount(PushAssetClearScrapeEntity pacse) {
		return (Integer) this.getSqlSession().selectOne(
				mapperNameSpace + ".queryAssetsRenewCount", pacse);
	}

	/**
	 * 查询盘点任务是否超时
	 * 
	 * @author 237986
	 * @date 2015-5-11 上午09:58:13
	 * @param stockTaskingFnumber
	 * @return
	 */
	@Override
	public int queryStockTimeOut(String stockTaskingFnumber) {
		return (Integer) this.getSqlSession().selectOne(
				mapperNameSpace + ".selectTimeOut", stockTaskingFnumber);
	}

	/**
	 * 删除超时的盘点任务
	 * 
	 * @author 237986
	 * @date 2015-5-11 上午10:19:35
	 * @param stockTaskingFnumber
	 * @return
	 */
	@Override
	public int delStockTask(String stockTaskingFnumber) {
		//返回是否成功删除数据
		return this.getSqlSession().delete(
				mapperNameSpace + ".deleteStockTask", stockTaskingFnumber);
	}

	/**
	 * 查询部门负责人同一部门下的所有员工工号
	 * 
	 * @param empCode
	 * @return list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> queryAllEmpCode(String empCode) {
		List<String> list = new ArrayList<String>();
		try {
			list = this.getSqlSession().selectList(
					mapperNameSpace + ".selectEmpCodeList", empCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询固定资产是否有任务
	 * 
	 * @param empCode
	 * @return
	 */
	@Override
	public int queryFixedAssetsCount(String empCode) {
		//返回是否有任务
		return (Integer) this.getSqlSession().selectOne(
				mapperNameSpace + ".queryFixedAssetsCount", empCode);
	}

	/**
	 * PC端回退盘点工作流后修改盘点任务状态为未提交
	 * 
	 * @author 237986
	 * @date 2015-06-19 10:44:33
	 * @param stockTaskingNumber
	 * @return
	 */
	@Override
	public int updateStockTask(String stockTaskingNumber) {
		//返回更新数据的标志位
		return this.getSqlSession().update(
				mapperNameSpace + ".updateStockTaskStatus", stockTaskingNumber);
	}

}
