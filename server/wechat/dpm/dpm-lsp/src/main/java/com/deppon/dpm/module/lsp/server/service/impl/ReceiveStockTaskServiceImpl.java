package com.deppon.dpm.module.lsp.server.service.impl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;


import org.apache.log4j.Logger;

import com.deppon.dpm.module.common.server.service.IMonitorCountInfoService;
import com.deppon.dpm.module.common.server.util.Constants;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.lsp.server.dao.IAssetStockDao;
import com.deppon.dpm.module.lsp.server.dao.IReceiveStockTaskDao;
import com.deppon.dpm.module.lsp.server.service.IReceiveStockTaskService;
import com.deppon.dpm.module.lsp.shared.domain.Auditor;
import com.deppon.dpm.module.lsp.shared.domain.PushAssetClearScrapeEntity;
import com.deppon.dpm.module.lsp.shared.domain.StockTaskingNotice;
import com.deppon.dpm.module.news.server.service.impl.TpushNewsService;
import com.deppon.dpm.module.news.shared.domain.NewsCenterEntity;
public class ReceiveStockTaskServiceImpl implements IReceiveStockTaskService {
	private static Logger logger = Logger.getLogger(ReceiveStockTaskServiceImpl.class);
	@Resource
	private IReceiveStockTaskDao receiveStockTaskDao;
	@Resource
	private TpushNewsService tpushNewsService;
	@Resource
	private IAssetStockDao assetStockDao;
	@Resource 
	private IMonitorCountInfoService monitorCountInfoService;
	
