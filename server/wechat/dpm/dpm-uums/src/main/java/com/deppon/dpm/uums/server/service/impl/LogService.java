/**
 * Project Name:dpm-uums
 * File Name: LogService.java
 * Package Name:com.deppon.dpm.uums.server.service.impl
 * Date:2014-8-16下午7:21:17
 * Copyright (c) 2014, yuyongxiang@deppon.com All Rights Reserved.
 *
 */

package com.deppon.dpm.uums.server.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.deppon.dpm.uums.server.dao.ILogDao;
import com.deppon.dpm.uums.server.service.ILogService;
import com.deppon.dpm.uums.server.vo.AppLogVo;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 
 * @ClassName: LogService
 * @Description: 查询所有的操作日志
 * @author yuyongxiang-134019-yuyongxiang@deppon.com
 * @date 2014年09月18日15:51:53
 *
 */
public class LogService implements ILogService {

	private ILogDao logDao;

	/**
	 * @Title: select
	 * @Description: 查询所有的操作日志
	 * @author yuyongxiang-134019-yuyongxiang@deppon.com
	 * @date 2014年9月18日 下午3:52:14
	 * @param @param vo
	 * @param @return
	 * @param @throws BusinessException 设定文件
	 * @throws
	 */
	@Override
	public AppLogVo select(AppLogVo vo) throws BusinessException {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("start", vo.getStartTime());
		map.put("endTime", vo.getEndTime());
		map.put("userCode", vo.getUserCode());
		map.put("userName", vo.getUserName());
		map.put("limit", vo.getLimit());
		map.put("startLimit", vo.getStartLimit());
		
		vo.setLogList(logDao.selectlimit(map));
		vo.setTotalCount(logDao.selectlimitCount(map));
		
		return vo;
	}

	/**
	 * @return logDao
	 */
	public ILogDao getLogDao() {
		return logDao;
	}

	/**
	 * @param logDao
	 *            要设置的 logDao
	 */
	public void setLogDao(ILogDao logDao) {
		this.logDao = logDao;
	}

}
