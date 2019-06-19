package com.deppon.dpm.module.projecttools.server.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.projecttools.server.service.IProjectGradeService;
/**
 * 项目评级
 * @author gcl
 * 2015-09-25
 */
public class ProjectGradeAction extends BaseAction {
	/*** 日志*/
	private Logger logger = LoggerFactory.getLogger(ProjectGradeAction.class);
	
	private static final long serialVersionUID = 1L;
	
	/*** service*/
	private IProjectGradeService projGradeSrv;
	/**
	 * 项目编号
	 */
	private int projectCode;
	/**
	 * 评级详情id
	 */
	private String gradeId;
	
	/**
	 * 获得项目评级信息
	 * 四个评级阶段 ：立项评级，过程评级，结项评级，落地评级
	 */
	public void gradeInfo() {
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			this.logger.info("点击项目评级  param is :" + projectCode);
			//调用service 根据项目编号获得项目评级
			String info= this.projGradeSrv.gradeInfo(projectCode);
			// 返回 到前端
			writeToPage(response, info);
			this.logger.info("点击项目评级  result is :" + info);
		} catch (Exception e) {
			logger.info("点击项目评级出现异常！", e);
			writeToPage(response, "");
		}
	}
	/**
	 * 根据评级编号获得项目评级详情
	 */
	public void gradeBillInfo() {
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			this.logger.info("点击项目评级查看评级详情  param is :" + gradeId);
			//调用service 根据评级详情编号获得项目评级详情
			String info= this.projGradeSrv.gradeBillInfo(gradeId);
			// 返回 到前端
			writeToPage(response, info);
			this.logger.info("点击项目评级查看评级详情  result is :" + info);
		} catch (Exception e) {
			logger.info("点击项目评级查看评级详情出现异常！", e);
			writeToPage(response, "");
		}
	}

	/**
	 * @param projGradeSrv
	 */
	public void setProjGradeSrv(IProjectGradeService projGradeSrv) {
		this.projGradeSrv = projGradeSrv;
	}

	/**
	 * @param projectCode
	 */
	public void setProjectCode(int projectCode) {
		this.projectCode = projectCode;
	}
	/**
	 * @param gradeId
	 */
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}


}
