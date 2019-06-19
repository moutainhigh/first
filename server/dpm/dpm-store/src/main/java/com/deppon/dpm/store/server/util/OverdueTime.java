package com.deppon.dpm.store.server.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * 计算逾期时间工具类
 * @author lvdefu
 *
 */
public class OverdueTime {
	/**
	 * 需要的数据
	 * 主任务id
	 * 任务截止时间 endtime
	 * 子任务条数 denominator
	 * 子任务已完成条数 numerator
	 * 最晚提交时间 sublistendtime
	 * @throws ParseException 
	 */
	public static Map<String,String> overdue(String endtime,int denominator,int numerator,String sublistendtime) throws ParseException{
		// 定义返回map
		Map<String,String> map = new HashMap<String, String>();
		// 获取当前时间与逾期时间的毫秒数 若当前时间未到任务截止时间 则未逾期
		long time = overdueTime(endtime);
		// time小于0代表当前时间小于任务截止时间
		if(time<0){
			map.put("OverdueTime","未逾期");
			map.put("Isoverdue","0");
		}else{
			// 如果任务字表中的总条数等于任务字表中的已完成任务数量，则说明全部反馈完成
			if(denominator==numerator){
				// 按照最晚提交时间计算逾期时间
				time = differentDaysByMillisecond(endtime,sublistendtime);
				// 判断逾期 若为负数则未逾期，若为正数则未逾期多少天
				judgeOverdue(map, time);
			}else{
				//如果denominator和numerator不相等 则说明 任务未完成 按当前时间计算逾期
				time = overdueTime(endtime);
				judgeOverdue(map,time);
			}
		}
		return map;
	}
	/**
	 * 判断 逾期通用方法
	 * @param jonum
	 * @param time
	 */
	public static void judgeOverdue(Map<String,String> map, long time) {
		if(time>0){
			map.put("Isoverdue","1");
			// 若大于0，则逾期超过一天 等于0则未超过一天
			if(time / (24 * 60 * 60) == 0){
				map.put("OverdueTime","逾期不到1天");
			}else{
				// 计算天数
				time = time / (24 * 60 * 60);
				map.put("OverdueTime","逾期" + time + "天");
			}
		}else{
			map.put("Isoverdue","0");
			map.put("OverdueTime","未逾期");
		}
	}
	/**
	 * 计算给定时间和当前时间之间的秒数
	 * 
	 * @param endtime
	 * @return
	 * @throws ParseException
	 */
	private static long overdueTime(String endtime) throws ParseException {
		// 格式化时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 转换类型
		Date date1 = format.parse(endtime);
		// 获取当前时间
		Date date = new Date();
		// 计算秒数
		long dayDiff = (long) ((date.getTime() - date1.getTime()) / (1000));
		// 返回
		return dayDiff;
	}
	/**
	 * 计算两个时间之间的秒数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	private static long differentDaysByMillisecond(String str1, String str2)
			throws ParseException {
		// 格式化时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 转换类型
		Date date1 = format.parse(str1);
		// 转换类型
		Date date2 = format.parse(str2);
		// 计算时间差
		long days = (long) ((date2.getTime() - date1.getTime()) / (1000));
		// 返回
		return days;
	}

}
