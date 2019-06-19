package com.deppon.dpm.module.wfs.server.action;

import java.io.BufferedReader;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.wfs.server.service.IFSSCWorkInfoService;
import com.deppon.dpm.module.wfs.server.service.IMonitorService;
import com.deppon.dpm.module.wfs.server.util.monitor.WFSMonitorUtil;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

/**
 * 控股报账的工作流 报账工作流 使用webservice方式
 * 
 * @version
 */
public class FSSCWorkInfoAction extends BaseAction {
	/** 
	*
	*/
	private static final long serialVersionUID = 1397420409043898745L;
	private Logger logger = LoggerFactory.getLogger(FSSCWorkInfoAction.class);

	/**
	 * service
	 */
	private IFSSCWorkInfoService fsscWfsSrv;
	//service
	private IMonitorService monitorService;
	private String empName;
	// 工作流单据号
	private String busino;
	private String workitemid;
	// 工作流类型
	private String flowtype;
	// 错误信息 用于错误预警
    private String errorInfo;

	/**
	 *Fss报账工作流查询
	 * 
	 * @author 280769 张彬
	 * @date 2015-9-14 
	 * @see
	 */
    @CookieNotCheckedRequired
    public void fssQuery() {
        Date begindate = new Date();
        String issuccess = "0";
        String json = null;
        String str = null;
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest requst = ServletActionContext.getRequest();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        response.addHeader(
                "Access-Control-Allow-Headers",
                "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
        if ("POST".equals(requst.getMethod())) {
            try {
            	//打印出参数
                logger.info("----fssc query action param:" + this.userId
                        + "----" + this.busino + "------" + this.workitemid);
                BufferedReader bu = ServletActionContext.getRequest()
                        .getReader();
                str = StringUtil.bufferString(bu);
                // 调用service
                json = fsscWfsSrv.fssQueryWorkInfo(str);
                //打印出返回的json
                logger.info("----fssc query action return:" + json);
                if (json.indexOf("exceptionType") > 0) {
                	this.errorInfo = json;
                	json = "";
                }
                if (com.deppon.foss.framework.shared.util.string.StringUtil
                        .isEmpty(json)) {
                    this.errorInfo = json;
                } else {//审批成功
                    issuccess = "1";
                }

            } catch (Exception e) {
                this.errorInfo = e.getMessage();
                e.printStackTrace();
            } finally {
                // 保存数据监控
                WFSMonitorUtil.addMonitor(this.userId, "0", this.flowtype,
                        begindate, this.busino, issuccess, this.errorInfo,
                        ServletActionContext.getRequest().getSession(),
                        this.monitorService, null,str);
            }
            //返回给页面
            writeToPage(response, json);
        }
    }
	
	/**
	 * Fss报账工作流审批
	 * @author 280769 张彬
	 * @date 2015-9-14 
	 */
	public void fssApprove() {
		Date begindate = new Date();
		String issuccess = "0";
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest requst = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String str=null;
		String json="";
		if ("POST".equals(requst.getMethod())) {
            try {
                BufferedReader bu = ServletActionContext.getRequest()
                        .getReader();
                // Auditparameters audit = null;// 构建审批需要的参数
                str = StringUtil.bufferString(bu);
                //打印出参数
                logger.info("----fssc approve action param:" + str);
                if (!com.deppon.foss.framework.shared.util.string.StringUtil
                        .isEmpty(str)) {
//                    busino = JsonUtil.jsonGetValueBykey(str, "docId");
                    // 调用service
                    json = fsscWfsSrv.fssApproveWorkInfo(str);
                    if (json.indexOf("exceptionType") > 0) {
                    	errorInfo = json;
                        json = "";
                    } else {
                        String s = JsonUtil.jsonGetValueBykey(json, "type");
                        if (s != null && "1".equals(s)) {// 审批成功
                            issuccess = "1";
                        }
                        //打印出返回json
                        logger.info("============fssc approve action return:"
                                + json);
                      //打印出busino
                        logger.info("============busino approve action return:"
                                + busino);

                        errorInfo = json;
                    }
                }
                //返回给页面
                writeToPage(response, json);
            } catch (Exception e) {
                writeToPage(response, "");
                errorInfo = e.getMessage();
            } finally {
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)){
				//保存数据监控
				WFSMonitorUtil.addMonitor(this.userId, "1", this.flowtype, begindate, this.busino, 
						issuccess, this.errorInfo, ServletActionContext.getRequest().getSession(), this.monitorService,null,str);
				
			}
		}
		}
	}
	

	/**
	 * @param fsscWfsSrv the fsscWfsSrv to set
	 */
	public void setFsscWfsSrv(IFSSCWorkInfoService fsscWfsSrv) {
		this.fsscWfsSrv = fsscWfsSrv;
	}

	/**
	 * @return the monitorService
	 */
	public IMonitorService getMonitorService() {
		return monitorService;
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
	 * @param workitemid the workitemid to set
	 */
	public void setWorkitemid(String workitemid) {
		this.workitemid = workitemid;
	}

	/**
	 * @param flowtype the flowtype to set
	 */
	public void setFlowtype(String flowtype) {
		this.flowtype = flowtype;
	}

}