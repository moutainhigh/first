package com.deppon.dpm.login.server.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * excel表格导出工具类
 * 
 * @author 231586
 * 
 */
public class ExcelExportUtil {
	/**
	 * 封装参数
	 *//*
	public static List<Object> list = new ArrayList<Object>();

	*//**
	 * get
	 * @return
	 *//*
	public List<Object> getList() {
		return list;
	}*/
	
	/**
	 * @param columnName
	 *            列名
	 * @return list[0]:workbook,list[1]:sheet,list[2]:row
	 */
	public static List<Object> saveInformation(String sheetName, String... columnName) {
		List<Object> list = new ArrayList<Object>();
		// 1.创建一个webbook，对应一个excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 2.在webbook中创建一个sheet，对应Excel中的sheet
		HSSFSheet sheet = workbook.createSheet(sheetName);
		// 3.创建第一行
		HSSFRow row = sheet.createRow(0);
		// 4.创建单元格，并设置表头值，设置居中格式
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		// 设置文本格式
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 创建cell
		HSSFCell cell = row.createCell(0);
		// 循环
		for (int i = 0; i < columnName.length; i++) {
			// cell值
			cell.setCellValue(columnName[i]);
			// cell样式
			cell.setCellStyle(cellStyle);
			cell = row.createCell(i);
		}
		// 添加
		list.add(workbook);
		// 添加
		list.add(sheet);
		// 添加
		list.add(row);
		// 返回list
		return list;
	}
	
}
