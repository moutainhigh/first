
    package com.deppon.montal.conf; 

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.eos.foundation.common.utils.DateUtil;


   /** 
 * @Title: F_Constants.java
 * @Package com.deppon.montal.conf 
 * @Description: (返回页面URL常量定义) 
 * @author 廖建雄 
 * @date 2013-2-26 上午8:54:23 
 * @version V1.0 
 */
public class F_Constants {
    
	//---------------------登录相关UI begin-----------------------------
	
	public static final String UI_IOS = "ios";
	public static final String UI_WIN8 = "win8";
	//苹果应用
	public static final String APP_IOS = "APP-IOS";
	//安卓应用
	public static final String APP_Android = "APP-Android";
	
	public static final String UI_IPHONE = "iPhone";
	public static final String IS_DISPLAY_FILES = "Mobile";
	
	public static final String FORWARD_PATH_LOGIN = "/login/login.jsp";
	
	public static final String IOS_FORWARD_PATH_LOGIN = "/login/ios_login.jsp";
	
	public static final String FORWARD_PATH_MAIN = "/jsp/main.jsp";
	
	public static final String IOS_FORWARD_PATH_MAIN = "/jsp/ios/main.jsp";
	
	//登录权限编码
	public static final String COMPETENCE_CODE = "DPM001";
	
	//---------------------登录相关UI end-----------------------------
   
	//---------------------通讯录UI begin-----------------------------
	
	public static final String FORWARD_PATH_ADDSDETAIL = "/jsp/addresslist/addr_detail.jsp";
	
	public static final String IOS_FORWARD_PATH_ADDSDETAIL = "/jsp/ios/addresslist/addr_detail.jsp";
	//---------------------通讯录UI end-----------------------------
	//---------------------公告UI begin-----------------------------
	
	 public static final String FORWARD_PATH_ANNDETAIL = "/jsp/notice/announcement_detail.jsp";

	 public static final String IOS_FORWARD_PATH_ANNDETAIL = "/jsp/ios/notice/announcement_detail.jsp";

	
	//---------------------公告UI end-----------------------------
	
	
	//-------------------- 工作流类型  begin ------------------------------
    
	//APPLYINFO表中工作流来源标示：来源报账
	public static final String FSSC_WORKFLOW_SYSCODE = "FSSC";
	
	//APPLYINFO表中工作流来源标示：来源后勤
	public static final String DLSP_WORKFLOW_SYSCODE = "DLSP";
	
	//APPLYINFO表中工作流来源标示：来源门户二期
	public static final String DWFS_WORKFLOW_SYSCODE = "DWFS";
	
	//APPLYINFO表中工作流来源标示：来源CRM系统
	public static final String CRM_WORKFLOW_SYSCODE = "ICRM";
	
	//老OA工作流标示
	public static final String DIPOA_WORKFLOW_SYSCODE = "DIPOA"; 
	
	//APPLYINFO表中工作流来源标示：来源NHR系统
	public static final String HR_WORKFLOW_SYSCODE = "INHR";
	//网点规划系统
	public static final String WDGH_WORKFLOW_SYSCODE = "WDGH";
	//网点规划系统
	public static final String ACMS_WORKFLOW_SYSCODE = "ACMS";
	//APPLYINFO表中工作流来源标示：来源后勤，这个是走esb的
//	public static final String LSP_WORKFLOW_SYSCODE = "LSP";
	
	//APPLYINFO表中工作流来源标示：来源FIN_SELF系统
	public static final String FIN_SELF_WORKFLOW_SYSCODE = "FINS";
	
    /**增补员*/
    public static final String PERSONADD_TYPE = "dip.workflow.personnel.personadd.personadd";
    /**文件发布申请*/								
    public static final String FILEPUBLISH_TYPE = "dip.integrateflow.personnel.filePublish.filePublishApply";
    /**签订合同申请*/								
    public static final String CONTRACTSIGN_TYPE = "dip.workflow.administrative.contracts.contractSignApply.contractSignApply";
	
