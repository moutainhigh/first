package com.deppon.dpm.module.wfs.server.action;

import java.io.BufferedReader;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.news.server.service.ITpushNewsService;
import com.deppon.dpm.module.wfs.server.service.IApprovePeopleQueryService;
import com.deppon.dpm.module.wfs.server.service.IMonitorService;
import com.deppon.dpm.module.wfs.server.service.INetWorkPlanService;
import com.deppon.dpm.module.wfs.server.service.ITaxInfoService;
import com.deppon.dpm.module.wfs.server.util.WorkFlowUtils;
import com.deppon.dpm.module.wfs.server.util.workflowStrUtil;
import com.deppon.dpm.module.wfs.server.util.monitor.WFSMonitorUtil;
import com.deppon.dpm.module.wfs.server.util.monitor.WorkFlowMonitor;
import com.deppon.dpm.module.wfs.shared.domain.TaxInfoEntity;
import com.deppon.dpm.module.wfs.shared.domain.wdgh.WdghEntity;
import com.deppon.dpm.module.wfs.shared.vo.WfsMonitorVo;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * 网点规划
 * @author 251624
 *
 */
public class NetworkPlanAction extends BaseAction {
	private static final long serialVersionUID = -7038967394378413515L;
	static Logger logger = LoggerFactory.getLogger(NetworkPlanAction.class);

	/*** */
	INetWorkPlanService netWorkPlanService;
	//service
	private IMonitorService monitorService;

	/*** 工作流号 */
	String processInstId;

	/*** 流程定义名称(就是flowtype) */
	String processDefName;

	/*** 流程号 */
	String workItemId;

	/*** 审批人工号 */
	String approverCode;

	/*** 审批人名称 */
	String approverName;

	/*** 审批决策 */
	String approveOperateType;

	/*** 意见 */
	String approveOpinion;
	
	//回退节点
	String activtyId;
	//当前节点
	String activitydefid;
	//
	String busino;
	/**分页*/
	String page;
	// 错误信息 用于错误预警
	private String errorInfo;
	/**部门查询信息*/
	private String departmentInfo;
	/**下个审批人查询*/
	private IApprovePeopleQueryService approvePeopleQueryService;
	private ITpushNewsService tpushNewsService;
	private ITaxInfoService taxInfoService;

