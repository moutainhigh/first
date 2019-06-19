package com.deppon.dpm.doc.server.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.transaction.annotation.Transactional;

import com.deppon.dpm.doc.server.dao.IFileDao;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.entity.StatementSummaryEntity;
import com.deppon.dpm.doc.server.service.IDidiOrderService;
import com.deppon.dpm.doc.server.service.IFileService;

public class FileService implements IFileService {

	public IFileDao FileDao;
	
	private static final Logger LOG = LoggerFactory.getLogger(FileService.class);
	/**
	 * 滴滴订单服务
	 */
	private IDidiOrderService didiOrderService;
	
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public String upload(String originalFilename, String contentType,
			long size, InputStream is , String getDate) throws IOException {
		try {
			long startTime = System.currentTimeMillis();
			getDate=getDate.replaceAll("-", "");
			LOG.error("XSSFWorkbook解析文件》》》》》》》》》》");
			ReferenceQueue<Object> gcQueue = new ReferenceQueue<Object>();
			XSSFWorkbook workbook = (XSSFWorkbook)(new WeakReference<Object>(new XSSFWorkbook(is), gcQueue).get());
			Sheet sheet = (Sheet)(new WeakReference<Object>(workbook.getSheetAt(0), gcQueue).get());
			workbook = null;
			//总行数  
	        int trLength = sheet.getLastRowNum();//获取标题对应列的长度
	        List<Map<String,String>> didiOrders = (List<Map<String,String>>)new WeakReference<Object>(new ArrayList<Map<String,String>>(), gcQueue).get();
	        for (int i = 0; i <= trLength; i++) {
	        	//得到Excel工作表的行  
	            Row irow = sheet.getRow(i);
	            int num = irow.getLastCellNum();
	            if(num!=3){
	            	return "请上传正确的文件";
	            }
	            if(irow.getCell(0)!=null && irow.getCell(1)!=null && irow.getCell(2)!=null){
	            	irow.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					irow.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
					irow.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
	            	if(StringUtils.isNotBlank(irow.getCell(0).getStringCellValue())){
	            		//解析Excel存入map
	                    Map<String,String> didiorder = new HashMap<String,String>();
	                	didiorder.put("didiBillNo", irow.getCell(0).getStringCellValue());//订单号
	                	didiorder.put("amount", irow.getCell(1).getStringCellValue());//金额
	                	didiorder.put("subCompany", irow.getCell(2).getStringCellValue().trim());//子公司
	                	didiorder.put("getDate", getDate);
	                	didiOrders.add(didiorder);
	            	}else{
	            		break;
	            	}
	            }else{
	        		break;
	        	}
	        }
	        //释放相关资源
	        sheet = null;
	        is.close();
	        LOG.error("解析文件数据完成》》》》》》》》》》真实行数:"+didiOrders.size());
	        //执行插入滴滴订单逻辑
	        LOG.error("<<<<<<<<<<<<<<<<<<<<开始插入滴滴订单数据"+getDate+">>>>>>>>>>>>>>>>>>>>>>>>>");
	        //提交未匹配的对账数据
        	int exeRows = 2000;
        	String sql2 = "INSERT INTO didi_statement(billno,company,didi_price,id,statement_month) "
					+ "VALUES (?,?,CONVERT(?,DECIMAL(5,2)),concat(?,LPAD(nextValue(?,'YW'),8,'0')),?);";
			jdbcTemplate.batchUpdate(sql2, didiOrders, exeRows,
					new ParameterizedPreparedStatementSetter<Map<String,String>>(){
				@Override
				public void setValues(PreparedStatement ps,Map<String,String> param) throws SQLException {
					ps.setString(1, param.get("didiBillNo"));
					ps.setString(2, param.get("subCompany"));
					ps.setString(3, param.get("amount"));
					ps.setString(4, param.get("getDate"));
					ps.setString(5, param.get("getDate"));
					ps.setString(6, param.get("getDate"));
				}
			});
	        didiOrders = null;
	        gcQueue = null;
	        long endTime = System.currentTimeMillis();
	        LOG.error("<<<<<<<<<<<<<<<<<<<<插入滴滴订单数据"+getDate+"完成消耗时间>>>>>>>>>>>>>>>>>>>>>>>>>"+(endTime-startTime)+"ms");
		} catch (Exception e) {
			LOG.error("<<<<<<<<<<<<<<<<<<<<插入滴滴订单数据"+getDate+">>>>>>>>>>>>>失败>>>>>>>>>>>>"+e.getMessage());
			e.printStackTrace();
			return "fail";
		}
        return "success";
	}