	/**请假/调休*/
    public static final String LEAVE_TYPE = "dip.integrateflow.performance.leaveapply.leaveapply";
    /**离职申请*/
    public static final String RESIGN_TYPE = "dip.workflow.personnel.profession.resign.resign";
    /**常规理赔*/
    public static final String CLAIMS_TYPE = "dip.workflow.operation.claims.normalclaim.normalClaim";
    /**月结客户签订申请*/
    public static final String CONTRACTADD_TYPE = "dip.workflow.administrative.contracts.contractadd.contractAdd";
    /**工作流审批回退按钮显示*/
    public static final String ROLLBAIK_SHOW = "show";
    /**工作流审批回退按钮显示*/
    public static final String ROLLBAIK_HIDE = "hide";
    /**系统数据变更申请*/
    public static final String  SYS_DATA_CHANGES= "dip.workflow.it.sysdatachange.sysdatachange";
    /**付款单——外请车*/
    public static final String  RENT_CAR_OUTSIDES= "dip.integrateflow.costcontrol.rentCarOutside.rentCarOutside";
    /**通用费用报销单*/
    public static final String  EXPENSE_CLAIMS = "dip.integrateflow.costcontrol.dl.expenseClaims.expenseClaims";
    /**福利费用报销申请*/
    public static final String  BENIFITFEE = "dip.integrateflow.costcontrol.dl.benifitFee.benifitFee";
    /**补考勤*/
    public static final String  ADDATTENDANCE = "dip.integrateflow.performance.addattendance.addattendance";    
    /**出差申请*/
    public static final String  ONBUSINESS = "dip.integrateflow.costcontrol.af.onBusiness.onBusiness"; 
    /**推荐新员工*/
    public static final String RECOMMANDNEWEMP = "dip.workflow.personnel.recommendNewEmp.recommendNewEmp";
    /**数据预算审批*/
    public static final String OA_BUDGETDATAAPPLY = "dip.workflow.finance.managementcontrol.budgetData";
    /**日常付款*/
    public static final String DAILYPAYMENT = "dip.integrateflow.costcontrol.po.dailyPayment.dailyPayment";
    /**系统权限申请*/
    public static final String SYSTEMPOWERAPPLY = "dip.workflow.it.systemPowerApply.systemPowerApply";
    /**实体合同借阅*/
    public static final String REALCONTRACTBORROW = "dip.integrateflow.archives.realContractBorrow.realContractBorrow";
    /**应酬费用报销申请*/
    public static final String ENTERTAINMENTEXPENSE = "dip.integrateflow.costcontrol.dl.entertainmentExpense.entertainmentExpense";
    /**数据提供审批*/
    public static final String DATA_PROVIDE_APPLY = "dip.integrateflow.performance.dataProvide.dataProvideApply";
    /**人员异动借调申请*/
    public static final String EMP_TRANS_APPLY = "dip.integrateflow.personnel.changeandresign.employeeTransactionApply";
    /**房租*/
    public static final String RENT = "dip.integrateflow.costcontrol.po.rent.rent";
    /**物资资产采购报销申请*/
    public static final String  MATERIAL_PROPERTY_APPLY = "dip.integrateflow.costcontrol.dl.wuzizicancaigou.wuzizicancaigou";
   /**外请车付款单*/
    public static final String CAR_OUTSIDES_RENT = "dip.integrateflow.costcontrol.newType.rentCarOutsides.rentCarOutsides";
   /**日常（新）*/
    public static final String DAILY_NEW = "dip.integrateflow.costcontrol.bo.everyday2.everyday2";
    /**应酬费（新）*/
    public static final String FEE_NEW = "dip.integrateflow.costcontrol.bo.EntertainmentFees2.EntertainmentFees";
    /**多赔*/
    public static final String MUCH_PAY = "dip.workflow.operation.claims.muchrecompensate.muchRecompens";
    /**工伤医疗费用报销申请*/
    public static final String INJURY_MEDICAL_EXPENSES_APPLY = "dip.integrateflow.costcontrol.dl.workRelatedInjury.workRelatedInjury";
    /**借款—福利（新）*/
    public static final String BENIFITFEES_NEW = "dip.integrateflow.costcontrol.bo.benefits2.benefits";
    /**车辆付款*/
    public static final String VEHICLE_PAY = "dip.integrateflow.costcontrol.po.vehiclePayment.vehiclePayment";
    /**工伤医疗费用（新）*/
    public static final String INJURY_MEDICAL_EXPENSES_NEW = "dip.integrateflow.costcontrol.bo.injuryMedical2.injuryMedical2";
    /**场地租赁申请*/
    public static final String SITE_RENT = "dip.workflow.logistics.courtRent.courtRent";
    /**资金运作*/
    public static final String FUNDS_OPERATION = "dip.integrateflow.financial.runfinance.runfinance";
    /**专项费用立项申请*/
    public static final String SPECIAL_EXPENSES_PROJECT = "dip.integrateflow.financial.zhuanfeilixaing.zhuanfeilixiang";
    /**行政类合同申请*/
    public static final String CONTRACT_ADMINISTRATIVE = "dip.workflow.administrative.contracts.administrationKindContractApply.administrationKindContractApply";
    /**场地转租*/
    public static final String SITE_SUBLEASE = "dip.workflow.logistics.courtSublet.courtSublet";
    /**诉讼案件立案/外请律师申请*/
    public static final String CASES_REGISTERED = "dip.integrateflow.performance.outsidelawyer.outsidelawyer";
    /**考核方案申请*/
    public static final String ASSESS_PROGRAM = "dip.workflow.personnel.payment.assessProgram.assessProgram";
    /**任职资格申请*/
    public static final String QUALIFICATIONAUTH ="dip.integrateflow.personnel.qualificationauth.QualificationAuth";
    /**借章申请*/
    public static final String BORROW_SEAL = "dip.integrateflow.archives.borrowSealApply.borrowSealApply";
    /**加班/加班工资申请*/
    public static final String OVERTIME = "dip.integrateflow.personnel.overtime.Overtimeapply2";
    /**免职申请*/
    public static final String DISMISSAL = "dip.integrateflow.personnel.dismissal.dismissal_modify";
    /**营销活动申请*/
    public static final String MARKETING_ACTIVITIES = "dip.workflow.operation.run.marketingActivities.marketingActivities";
    /**考核特批减免申请*/
    public static final String ASSESSREDUCE = "dip.integrateflow.performance.assessreduce.apply";
    /**付款申请（香港）*/
    public static final String PAYMENT = "dip.workflow.finance.reimbursement.payment.payment";
    /**课程研发/审核申请*/
    public static final String LESSON_RESEARCH = "dip.workflow.train.lessonResearch.lessonResearch";
    /**费用报销申请香港*/
    public static final String EXPENSE_ACCOUNT_HK = "dip.workflow.finance.reimbursement.expenseaccount.expenseaccount";
    /**折扣申请*/
    public static final String DISCOUNT = "dip.workflow.operation.manage.discount.discount";
    /**借支申请*/
    public static final String LOAN_PAYMENT = "dip.workflow.finance.loanPayment.loanPayment";
    /**场地设计*/
    public static final String COURT_DESIGN = "dip.workflow.logistics.courtDesign.courtDesign";
    /**外训申请*/
    public static final String EDUCATE_BY_OUTSIDE = "dip.workflow.train.educateByOutSide.educateByOutSide";
    /**回原籍申请*/
    public static final String RETURN_DOMICILE_OF_ORIGIN = "dip.workflow.personnel.profession.returnDomicileOfOrigin.returnDomicileOfOrigin";
    /**开设新点/搬迁旧点申请(201303)*/
    public static final String REMOVAL_APPLY_NEW = "dip.integrateflow.management.removalApply.removalApplyNew";
    /**项目类合同申请*/
    public static final String PROJECT_KIND_CONTRACT_APPLY = "dip.workflow.administrative.contracts.projectKindContractApply.projectKindContractApply";
    /**子公司设立及变更申请新*/
    public static final String SUB_SIDIARYSET = "dip.integrateflow.financial.subsidiaryset.subsidiaryset";
    /**管理人员转正/成长期通过申请工作流*/
    public static final String MANAGER_BECOME = "dip.workflow.personnel.profession.managerBecomesApply.managerBecomesApply";    
    
    
    /**2013 08 14 新增工作流*/
    /**用章申请*/
    public static final String USE_SEAL_APPLY = "dip.integrateflow.archives.useSealApply.useSealApply";
    /**数据需求审批流程*/
    public static final String DATA_REQUIRE = "dip.integrateflow.performance.datarequire.datarequire";
    /**培训请假*/
    public static final String TRAIN_LEAVE = "dip.workflow.train.trainleave.trainleave";
    /**人事授权申请*/
    public static final String PERSONEL_IMPOWER = "dip.integrateflow.personnel.personelimpower.personelimpower";
    /**业务类坏账申请*/
    public static final String BUSINESS_BAD_DEBTS = "dip.workflow.finance.reaccount.baddebtmanager.businessBaddebts";
    /**非业务类坏账申请*/
    public static final String BAD_DEBT = "dip.workflow.finance.reaccount.baddebtmanager.baddebt";
    /**扣货申请工作流*/
    public static final String DETAINED_GOODS = "dip.workflow.operation.manage.kouhuoApply.Kouhuo";
    /**电子合同借阅*/
    public static final String ELECTRONIC_CONTRACT_BORROW = "dip.integrateflow.archives.electronicContractBorrow.electronicContractBorrow";
    
    /**2013 08 20新增工作流*/
    /**整车货物运输合同*/
    public static final String TRUCK_LOAD_TRANSPORT = "dip.integrateflow.contract.cargoTransContract.cargoTransContract";
    /**优秀人才推荐*/
    public static final String TALENT_RECOMMENDATION = "dip.integrateflow.personnel.recommandexcellentemp.recommendexcellentemp";
    /**分公司证照注销*/
    public static final String LICENSE_CANCELL = "dip.workflow.operation.manage.licenseCancellApply.licenseCancellApply";
    /**培训需求*/
    public static final String TRAIN_REQUIREMENT = "dip.workflow.train.trainrequirement.trainrequirement";
    /**证照借阅申请（新）*/
    public static final String LICENSES_BORROW = "dip.integrateflow.archives.loanCertificate.LoanCertificateApplyNew";
    /**发文审核申请*/
    public static final String DISPATCH_CENSOR = "dip.workflow.administrative.legalaffairs.dispatchCensor.dispatchCensor";
    /**刻章申请*/
    public static final String SEAL_CARVE_APPLY = "dip.integrateflow.archives.sealCarveApply.sealCarveApply";
    /**银行开户/销户申请*/
    public static final String BANKACCOUNT_OPENCL = "dip.integrateflow.financial.bankaccountopencl.bankaccountopencl";
    /**场地找点*/
    public static final String COURT_FIND_SITE = "dip.workflow.logistics.court.courtFindSite";
    /**流程新建/变更/废除*/
    public static final String PROCESS_MANAGER = "dip.workflow.it.processManager.processManager";
    
    /**2013-11-04新增工作流 */
    /**采购合同变更 */
    public static final String LSP_PURCHASE_CONTRACT_CHANGE = "com.deppon.bpms.module.lsp.bpsdesign.purchase.purchaseContractChange";
    /**日常报账单-异常代收货款退款*/
    public static final String FSSC_UNUSUALAGENTREFUND = "com.deppon.bpms.module.fssc.bpsdesign.dailyRepbill.unusualAgentRefund";
    /**薪酬福利报账单-福利费*/
    public static final String FSSC_WELFARE_FEE_APPLY = "com.deppon.bpms.module.fssc.bpsdesign.salaryWelfareBill.WelfareFeeApply";
    
    /**异常代收货款退款*/
    public static final String FSSC_ABNORMAL_REFUND_APPLY = "com.deppon.bpms.module.fssc.bpsdesign.dailyRepbill.unusualAgentRefund";
    
    
    /**后勤系统所有工作流*/
    /*public static final String ALL_WORKFLOW_TYPES_LSP = " "+
            "'"+LSP_PURCHASE_CONTRACT_CHANGE+"'" ;*/
    public static String ALL_WORKFLOW_TYPES_LSP = "";
    /**付款申请单*/
    public static String DLSP_PAYMENT_APPLY = "com.deppon.bpms.module.lsp.bpsdesign.purchase.paymentApply";
    /**采购合同*/
    public static String DLSP_PURCHASE_CONTRACT = "com.deppon.bpms.module.lsp.bpsdesign.purchase.purchaseContract";
    /**采购合同变更*/
    public static String DLSP_PURCHASE_CONTRACT_CHANGE = "com.deppon.bpms.module.lsp.bpsdesign.purchase.purchaseContractChange";
    /**报账系统所有工作流*/
   /* public static final String ALL_WORKFLOW_TYPES_FSSC = " "+
            "'"+FSSC_UNUSUALAGENTREFUND+"', "+
    		"'"+FSSC_WELFARE_FEE_APPLY+"' ";*/
    public static String ALL_WORKFLOW_TYPES_FSSC = "";
    