    /**
	 * 查询商铺租贷和场地租赁/转租工作流详细信息
	 */
	public void queryNetWorkPlanInfo(){
		Date begindate = new Date();
		String issuccess = "0";
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		HashMap<String, Object> retMap = new HashMap<String, Object>();

		HttpServletResponse response = ServletActionContext.getResponse();

		String shopInfo = null;
		String paramStr = "";
		try {
			WdghEntity paramEntity = new WdghEntity();
			String errorMessage = getQueryParamMap(paramEntity,"1");
			if(StringUtil.isEmpty(errorMessage)){
				paramMap.put("queryWorkFlow", paramEntity);
				paramStr = JsonUtil.beanToJsonString(paramMap);
				//调用service
				shopInfo = netWorkPlanService.queryNetWorkPlanInfo(JsonUtil.mapToJsonString(paramMap));
				if(StringUtil.isEmpty(shopInfo)){
					retMap.put("ifSuccess", false);
					logger.info("查询服务端出现错误！原因：返回结果为空。" );
					errorInfo = "查询服务端出现错误！原因：返回结果为空。" ;
				}else{
					if(!JsonUtil.isExistKey(shopInfo, "ifSuccess")){
						retMap.put("ifSuccess", false);
						logger.info("查询服务端出现错误！原因：" + shopInfo);
						errorInfo = "查询服务端出现错误！原因：" + shopInfo;
					}else{
						issuccess = "1";
						boolean taxFlag = false;
						
						//场地最后节点 manualActivity11
						if(WorkFlowUtils.siteRentFlowtype.equals(this.processDefName) 
						        && "manualActivity11".equals(activitydefid)){
						    taxFlag = true;
						}
						//商铺最后节点 manualActivity6
						if(WorkFlowUtils.storeRentFlowtype.equals(this.processDefName) 
						        && "manualActivity6".equals(activitydefid)){
						    taxFlag = true;
						}
						 if (taxFlag) {
		                        try{
		                            TaxInfoEntity taxInfo = this.taxInfoService.getWorkFlowTaxinfo(this.busino);
		                            JSONObject querInfoJson = JsonUtil.parseObject(shopInfo);
		                            querInfoJson.put("taxInfo", JsonUtil.beanToJSONObject(taxInfo));
		                            shopInfo = querInfoJson.toJSONString();
		                            
		                            logger.info("flowtype======>" + this.processDefName + "  busino======>" + this.busino);
		                            logger.info("DWFS含有税务信息的返回JSON是: " + shopInfo);
		                        }catch(Exception ex){
		                            logger.info("查询税务信息出现错误: userid==> " + userId + " busino====> " + busino,ex);
		                        }
		                 }
					}
				}
			}else{
				retMap.put("ifSuccess", false);
				logger.info("查询参数错误！原因：" + errorMessage);
				errorInfo = "查询参数错误！原因：" + errorMessage;
			}
		} catch (Exception e) {
			retMap.put("ifSuccess", false);
			//超时异常
			if(e instanceof SocketTimeoutException){
				retMap.put("isTimeOut", true);
			}

			logger.info("查询工作流信息出现异常", e);
			errorInfo = e.getMessage();
		} finally {
			//保存数据监控
			WfsMonitorVo vo = new WfsMonitorVo();
			vo.setUserId(userId);
			vo.setType("0");
			vo.setWorkflowname(processDefName);
			vo.setBegindate(begindate);
			vo.setEnddate(new Date());
			vo.setRemark(busino);
			vo.setRemark2(paramStr);
			vo.setIssuccess(issuccess);
			//			monitorService.addWfsMonitor(vo);

			WorkFlowMonitor wm = new WorkFlowMonitor();
			wm.monitorService = monitorService;
			wm.vo = vo;
			wm.errorInfo = errorInfo;
			wm.session = ServletActionContext.getRequest().getSession();

			Thread t = new Thread(wm);
			t.start();
		}

		if(!retMap.isEmpty()){
			shopInfo = JsonUtil.mapToJsonString(retMap);
		}
		
		//向画面发送数据
		response.setHeader("Access-Control-Allow-Origin", "*");
		writeToPage(response, workflowStrUtil.replaceJsonSpecialCharacter(shopInfo));
	}

