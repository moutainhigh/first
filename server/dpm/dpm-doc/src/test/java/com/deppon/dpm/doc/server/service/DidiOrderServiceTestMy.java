package com.deppon.dpm.doc.server.service;

import java.io.FileInputStream;

import com.deppon.dpm.doc.server.dao.impl.FileDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;

import com.deppon.dpm.doc.server.dao.IFileDao;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.job.QueryOrderForkJoinTask;
import com.deppon.dpm.doc.server.job.StatementInsertForkJoinTask;
import com.deppon.dpm.doc.server.service.impl.DidiOrderService;

public class DidiOrderServiceTestMy{

	/**
	 * spring 应用容器
	 */
	protected static ApplicationContext appContext = null;

	/**
	 * service
	 */
	private static DidiOrderService didiOrderService;
	
	private static IFileDao FileDao;
	
	private static JdbcTemplate jdbcTemplate;
	
	static{
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/springMy.xml");
		didiOrderService = (DidiOrderService) appContext.getBean("didiOrderService");
		FileDao = (FileDao) appContext.getBean("FileDao");
		setJdbcTemplate((JdbcTemplate) appContext.getBean("jdbcTemplate"));
	}
	
	public static void main(String[] args) throws Exception {
		statementTest();
		//statementTest4JdbcTemplate();
	}
	
