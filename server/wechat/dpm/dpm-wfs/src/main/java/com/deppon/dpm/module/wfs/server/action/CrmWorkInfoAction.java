package com.deppon.dpm.module.wfs.server.action;

import java.io.BufferedReader;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.wfs.server.service.ICrmWorkInfoService;
import com.deppon.dpm.module.wfs.server.service.IMonitorService;
import com.deppon.dpm.module.wfs.server.util.workflowStrUtil;
import com.deppon.dpm.module.wfs.server.util.monitor.WFSMonitorUtil;
import com.deppon.dpm.module.wfs.shared.domain.crm.CrmApproveParam;
import com.deppon.dpm.module.wfs.shared.vo.QueryParamVo;

/**
 * crm 客户关系管理系统的工作流
 * 疑似重复客户处理工作流
 * @version
 */
public class CrmWorkInfoAction extends BaseAction {
	/** 
	*
	*/
	private static final long serialVersionUID = 1397420409043898745L;
	private Logger logger  = LoggerFactory.getLogger(CrmWorkInfoAction.class);
	/**
	 * service
	 */
	private ICrmWorkInfoService crmWfsSrv;
	//service
	private IMonitorService monitorService;
	private String empName;
	// 工作流单据号
	private String busino;
	// 工作流单据号
	private String cbusino;
	// 工作流类型
	private String flowtype;
	// 错误信息 用于错误预警
	private String errorInfo;

	/**
	 * 详情查看 根据审批流程中任一人的工号，姓名，工作流单据号 使用restful的方式进行接口调用
	 * 
	 * @author 195406 高春玲
	 * @date 2015-6-29 上午9:45:08
	 * @see
	 */
	public void queryWorkInfo() {
		Date begindate = new Date();
		String issuccess = "0";
		String str = null;
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
			response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			QueryParamVo query = null;
			str = StringUtil.bufferString(bu);
			//打印出参数
			logger.info("============crm query action param:" + str);
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				//给实体赋值
				query = JSONObject.parseObject(str,
						QueryParamVo.class);
				//给busino赋值
				busino = query.getBusino();
				query.setEmpName(java.net.URLDecoder.decode(query.getEmpName(), "utf-8"));
				//调用service
				String json = crmWfsSrv.queryWorkInfo(query);
				//打印返回的json
				logger.info("============crm query action return:" + json);
				json = workflowStrUtil.replaceJsonSpecialCharacter(json);
				//返回给页面
				writeToPage(response, json);
				if(json != null && !json.equals("")) {
					String s = JsonUtil.jsonGetValueBykey(json,"isSuccess");
					if(s != null && s.equals("Y")) {//查询成功
						issuccess = "1";
					}
				}
				errorInfo = json;
			}
		} catch (Exception e) {
			errorInfo = e.getMessage();
			e.printStackTrace();
		} finally {
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				if( flowtype !=null && flowtype.equals("com.deppon.bpms.module.crm.bpsdesign.operate.multiReparation") 
						||  flowtype !=null && flowtype.equals("com.deppon.bpms.module.crm.bpsdesign.claims.generalclaims") ){
					WFSMonitorUtil.addMonitor(this.userId, "0", this.flowtype, begindate, this.cbusino, 
							issuccess, this.errorInfo, ServletActionContext.getRequest().getSession(), this.monitorService, null,str);
				}
				else{
				//保存数据监控
				WFSMonitorUtil.addMonitor(this.userId, "0", this.flowtype, begindate, this.busino, 
						issuccess, this.errorInfo, ServletActionContext.getRequest().getSession(), this.monitorService, null,str);
				}
			}
		}
	}

	/**
	 * 工作流审批
	 */
	public void approveWorkInfo() {
		Date begindate = new Date();
		String issuccess = "0";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String str = null;
		try {
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			CrmApproveParam audit = null;// 构建审批后勤需要的参数
			str = StringUtil.bufferString(bu);
			//打印出参数
			logger.info("============crm approve action param:" + str);
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				//给实体赋值
				audit = JSONObject.parseObject(str,
						CrmApproveParam.class);
//				audit.setDealEmpName(java.net.URLDecoder.decode(audit.getDealEmpName(), "utf-8"));
				busino = audit.getBusino();
				//调用service
				String json = crmWfsSrv.approveWorkInfo(audit);
				String s = JsonUtil.jsonGetValueBykey(json,"success");
				if(s != null && s.equals("true")) {//审批成功
					issuccess = "1";
				}
				logger.info("============crm approve action return:" + json);
				//返回给页面
				writeToPage(response, json);
				errorInfo = json;
			}
		} catch (Exception e) {
			//打印出报错信息
			e.printStackTrace();
			writeToPage(response, "0");
			errorInfo = e.getMessage();
		} finally {
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				if(flowtype !=null && flowtype.equals("com.deppon.bpms.module.crm.bpsdesign.operate.multiReparation") 
						||  flowtype !=null && flowtype.equals("com.deppon.bpms.module.crm.bpsdesign.claims.generalclaims")){
					WFSMonitorUtil.addMonitor(this.userId, "1", this.flowtype, begindate, this.cbusino, 
							issuccess, this.errorInfo, ServletActionContext.getRequest().getSession(), this.monitorService, null,str);
				}
				else{
				//保存数据监控
				WFSMonitorUtil.addMonitor(this.userId, "1", this.flowtype, begindate, this.busino, 
						issuccess, this.errorInfo, ServletActionContext.getRequest().getSession(), this.monitorService, null,str);
				}
			}
		}
	}

	/**
	 * @param crmWfsSrv the crmWfsSrv to set
	 */
	public void setCrmWfsSrv(ICrmWorkInfoService crmWfsSrv) {
		this.crmWfsSrv = crmWfsSrv;
	}

	/**
	 * @param monitorService the monitorService to set
	 */
	public void setMonitorService(IMonitorService monitorService) {
		this.monitorService = monitorService;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}


	/**
	 * @param flowtype the flowtype to set
	 */
	public void setFlowtype(String flowtype) {
		this.flowtype = flowtype;
	}

	/**
	 * @param cbusino the cbusino to set
	 */
	public void setCbusino(String cbusino) {
		this.cbusino = cbusino;
	}
}