    /**CRM系统所有工作流*/
    public static String ALL_WORKFLOW_TYPES_ICRM = "";
    
    /**后勤系统所有工作流*/
//    public static String ALL_WORKFLOW_TYPES_LSPESB = "";
    /**FIN_SELF财务自助工作流*/
    public static String ALL_WORKFLOW_TYPES_FIN_SELF = "";
    /**HR工作流*/
    public static String ALL_WORKFLOW_TYPES_HR = "";
    /**WDGH工作流*/
    public static String ALL_WORKFLOW_TYPES_WDGH = "";
    /**ACMS工作流*/
    public static String ALL_WORKFLOW_TYPES_ACMS = "";
    /**门户二期所有工作流*/
    public static String ALL_WORKFLOW_TYPES_DWFS = "";
    
    public static String HR_POSITIVEAPPLY_PROCEDEFNAME= "com.deppon.bpms.module.nhr.bpsdesign.personnel.positiveApplication";
    
    /**门户二期新迁工作流*/
    
    /**通用审批action*/
    public static String NORMOL_APPROVAL_URL = "approvalWorkFlow.action";
    /**特殊审批页面，保存业务信息*/
    public static String SAVE_ENTITY__APPROVAL_URL = "newDeptApplyAction.action";
    /**特殊审批界面 保存业务数据*/
    public static String APPROVAL_SAVEENTITY_URL = "approvalWithbizEntity.action";
    /**任职资格审批界面 保存业务数据*/
    public static String APPROVAL_QUALIFICATION_URL = "qualificationApproval.action";
    /**场地搬迁资源协调 特殊审批保存业务数据*/
    public static String APPROVAL_COURTRELOCATION_URL = "approvalWithbizEntity.action";
    
    /**门户二期特殊审批界面需要的实体bean文件路径*/
    /**一线反馈问题实体bean*/
    public static String PROBLEM_BEAN = "com.deppon.wfs.regulations.server.domain.ProblemFeedbackBean";
    /**开线申请bean*/
    public static String ONLINE_BEAN = "com.deppon.wfs.regulations.server.domain.OnlineBean";
    /**快递新增试点网点申请bean*/
    public static String EXPNEWPILOTOUTLETS_BEAN = "com.deppon.wfs.regulations.server.domain.ExpressNewPilotBean";
    /**场地搬迁资源协调*/
    public static String COURTRELOCATION_BEAN= "com.deppon.wfs.regulations.server.domain.CourtRelocationBean";
    
    /**离职工作流工作流审批*/
    public static String RESIGN_APPROVAL_URL="resignApprovalAction.action";
    /**外训申请工作流审批URL*/
    public static String EXTERNALSTUDY_APPROVAL_URL="resignApprovalAction.action";
    /**场地租赁/转租合同审批URL*/
    public static String YARDRENT_APPROVAL_URL="yardRentApproval.action";
    
    /**离职工作流*/
    public static String DWFS_RESIGN = "com.deppon.bpms.module.wfs.bpsdesign.personnel.resignation";
    /**场地租赁/转租合同*/
    public static String DWFS_SITERENT = "com.deppon.bpms.module.wfs.bpsdesign.administrationLegal.siteRent";
    /**外训申请*/
    public static String DWFS_EXTERRNAL = "com.deppon.bpms.module.wfs.bpsdesign.personnel.externalStudy";
    /**预算数据申请*/
    public static String DWFS_BUDGETDATA = "com.deppon.bpms.module.wfs.bpsdesign.finance.budgetData";
    /**加班/加班工资申请*/
    public static String DWFS_OVERTIMEPAY_APPLY = "com.deppon.bpms.module.wfs.bpsdesign.personnel.overtimePayApply";
    
    /**任职资格申请工作流*/
    public static String DWFS_QUALI_FICATION_APPLY = "com.deppon.bpms.module.wfs.bpsdesign.personnel.qualificationApply";
    /**任职资格实体*/
    public static String DWFS_QUALI_FICATION_BEAN = "com.deppon.wfs.regulations.server.domain.QualificationApplyBean";
    /**银行开户销户申请*/
    public static String DWFS_BANK_ACCOUNT = "com.deppon.bpms.module.wfs.bpsdesign.finance.BankAccount";
    /**银行开户销户实体bean*/
    public static String BANK_ACCOUNT_BEAN = "com.deppon.wfs.regulations.server.domain.Bankaccount";
    /**数据提供审批*/
    public static String DWFS_DATA_PROVIDE = "com.deppon.bpms.module.wfs.bpsdesign.personnel.dataProvide";
    /**专项费用立项*/
    public static String DWFS_SPECIAL_FUNDS_PROJECT = "com.deppon.bpms.module.wfs.bpsdesign.finance.specialFundsProject";
    /**补考勤申请*/
    public static String DWFS_REPAIR_ATTENDANCE = "com.deppon.bpms.module.wfs.bpsdesign.personnel.repairAttendance";
    /**管理人员转正成长期通过*/
    public static String DWFS_MANAGER_GROWTH_STAGE_PASS="com.deppon.bpms.module.wfs.bpsdesign.personnel.managerGrowthStagePass";
    
    /**营销活动申请申请工作流*/
    public static final String DWFS_MARKETACTIVITY = "com.deppon.bpms.module.wfs.bpsdesign.operation.marketingActivities"; 
    /**培训需求或变更申请*/
    public static final String DWFS_TRAIN = "com.deppon.bpms.module.wfs.bpsdesign.personnel.trainNeedsORChange";
    /**考核方案申请*/
    public static final String DWFS_ASSESSMENTSCHEME = "com.deppon.bpms.module.wfs.bpsdesign.personnel.assessmentScheme";
    /**考核特批减免申请*/
    public static final String DWFS_ASSESSREDUCE = "com.deppon.bpms.module.wfs.bpsdesign.performance.assessreduce";
    /**人事授权申请 */
    public static final String DWFS_WARRANT = "com.deppon.bpms.module.wfs.bpsdesign.personnel.warrant";
    /**整车货物运输合同*/
    public static final String DWFS_CARGOTRANS_CONSTRACT = "com.deppon.bpms.module.wfs.bpsdesign.administrationLegal.carGoTransContract";
    /**推荐新员工*/
    public static String DWFS_RECOMMEND_NEW_EMP = "com.deppon.bpms.module.wfs.bpsdesign.personnel.recommendNewEmp";
    
