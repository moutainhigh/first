package com.deppon.dpm.module.management.server.service;

import com.deppon.foss.framework.exception.BusinessException;



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
	 * @throws BusinessException
	 */
	 public String savaScoring(String str) throws BusinessException;
	 /**
	  * @提交实时数据保存
	  * @param str
	  * @return
	  * @throws BusinessException
	  */
	 public String savaMessageReason(String str) throws BusinessException;
	 /**
	  * @监控数据保存
	  * @param str
	  * @return
	  * @throws BusinessException
	  */
	 public String savaProcWatchDept(String str)throws BusinessException;
	 /**
	  * @监控数据保存
	  * @param str
	  * @return
	  * @throws BusinessException
	  */
	 public String savaProcWatchProject(String str)throws BusinessException;
}
