package com.deppon.montal.module.workitems.webservice.client;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Holder;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.log4j.Logger;

import com.deppon.esb.header.ESBHeader;
import com.deppon.esb.utils.EsbHeaderData;
import com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain.Auditparameters;
import com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain.WorkflowBusinessData;
import com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain.WorkflowSecondEntity;
import com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.CommException;
import com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.IMobileSecondWorkflowService;
import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.util.InitDataServlet;

public class LSP_ESBWorkItemServiceClientSecond {
	private static Logger logger = Logger.getLogger(LSP_ESBWorkItemServiceClient.class); 
	
	//后勤系统的接口地址
	public static String LSP_WEBSERVICES_LINK2;
	//后勤在esb中注册的查询的编码
	public static String LSP_ESBCODE_SEARCH2;
	//后勤在esb中注册的审批的编码
	public static String LSP_ESBCODE_APPROVE2;
	public static IMobileSecondWorkflowService client2 = null;
	private static LSP_ESBWorkItemServiceClientSecond obj;
	private LSP_ESBWorkItemServiceClientSecond(){}
	public static LSP_ESBWorkItemServiceClientSecond getLSP_ESBWorkItemServiceClient(){
		if (obj == null){
			obj =  new LSP_ESBWorkItemServiceClientSecond();
			LSP_WEBSERVICES_LINK2 = InitDataServlet.getValue("lsp_esb_ws_link2");
			LSP_ESBCODE_SEARCH2 = InitDataServlet.getValue("lsp_esbCode_search2");
			LSP_ESBCODE_APPROVE2 = InitDataServlet.getValue("lsp_esbCode_approve2");
			//FSSC_WEBSERVICES_LINK = "http://10.224.65.122:8881/claim/webservice/MobileFsscService";
			client2 = getClient();
		}
		return obj;
	}
	
	/**
	 * 调用后勤接口，返回查询实体
	 * @param params
	 * @return
	 */
	public WorkflowSecondEntity getLSPEntity (Map<String,String> params) {
		
		/**
		 * 封装头信息
		 * */
		Holder<ESBHeader> esbHeader = EsbHeaderData.setEsbHeaderData("1.0.0",params.get("busino"), LSP_ESBCODE_SEARCH2);
	
		/**
		 * 封装消息体
		 * */
		WorkflowBusinessData workflowInfoRequest = new WorkflowBusinessData();
		workflowInfoRequest.setWorkflowNumber(params.get("busino"));
		workflowInfoRequest.setEmpCode(params.get("empCode"));
		workflowInfoRequest.setEmpName(params.get("empName"));
	    
		/**
		 * 调用远程方法，获取返回值
		 * */
		WorkflowSecondEntity workflowInfo = new WorkflowSecondEntity();;
		try {
			workflowInfo = client2.queryWorkflowInfo(workflowInfoRequest, esbHeader);
		} catch (CommException e) {
			logger.error("后勤第二个接口-查询接口调用异常" + e.getMessage(),e);
		}
		return workflowInfo;
	}
	//调用后勤审批
	
