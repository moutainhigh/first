package com.deppon.dpm.module.management.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalendarDateUtil {
	/**
	 * LOG
	 */
	private static final Logger LOG = LoggerFactory
			.getLogger(CalendarDateUtil.class);

	/**
	 * 根据日期获取当月的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getCurrentMonthStartTime(Date date) {
		// 创建日期格式化对象
		SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		// 创建对象
		Calendar c = Calendar.getInstance();
		// 赋值日期
		c.setTime(date);
		// 定义返回值
		Date now = null;
		try {
			// 把day赋值为1
			c.set(Calendar.DATE, 1);
			// 格式化时间
			now = shortSdf.parse(shortSdf.format(c.getTime()));
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
			LOG.error("getCurrentMonthStartTime", e);
		}
		// 返回
		return now;
	}

	/**
	 * 根据日期获取当月的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getCurrentMonthEndTime(Date date) {
		// 创建日期格式化对象
		SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 创建对象
		Calendar c = Calendar.getInstance();
		// 赋值日期
		c.setTime(date);
		// 定义返回值
		Date now = null;
		try {
			// 把day赋值为1
			c.set(Calendar.DATE, 1);
			// 月加1
			c.add(Calendar.MONTH, 1);
			// 天减1
			c.add(Calendar.DATE, -1);
			// 格式化时间
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
			LOG.error("getCurrentMonthEndTime", e);
		}
		// 返回
		return now;
	}

	/**
	 * 获取此日期之后N天的日期
	 * 
	 * @param date
	 * @param i
	 * @return
	 */
	public static String addDay(Date date, int i) {
		SimpleDateFormat addDaySdf = new SimpleDateFormat("yyyy-MM-dd");
		// 创建对象
		Calendar c = Calendar.getInstance();
		// 赋值日期
		c.setTime(date);
		// 定义返回值
		String now = null;
		try {
			// 天加N天
			c.add(Calendar.DATE, i);
			// 格式化时间
			now = addDaySdf.format(c.getTime());
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
			LOG.error("addDay", e);
		}
		// 返回
		return now;
	}

	/**
	 * 根据日期格式，Date转换为String
	 * 
	 * @param aMask
	 * @param aDate
	 * @return
	 */
	public static String getDateTime(String aMask, Date date) {
		// 返回值
		String returnValue = "";
		// 日期是否为空
		if (date == null) {
			// 日志记录
			LOG.error("aDate is null!");
		} else {
			// 格式化日期
			SimpleDateFormat df = new SimpleDateFormat(aMask);
			returnValue = df.format(date);
		}
		// 返回值
		return returnValue;
	}

	/**
	 * String转换为date
	 * 
	 * @param aMask
	 * @param strDate
	 * @return
	 */
	public static final Date convertStringToDate(String aMask, String strDate) {
		// 格式化
		SimpleDateFormat df = new SimpleDateFormat(aMask);
		// 返回值
		Date date = null;
		try {
			// 日期转换
			date = df.parse(strDate);
		} catch (ParseException pe) {
			// 异常处理
			LOG.error("convertStringToDate", pe);
		}
		// 返回
		return date;
	}

	/**
	 * 获取当前时间
	 * 
	 * @param sdf
	 * @return
	 */
	public static String getDateTime(SimpleDateFormat sdf) {
		// 创建对象
		Calendar cale = Calendar.getInstance();
		try {
			// 获取当前时间，格式化时间
			return sdf.format(cale.getTime());
		} catch (Exception e) {
			// 异常处理
			LOG.error("getDateTime", e);
			return "";
		}
	}

	/**
	 * 格式化时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getSdfDate(String aMask, Date date) {
		// 格式化
		SimpleDateFormat df = new SimpleDateFormat(aMask);
		// 返回值
		Date newDate = null;
		try {
			// 格式化时间
			newDate = df.parse(df.format(date));
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
			LOG.error("getCurrentMonthStartTime", e);
		}
		// 返回
		return newDate;
	}

}