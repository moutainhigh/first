package com.deppon.dpm.module.wfs.server.action;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.news.server.service.ITpushNewsService;
import com.deppon.dpm.module.wfs.server.service.IApprovePeopleQueryService;
import com.deppon.dpm.module.wfs.server.service.IDWFSWorkInfoService;
import com.deppon.dpm.module.wfs.server.service.IMonitorService;
import com.deppon.dpm.module.wfs.server.service.ITaxInfoService;
import com.deppon.dpm.module.wfs.server.util.WorkFlowUtils;
import com.deppon.dpm.module.wfs.server.util.workflowStrUtil;
import com.deppon.dpm.module.wfs.server.util.monitor.WFSMonitorUtil;
import com.deppon.dpm.module.wfs.shared.domain.DepEntity;
import com.deppon.dpm.module.wfs.shared.domain.EmpEntity;
import com.deppon.dpm.module.wfs.shared.domain.TaxInfoEntity;
import com.deppon.dpm.module.wfs.shared.domain.dwfs.DwfsEntity;


/**
 * <p>ClassName: DWFS工作流查询、审批接口Action</p>
 * <p>Description: TODO</p>
 * <p>Author: 石学钢</p>
 * <p>Date: 2015-7-21</p>
 */
public class DWFSWorkInfoAction extends BaseAction{
	/*** 日志*/
	Logger logger = LoggerFactory.getLogger(DWFSWorkInfoAction.class);

	private static final long serialVersionUID = 1L;

	//工作流编号
	private String busino;

	//流程定义名称
	private String processDefName;
	
	//工作流字段
	private String processInstId;

	//报错预警、异步调用service
	public IMonitorService monitorService;

	//用户ID
	private String userId;

	//部门查询信息
	private String departmentInfo;
	//搜索id
	private String pid;
	
	/**
	 * 查询、审批Service
	 */
	private IDWFSWorkInfoService dwfsWorkInfoService;
	/**下个审批人查询*/
	private IApprovePeopleQueryService approvePeopleQueryService;
	private ITpushNewsService tpushNewsService;
	private ITaxInfoService taxInfoService;
	
	/**
	 * DWFS申请处理审批
	 */
	public void mobileWorkApprovalQuery(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		//读取post传过来的参数
		String errorInfo = "";
		String resInfo = "";
		String paramRes = "";
		String issuccess = "0";
		//读取post传过来的参数
		BufferedReader bu  = null;
		//获取审批时间
		Date begindate = new Date();
		if("POST".equals(request.getMethod())){
			try {
				bu  = request.getReader();
				resInfo = StringUtil.bufferString(bu);
				resInfo = java.net.URLDecoder.decode(resInfo, "utf-8");
				paramRes = resInfo;
				//打印出参数
				logger.info("DWFS审批接口  Jobnumbe is : "+resInfo);
				
				DwfsEntity approveEntity = JsonUtil.jsonToEntity(resInfo, DwfsEntity.class);
				//调用service
				resInfo = java.net.URLDecoder.decode(dwfsWorkInfoService.approval(resInfo), "utf-8");
				JSONObject audit=JsonUtil.parseObject(resInfo);
				//判断审批是否成功
                if (audit.containsKey("result") && "1".equals(audit.getString("result")) ) {  
                    issuccess = "1";
                    // 用线程进行信息推送
                    if (WorkFlowUtils.checkIsTaxes(processDefName)
                            && ("manualActivity3".equals(approveEntity
                                    .getCurrentActivityInstId()) || "manualActivity4"
                                    .equals(approveEntity
                                            .getCurrentActivityInstId()))) {
                        try {
                            TaxInfoEntity taxinfo = new TaxInfoEntity();
                            taxinfo.setBusino(this.busino);
                            taxinfo.setActivitydefid(approveEntity
                                    .getCurrentActivityInstId());
                            taxinfo.setFlowtype(approveEntity
                                    .getProcessDefName());
                            taxinfo.setProcessinstid(approveEntity
                                    .getProcessinstid() + "");
                            WorkFlowUtils.copyDwfsTaxEntity(approveEntity
                                    .getBussinessBean().get(0), taxinfo);
                            taxInfoService.insert(taxinfo);
                        } catch (Exception ex) {
                            logger.info("本地保存税务信息出现异常", ex);
                        }

                        // 向下一个审批人推送审批信息
                        WorkFlowUtils.workflowNextAppovePush(
                                approvePeopleQueryService, tpushNewsService,
                                processInstId);
                    }
                }
				errorInfo = resInfo;
			} catch (Exception e) {
				logger.info("审批工作流出现异常！",e);
				resInfo = "[]";
				errorInfo=e.getMessage();
				//打印出报错信息
				e.printStackTrace();
			} finally {
				logger.info("样式：" + processDefName + "——ID+" + processInstId + "——名称" + busino);
				//保存数据监控
				WFSMonitorUtil.addMonitor(this.userId, "1", this.processDefName, begindate, this.busino, 
						issuccess, errorInfo, ServletActionContext.getRequest().getSession(), this.monitorService, null,paramRes);
			}
		}
		//返回页面
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		writeToPage(response, resInfo);
	}
	