	public int approvalLSPWorkflow (Map<String,String> reqPara,String userId,String empName) {
		/**
		 * 存取返回值结果
		 */
		int result = 0;
		
		/**
		 * 封装消息体
		 * */
		Auditparameters audit = new Auditparameters();
		audit.setWfInstanceId(Long.parseLong(reqPara.get("processinstidDLSP")));//流程号
		audit.setWfState(reqPara.get("activityIdDLSP"));//当前活动的流程定义id
		audit.setWfWorkItemId(Long.parseLong(reqPara.get("workitemidDLSP")));//工作项定义id
		String busino = reqPara.get("businoDLSP");
		audit.setDocId(busino);//业务编号
		String options = "";
		try {
			options = new String(reqPara.get("opinionsLSP").getBytes("utf-8"), "utf-8");
		} catch (UnsupportedEncodingException e2) {
			logger.error("字节转换异常" + e2.getMessage(),e2);
		}
		audit.setAuditAdvise(options);//审批意见
		audit.setDecisionState(reqPara.get("decisionDLSP"));//审批决策
		audit.setEmpCode(userId);//登录的审批人工号
		audit.setEmpName(empName);//登录的审批人姓名
		
		/**
		 * 封装头信息
		 * */
		Holder<ESBHeader> esbHeader = EsbHeaderData.setEsbHeaderData("1.0.0",busino, LSP_ESBCODE_APPROVE2);
		
		try {
			result = client2.workflowApprove(audit, esbHeader);
		}catch (CommException e) {
			logger.error("后勤审批的第二个接口调用异常" + e.getMessage(),e);
		}
		/**
		 * 返还返回值
		 */
		return result;
	}
	
	public static IMobileSecondWorkflowService getClient() {
		/**
		 * 初始化cxf客户端
		 * */
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		/**
		 * 设置访问服务器端的指定接口
		 */
		factory.setServiceClass(IMobileSecondWorkflowService.class);
		/**
		 *  设置访问的服务的地址
		 */
		factory.setAddress(LSP_WEBSERVICES_LINK2);
		/**
		 * 创建远程对象，以供远程调用
		 */
		client2 = (IMobileSecondWorkflowService)factory.create();
		
		return client2;
	}

	/**
	 * 下面的方法是为了获得工作流是那个批次的，不同批次调用的接口不同
	 * @param processDefName
	 * @return
	 */
	public static String getBatch(String processDefName){
		Map<String,String> lspWorkFlowSet = F_Constants.lspWorkFlowSet;
		for (Map.Entry<String, String> entry:lspWorkFlowSet.entrySet()) {
			if (entry.getKey().equals(processDefName)) {
				return entry.getValue();
			}
		}
		return "0";
	}
	public static Map<String,String> lspWorkFlowNameSet = new HashMap<String,String> () {{
		   //工程寻源申请单
		   put("com.deppon.bpms.module.lsp.bpsdesign.projects.projectSearchSource", "工程寻源申请单");
		   //企划设计-非库非固分购
		   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.layoutDesignFGou", "企划设计-非库非固分购");
		   //企划设计-非库非固统购
		   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.layoutDesignTGou", "企划设计-非库非固统购");
		   //日常物资-非库固定大型设备、
		   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsNotStockFixBigDevice", "日常物资-非库固定大型设备");
		   //日常物资-库存非固统购
		   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsStockNotFixTGou", "日常物资-库存非固统购");
		   //日常物资-库存固定
		   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsStockFix", "日常物资-库存固定");
		   //日常物资-库存非固分购、
		   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsStockNotFixFGou", "日常物资-库存非固分购");
		   //日常物资-非库固定统购
		   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsNotStockFixTGou", "日常物资-非库固定统购");
		   //日常物资-非库固定分购、
		   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsNotStockFixFGou", "日常物资-非库固定分购");
		   //日常物资-非库非固统购、
		   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsNotStockNotFixTGou", "日常物资-非库非固统购");
		   //日常物资-非库非固汽配统购
		   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsNotStockNotFixCarTGou", "日常物资-非库非固汽配统购");
		   //日常物资-非库非固汽配分购
		   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsNotStockNotFixCarFGou", "日常物资-非库非固汽配分购");
		   //日常物资-非库非固分购
		   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsNotStockNotFixFGou", "日常物资-非库非固分购");
	}};
	public static String getWorkflowName(String processDefName){
		Map<String,String> lspWorkFlowSet = LSP_ESBWorkItemServiceClientSecond.lspWorkFlowNameSet;
		for (Map.Entry<String, String> entry:lspWorkFlowSet.entrySet()) {
			if (entry.getKey().equals(processDefName)) {
				return entry.getValue();
			}
		}
		return "";
	}
}