	/**
	 * 审批商铺租贷和场地租赁/转租工作流信息
	 */
	public void approveNetWorkPlan(){
		Date begindate = new Date();
		String issuccess = "0";
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		//跨域设置
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		//读取post传过来的参数
        BufferedReader bu  = null;
		String result = null;
		String resInfo = "";
        if ("POST".equals(request.getMethod())) {
            try {
                bu = request.getReader();
                resInfo = com.deppon.dpm.module.common.server.util.StringUtil
                        .bufferString(bu);
                
                resInfo = java.net.URLDecoder.decode(resInfo, "utf-8");
                //打印出参数
                logger.info("approve param is: " + resInfo);
              //调用service
                result = netWorkPlanService.approve(resInfo);
                if (result == null) {
                    retMap.put("ifSuccess", false);
                    logger.info("审批服务端出现错误！原因：返回结果为空。");
                    errorInfo = "审批服务端出现错误！原因：返回结果为空。";
                }

                if (!JsonUtil.isExistKey(result, "ifSuccess")) {
                    retMap.put("ifSuccess", false);
                    logger.info("审批服务端出现错误！原因：" + result);
                    errorInfo = "审批服务端出现错误！原因：" + result;
                } else {
                    WdghEntity paramEntity = JsonUtil.jsonToEntity(JsonUtil
                            .jsonGetValueBykey(resInfo, "approveWorkFlow"),
                            WdghEntity.class);
                    if (WorkFlowUtils.checkIsTaxes(paramEntity
                            .getProcessDefName())
                            && ("manualActivity4".equals(paramEntity
                                    .getActivtyCurrentId()) || "manualActivity1"
                                    .equals(paramEntity.getActivtyCurrentId()))) {
                        try {
                            TaxInfoEntity taxinfo = new TaxInfoEntity();
                            taxinfo.setBusino(this.busino);
                            taxinfo.setActivitydefid(paramEntity
                                    .getActivtyCurrentId());
                            taxinfo.setFlowtype(paramEntity.getProcessDefName());
                            taxinfo.setProcessinstid(paramEntity
                                    .getProcessInstId() + "");
                            WorkFlowUtils.copyWdghTaxEntity(
                                    paramEntity.getObj(), taxinfo);
                            taxInfoService.insert(taxinfo);
                        } catch (Exception ex) {
                            logger.info("本地保存税务信息出现异常", ex);
                        }
                        // 向下一个审批人推送审批信息
                        WorkFlowUtils.workflowNextAppovePush(
                                approvePeopleQueryService, tpushNewsService,
                                paramEntity.getProcessInstId());
                    }
                }
                
                if(!retMap.isEmpty()){
                    result = JsonUtil.mapToJsonString(retMap);
                }
                //返回给页面
                writeToPage(response, result);
            } catch (Exception e) {
                retMap.put("ifSuccess", false);

                // 超时异常
                if (e instanceof SocketTimeoutException) {
                    retMap.put("isTimeOut", true);
                }
                    
                logger.info("审批出现异常", e);
                //打印出报错信息
                e.printStackTrace();
                errorInfo = e.getMessage();
                writeToPage(response, "0");
            } finally {
                String s = JsonUtil.jsonGetValueBykey(result, "ifSuccess");
                if (s != null && s.equals("true")) {
                    issuccess = "1";
                }
                // 保存数据监控
                WFSMonitorUtil.addMonitor(this.userId, "1",
                        this.processDefName, begindate, this.busino, issuccess,
                        this.errorInfo, ServletActionContext.getRequest()
                                .getSession(), this.monitorService, null,resInfo);
            }
        }
	}