	@Override
    public Response  processRestResponse(String strJson) throws IOException {
		List<String> stockList=new ArrayList<String>(); 
		int flag=0;  
		NewsCenterEntity nce=null;
		String res=null;
		// 开始时间
		Date startDt = new Date();
		try {
		     //String strJson2 = "{\"type\":\"LSP_PUSHAUDITNOTICE_MOBILE\",\"requestEntity\":[{\"docNo\":\"111111\",\"fnumber\":\"123458\",\"tpName\":\"资产更新工作流\",\"assetCoding\":\"1010101010\",\"remark\":\"备注\",\"department\":\"IT\",\"managementCode\":\"05011010\",\"fixedAssetsName\":\"主机\",\"useStatus\":\"正在使用\",\"belongCompany\":\"德邦物流\",\"applicantCode\":\"046707\",\"applicant\":\"姚明\",\"beginAuditDate\":\"1429004174674\",\"auditorList\":[{\"empCode\":\"103755\",\"empName\":\"ROSE\"},{\"empCode\":\"000001\",\"empName\":\"KOBE\"}]}]}";
			 String type=JsonUtil.jsonGetValueBykey(strJson, "type");
			
			// System.out.println(strJson);
			 if (type.equals("LSP_PUSHNOTICE_MOBILE")) {//LSP_PUSHNOTICE_MOBILE:推送盘点任务,LSP_PUSHAUDITNOTICE_MOBILE:推送资产更新
				 List<StockTaskingNotice> stnList=JsonUtil.jsonToList(JsonUtil.jsonGetValueBykey(strJson, "requestEntity"), StockTaskingNotice.class);
				
				 for (StockTaskingNotice stn:stnList) {
					 String stockEmpCode=stn.getStockTaskingEmpCode();
					 //根据部门领导人工号查询部门下所有员工
					 List<String> empCodeList=assetStockDao.queryAllEmpCode(stockEmpCode);
					 StringBuffer empCode=new StringBuffer();
					 for (String code:empCodeList) {
						 empCode.append(code+"|");
					 }
					// System.out.println("部门领导人是============="+stockEmpCode);
					 empCode.append(stockEmpCode);
					 //System.out.println("所有人=="+empCode.toString());
					 stn.setStockTaskingEmpCode(empCode.toString());
					 String st="";
					 try {
						 //保存接收到的盘 点任务
						 flag=receiveStockTaskDao.saveStockTaskingNotice(stn);
						// 结束时间
						 Date endDt = new Date();
						 monitorCountInfoService.saveMonitorCountInfo(stockEmpCode,startDt,endDt,Constants.STOCK_TASK_QUANTITY);
						} catch (Exception e) {
							st=e.getMessage();
							 logger.error("[processRestResponse]-----盘点单为"+stn.getStockTaskingNumber()+"的任务插入失败",e);
						}
					 if (flag>0) {//保存成功推送盘点任务
						 //String []str=empCode.toString().split("\\|");
						 //for (String emp:str) {
							 //实例化推送对象
//							 nce=new NewsCenterEntity();
//							 nce.setApplicationId(DpmConstants.FIXED_ASSETS);
//							 nce.setTaskId(stn.getStockTaskingNumber());
//							 nce.setActive(DpmConstants.YES);
//							 nce.setContent("");
//							 nce.setIsTxtNews(DpmConstants.NO);
						 
							 /*nce = new NewsCenterEntity(
										stn.getStockTaskingNumber(), 3, 0, 1,
										"固定资产");*/
						 
						 	nce = new NewsCenterEntity("2", 3, 0, 1,"固定资产");
							tpushNewsService.pushUserNews(stockEmpCode, "你有一个盘点任务",  "固定资产任务",nce);
						//}
						
						 logger.info("[processRestResponse]-----盘点单为"+stn.getStockTaskingNumber()+"的任务插入成功");
						 //res="{\"resultFlag\":\"true\",\"responseEntity\":\"\",\"failureReason\":\"\"}";
					 }
//						 logger.info("[processRestResponse]-----盘点单为"+stn.getStockTaskingNumber()+"的任务插入成功");
//						 //res="{\"resultFlag\":\"true\",\"responseEntity\":\"\",\"failureReason\":\"\"}";
//					 }
					 else{
						 if (!st.contains("for key 'PRIMARY'")) {
							 stockList.add(stn.getStockTaskingNumber());
						}
						 //res="{\"resultFlag\":\"false\",\"responseEntity\":\""+JsonUtil.listToJsonString(stockList)+"\",\"failureReason\":\"盘点任务推送失败!\"}";
						 //logger.error("[processRestResponse]-----盘点单为"+stn.getStockTaskingNumber()+"的任务插入失败");
					 }
				 }
				 res="{\"resultFlag\":\"true\",\"responseEntity\":\""+stockList+"\",\"failureReason\":\"盘点任务推送完成!\"}";
				 //res="{\"resultFlag\":\"true\",\"responseEntity\":"+stockList+",\"failureReason\":\"盘点任务推送完成!\"}";
			 }
			 
			 
			 else if(type.equals("LSP_PUSHAUDITNOTICE_MOBILE")){ //如果接收到的是资产更新任务，则插入资产更新，由于审批人有可能是多个，所以需将审批人从集中
				 //取出并一一推送给审批人
				//PushAssetClearScrapeEntity pacse1=JSON.parseObject(obj.getJSONArray("requestEntity").getString(0),PushAssetClearScrapeEntity.class);
				PushAssetClearScrapeEntity pacse=JsonUtil.jsonToEntity(JsonUtil.jsonStrToArray(strJson, "requestEntity"), PushAssetClearScrapeEntity.class);
				logger.info("======资产更新pc端传过来json字符串是=>"+strJson);
				//保存更新任务前先根据单据编号删除上一节点的信息
				//assetStockDao.delAssetsRenew(pacse.getFnumber());
				List<Auditor> auditList=pacse.getAuditorList();
				StringBuffer auditCode=new StringBuffer();
				for (Auditor auditor:auditList) {
					auditCode.append(auditor.getEmpCode()+"|");
				}
				String code=auditCode.substring(0, auditCode.length()-1);
				pacse.setAuditor(code);
				if(receiveStockTaskDao.queryIsRepeat(pacse)==0){//没有重复
					flag=receiveStockTaskDao.saveAssetsClear(pacse);//保存资产更新任务
				}else{//有重复
					flag=receiveStockTaskDao.updateAssetsRenew(pacse);//修改资产更新任务					
				}	
				if (flag>0) {//保存成功后推送
					String []str=code.split("\\|");
					for (String empCode:str) {//根据审批人集合推送					
						nce = new NewsCenterEntity("2", 3, 0, 1, "固定资产","你有一个资产更新工作流");
						tpushNewsService.pushUserNews(empCode, "你有一个资产更新工作流",  "资产更新工作流",nce);
					}
					res="{\"resultFlag\":\"true\",\"responseEntity\":\"\",\"failureReason\":\"\"}";
					logger.info("[processRestResponse]-----单据编号为"+pacse.getFnumber()+"的资产更新任务新增或修改成功");
				}
				else{
					 res="{\"resultFlag\":\"false\",\"responseEntity\":\"\",\"failureReason\":\"资产更新推送失败!\"}";
					 logger.error("[processRestResponse]-----单据编号为"+pacse.getFnumber()+"的任务新增或修改失败");
				}
			 }
			 else if(type.equals("LSP_PUSHSUBMITNOTICE_MOBILE")){//如果是PC端提交资产盘点
				 StockTaskingNotice stn=JsonUtil.jsonToEntity(JsonUtil.jsonStrToArray(strJson, "requestEntity"), StockTaskingNotice.class);
				 assetStockDao.updateStockNumber(stn.getStockTaskingNumber());
					// 结束时间
				 Date endDt = new Date();
				 monitorCountInfoService.saveMonitorCountInfo(stn.getStockTaskingName(),startDt,endDt,Constants.PC_SUM_STOCK);
				 logger.info("[processRestResponse]-----盘点单号为"+stn.getStockTaskingNumber()+"的盘点任务PC端提交成功");
			 }
			 else if(type.equals("LMS_CANCELNOTICE_MOBILE")){//清理垃圾数据
				 String taskNumber=JsonUtil.jsonGetValueBykey(strJson, "requestEntity");
				 if (assetStockDao.delStockTask(taskNumber)>0) {
					 Date endDt = new Date();
					 monitorCountInfoService.saveMonitorCountInfo(taskNumber,startDt,endDt,Constants.PC_CANCEL_STOCK);
					 res="{\"resultFlag\":\"true\",\"responseEntity\":\"\",\"failureReason\":\"\"}";
					 logger.info("[processRestResponse]-----被取消的盘点单"+taskNumber+"删除成功!");
				}
				 else{
					 res="{\"resultFlag\":\"false\",\"responseEntity\":\"\",\"failureReason\":\"删除失败!\"}";
					 logger.info("[processRestResponse]-----被取消的盘点单"+taskNumber+"删除失败!");
				 }
			 }
			 else if(type.equals("LSP_CANCELASSETCLEARSCRAPE_MOBILE")){//删除被取消的更新任务
				 String fnumber=JsonUtil.jsonGetValueBykey(strJson, "requestEntity");
				 if (assetStockDao.delAssetsRenew(fnumber)>0) {
					 res="{\"resultFlag\":\"true\",\"responseEntity\":\"\",\"failureReason\":\"\"}";
					 logger.info("[processRestResponse]-----被取消的更新任务"+fnumber+"删除成功!");
				}
				 else{
					 res="{\"resultFlag\":\"false\",\"responseEntity\":\"\",\"failureReason\":\"删除失败!\"}";
					 logger.info("[processRestResponse]-----被取消的更新任务"+fnumber+"删除失败!");
				 }
			 }
			 else if(type.equals("LSP_PUSHBACKNOTICE_MOBILE")){//PC端回退的固定资产盘点任务
				 String stockTaskNumber=JsonUtil.jsonGetValueBykey(strJson, "requestEntity");
				 assetStockDao.updateStockTask(stockTaskNumber);
				 res="{\"resultFlag\":\"true\",\"responseEntity\":\"\",\"failureReason\":\"\"}";
				 Date endDt = new Date();
				 monitorCountInfoService.saveMonitorCountInfo(stockTaskNumber,startDt,endDt,Constants.PC_RETURN_STOCK);
				 logger.info("[processRestResponse]-----PC端退回盘点任务"+stockTaskNumber+"成功!");
			 }
		} catch (Exception e) {
			logger.error("[processRestResponse]-----操作失败",e);
			return Response.ok("{\"resultFlag\":\"false\",\"responseEntity\":\"\",\"failureReason\":\""+e.getMessage()+"\"}").header("ESB-ResultCode", 1).build();
		}
		return Response.ok(res).header("ESB-ResultCode", 1).build();
	}
	

	public static void main(String[] args) {
		
		
	}
}