    /**免职申请*/
    public static String DWFS_DISMISSAL = "com.deppon.bpms.module.wfs.bpsdesign.personnel.dismissal";
    /**诉讼案件立案/外请律师申请*/ 
    public static String DWFS_LAYWERAPPLY = "com.deppon.bpms.module.wfs.bpsdesign.administrationLegal.litigationLawyers";
    /**考核方案申请*/
    public static String DWFS_ASSESSMENTSCHEMEAPPLY = "com.deppon.bpms.module.wfs.bpsdesign.strategy.assessmentScheme";
    /**课程研发/审核申请*/
    public static String DWFS_CURRICULUM_AUDIT = "com.deppon.bpms.module.wfs.bpsdesign.personnel.curriculumDevelopmentUpdateAudit";
    /**折扣申请*/
    public static String DWFS_DISCOUNT = "com.deppon.bpms.module.wfs.bpsdesign.business.discount";
    /**考核数据提交申请*/
    public static String DWFS_INSPECTIONDATASUBMIT = "com.deppon.bpms.module.wfs.bpsdesign.strategy.inspectionDataSubmit";
    /**考核特批减免申请 蔡兵兵*/
    public static String DWFS_ASSESSREDUCE_NEW = "com.deppon.bpms.module.wfs.bpsdesign.strategy.assessreduce";
    /** 管理文件发布申请  gaoyazhe*/
    public static String  DWFS_CHACKFILE = "com.deppon.bpms.module.wfs.bpsdesign.administrationLegal.checkFileApply";
    /**销售激励申请 **/
    public static String DWFS_SELLENCOURAGE = "com.deppon.bpms.module.wfs.bpsdesign.business.sellEncourage";
    /**扣货申请*/
    public static final String DWFS_DEDUCTCARGO = "com.deppon.bpms.module.wfs.bpsdesign.business.deductCargo";
    /**场地找点申请*/
    public static final String DWFS_SITEFINDPOINTSAPPLY = "com.deppon.bpms.module.wfs.bpsdesign.logistics.siteFindPointsApply";
    /**新部门成立申请*/
    public static final String DWFS_NEW_DEPT_APPLY = "com.deppon.bpms.module.wfs.bpsdesign.personnel.newDeptApply";
    /** 系统权限申请 */
    public static final String DWFS_SYSJURISDICTIONAPPLY = "com.deppon.bpms.module.wfs.bpsdesign.it.sysJurisdictionApply";
    /**财务档案借阅申请 */
    public static final String DWFS_FINANCIALARCHIVESLENDING = "com.deppon.bpms.module.wfs.bpsdesign.financial.financialArchivesLending";
    /**合同签订申请*/
    public static final String DWFS_CONTRACT_APPLY = "com.deppon.bpms.module.wfs.bpsdesign.administrationLegal.contractApply";
    /**流程管理工作流*/
    public static final String DWFS_PROCESSMANAGEMENT = "com.deppon.bpms.module.wfs.bpsdesign.other.processManagement";
    /**借章申请*/
    public static final String DWFS_BORROWSEALAPPLY = "com.deppon.bpms.module.wfs.bpsdesign.administrationLegal.borrowSealApply";
    /**项目类合同申请*/
    public static final String DWFS_PROJECTCONTRACTAPPLY = "com.deppon.bpms.module.wfs.bpsdesign.administrationLegal.projectContractApply";
    /**价格调整*/
    public static final String DWFS_ADJUSTPRICE = "com.deppon.bpms.module.wfs.bpsdesign.business.adjustPrice";
    /**活动报名申请*/
    public static final String DWFS_ACTREGISTRATIONAPP = "com.deppon.bpms.module.wfs.bpsdesign.logistics.actRegistrationApp";
    /**学车报名申请*/
    public static final String DWFS_LEARNCAR = "com.deppon.bpms.module.wfs.bpsdesign.logistics.learnCar";
    /**市场调研申请*/
    public static final String DWFS_MARKETRESEARCH = "com.deppon.bpms.module.wfs.bpsdesign.business.marketResearch";
    /**接待申请*/
    public static final String DWFS_ADMITAPPLYBEAN = "com.deppon.bpms.module.wfs.bpsdesign.administrationLegal.admitapply";
    /**营运提成单项奖设立与调整申请*/
    public static final String DWFS_COMMISSIONMAKEORCHANGEBEAN = "com.deppon.bpms.module.wfs.bpsdesign.strategy.commissionMakeOrChange";
    /**一线问题反馈*/
    public static final String DWFS_PROBLEMFEEDBACKBEAN = "com.deppon.bpms.module.wfs.bpsdesign.business.problemFeedback";
    /**实体合同借阅申请*/
    public static final String DWFS_REALCONTRACTBORROW = "com.deppon.bpms.module.wfs.bpsdesign.administrationLegal.realContractBorrow";
    /**商铺租赁合同申请*/
    public static final String DWFS_STORERENT = "com.deppon.bpms.module.wfs.bpsdesign.contract.storeRent";
    /**章程/决议审批申请*/
    public static final String DWFS_RULEAPPROVAL = "com.deppon.bpms.module.wfs.bpsdesign.administrationLegal.ruleApproval";
    /**法定代表人/负责人签字申请*/
    public static final String DWFS_LEGALREPRESENTSIGNAPPLY = "com.deppon.bpms.module.crm.bpsdesign.administLegal.legalRepresentSignApply";
    /**新增岗位申请*/
    public static final String DWFS_POSTAPPLY = "com.deppon.bpms.module.wfs.bpsdesign.personnel.addPostApply";
    /**福利费发放申请 WelfarePaymentBean*/
    public static final String DWFS_WELFAREPAYMENT = "com.deppon.bpms.module.wfs.bpsdesign.personnel.welfarePaymentApply";
    /**集中接货 CentralizedPickBean*/
    public static final String DWFS_CENTRALIZEDPICK = "com.deppon.bpms.module.wfs.bpsdesign.operation.centralizedPick";
    /**企划类设计制作申请 PlainDesignBean*/
    public static final String DWFS_PLAINDESIGN = "com.deppon.bpms.module.wfs.bpsdesign.business.planningDesignApply";
    /**偏线代理合同*/
    public static final String DWFS_OTHERSIDELINGPOXY = "com.deppon.bpms.module.wfs.bpsdesign.operation.otherSideLinePoxy";
    /**货车配件采购/维修/保养*/
    public static final String DWFS_TRUCKPARTBUYMAINTAIN = "com.deppon.bpms.module.wfs.bpsdesign.logistics.truckPartBuyMaintain";
    /**工资信息更改申请*/
    public static final String DWFS_PAYMENTWAGEINFO = "com.deppon.bpms.module.wfs.bpsdesign.personnel.paymentWageinfo";
    /**员工宿舍*/
    public static final String DWFS_EMPDORM = "com.deppon.bpms.module.wfs.bpsdesign.logistics.empDorm";
    
    /**节点与产品调整实体*/
    public static final String DWFS_PRODUCTADJUSTMENT = "com.deppon.bpms.module.wfs.bpsdesign.business.productAdjustment";
    
    /**成立接货开单查询组申请*/
    public static final String DWFS_FOUNDPICKBILLQUERYTEAM = "com.deppon.bpms.module.wfs.bpsdesign.business.foundPickbillQueryTeam";
    /**长途司机时效减免申请*/
    public static final String DWFS_LONGDISDRIVERAGINGBREAKS = "com.deppon.bpms.module.wfs.bpsdesign.operation.longDisDriverAgingBreaks";
    /**员工退回人力资源部*/
    public static final String DWFS_STAFFRETURNTOHR = "com.deppon.bpms.module.wfs.bpsdesign.personnel.staffReturnToHR";
    /**合同销毁*/
    public static final String DWFS_DESTROYCONTRACT = "com.deppon.bpms.module.wfs.bpsdesign.contract.destroyContract";
    /**网站信息发布*/
    public static final String DWFS_WEBINFOPUBLICSH = "com.deppon.bpms.module.wfs.bpsdesign.business.webinfoPublish";
    /**开线申请*/
    public static final String DWFS_ONLINEAPPLY = "com.deppon.bpms.module.wfs.bpsdesign.operation.online";
    /**借支申请*/
    public static final String DWFS_LOANPAYMENT = "com.deppon.bpms.module.wfs.bpsdesign.finance.loanPaymentApply";
    /**资金运作*/
    public static final String DWFS_RUNFINANCE = "com.deppon.bpms.module.wfs.bpsdesign.finance.runfinance";
    /**刻章申请*/
    public static final String DWFS_SEALCARVE = "com.deppon.bpms.module.wfs.bpsdesign.logistics.sealCarveApply";
    /**系统数据变更申请*/
    public static final String DWFS_SYSTEMDATACHANGEAPPLY = "com.deppon.bpms.module.wfs.bpsdesign.it.systemDataChangeApply";
    /**系统数据变更申请实体命名*/
    public static final String DWFS_SYSTEMDATACHANGEAPPLY_BEAN = "com.deppon.wfs.regulations.server.domain.SystemDataChangeApplyBean";
    /** 人员外请申请*/
    public static final String DWFS_PERSONNELOUTSIDE = "com.deppon.bpms.module.wfs.bpsdesign.operation.personnelOutside";
    /**快递新增试点网点申请*/
    public static final String DWFS_EXPNEWPILOTOUTLETS = "com.deppon.bpms.module.wfs.bpsdesign.express.expNewPilotOutlets";
    /**场地搬迁资源协调*/
    public static final String DWFS_COURTRELOCATION = "com.deppon.bpms.module.wfs.bpsdesign.logistics.courtRelocation";
    
