/**
 * Project Name:DPMotal_20140925
 * File Name:ICalendarManagerService.java
 * Package Name:com.deppon.montal.module.calendar.service
 * Date:2014-10-14上午9:12:27
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.deppon.montal.module.calendar.service;
/**
 * ClassName:ICalendarManagerService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * 
 * Date:     2014-10-14 上午9:12:27 <br/>
 * @author   157229-zxy
 * @version  
 * @since    JDK 1.6
 */
public interface ICalendarManagerService {
	
	/**
	 * 新增日程
	 * addSchedule: <br/>
	 * 
	 * Date:2014-10-14上午9:16:53
	 * @author 157229-zxy
	 * @param content 日程的json报文
	 * @since JDK 1.6
	 */
	void addSchedule(String content) throws Exception;
	
	/**
	 * 修改日程
	 * updateSchedule: <br/>
	 * 
	 * Date:2014-10-14上午9:17:19
	 * @author 157229-zxy
	 * @param content 日程的json报文
	 * @since JDK 1.6
	 */
	void updateSchedule(String content) throws Exception;
	
	/**
	 * 删除日程
	 * deleteSchedule: <br/>
	 * 
	 * Date:2014-10-14上午9:17:33
	 * @author 157229-zxy
	 * @param content 
	 * @since JDK 1.6
	 */
	void deleteSchedule(String content) throws Exception;
	
	/**
	 * 查询日程
	 * querySchedule: <br/>
	 * 
	 * Date:2014-10-14上午9:17:47
	 * @author 157229-zxy
	 * @param content
	 * @return 日程json报文
	 * @since JDK 1.6
	 */
	String querySchedule(String content) throws Exception;

}

