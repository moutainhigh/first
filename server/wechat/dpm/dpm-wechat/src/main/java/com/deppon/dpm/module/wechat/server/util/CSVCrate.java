package com.deppon.dpm.module.wechat.server.util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CSVCrate {

	/////////////////////////////////////////////

	/**
	 * 创建CSV文件
	 */
	public void createCSV(Object[] head, List<List<Object>> dataList,String fileName, String filePath) {

		// 表格头
//		Object[] head = { "客户姓名", "证件类型", "日期", };
		List<Object> headList = Arrays.asList(head);

		//数据
//		List<List<Object>> dataList = new ArrayList<List<Object>>();
//		List<Object> rowList = null;
//		for (int i = 0; i < 100; i++) {
//			rowList = new ArrayList<Object>();
//			rowList.add("李四" + i);
//			rowList.add("263834194" + i);
//			rowList.add(new Date());
//			dataList.add(rowList);
//		}

//		String fileName = "企业微信通讯录同步.csv";//文件名称
//		String filePath = "E:/test/"; //文件路径

		File csvFile = null;
		BufferedWriter csvWtriter = null;
		try {
			csvFile = new File(filePath + fileName);
			File parent = csvFile.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			csvFile.createNewFile();

			// GB2312使正确读取分隔符","
			csvWtriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "gbk"), 1024);

			//文件下载，使用如下代码
			//            response.setContentType("application/csv;charset=gb18030");
			//            response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
			//            ServletOutputStream out = response.getOutputStream();
			//            csvWtriter = new BufferedWriter(new OutputStreamWriter(out, "GB2312"), 1024);

			int num = headList.size() / 2;
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < num; i++) {
				buffer.append(" ,");
			}
			//表格第一行总标题
//			csvWtriter.write(buffer.toString() + fileName + buffer.toString());
//			csvWtriter.newLine();

			// 写入文件头部
			writeRow(headList, csvWtriter);

			// 写入文件内容
			for (List<Object> row : dataList) {
				writeRow(row, csvWtriter);
			}
			csvWtriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				csvWtriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}




	/////////////////////////////////////////////


	/**
	 * 写一行数据
	 * @param row 数据列表
	 * @param csvWriter
	 * @throws IOException
	 */
	private static void writeRow(List<Object> row, BufferedWriter csvWriter) throws IOException {
		/*for (Object data : row) {
			StringBuffer sb = new StringBuffer();
			String rowStr = sb.append("\"").append(data).append("\",").toString();
			csvWriter.write(rowStr);
		}*/
		
		/*for (Object data : row) {
			StringBuffer sb = new StringBuffer();
			String rowStr = sb.append(data).append(",").toString();
			csvWriter.write(rowStr);
		}*/
		
		for (int i = 0; i < row.size(); i++) {
			Object obj = row.get(i);
			StringBuffer sb = new StringBuffer();
			String rowStr = "";
			//每行最后 不加逗号
			if (i != (row.size() - 1)) {
				rowStr = sb.append(obj).append(",").toString();
			}else {
				rowStr = sb.append(obj).toString();
			}
			
			csvWriter.write(rowStr);
		}
		csvWriter.newLine();
	}

		

}
	