	//jdbcTemplate批量提交
	public static void statementTest4JdbcTemplate() throws Exception{
		long startTime = System.currentTimeMillis();
		String getDate = "2018-10";
		FileInputStream fis = new FileInputStream("D:/input.xlsx");
		System.out.println("XSSFWorkbook解析文件》》》》》》》》》》");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
		
		//总行数  
        int trLength = sheet.getLastRowNum();//获取标题对应列的长度
        List<Map<String,String>> didiOrders = new ArrayList<Map<String,String>>();
        for (int i = 0; i <= trLength; i++) {
        	//得到Excel工作表的行  
            Row irow = sheet.getRow(i);
            int num = irow.getLastCellNum();
            if(num!=3){
            	//格式不对
            }
            if(irow.getCell(0)!=null && irow.getCell(1)!=null && irow.getCell(2)!=null){
            	irow.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
				irow.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
				irow.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
            	if(StringUtils.isNotBlank(irow.getCell(0).getStringCellValue())){
            		//解析Excel存入map
            		//订单号
            		String orderNum = irow.getCell(0).getStringCellValue();
            		//金额
            		String amount = irow.getCell(1).getStringCellValue();
            		//子公司
                	String subCompany = irow.getCell(2).getStringCellValue().trim();
                	
                    Map<String,String> didiorder = new HashMap<String,String>();
                	didiorder.put("didiBillNo", orderNum);
                	didiorder.put("amount", amount);
                	didiorder.put("subCompany", subCompany);
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
        workbook = null;
        fis.close();
        fis.close();
        System.out.println("解析文件数据完成》》》》》》》》》》真实行数:"+didiOrders.size()); 
        
        System.out.println("查询数据库"+getDate+"打车记录<<<<<<<<<<开始>>>>>>>>>>");
        //List<DidiOrderEntity> depponOrderList = didiOrderService.dateOrder(getDate);
        
        List<DidiOrderEntity> depponOrderList = new ArrayList<DidiOrderEntity>();
        long start = System.currentTimeMillis();
        
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        QueryOrderForkJoinTask task = new QueryOrderForkJoinTask(didiOrderService, didiOrders);
        ForkJoinTask<List<DidiOrderEntity>> result = forkJoinPool.submit(task);
        depponOrderList = result.get();
        forkJoinPool.shutdown();
        
        long end = System.currentTimeMillis();
        System.out.println("查询德邦订单消耗时间:"+(end-start));
        System.out.println(depponOrderList.size());
        
        //根据数据库查询月数据存入map key:订单号 value：订单
        Map<String,DidiOrderEntity> depponOrderMap = new HashMap<String,DidiOrderEntity>();
        if(depponOrderList != null){
        	Iterator<DidiOrderEntity> depponIterator = depponOrderList.iterator();
            while(depponIterator.hasNext()){
            	DidiOrderEntity order = depponIterator.next();
            	depponOrderMap.put(order.getBillno(), order);
            	depponIterator.remove();
            }
        }
        depponOrderList = null;
        System.out.println("查询数据库"+getDate+"打车记录<<<<<<<<<<结束>>>>>>>>>>");
        
        //比较map中不同的order数据，新增进新的对比order表中
        getDate=getDate.replaceAll("-", "");
        System.out.println("<<<<<<<<<<<<<<<<<<<<"+"本次对账开始"+getDate+">>>>>>>>>>>>>>>>>>>>>>");
        List<Map<String,String>> exeList = new ArrayList<Map<String,String>>();//包含在Excel表中的订单
		List<Map<String,String>> exeList2 = new ArrayList<Map<String,String>>();//未包含在Excel表中的订单
        try {
        	doStatement(didiOrders,depponOrderMap,getDate,exeList,exeList2);//对账
        	didiOrders = null;
        	depponOrderMap = null;
		} catch (Exception e) {
			System.out.println("<<<<<<<<<<<<<<<<<<<<"+"本次对账完成"+getDate+">>>>>>>>>>失败>>>>>>>>>>>>"+e.getMessage());
		}
        System.out.println("<<<<<<<<<<<<<<<<<<<<"+"本次对账完成"+getDate+">>>>>>>>>>>成功>>>>>>>>>>>");
        
        System.out.println("<<<<<<<<<<<<<<<<<<<<对账数据开始提交"+getDate+">>>>>>>>>>>>>>>>>>>>>>>>>");
        try {
        	//提交未匹配的对账数据
        	int exeRows = 1000;
        	String sql2 = "INSERT INTO didi_statement(billno,company,difference,id,"
        			+ "same_or_difference,didi_price,lower_price,deppon_price,statement_month) "
					+ "VALUES (?,?,?,concat(?,LPAD(nextValue(?,'YW'),8,'0'))"
					+ ",?,?,'0.00','0.00',?)";
			jdbcTemplate.batchUpdate(sql2, exeList2, exeRows,
					new ParameterizedPreparedStatementSetter<Map<String,String>>(){
				@Override
				public void setValues(PreparedStatement ps,Map<String,String> param) throws SQLException {
					ps.setString(1, param.get("billno"));
					ps.setString(2, param.get("subCompany"));
					ps.setString(3, param.get("didi_price"));
					ps.setString(4, param.get("getDate"));
					ps.setString(5, param.get("getDate"));
					ps.setString(6, param.get("sameordifference"));
					ps.setString(7, param.get("didi_price"));
					ps.setString(8, param.get("getDate"));
				}
			});
        	exeList2 = null;
        	String sql = "INSERT INTO didi_statement(billno,company,difference,id,"
        			+ "same_or_difference,didi_price,lower_price,offtime,"
					+"from_name,to_name,deppon_price,costCenterName,"
					+ "bizOccurDate,statement_month) "
					+ "VALUES (?,?,?,concat(?,LPAD(nextValue(?,'YW'),8,'0')),?,?,?,?,?,?,?,?,?,?)";
    		jdbcTemplate.batchUpdate(sql, exeList, exeRows,
    				new ParameterizedPreparedStatementSetter<Map<String,String>>(){
				@Override
				public void setValues(PreparedStatement ps,Map<String,String> param) throws SQLException {
					ps.setString(1, param.get("billno"));
					ps.setString(2, param.get("subCompany"));
					ps.setString(3, param.get("didi_price"));
					ps.setString(4, param.get("getDate"));
					ps.setString(5, param.get("getDate"));
					ps.setString(6, param.get("sameordifference"));
					ps.setString(7, param.get("didi_price"));
					ps.setString(8, param.get("lower_price"));
					ps.setString(9, param.get("offtime"));
					ps.setString(10, param.get("from_name"));
					ps.setString(11, param.get("to_name"));
					ps.setString(12, param.get("total_price"));
					ps.setString(13, param.get("financedept"));
					ps.setString(14, param.get("taxidate"));
					ps.setString(15, param.get("getDate"));
				}
    		});
        	exeList = null;
        	System.out.println("<<<<<<<<<<<<<<<<<<<<对账数据结束提交"+getDate+">>>>>>>>>>>>>>>>>>>>>>>>>");
		} catch (Exception e) {
			System.out.println("<<<<<<<<<<<<<<<<<<<<"+"对账数据提交"+getDate+">>>>>>>>>>失败>>>>>>>>>>>>"+e.getMessage());
		}
        System.out.println("<<<<<<<<<<<<<<<<<<<<对账功能"+getDate+"完成>>>>>>>>>>>>>>>>>>>>>>>>>");
        long endTime = System.currentTimeMillis();
        System.out.println("消耗总时间:"+(endTime-startTime)/1000+"s");
	}
	
	//mybatis批量提交
	public static void statementTest() throws Exception{
		long startTime = System.currentTimeMillis();
		String getDate = "201810";
		FileInputStream fis = new FileInputStream("D:/input.xlsx");
		System.out.println("XSSFWorkbook解析文件》》》》》》》》》》");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
		
		//总行数  
        int trLength = sheet.getLastRowNum();//获取标题对应列的长度
        List<Map<String,String>> didiOrders = new ArrayList<Map<String,String>>();
        for (int i = 0; i <= trLength; i++) {
        	//得到Excel工作表的行  
            Row irow = sheet.getRow(i);
            int num = irow.getLastCellNum();
            if(num!=3){
            	//格式不对
            }
            if(irow.getCell(0)!=null && irow.getCell(1)!=null && irow.getCell(2)!=null){
            	irow.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
				irow.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
				irow.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
            	if(StringUtils.isNotBlank(irow.getCell(0).getStringCellValue())){
            		//解析Excel存入map
            		//订单号
            		String orderNum = irow.getCell(0).getStringCellValue();
            		//金额
            		String amount = irow.getCell(1).getStringCellValue();
            		//子公司
                	String subCompany = irow.getCell(2).getStringCellValue().trim();
                	
                    Map<String,String> didiorder = new HashMap<String,String>();
                	didiorder.put("didiBillNo", orderNum);
                	didiorder.put("amount", amount);
                	didiorder.put("subCompany", subCompany);
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
        workbook = null;
        fis.close();
        System.out.println("解析文件数据完成》》》》》》》》》》真实行数:"+didiOrders.size()); 
    	List<Map<String,String>> submitList = new ArrayList<Map<String,String>>();//用于提交的列表
    	//提交未匹配的对账数据
    	int exeRows = 5000;
    	Iterator<Map<String,String>> exe2It = didiOrders.iterator();
    	do{
    		if((submitList.size()%exeRows==0 || !exe2It.hasNext()) && submitList.size() > 0){
    			System.out.println("【未匹配的】对账数据提交"+getDate+"条数:"+submitList.size()+">>>>>");
    			FileDao.addStatement4Didi(submitList);
        		submitList = new ArrayList<Map<String,String>>();
    		}else{
    			submitList.add(exe2It.next());
    			exe2It.remove();
    		}
    	}while(exe2It.hasNext());
    	System.out.println("【未匹配的】对账数据提交"+getDate+"条数:"+submitList.size()+">>>>>");
    	FileDao.addStatement4Didi(submitList);
        didiOrders = null;
//        
//        System.out.println("查询数据库"+getDate+"打车记录<<<<<<<<<<开始>>>>>>>>>>");
//        //List<DidiOrderEntity> depponOrderList = didiOrderService.dateOrder(getDate);
//        
//        List<DidiOrderEntity> depponOrderList = new ArrayList<DidiOrderEntity>();
//        long start = System.currentTimeMillis();
//        
//        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        QueryOrderForkJoinTask task = new QueryOrderForkJoinTask(didiOrderService, didiOrders);
//        ForkJoinTask<List<DidiOrderEntity>> result = forkJoinPool.submit(task);
//        depponOrderList = result.get();
//        forkJoinPool.shutdown();
//        
//        long end = System.currentTimeMillis();
//        System.out.println(end-start);
//        System.out.println(depponOrderList.size());
//        
//        //根据数据库查询月数据存入map key:订单号 value：订单
//        Map<String,DidiOrderEntity> depponOrderMap = new HashMap<String,DidiOrderEntity>();
//        if(depponOrderList != null){
//        	Iterator<DidiOrderEntity> depponIterator = depponOrderList.iterator();
//            while(depponIterator.hasNext()){
//            	DidiOrderEntity order = depponIterator.next();
//            	depponOrderMap.put(order.getBillno(), order);
//            	depponIterator.remove();
//            }
//        }
//        depponOrderList = null;
//        System.out.println("查询数据库"+getDate+"打车记录<<<<<<<<<<结束>>>>>>>>>>");
//        
//        //比较map中不同的order数据，新增进新的对比order表中
//        getDate=getDate.replaceAll("-", "");
//        System.out.println("<<<<<<<<<<<<<<<<<<<<"+"本次对账开始"+getDate+">>>>>>>>>>>>>>>>>>>>>>");
//        List<Map<String,String>> exeList = new ArrayList<Map<String,String>>();//包含在Excel表中的订单
//		List<Map<String,String>> exeList2 = new ArrayList<Map<String,String>>();//未包含在Excel表中的订单
//        try {
//        	doStatement(didiOrders,depponOrderMap,getDate,exeList,exeList2);//对账
//        	didiOrders = null;
//        	depponOrderMap = null;
//		} catch (Exception e) {
//			System.out.println("<<<<<<<<<<<<<<<<<<<<"+"本次对账完成"+getDate+">>>>>>>>>>失败>>>>>>>>>>>>"+e.getMessage());
//		}
//        System.out.println("<<<<<<<<<<<<<<<<<<<<"+"本次对账完成"+getDate+">>>>>>>>>>>成功>>>>>>>>>>>");
//        
//        System.out.println("<<<<<<<<<<<<<<<<<<<<对账数据开始提交"+getDate+">>>>>>>>>>>>>>>>>>>>>>>>>");
//        try {
//        	List<Map<String,String>> submitList = new ArrayList<Map<String,String>>();//用于提交的列表
//        	//提交未匹配的对账数据
//        	int exeRows = 5000;
//        	Iterator<Map<String,String>> exe2It = exeList2.iterator();
//        	do{
//        		if((submitList.size()%exeRows==0 || !exe2It.hasNext()) && submitList.size() > 0){
//        			System.out.println("【未匹配的】对账数据提交"+getDate+"条数:"+submitList.size()+">>>>>");
//                	ForkJoinPool forkJoinPoolt = new ForkJoinPool();
//                	StatementInsertForkJoinTask taskt = new StatementInsertForkJoinTask(FileDao, submitList,false);
//                    ForkJoinTask<Integer> resultt = forkJoinPoolt.submit(taskt);
//                    int resulte2 = resultt.get();
//                    forkJoinPoolt.shutdown();
//            		if(resulte2==0){
//            			//入对账表失败
//            		}
//            		submitList = new ArrayList<Map<String,String>>();
//        		}else{
//        			submitList.add(exe2It.next());
//        			exe2It.remove();
//        		}
//        	}while(exe2It.hasNext());
//        	System.out.println("【未匹配的】对账数据提交"+getDate+"条数:"+submitList.size()+">>>>>");
//        	ForkJoinPool forkJoinPoolt = new ForkJoinPool();
//        	StatementInsertForkJoinTask taskt = new StatementInsertForkJoinTask(FileDao, submitList,false);
//            ForkJoinTask<Integer> resultt = forkJoinPoolt.submit(taskt);
//            int resulte2 = resultt.get();
//            forkJoinPoolt.shutdown();
//        	exeList2 = null;
//        	//提交匹配的对账数据
//        	submitList = new ArrayList<Map<String,String>>();//用于提交的列表
//        	Iterator<Map<String,String>> exeIt = exeList.iterator();
//        	do{
//        		if((submitList.size()%exeRows==0 || !exeIt.hasNext()) && submitList.size() > 0){
//        			System.out.println("【匹配的】对账数据提交"+getDate+"条数:"+submitList.size()+">>>>>");
//                	ForkJoinPool forkJoinPools = new ForkJoinPool();
//                	StatementInsertForkJoinTask tasks = new StatementInsertForkJoinTask(FileDao, submitList,true);
//                    ForkJoinTask<Integer> results = forkJoinPools.submit(tasks);
//                    int results2 = results.get();
//                    forkJoinPools.shutdown();
//            		if(results2==0){
//            			//入对账表失败
//            		}
//            		submitList = new ArrayList<Map<String,String>>();
//        		}else{
//        			submitList.add(exeIt.next());
//        			exeIt.remove();
//        		}
//        	}while(exeIt.hasNext());
//        	System.out.println("【匹配的】对账数据提交"+getDate+"条数:"+submitList.size()+">>>>>");
//        	ForkJoinPool forkJoinPools = new ForkJoinPool();
//        	StatementInsertForkJoinTask tasks = new StatementInsertForkJoinTask(FileDao, submitList,true);
//            ForkJoinTask<Integer> results = forkJoinPools.submit(tasks);
//            int results2 = results.get();
//            forkJoinPools.shutdown();
//        	exeList = null;
//        	System.out.println("<<<<<<<<<<<<<<<<<<<<对账数据结束提交"+getDate+">>>>>>>>>>>>>>>>>>>>>>>>>");
//		} catch (Exception e) {
//			System.out.println("<<<<<<<<<<<<<<<<<<<<"+"对账数据提交"+getDate+">>>>>>>>>>失败>>>>>>>>>>>>"+e.getMessage());
//		}
//        System.out.println("<<<<<<<<<<<<<<<<<<<<对账功能"+getDate+"完成>>>>>>>>>>>>>>>>>>>>>>>>>");
//        long endTime = System.currentTimeMillis();
//        System.out.println("消耗总时间:"+(endTime-startTime)/1000+"s");
	}
	
	/**
	 * 处理对账逻辑
	 * @param didiOrders
	 * @param depponOrderMap
	 * @param getDate
	 * @param index
	 * @return String
	 * */
	private static void doStatement(List<Map<String,String>> didiOrders,Map<String,DidiOrderEntity> depponOrderMap,
			String getDate,List<Map<String,String>> exeList,List<Map<String,String>> exeList2){
		//数字格式化器,保留2位小数
		DecimalFormat df = new DecimalFormat("#.##");
		Iterator<Map<String,String>> didiIterator = didiOrders.iterator();
		while(didiIterator.hasNext()){
			Map<String,String> didiOrder = didiIterator.next();
			//下面执行对账逻辑
			String didiBillNo = didiOrder.get("didiBillNo");//获取滴滴订单号
			Float price = Float.valueOf(didiOrder.get("amount"));
			String subCompany = didiOrder.get("subCompany");
			
			Map<String,String> tempMap = new HashMap<String,String>();
    		tempMap.put("billno", didiBillNo);
    		tempMap.put("id", getDate+"YW"+didiBillNo);
        	tempMap.put("getDate", getDate);
        	tempMap.put("subCompany", subCompany);
        	//判断业务单中是否包含上传的订单号
        	if(depponOrderMap.keySet().contains(didiBillNo)){
        		//得到滴滴金额和德邦金额的差值
        		DidiOrderEntity depponOrder = depponOrderMap.get(didiBillNo);
        		Double result = Double.valueOf(df.format(price-depponOrder.getTotalPrice()));
        		Double total = Double.valueOf((double)price);
        		tempMap.put("difference", result.toString());
        		tempMap.put("didi_price", df.format(total));
        		tempMap.put("offtime", depponOrder.getOfftime());
        		tempMap.put("from_name", depponOrder.getFromName());
        		tempMap.put("to_name", depponOrder.getToName());
        		tempMap.put("financedept", depponOrder.getFinancedept());
        		tempMap.put("taxidate", depponOrder.getTaxidate());
        		tempMap.put("total_price", Float.toString(depponOrder.getTotalPrice()));
        		if(result>0||result<0){
        			tempMap.put("sameordifference", "1");
        			tempMap.put("lower_price",Float.toString(depponOrder.getTotalPrice()));
        		}else{
        			tempMap.put("sameordifference", "0");
        			tempMap.put("lower_price",price.toString());
        		}
        		exeList.add(tempMap);
        		depponOrderMap.remove(didiBillNo);
        	}else{
        		tempMap.put("sameordifference", "1");
        		tempMap.put("didi_price", df.format(price));
        		exeList2.add(tempMap);
        	}
        	didiIterator.remove();
		}
	}

	public static JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		DidiOrderServiceTestMy.jdbcTemplate = jdbcTemplate;
	}
}