	/**
	 * 
	 * @param paramEntity
	 * 			查询参数实体
	 * @param type
	 * 			1：查询 
	 * 			2：审批
	 * @return
	 */
	String getQueryParamMap(WdghEntity paramEntity, String type){
		//		if(!StringUtil.isEmpty(busiNo)){
		//			paramEntity.setBusiNo(busiNo);
		//		}else{
		//			return "客户唯一性编号不能为空！";
		//		}

		if(processInstId == null){
			return "工作流号不能为空！";
		}else{
			paramEntity.setProcessInstId(processInstId);
		}

		if(!StringUtil.isEmpty(processDefName)){
			paramEntity.setProcessDefName(processDefName);
		}else{
			return "流程定义名称不能为空！";
		}

		if(!StringUtil.isEmpty(approverCode)){
			paramEntity.setApproverCode(approverCode);
		}else{
			return "审批人工号不能为空！";
		}

		if(!StringUtil.isEmpty(approverName)){
			paramEntity.setApproverName(approverName);
		}else{
			return "审批人名称不能为空！";
		}

		if(workItemId == null){
			return "单据编号不能为空！";
		}else{
			paramEntity.setWorkItemId(workItemId);
		}

		//审批
		if("2".equals(type)){
			//审批决策 	0：同意	1：不同意	4：回退
			if(!StringUtil.isEmpty(approveOperateType)){
				paramEntity.setApproveOperateType(approveOperateType);
			}else{
				return "审批决策不能为空！";
			}

			//审批意见
			if(StringUtil.isEmpty(approveOpinion)){
				paramEntity.setApproveOpinion(StringUtil.EMPTY_STRING);
			}else{
				paramEntity.setApproveOpinion(approveOpinion);
			}


			if("4".equals(approveOperateType)){//4表示回退
				if(!StringUtil.isEmpty(activtyId)){
					paramEntity.setActivtyId(activtyId);
				}else{
					return "回退节点不能为空!";
				}
			}
		}

		return "";
	}
	/**
	 * 申报部门查询
	 */
	public void departmentNameQeury(){
		HttpServletResponse response = ServletActionContext.getResponse();
		String resInfo = "";
		logger.info("申报部门查询" + departmentInfo + "###页码"+page);
		int pages = Integer.parseInt(page);
		//分页 开始
		int start = (pages - 1) * 10;
		//分页 结束
		int end = pages * 10 - 1;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", departmentInfo);
		paramMap.put("start", start);
		paramMap.put("limit", end);
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("queryDeclareDepart", paramMap);
		try {
			//调用service
			resInfo=netWorkPlanService.departmentQeury(param);
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
	 * @param netWorkPlanService the netWorkPlanService to set
	 */
	public void setNetWorkPlanService(INetWorkPlanService netWorkPlanService) {
		this.netWorkPlanService = netWorkPlanService;
	}

	/**
	 * @param monitorService the monitorService to set
	 */
	public void setMonitorService(IMonitorService monitorService) {
		this.monitorService = monitorService;
	}

	/**
	 * @param processInstId the processInstId to set
	 */
	public void setProcessInstId(String processInstId) {
		this.processInstId = processInstId;
	}

	/**
	 * @param processDefName the processDefName to set
	 */
	public void setProcessDefName(String processDefName) {
		this.processDefName = processDefName;
	}

	/**
	 * @param workItemId the workItemId to set
	 */
	public void setWorkItemId(String workItemId) {
		this.workItemId = workItemId;
	}

	/**
	 * @param approverCode the approverCode to set
	 */
	public void setApproverCode(String approverCode) {
		this.approverCode = approverCode;
	}

	/**
	 * @param approverName the approverName to set
	 */
	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}

	/**
	 * @param approveOperateType the approveOperateType to set
	 */
	public void setApproveOperateType(String approveOperateType) {
		this.approveOperateType = approveOperateType;
	}

	/**
	 * @param approveOpinion the approveOpinion to set
	 */
	public void setApproveOpinion(String approveOpinion) {
		this.approveOpinion = approveOpinion;
	}

	/**
	 * @param activtyId the activtyId to set
	 */
	public void setActivtyId(String activtyId) {
		this.activtyId = activtyId;
	}

	/**
	 * @param activitydefid the activitydefid to set
	 */
	public void setActivitydefid(String activitydefid) {
		this.activitydefid = activitydefid;
	}

	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}

	/**
	 * @param departmentInfo the departmentInfo to set
	 */
	public void setDepartmentInfo(String departmentInfo) {
		this.departmentInfo = departmentInfo;
	}

	/**
	 * @param approvePeopleQueryService the approvePeopleQueryService to set
	 */
	public void setApprovePeopleQueryService(
			IApprovePeopleQueryService approvePeopleQueryService) {
		this.approvePeopleQueryService = approvePeopleQueryService;
	}

	/**
	 * @return the tpushNewsService
	 */
	public ITpushNewsService getTpushNewsService() {
		return tpushNewsService;
	}

	/**
	 * @param tpushNewsService the tpushNewsService to set
	 */
	public void setTpushNewsService(ITpushNewsService tpushNewsService) {
		this.tpushNewsService = tpushNewsService;
	}

	/**
	 * @return the taxInfoService
	 */
	public ITaxInfoService getTaxInfoService() {
		return taxInfoService;
	}

	/**
	 * @param taxInfoService the taxInfoService to set
	 */
	public void setTaxInfoService(ITaxInfoService taxInfoService) {
		this.taxInfoService = taxInfoService;
	}

}
