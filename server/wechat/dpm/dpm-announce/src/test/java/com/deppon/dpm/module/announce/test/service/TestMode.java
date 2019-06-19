package com.deppon.dpm.module.announce.test.service;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class TestMode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*String[] srcStr = {"1","2","3","4","5","6","7","8","9","10"};
		String[] dirStr = {"a","b","c"};
		for(int i = 0 ; i < srcStr.length; i++){
			int rs = i%3;
			String pt = "无";
			if(rs == 0){
				pt = dirStr[0];
			}else if(rs == 1){
				pt = dirStr[1];
			}else if(rs == 2){
				pt = dirStr[2];
			}
			System.out.println(srcStr[i]+"============"+pt);
		}*/
		/*String[] srcStr = {"1","2","3",null,"5","6","7",null,"9","10"};
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < srcStr.length; i++){
			String str = srcStr[i] == null?"":srcStr[i].replaceAll("[#\\|]", "");
			sb.append(str).append("|");
		}
		System.out.println(sb.toString());*/
		//sb.append((rs.getString(i) == null) ? rs.getString(i) : rs.getString(i).replaceAll("[#\\|]", "")).append("|");
		/*String str1 = "【高管晨会随笔】德邦“高管团队自律宣言”誓词（二） 15";
		String str2 = "【故事】送货司机斗贪心收货人 拒绝诱惑保发货人利益 (图)";
		String str3 = "14-7171职能部门组织结构调整及相关人事任命通知";
		String str4 = "";
		String[] strs = {str1,str2,str3,str4};
		
		for(String s : strs){
			String st = splitTitle(s);
			System.out.println(st);
		}*/
		Calendar currCalendar = Calendar.getInstance();
		Date currDate = currCalendar.getTime();
		int currmonth = currCalendar.get(Calendar.MONTH)+1;   
		//currCalendar.set
		currCalendar.set(Calendar.MONTH, currmonth-2);
		int year = currCalendar.get(Calendar.YEAR); 
		int month = currCalendar.get(Calendar.MONTH)+1;   
		int day = currCalendar.get(Calendar.DATE);   
		System.out.println(year+""+month+""+day);
		
	}
	
	public static String splitTitle(String title){
		if(StringUtils.isEmpty(title)){
			return "";
		}
		String newTitle = "";
		int start = title.lastIndexOf("】")+1;
		int end = title.length();
		String subStr = null;
		if(start >= 0){
			subStr = title.substring(start, end);
		}else{
			subStr = title;
		}
		int index = subStr.lastIndexOf("(图)");
		if(index >= 0) {
			newTitle = subStr.substring(0, subStr.length()-3);
		}else{
			newTitle = subStr;
		}
		return newTitle;
	}

}
