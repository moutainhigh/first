package com.deppon.dpm.module.wfs.server.action;

import java.io.BufferedReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
import com.deppon.dpm.module.wfs.server.dao.IMonitorDao;
import com.deppon.dpm.module.wfs.server.service.IApprovePeopleQueryService;
import com.deppon.dpm.module.wfs.server.service.IDLspWorkInfoService;
import com.deppon.dpm.module.wfs.server.service.IMonitorService;
import com.deppon.dpm.module.wfs.server.service.IQueryEmployeeInfoService;
import com.deppon.dpm.module.wfs.server.service.ITaxInfoService;
import com.deppon.dpm.module.wfs.server.util.WorkFlowUtils;
import com.deppon.dpm.module.wfs.server.util.workflowStrUtil;
import com.deppon.dpm.module.wfs.server.util.monitor.WFSMonitorUtil;
import com.deppon.dpm.module.wfs.shared.domain.TaxInfoEntity;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowBusinessData;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowNewMonitorEntity;
import com.deppon.dpm.module.wfs.shared.domain.dlsp.TaxDlspEntity;

/**
 * 固定资产盘点的工作流
 * 
 * @version
 */
public class DLspWorkInfoAction extends BaseAction {
	/** 
	*
	*/
	private static final long serialVersionUID = 1397420409043898745L;
	private static Logger logger  = LoggerFactory.getLogger(DLspWorkInfoAction.class);

