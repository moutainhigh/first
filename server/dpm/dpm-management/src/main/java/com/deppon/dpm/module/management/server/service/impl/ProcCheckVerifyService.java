package com.deppon.dpm.module.management.server.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.management.server.dao.IProcCheckVerifyDao;
import com.deppon.dpm.module.management.server.service.IProcCheckVerifyService;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * <p>
 * ClassName: ProcCheckVerifyService
 * </p>
 * <p>
 * Description: 工程验收初次保存的校验service接口实现
 * </p>
 * <p>
 * Author: 268101
 * </p>
 * <p>
 * Date: 2015-8-17
 * </p>
 */
public class ProcCheckVerifyService implements IProcCheckVerifyService {
	// 工程验收dao接口
	private IProcCheckVerifyDao checkVerifyDao;
	// 日志
	private Logger logger = LoggerFactory
			.getLogger(ProcCheckVerifyService.class);

	/**
	 * <p>
	 * Description: 工程验收初次保存的校验.
	 * </p>
	 * 
	 * @param name
	 *            营业部名称
	 * @return str
	 */
	public String checkProcSubmit(String name) {
		String res = "";
		if (!StringUtil.isEmpty(name)) {
			logger.info("进入ProcCheckVerifyService的checkProcSubmit方法<<<<<<<<<<<<<<<传入参数为:"
					+ name);
			//获取工程验收数据
			int checkMark = this.checkVerifyDao.checkProcSubmit(name);
			//对得到数据标志位进行判断 1 成功前台按钮亮起可以保存 2按钮不亮起，不能进行保存
			if (checkMark == 1) {
				res = "{\"resultFlag\":\"true\",\"failureReason\":\"\"}";
			}
			if (checkMark == 2) {
				res = "{\"resultFlag\":false,\"failureReason\":\"还不能亮起！\"}";
			}

		}
		return res;
	}

	public IProcCheckVerifyDao getCheckVerifyDao() {
		return checkVerifyDao;
	}

	public void setCheckVerifyDao(IProcCheckVerifyDao checkVerifyDao) {
		this.checkVerifyDao = checkVerifyDao;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

}