    /**所有工作流*/
    /*public static  String ALL_WORKFLOW_TYPES = "'"+MATERIAL_PROPERTY_APPLY+"', " +
    		"'"+TRUCK_LOAD_TRANSPORT+"', " +
    		"'"+TALENT_RECOMMENDATION+"', " +
    		"'"+LICENSE_CANCELL+"', " +
    		"'"+TRAIN_REQUIREMENT+"', " +
    		"'"+LICENSES_BORROW+"', " +
    		"'"+DISPATCH_CENSOR+"', " +
    		"'"+SEAL_CARVE_APPLY+"', " +
    		"'"+BANKACCOUNT_OPENCL+"', " +
    		"'"+COURT_FIND_SITE+"', " +
    		"'"+PROCESS_MANAGER+"', " +
    		"'"+RENT+"', " +
    		"'"+EMP_TRANS_APPLY+"', " +
    		"'"+DATA_PROVIDE_APPLY+"', " +
    		"'"+ENTERTAINMENTEXPENSE+"', " +
    		"'"+REALCONTRACTBORROW+"', " +
    		"'"+SYSTEMPOWERAPPLY+"', " +
    		"'"+DAILYPAYMENT+"', " +
    		"'"+OA_BUDGETDATAAPPLY+"', " +
    		"'"+RECOMMANDNEWEMP+"', " +
    		"'"+ONBUSINESS+"', " +
    		"'"+ADDATTENDANCE+"', " +
    		"'"+BENIFITFEE+"', " +
    		"'"+EXPENSE_CLAIMS+"', " +
    		"'"+RENT_CAR_OUTSIDES+"', " +
    		"'"+SYS_DATA_CHANGES+"', " +  
			"'"+CONTRACTADD_TYPE+"', " +  
			"'"+CLAIMS_TYPE+"', " +   
			"'"+RESIGN_TYPE+"', " +  
			"'"+LEAVE_TYPE+"', " +      			
    		//"'"+CONTRACTADD_TYPE+"', " +
    		"'"+FILEPUBLISH_TYPE+"', " +
    		"'"+PERSONADD_TYPE+"', " +
    		"'"+CAR_OUTSIDES_RENT+"', " +
    		"'"+DAILY_NEW+"', " +
    		"'"+FEE_NEW+"', " +
    		"'"+MUCH_PAY+"', " +
    		"'"+INJURY_MEDICAL_EXPENSES_APPLY+"', " +
    		"'"+BENIFITFEES_NEW+"', " +
    		"'"+VEHICLE_PAY+"', " +
    		"'"+INJURY_MEDICAL_EXPENSES_NEW+"', " +
    		"'"+SITE_RENT+"', " +
    		"'"+FUNDS_OPERATION+"', " +
    		"'"+SPECIAL_EXPENSES_PROJECT+"', " +
    		"'"+CONTRACT_ADMINISTRATIVE+"', " +
    		"'"+SITE_SUBLEASE+"', " +
    		"'"+ASSESS_PROGRAM+"', " +
    		"'"+QUALIFICATIONAUTH+"', " +
    		"'"+BORROW_SEAL+"', " +
    		"'"+CONTRACTSIGN_TYPE+"', " +
    		"'"+OVERTIME+"', " +
    		"'"+DISMISSAL+"', " +
    		"'"+MARKETING_ACTIVITIES+"', " +
    		"'"+ASSESSREDUCE+"', " +
    		"'"+PAYMENT+"', " +
    		"'"+LESSON_RESEARCH+"', " +
    		"'"+EXPENSE_ACCOUNT_HK+"', " +
    		"'"+MANAGER_BECOME+"', " +
    		"'"+LOAN_PAYMENT+"', " +
    		"'"+COURT_DESIGN+"', " +
    		"'"+EDUCATE_BY_OUTSIDE+"', " +
    		"'"+RETURN_DOMICILE_OF_ORIGIN+"', " +
    		"'"+REMOVAL_APPLY_NEW+"', " +
    		"'"+PROJECT_KIND_CONTRACT_APPLY+"', " +
    		"'"+SUB_SIDIARYSET+"', " +
    		"'"+DISCOUNT+"', " +
			"'"+ELECTRONIC_CONTRACT_BORROW+"', " +
			"'"+DETAINED_GOODS+"', " +
			"'"+BAD_DEBT+"', " +
			"'"+BUSINESS_BAD_DEBTS+"', " +
			"'"+PERSONEL_IMPOWER+"', " +
			"'"+TRAIN_LEAVE+"', " +
			"'"+DATA_REQUIRE+"', " +
			"'"+USE_SEAL_APPLY+"', " +
    		"'"+CASES_REGISTERED+"'" ;    	*/
    		
    public static  String ALL_WORKFLOW_TYPES = "";   
    public static String ALL_WORKFLOW = "";
    
    //------------------- 工作流类型  end ---------------------------------
    
    
    
    
    //-------------------- win8 URL begin -------------------------------
  
   /**滚动新闻列表*/
   public static final String ROLLNEWS_LIST_FORWARD = "/jsp/rollnews/rollnews_list.jsp";
   /**滚动新闻详情*/
   public static final String ROLLNEWS_LIST_DETAIL = "/jsp/rollnews/rollnews_detail.jsp";
   /**滚动新闻详情*/
   public static final String IOS_ROLLNEWS_LIST_DETAIL = "/jsp/ios/rollnews/rollnews_detail.jsp";
   //-------------------- win8 URL end ----------------------
   
   /**win8 URL**/
   public static final String WIN8_PATH ="/jsp/workitems/";
   /**ios URL**/
   public static final String IOS_PATH ="/jsp/ios/workitems/";
   
   //-------------------- 工作流详细页面  begin ----------------------
   /**车辆付款*/
   public static final String IOS_VEHICLE_PAY_PATH = "vehicle_pay.jsp";
   /**借款-福利（新）*/
   public static final String IOS_BENIFITFEES_NEW_PATH = "benifitfees_new.jsp";
   /**房租IOS*/
   public static final String IOS_RENT_PATH = "rent.jsp";
   /**数据预算审批IOS*/
   public static final String IOS_OA_BUDGETDATAAPPLY_PATH="budgetdata_apply.jsp";
   /**新员工推荐（新）IOS*/
   public static final String IOS_RECOMMANDNEWEMP_PATH = "recommand_emp.jsp";
   /**增补员IOS URL*/ 
   public static final String IOS_PERSONADD_FORWARD_PATH = "personadd.jsp";
   /**文件发布IOS URL*/
   public static final String IOS_FILEPUBLISH_FORWARD_PATH = "filepublish.jsp";
   /**签订合同申请IOS URL*/
   public static final String IOS_CONTRACTSIGN_FORWARD_PATH = "contractsign.jsp"; 
   /**月结客户签订申请IOS URL*/
   public static final String IOS_CONTRACTADD_FORWARD_PATH = "contractAdd.jsp";
   /**待办事宜IOS URL*/
   public static final String IOS_WORKFLOWS_FORWARD = "work_items.jsp";
   /**请假/调休 IOS URL*/
   public static final String IOS_LEAVE_WORKFLOW_FORWARD = "leave_workflow_approve.jsp";
   /**离职申请IOS URL*/
   public static final String IOS_RESIGN_WORKFLOW_FORWARD = "resign_workflow_approve.jsp";
   /**常规理赔IOS URL*/
   public static final String IOS_CLAIMS_WORKFLOW_FORWARD = "claims_workflow_approve.jsp";
   
