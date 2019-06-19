package com.deppon.dpm.module.projecttools.server.action;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.projecttools.server.service.ICommonService;
/**
 * dppm 公共选择器
 * @author gcl
 * 2015-10-13
 */
public class CommonAction extends BaseAction {
	/*** 日志*/
	private Logger logger = LoggerFactory.getLogger(CommonAction.class);
	
	private static final long serialVersionUID = 1L;
	
	/*** service*/
	private ICommonService commonSrv;
	/**
	 * 搜索输入框
	 */
	private String code;
	/**
	 * 状态
	 */
	private int status;
	/**
	 * 系统需求搜索时 关联的用户需求编号
	 */
	private String userDemandCode;
	/**
	 * 人员信息查询
	 */
	public void chooseEmp() {
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			this.logger.info("点击人员查询  param is :" + code);
			//调用service 获得人员信息
			String info = this.commonSrv.chooseEmp(code,status);
			// 返回 到前端
			writeToPage(response, info);
			this.logger.info("点击人员查询  result is :" + info);
		} catch (Exception e) {
			logger.info("点击人员查询出现异常！", e);
			writeToPage(response, "");
		}
	}
	/**
	 * 验收模块下拉
	 */
	public void checkModule() {
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			//调用service 获得验收模块
			String info = this.commonSrv.checkmodule();
			// 返回 到前端
			writeToPage(response, info);
			this.logger.info("点击验收模块  result is :" + info);
		} catch (Exception e) {
			logger.info("点击验收模块出现异常！", e);
			writeToPage(response, "");
		}
	}
	
	/**
	 * 任务类别查询
	 */
	public void taskType() {
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			//调用service 获得任务类别
			String info = this.commonSrv.taskType();
			// 返回 到前端
			writeToPage(response, info);
			this.logger.info("获得任务类别  result is :" + info);
		} catch (Exception e) {
			logger.info("获得任务类别出现异常！", e);
			writeToPage(response, "");
		}
	}
	/**
	 * 项目选择器
	 * 查询我负责的项目 可以按照项目名称搜索
	 */
	public void searchProjList() {
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			//调用service 获得项目列表
			String info = this.commonSrv.searchProjList(userId, code);
			// 返回 到前端
			writeToPage(response, info);
			this.logger.info("获得项目选择器  result is :" + info);
		} catch (Exception e) {
			logger.info("获得项目选择器出现异常！", e);
			writeToPage(response, "");
		}
	}
	/**
	 * 任务新建中 父任务选择器
	 * 当前用户是任务分配者或处理者，根据任务类别或项目名称查询出任务集合
	 */
	public void searchPtaskList() {
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			//调用service 获得父任务列表
			String info = this.commonSrv.searchPtaskList(userId, code, status);
			// 返回 到前端
			writeToPage(response, info);
			this.logger.info("获得父任务选择器  result is :" + info);
		} catch (Exception e) {
			logger.info("获得父任务选择器出现异常！", e);
			writeToPage(response, "");
		}
	}
	/**
	 * 用户需求选择器
	 * 可以按照需求名称搜索
	 */
	public void searchUserDemand() {
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			//调用service 获得用户需求列表
			String info = this.commonSrv.searchUserDemand(code);
			// 返回 到前端
			writeToPage(response, info);
			this.logger.info("获得用户需求选择器  result is :" + info);
		} catch (Exception e) {
			logger.info("获得用户需求选择器出现异常！", e);
			writeToPage(response, "");
		}
	}
	/**
	 * 系统需求选择器
	 * 可以按照需求编码搜索
	 */
	public void searchSysDemand() {
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			//调用service 获得系统需求列表
			String info = this.commonSrv.searchSysDemand(code, userDemandCode);
			// 返回 到前端
			writeToPage(response, info);
			this.logger.info("获得系统需求选择器  result is :" + info);
		} catch (Exception e) {
			logger.info("获得系统需求选择器出现异常！", e);
			writeToPage(response, "");
		}
	}
	/**
	 * 任务开发语言选择器
	 * 任务类型是开发任务时 获得
	 */
	public void searchDevLang() {
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			//调用service 获得开发语言
			String info = this.commonSrv.searchDevLang();
			// 返回 到前端
			writeToPage(response, info);
			this.logger.info("获得开发语言  result is :" + info);
		} catch (Exception e) {
			logger.info("获得开发语言选择器出现异常！", e);
			writeToPage(response, "");
		}
	}

	/**
	 * @param commonSrv
	 */
	public void setCommonSrv(ICommonService commonSrv) {
		this.commonSrv = commonSrv;
	}

	/**
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @param userDemandCode
	 */
	public void setUserDemandCode(String userDemandCode) {
		this.userDemandCode = userDemandCode;
	}
	

}
