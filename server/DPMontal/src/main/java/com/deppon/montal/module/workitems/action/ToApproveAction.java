package com.deppon.montal.module.workitems.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.acms.domain.SyncWorkflowinfoRequest;
import com.deppon.dpm.module.acms.domain.SyncWorkflowinfoResponse;
import com.deppon.esb.header.ESBHeader;
import com.deppon.esb.utils.EsbHeaderData;
import com.deppon.fins.esb.mobile.domain.InitWorkFlowViewDataRequest;
import com.deppon.fins.esb.mobile.domain.InitWorkFlowViewDataResponse;
import com.deppon.fins.esb.mobile.mobileservice.IFinsMobileService;
import com.deppon.fssc.module.claimsupport.shared.vo.WfParamVo;
import com.deppon.fssc.module.remote.mobile.service.MobileFsscEntity;
import com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ComUtil;
import com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.WorkflowBusinessData;
import com.deppon.lsp.module.mobileworkflow.server.service.Auditparameters;
import com.deppon.lsp.module.mobileworkflow.server.service.PayApplyWorkflowData;
import com.deppon.lsp.module.mobileworkflow.server.service.WorkflowData;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity;
import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.conf.Constants;
import com.deppon.montal.conf.DictEntryService;
import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.conf.domain.WorkflowInfo;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.login.service.SSOLogonService;
import com.deppon.montal.login.service.UserLoginService;
import com.deppon.montal.model.OAMuchRecompensate;
import com.deppon.montal.model.OAOvertimeApply;
import com.deppon.montal.model.OAYardrentApply;
import com.deppon.montal.model.OaContractAdd;
import com.deppon.montal.model.OaContractApply;
import com.deppon.montal.model.OaPersonAdd;
import com.deppon.montal.model.OaPersonAddEntry;
import com.deppon.montal.module.crm.damin.QueryWorkflowInfoRequest;
import com.deppon.montal.module.crm.damin.QueryWorkflowInfoResponse;
import com.deppon.montal.module.crm.serivce.CommException;
import com.deppon.montal.module.crm.serivce.IDpmToCrmService;
import com.deppon.montal.module.workitems.dao.AssessreduceApplyDao;
import com.deppon.montal.module.workitems.dao.DisCountApplyDao;
import com.deppon.montal.module.workitems.dao.IAssessreduceApplyDao;
import com.deppon.montal.module.workitems.dao.IDisCountApplyDao;
import com.deppon.montal.module.workitems.dao.ILessonApplyDao;
import com.deppon.montal.module.workitems.dao.IMarketingActivitiesDao;
import com.deppon.montal.module.workitems.dao.IOADataRequireApplyDao;
import com.deppon.montal.module.workitems.dao.IOAPersonelimPowerDao;
import com.deppon.montal.module.workitems.dao.ISitedesignDao;
import com.deppon.montal.module.workitems.dao.LessonApplyDao;
import com.deppon.montal.module.workitems.dao.MarketingActivitiesDao;
import com.deppon.montal.module.workitems.dao.OADataRequireApplyDao;
import com.deppon.montal.module.workitems.dao.OAPersonelimPowerDao;
import com.deppon.montal.module.workitems.dao.SitedesignDao;
import com.deppon.montal.module.workitems.service.*;
import com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient;
import com.deppon.montal.module.workitems.webservice.client.FSSCWorkItemServiceClient;
import com.deppon.montal.module.workitems.webservice.client.LSPWorkItemServiceClient;
import com.deppon.montal.module.workitems.webservice.client.LSP_ESBWorkItemServiceClient;
import com.deppon.montal.module.workitems.webservice.client.LSP_ESBWorkItemServiceClientSecond;
import com.deppon.montal.module.workitems.webservice.client.OtherSysWorkItemClient;
import com.deppon.montal.util.Base64;
import com.deppon.montal.util.InitDataServlet;
import com.deppon.montal.util.RestfulUtil;
import com.deppon.montal.util.WFUtil;
import com.deppon.nhr.module.remote.dpm.service.WorkFlowToDPMService;
import com.deppon.wdgh.inteface.domain.IDpmToWdghService;
import com.deppon.wfs.workflow.domain.CourseDevelopUpdateAuditBean;
import com.deppon.wfs.workflow.service.IWFDetailApplyService;
import com.deppon.wfs.workflow.service.WFDetailApplyServiceImpl;

/**
 * @Title: ApproveAction.java
 * @Package com.deppon.montal.module.todolist.server.action
 * @Description:(查看工作流详细审批页面)
 * @author 廖建雄
 * @date 2013-1-30 上午9:02:29
 * @version V1.0
 */