   /**系统变更申请IOSURL*/
   public static final String IOS_DATA_CHANGES_FORWARD_PATH = "data_changes_approve.jsp";
   /**外请车IOSURL*/
   public static final String IOS_OUTSIDES_CAR_FORWARD_PATH = "outside_car_approve.jsp";
   /**通用费用报销单*/
   public static final String IOS_EXPENSE_CLAIMS_PATH = "expense_claims_approve.jsp";
   /**福利费用报销申请*/
   public static final String IOS_BENIFITFEE_PATH = "benifitFee_approve.jsp";
   /**补考勤申请*/
   public static final String IOS_ADDATTENDANCE_FORWARD_PATH = "addattendance.jsp";
   /**出差申请IOS URL*/
   public static final String IOS_TRAVEL_PATH = "travel_approve.jsp";
   /**实体合同借阅URL*/
   public static final String IOS_REALCONTRACT_BORROW_PATH = "realcontract_borrow_approve.jsp";
   /**系统权限申请URL*/
   public static final String IOS_SYSTEMPOWER_APPLY_PATH = "systemPowerApply.jsp";
   /**应酬费用报销URL*/
   public static final String IOS_ENTERTAINMENTEXPENSE_PATH = "entertainmentExpense.jsp";   
   /**日常付款URL*/
   public static final String IOS_DAILY_PAYMENT_PATH = "daily_payment_approve.jsp";
   /**数据提供审批IOS URL**/
   public static final String IOS_DATA_PROVIDE_APPLY_PATH = "data_provide_apply.jsp";
   /**人员异动借调申请IOS URL*/
   public static final String IOS_EMP_TRANS_APPLY_PATH = "emp_trans_apply.jsp";
   /**物资资产采购报销申请 URL */
   public static final String IOS_EXPENSE_ACCOUNT_BILL_PATH = "expenseaccountBill.jsp";
   /**外请车付款单 URL */
   public static final String IOS_CAR_OUTSIDES_RENT_PATH = "rent_car_outsides.jsp";
   /**日常（新）URL**/
   public static final String BOEVERY_DAY_RENT_PATH = "boeveryday_apply.jsp";
   /**多赔 URL**/
   public static final String MUCH_RECOMPENSATE_PATH = "much_recompens.jsp";
   /**应酬费（新） URL**/
   public static final String ENTERTAINMENT_FEES_PATH = "entertainment_fees_apply.jsp";
   /**工伤医疗费用（新） URL**/
   public static final String INJURY_MEDICAL_PATH = "boinjury_medical.jsp";
   /**工伤医疗费用报销申请 URL**/
   public static final String INJURY_MEDICAL_EXPENSES_PATH = "injury_medical_expenses_apply.jsp";
   /**加班/加班工资申请*/
   public static final String OVER_TIME_PATH = "over_time.jsp";
   /**资金运作申请URL*/
   public static final String  RUNFINANCE_PATH= "runfinance_apply.jsp";
   /**专项费用立项申请URL*/
   public static final String  SPECIFIC_PROJECT_FEE_PATH= "specific_project_fee _apply.jsp";
   /**行政类合同申请URL*/
   public static final String  ADMIN_CONTRACT_APPLY_PATH= "admin_contract_apply.jsp";  
   /**数据提供审批*/
   public static final String ASSESS_PROGRAM_PATH = "assess_program.jsp";
   /**诉讼案件立案/外请律师申请*/
   public static final String OURSIDE_LAYWER_PATH = "outside_laywer.jsp";
   /**免职申请*/
   public static final String DISMISSAL_APPLY_PATH = "dismissal_apply.jsp";
   /**场地租赁申请*/
   public static final String YARDRENT_APPLY_PATH = "yard_rent_apply.jsp";
   /**场地转租*/
   public static final String SITE_SUBLEASE_PATH = "oa_place_sublet.jsp";
   /**任职资格申请*/
   public static final String QUALIFICATIONAUTH_PATH = "qualificationauth.jsp";
   /**借章申请*/
   public static final String BORROW_SEAL_PATH = "borrow_seal_apply.jsp";
   /**子公司设立及变更申请*/
   public static final String SUBSIDIARYSET_PATH = "subsidiaryset.jsp";
   /**付款申请（香港）*/
   public static final String WFS_PAYMENT_PATH = "wfs_payment.jsp";
   /**新点开设/旧点搬迁*/
   public static final String REMOVAL_PATH = "removal_apply_new.jsp";
   
   /**营销活动申请JSP*/
   public static final String MARKETING_ACTIVITIES_PATH = "marketing_activities_apply.jsp";
   /**项目类合同签订申请*/
   public static final String PROJECT_CONTRACT_APPLY_PATH = "projectcontractapply.jsp";
   /**考核特批减免申请JSP*/
   public static final String ASSESSREDUCE_APPLY_PATH = "assessreduce_apply.jsp";
   /**费用报销申请（香港）*/
   public static final String EXPENSE_HK_PATH = "expense_hk.jsp";
   /**课程研发/审核申请JSP*/
   public static final String LESSON_PATH = "lesson_apply.jsp";
   
   /**回原籍*/
   public static final String RETURN_ORIGIN_PATH = "return_origin.jsp";
   /**借支申请*/
   public static final String LOAN_PAYMENT_PATH = "loan_payment.jsp";
   /**外训申请*/
   public static final String EDUCATE_OUTSIDE_PATH  ="educate_outside.jsp";
   
   /**折扣申请*/
   public static final String DISCOUNT_APPLY_PATH = "discount_apply.jsp";
   /**场地设计*/
   public static final String SITEDESIGN_APPLY_PATH = "sitedesign_apply.jsp";
   /**管理人员转正/成长期通过申请工作流*/
   public static final String MANAGER_BECOME_PATH  ="manager_become.jsp";
   /**用章申请*/
   public static final String USE_SEAL_APPLY_PATH = "use_seal_apply.jsp";
   /**人事授权申请*/
   public static final String PERSONEL_IMPOWER_PATH = "personelimpower.jsp";
   /**扣货申请*/
   public static final String DETAINED_GOODS_APPLY_PATH = "detained_goods_apply.jsp";
   /**数据需求审批流程 JSP */
   public static final String DATA_REQUIRE_PATH = "data_require_apply.jsp";
   /**培训请假JSP*/
   public static final String TRAIN_LEAVE_RATH ="trainleave_apply.jsp";
   /**非业务类坏账申请JSP*/
   public static final String BAD_DEBT_PATH = "baddebt.jsp";
   /**电子合同借阅申请JSP*/
   public static final String BUSINESS_BAD_DEBT_PATH = "business_bad_debt_apply.jsp";
   
   /**业务类坏账申请JSP*/
   public static final String ELECTRONIC_CONTRACT_BORROW_PATH = "elec_contract_borrow.jsp";
   
   /**整车货物运输合同*/
   public static final String TRUCK_LOAD_TRANSPORT_PATH = "oacargotranscontract.jsp";
   /**优秀人才推荐JSP*/
   public static final String RECOMMEND_STAFF_PATH = "recommend_excellent_staff.jsp";
   /**培训需求申请*/
   public static final String TRAIN_REQUEST_PATH = "train_request.jsp";
   /**刻章申请*/
   public static final String SEAL_CARVE_APPLY_PATH = "oasealcarveapply.jsp";
   /**流程新建/变更/废除*/
   public static final String MANAGER_PROCESS_PATH = "oamanagerprocess.jsp";
   /**分公司证照注销*/
   public static final String LICENSE_CANCELL_PATH = "license_canceled.jsp";
   /**发文审核申请*/
   public static final String CHECKFILE_APPLY_PATH = "check_file_apply.jsp";
   /**证照借阅申请(新)*/
   public static final String LICENSES_BORROW_PATH = "license_lend_read.jsp";
   /**银行开户/销户申请*/
   public static final String BANK_ACCOUNTOPENCL_PATH = "bank_account_opencl.jsp";
   /**场地找点*/
   public static final String COURT_FIND_SITE_PATH = "site_find_place_apply.jsp";
   
   
   /**FSSC页面PATH**/
   /**薪酬福利报账单-福利费*/
   public static final String FSSC_WELFARE_FEE_APPLY_PATH = "fssc/welfarism_apply.jsp";
   /**异常代收货款退款JSP*/
   public static final String FSSC_ABNORMAL_REFUND_APPLY_PATH = "fssc/abnormal_refund_apply.jsp";
   
   /**LSP详细页面*/
   /**采购合同变更*/
   public static final String LSP_PURCHASE_CONTRACT_CHANGE_PATH = "lsp/lsp_purchase_contract_change.jsp";
   
   //-------------------- 工作流详细页面 end ----------------------
   
   /**审批接口调用返回状态值*/
   public static final String APPORVE_TYPE_SUCCESS = "success";
   
   /**假期code转化中文输出*/
   public static String codeToString(String str){
       Map<String,  String> map = new HashMap<String,  String>();
       map.put("1",  "事假");
       map.put("2",  "病假");
       map.put("3",  "年假");
       map.put("4",  "婚假");
       map.put("5",  "丧假");
       map.put("6",  "产假");
       map.put("7",  "看护假");
       map.put("8",  "工伤假");
       map.put("9",  "产检假");
       
       if(!map.containsKey(str))
	   return str;
       
       return map.get(str);
   }
   
   public static  Map<String, String> WORKFLOW_RESULT_MAP = new HashMap<String, String>(){{
	   put("0", "同意");
	   put("1", "不同意");
	   put("2", "起草");
	   put("4", "退回");
	   put("5", "同意并结束");
	   put("6", "收回");
	   put("7", "业务回退");
   }};
   
   public static  Map<String, String> SYSTEMPOWER_TYPE_MAP = new HashMap<String, String>(){{
	   put("OUTER", "外网");
	   put("OA", "OA");
	   put("MAIL", "MAIL");
	   put("IT_INNER", "IT内部工具");
	   put("ERP", "ERP");
	   put("DLP", "DLP");
	   put("CRM", "其他");
	   put("LMS", "LMS");
	   put("EAS7.0", "金蝶7.0财务系统");
	   put("EIS", "影像系统");
	   put("FOSS", "FOSS");
	   put("FSSC", "报账系统");
   }};

