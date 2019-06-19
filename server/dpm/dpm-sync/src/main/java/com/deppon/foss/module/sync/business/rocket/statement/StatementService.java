package com.deppon.foss.module.sync.business.rocket.statement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class StatementService {
	public  StatementDao statementDao;
	
	public int updateStatementSummary(String workflowNum,String workflowStatus,String company,String offTime){
		return statementDao.updateStatementSummary(workflowNum,workflowStatus,company, offTime);
	}
	
	@SuppressWarnings("unchecked")
	public List<DidiStatementEntity> queryStatement(String company,String offTime) {
		return statementDao.queryStatement(company,offTime);
	}
	
	public int updateStatementSummaryByWF(String workflowNum,String workflowStatus,String company){
		return statementDao.updateStatementSummaryByWF(workflowNum,workflowStatus,company);
	}
	
	public int queryStatementSummaryByNum(String workflowNum){
		return statementDao.queryStatementSummaryByNum(workflowNum);
	}
	
	public int updateStatementSummaryByMessage(String workflowNum,String bizDataUUID,String workFlowState){
		return statementDao.updateStatementSummaryByMessage(workflowNum,bizDataUUID,workFlowState);
	}
	
	public boolean exportExcel(String fileName, String[] headers, List<Map> dataset)
    {
        boolean flag = false;
        Workbook workbook = null;
        if (fileName.endsWith("xlsx"))
        {
            workbook = new XSSFWorkbook();
        } else if (fileName.endsWith("xls"))
        {
            workbook = new HSSFWorkbook();
        } else
        {
            try
            {
                throw new Exception("invalid file name, should be xls or xlsx");
            } catch (Exception e)
            {
                System.out.println("必须是xls或者xlsx结尾的文件.");
                e.printStackTrace();
            }
            
        }

        Sheet sheet = workbook.createSheet();
          CellStyle style = workbook.createCellStyle();
        
        // 列名
        Row row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++)
        {
            Cell cell = row.createCell(i);
            sheet.setColumnWidth(i, 5000);
            style.setAlignment(CellStyle.ALIGN_CENTER);
            cell.setCellValue(headers[i]);
        }

        Iterator<Map> it = dataset.iterator();
        int index = 0;
        while (it.hasNext())
        {
            index++;
            row = sheet.createRow(index);
            
            Map map = it.next();
            Set<String> mapKey = (Set<String>)map.keySet();
            Iterator<String> iterator = mapKey.iterator();
            int num  = 0;
            while(iterator.hasNext()){
                Cell cell = row.createCell(num);
                num++;
                String key = iterator.next();
                Object obj = map.get(key);
                if (obj instanceof Date)
                {
                    SimpleDateFormat sdf = new SimpleDateFormat();
                    cell.setCellValue(sdf.format(obj));
                } else if (obj instanceof Integer)
                {
                    cell.setCellValue((Integer) obj);
                } else if (obj instanceof Double)
                {
                    cell.setCellValue((Double) obj);
                } else
                {
                    cell.setCellValue((String) obj);
                }
            }
        }
        FileOutputStream fos;
        try
        {
            fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();
            flag = true;
        } catch (FileNotFoundException e)
        {
        	 System.out.println("文件不存在");
            flag = false;
            e.printStackTrace();
        } catch (IOException e)
        {
        	 System.out.println("文件写入错误");
            flag = false;
            e.printStackTrace();
            
        }
        return flag;
    }

	public StatementDao getStatementDao() {
		return statementDao;
	}

	public void setStatementDao(StatementDao statementDao) {
		this.statementDao = statementDao;
	} 
}