public class ToApproveAction extends AppDelegateAction {
	private static Logger logger = Logger.getLogger(ToApproveAction.class);
	private static final long serialVersionUID = 6713309515119127016L;
	//当前节点activityinstid
	private String acdefid = null;
	private UserLoginService loginService = new UserLoginService();
	@Override
	protected void response() {
		
		IWorkItemsService workItemService = new WorkItemsService();
		Date begindate=new Date();
		String userId="";
		//工作流类别
		String flowtype="";
		String busino="";
		String errorInfo="";
		String issuccess="0";
		try {
			
			String version = reqPara.get("version");
			logger.info(version+"==version===============");
			
			if(version!=null&&version.equals("new")){
				userinfocheck(reqPara.get("userinfo"));
				request.getSession().setAttribute("version", version);
			}
			
			String workId = reqPara.get("workId");
			//工作流类别
			flowtype = reqPara.get("type");			
			//业务ID
			busino = reqPara.get("busino");
			//工作项ID
			String workitemid = reqPara.get("workitemid");
			//来源
			String syscode = reqPara.get("syscode")==null?F_Constants.DIPOA_WORKFLOW_SYSCODE:reqPara.get("syscode");
//			String syscode = "DWFS";
			// 获取UI标记
			String ui_type = reqPara.get("ui_type");
			//判断是否是APP
			String app_ui = reqPara.get("app_ui");
			// 活动定义ID
			String activitydefid = reqPara.get("activitydefid");
			acdefid = activitydefid;
			// 活动实例ID
			String activityinstid = reqPara.get("activityinstid");
			//获取用户信息
			LoginUser login = (LoginUser)getUserRedisService().getFromRedisBySession(getSessionId());
			//获取当前登录人的工号
			userId = login.getUserId();
			//供数据监控审批时使用 6.4
			request.getSession().setAttribute("newflowtype", flowtype);
			request.getSession().setAttribute("newbusino", busino);
			//是否为原OA工作流
			if(syscode.equals(F_Constants.DIPOA_WORKFLOW_SYSCODE)){
				if (workId != null && flowtype != null) {
					if (flowtype.equals(F_Constants.PERSONADD_TYPE)) {// 增补员申请
						Map<Object, Object> map = workItemService.getPersonAddInfo(workId);
						OaPersonAdd padd = (OaPersonAdd) map.get("personAdd");
						List<OaPersonAddEntry> penteyList = (List<OaPersonAddEntry>) map.get("personList");
						request.setAttribute("personAdd", padd);
						request.setAttribute("pentryList", penteyList);
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_HIDE);
					}else if (flowtype.equals(F_Constants.LEAVE_TYPE)) {// 请假调休
						Map map = workItemService.getLeaveWorkFlowApplyById(workId);
						request.setAttribute(Constants.PAGE_RESULT,
								map.get("leaveApplyInfo"));
						request.setAttribute("detailList", map.get("detailList"));
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_SHOW);
					} else if (flowtype.equals(F_Constants.RESIGN_TYPE)) {// 离职申请
						request.setAttribute(Constants.PAGE_RESULT,
								workItemService.getResingWorkFlowApplyById(workId));
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_SHOW);
					} else if (flowtype.equals(F_Constants.FILEPUBLISH_TYPE)) {// 文件发布申请
						request.setAttribute("filepublish",
								workItemService.getFilePublishInfo(workId));
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_SHOW);
					} else if (flowtype.equals(F_Constants.CONTRACTSIGN_TYPE)) {// 合同签订
						request.setAttribute("contractApply",
								workItemService.getContractSignInfo(workId));
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_SHOW);
					} else if (flowtype.equals(F_Constants.CLAIMS_TYPE)) {// 常规理赔
						Map map = workItemService
								.getClaimsWorkFlowApplyById(workId);
						request.setAttribute("claims", map.get("claims"));
						request.setAttribute("description", map.get("description"));
						request.setAttribute("deptexpenses",
								map.get("deptexpenses"));
						request.setAttribute("punishment", map.get("punishment"));
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_HIDE);
					} else if (flowtype.equals(F_Constants.CONTRACTADD_TYPE)) {// 月结客户签订申请
						IOaContractAddService oacontractinfoService = new OaContractAddService();
						OaContractAdd oacontractAdd = oacontractinfoService
								.getContractAdd(workId);
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_HIDE);
						request.setAttribute("oacontractAdd", oacontractAdd);
					} else if (flowtype.equals(F_Constants.SYS_DATA_CHANGES)) { // 系统数据变更
						IWFSysDataChangesService service = new WFSysDataChangesService();
						request.setAttribute("detailList",
								service.getSysDataChangesDetail(workId));
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_SHOW);
					} else if (flowtype.equals(F_Constants.RENT_CAR_OUTSIDES)) {// 付款单——外请车
						IPorentCarOutsideService service = new PorentCarOutsideService();
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_HIDE);
						request.setAttribute("outsideCar",
								service.getCarOutsideInfo(workId));
					} else if (flowtype.equals(F_Constants.EXPENSE_CLAIMS)) {// 通用费用报销单
						ICCExpenseClaimsService service = new CCExpenseClaimService();
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_HIDE);
						request.setAttribute("expenseClaims",
								service.getCCExpenseClaims(workId));
	
					} else if (flowtype.equals(F_Constants.BENIFITFEE)) {// 福利费用报销申请
						ICCWelfareexpenseService service = new CCWelfareexpenseService();
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_HIDE);
						request.setAttribute("benifitFee",
								service.getCCWelfareexpense(workId));
					} else if (flowtype.equals(F_Constants.ADDATTENDANCE)) {// 补考勤申请
						IOAaddAttendanceService service = new OAaddAttendanceService();
						Map<String, Object> map = service
								.getAddAttendanceInfo(workId);
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("addAttendance",
								map.get("OAaddAttendance"));
						request.setAttribute("attendDetails",
								map.get("addAttendanceEntryList"));
					} else if (flowtype.equals(F_Constants.ONBUSINESS)) {// 出差申请
						ICCOnbusinessService service = new CCOnbusinessService();
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("CCOnbusiness",
								service.getCConOnbusiness(workId));
					} else if (flowtype.equals(F_Constants.OA_BUDGETDATAAPPLY)) {// 数据预算申请
						IOaBudgetdataApplyService service = new OaBudgetdataApplyService();
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("OaBudgetdataApply",
								service.getOaBudgetdataApply(workId));
					} else if (flowtype.equals(F_Constants.RECOMMANDNEWEMP)) {// 新员工推荐（新）
						IRecommandnewEmpService service = new RecommandnewEmpService();
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("RecommandNewEMP",
								service.getRecommandNewEMP(workId));
					} else if (flowtype.equals(F_Constants.REALCONTRACTBORROW)) {// 实体合同借阅
						IRealcontractBorrowService service = new RealcontractBorrowService();
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_HIDE);
						request.setAttribute("OARealcontractBorrow",
								service.getOARealcontractBorrowInfo(workId));
					} else if (flowtype.equals(F_Constants.SYSTEMPOWERAPPLY)) {// 系统权限申请
						IOASystempowerApplyService service = new OASystempowerApplyService();
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("systemApply",
								service.getOASystempowerApply(workId));
					} else if (flowtype.equals(F_Constants.ENTERTAINMENTEXPENSE)) {// 应酬费用管理
						ICCEntertainmentExpenseService service = new CCEntertainmentExpenseService();
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_HIDE);
						Map<String, Object> map = service
								.getEntertainmentExpense(workId);
						request.setAttribute("expense", map.get("expense"));
						request.setAttribute("expenseEntryList",
								map.get("expenseEntryList"));
					} else if (flowtype.equals(F_Constants.DAILYPAYMENT)) {// 日常付款
						IPodailyPaymentService service = new PodailyPaymentService();
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_HIDE);
						request.setAttribute("CCPodailyPayment",
								service.getCCPodailyPaymentInfo(workId));
					} else if (flowtype.equals(F_Constants.RENT)) {// 房租
						IRentService service = new RentService();
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_HIDE);
						request.setAttribute("rent",
								service.queryRentByWorkId(workId));
					} else if (flowtype.equals(F_Constants.DATA_PROVIDE_APPLY)) {// 数据提供审批
						IDataProvideApplyService service = new DataProvideApplyService();
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("OADataProvideApply",
								service.getOADataProvideApply(workId));
					} else if (flowtype.equals(F_Constants.EMP_TRANS_APPLY)) {// 异动调动申请
						IChangeAndresignApplyService service = new ChangeAndresignApplyService();
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_HIDE);
						request.setAttribute("OAChangeAndresignApply",
								service.getOAChaApply(workId));
					} else if (flowtype.equals(F_Constants.MATERIAL_PROPERTY_APPLY)){//物资资产采购报销申请
						ICCExpenseaccountBillService   service = new CCExpenseaccountBillService();
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_HIDE);
						Map<String, Object> map = service
								.getCCExpenseaccountBill(workId);
						request.setAttribute("bill", map.get("bill"));
						request.setAttribute("billEntryList",
								map.get("billEntryList"));
					} else if (flowtype.equals(F_Constants.BENIFITFEES_NEW)){//借款-福利（新）
						ICCBobenefitsService service = new CCBobenefitsService();
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_HIDE);
						request.setAttribute("benifitfees_new", service.getCCBobenefitsByWorkId(workId));
					} else if (flowtype.equals(F_Constants.VEHICLE_PAY)){//车辆付款
						ICCPovehivlePaymentService service = new CCPovehivlePaymentService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_HIDE);
						request.setAttribute("vehicle_pay", service.getCCPovehivlePaymentByWorkId(workId));
					} else if(flowtype.equals(F_Constants.DAILY_NEW)){//日常（新）
					    	IBoeveryDayService service = new BoeveryDayService();
					    	request.setAttribute("rollBackType", F_Constants.ROLLBAIK_HIDE);
					    	request.setAttribute("CCBoeveryDay", service.getBoeveryDayInfo(workId));
					}else if(flowtype.equals(F_Constants.CAR_OUTSIDES_RENT)){//外请车付款单
						ICCExpenseaccountBillService   service = new CCExpenseaccountBillService();
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_HIDE);
						Map<String, Object> map = service
								.getCCExpenseaccountBill(workId);
						request.setAttribute("bill", map.get("bill"));
						request.setAttribute("billEntryList",
								map.get("billEntryList"));
					}else if(flowtype.equals(F_Constants.MUCH_PAY)){//多赔
						IOAMuchRecompensateService service = new  OAMuchRecompensateService();
						request.setAttribute("rollBackType",
								F_Constants.ROLLBAIK_HIDE);
						OAMuchRecompensate sate = service.getMuchRecompensate(workId);
						request.setAttribute("muchSate", sate);
					}else if(flowtype.equals(F_Constants.FEE_NEW)){//应酬费（新）
					    	IEntertainmentFeesService service = new  EntertainmentFeesService();
					    	request.setAttribute("rollBackType",F_Constants.ROLLBAIK_HIDE);
					    	request.setAttribute("CCEntertainmentFees", service.getFees(workId));
					}else if(flowtype.equals(F_Constants.INJURY_MEDICAL_EXPENSES_NEW)){//工伤医疗费用（新）
					    	ICCBoInjuryMedicalService service = new  CCBoInjuryMedicalService();
					    	request.setAttribute("rollBackType",F_Constants.ROLLBAIK_HIDE);
					    	request.setAttribute("medical", service.getCCBoInjuryMedical(workId));
					}else if(flowtype.equals(F_Constants.INJURY_MEDICAL_EXPENSES_APPLY)){//工伤医疗费用报销申请
					    	IDlworkrelatedInjuryService service = new  DlworkrelatedInjuryService();
					    	request.setAttribute("rollBackType",F_Constants.ROLLBAIK_HIDE);
					    	Map map = service.getiInjuryInfo(workId);
					    	request.setAttribute("CCDlworkrelatedInjury", 
						    map.get("CCDlworkrelatedInjury"));
					    	request.setAttribute("CCDlworkrelatedInjuryEntry", 
						    map.get("CCDlworkrelatedInjuryEntry"));
					}else if(flowtype.equals(F_Constants.FUNDS_OPERATION)){//资金运作
					    	IRunfinanceService service = new  RunfinanceService();
					    	request.setAttribute("rollBackType", F_Constants.ROLLBAIK_SHOW);
					    	request.setAttribute("OARunfinance", service.getRunfinance(workId));
					}else if(flowtype.equals(F_Constants.SPECIAL_EXPENSES_PROJECT)){//专项费用立项申请
					    	IZhuanfeiLixiangService service = new  ZhuanfeiLixiangService();
					    	request.setAttribute("rollBackType", F_Constants.ROLLBAIK_SHOW);
					    	request.setAttribute("CCZhuanfeiLixiang", service.getLixiangInfo(workId));
					}else if(flowtype.equals(F_Constants.OVERTIME)){//加班/加班工资申请
						IOAOverTimeApplyService service = new OAOverTimeApplyService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
						OAOvertimeApply oaovertimeapply = service.getOAOverTimeApply(workId);
						request.setAttribute("over_time", oaovertimeapply);
						request.setAttribute("overinfo", service.getOvertimes(oaovertimeapply));
					}else if(flowtype.equals(F_Constants.CONTRACT_ADMINISTRATIVE)){//行政类合同申请
						IAdminContractApplyService service = new AdminContractApplyService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
						OaContractApply apply = service.queryContractApply(workId);
						request.setAttribute("contractApply", apply);
					}else if(flowtype.equals(F_Constants.ASSESS_PROGRAM)){//数据提供审批
						IOAAssessProgramService service = new OAAssessProgramService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("assess_program", service.getOAAssessApply(workId));
					}else if(flowtype.equals(F_Constants.DISMISSAL)){//免职申请
						IDismissalService service = new DismissalService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("OADismissal", service.getDismissal(workId));
					}else if(flowtype.equals(F_Constants.CASES_REGISTERED)){//诉讼案件立案/外请律师申请
						ILaywerApplyService service = new LaywerApplyService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("laywerApply", service.getLaywerApplyInfo(workId));
					}else if(flowtype.equals(F_Constants.SITE_RENT)){//场地租赁申请
						IYardrentApplyService service = new YardrentApplyService();
						OAYardrentApply apply = service.getYardrentApplyInfo(workId);
						if(null != apply && apply.getCurrentnode().equals("场地租赁组负责人")){
							request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
						}else{
							request.setAttribute("rollBackType",F_Constants.ROLLBAIK_HIDE);
						}
						request.setAttribute("yardrentApply", apply);
					}else if(flowtype.equals(F_Constants.SITE_SUBLEASE)){//场地转租
						IOAPlaceSubletService service = new OAPlaceSubletService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_HIDE);
						request.setAttribute("oa_place_sublet",service.getOAPlaceSublet(workId));
					}else if(flowtype.equals(F_Constants.BORROW_SEAL)){//借章申请
					    	IBorrowsealApplyService service = new BorrowsealApplyService();
					    	request.setAttribute("rollBackType",F_Constants.ROLLBAIK_HIDE);
					    	request.setAttribute("OABorrowsealApply",service.getBorrowsealApply(workId));
					}else if(flowtype.equals(F_Constants.QUALIFICATIONAUTH)){//任职资格申请
				    	IOAQualificationAuthService service = new OAQualificationAuthService();
				    		request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
				    		request.setAttribute("authApply",service.getQualificationAuth(workId));
					}else if(flowtype.equals(F_Constants.PAYMENT)){//付款申请（香港）
						ITWFSexpensehkService service = new TWFSexpensehkService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);		
						
						Map<String,Object> map = service.getWFSexpensehkInfo(workId);
						request.setAttribute("expensehk",map.get("expensehk"));
						request.setAttribute("expensehkSubList",map.get("expensehkSubList"));
					}else if(flowtype.equals(F_Constants.SUB_SIDIARYSET)){//子公司设立及变更申请
						ISubsidiarysetService service = new SubsidiarysetService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_HIDE);
						request.setAttribute("subsidiaryset", service.getOASubsidiarysetByWorkId(workId));
					}else if(flowtype.equals(F_Constants.REMOVAL_APPLY_NEW)){//新点开设/旧点搬迁
						IRemovalService service = new RemovalService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_HIDE);
						request.setAttribute("removal", service.getOAremovalByWorkId(workId));
					}else if(flowtype.equals(F_Constants.MARKETING_ACTIVITIES)){//营销活动申请
	    				    	IMarketingActivitiesDao service = new MarketingActivitiesDao();
	    				    	request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
	    				    	request.setAttribute("OAMarketingActivities", service.getMarketingActivitiesInfo(workId));
					}else if(flowtype.equals(F_Constants.PROJECT_KIND_CONTRACT_APPLY)){//项目类合同签订申请
						IProjectContractService service = new ProjectContractService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("projectcontractapply", service.getOAContractApplyByWorkId(workId));
					}else if(flowtype.equals(F_Constants.ASSESSREDUCE)){//考核特批减免申请
					    	IAssessreduceApplyDao service = new AssessreduceApplyDao();
					    	request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
					    	request.setAttribute("OAAssessreduceApply", service.getAssessreduceApply(workId));
					}else if(flowtype.equals(F_Constants.EXPENSE_ACCOUNT_HK)){//费用报销申请（香港）
						IExpenseAccount_HKService service = new ExpenseAccount_HKService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("expense_hk", service.getTWFSexpensehkByWorkId(workId));
						request.setAttribute("expense_info", service.getTWFSexpensehkSubsByWorkId(workId));
					}else if(flowtype.equals(F_Constants.LESSON_RESEARCH)){//课程研发/审核申请
					    	ILessonApplyDao service = new LessonApplyDao();
					    	request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
					    	request.setAttribute("OALessonApply", service.getLessonApply(workId));
					}else if(flowtype.equals(F_Constants.RETURN_DOMICILE_OF_ORIGIN)){//回原籍
						IReturnOriginService service = new ReturnOriginService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_HIDE);
				    		request.setAttribute("origin", service.getReturnOriginInfo(workId));
					}else if(flowtype.equals(F_Constants.LOAN_PAYMENT)){//借支申请
						ILoanPaymentService service = new LoanPaymentService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("payment", service.getLoanPaymentInfo(workId));
					}else if(flowtype.equals(F_Constants.EDUCATE_BY_OUTSIDE)){//外训申请
						IEducateOutsideService service = new EducateOutsideService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
				    		request.setAttribute("training", service.getExterNaltrainingInfo(workId));
					}else if(flowtype.equals(F_Constants.DISCOUNT)){//折扣申请
	    				    	IDisCountApplyDao service = new DisCountApplyDao();
	    				    	request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
	    				    	request.setAttribute("OAdisCountApply", service.getDisCountApply(workId));
					}else if(flowtype.equals(F_Constants.COURT_DESIGN)){//场地设计
					    	ISitedesignDao service = new SitedesignDao();
					    	request.setAttribute("rollBackType",F_Constants.ROLLBAIK_HIDE);
					    	request.setAttribute("OASitedesign", service.getSitedesign(workId));
					}else if(flowtype.equals(F_Constants.MANAGER_BECOME)){//管理人员转正
				    		IManagerBecomeService service = new ManagerBecomeService();
				    		request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
				    		request.setAttribute("managerBecome", service.getManagerRegApply(workId));
					}else if(flowtype.equals(F_Constants.USE_SEAL_APPLY)){//用章申请
						IOAUseSealApplyService service = new OAUseSealApplyService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_HIDE);
						request.setAttribute("use_seal_apply", service.getOAUseSealApplyById(workId));
					}else if(flowtype.equals(F_Constants.PERSONEL_IMPOWER)){//人事授权申请
						IOAPersonelimPowerDao service = new OAPersonelimPowerDao();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("powerApply", service.getPersonelimPower(workId));
					}else if(flowtype.equals(F_Constants.DETAINED_GOODS)){//扣货申请
						IDetainedGoodsService service = new DetainedGoodsService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("detained_goods_apply", service.getOAKouhuoApplyById(workId));
					}else if(flowtype.equals(F_Constants.DATA_REQUIRE)){//数据需求审批流程
					    	IOADataRequireApplyDao service = new OADataRequireApplyDao();
					    	request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
					    	request.setAttribute("OADataRequireApply", service.getDataRequireApply(workId));
					}else if(flowtype.equals(F_Constants.TRAIN_LEAVE)){//培训请假
					    	IOATrainLeaveService service = new OATrainLeaveService();
					    	Map map = service.getTrainLeave(workId);
					    	request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
					    	request.setAttribute("OATrainLeave", map.get("OATrainLeave"));
					    	request.setAttribute("OATrainLeaveDetail", map.get("OATrainLeaveDetail"));
					}else if(flowtype.equals(F_Constants.BAD_DEBT)){//非业务类坏账申请
	        			    	IOABaddebtService service = new OABaddebtService();
	        			    	request.setAttribute("rollBackType",F_Constants.ROLLBAIK_HIDE);
	        			    	request.setAttribute("badApply", service.getBaddebtApply(workId));
	        			    	request.setAttribute("badChildList", service.getBaddebtChild(workId));
					}else if(flowtype.equals(F_Constants.BUSINESS_BAD_DEBTS)){//业务类坏账申请
	    				    	IOABusinessBaddebtsService service = new OABusinessBaddebtService();
	    				    	Map map = service.getBusinessBaddebt(workId);
	    				    	request.setAttribute("rollBackType",F_Constants.ROLLBAIK_HIDE);
	    				    	request.setAttribute("businessBaddebts", map.get("businessBaddebts"));
	    				    	request.setAttribute("baddebtbills", map.get("baddebtbills"));
	    				    	request.setAttribute("baddebtleafs", map.get("baddebtleafs"));
				   }else if(flowtype.equals(F_Constants.ELECTRONIC_CONTRACT_BORROW)){//电子合同借阅
				    		IEleContractBorrowService service = new EleContractBorrowService();
				    		request.setAttribute("rollBackType",F_Constants.ROLLBAIK_HIDE);
				    		request.setAttribute("borrowApply", service.getEleContractBorrowInfo(workId));
				    } else if(flowtype.equals(F_Constants.TRUCK_LOAD_TRANSPORT)){//整车货物运输合同
				    		IOACarGoTransContractService service = new OACarGoTransContractService();
				    		request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
				    		request.setAttribute("oaCarGoTransContract", service.getOACarGoTransContractByProcessinstid(workId));
				    } else if(flowtype.equals(F_Constants.TALENT_RECOMMENDATION)){//优秀人才推荐
						IRecommendExcellentEmpService service = new RecommendExcellentEmpService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("recommendexcellentemp", service.getExcellentEmp(workId));
				    } else if(flowtype.equals(F_Constants.TRAIN_REQUIREMENT)){//培训需求申请
						IOATrainRequestService service = new OATrainRequestService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("trainRequest", service.getTrainRequestInfo(workId));
				    } else if(flowtype.equals(F_Constants.SEAL_CARVE_APPLY)){//刻章申请
				    		IOASealCarveApplyService service = new OASealCarveApplyService();
				    		request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
				    		request.setAttribute("oasealcarveapply", service.getOASealCarveApplyByProcessinstid(workId));
				    } else if(flowtype.equals(F_Constants.PROCESS_MANAGER)){//流程新建/变更/废除
				    		IOAManagerProcessService service = new OAManagerProcessService();
				    		request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
				    		request.setAttribute("oamanagerprocess", service.getOAManagerProcessByProcessinstid(workId));
				    } else if(flowtype.equals(F_Constants.LICENSE_CANCELL)){//分公司证照注销
						IOALicenseCanceledService service = new OALicenseCanceledService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("licensecanceledinfo", service.getLicenseCanceledInfo(workId));
				    } else if(flowtype.equals(F_Constants.DISPATCH_CENSOR)){//发文审核申请
						IOACheckFileApplyService service = new OACheckFileApplyService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("fileApply", service.getCheckFileApplyInfo(workId));
				    } else if(flowtype.equals(F_Constants.LICENSES_BORROW)){//发文审核申请
						IOALicenseLendReadService service = new OALicenseLendReadService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_HIDE);
						request.setAttribute("licenseLendRead", service.getLicenseLendRead(workId));
				    }else if(flowtype.equals(F_Constants.BANKACCOUNT_OPENCL)){//银行开户/销户申请
						IOABankAccountOpenClService service = new OABankAccountOpenClService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("openClApply", service.getBankAccountOpenClInfo(workId));
				    }else if(flowtype.equals(F_Constants.COURT_FIND_SITE)){//场地找点
						IOASiteFindPlaceApplyService service = new OASiteFindPlaceApplyService();
						request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
						request.setAttribute("OASiteFindPlaceApply", service.getSiteFindPlaceApply(workId));
				    }
				}
				
			/**------------以下是FSSC和LSP的工作流--------------**/
			//FSSC工作流				
			}else if(syscode.equals(F_Constants.FSSC_WORKFLOW_SYSCODE)){
				//接口传参
				Object[] objs = new Object[]{busino,login.getUserId(),Long.parseLong(workitemid)};
//				objs = new Object[]{"FSSC107140710000001","019038",242209};
//				flowtype = "com.deppon.bpms.module.fssc.bpsdesign.fossAccountBill.pay4Car";
//				objs = new Object[]{"FSSC101140718000001","019038",650964};
//				flowtype = "com.deppon.bpms.module.fssc.bpsdesign.dailyRepbill.commcation";
				//调用接口返回实体
				MobileFsscEntity mobileFsscEntity = FSSCWorkItemServiceClient.getFSSCWorkItemInfo(objs);
				
				//如果报账返回bean为 null则 创建
				if(null == mobileFsscEntity)
					mobileFsscEntity = new MobileFsscEntity();
					
				request.setAttribute("mobileFsscEntity", mobileFsscEntity);
				//意见
				request.setAttribute("approvalInfos", mobileFsscEntity.getMobileApprovalArray());
				//回退节点
				/**
				 * 功    能：增加判断当前审批节点有无可回退的节点，当没有回退的节点时new一长度为0的MobileBranchRule类型的数组
				 * ，以免在workflow_approve_button.jsp页面的第14行或者221行用到报空指针异常
				 * 修改者：吴亚青
				 * 修改日期：2014-4-1 17:33
				 */
				request.setAttribute("mobileBackRules", mobileFsscEntity.getMobileBackRule());
				
				//审批需要信息
				WfParamVo wfParamVo = new WfParamVo();
				wfParamVo.setClaimNo(busino);
				wfParamVo.setWfWorkitemId(Long.parseLong(workitemid));
				request.setAttribute("wfParamVo", wfParamVo);
				if(null != mobileFsscEntity.getMobileBackRule() && mobileFsscEntity.getMobileBackRule().length > 0){
					request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
				}else{
					request.setAttribute("rollBackType",F_Constants.ROLLBAIK_HIDE);
				}
				
				
			}else if(syscode.equals(F_Constants.DLSP_WORKFLOW_SYSCODE)){//后勤系统的工作流
				//接口参数
				Object[] objs = new Object[]{busino,login.getUserId(),login.getEmpName()};
				System.out.println(busino+"===lsp==============="+login.getUserId()+"========"+login.getEmpName());
				Object entity = null;
				if(flowtype.equals(F_Constants.DLSP_PURCHASE_CONTRACT_CHANGE)){//采购合同变更
					//调用外部接口获取数据
					LSPWorkItemServiceClient lspClent = LSPWorkItemServiceClient.getLSPWorkItemServiceClient();
					entity = (WorkflowData)lspClent.getLSPWorkItemInfo(objs , "queryWorkflowDetailFromLSP");
					approvalLSP(workId, busino, workitemid, activitydefid, entity);
					request.setAttribute("attachListLSP",((WorkflowData)entity).getAttachList());//传递给页面
				} else if (flowtype.equals(F_Constants.DLSP_PAYMENT_APPLY)){ //付款单申请
					//调用外部接口获取数据
					LSPWorkItemServiceClient lspClent = LSPWorkItemServiceClient.getLSPWorkItemServiceClient();
					entity = (PayApplyWorkflowData)lspClent.getLSPWorkItemInfo(objs, "queryPayApplyWorkflowDetailFromLSP");
					approvalLSP(workId, busino, workitemid, activitydefid, entity);
					request.setAttribute("attachListLSP",((PayApplyWorkflowData)entity).getAttachList());//传递给页面
				} else if (flowtype.equals(F_Constants.DLSP_PURCHASE_CONTRACT)){ // 采购合同
					//调用外部接口获取数据
					LSPWorkItemServiceClient lspClent = LSPWorkItemServiceClient.getLSPWorkItemServiceClient();
					entity = (WorkflowData)lspClent.getLSPWorkItemInfo(objs , "queryWorkflowDetailFromLSP");
					approvalLSP(workId, busino, workitemid, activitydefid, entity);
					request.setAttribute("attachListLSP",((WorkflowData)entity).getAttachList());//传递给页面
				}else {
					//下面的是走了esb接口的工作流的处理。上面的采购合同变更、付款单申请、采购合同是没有走esb而用的是最开始的接口的工作流
					Map<String,String> params = new HashMap<String,String>();//为了构建查询参数
					params.put("busino", busino);
					params.put("empCode", login.getUserId());
					params.put("empName", login.getEmpName());
					String batchType = LSP_ESBWorkItemServiceClientSecond.getBatch(flowtype);
					if ("1".equals(batchType)) {
						LSP_ESBWorkItemServiceClient client = LSP_ESBWorkItemServiceClient.getLSP_ESBWorkItemServiceClient();//调用服务端
						WorkflowEntity workflowInfo = new WorkflowEntity();
						workflowInfo = client.getLSPEntity(params);//得到响应实体
						request.setAttribute("lspResponseEntity",workflowInfo);//传递给页面
					}else if ("2".equals(batchType)) {
						LSP_ESBWorkItemServiceClientSecond client = LSP_ESBWorkItemServiceClientSecond.getLSP_ESBWorkItemServiceClient();//调用服务端
						com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain.WorkflowSecondEntity workflowInfo = new com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain.WorkflowSecondEntity();
						workflowInfo = client.getLSPEntity(params);//得到响应实体
						request.setAttribute("lspResponseEntity",workflowInfo);//传递给页面
						String workflowNameLSP = LSP_ESBWorkItemServiceClientSecond.getWorkflowName(flowtype);
						request.setAttribute("workflowNameLSP",workflowNameLSP);//传递给页面
					}else if("3".equals(batchType)) {
						//用restful調用接口
//						RestfulUtil.createClient("lsp_esb_ws_rest_link");//调用服务端
						WorkflowBusinessData workflowInfo = new WorkflowBusinessData(params.get("empCode"),params.get("empName"),params.get("busino"));
						
						//调用接口
						String lmsInfojson = RestfulUtil.querylmsInfo("lsp_esb_ws_rest_link",workflowInfo);
						errorInfo=lmsInfojson;
						int excep = lmsInfojson.indexOf("exceptionType");
						if(excep == -1){
							//lms工作流解析
							Object lmsInfoObjs = WFUtil.parseLmsWFInfo(flowtype, ComUtil.class,lmsInfojson);
							ComUtil comBean = (ComUtil)lmsInfoObjs;
							//传递给页面
							request.setAttribute("lspResponseEntity",comBean.getItems());
							request.setAttribute("attachList",comBean.getAttachList());
							request.setAttribute("approvalInfoList",comBean.getApprovalInfoList());
						}else{
							logger.error("接口异常信息："+lmsInfojson);
						}
						
					}else {
						throw new RuntimeException("不在移动办公项目的配合范围内");
					}
					request.setAttribute("interfaceBatchLSP",batchType);
					Auditparameters audit = new Auditparameters();//构建审批后勤需要的参数
					audit.setWfInstanceId(Long.parseLong(workId));//流程实例号
					audit.setWfWorkItemId(Long.parseLong(workitemid));//工作项定义id
					audit.setDocId(busino);//业务编号
					audit.setWfState(activitydefid);//当前活动的流程定义id
					
					request.setAttribute("approvalLSPEntity",audit);
				}

			} else if (syscode.equals(F_Constants.DWFS_WORKFLOW_SYSCODE)) { //门户二期工作流
				request.setAttribute("rollBackType",F_Constants.ROLLBAIK_SHOW);
				Object entity = DWFSGetDetails(busino, flowtype);
				request.setAttribute("entity", entity);
				request.setAttribute("workItemId",workitemid);
				request.setAttribute("processinstid",workId);
				request.setAttribute("activitydefid",activitydefid);
				request.setAttribute("activityinstid", activityinstid);
				request.setAttribute("flowType", flowtype);
				request.setAttribute("isDisplayFiles", reqPara.get("isDisplayFiles"));
				request.setAttribute("userId", userId);
			}else if(syscode.equals(F_Constants.CRM_WORKFLOW_SYSCODE)){//CRM系统工作流
				//获取CRM接口连接esb编码
				String esbCode = InitDataServlet.getValue("icrm_esbCode_search");
				/**
				 * 2    初始化cxf客户端
				 * */
				IDpmToCrmService client = (IDpmToCrmService) OtherSysWorkItemClient.getOtherSysClient("icrm_ws_link",IDpmToCrmService.class);
				
				/**
				 * 3    封装头信息
				 * */
				Holder<ESBHeader> esbHeader = EsbHeaderData.setEsbHeaderData("1.0.0", busino,esbCode);
				
				/**
				 * 4   封装消息体
				 * */
				QueryWorkflowInfoRequest workflowInfoRequest = new QueryWorkflowInfoRequest(busino, flowtype , Integer.parseInt(workId), login.getUserId(), login.getEmpName());
				
				/**
				 * 5    调用远程方法，获取返回值
				 * */
		        QueryWorkflowInfoResponse workflowInfo = new QueryWorkflowInfoResponse();;
				try {
					
					workflowInfo = client.queryWorkflowInfo(workflowInfoRequest, esbHeader);
				} catch (CommException e) {
					logger.info(esbHeader.value.getEsbServiceCode()+" "+ esbHeader.value.getBusinessId(), e);
				}
				request.setAttribute("queryWorkflowInfoResponse", workflowInfo);
				request.setAttribute("syscode", syscode);
				request.setAttribute("processinstid", workId);
				request.setAttribute("processDefName", flowtype);
				request.setAttribute("busino", busino);
				request.setAttribute("workitemid", workitemid);
//				request.setAttribute("syscode", syscode);
			}else if(syscode.equals(F_Constants.FIN_SELF_WORKFLOW_SYSCODE)) {
				
				/**FIN_SELF财务自助接口*/
				
				IFinsMobileService finsClient = (IFinsMobileService)OtherSysWorkItemClient.getOtherSysClient("fins_ws_link",IFinsMobileService.class);
				//头信息
				Holder<ESBHeader> finsEsbHeader = EsbHeaderData.setEsbHeaderData("1.0.0", busino,InitDataServlet.getValue("fins_esbCode_busi"));
				//消息体
				InitWorkFlowViewDataRequest finsBusiReq = new InitWorkFlowViewDataRequest(workId,busino,login.getUserId(),login.getEmpName());
				//返回业务信息
				InitWorkFlowViewDataResponse finsBusiRsp =finsClient.initWorkFlowViewData(finsEsbHeader, finsBusiReq);
				request.setAttribute("finsBusiRsp", finsBusiRsp);
				request.setAttribute("syscode", syscode);
				request.setAttribute("processinstid", workId);
				request.setAttribute("processDefName", flowtype);
				request.setAttribute("busino", busino);
				request.setAttribute("workitemid", workitemid);
			}else if(syscode.equals(F_Constants.HR_WORKFLOW_SYSCODE)) {
				
				/**HR人力资源接口*/
				WorkFlowToDPMService hrClient = (WorkFlowToDPMService) OtherSysWorkItemClient.getOtherSysClient("hr_ws_link", WorkFlowToDPMService.class);
				//消息头
				Holder<ESBHeader> hrEsbHeader = EsbHeaderData.setEsbHeaderData("1.0.0", busino, InitDataServlet.getValue("hr_esbCode_busi"));
				//消息体
				com.deppon.nhr.module.remote.dpm.shared.domain.workflow.QueryWorkflowInfoRequest hrBusiReq = new com.deppon.nhr.module.remote.dpm.shared.domain.workflow.QueryWorkflowInfoRequest(login.getUserId(),login.getEmpName(),flowtype,busino);
				//返回业务信息
				com.deppon.nhr.module.remote.dpm.shared.domain.workflow.QueryWorkflowInfoResponse hrBusiRsp = hrClient.queryByWrokFlowEntity(hrBusiReq, hrEsbHeader);
                request.setAttribute("hrBusiRsp", hrBusiRsp);
				request.setAttribute("syscode", syscode);
				request.setAttribute("processinstid", workId);
				request.setAttribute("processDefName",flowtype);
				request.setAttribute("busino", busino);
				request.setAttribute("workitemid", workitemid);
				request.setAttribute("activitydefid", activitydefid);
			}else if(syscode.equals(F_Constants.WDGH_WORKFLOW_SYSCODE)) {
				/**网点规划接口*/
				IDpmToWdghService wdghClient = (IDpmToWdghService)OtherSysWorkItemClient.getOtherSysClient("wdgh_ws_link",IDpmToWdghService.class );
				Holder<ESBHeader> wdghEsbHeader = EsbHeaderData.setEsbHeaderData("1.0.0", busino, InitDataServlet.getValue("wdgh_esbCode_busi"));
				com.deppon.wdgh.inteface.domain.QueryWorkflowInfoRequest wdghBuisReq = new com.deppon.wdgh.inteface.domain.QueryWorkflowInfoRequest(busino, flowtype, Integer.parseInt(workId), login.getUserId(), login.getEmpName());
				com.deppon.wdgh.inteface.domain.QueryWorkflowInfoResponse wdghBusiRsp = wdghClient.queryWorkflowInfo(wdghBuisReq, wdghEsbHeader);
				request.setAttribute("wdghBusiRsp", wdghBusiRsp);
				request.setAttribute("syscode", syscode);
				request.setAttribute("processinstid", workId);
				request.setAttribute("processDefName",flowtype);
				request.setAttribute("busino", busino);
				request.setAttribute("workitemid", workitemid);
			}else if(F_Constants.ACMS_WORKFLOW_SYSCODE.equals(syscode)){
				/**证照系统工作流接口*/
				/**创建http客户端*/
//				String link = InitDataServlet.getValue("acms_wfs_info_link");
//				WebClient acmsClient = RestfulUtil.createClient(link);
				//接口请求参数封装
				SyncWorkflowinfoRequest syncReq = new SyncWorkflowinfoRequest(login.getUserId(),login.getEmpName(),flowtype,busino,Long.parseLong(workId));
				/*接口调用*/
				SyncWorkflowinfoResponse syncResponse = (SyncWorkflowinfoResponse) RestfulUtil.invoke("acms_wfs_info_link",syncReq, SyncWorkflowinfoResponse.class);
				request.setAttribute("acmsSyncResponse", syncResponse);
				request.setAttribute("syscode", syscode);
				request.setAttribute("processinstid", workId);
				request.setAttribute("processDefName",flowtype);
				request.setAttribute("busino", busino);
				request.setAttribute("workitemid", workitemid);
			}
			request.setAttribute("app_ui", app_ui);
			
			/**页面跳转路径**/
			
			issuccess = "1";
			if (null != ui_type && ui_type.equals(F_Constants.UI_IOS)) {
				forward(F_Constants.IOS_PATH
						+ F_Constants.WF_FORWARD_MAP.get(flowtype));
			} else {
				forward(F_Constants.WIN8_PATH
						+ F_Constants.WF_FORWARD_MAP.get(flowtype));
			}
			
			return;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询工作流信息异常，异常信息:"+e.getMessage(), e);
			issuccess = "0";
			errorInfo="★★"+e.getMessage();
			try {
				request.setAttribute("errorInfo", e.getMessage()+ e);
				forward("error.jsp");
				return;
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ServletException e2) {
				e2.printStackTrace();
			}
		}finally{
			try {
				//数据监控 6.3
				requestClient(userId,flowtype,begindate,new Date(),busino,issuccess,null,errorInfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 数据监控
	 */
	public void requestClient(String userId,String flowtype,Date begindate,Date enddate,String busino,String issuccess,String flag,String errorInfo)
			throws Exception {
		System.out.println(errorInfo+"========errorInfo");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		Object o="";
		if(errorInfo.indexOf("{")>-1&&errorInfo.indexOf("}")>-1){
			o=JSONObject.parseObject(errorInfo).toJSONString();
		}else{
			o="\""+errorInfo+"\"";
		}
		String str="{\"userId\":\""+userId+"\",\"workflowname\":\""+flowtype+"\",\"bdateStr\":\""+sdf.format(begindate)+"\",\"edateStr\":\""+sdf.format(enddate)+"\",\"remark\":\""+busino+"\",\"errorInfo\":"+o;
		
		String urls="dpmontal_queryWorkInfo.action";
		str+=",\"issuccess\":\""+issuccess+"\"";
		if(flag!=null&&flag.equals("1")){//审批
			urls="dpmontal_approveWorkInfo.action";
		}
		str+="}";
		System.out.println(str+"=========");
		System.out.println(InitDataServlet.prop.getProperty("dpm_workflow_url")+"============");
		//创建一个Url对象
		URL url = new URL(InitDataServlet.prop.getProperty("dpm_workflow_url")+"/dpm/"+urls);
		//获得连接
		HttpURLConnection httpConn = ((HttpURLConnection) url
				.openConnection());
		//设置请求头的一些参数
		httpConn.addRequestProperty("Content-Type",
				"application/json;charset=utf-8");
		//设置请求方式为POST
		httpConn.setRequestMethod("POST");
		httpConn.setDoOutput(true);
		httpConn.setAllowUserInteraction(false);
		//获得输出流
		PrintStream ps = new PrintStream(httpConn.getOutputStream());
		//写入输出流
		ps.print(str);
		//关闭输出流
		ps.close();
		//获得输入流
		InputStream input = httpConn.getInputStream();
        //获得返回json
//		String jsonString = org.apache.commons.io.IOUtils.toString(input);
//		判断json字符串是否为空
//		if (null != jsonString) {
//			//json字符串如果不为空，返回jsonString
//			return jsonString;
//		}
//		return result;
	}
	private void userinfocheck(String userinfo){
		try {
			userinfo =new String(Base64.decryptBASE64(userinfo));
			String userid = userinfo.substring(0, userinfo.indexOf("|"));
			String password = userinfo.substring(userinfo.indexOf("|") + 1);
			logger.info("userid=" + userid + "" + "password=" + password);
			String sessionId = getSessionId();
			LoginUser user = (LoginUser) getUserRedisService()
				.getFromRedisBySession(sessionId);
			System.out.println(user + "============");
			HttpSession session = request.getSession();
			// 验证通过，封装用户信息
			String sid = session.getId();
			logger.info("SSOLogonAction------------------->userid = "
					+ userid + " ,sessionId = " + sid);

			LoginUser login = null;
			if (userid != null)
			{// 先从redis缓存中查询用户是否存在
				login = (LoginUser) getUserRedisService().getFromRedis(
						userid);
			}
			if (login == null)
			{// 若是redis缓存中不存在user信息，再到数据库中核对有没有该用户
				login = loginService.getLoginUser(userid);
				if (login != null)
				{
					// 向redis缓存中添加用户信息
					getUserRedisService().add2Redis(login);
				}
			}
			System.out.println(login + "---------" + userid + "---------"
					+ password);
			if (null != login)
			{
				user = login;
				// TODO 首先把用户的信息与session绑定到一块
				getUserRedisService().add2Redis(sid, userid);
				request.getSession().setAttribute("loginUser", login);
				// response.getWriter().write("success");//成功
			}
			else
			{
				response.getWriter().write("error");// 用户名密码错误
				request.setAttribute("errors", "工号或密码错误！");
				return ;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void approvalLSP(String workId, String busino, String workitemid,String activitydefid, Object entity) {
		//审批实体
		Auditparameters auditparameters = new Auditparameters();
		auditparameters.setWfInstanceId(Long.parseLong(workId));
		auditparameters.setWfWorkItemId(Long.parseLong(workitemid));
		auditparameters.setWfState(activitydefid);
		auditparameters.setDocId(busino);
		request.setAttribute("auditparameters", auditparameters);
		request.setAttribute("entity", entity);
		request.setAttribute("rollBackType",F_Constants.ROLLBAIK_HIDE);
	}
	
	private Object DWFSGetDetails(String busino , String flowtype) throws NoSuchFieldException{
		//工作流工具类
		WFUtil wfUtil = new WFUtil();
		//单点登录服务 校验casCookie
		SSOLogonService service = new SSOLogonService();
		IWFDetailApplyService detailsService = new WFDetailApplyServiceImpl();
		Map<String, String> params = new HashMap<String, String>();
		Object entity = null;
		request.setAttribute("fileList", wfUtil.getAllFiles(busino));
		//参数
		params.put("busino", busino);
		params.put("processDefName", flowtype);
		String workId = reqPara.get("workId");
		try {
			//APP访问 直接获取cookie sessionId
			String CASLOGINTGC="";
			String sid="";
			String version=reqPara.get("version");
			if(version!=null&&version.equals("new")){
				String cookie = reqPara.get("casCookie");//casCookie CASTGC
				String casSid = reqPara.get("sessionId");
				
			    System.out.println(cookie+"===cookie=========="+casSid);
			    if(cookie.indexOf("Path=/cas") > -1){
			    	CASLOGINTGC= cookie;
				}else{
					CASLOGINTGC= cookie + "; Path=/cas";
//					String app_cookies = "CASTGC=" + cookie + "; Path=/cas";
					
				}
			    if(cookie.indexOf("CASTGC=") > -1){
			    	CASLOGINTGC= cookie;
				}else{
					CASLOGINTGC="CASTGC="+ cookie;
//					String app_cookies = "CASTGC=" + cookie + "; Path=/cas";
//					request.getSession().setAttribute("CAS-LOGIN-TGC", app_cookies);
				}
			    System.out.println(cookie+"----------cascookie--------"+CASLOGINTGC);
			    //cas认证ID
				sid =casSid;
				request.getSession().setAttribute("CAS-LOGIN-TGC", CASLOGINTGC);
				request.getSession().setAttribute("CAS-SESSIONID",sid);
			}else{
				CASLOGINTGC=(String)request.getSession().getAttribute("CAS-LOGIN-TGC");
				sid=(String)request.getSession().getAttribute("CAS-SESSIONID");
			}
			
			String actionUrl = service.doClientLogin(InitDataServlet.prop.getProperty("cas_login_url")+ "?service="
					+ URLEncoder.encode(DWFSWorkItemServiceClient.DWFS_DETAILS_URL, "utf8"), null, CASLOGINTGC);
			
			System.out.println("==========actionUrl============="+actionUrl+"=="+flowtype);
			
			//从缓存中获取DWFS工作流配置信息
			List<WorkflowInfo> workflowInfos = wfUtil.getWrokflowInfo(flowtype);
			
			int wfInfoSize = workflowInfos==null?0:workflowInfos.size();
			if(wfInfoSize > 1){
				logger.info("工作流配置信息结果异常，请检查工作流配置。");
			}
			WorkflowInfo wfinfo =  workflowInfos.get(0);
			logger.info("流程定义:"+flowtype+" 实体类:" + wfinfo.getClassName() + " 业务字典属性:" + wfinfo.getEntryProperty());
			//通过类的名称反射类
			Class<?> cls=Class.forName(wfinfo.getClassName());
			//对象实例化
            Object bean=cls.newInstance();
			
			//需要转换的属性
            Map filedMap = new HashMap<String,String>();
            filedMap = wfUtil.parseJsonToMap(wfinfo.getEntryProperty());
			//获取实体bean
			entity = wfUtil.getWFSDetails(bean, actionUrl, params, sid);
//			System.out.println(entity+"------------");
			//参数业务字典转换
			entity = wfUtil.parseEntityEntry(entity,bean,filedMap);
//			System.out.println(entity+"----2222222222--------");
			if (flowtype.equals(F_Constants.DWFS_QUALI_FICATION_APPLY)) {//任职资格
				request.setAttribute("scoreDict", DictEntryService.getInstance().getDictEntries("WFS_QUALAUTH_SCORE", null));
			}else if(flowtype.equals(F_Constants.DWFS_BUDGETDATA)){//预算数据申请#################????????????
			    entity=detailsService.translateBudgedata(entity);
			}else if (flowtype.equals(F_Constants.DWFS_NEW_DEPT_APPLY)) {//新部门成立申请
				request.setAttribute("dict", DictEntryService.getInstance().getDictEntries("WFS_WORKFLOW_DIRECTION", null));
			}else if(flowtype.equals(F_Constants.DWFS_PROBLEMFEEDBACKBEAN)) { //一线问题反馈
				request.setAttribute("dict", DictEntryService.getInstance().getDictEntries("DWFS_RESPONSIBLE_DEPT", null));
			}else if(flowtype.equals(F_Constants.DWFS_CURRICULUM_AUDIT)) { //课程研发申请
				Map<String, String> params1 = new HashMap<String, String>();
				Map<String, String> params2 = new HashMap<String, String>();
				Object entity1 = null;
				String businoCuose = null;
				CourseDevelopUpdateAuditBean cc = (CourseDevelopUpdateAuditBean) entity;
				//工作流号
				if(cc.getDevlopUpdateId() != null && !"".equals(cc.getDevlopUpdateId())){
					String actionUrl1 = service.doClientLogin(InitDataServlet.prop.getProperty("cas_login_url")+ "?service="
							+ URLEncoder.encode(DWFSWorkItemServiceClient.DWFS_CURRICULUM, "utf8"), null, CASLOGINTGC);
					params2.put("processinstid",cc.getDevlopUpdateId());
					businoCuose = detailsService.getCommDWFSUrl(actionUrl1, params2, sid);
					params1.put("busino", businoCuose.toString());
					params1.put("processDefName", flowtype);
					
					actionUrl = service.doClientLogin(InitDataServlet.prop.getProperty("cas_login_url")+ "?service="
							+ URLEncoder.encode(DWFSWorkItemServiceClient.DWFS_DETAILS_URL, "utf8"), null, CASLOGINTGC);
					entity1 = detailsService.getCommDWFSDetails(new CourseDevelopUpdateAuditBean(), actionUrl, params1, sid);
					((CourseDevelopUpdateAuditBean) entity).setReSetEntity((CourseDevelopUpdateAuditBean) detailsService.parseCourseDevelopUpdateAudit(entity1)) ;
				}
				
			}
			
		} catch (IllegalArgumentException e) {
			logger.error("DWFS getDetails error" + e);
		} catch (UnsupportedEncodingException e) {
			logger.error("DWFS getDetails error" + e);
		} catch (InstantiationException e) {
			logger.error("DWFS getDetails error" + e);
		} catch (IllegalAccessException e) {
			logger.error("DWFS getDetails error" + e);
		} catch (InvocationTargetException e) {
			logger.error("DWFS getDetails error" + e);
		} catch (ClassNotFoundException e) {
			logger.error("DWFS getDetails error" + e);
		} catch (SecurityException e) {
			logger.error("DWFS getDetails error" + e);
		}
		return entity;
	}
	
		private Object DWFSGetDetails2(String busino , String flowtype) throws NoSuchFieldException{
			//工作流工具类
			WFUtil wfUtil = new WFUtil();
			//单点登录服务
			SSOLogonService service = new SSOLogonService();
			IWFDetailApplyService detailsService = new WFDetailApplyServiceImpl();
			Map<String, String> params = new HashMap<String, String>();
			Object entity = null;
			request.setAttribute("fileList", wfUtil.getAllFiles(busino));
			//cas认证ID
			String sid = (String)request.getSession().getAttribute("CAS-SESSIONID");
			//参数
			params.put("busino", busino);
			params.put("processDefName", flowtype);
			String workId = reqPara.get("workId");
			try {
				String actionUrl = service.doClientLogin(InitDataServlet.prop.getProperty("cas_login_url")+ "?service="
						+ URLEncoder.encode(DWFSWorkItemServiceClient.DWFS_DETAILS_URL, "utf8"), null, (String) request.getSession().getAttribute("CAS-LOGIN-TGC"));
				
				//从缓存中获取DWFS工作流配置信息
				List<WorkflowInfo> workflowInfos = wfUtil.getWrokflowInfo(flowtype);
				int wfInfoSize = workflowInfos==null?0:workflowInfos.size();
				if(wfInfoSize > 1){
					logger.info("工作流配置信息结果异常，请检查工作流配置。");
				}
				WorkflowInfo wfinfo =  workflowInfos.get(0);
				logger.info("流程定义:"+flowtype+" 实体类:" + wfinfo.getClassName() + " 业务字典属性:" + wfinfo.getEntryProperty());
				//通过类的名称反射类
				Class<?> cls=Class.forName(wfinfo.getClassName());
				//对象实例化
	            Object bean=cls.newInstance();
				
				//需要转换的属性
	            Map filedMap = new HashMap<String,String>();
	            filedMap = wfUtil.parseJsonToMap(wfinfo.getEntryProperty());
				//获取实体bean
				entity = wfUtil.getWFSDetails(bean, actionUrl, params, sid);
				//参数业务字典转换
				entity = wfUtil.parseEntityEntry(entity,bean,filedMap);
				
				if (flowtype.equals(F_Constants.DWFS_QUALI_FICATION_APPLY)) {//任职资格
					request.setAttribute("scoreDict", DictEntryService.getInstance().getDictEntries("WFS_QUALAUTH_SCORE", null));
				}else if(flowtype.equals(F_Constants.DWFS_BUDGETDATA)){//预算数据申请#################????????????
				    entity=detailsService.translateBudgedata(entity);
				}else if (flowtype.equals(F_Constants.DWFS_NEW_DEPT_APPLY)) {//新部门成立申请
					request.setAttribute("dict", DictEntryService.getInstance().getDictEntries("WFS_WORKFLOW_DIRECTION", null));
				}else if(flowtype.equals(F_Constants.DWFS_PROBLEMFEEDBACKBEAN)) { //一线问题反馈
					request.setAttribute("dict", DictEntryService.getInstance().getDictEntries("DWFS_RESPONSIBLE_DEPT", null));
				}else if(flowtype.equals(F_Constants.DWFS_CURRICULUM_AUDIT)) { //课程研发申请
					Map<String, String> params1 = new HashMap<String, String>();
					Map<String, String> params2 = new HashMap<String, String>();
					Object entity1 = null;
					String businoCuose = null;
					CourseDevelopUpdateAuditBean cc = (CourseDevelopUpdateAuditBean) entity;
					//工作流号
					if(cc.getDevlopUpdateId() != null && !"".equals(cc.getDevlopUpdateId())){
						String actionUrl1 = service.doClientLogin(InitDataServlet.prop.getProperty("cas_login_url")+ "?service="
								+ URLEncoder.encode(DWFSWorkItemServiceClient.DWFS_CURRICULUM, "utf8"), null, (String) request.getSession().getAttribute("CAS-LOGIN-TGC"));
						params2.put("processinstid",cc.getDevlopUpdateId());
						businoCuose = detailsService.getCommDWFSUrl(actionUrl1, params2, (String)request.getSession().getAttribute("CAS-SESSIONID"));
						params1.put("busino", businoCuose.toString());
						params1.put("processDefName", flowtype);
						
						actionUrl = service.doClientLogin(InitDataServlet.prop.getProperty("cas_login_url")+ "?service="
								+ URLEncoder.encode(DWFSWorkItemServiceClient.DWFS_DETAILS_URL, "utf8"), null, (String) request.getSession().getAttribute("CAS-LOGIN-TGC"));
						entity1 = detailsService.getCommDWFSDetails(new CourseDevelopUpdateAuditBean(), actionUrl, params1, (String)request.getSession().getAttribute("CAS-SESSIONID"));
						((CourseDevelopUpdateAuditBean) entity).setReSetEntity((CourseDevelopUpdateAuditBean) detailsService.parseCourseDevelopUpdateAudit(entity1)) ;
					}
					
				}
				
			} catch (IllegalArgumentException e) {
				logger.error("DWFS getDetails error" + e);
			} catch (UnsupportedEncodingException e) {
				logger.error("DWFS getDetails error" + e);
			} catch (InstantiationException e) {
				logger.error("DWFS getDetails error" + e);
			} catch (IllegalAccessException e) {
				logger.error("DWFS getDetails error" + e);
			} catch (InvocationTargetException e) {
				logger.error("DWFS getDetails error" + e);
			} catch (ClassNotFoundException e) {
				logger.error("DWFS getDetails error" + e);
			} catch (SecurityException e) {
				logger.error("DWFS getDetails error" + e);
			}
			return entity;
		}
	@Override
	protected void mapParameters() {
		super.mapParameters();
	}
	
}