   public static  Map<String, String> ENTERPRISEPERSONNEL_TYPE_MAP = new HashMap<String, String>(){{
	   put("0", "--请选择--");
	   put("W01000301041001", "东北事业部人事部");
	   put("W01000301041002", "河南事业部人事部");
	   put("W01000301041003", "山东事业部人事部");
	   put("W011206", "广州事业部人事部");
	   put("W011207", "深圳事业部人事部");
	   put("W011208", "北京事业部人事部");	   
	   put("W011209", "湖北事业部人事部");
	   put("W01120901", "西南事业部人事部");
	   put("W011210", "上海事业部人事部");
	   put("W17000313", "江苏事业部人事部");
	   put("W17000314", "浙江事业部人事部");
   }};
   
   /*
   public static Map<String, String> WF_FORWARD_MAP = new HashMap<String, String>(){{
       put(PERSONADD_TYPE, IOS_PERSONADD_FORWARD_PATH);// 增补员申请
       put(LEAVE_TYPE, IOS_LEAVE_WORKFLOW_FORWARD);// 请假调休
       put(FILEPUBLISH_TYPE,IOS_FILEPUBLISH_FORWARD_PATH);//文件发布
       put(RESIGN_TYPE, IOS_RESIGN_WORKFLOW_FORWARD);// 离职申请
       put(CONTRACTSIGN_TYPE, IOS_CONTRACTSIGN_FORWARD_PATH);// 合同签订
       put(CLAIMS_TYPE, IOS_CLAIMS_WORKFLOW_FORWARD);// 常规理赔
       put(SYS_DATA_CHANGES, IOS_DATA_CHANGES_FORWARD_PATH);// 系统数据变更
       put(RENT_CAR_OUTSIDES, IOS_OUTSIDES_CAR_FORWARD_PATH);// 付款单——外请车
       put(EXPENSE_CLAIMS, IOS_EXPENSE_CLAIMS_PATH);//通用费用报销单
       put(BENIFITFEE, IOS_BENIFITFEE_PATH);//福利费用报销申请
       put(ADDATTENDANCE, IOS_ADDATTENDANCE_FORWARD_PATH);//补考勤申请
       put(ONBUSINESS, IOS_TRAVEL_PATH); //出差申请
       put(OA_BUDGETDATAAPPLY, IOS_OA_BUDGETDATAAPPLY_PATH); //数据预算申请
       put(RECOMMANDNEWEMP, IOS_RECOMMANDNEWEMP_PATH); //新员工推荐（新）
       put(REALCONTRACTBORROW, IOS_REALCONTRACT_BORROW_PATH);//实体合同借阅
       put(SYSTEMPOWERAPPLY, IOS_SYSTEMPOWER_APPLY_PATH);//系统权限申请
       put(ENTERTAINMENTEXPENSE, IOS_ENTERTAINMENTEXPENSE_PATH); //应酬费用管理
       put(DAILYPAYMENT, IOS_DAILY_PAYMENT_PATH); //日常付款
       put(RENT, IOS_RENT_PATH); //房租
       put(DATA_PROVIDE_APPLY, IOS_DATA_PROVIDE_APPLY_PATH); //数据提供审批
       put(EMP_TRANS_APPLY, IOS_EMP_TRANS_APPLY_PATH); //异动调动申请
       put(MATERIAL_PROPERTY_APPLY, IOS_EXPENSE_ACCOUNT_BILL_PATH); //物资资产采购报销申请
       put(BENIFITFEES_NEW,  IOS_BENIFITFEES_NEW_PATH);//借款福利（新）
       put(VEHICLE_PAY, IOS_VEHICLE_PAY_PATH);//车辆付款
       put(CAR_OUTSIDES_RENT, IOS_CAR_OUTSIDES_RENT_PATH);//外请车付款单
       put(DAILY_NEW, BOEVERY_DAY_RENT_PATH);//日常（新）
       put(MUCH_PAY,MUCH_RECOMPENSATE_PATH);//多赔
       put(FEE_NEW, ENTERTAINMENT_FEES_PATH);//应酬费（新） --
       put(INJURY_MEDICAL_EXPENSES_NEW, INJURY_MEDICAL_PATH);//工伤医疗费用（新）
       put(INJURY_MEDICAL_EXPENSES_APPLY, INJURY_MEDICAL_EXPENSES_PATH);//工伤医疗费用报销申请
       put(OVERTIME,OVER_TIME_PATH);//加班/加班工资申请
       put(FUNDS_OPERATION, RUNFINANCE_PATH);//资金运作申请
       put(SPECIAL_EXPENSES_PROJECT,SPECIFIC_PROJECT_FEE_PATH);//专项费用立项申请
       put(CONTRACT_ADMINISTRATIVE,ADMIN_CONTRACT_APPLY_PATH);//行政类合同申请
       put(ASSESS_PROGRAM,ASSESS_PROGRAM_PATH);//数据提供审批
       put(CASES_REGISTERED, OURSIDE_LAYWER_PATH);//诉讼案件立案/外请律师申请
       put(DISMISSAL, DISMISSAL_APPLY_PATH);//免职申请
       put(SITE_RENT,YARDRENT_APPLY_PATH);//场地租赁申请
       put(SITE_SUBLEASE, SITE_SUBLEASE_PATH);//场地转租
       put(QUALIFICATIONAUTH, QUALIFICATIONAUTH_PATH);//任职资格申请
       put(BORROW_SEAL, BORROW_SEAL_PATH);//借章申请
       put(SUB_SIDIARYSET,SUBSIDIARYSET_PATH);//子公司设立及变更申请
       put(PAYMENT,WFS_PAYMENT_PATH);//付款申请（香港）
       put(REMOVAL_APPLY_NEW, REMOVAL_PATH);//新点开设/旧点搬迁
       put(MARKETING_ACTIVITIES, MARKETING_ACTIVITIES_PATH);//营销活动申请
       put(PROJECT_KIND_CONTRACT_APPLY, PROJECT_CONTRACT_APPLY_PATH);//项目类合同签订申请
       put(ASSESSREDUCE, ASSESSREDUCE_APPLY_PATH);//考核特批减免申请
       put(EXPENSE_ACCOUNT_HK, EXPENSE_HK_PATH);//费用报销申请（香港）
       put(RETURN_DOMICILE_OF_ORIGIN,RETURN_ORIGIN_PATH);//回原籍
       put(LOAN_PAYMENT,LOAN_PAYMENT_PATH);//借支申请
       put(LESSON_RESEARCH,LESSON_PATH);//课程研发/审核申请
       put(EDUCATE_BY_OUTSIDE,EDUCATE_OUTSIDE_PATH);//外训申请
       put(DISCOUNT,DISCOUNT_APPLY_PATH);//折扣申请
       put(COURT_DESIGN,SITEDESIGN_APPLY_PATH);//场地设计
       put(MANAGER_BECOME,MANAGER_BECOME_PATH);//管理人员转正/成长期通过申请工作流
       put(CONTRACTADD_TYPE, IOS_CONTRACTADD_FORWARD_PATH);//月结合同签订
       put(USE_SEAL_APPLY, USE_SEAL_APPLY_PATH);//用章申请
       put(PERSONEL_IMPOWER,PERSONEL_IMPOWER_PATH);//人事授权需求
       put(DETAINED_GOODS, DETAINED_GOODS_APPLY_PATH);//扣货申请
       put(DATA_REQUIRE, DATA_REQUIRE_PATH);//数据需求审批流程
       put(TRAIN_LEAVE, TRAIN_LEAVE_RATH);//培训请假
       put(BAD_DEBT, BAD_DEBT_PATH);//非业务类坏账申请
       put(BUSINESS_BAD_DEBTS, BUSINESS_BAD_DEBT_PATH);//业务类坏账申请
       put(ELECTRONIC_CONTRACT_BORROW,ELECTRONIC_CONTRACT_BORROW_PATH);//电子合同借阅
       put(TRUCK_LOAD_TRANSPORT, TRUCK_LOAD_TRANSPORT_PATH);//整车货物运输合同
       put(TALENT_RECOMMENDATION, RECOMMEND_STAFF_PATH);//优秀人才推荐
       put(TRAIN_REQUIREMENT,TRAIN_REQUEST_PATH);//培训需求申请
       put(SEAL_CARVE_APPLY, SEAL_CARVE_APPLY_PATH);//刻章申请
       put(PROCESS_MANAGER, MANAGER_PROCESS_PATH);//流程新建/变更/废除
       put(LICENSE_CANCELL, LICENSE_CANCELL_PATH);//分公司证照注销
       put(DISPATCH_CENSOR, CHECKFILE_APPLY_PATH);//发文审核申请
       put(LICENSES_BORROW, LICENSES_BORROW_PATH);//证照借阅申请(新)
       put(BANKACCOUNT_OPENCL,BANK_ACCOUNTOPENCL_PATH);//银行开户/销户申请
       put(COURT_FIND_SITE,COURT_FIND_SITE_PATH);//场地找点
       
       *//**FSSC**//*
       put(FSSC_WELFARE_FEE_APPLY,FSSC_WELFARE_FEE_APPLY_PATH);//薪酬福利报账单-福利费
       put(FSSC_ABNORMAL_REFUND_APPLY,FSSC_ABNORMAL_REFUND_APPLY_PATH);//异常代收货款退款
       
       *//**LSP*//*
       put(LSP_PURCHASE_CONTRACT_CHANGE, LSP_PURCHASE_CONTRACT_CHANGE_PATH);//采购合同变更
   }};
   */
   public static Map<String, String> WF_FORWARD_MAP = new HashMap();
   public static Map<Integer, String> ASSESS_PROGRAM_SEASON = new HashMap<Integer, String>(){{
	   put(1, "第一季度");
	   put(2, "第二季度");
	   put(3, "第三季度");
	   put(4, "第四季度");}
   };
   public static Map<Integer, String> ASSESS_PROGRAM_DEPT_PROPERTY = new HashMap<Integer, String>(){{
	   put(1, "经营");
	   put(2, "运作");
	   put(3, "职能");
   }};
   
