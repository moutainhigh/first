package com.deppon.dpm.module.projecttools.server.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class DateUtil {
	/**
     * 获取某月的最后一天
     * @Title:queryLastdayOfMonth
     * @Description:
     * @param:@param month 年月 2015-08
     * @param:@return
     * @return:String
     * @throws
     */
	public static final String queryLastdayOfMonth(String month) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR); //得到年
		int mon = cal.get(Calendar.MONTH) + 1;
		if(month != null && !month.equals("")){
			String[] s = month.split("-");
			year = Integer.parseInt(s[0]);
			mon = Integer.parseInt(s[1]);
		}
		
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, mon-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
	}
	/**
     * 获取昨天
     * @Title:queryYesterday
     * @Description:
     * @param:@param date 年月日 2015-11-16
     * @param:@return
     * @return:String
     * @throws
     */
	public static final String queryYesterday(String date) {
		//格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.add(Calendar.DAY_OF_MONTH, -1);
		String yesterday = sdf.format(cal.getTime());
        return yesterday;
	}
	/**
     * 获取上月
     * @Title:queryLastMonth
     * @Description:
     * @param:@param date 年月 2015-11
     * @param:@return
     * @return:String
     * @throws
     */
	public static final String queryLastMonth(String date) {
		//格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.add(Calendar.MONTH, -1);
		String yesterday = sdf.format(cal.getTime());
        return yesterday;
	}
	/**
     * 获取去年本月
     * @Title:queryLastYear
     * @Description:
     * @param:@param date 年月 2015-11
     * @param:@return
     * @return:String
     * @throws
     */
	public static final String queryLastYear(String date) {
		//格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.add(Calendar.YEAR, -1);
		String yesterday = sdf.format(cal.getTime());
        return yesterday;
	}
	/**
     * 获取前几天  n 等数据
     * @Title:queryYesterday
     * @Description:
     * @param:@param date 年月日 2015-11-16
     * @param:@return
     * @return:String
     * @throws
     */
	public static final String queryBeforeday(String date,int n) {
		//格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.add(Calendar.DAY_OF_MONTH, -n);
		String yesterday = sdf.format(cal.getTime());
        return yesterday;
	}
	/**
     * 获取上周当天
     * @Title:queryLastWeek
     * @Description:
     * @param:@param date 年月日 2015-11-16
     * @param:@return
     * @return:String
     * @throws
     */
	public static final String queryLastWeek(String date) {
		//格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.add(Calendar.WEEK_OF_YEAR, -1);
		String week = sdf.format(cal.getTime());
        return week;
	}
	/**
     * 获取当前日期的周日
     * @Title:queryWeekSunday
     * @Description:
     * @param:@param date 年月日 2015-11-16
     * @param:@return
     * @return:String
     * @throws
     */
	public static final String queryWeekSunday(String date) {
		//格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date a = null;
		try {
			a = DateUtils.addDays(sdf.parse(date), -1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         Calendar cal = Calendar.getInstance();
         if(a != null){
             cal.setTime(a);
             cal.set(Calendar.DAY_OF_WEEK, 1);
         }
         return sdf.format(cal.getTime());
	}
	public static void main(String[] args) {
		String yestDay = DateUtil.queryBeforeday("2015-11-13",0);
        System.out.println(yestDay);
	}
}