	/**
	 * service
	 */
	private IDLspWorkInfoService dlspWfsSrv;
	//service
	private IMonitorService monitorService;
	//service
	private ITpushNewsService tpushNewsService;
	//service
    private IApprovePeopleQueryService approvePeopleQueryService;
    //service
    private ITaxInfoService taxInfoService;
    //员工信息
  	private IQueryEmployeeInfoService employeeService;
  	//监控日志
  	private IMonitorDao monitordao;
	private String empName;
	// 工作流单据号
	private String busino;
	//流程定义名称
	private String flowtype;
	//当前活动定义ID
	private String activitydefid;
	//requestId
	private String wfInstanceId;
	//审批操作
	private String decisionState;
	//审批意见
	private String auditAdvise;
	//工作项Id
//	private String wfWorkItemId;
	//工号等级
  	private String joblevel;
	// 错误信息 用于错误预警
    private String errorInfo;
	/**部门查询信息*/
	private String departmentInfo;
	/**页码*/
	private String page;
	//资产编码
	//private String assetsType;
	//资产名称
	//private String assetsName;
	//所属子公司
	//private String companyName;
	/**
	 * 盘点单详情 根据审批流程中任一人的工号，姓名，工作流单据号 使用restful的方式进行接口调用
	 * 
	 * @author 195406 高春玲
	 * @date 2015-4-2 下午1:45:08
	 * @see
	 */
	public void queryWorkInfo() {
		Date begindate = new Date();
		String issuccess = "0";
		String paramStr = "";
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("Access-Control-Allow-Origin", "*");
			//打印出参数
			logger.info("----lsp query action param:" + this.userId + "----" + this.empName + "---" + this.busino);
			//给实体赋值
			WorkflowBusinessData workflowInfo = new WorkflowBusinessData(
					this.userId, this.empName, this.busino);
			paramStr = JsonUtil.beanToJsonString(workflowInfo);
			// 调用接口
			String json = dlspWfsSrv.queryWorkInfo(workflowInfo);
			int excep = json.indexOf("exceptionType");
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(json) && excep < 0) {
                issuccess = "1";
                json = workflowStrUtil.replaceJsonSpecialCharacter(json);
                if (WorkFlowUtils.checkIsTaxes(this.flowtype)) {
                    if ("manualActivity8".equals(activitydefid)
                            || "manualActivity18".equals(activitydefid)
                            || "manualActivity26".equals(activitydefid)
                            || "manualActivity28".equals(activitydefid)) {

                        try {
                            TaxInfoEntity taxInfo = this.taxInfoService
                                    .getWorkFlowTaxinfo(this.busino);
                            JSONObject querInfoJson = JsonUtil.parseObject(json);
                            querInfoJson.put("taxInfo", JsonUtil.beanToJSONObject(taxInfo));
                            json = querInfoJson.toJSONString();

                            logger.info("flowtype======>" + this.flowtype
                                    + "  busino======>" + this.busino);
                            logger.info("DWFS含有税务信息的返回JSON是: " + json);
                        } catch (Exception ex) {
                            logger.info("查询税务信息出现错误: userid==> " + userId
                                    + " busino====> " + busino, ex);
                        }
                    }
                }
               
            }
			//打印出返回的json
			logger.info("----lsp query action return:" + excep + "============" + json);
			//返回给页面
			writeToPage(response, json);
			errorInfo = json;
		} catch (Exception e) {
			errorInfo = e.getMessage();
			//打印出报错信息
			e.printStackTrace();
		} finally {
			//保存数据监控
			WFSMonitorUtil.addMonitor(this.userId, "0", this.flowtype, begindate, this.busino, 
					issuccess, this.errorInfo, ServletActionContext.getRequest().getSession(), this.monitorService, null,paramStr);
		}
	}

	/**
	 * 工作流审批
	 */
	public void approveWorkInfo() {
		Date begindate = new Date();
		String issuccess = "0";
		long startTime = 0;    //获取DPM开始时间
		long endTime = 0;    //获取DPM结束时间
		long startTime1 = 0;    //获取开始时间
		long endTime1 = 0;    //获取结束时间
		long resultTime = 0;    //获取总时长
		String json="";
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String str = null;
        if ("POST".equals(request.getMethod())) {
            try {
            	//获取DPM开始时间
    			startTime = System.currentTimeMillis();
                BufferedReader bu = request.getReader();
               // Auditparameters audit = null;// 构建审批后勤需要的参数
                str = StringUtil.bufferString(bu);
                JSONObject audit=null;
                str = java.net.URLDecoder.decode(str, "utf-8");
                //打印出参数
                logger.info("============lsp approve action param:" + str);
                if (!com.deppon.foss.framework.shared.util.string.StringUtil
                        .isEmpty(str)) {
                    audit = JSONObject.parseObject(str);
                   /* audit.setEmpName(java.net.URLDecoder.decode(
                            audit.getEmpName(), "utf-8"));*/
                   // logger.info(audit.getEmpName() + "==姓名");
                    busino = audit.getString("docId");
                    wfInstanceId = audit.getString("wfInstanceId");
                    decisionState = audit.getString("decisionState");
                    auditAdvise = audit.getString("auditAdvise");
                   // logger.info("输出的工作流号" + audit.getDocId());
                    //获取开始时间
    				startTime1 = System.currentTimeMillis();
    				//调用service
                    json = dlspWfsSrv.approveWorkInfo(audit);
                    //获取结束时间
    	            endTime1 = System.currentTimeMillis();    
    				logger.info("DLsp老工作流审批（方法） - 程序运行时间  - 后台：" + (endTime1 - startTime1) + "ms");
                    if (json != null && json.equals("1")) {// 审批成功
                        issuccess = "1";
                        errorInfo = json;
                        logger.info("======lsp approve action return success:" + json);
                        if (WorkFlowUtils.checkIsTaxes(flowtype) 
                           && "manualActivity1".equals(audit.getString("wfState"))) {
                            try{
                                TaxInfoEntity taxinfo = new TaxInfoEntity();
                                taxinfo.setBusino(this.busino);
                                taxinfo.setActivitydefid(audit.get("wfState").toString());
                                taxinfo.setBusino(audit.getString("docId"));
                                taxinfo.setFlowtype(flowtype);
                                taxinfo.setProcessinstid(audit.getString("wfInstanceId") + "");
                                
                                WorkFlowUtils.copyDlspTaxEntity(JsonUtil.jsonToEntity(audit.getJSONObject("obj").toString(),TaxDlspEntity.class), taxinfo);
                                taxInfoService.insert(taxinfo);
                            }catch(Exception ex){
                                logger.info("本地保存税务信息出现异常", ex);
                            }
                            //向下一个审批人推送审批信息
                            WorkFlowUtils.workflowNextAppovePush(approvePeopleQueryService, 
                                    tpushNewsService, 
                                    audit.getString("wfInstanceId"));
                        }
                    }else{
                    	issuccess = "0";
                    	errorInfo = json;
                    	json = "";
                        logger.info("======lsp approve action return error:" + json);
                    }
                    //返回给页面
                    writeToPage(response, json);
                    //获取DPM结束时间
                    endTime = System.currentTimeMillis();
                    resultTime = endTime - startTime;
            		logger.info("DLsp老工作流审批（总时间） - 程序运行时间  - 后台：" + resultTime + "ms");
                }
            } catch (Exception e) {
                writeToPage(response, "0");
                errorInfo = e.getMessage();
            } finally {
                if (!com.deppon.foss.framework.shared.util.string.StringUtil
                        .isEmpty(str)) {
                    // 保存数据监控
                    WFSMonitorUtil.addMonitor(this.userId, "1", this.flowtype,
                            begindate, this.busino, issuccess, this.errorInfo,
                            ServletActionContext.getRequest().getSession(),
                            this.monitorService, null,str);
                    //审批人 等级
                	joblevel = employeeService.getJoblevel(userId);
                    /**
					 * 封装监控实体数据
					 */
					WorkflowNewMonitorEntity wmEntity = new WorkflowNewMonitorEntity();
					wmEntity.setUserId(userId);
					wmEntity.setJobLevel(joblevel);
					wmEntity.setWorkflowId(busino);
					wmEntity.setRequestId(wfInstanceId);
					//可能包含两条工作流 用,分开截取前面的一天  字段长度有限
					if(flowtype.contains(",")){
						int index=flowtype.indexOf(",");
						String flowtypeBefore=flowtype.substring(0,index);
//						String after=flowtype.substring(index+1);
						wmEntity.setWorkflowName(flowtypeBefore);
					}else{
						wmEntity.setWorkflowName(flowtype);
					}
					wmEntity.setSysCode("DLSP-后勤(old)");
					wmEntity.setStatus("old");
					wmEntity.setApprovalOption(decisionState);
					wmEntity.setRemark(auditAdvise);
					wmEntity.setResult(issuccess);
					wmEntity.setIsSuccess(Integer.parseInt(issuccess));
					wmEntity.setData(json);
					wmEntity.setErrorInfo(errorInfo);
					wmEntity.setInterfaceName("approveWorkInfo");
					wmEntity.setRejectNode("");
					wmEntity.setCreateTime(begindate);
					wmEntity.setMethodTime(String.valueOf(resultTime));
					wmEntity.setFileDocId("");
					wmEntity.setFileName("");
					wmEntity.setFilePath("");
					wmEntity.setFileOpenCount(0);
					wmEntity.setUi_type("");
					wmEntity.setRemark1("");
					wmEntity.setRemark2("");
					wmEntity.setRemark3("");
					
					//VP 及 普通用户的 成功/失败信息 都先存到新工作流监控表
					if(userId !=null && joblevel != null && issuccess!=null){
						monitordao.insertApprovalEntityNewMonitor(wmEntity);
					}
                }
            }
        }
	}
	/**
	 * @author 280769
	 * @date 2016-4-22
	 * 资产查询
	 */
	public void assetsQeury(){
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String resInfo = "";
		String str=null;
        if ("POST".equals(request.getMethod())) {
		try {
			
			BufferedReader bu = request.getReader();
			//取值
			str = StringUtil.bufferString(bu);
			//打印参数
			logger.info("资产查询-----"+str);
			str = java.net.URLDecoder.decode(str, "utf-8");
		   if (!com.deppon.foss.framework.shared.util.string.StringUtil
                      .isEmpty(str)) {
			JSONObject audit = null;
			//转换json
			audit = JSONObject.parseObject(str);
			//打印参数
			logger.info("资产查询-----"+audit);
			//调用service
			resInfo = dlspWfsSrv.assetsQeury(audit);
			//打印返回值
			logger.info("资产查询结果"+resInfo);
			  }
		} catch (Exception e) {
			logger.info("资产查询查询出现异常！",e);
			resInfo = "[]";
			e.printStackTrace();
		}
		//返回页面
		response.setHeader("Access-Control-Allow-Origin", "*");
		writeToPage(response, resInfo);
        }
	}
	/**
	 * 部门code查询
	 */
	public void deptCodeQuery(){
		HttpServletResponse response = ServletActionContext.getResponse();
		String resInfo = "";
		logger.info("部门code查询"+this.userId);
		try {
			//调用service
			resInfo = dlspWfsSrv.deptCodeQuery(this.userId);
			logger.info("部门查询结果"+resInfo);
		} catch (Exception e) {
			logger.info("前端部门查询出现异常！",e);
			resInfo = "[]";
			e.printStackTrace();
		}
		//返回页面
		response.setHeader("Access-Control-Allow-Origin", "*");
		writeToPage(response, resInfo);
	}
	/**
	 * 申报部门查询
	 */
	public void departmentNameQeury(){
		HttpServletResponse response = ServletActionContext.getResponse();
		String resInfo = "";
		logger.info("申报部门查询"+departmentInfo+"###页码"+page);
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("deptName", departmentInfo);
		paramMap.put("page", page);
		try {
			//调用service
			resInfo = dlspWfsSrv.departmentQeury(paramMap);
			logger.info("部门查询结果"+resInfo);
		} catch (Exception e) {
			logger.info("前端申报部门查询出现异常！",e);
			resInfo = "[]";
			e.printStackTrace();
		}
		
		//返回页面
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		writeToPage(response, resInfo);
	}

	/**
	 * @param dlspWfsSrv the dlspWfsSrv to set
	 */
	public void setDlspWfsSrv(IDLspWorkInfoService dlspWfsSrv) {
		this.dlspWfsSrv = dlspWfsSrv;
	}
	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}
	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @param flowtype the flowtype to set
	 */
	public void setFlowtype(String flowtype) {
		this.flowtype = flowtype;
	}
	/**
	 * @param monitorService the monitorService to set
	 */
	public void setMonitorService(IMonitorService monitorService) {
		this.monitorService = monitorService;
	}
	/**
	 * @param departmentInfo the departmentInfo to set
	 */
	public void setDepartmentInfo(String departmentInfo) {
		this.departmentInfo = departmentInfo;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}
	/**
	 * @param tpushNewsService the tpushNewsService to set
	 */
    public void setTpushNewsService(ITpushNewsService tpushNewsService) {
        this.tpushNewsService = tpushNewsService;
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
   	 * @param activitydefid the activitydefid to set
   	 */
    public void setActivitydefid(String activitydefid) {
        this.activitydefid = activitydefid;
    }

	public String getJoblevel() {
		return joblevel;
	}

	public void setJoblevel(String joblevel) {
		this.joblevel = joblevel;
	}

	public IQueryEmployeeInfoService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(IQueryEmployeeInfoService employeeService) {
		this.employeeService = employeeService;
	}

	public IMonitorDao getMonitordao() {
		return monitordao;
	}

	public void setMonitordao(IMonitorDao monitordao) {
		this.monitordao = monitordao;
	}

	public String getWfInstanceId() {
		return wfInstanceId;
	}

	public void setWfInstanceId(String wfInstanceId) {
		this.wfInstanceId = wfInstanceId;
	}

	public String getDecisionState() {
		return decisionState;
	}

	public void setDecisionState(String decisionState) {
		this.decisionState = decisionState;
	}

	public String getAuditAdvise() {
		return auditAdvise;
	}

	public void setAuditAdvise(String auditAdvise) {
		this.auditAdvise = auditAdvise;
	}

	/*public String getWfWorkItemId() {
		return wfWorkItemId;
	}

	public void setWfWorkItemId(String wfWorkItemId) {
		this.wfWorkItemId = wfWorkItemId;
	}*/

	public String getBusino() {
		return busino;
	}

	public String getActivitydefid() {
		return activitydefid;
	}
    
	/**
	 * @param assetsType the assetsType to set
	 */
	/*public void setAssetsType(String assetsType) {
		this.assetsType = assetsType;
	}*/

	/**
	 * @param assetsName the assetsName to set
	 */
	/*public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}*/

	/**
	 * @param companyName the companyName to set
	 */
	/*public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}*/
}