   /**系统权限申请申请类型1**/
   public static Map<String, String> SYSTEM_POWER_APPLYTYPE1 = new HashMap<String, String>(){{
	   put("1", "车辆权限");
	   put("2", "综合权限");
   }};
   /**系统权限申请申请类型2**/
   public static Map<String, String> SYSTEM_POWER_APPLYTYPE2 = new HashMap<String, String>(){{
	   put("1", "新增");
	   put("2", "变更");
	   put("3", "删除");
   }};
   
   /** 字符串判空返回结果 是返回"" 否 返回真值   */
   public static String chageNull(String str){
  	return str == null ? "":str;
      }
   /**Date 时间转换 yyyy-MM-dd*/
   public static String getDateyyyyMMdd(Date date){
       
       if(date == null)
	   return "";
       
       return DateUtil.format(date, "yyyy-MM-dd");
   }
   /**Date 时间转换 yyyy-MM-dd
 * @throws ParseException */
   public static String getDateyyyyMMdd(String date){
       
       if(date == null)
	   return "";
       
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
       ParsePosition pos = new ParsePosition(0);
       Date posdate = formatter.parse(date, pos);
       return DateUtil.format(posdate, "yyyy-MM-dd");
   }
   
   @SuppressWarnings("serial")
   public static Map<String,String> lspWorkFlowSet = new HashMap<String,String> () {{
	   //工程寻源申请单
	   put("com.deppon.bpms.module.lsp.bpsdesign.projects.projectSearchSource", "2");
	   //企划设计-非库非固分购
	   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.layoutDesignFGou", "2");
	   //企划设计-非库非固统购
	   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.layoutDesignTGou", "2");
	   //日常物资-非库固定大型设备、
	   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsNotStockFixBigDevice", "2");
	   //日常物资-库存非固统购
	   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsStockNotFixTGou", "2");
	   //日常物资-库存固定
	   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsStockFix", "2");
	   //日常物资-库存非固分购、
	   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsStockNotFixFGou", "2");
	   //日常物资-非库固定统购
	   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsNotStockFixTGou", "2");
	   //日常物资-非库固定分购、
	   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsNotStockFixFGou", "2");
	   //日常物资-非库非固统购、
	   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsNotStockNotFixTGou", "2");
	   //日常物资-非库非固汽配统购
	   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsNotStockNotFixCarTGou", "2");
	   //日常物资-非库非固汽配分购
	   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsNotStockNotFixCarFGou", "2");
	   //日常物资-非库非固分购
	   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsNotStockNotFixFGou", "2");
	   
	   /*//日常物资-非库非固分购不要了，后勤说迁移优化
	   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.dailyGoodsNotStockNotFixFGou", "2");*/
	   
	   /* 这三条是未走esb的接口
	    * 采购合同变更：com.deppon.bpms.module.lsp.bpsdesign.purchase.purchaseContractChange
	    * 付款申请单:com.deppon.bpms.module.lsp.bpsdesign.purchase.paymentApply
	    * 采购合同:com.deppon.bpms.module.lsp.bpsdesign.purchase.purchaseContract
	    **/
	   /*下面这些工作流是移动办公二期上线配合后勤写的
	    * 其中value值为1的工作流是，2014年5月30 号上线时候的四条工作流 和2014年6月30 号上线时候的十三工作流
	    * 其中value值为2的工作流是，2014年7月30 号上线时候的十二条工作流
	    * 总计走esb的后勤工作流有29条*/
	   //工程项目可行性评估单
	   put("com.deppon.bpms.module.lsp.bpsdesign.projects.projectFeasibilityAssessment", "1");
	   //车辆申请
	   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.carApply", "1");
	   //定标单变更
	   put("com.deppon.bpms.module.lsp.bpsdesign.purchase.scalingSingleChange", "1");
	   //定标单
	   put("com.deppon.bpms.module.lsp.bpsdesign.purchase.scalingSingle", "1");
	   
	   //工程项目立项单
	   put("com.deppon.bpms.module.lsp.bpsdesign.projects.projectApproval", "1");
	   //项目设计变更单
	   put("com.deppon.bpms.module.lsp.bpsdesign.projects.projectDesignChange", "1");
	   //工程维修申请单
	   put("com.deppon.bpms.module.lsp.bpsdesign.projects.serviceApply", "1");
	   //维修保养单
	   put("com.deppon.bpms.module.lsp.bpsdesign.vehicle.maintenanceSingle", "1");
	   //工程量单变更单
	   put("com.deppon.bpms.module.lsp.bpsdesign.projects.projectLdChange", "1");
	   //工程项目状态申请
	   put("com.deppon.bpms.module.lsp.bpsdesign.projects.projectStateApply", "1");
	   //工程项目规划单
	   put("com.deppon.bpms.module.lsp.bpsdesign.projects.projectPlan", "1");
	   //车辆更新申请单
	   put("com.deppon.bpms.module.lsp.bpsdesign.vehicle.vehiclesUpdatedApplicationForm", "1");
	   //备货维护单
	   put("com.deppon.bpms.module.lsp.bpsdesign.purchase.stockUpSafeguard", "1");
	   //决算单
	   put("com.deppon.bpms.module.lsp.bpsdesign.projects.finalAccounts", "1");
	   //工程项目结算单
	   put("com.deppon.bpms.module.lsp.bpsdesign.projects.projectSettlement", "1");
	   //新点物料申请单
	   put("com.deppon.bpms.module.lsp.bpsdesign.warehouse.newPointSuppliesApply", "1");
	   //备货申请单
	   put("com.deppon.bpms.module.lsp.bpsdesign.purchase.stockUpApply", "1");
	   //RFQ单
	   put("com.deppon.bpms.module.lsp.bpsdesign.purchase.RFQBill", "3");
	   //评标申请单
	   put("com.deppon.bpms.module.lsp.bpsdesign.purchase.evaluationRequestForm", "3");
	   //决算单申请
	   put("com.deppon.bpms.module.lsp.bpsdesign.projects.finalAccountsApply", "3");
	   //维修结算单
	   put("com.deppon.bpms.module.lsp.bpsdesign.projects.repairSettlement", "3");
	   //供应商考核单
	   put("com.deppon.bpms.module.lsp.bpsdesign.purchase.supplierCheck","3");
	   //供应商处置单
	   put("com.deppon.bpms.module.lsp.bpsdesign.purchase.supplierDispose","3");
	   //工程项目设计单
	   put("com.deppon.bpms.module.lsp.bpsdesign.projects.projectDesign","3");
	   //工程项目申请单
	   put("com.deppon.bpms.module.lsp.bpsdesign.projects.projectApply","3");
	   //工程项目预算调整单
	   put("com.deppon.bpms.module.lsp.bpsdesign.projects.projectBudgetAdjust","3");
	   //工程项目预算明细单
	   put("com.deppon.bpms.module.lsp.bpsdesign.projects.projectBudgetDetail","3");
	   //询价确认单
	   put("com.deppon.bpms.module.lsp.bpsdesign.purchase.requestConfirmation","3");
	   
	   
	   
   }};
}
