package com.deppon.dpm.doc.server.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.entity.DidiStatementEntity;
import com.deppon.dpm.doc.server.entity.StatementSummaryEntity;
import com.deppon.dpm.doc.server.service.IFileService;
import com.deppon.dpm.doc.server.util.File2ExcelUtils;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.foss.module.sync.business.rocket.statement.StatementAccountProducer;
import com.esafenet.dll.FileDlpUtil;

public class FileAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LoggerFactory.getLogger(FileAction.class);

	/**
	 * 
	 */
	@Autowired
	public IFileService FileService;
	
	public File file;
	
	public File financialFile;
	
	public String getDate;
	//每页条数
	public int limit = 10;
	
	//起始页数
	private int pageNum;
	
	public String id;
	public String amount;
	
	public String depponPrice;
	public String lowerPrice;
	
	public String company;
	public String workFlowStatus;
	public String offTime;
	
	public String identifice;//0修改订单，1删除订单
	
	public StatementAccountProducer producer;
	
	@SuppressWarnings("unused")
	@CookieNotCheckedRequired
	public void uploadFile() throws IOException {
		LOG.info("解密开始>>>>>>>>>>>>>>>>>>");
		String newPath = FileDlpUtil.getDecryptFile(file.getPath());
		LOG.info("解密结束>>>>>>>>>>>>>>>>>>");
		Map<String,String> jonum = new HashMap<String,String>();
		File file1 = null;
		FileInputStream fis = null;
		try {
			file1 = new File(newPath);
			fis = new FileInputStream(file1);
			if(fis != null){
				LOG.info("读取文件开始》》》》》》》》》》》》》");
				String diffstr = FileService.upload(file1.getName(), file1.getName(), file1.getTotalSpace(),fis ,getDate);
				if(diffstr=="success"){
					jonum.put("msg", "success");
					jonum.put("errorCode", "0");
					jonum.put("uploadfile", "success");
					LOG.info("读取文件完成》》》》》》》》》》》》》"+diffstr);
				}else if(diffstr=="fail"){
					jonum.put("uploadfile", "fail");
					jonum.put("msg", "fail");
					jonum.put("errorCode", "1");
				}else{
					jonum.put("msg", "请上传正确的文件");
				}
			}else{
				jonum.put("msg", "fail");
				jonum.put("errorCode", "1");
			}
		} catch (Exception e) {
			jonum.put("msg", e.getMessage());
			jonum.put("errorCode", "1");
		}finally{
			if(fis != null){
				fis.close();
			}
		}
		writeToPage(jonum);
	}
	
	//上传财务信息excel文件
	@SuppressWarnings("unused")
	@CookieNotCheckedRequired
	public void uploadFinancialFile() throws IOException{
		LOG.info("解密开始>>>>>>>>>>>>>>>>>>");
		String newPath = FileDlpUtil.getDecryptFile(financialFile.getPath());
		LOG.info("解密结束>>>>>>>>>>>>>>>>>>");
		Map<String,String> jonum = new HashMap<String,String>();
		if(getDate == null){
			jonum.put("msg", "fail");
			jonum.put("errorCode", "1");
			writeToPage(jonum);
			return;
		}
		File financialFile1 = null;
		FileInputStream fis = null;
		try {
			financialFile1 = new File(newPath);
			fis = new FileInputStream(financialFile1);
			if(fis != null){
				LOG.info("读取文件开始》》》》》》》》》》》》》");
				String getDateStr = getDate.replace("-", "");
				String diffstr = FileService.readFinancialFile(fis,getDateStr);
				if(diffstr=="success"){
					jonum.put("msg", "success");
					jonum.put("errorCode", "0");
					jonum.put("uploadfile", "success");
					LOG.info("读取文件完成》》》》》》》》》》》》》"+diffstr);
				}else{
					jonum.put("uploadfile", "fail");
					jonum.put("msg", "fail");
					jonum.put("errorCode", "1");
				}
			}else{
				jonum.put("msg", "fail");
				jonum.put("errorCode", "1");
			}
		} catch (Exception e) {
			jonum.put("msg", "fail");
			jonum.put("errorCode", "1");
		}finally{
			if(fis != null){
				fis.close();
			}
		}
		writeToPage(jonum);
	}
	
	@CookieNotCheckedRequired
	public void queryFileMsg(){
		//List<DidiOrderEntity> queryList = FileService.queryAllByDate(getDate);
		int countOfMonth = FileService.getCountOfMonth(getDate);
		int beginNum = getRecordIndex();// 定位请求的首条数据库位置
		List<DidiOrderEntity> querydLimitList = FileService.queryByPage(getDate,beginNum);
		
		JSONObject jonum = new JSONObject();
		
		if(countOfMonth == 0){
			//失败400
			jonum.put("code", 400);
			jonum.put("msg", "null");
			jonum.put("reruestVOlist", 0);
		}else{
			//成功传200
			jonum.put("code", 200);
			jonum.put("msg", "success");
			jonum.put("errorCode", 0);
			jonum.put("totalnum", countOfMonth);//返回总页数
			
			jonum.put("List", querydLimitList);
		}
		writeToPage(jonum);
	}
	
	@SuppressWarnings("rawtypes")
	@CookieNotCheckedRequired
	public void queryStatement(){
		int beginNum = getRecordIndex();
		String getDateStr=getDate.replaceAll("-", "");
		List statementList = FileService.queryStatement(beginNum,getDateStr);
		int totalCount = FileService.getStatementCount(getDateStr);
		JSONObject jonum = new JSONObject();
		if(statementList == null){
			//失败400
			jonum.put("code", 400);
			jonum.put("msg", "null");
			jonum.put("reruestVOlist", 0);
		}else{
			//成功传200
			jonum.put("code", 200);
			jonum.put("msg", "success");
			jonum.put("errorCode", 0);
			jonum.put("totalnum", totalCount);//返回总页数	
			jonum.put("List", statementList);
		}
		writeToPage(jonum);
		
	}
	
	@SuppressWarnings("unchecked")
	@CookieNotCheckedRequired
	public void fuzzySearchStatement(){
		int beginNum = getRecordIndex();
		List<StatementSummaryEntity> AllList = FileService.fuzzySearchStatement(company, workFlowStatus,offTime);
		List<StatementSummaryEntity> list = FileService.fuzzySearchStatementFenYe(company, workFlowStatus, offTime, beginNum);
		JSONObject jonum = new JSONObject();
		if(list == null){
			//失败400
			jonum.put("code", 400);
			jonum.put("msg", "null");
			jonum.put("reruestVOlist", 0);
		}else{
			//成功传200
			jonum.put("code", 200);
			jonum.put("msg", "success");
			jonum.put("errorCode", 0);	
			jonum.put("totalnum", AllList.size());//返回总页数
			jonum.put("List", list);
		}
		writeToPage(jonum);
	}
	
	@SuppressWarnings("unchecked")
	@CookieNotCheckedRequired
	public void addStatementSummary(){
		JSONObject jonum = new JSONObject();
		List<StatementSummaryEntity> statementList = FileService.queryStatementSummary(getDate);
		if(statementList.size()!=0){
			for(int i=0;i<statementList.size();i++){
				StatementSummaryEntity tempStat = statementList.get(i);
				int temp = FileService.searchStatementSummary2(tempStat.getCompany(),tempStat.getOffTime());
				if(temp==0){
					int insert = FileService.addStatementSummary(tempStat.getCompany(),tempStat.getMoney(),tempStat.getOffTime());
					jonum.put("insert", insert);
				}else{
					String workflowStatus = FileService.queryWorkFlowStatus(tempStat.getCompany(), tempStat.getOffTime());
					//如果审批不同意，再次汇总这个月这个公司的工作流
					if("不同意".equals(workflowStatus)){
						int insert = FileService.addStatementSummary(tempStat.getCompany(),Integer.valueOf(tempStat.getMoney()).toString(),tempStat.getOffTime());
						jonum.put("insert", insert);
					}
				}
				jonum.put("code", 200);
				jonum.put("msg", "success");
				jonum.put("errorCode", 0);
				writeToPage(jonum);
			}
		}else{
			jonum.put("code", 400);
			jonum.put("msg", "没有数据请查看是否全部对账完成");
			writeToPage(jonum);
		}
	}
	
	/**
	 * 导出对账汇总后的数据成Excel
	 * */
	@CookieNotCheckedRequired
	public void exportStatementSummary() throws Exception{
		List<StatementSummaryEntity> list = FileService.queryStatementSummaryDetails(offTime);
		String filePrefix = "statementSummary";
		String fileSuffix = ".xlsx";
		String fileName = filePrefix + offTime + fileSuffix;
		HttpServletResponse response = ServletActionContext.getResponse();
		OutputStream os = null;
		SXSSFWorkbook wb = null;
		try {
			wb = File2ExcelUtils.fillData(list, fileName);
			response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("utf-8"),"iso8859-1"));
			response.setContentType("application/x-execl;charset=UTF-8");
			os = response.getOutputStream();
			wb.write(os);
			os.flush();
		} catch (Exception e) {
			LOG.error(offTime+"导出对账汇总后的数据成Excel报错:"+e.getMessage());
		}finally{
			if(os != null){
				os.close();
			}
			wb = null;
		}
		LOG.error(offTime+"导出对账汇总后的数据成Excel成功!");
	}
	
	@CookieNotCheckedRequired
	public void delChgMethord(){
		JSONObject jonum = new JSONObject();
		if("0".equals(identifice)){
			int update = FileService.updateOrder(id, amount);
			jonum.put("msg", "success");
			jonum.put("update", update);
		}
		else if("1".equals(identifice)){
			int delete = FileService.deleteOrder(id);
			jonum.put("msg", "success");
			jonum.put("delete", delete);
		}else{
			jonum.put("msg", "error");
		}
		writeToPage(jonum);
	}
	
	//更新对账单，包括修改和删除
	@CookieNotCheckedRequired
	public void updateStatement(){
		JSONObject jonum = new JSONObject();
		if("0".equals(identifice)){
			int update = FileService.updateStatement(id, depponPrice, lowerPrice);
			jonum.put("msg", "success");
			jonum.put("update", update);
			jonum.put("errorCode", 0);	
		}
		else if("1".equals(identifice)){
			int delete = FileService.deleteStatement(id);
			jonum.put("msg", "success");
			jonum.put("delete", delete);
			jonum.put("errorCode", 0);	
		}else{
			jonum.put("msg", "error");
		}
		writeToPage(jonum);
	}
	
	//根据公司查询对账单
	@SuppressWarnings("rawtypes")
	@CookieNotCheckedRequired
	public void queryStatementByCompany(){
		List list = FileService.queryAllStatementByCompany(company,offTime);
		JSONObject jonum = new JSONObject();
		if(list == null){
			//失败400
			jonum.put("code", 400);
			jonum.put("msg", "null");
			jonum.put("reruestVOlist", 0);
		}else{
			//成功传200
			jonum.put("code", 200);
			jonum.put("msg", "success");
			jonum.put("errorCode", 0);			
			jonum.put("List", list);
		}
		writeToPage(jonum);
	}
	
	//根据id包含的月份删除对账单明细
	@CookieNotCheckedRequired
	public void deleteStatementByTime(){
		JSONObject jonum = new JSONObject();
		int delete =FileService.deleteStatementByTime(offTime);
		jonum.put("msg", "success");
		jonum.put("delete", delete);
		jonum.put("errorCode", 0);	
		writeToPage(jonum);
	}
	
	//根据时间来删除对账后汇总的数据
	@CookieNotCheckedRequired
	public void deleteStatementSummaryByTime(){
		JSONObject jonum = new JSONObject();
		int delete =FileService.deleteStatementSummaryByTime(offTime);
		jonum.put("msg", "success");
		jonum.put("delete", delete);
		jonum.put("errorCode", 0);	
		writeToPage(jonum);
	}
	
	@CookieNotCheckedRequired
	public void statementByTime(){
		JSONObject jonum = new JSONObject();
		int count =FileService.statementByTime(offTime);
		jonum.put("msg", "success");
		jonum.put("statementCount", count);
		jonum.put("errorCode", 0);	
		writeToPage(jonum);
	}
	
	/**
	 * 当前页首条在数据库里的位置
	 * @return
	 */
	public int getRecordIndex() {
		return (pageNum - 1) * 10;
	}
	
	/**
	 * 获取总页数
	 */
	public int getTotalPage(List<DidiOrderEntity> list) {
		if (list == null) {
			return 0;
		}
		if (list.size() % limit == 0) {
			return list.size() / limit;
		}
		else {
			return list.size() / limit + 1;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@CookieNotCheckedRequired
	public void sendStatement(){
		JSONObject jonum = new JSONObject();
		//传给前端需要的数据
		JSONObject json = new JSONObject();
		List<DidiStatementEntity> list = FileService.queryAllStatementByCompany(company, offTime);
		if(list.size()!=0){
			Map<String,Object> sendResult = new HashMap<String,Object>();
			List<Map> sendList = new ArrayList<Map>();
			for(DidiStatementEntity statement : list){
				Map<String,String> sendMap = new TreeMap<String,String>();
				sendMap.put("applyEmpName", statement.getApplyEmpName());
				sendMap.put("applyEmpCode", statement.getApplyEmpCode());
				sendMap.put("mcName", statement.getMcName());
				sendMap.put("invoiceTitle", statement.getInvoiceTitle());
				sendMap.put("financialDept", statement.getFinancialDept());
				sendMap.put("accountName", statement.getAccountName());
				sendMap.put("contactInfo", statement.getContactInfo());
				sendMap.put("expenseIsOvertime", statement.getExpenseIsOvertime());
				sendMap.put("costExplain", statement.getCostExplain());
				sendMap.put("accountNature", statement.getAccountNature());
				sendMap.put("bankName", statement.getBankName());
				sendMap.put("bankProvinceName", statement.getBankProvinceName());
				sendMap.put("bankCityName", statement.getBankCityName());
				sendMap.put("subbankName", statement.getSubbankName());
				sendMap.put("account", statement.getAccount());
				sendMap.put("costCenterName", statement.getCostCenterName());
				sendMap.put("scName", statement.getScName());
				sendMap.put("scNo", statement.getScNo());
				sendMap.put("actualAmount", statement.getActualAmount());
				sendMap.put("bizOccurDate", statement.getBizOccurDate());
				sendMap.put("itemCostExplain", statement.getItemCostExplain());
				sendList.add(sendMap);
			}
			//把每个子公司每个月的第一条明细数据用MQ传到总账那边生成工作流，其余明细打包成Excel传过去
			Map<String,String> summary = sendList.get(0);
			List<StatementSummaryEntity> summaryList = FileService.queryStatementSummaryDetails(offTime);
			for(StatementSummaryEntity s: summaryList){
				if(StringUtils.isNoneBlank(company) && company.equalsIgnoreCase(s.getCompany())){
					summary.put("actualAmount", s.getMoney());
				}
			}
			sendResult.put("summary", summary);
			sendResult.put("detail", list);
			String uuid = UUID.randomUUID().toString();
			try{
				jonum.put("data", sendResult);
				jonum.put("code", 200);
				jonum.put("bizDataUUID", uuid);
				jonum.put("msg", "success");
				jonum.put("errorCode", 0);
				json.put("code", 200);
				json.put("msg", "success");
				json.put("errorCode", 0);
				String temp = jonum.toString();
				if(producer.sendMessage(temp,uuid)){
					FileService.updateStatementSummary(company, offTime,uuid);
				}
			}catch(Exception e){
				e.printStackTrace();
				LOG.error("推送对账消息到RocketMQ报错:"+e.getMessage());
			}
		}else{
			json.put("code", 400);
			json.put("msg", "failed");
		}
		writeToPage(json);
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@CookieNotCheckedRequired
	public void batchSendStatementSummary(){
		JSONObject jonum = new JSONObject();
		List<StatementSummaryEntity> summaryList = null;
		//传给前端需要的数据
		JSONObject json = new JSONObject();
		try {
			summaryList = FileService.fuzzySearchStatement(company, workFlowStatus,offTime);
			if(summaryList == null || summaryList.size() <= 0){
				LOG.error("没有可以推送的对账消息到总账RocketMQ");
				json.put("code", 400);
				json.put("msg", "没有可以推送的对账消息");
				writeToPage(json);
				return;
			}
			boolean isNeedSend = false;
			//遍历对账汇总列表
			for(StatementSummaryEntity s:summaryList){
				if("否".equalsIgnoreCase(s.getStatus())){
					isNeedSend = true;
					break;
				}
			}
			if(!isNeedSend){
				LOG.error("没有可以推送的对账消息到总账RocketMQ");
				json.put("code", 400);
				json.put("msg", "没有可以推送的对账消息");
				writeToPage(json);
				return;
			}
			//推送到总账RocketMQ
			for(StatementSummaryEntity s:summaryList){
				if(!"否".equals(s.getStatus())){
					continue;
				}
				List<DidiStatementEntity> list = FileService.queryAllStatementByCompany(s.getCompany(), offTime);
				if(list != null && list.size()!=0){
					Map<String,Object> sendResult = new HashMap<String,Object>();
					List<Map> sendList = new ArrayList<Map>();
					for(DidiStatementEntity statement : list){
						Map<String,String> sendMap = new TreeMap<String,String>();
						sendMap.put("applyEmpName", statement.getApplyEmpName());
						sendMap.put("applyEmpCode", statement.getApplyEmpCode());
						sendMap.put("mcName", statement.getMcName());
						sendMap.put("invoiceTitle", statement.getInvoiceTitle());
						sendMap.put("financialDept", statement.getFinancialDept());
						sendMap.put("accountName", statement.getAccountName());
						sendMap.put("contactInfo", statement.getContactInfo());
						sendMap.put("expenseIsOvertime", statement.getExpenseIsOvertime());
						sendMap.put("costExplain", statement.getCostExplain());
						sendMap.put("accountNature", statement.getAccountNature());
						sendMap.put("bankName", statement.getBankName());
						sendMap.put("bankProvinceName", statement.getBankProvinceName());
						sendMap.put("bankCityName", statement.getBankCityName());
						sendMap.put("subbankName", statement.getSubbankName());
						sendMap.put("account", statement.getAccount());
						sendMap.put("costCenterName", statement.getCostCenterName());
						sendMap.put("scName", statement.getScName());
						sendMap.put("scNo", statement.getScNo());
						sendMap.put("actualAmount", statement.getActualAmount());
						sendMap.put("bizOccurDate", statement.getBizOccurDate());
						sendMap.put("itemCostExplain", statement.getItemCostExplain());
						sendList.add(sendMap);
					}
					//把每个子公司每个月的第一条明细数据用MQ传到总账那边生成工作流，其余明细打包成Excel传过去
					Map<String,String> summary = sendList.get(0);
					summary.put("actualAmount", s.getMoney());
					sendResult.put("summary", summary);
					sendResult.put("detail", list);
					String uuid = UUID.randomUUID().toString();
					try{
						jonum.put("data", sendResult);
						jonum.put("code", 200);
						jonum.put("bizDataUUID", uuid);
						jonum.put("msg", "success");
						jonum.put("errorCode", 0);
						json.put("code", 200);
						json.put("msg", "起草工作流成功");
						json.put("errorCode", 0);
						String temp = jonum.toString();
						if(producer.sendMessage(temp,uuid)){
							FileService.updateStatementSummary(s.getCompany(),offTime,uuid);
						}
					}catch(Exception e){
						e.printStackTrace();
						LOG.error("推送对账消息到RocketMQ报错:"+e.getMessage());
						json.put("code", 400);
						json.put("msg", "推送对账汇总信息报错!");
						writeToPage(json);
						return;
					}
				}else{
					LOG.error("该财务子公司没有对账明细需要推送到总账:"+s.getCompany());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("批量推送对账消息到RocketMQ报错:"+e.getMessage());
			json.put("code", 400);
			json.put("msg", "failed");
		}
		LOG.error("批量推送对账消息到总账RocketMQ成功!");
		writeToPage(json);
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#addActionError(java.lang.String)
	 */
	@Override
	public void addActionError(String anErrorMessage) {
		System.out.println(anErrorMessage);
		LOG.info(anErrorMessage);
//		super.addActionError(anErrorMessage);
	}
	
	/**
	 * @return the fileService
	 */
	public IFileService getFileService() {
		return FileService;
	}

	/**
	 * @param fileService the fileService to set
	 */
	public void setFileService(IFileService fileService) {
		FileService = fileService;
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	public File getFinancialFile() {
		return financialFile;
	}
	public void setFinancialFile(File financialFile) {
		this.financialFile = financialFile;
	}
	/**
	 * @return the getDate
	 */
	public String getGetDate() {
		return getDate;
	}

	/**
	 * @param getDate the getDate to set
	 */
	public void setGetDate(String getDate) {
		this.getDate = getDate;
	}
	/**
	 * @return the pageNum
	 */
	public int getPageNum() {
		return pageNum;
	}
	/**
	 * @param pageNum the pageNum to set
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	/**
	 * @return the identifice
	 */
	public String getIdentifice() {
		return identifice;
	}
	/**
	 * @param identifice the identifice to set
	 */
	public void setIdentifice(String identifice) {
		this.identifice = identifice;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDepponPrice() {
		return depponPrice;
	}
	public void setDepponPrice(String depponPrice) {
		this.depponPrice = depponPrice;
	}
	public String getLowerPrice() {
		return lowerPrice;
	}
	public void setLowerPrice(String lowerPrice) {
		this.lowerPrice = lowerPrice;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getWorkFlowStatus() {
		return workFlowStatus;
	}
	public void setWorkFlowStatus(String workFlowStatus) {
		this.workFlowStatus = workFlowStatus;
	}
	public String getOffTime() {
		return offTime;
	}
	public void setOffTime(String offTime) {
		this.offTime = offTime;
	}
	public StatementAccountProducer getProducer() {
		return producer;
	}
	public void setProducer(StatementAccountProducer producer) {
		this.producer = producer;
	}

}
