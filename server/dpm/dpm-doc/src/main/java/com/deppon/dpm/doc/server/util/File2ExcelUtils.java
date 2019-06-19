package com.deppon.dpm.doc.server.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;

import com.deppon.dpm.doc.server.entity.StatementSummaryEntity;

public class File2ExcelUtils {

	public static void main(String[] args) {
		List<StatementSummaryEntity> list = new ArrayList<StatementSummaryEntity>();
		StatementSummaryEntity s = new StatementSummaryEntity();
		s.setCompany("上海德邦");
		s.setMoney("1233.00");
		s.setWorkFlowStatus("起草");
		s.setWorkFlowNum("FSD12446387980");
		s.setOffTime("201809");
        list.add(s);
        String exportPath = "D:/";
		try {
			contextLoads(exportPath,list,"DOC.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void contextLoads(String exportPath,List<StatementSummaryEntity> list,String fileName) throws IOException {
		
	   FileOutputStream fos = null;
	   SXSSFWorkbook sxssfWorkbook = null;
	   try {
	       /// -> excel到处逻辑
	       long startTime = System.currentTimeMillis();
	       // 获取SXSSFWorkbook实例
	       sxssfWorkbook = new SXSSFWorkbook();
	       Sheet sheet = sxssfWorkbook.createSheet(fileName);
	       // 冻结最左边的两列、冻结最上面的一行
	       // 即：滚动横向滚动条时，左边的第一、二列固定不动;滚动纵向滚动条时，上面的第一行固定不动。
	       sheet.createFreezePane(2, 1);
	       // 设置并获取到需要的样式
	       XSSFCellStyle xssfCellStyleHeader = getAndSetXSSFCellStyleHeader(sxssfWorkbook);
	       XSSFCellStyle xssfCellStyleOne = getAndSetXSSFCellStyleOne(sxssfWorkbook);
	       XSSFCellStyle xssfCellStyleTwo = getAndSetXSSFCellStyleTwo(sxssfWorkbook);
	       // 创建第一行,作为header表头
	       Row header = sheet.createRow(0);
	       // 循环创建header单元格(根据实际情况灵活创建即可)
	       for (int cellnum = 0; cellnum < 6; cellnum++) {
	           Cell cell = header.createCell(cellnum);
	           cell.setCellStyle(xssfCellStyleHeader);
	           // 判断单元格
	           if (cellnum == 0) {
	               cell.setCellValue("所属财务子公司");
	           } else if (cellnum == 1) {
	               cell.setCellValue("总金额");
	           } else if (cellnum == 2) {
	               cell.setCellValue("工作流状态");
	           } else if (cellnum == 3) {
	               cell.setCellValue("发送状态");
	           } else if (cellnum == 4) {
	               cell.setCellValue("工作流号");
	           } else {
	               cell.setCellValue("对账月");
	           }
	       }
	 
	       // 遍历创建行,导出数据
	       for (int rownum = 1; rownum <= list.size(); rownum++) {
	           Row row = sheet.createRow(rownum);
	           // 循环创建单元格
	           for (int cellnum = 0; cellnum < 6; cellnum++) {
	               Cell cell = row.createCell(cellnum);
	               // 根据行数,设置该行内的单元格样式
	               if (rownum % 2 == 1) { // 奇数
	                   cell.setCellStyle(xssfCellStyleOne);
	               } else { // 偶数
	                   cell.setCellStyle(xssfCellStyleTwo);
	               }
	               // 根据单元格所属,录入相应内容
	               // 将部分数字类型的字符串,转换为Long;以免导出excel后,单元格左上角有三
	               //    角形(这是excel检查到该单元格内的内容均为数字,但是单元格类型却不是
	               //    数字,给出的提示),转不转看自己需求灵活处理
	               if (cellnum == 0) {
	                   cell.setCellValue(list.get(rownum - 1).getCompany());
	               } else if (cellnum == 1) {
	                   cell.setCellValue(list.get(rownum - 1).getMoney());
	               } else if (cellnum == 2) {
	                   cell.setCellValue(list.get(rownum - 1).getWorkFlowStatus());
	               } else if (cellnum == 3) {
	                   cell.setCellValue(list.get(rownum - 1).getStatus());
	               } else if (cellnum == 4) {
	                   cell.setCellValue(list.get(rownum - 1).getWorkFlowNum());
	               } else {
	                   cell.setCellValue(list.get(rownum - 1).getOffTime());
	               }
	           }
	       }
	       // 在后面设置sheet
	       setSheet(sheet);
	       // 导出的excel,全文件名
	       File file = new File(exportPath+fileName);
	       fos = new FileOutputStream(file);
	       sxssfWorkbook.write(fos);
	       long endTime = System.currentTimeMillis();
	       System.out.println(endTime-startTime);
	   } catch (Exception e) {
	    	e.printStackTrace();
	   } finally {
	       if(sxssfWorkbook != null) {
			   // dispose of temporary files backing this workbook on disk -> 
			   //     处理SXSSFWorkbook导出excel时，产生的临时文件
			   //sxssfWorkbook.dispose();
	       }
	       if(fos != null) {
			   fos.close();
	       }
	   }
	}
	
	public static SXSSFWorkbook fillData(List<StatementSummaryEntity> list,String fileName) throws IOException {
		
	   SXSSFWorkbook sxssfWorkbook = null;
	   try {
	       // -> excel到处逻辑
	       // 获取SXSSFWorkbook实例
	       sxssfWorkbook = new SXSSFWorkbook();
	       Sheet sheet = sxssfWorkbook.createSheet(fileName);
	       // 冻结最左边的两列、冻结最上面的一行
	       // 即：滚动横向滚动条时，左边的第一、二列固定不动;滚动纵向滚动条时，上面的第一行固定不动。
	       sheet.createFreezePane(2, 1);
	       // 设置并获取到需要的样式
	       XSSFCellStyle xssfCellStyleHeader = getAndSetXSSFCellStyleHeader(sxssfWorkbook);
	       XSSFCellStyle xssfCellStyleOne = getAndSetXSSFCellStyleOne(sxssfWorkbook);
	       XSSFCellStyle xssfCellStyleTwo = getAndSetXSSFCellStyleTwo(sxssfWorkbook);
	       // 创建第一行,作为header表头
	       Row header = sheet.createRow(0);
	       // 循环创建header单元格(根据实际情况灵活创建即可)
	       for (int cellnum = 0; cellnum < 6; cellnum++) {
	           Cell cell = header.createCell(cellnum);
	           cell.setCellStyle(xssfCellStyleHeader);
	           // 判断单元格
	           if (cellnum == 0) {
	               cell.setCellValue("所属财务子公司");
	           } else if (cellnum == 1) {
	               cell.setCellValue("总金额");
	           } else if (cellnum == 2) {
	               cell.setCellValue("工作流状态");
	           } else if (cellnum == 3) {
	               cell.setCellValue("发送状态");
	           } else if (cellnum == 4) {
	               cell.setCellValue("工作流号");
	           } else {
	               cell.setCellValue("对账月");
	           }
	       }
	 
	       // 遍历创建行,导出数据
	       for (int rownum = 1; rownum <= list.size(); rownum++) {
	           Row row = sheet.createRow(rownum);
	           // 循环创建单元格
	           for (int cellnum = 0; cellnum < 6; cellnum++) {
	               Cell cell = row.createCell(cellnum);
	               // 根据行数,设置该行内的单元格样式
	               if (rownum % 2 == 1) { // 奇数
	                   cell.setCellStyle(xssfCellStyleOne);
	               } else { // 偶数
	                   cell.setCellStyle(xssfCellStyleTwo);
	               }
	               // 根据单元格所属,录入相应内容
	               // 将部分数字类型的字符串,转换为Long;以免导出excel后,单元格左上角有三
	               //    角形(这是excel检查到该单元格内的内容均为数字,但是单元格类型却不是
	               //    数字,给出的提示),转不转看自己需求灵活处理
	               if (cellnum == 0) {
	                   cell.setCellValue(list.get(rownum - 1).getCompany());
	               } else if (cellnum == 1) {
	                   cell.setCellValue(list.get(rownum - 1).getMoney());
	               } else if (cellnum == 2) {
	                   cell.setCellValue(list.get(rownum - 1).getWorkFlowStatus());
	               } else if (cellnum == 3) {
	                   cell.setCellValue(list.get(rownum - 1).getStatus());
	               } else if (cellnum == 4) {
	                   cell.setCellValue(list.get(rownum - 1).getWorkFlowNum());
	               } else {
	                   cell.setCellValue(list.get(rownum - 1).getOffTime());
	               }
	           }
	       }
	       // 在后面设置sheet
	       setSheet(sheet);
	   } catch (Exception e) {
	    	e.printStackTrace();
	   }
	   return sxssfWorkbook;
	}
		 
	/**
	 * 设置sheet
	 */
	private static void setSheet(Sheet sheet) {
	    // 设置各列宽度(单位为:字符宽度的1/256)
	    sheet.setColumnWidth(0, 32 * 256);
	    sheet.setColumnWidth(1, 32 * 256);
	    sheet.setColumnWidth(2, 20 * 256);
	    sheet.setColumnWidth(3, 20 * 256);
	    sheet.setColumnWidth(4, 20 * 256);
	    sheet.setColumnWidth(5, 20 * 256);
	    }
	 
	    /**
	 * 获取并设置header样式
	 */
	private static XSSFCellStyle getAndSetXSSFCellStyleHeader(SXSSFWorkbook sxssfWorkbook) {
	    XSSFCellStyle xssfCellStyle = (XSSFCellStyle) sxssfWorkbook.createCellStyle();
	    Font font = sxssfWorkbook.createFont();
	    // 字体大小
	    font.setFontHeightInPoints((short) 14);
	    // 字体粗细
	    font.setBoldweight((short) 20);
	    // 将字体应用到样式上面
	    xssfCellStyle.setFont(font);
	    // 是否自动换行
	    xssfCellStyle.setWrapText(false);
	    // 水平居中
	    xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
	    // 垂直居中
	        xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
	        return xssfCellStyle;
	    }
	 
	    /**
	 * 获取并设置样式一
	 */
	private static XSSFCellStyle getAndSetXSSFCellStyleOne(SXSSFWorkbook sxssfWorkbook) {
	    XSSFCellStyle xssfCellStyle = (XSSFCellStyle) sxssfWorkbook.createCellStyle();
	    XSSFDataFormat format = (XSSFDataFormat)sxssfWorkbook.createDataFormat();
	    // 是否自动换行
	    xssfCellStyle.setWrapText(false);
	    // 水平居中
	    xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
	    // 垂直居中
	    xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
	    // 前景颜色
	    xssfCellStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
	    xssfCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
	    // 边框
	    xssfCellStyle.setBorderBottom(BorderStyle.THIN);
	    xssfCellStyle.setBorderRight(BorderStyle.THIN);
	    xssfCellStyle.setBorderTop(BorderStyle.THIN);
	    xssfCellStyle.setBorderLeft(BorderStyle.THIN);
	    xssfCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	    xssfCellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
	    xssfCellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
	    xssfCellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	    // 防止数字过长,excel导出后,显示为科学计数法,如:防止8615192053888被显示为8.61519E+12
	    xssfCellStyle.setDataFormat(format.getFormat("0"));
	        return xssfCellStyle;
	    }
	 
	    /**
	 * 获取并设置样式二
	 */
	private static XSSFCellStyle getAndSetXSSFCellStyleTwo(SXSSFWorkbook sxssfWorkbook) {
	    XSSFCellStyle xssfCellStyle = (XSSFCellStyle) sxssfWorkbook.createCellStyle();
	    XSSFDataFormat format = (XSSFDataFormat)sxssfWorkbook.createDataFormat();
	    // 是否自动换行
	    xssfCellStyle.setWrapText(false);
	    // 水平居中
	    xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
	    // 边框
	    xssfCellStyle.setBorderBottom(BorderStyle.THIN);
	    xssfCellStyle.setBorderRight(BorderStyle.THIN);
	    xssfCellStyle.setBorderTop(BorderStyle.THIN);
	    xssfCellStyle.setBorderLeft(BorderStyle.THIN);
	    xssfCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	    xssfCellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
	    xssfCellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
	    xssfCellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	    // 垂直居中
	    xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
	    // 防止数字过长,excel导出后,显示为科学计数法,如:防止8615192053888被显示为8.61519E+12
	    xssfCellStyle.setDataFormat(format.getFormat("0"));
	    return xssfCellStyle;
	}
		 
}
