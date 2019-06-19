package com.deppon.dpm.module.management.server.service;



/**
 * 保存分数信息
 * 和数据监控
 * @author 袁中华
 * @date 2015.07.14
 *
 */

public interface IProcScoringService {
	/**
	 * @提交5分保存 
	 * @param string
	 * @return
	 * @throws Exception
	 */
	 public String savaScoring(String str) throws Exception;
	 /**
	  * @提交实时数据保存
	  * @param str
	  * @return
	  * @throws Exception
	  */
	 public String savaMessageReason(String str) throws Exception;
	 /**
	  * @监控数据保存
	  * @param str
	  * @return
	  * @throws Exception
	  */
	 public String savaProcWatchDept(String str)throws Exception;
	 /**
	  * @监控数据保存
	  * @param str
	  * @return
	  * @throws Exception
	  */
	 public String savaProcWatchProject(String str)throws Exception;
}
