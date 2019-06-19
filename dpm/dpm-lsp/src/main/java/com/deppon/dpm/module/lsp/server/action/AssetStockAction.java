package com.deppon.dpm.module.lsp.server.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.service.IMonitorCountInfoService;
import com.deppon.dpm.module.common.server.util.Constants;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.lsp.server.service.IAssetStockService;
import com.deppon.dpm.module.lsp.server.service.IReceiveStockTaskService;
import com.deppon.dpm.module.lsp.shared.domain.PushAssetClearScrapeEntity;
import com.deppon.dpm.module.lsp.shared.domain.StockByEndDateEntity;
import com.deppon.dpm.module.news.server.service.impl.TpushNewsService;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.shared.util.string.StringUtil;
import com.deppon.lsp.module.fixasset.assetliablitychange.server.service.IDpmAssetLiablityChangeService;
import com.google.gson.Gson;

/**
 * 资产盘点action
 * 
 * @author 237986
 * 
 */
public class AssetStockAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(AssetStockAction.class);	
	//private static String SWEEP = "SWEEP";// 扫一扫
	private static String DISAGREE = "DISAGREE";// 回退
	// private static String AGREE="AGREE";//扫描确认
	private IAssetStockService assetStockService;
	@Resource
	private IReceiveStockTaskService stockTaskService;
	@Resource
	private TpushNewsService tpushNewsService;
	
	@Autowired
	private IDpmAssetLiablityChangeService dpmAssetLiablityChangeServiceImpl;
	
	public void setAssetStockService(IAssetStockService assetStockService) {
		this.assetStockService = assetStockService;
	}

	public void processTest() throws IOException{
		String jString ="{\"requestEntity\":[{\"applicant\":\"范皓\",\"applicantCode\":\"130748\",\"assetCoding\":\"02-122542\",\"auditorList\":[{\"empCode\":\"130748\",\"empName\":\"范皓\"}],\"beginAuditDate\":1439783934819,\"belongCompany\":\"郑州德邦\",\"department\":\"郑州中原区郑上路营业部\",\"docNo\":\"DLSP201508171392687\",\"fixedAssetsName\":\"叉车秤\",\"fnumber\":\"GBS-20150817-00341\",\"managementCode\":\"0502201212118960\",\"remark\":\"领导好，部门叉车称已使用四年，多次损坏，已无维修价值，现申请报废，请批准！\",\"tpName\":\"固定资产更新申请单\",\"useStatus\":\"正在使用\"}],\"type\":\"LSP_PUSHAUDITNOTICE_MOBILE\"}";
		stockTaskService.processRestResponse(jString);
	}
	
	public void processTaskTest() throws IOException{
		String jString="{\"requestEntity\": [{\"stockTaskingEmpCode\": \"040324\",\"stockTaskingEndDate\": 1443456000000,\"useDeptName\": \"财务系统开发组\",\"useDeptCode\": \"DP08392\",\"stockTaskingName\": \"张平丽\",\"stockTaskingNumber\": \"201509010004\"}],\"type\": \"LSP_PUSHNOTICE_MOBILE\"}";
		stockTaskService.processRestResponse(jString);
	}
	
	public void setDpmAssetLiablityChangeServiceImpl(
			IDpmAssetLiablityChangeService dpmAssetLiablityChangeServiceImpl) {
		this.dpmAssetLiablityChangeServiceImpl = dpmAssetLiablityChangeServiceImpl;
	}


	/**
	 * 记录提交响应时长
	 */
	private IMonitorCountInfoService monitorCountInfoService;

	public void setMonitorCountInfoService(
			IMonitorCountInfoService monitorCountInfoService) {
		this.monitorCountInfoService = monitorCountInfoService;
	}

	/**
	 * 单据编号
	 */
	String fnumber;

	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}

	/**
	 * 用户进入资产盘点首页时根据用户工号查询该用户是否有盘点任务，有则返回盘点任务单
	 * 
	 * @author 237986
	 * 
	 *//*
	public String queryStockTaskNumber() {
		// 设置页面响应实体
		String res = "";
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			try {
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("empCode", userId);
				map.put("codeLength", userId.length());
				// 根据员工工号查询盘点任务
				List<StockTaskingEntity> stockList = assetStockService
						.getStockTaskNumber(map);
				int size=stockList.size();
				if (size<=0) {
					res = "{\"stockTaskNumber\":\"\",\"isLeader\":\"\",\"count\":\"\"}";
				}
				else {
					StockTaskingEntity stockEntity=stockList.get(0);
					//res = "{\"stockTaskNumber\":\"" + stockList.get(0) + "\",\"count\":"+size+"}";
					res = "{\"stockTaskNumber\":\"" + stockEntity.getStockTaskingNumber() + "\",\"isLeader\":\""+stockEntity.getIsLeader()+"\",\"count\":"+size+"}";
				}

			} catch (Exception e) {
				e.printStackTrace();
				res = "{\"stockTaskNumber\":\"\",\"isLeader\":\"\",\"count\":\"\"}";

			}
		// 返回给页面
		writeToPage(response, res);
		return null;
	}*/
	
	/**
	 * 用户进入资产盘点首页时根据用户工号查询该用户是否有盘点任务，有则返回盘点任务单
	 * 
	 * @author 237986
	 * 
	 */
	public String queryStockTaskNumber()  throws BusinessException {
		// 设置页面响应实体
		String res = "";
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			try {
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("empCode", userId);
				map.put("codeLength", userId.length());
				/*map.put("empCode", "028194");
				map.put("codeLength", "028194".length());*/
				// 根据员工工号查询盘点任务
				List<StockByEndDateEntity> dateEntities = assetStockService.queryGroupByEndDate(map);
				int size=assetStockService.getStockTaskNumber(map).size();
				if (size<=0) {
					res = "{\"stockTaskNumber\":\"\",\"isLeader\":\"\",\"count\":0}";
				}
				else {
					res="{\"count\":"+size+",\"itemList\":";
					res+=JsonUtil.beanToJsonString(dateEntities);					
					res+="}";				
				}
			} catch (Exception e) {
				e.printStackTrace();
				res = "{\"stockTaskNumber\":\"\",\"isLeader\":\"\",\"count\":0}";

			}
		// 返回给页面
		writeToPage(response, res);
		return null;
	}

	
	/**
	 * 提交或暂存
	 * 
	 * @throws IOException
	 */
	public void submitOrStorage() {
		// 开始时间
		Date startDate = new Date();
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String resString = "";
		BufferedReader bu = null;
		String str = "";
		try {
			bu = ServletActionContext.getRequest().getReader();
			/*str = com.deppon.dpm.module.common.server.util.StringUtil
					.bufferString(bu);*/
			//编码转换
			str = java.net.URLDecoder.decode(com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu), "utf-8");
			logger.info("submitOrStorage：盘点单暂存或提交前端所传参数为--"+str);
			if(!StringUtil.isEmpty(str)){
				//String str2 = "{\"stockTaskingFnumber\":\"201506100073\",\"operatStatus\":1,\"description\":\"cdcdscscs\",\"assetList\":[{\"managementCode\":\"05111111\",\"assetCoding\":\"10000000\",\"remark\":\"AAAAAAAAAAAAAAA\"},{\"managementCode\":\"05222222\",\"assetCoding\":\"20000000\",\"remark\":\"BBBBBBBBBBBBBBB\"}]}";
				resString = assetStockService.submitOrStorage(str);
	
				// 结束时间
				if (JsonUtil.jsonGetValueBykey(resString, "resultFlag").equals("1")) {//提交或暂存成功插入数据监控
					Date endDate = new Date();
					int type = Constants.ASSETS_SUMIT;
					int operatStatus = JsonUtil.jsonToInteger(str, "operatStatus");// 操作状态
					if (operatStatus == 0) {
						type = Constants.ASSETS_STORAGE;// 提交:3,暂存：4
					}
					// 统计响应时长
					monitorCountInfoService.saveMonitorCountInfo(userId, startDate,
							endDate, type);
				}
			}
		} catch (Exception ce) {
			logger.error("submitOrStorage--------盘点单提交或暂存失败",ce);
			ce.printStackTrace();
		}
		writeToPage(response, resString);
	}

	/**
	 * 资产更新回退或扫描确认
	 */
	public void assetsRenew() {
		//{"requestEntity":[{"stockTaskingEmpCode":"238262","stockTaskingEndDate":1440345600000,"stockTaskingName":"谢秋香","stockTaskingNumber":"201508200056"}],"type":"LSP_PUSHNOTICE_MOBILE"}
		// 开始时间
		Date startDate = new Date();
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		BufferedReader bu = null;
		String strJson = "";// 接收前台传送信息
		String resString = "";// 接收返回信息
		try {
			bu = ServletActionContext.getRequest().getReader();
			/*strJson = com.deppon.dpm.module.common.server.util.StringUtil
					.bufferString(bu);*/
			//编码转换
			strJson = java.net.URLDecoder.decode(com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu), "utf-8");
			if(!StringUtil.isEmpty(strJson)){
				// "{\"fnumber\":\"111111\",\"requestEntity\":[{\"docID\":\"DLSP201504030010140\",\"decision\":\"disagree\",\"optinion\":\"回退意见\",\"empCode\":\"046707\",\"empName\":\"孙伟\"}]}";
				//String strJson1 = "{\"flag\":\"AGREE\",\"fnumber\":\"GBS-20150508-00053\",\"requestEntity\":[{\"docID\":\"DLSP201505080010563\",\"decision\":\"agree\",\"optinion\":\"回退意见\",\"empCode\":\"046707\",\"empName\":\"孙伟\"}]}";
				String flag = JsonUtil.jsonGetValueBykey(strJson, "flag");
				resString = assetStockService.assetsRenew(strJson,flag);
				int type = 0;
//				if (SWEEP.equals(flag)) {// 如果提交的是扫一扫
//					type = Constants.ASSETS_RENEW_SWEEP;
//				} else
				if (DISAGREE.equals(flag)) {// 如果提交的是回退
					type = Constants.ASSETS_BACK;
				} else {// 确认扫描
					type = Constants.SWEEP_CONFIRM;
				}
				// 结束时间
				Date endDate = new Date();
				// 统计响应时长
				monitorCountInfoService.saveMonitorCountInfo(userId, startDate,
						endDate, type);
			}
		} catch (Exception ce) {
			ce.printStackTrace();
		}

		writeToPage(response, resString);

	}

	/**
	 * 通过单据编号，获取对应的单据明细，然后把明细详情返回
	 * 
	 * @param fnumber
	 *            单据编号
	 * @throws Exception
	 */
	public void assetDetails() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HashMap<String, Object> retJsonObj = new HashMap<String, Object>();
		// 返回结果
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			// 单据编号不能为空
			if (!StringUtil.isEmpty(fnumber)) {
				PushAssetClearScrapeEntity resEntity = assetStockService
						.getAssetDetails(fnumber);
				if (resEntity != null) {
					// 单据明细获取成功
					retJsonObj.put("retCode", "0");
					retJsonObj.put("assetDetails", resEntity);
					retJsonObj.put("retMsg", "");
				} else {
					// 单据明细获取失败
					retJsonObj.put("retCode", "1");
					retJsonObj.put("retMsg", "没有查询到单据所对应的详细信息");
				}
			} else {
				retJsonObj.put("retCode", "1");
				retJsonObj.put("retMsg", "单据编号不能为空！");
			}
		} catch (Exception e) {
			retJsonObj.put("retCode", "1");
			retJsonObj.put("retMsg", "查询数据发生异常！");

			e.printStackTrace();
		}

		
		writeToPage(response, JsonUtil.mapToJsonString(retJsonObj));
	}

	/**
	 * 获得资产更新列表 gcl
	 */
	public void queryAssetsRenewList() {
		// 开始时间
		Date startDt = new Date();
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		PushAssetClearScrapeEntity pacse = new PushAssetClearScrapeEntity();
		pacse.setAuditor(userId);// 审批人工号
		List<PushAssetClearScrapeEntity> list = assetStockService
				.queryAssetsClearList(pacse);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String yest = sdf.format(cal.getTime());
		List<PushAssetClearScrapeEntity> todayList = new ArrayList<PushAssetClearScrapeEntity>();
		List<PushAssetClearScrapeEntity> yestList = new ArrayList<PushAssetClearScrapeEntity>();
		List<PushAssetClearScrapeEntity> otherList = new ArrayList<PushAssetClearScrapeEntity>();

		for (PushAssetClearScrapeEntity e : list) {
			if (today.equals(e.getBelongCompany().trim())) {
				todayList.add(e);
			} else if (yest.equals(e.getBelongCompany().trim())) {
				yestList.add(e);
			} else {
				otherList.add(e);
			}
		}
		Map<String, List<PushAssetClearScrapeEntity>> map = new HashMap<String, List<PushAssetClearScrapeEntity>>();
		map.put("todayList", todayList);
		map.put("yestList", yestList);
		map.put("otherList", otherList);
		// 结束时间
		Date endDt = new Date();
		
		// 保存资产更新入口数据监控
		monitorCountInfoService.saveMonitorCountInfo(userId,startDt,endDt,Constants.ASSETS_RENEW);
		writeToPage(response, new Gson().toJson(map));
	}
	/**
	 * 获得资产更新数量
	 */
	public void queryAssetsRenewCount() {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		PushAssetClearScrapeEntity pacse = new PushAssetClearScrapeEntity();
		pacse.setAuditor(userId);// 审批人工号
		int count=0;
		try {
			count=assetStockService.queryAssetsClearCount(pacse);
			/*//固定资产更新消息通知
			NewsCenterEntity newsCenterEntity = new NewsCenterEntity(
					"2", 3, 0, 0,"固定资产"); 
			tpushNewsService.pushUserNews(userId, "你有"+count+"个资产更新任务",  "资产更新任务",newsCenterEntity);
			logger.info("工号为"+userId+"的资产更新任务推送成功!");*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeToPage(response, String.valueOf(count));
	}
	/**
	 * 查询固定资产是否有任务
	 * @param empCode
	 * @return
	 */
	public void queryFixedAssetsCount() {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		writeToPage(response, assetStockService.queryFixedAssetsCount(userId));
	}
	
	/**
	 * 查询本人资产
	 */
	public void queryMyAsset() {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String resString = "";
		try {
			resString = dpmAssetLiablityChangeServiceImpl.queryPersonAsset(userId);
		} catch (Exception ce) {
			ce.printStackTrace();
		}
		writeToPage(response, resString);
	}
	
	/**
	 * 查询资产变更责任人
	 */
	public void queryAssetliablity() {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String resString = "";
		try {
			resString = dpmAssetLiablityChangeServiceImpl.queryAssetliablity(userId);
		} catch (Exception ce) {
			ce.printStackTrace();
		}
		writeToPage(response, resString);
	}
	
	/**
	 * 提交资产责任人变更单
	 */
	public void submitBill() {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String billJson = "";
		String resString = "";
		HttpServletRequest request = ServletActionContext.getRequest();
        if ("POST".equals(request.getMethod())) {
        	try {
        		//读取前台发送的流
        		BufferedReader bu = request.getReader();
        		//流转换成String
        		/*billJson = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);*/
    			//编码转换
    			billJson = java.net.URLDecoder.decode(com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu), "utf-8");
    			resString = dpmAssetLiablityChangeServiceImpl.submitBill(userId, billJson);
    		} catch (Exception ce) {
    			ce.printStackTrace();
    		}
        }
		writeToPage(response,resString);
	}

}