	/*
	 * 根据月份对账
	 * */
	@Override
	public int statementByTime(String offTime){
		Map<String,String> params = new HashMap<>();
		params.put("getDate", offTime.replace("-", ""));
		FileDao.statementInDpm(params);
		FileDao.statementNotInDpm(params);
		return 1;
	}
	
	//读取财务信息excel表格
	@SuppressWarnings("unchecked")
	@Override
	public String readFinancialFile(InputStream is,String getDate) {
		LOG.info("XSSFWorkbook解析文件》》》》》》》》》》");
		try {
			ReferenceQueue<Object> gcQueue = new ReferenceQueue<Object>();
			XSSFWorkbook workbook = (XSSFWorkbook)(new WeakReference<Object>(new XSSFWorkbook(is),gcQueue).get());
			Sheet sheet = (Sheet)(new WeakReference<Object>(workbook.getSheetAt(0),gcQueue).get());
			
			List<Map<String,String>> list = (ArrayList<Map<String,String>>)(new WeakReference<Object>(new ArrayList<Map<String,String>>(),gcQueue).get());
			for(int rowNum=0;rowNum<sheet.getLastRowNum()+1;rowNum++){
				Row row = sheet.getRow(rowNum);
				for(int i=0;i<row.getLastCellNum();i++){
					row.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
				}
				Map<String,String> map = new HashMap<String,String>();
				map.put("applyEmpName", row.getCell(0).getStringCellValue());
				map.put("applyEmpCode",  row.getCell(1).getStringCellValue());
				map.put("mcName",  row.getCell(2).getStringCellValue());
				map.put("invoiceTitle",  row.getCell(3).getStringCellValue());
				map.put("financialDept",  row.getCell(4).getStringCellValue());
				map.put("accountName",  row.getCell(5).getStringCellValue());
				map.put("contactInfo",  row.getCell(6).getStringCellValue());
				map.put("costExplain",  row.getCell(7).getStringCellValue());
				map.put("accountNature",  row.getCell(8).getStringCellValue());
				map.put("bankName",  row.getCell(9).getStringCellValue());
				map.put("bankProvinceName",  row.getCell(10).getStringCellValue());
				map.put("bankCityName",  row.getCell(11).getStringCellValue());
				map.put("subbankName",  row.getCell(12).getStringCellValue());
				map.put("account",  row.getCell(13).getStringCellValue());
				//map.put("scName",  row.getCell(14).getStringCellValue());
				//map.put("costCenterName",  row.getCell(15).getStringCellValue());
				//map.put("actualAmount",  row.getCell(16).getStringCellValue());
				list.add(map);
			}
			sheet = null;
			workbook = null;
			
			int Num=0;
			for(int i=0;i<list.size();i++){
				//发票抬头和财务子公司内容是一样的，根据发票抬头来使数据关联
				String company =list.get(i).get("invoiceTitle");
				company = new String(company.getBytes("UTF-8"), "UTF-8");
				int temp = FileDao.addFinancialExcel(list.get(i),company,getDate);
				Num+=temp;
			}
			list = null;
			gcQueue = null;
			if(Num==0){
				return "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("读取财务信息》》》》》》》》》》"+e.getMessage());
		}finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
					LOG.error("读取财务信息》》》》》》》》》》"+e.getMessage());
				}
			}
		}
		return "success";
		
	}
	/**
	 * @return the fileDao
	 */
	public IFileDao getFileDao() {
		return FileDao;
	}
	/**
	 * @param fileDao the fileDao to set
	 */
	public void setFileDao(IFileDao fileDao) {
		FileDao = fileDao;
	}

	/**
	 * @return the didiOrderService
	 */
	public IDidiOrderService getDidiOrderService() {
		return didiOrderService;
	}

	/**
	 * @param didiOrderService the didiOrderService to set
	 */
	public void setDidiOrderService(IDidiOrderService didiOrderService) {
		this.didiOrderService = didiOrderService;
	}

	@Override
	public List<DidiOrderEntity> queryByPage(String getDate, int pageNum) {
		return FileDao.queryByPage(getDate, pageNum);
	}

	@Override
	public List<DidiOrderEntity> queryAllByDate(String getDate) {
		return FileDao.queryAllByDate(getDate);
	}
	
	//查询当月订单总数
	@Override
	public int getCountOfMonth(String getDate){
		return FileDao.getCountOfMonth(getDate);
	}
	
	@Override
	public int getStatementCount(String getDate){
		return FileDao.getStatementCount(getDate);
	}

	@Override
	public int updateOrder(String id, String amount) {
		return FileDao.updateOrder(id, amount);
	}

	@Override
	public int deleteOrder(String id) {
		return FileDao.deleteOrder(id);
	}
		
	//查询对账单
	public List queryStatement (int pageNum,String getDate){
		return FileDao.queryStatement(pageNum,getDate);
		
	}
	//根据ID删除对账单明细
	public int deleteStatement(String id){
		return FileDao.deleteStatement(id);
		
	}
	//修改对账单明细
	public int updateStatement(String id,String depponPrice,String lowerPrice){
		return FileDao.updateStatement(id, depponPrice, lowerPrice);
		
	}
	//模糊查询对账单
	@Override
	public List fuzzySearchStatement(String company, String workFlowStatus,String offTime) {
		return FileDao.fuzzySearchStatement(company, workFlowStatus,offTime);
	}
	//根据公司查询对账单明细
	@Override
	public List queryAllStatementByCompany(String company,String offTime) {
		return FileDao.queryAllStatementByCompany(company,offTime);
	}
	//把对账单明细汇总
	@Override
	public int addStatementSummary(String company,String money,String offTime) {
		return FileDao.addStatementSummary(company,money,offTime);
	}
	@Override
	public List queryStatementSummary(String getDate) {
		return FileDao.queryStatementSummary(getDate);
	}
	@Override
	public int searchStatementSummary(String company,String offTime) {
		return FileDao.SearchStatementSummary(company,offTime);
	}
	@Override
	public List queryAllStatement() {
		return FileDao.queryAllStatement();
	}
	@Override
	public List fuzzySearchStatementFenYe(String company, String workFlowStatus,
			String offTime, int pageNum) {
		return FileDao.fuzzySearchStatementFenYe(company, workFlowStatus, offTime, pageNum);
	}
	@Override
	public int deleteStatementByTime(String offTime) {
		return FileDao.deleteStatementByTime(offTime);
	}
	@Override
	public int deleteStatementSummaryByTime(String offTime) {
		return FileDao.deleteStatementSummaryByTime(offTime);
	}
	@Override
	public int updateStatementSummary(String company, String offTime,String bizDataUUID) {
		return FileDao.updateStatementSummary(company, offTime,bizDataUUID);
	}
	@Override
	public int searchStatementSummary2(String company, String offTime) {
		return FileDao.SearchStatementSummary2(company,offTime);
	}
	@Override
	public List queryStatus(String getDate) {
		return FileDao.queryStatus(getDate);
	}
	@Override
	public String queryWorkFlowStatus(String company, String offTime) {
		return FileDao.queryWorkFlowStatus(company, offTime);
	}

	/**
	 * 查询对账汇总明细
	 * */
	public List<StatementSummaryEntity> queryStatementSummaryDetails(String offTime){
		return FileDao.queryStatementSummaryDetails(offTime);
	}
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
