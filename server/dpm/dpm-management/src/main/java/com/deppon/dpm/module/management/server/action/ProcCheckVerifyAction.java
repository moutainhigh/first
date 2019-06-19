package com.deppon.dpm.module.management.server.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.management.server.service.IProcCheckVerifyService;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * <p>
 * ClassName: ProcCheckVerify
 * </p>
 * <p>
 * Description: 工程验收初次保存的校验.
 * </p>
 * <p>
 * Author: 268101
 * </p>
 * <p>
 * Date: 2015-8-17
 * </p>
 */
public class ProcCheckVerifyAction extends BaseAction {

	/**
	 * <p>
	 * Field serialVersionUID: 序列化
	 * </p>
	 */
	private static final long serialVersionUID = 1L;
	// 营业部名称code
	private String deptCode;
	// 接口
	private IProcCheckVerifyService checkVerifyService;
	private Logger logger = LoggerFactory
			.getLogger(ProcCheckVerifyAction.class);

	/**
	 * <p>
	 * Description: 校验工程验收的提交.
	 * </p>
	 */
	public void checkProcSubmit() {
		logger.info("进入ProcCheckVerifyAction的checkProcSubmit方法<<<<<<<<<<<<<<<<<<<<<<");
		// 设置页面响应实体
		String res = "";
		
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			//获得数据
			res = this.checkVerifyService.checkProcSubmit(deptCode);
			if (StringUtil.isEmpty(res)) {
				res = "{\"resultFlag\":false,\"failureReason\":\"还不能亮起！\"}";

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		writeToPage(response, res);

	}

	public void setCheckVerifyService(IProcCheckVerifyService checkVerifyService) {
		this.checkVerifyService = checkVerifyService;
	}

	// 营业部名称code get set
	public String getDeptCode() {
		return deptCode;
	}

	// 营业部名称code get set
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
    //日志标志位 get set
	public Logger getLogger() {
		return logger;
	}
	 //日志标志位 get set
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

}
