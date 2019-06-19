/**
 * 
 */
package com.deppon.montal.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * yin 格式化工具
 *
 */
public class FormatUtil {
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 默认日期转换“yyyy-MM-dd”toString
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date){
		if(null ==date){
			return "";
		}else{
			return sdf.format(date);
		}
	}
	/**
	 * 
	* @MethodName: formatStrTODate 
	* @description : String  转   Date
	* @author：caibingbing 
	* @date： 2014-9-2 上午10:51:05
	* @param str
	* @param reg
	* @return Date
	 */
	public static Date formatStrTODate(String str,String reg){
		SimpleDateFormat sdf = new SimpleDateFormat(reg);
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			return new Date();
		}
	}
	/**
	 * 自定义转换日期格式toString
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date,String format){
		if(null == date){
			return "";
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}	
	}
	
	/**
	 * 自定义转换日期格式toString
	 * 关波
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(XMLGregorianCalendar date,String format){
		if(null == date){
			return "";
		}else{
			GregorianCalendar ca = date.toGregorianCalendar();
	        Date temp = ca.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(temp);
		}	
	}
	/**
	   * @Title: formatMoneyStr 
	   * @Description:TODO(转为默认金额格式)
	   * @date 2014-7-16 上午9:04:50
	 */
	public static String formatMoneyStr(BigDecimal money){
		if(null == money){
			return "";
		}
		
		DecimalFormat myformat=new DecimalFormat("0.00");
		return myformat.format(money);
	}
	/**
	   * @Title: formatMoney 
	   * @Description:TODO(转为默认金额格式)
	   * @date 2013-8-2 下午4:04:50
	 */
	public static String formatMoney(BigDecimal money){
		if(null == money){
			return "0.00";
		}
		
		DecimalFormat myformat=new DecimalFormat("0.00");
		return myformat.format(money);
	}
	
	/**
	   * @Title: formatMoney 
	   * @Description:TODO(转为指定金额格式)
	   * @date 2013-8-2 下午4:04:50
	 */
	public static String formatMoney(BigDecimal money,String formatString){
		if(null == money){
			return "";
		}
		DecimalFormat myformat=new DecimalFormat(formatString);
		return myformat.format(money);
	}
	/**
	 * 
	* @MethodName: formatDoubleStr 
	* @description : 科学计数法 格式化转换 String
	* @author：caibingbing 
	* @date： 2014-5-14 下午2:12:34
	* @param d
	* @return String
	 */
	public static String formatDoubleStr(double d){
		DecimalFormat df = new DecimalFormat("####");
		String s=df.format(d);
		return s;
	}
	/**
	 * 
	* @MethodName: formatDouble 
	* @description : 格式化转换String类型 为想要的数字类型
	* @author：caibingbing 
	* @date： 2014-6-14 上午11:09:54
	* @param reg
	* @param str
	* @return String
	 */
	public static String formatDouble(String reg,String str){
		Double dou = Double.parseDouble(str);
		java.text.DecimalFormat   df   =new   java.text.DecimalFormat(reg);
		String d1 = df.format(dou);
		if(dou < 1){
			d1 = "0" + d1;
		}
		return d1;
	}
	/**
	 * 
	* @MethodName: formateDateAdd 
	* @description : 日期类型  加/减 算法
	* @author：caibingbing 
	* @date： 2014-7-8 下午5:14:56
	* @param date
	* @param day
	* @return String
	 */
	public static String formateDateAdd(Object date,int day){
		Date dateTime = null;
		if(date instanceof Date){
			dateTime = (Date) date;
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				dateTime = (Date) sdf.parse((String) date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateTime);
		cal.add(Calendar.DAY_OF_MONTH, day);
		System.out.println(formatDate(cal.getTime(),"yyyy-MM-dd"));
		return formatDate(cal.getTime(),"yyyy-MM-dd");
	}
}