	/**
	 * DWFS查询接口
	 */
    public void mobileWorkdisposeQuery() {
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        // 获取查询时间
        Date begindate = new Date();
        // 判断查询是否成功
        String issuccess = "0";
        String errorInfo = "";
        BufferedReader bu = null;
        JSONObject paramObj = null;
        String resInfo = "";
        String paramStr = "";
        if ("POST".equals(request.getMethod())) {
            try {
                bu = request.getReader();
                String jsonStr = StringUtil.bufferString(bu);
                //打印出参数
                jsonStr = java.net.URLDecoder.decode(jsonStr, "utf-8");
                logger.info("dwfs query request param is: " + jsonStr);
                
                paramStr = jsonStr;
                paramObj = JsonUtil.parseObject(jsonStr);
              //调用service
                resInfo = this.dwfsWorkInfoService.disposeQuery(jsonStr);
                // 判断返回结果是否异常
                int excep = resInfo.indexOf("exceptionType");
                
                if (!com.deppon.foss.framework.shared.util.string.StringUtil
                        .isEmpty(resInfo) && excep < 0 && !"Read timed out".equals(resInfo)) {
                    issuccess = "1";
                    if (WorkFlowUtils.checkIsTaxes(paramObj
                            .getString("processDefName"))
                            && "manualActivity11".equals(paramObj
                                    .getString("activitydefid"))) {
                        String businoStr = paramObj.getString("busino");
                        try {
                            TaxInfoEntity taxInfo = this.taxInfoService
                                    .getWorkFlowTaxinfo(paramObj
                                            .getString(businoStr));
                            JSONObject querInfoJson = JsonUtil
                                    .parseObject(resInfo);
                            querInfoJson.put("taxInfo",
                                    JsonUtil.beanToJSONObject(taxInfo));
                            resInfo = querInfoJson.toJSONString();

                            logger.info("flowtype======>" + this.processDefName
                                    + "  busino======>" + businoStr);
                            logger.info("DWFS含有税务信息的返回JSON是: " + resInfo);
                        } catch (Exception ex) {
                            logger.info("查询税务信息出现错误: userid==> " + userId
                                    + " busino====> " + businoStr, ex);
                        }
                    }
                }

                resInfo = workflowStrUtil.replaceJsonSpecialCharacter(resInfo);
            } catch (Exception e) {
                logger.info("查询项目状态详情出现异常！", e);
                resInfo = "[]";
                errorInfo = e.getMessage();
                //打印出报错信息
                e.printStackTrace();
            } finally {
                // 保存数据监控
            	if(null!=paramObj){
                WFSMonitorUtil.addMonitor(this.userId, "0",
                        paramObj.getString("processDefName"), begindate,
                        paramObj.getString("busino"), issuccess, errorInfo,
                        ServletActionContext.getRequest().getSession(),
                        this.monitorService, null,paramStr);
            	}
            }
        }
        // 返回页面
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        response.addHeader(
                "Access-Control-Allow-Headers",
                "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
        writeToPage(response, resInfo);
    }
	/**
	 * 申报部门查询
	 */
	public void departmentNameQeury(){
		HttpServletResponse response = ServletActionContext.getResponse();
		String resInfo = "";
//		logger.info("申报部门查询"+departmentInfo+"###页码"+page);
//		Map<String, String> paramMap = new HashMap<String, String>();
//		paramMap.put("orgName", departmentInfo);
//		paramMap.put("page", page);
//		paramMap.put("limi", "100");
		try {
			//调用service
			List<DepEntity> dep= dwfsWorkInfoService.getDepList(departmentInfo);
			if(dep == null ){
			    dep = new ArrayList<DepEntity>();
			}
			resInfo = JsonUtil.listToJsonString(dep);
		} catch (Exception e) {
			logger.info("前端申报部门查询出现异常！",e);
			resInfo = "[]";
			//打印出报错信息
			e.printStackTrace();
		}
		//返回页面
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		writeToPage(response, resInfo);
	}
	//合同部门人员查询
	public void empQeury(){
		HttpServletResponse response = ServletActionContext.getResponse();
		String resInfo = "";
		try {
			//调用service
			logger.info("申报部合同部门人员查询:---"+departmentInfo);
			List<EmpEntity> emp= dwfsWorkInfoService.getEmpList(departmentInfo);
			if(emp == null ){
				emp = new ArrayList<EmpEntity>();
			}
			resInfo = JsonUtil.listToJsonString(emp);
		} catch (Exception e) {
			logger.info("人员查询出现异常！",e);
			e.printStackTrace();
			resInfo = "[]";
			//打印出报错信息
			e.printStackTrace();
		}
		//返回页面
		response.setHeader("Access-Control-Allow-Origin", "*");
		writeToPage(response, resInfo);
	}
	//系统数据变更 中 产品线数据查询
	public void systemQuery(){
		HttpServletResponse response = ServletActionContext.getResponse();
		String resInfo = "";
		try {
			//调用service
			logger.info("系统数据变更 中 产品线数据查询param:---" + departmentInfo + "---pid :" + pid);
			resInfo = dwfsWorkInfoService.getSystemList(departmentInfo,pid);
		} catch (Exception e) {
			logger.info("系统数据变更 中 产品线数据查询出现异常！",e);
			e.printStackTrace();
			resInfo = "[]";
			//打印出报错信息
			e.printStackTrace();
		}
		//返回页面
		response.setHeader("Access-Control-Allow-Origin", "*");
		writeToPage(response, resInfo);
	}

	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}
	/**
	 * @param processDefName the processDefName to set
	 */
	public void setProcessDefName(String processDefName) {
		this.processDefName = processDefName;
	}
	/**
	 * @param processInstId the processInstId to set
	 */
	public void setProcessInstId(String processInstId) {
		this.processInstId = processInstId;
	}
	/**
	 * @param monitorService the monitorService to set
	 */
	public void setMonitorService(IMonitorService monitorService) {
		this.monitorService = monitorService;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @param departmentInfo the departmentInfo to set
	 */
	public void setDepartmentInfo(String departmentInfo) {
		this.departmentInfo = departmentInfo;
	}
	/**
	 * @param tpushNewsService the tpushNewsService to set
	 */
    public void setTpushNewsService(ITpushNewsService tpushNewsService) {
        this.tpushNewsService = tpushNewsService;
    }
    /**
	 * @param dwfsWorkInfoService the dwfsWorkInfoService to set
	 */
    public void setDwfsWorkInfoService(IDWFSWorkInfoService dwfsWorkInfoService) {
        this.dwfsWorkInfoService = dwfsWorkInfoService;
    }
    /**
   	 * @param approvePeopleQueryService the approvePeopleQueryService to set
   	 */
    public void setApprovePeopleQueryService(
            IApprovePeopleQueryService approvePeopleQueryService) {
        this.approvePeopleQueryService = approvePeopleQueryService;
    }
    /**
   	 * @param taxInfoService the taxInfoService to set
   	 */
    public void setTaxInfoService(ITaxInfoService taxInfoService) {
        this.taxInfoService = taxInfoService;
    }

	/**
	 * @param pid the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
    
    
}
