//package com.deppon.dpm.doc.server.util;
//
//import java.io.InputStream;
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.alibaba.excel.ExcelReader;
//import com.alibaba.excel.metadata.BaseRowModel;
//import com.alibaba.excel.metadata.Sheet;
//import com.alibaba.excel.read.context.AnalysisContext;
//import com.alibaba.excel.read.event.AnalysisEventListener;
//import com.alibaba.excel.support.ExcelTypeEnum;
//
//public class EasyExcelFactory {
//	 
//    /**
//     * Quickly read small files more than 10,000 lines.
//     * @param in the POI filesystem that contains the Workbook stream.
//     * @param sheet read sheet.
//     * @return analysis result.
//     */
//    @SuppressWarnings("rawtypes")
//	public static List<Object> read(InputStream in) {
//        final List<Object> rows = new ArrayList<Object>();
//        new ExcelReader(in, ExcelTypeEnum.XLSX , null, new AnalysisEventListener() {
//            @Override
//            public void invoke(Object object, AnalysisContext context) {
//            	rows.add(object);
//            }
// 
//            @Override
//            public void doAfterAllAnalysed(AnalysisContext context) {
//            	
//            }
//        }, false).read();
//        return rows;
//    }
//    
//	public static List<Map<String,String>> read(InputStream in,ExcelTypeEnum type) {
//        final List<Map<String,String>> rows = new ArrayList<>();
//        new ExcelReader(in, type , null, new AnalysisEventListener<List<String>>() {
//            @Override
//            public void invoke(List<String> object, AnalysisContext context) {
//    			try {
//    				Field[] fields = object.getClass().getDeclaredFields();
//        			fields[1].setAccessible(true);
//        			String[] columns = (String[])fields[1].get(object);
//        			Map<String,String> didiorder = new HashMap<String,String>();
//        			didiorder.put("didiBillNo", columns[0]);
//                	didiorder.put("amount", columns[1]);
//                	didiorder.put("subCompany", columns[2]);
//                	rows.add(didiorder);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//            }
// 
//            @Override
//            public void doAfterAllAnalysed(AnalysisContext context) {
//            	
//            }
//        }, false).read();
//        return rows;
//    }
//	
//	 /**
//     * Parsing large file
//     *
//     * @param in       the POI filesystem that contains the Workbook stream.
//     * @param sheet    read sheet.
//     * @param listener Callback method after each row is parsed.
//     */
//	@SuppressWarnings("rawtypes")
//	public static List<Object> readBySax2007(InputStream in,Class<? extends BaseRowModel> clazz) {
//    	final List<Object> rows = new ArrayList<>();
//        new ExcelReader(in, ExcelTypeEnum.XLSX,clazz, new AnalysisEventListener(){
//
//			@Override
//			public void invoke(Object object, AnalysisContext context) {
//				rows.add(object);
//			}
//
//			@Override
//			public void doAfterAllAnalysed(AnalysisContext context) {
//				
//			}
//        	
//        }).read(new Sheet(0,0,clazz));
//        return rows;
//    }
//    
//}
