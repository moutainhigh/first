package com.deppon.dpm.module.lsp.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.dpm.module.common.server.util.HttpUtil;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.lsp.server.dao.IAssetStockDao;
import com.deppon.dpm.module.lsp.server.service.IAssetStockService;
import com.deppon.dpm.module.lsp.shared.domain.PushAssetClearScrapeEntity;
import com.deppon.dpm.module.lsp.shared.domain.StockByEndDateEntity;
import com.deppon.dpm.module.lsp.shared.domain.StockEndDateListEntity;
import com.deppon.dpm.module.lsp.shared.domain.StockTaskingEntity;
import com.deppon.dpm.module.lsp.shared.vo.ResponseParameterEntity;
import com.deppon.dpm.module.news.server.service.impl.TpushNewsService;
import com.deppon.foss.framework.exception.BusinessException;

public class AssetStockService implements IAssetStockService{
	private static final String ESB_CODE_ASSETS_STOCK="ESB_DPM2ESB_LSP_ASSETS_REQCODE_LIST";
	private static Logger logger = Logger.getLogger(AssetStockService.class);
	private IAssetStockDao assetStockDao;
	private TpushNewsService tpushNewsService;//tpush推送接口
	public IAssetStockDao getAssetStockDao() {
		return assetStockDao;
	}

	public void setAssetStockDao(IAssetStockDao assetStockDao) {
		this.assetStockDao = assetStockDao;
	}
	
	public TpushNewsService getTpushNewsService() {
		return tpushNewsService;
	}

	public void setTpushNewsService(TpushNewsService tpushNewsService) {
		this.tpushNewsService = tpushNewsService;
	}

	/**
	 * 用户进入资产盘点首页时根据用户工号查询该用户是否有盘点任务，有则返回盘点任务单
	 * @author 237986
	 *
	 */
	@Override
	public List<StockTaskingEntity> getStockTaskNumber(Map<String, Object> map) throws BusinessException{
		List<StockTaskingEntity> list = new ArrayList<StockTaskingEntity>();
		if (assetStockDao.getStockTaskNumber(map)!=null&&assetStockDao.getStockTaskNumber(map).size()>0) {
			list = assetStockDao.getStockTaskNumber(map);
		}		 
		logger.info("=============工号"+map.get("empCode")+"的盘点任务有"+list.size()+"条");
		return list;
	}	
	
	/**
	 * 根据时间分组获取某个员工的盘点任务列表
	 */
	@Override
	public List<StockByEndDateEntity> queryGroupByEndDate(Map<String, Object> map) throws BusinessException {
		List<StockTaskingEntity> list = getStockTaskNumber(map);
		List<StockByEndDateEntity> dateEntities = assetStockDao.queryGroupByEndDate(map);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < dateEntities.size(); i++) {
			StockByEndDateEntity dateEntity = dateEntities.get(i);
			dateEntity.setStrStockEndDate(sdf.format(new Date(dateEntity.getStockEndDate().getTime())));
			List<StockEndDateListEntity> endDateListEntityList = new ArrayList<StockEndDateListEntity>();
			for (int j = 0; j < list.size(); j++) {
				StockEndDateListEntity endDateListEntity = new StockEndDateListEntity();  
				StockTaskingEntity taskingEntity = list.get(j);
				if (dateEntity.getStockEndDate().equals(taskingEntity.getStockTaskingEndDate())) {
					//9.24
					endDateListEntity.setDeptName(taskingEntity.getDeptName());
					endDateListEntity.setIsLeader(taskingEntity.getIsLeader());
					endDateListEntity.setStockTaskingNumber(taskingEntity.getStockTaskingNumber());
					endDateListEntityList.add(endDateListEntity);
				}
			}
			dateEntity.setDateListEntities(endDateListEntityList);
		}
		return dateEntities;
	}


	
	
	
	
	
	/**
	 * 提交暂存url
	 */
	private String synUrl;
	
	
	/**
	 * 推送提交和暂存数据
	 * @date 2015-3-30 18:21:00
	 * @param info
	 * @return
	 */
	@Override
	public String submitOrStorage(String  info) {
		int operatStatus = JsonUtil.jsonToInteger(info, "operatStatus");//操作状态
		String stockTaskingNumber=null;//盘点单号
		Map<String, Object> map=new HashMap<String, Object>();
			if(operatStatus == 1){//提交
				map.put("type","MOBILE_SUBMITWORKFLOW_LSP");//接口类型
			}
			else{//暂存
				map.put("type","MOBILE_SAVESTATUS_LSP");//接口类型
			}
			map.put("requestEntity", info);
			String result=null;
			try {
				String resString=HttpUtil.httpClient(JsonUtil.mapToJsonObject(map), synUrl, ESB_CODE_ASSETS_STOCK);
//				String ss="http://10.224.64.52:8180/lsp/webservice/fixassetMobileRest/processRestRequest";
				//String resString=HttpUtil.httpClient(JsonUtil.mapToJsonObject(map), ss, ESB_CODE_ASSETS_RENEW);
				logger.info("submitOrStorage：的盘点单接口返回是--"+resString);
				ResponseParameterEntity<?> rpe=JsonUtil.jsonToEntity(resString, ResponseParameterEntity.class); 
				if (rpe.isResultFlag()) {// 成功则返回1
					result = "{\"resultFlag\":\"1\"}";
					//请求lsp成功以后将status改为1，标识已提交
					if (operatStatus == 1) {
						stockTaskingNumber=JsonUtil.jsonGetValueBykey(info, "stockTaskingFnumber");
						assetStockDao.updateStockNumber(stockTaskingNumber);
						logger.info("盘点单----"+stockTaskingNumber+"提交成功============");
					}
					
				} else {// 失败则返回0
					result = "{\"resultFlag\":\"0\",\"failureReason\":\""+rpe.getFailureReason()+"\"}";
					logger.error("submitOrStorage--------"+rpe.getFailureReason());
				}
		} catch (Exception e) {
			logger.error("submitOrStorage--------盘点单提交或暂存失败",e);
 			e.printStackTrace();
 			result= "{\"resultFlag\":\"-1\",\"failureReason\":\"哎呀，请求出错，请稍后再试！\"}";
		}
		return result;
			
			
	}
	
	@Override
	public String assetsRenew(String auditDecision,String flag) {
		String result=null;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("type","MOBILE_AUDIT_LSP_ASSETCLEARSCRAPE");//接口类型
		map.put("requestEntity", JsonUtil.jsonGetValueBykey(auditDecision, "requestEntity"));
		try {
			String fnumber=JsonUtil.jsonGetValueBykey(auditDecision, "fnumber");
			String state=JsonUtil.jsonGetValueBykey(auditDecision, "state");				
			logger.info("=============单据号fnumber=>"+fnumber);
			logger.info("=============节点状态state=>"+state);
			//String ss="http://10.224.64.110:8089/lsp/webservice/fixassetMobileRest/processRestRequest";
			//String resString=HttpUtil.httpClient(JsonUtil.mapToJsonObject(map), ss, ESB_CODE_ASSETS_STOCK);				
			String resString=HttpUtil.httpClient(JsonUtil.mapToJsonObject(map), synUrl, ESB_CODE_ASSETS_STOCK);
			logger.info("============传过来的参数=>"+resString);
			ResponseParameterEntity<?> rpe=JsonUtil.jsonToEntity(resString, ResponseParameterEntity.class);			
			if (rpe.isResultFlag()) {		
				//if ("1".equals(state.trim())) {
					if (assetStockDao.delAssetsRenew(fnumber)>0) {//如果是倒数第二个节点就是最后一个节点就删除
						result="{\"resultFlag\":\"1\",\"failureReason\":\"\"}";
						logger.info("单据编号为"+fnumber+"的资产更新删除成功(扫描确认或回退后删除)============");
					}
					else{
						result="{\"resultFlag\":\"0\",\"failureReason\":\"哎呀，请求出错，请稍后再试！\"}";
						logger.error("单据编号为"+fnumber+"的资产更新删除失败(扫描确认或回退后删除)============");
					}
				//}				
			}
			else{
				result="{\"resultFlag\":\"0\",\"failureReason\":\"网络异常，请在PC端处理！\"}";
				logger.error("assetsRenew---------"+rpe.getFailureReason());
			}			
//			String resString=HttpUtil.httpClient(JsonUtil.mapToJsonObject(map), synUrl, ESB_CODE_ASSETS_STOCK);
//			ResponseParameterEntity<?> rpe=JsonUtil.jsonToEntity(resString, ResponseParameterEntity.class);
//			if (rpe.isResultFlag()) {
//				result="{\"resultFlag\":\"1\",\"failureReason\":\"\"}";
//			//	String fnumber=JsonUtil.jsonGetValueBykey(auditDecision, "fnumber");
//				//成功后删除资产更新任务
//				if (flag.equals("DISAGREE")) {//回退成功后删除资产更新任务
//					assetStockDao.delAssetsRenew(JsonUtil.jsonGetValueBykey(auditDecision, "fnumber"));
//				}
//				/*if (assetStockDao.delAssetsRenew(fnumber)>0) {
//					logger.info("单据编号为"+fnumber+"的资产更新删除成功(扫描确认或回退后删除)============");
//				}
//				else{
//					logger.error("单据编号为"+fnumber+"的资产更新删除失败(扫描确认或回退后删除)============");
//				}*/
//			}
//			else{
//				result="{\"resultFlag\":\"0\",\"failureReason\":\""+rpe.getFailureReason()+"\"}";
//				logger.error("assetsRenew---------"+rpe.getFailureReason());
//			}
		} catch (Exception e) {
			logger.error("assetsRenew---------扫描确认或回退失败",e);
			e.printStackTrace();
			result="{\"resultFlag\":\"-1\",\"failureReason\":\"哎呀，请求出错，请稍后再试！\"}";
		}
		
		return result;
	}
	
	/**
	 * 通过单据编号，获取对应的单据明细，然后把明细详情返回
	 * @param fnumber
	 * 			单据编号
	 * @throws Exception 
	 */
	@Override
	public PushAssetClearScrapeEntity getAssetDetails(String fnumber) throws BusinessException {
		
		//查询单据明细
		return assetStockDao.queryAssetDetail(fnumber);
	}
	
	@Override
	public List<PushAssetClearScrapeEntity> queryAssetsClearList(PushAssetClearScrapeEntity pacse) {
		return assetStockDao.queryAssetsClearList(pacse);
	}
	/**
	 * 根据工号查询固定资产更新数量
	 */
	@Override
	public int queryAssetsClearCount(PushAssetClearScrapeEntity pacse) {
		return assetStockDao.queryAssetsClearCount(pacse);
	}
	public void setSynUrl(String synUrl) {
		this.synUrl = synUrl;
	}

	public String getSynUrl() {
		return synUrl;
	}

	@Override
	public List<String> queryAllEmpCode(String empCode) {
		return assetStockDao.queryAllEmpCode(empCode);
	}

	@Override
	public String queryFixedAssetsCount(String empCode) {
		String result=null;
		try {
			int count=0;
			if(assetStockDao.queryFixedAssetsCount(empCode)>0){
				count=1;
			}
				result = "{\"resultFlag\":\""+count+"\"}";
			logger.info("[queryFixedAssetsCount]-----工号为"+empCode+"的员工有"+count+"固定资产任务");
		} catch (Exception e) {
			result = "{\"resultFlag\":\"0\"}";
			logger.error("[queryFixedAssetsCount]-----查询固定资产是否有任务失败!",e);
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		String resString="";
		ResponseParameterEntity<?> rpe=JsonUtil.jsonToEntity(resString, ResponseParameterEntity.class); 
		
	}
	
	
}
