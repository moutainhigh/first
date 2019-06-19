package com.deppon.wfs.workflow.service;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.deppon.montal.conf.DictEntryService;
import com.deppon.montal.conf.domain.DictEntry;
import com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient;
import com.deppon.montal.util.JSONUtil;
import com.deppon.wfs.workflow.domain.ActRegistrationBean;
import com.deppon.wfs.workflow.domain.AdmitApplyBean;
import com.deppon.wfs.workflow.domain.ArchivesLendingApplyBean;
import com.deppon.wfs.workflow.domain.AssessReduceBean;
import com.deppon.wfs.workflow.domain.AssessmentSchemeApplyBean;
import com.deppon.wfs.workflow.domain.AssessmentSchemeBean;
import com.deppon.wfs.workflow.domain.Bankaccount;
import com.deppon.wfs.workflow.domain.BudgeDataChildrenBean;
import com.deppon.wfs.workflow.domain.BudgeDataChildrenMinusBean;
import com.deppon.wfs.workflow.domain.BudgeDataSubmitDetailBean;
import com.deppon.wfs.workflow.domain.Budgedata;
import com.deppon.wfs.workflow.domain.CommissionMakeOrChangeBean;
import com.deppon.wfs.workflow.domain.ContractApplyBean;
import com.deppon.wfs.workflow.domain.CourseDevelopUpdateAuditBean;
import com.deppon.wfs.workflow.domain.DeductCargo;
import com.deppon.wfs.workflow.domain.DestroyContractBean;
import com.deppon.wfs.workflow.domain.DiscountapplyBean;
import com.deppon.wfs.workflow.domain.DismissalBean;
import com.deppon.wfs.workflow.domain.EmpDormBean;
import com.deppon.wfs.workflow.domain.Externalstudy;
import com.deppon.wfs.workflow.domain.FoundQueryTeamBean;
import com.deppon.wfs.workflow.domain.InspectionDataSubmitBean;
import com.deppon.wfs.workflow.domain.LegalSignBean;
import com.deppon.wfs.workflow.domain.LongDisDriverAgingBreaksBean;
import com.deppon.wfs.workflow.domain.LongDisDriversDataDellBean;
import com.deppon.wfs.workflow.domain.ManagerGrowthStagePassBean;
import com.deppon.wfs.workflow.domain.MarketActivityBean;
import com.deppon.wfs.workflow.domain.MarketResearchBean;
import com.deppon.wfs.workflow.domain.NewDeptApplyBean;
import com.deppon.wfs.workflow.domain.OnlineBean;
import com.deppon.wfs.workflow.domain.OtherSideLineProxy;
import com.deppon.wfs.workflow.domain.OvertimeApplyChildBean;
import com.deppon.wfs.workflow.domain.OvertimeApplyParentBean;
import com.deppon.wfs.workflow.domain.ProblemFeedbackBean;
import com.deppon.wfs.workflow.domain.ProcessManagementBean;
import com.deppon.wfs.workflow.domain.ProductAdjustmentBean;
import com.deppon.wfs.workflow.domain.ProjectContractApplyBean;
import com.deppon.wfs.workflow.domain.QualificationApplyBean;
import com.deppon.wfs.workflow.domain.QualificationapplyChildBean;
import com.deppon.wfs.workflow.domain.QualificationapplySkillBean;
import com.deppon.wfs.workflow.domain.RecommendNewEmpBean;
import com.deppon.wfs.workflow.domain.RepairAttendance;
import com.deppon.wfs.workflow.domain.RepairAttendanceDetails;
import com.deppon.wfs.workflow.domain.ResignationBean;
import com.deppon.wfs.workflow.domain.SealCarveApplyBean;
import com.deppon.wfs.workflow.domain.SignDataBean;
import com.deppon.wfs.workflow.domain.SiteFindPointsBean;
import com.deppon.wfs.workflow.domain.StaffReturnToHrBean;
import com.deppon.wfs.workflow.domain.StoreRent;
import com.deppon.wfs.workflow.domain.SystemDataChangeApplyBean;
import com.deppon.wfs.workflow.domain.SystempowerapplyChildBean;
import com.deppon.wfs.workflow.domain.SystempowerapplyParentBean;
import com.deppon.wfs.workflow.domain.TrainBean;
import com.deppon.wfs.workflow.domain.TruckPartBuyMaintainBean;
import com.deppon.wfs.workflow.domain.WelfarePaymentBean;
import com.deppon.wfs.workflow.domain.YardRentBean;

public class WFDetailApplyServiceImpl implements IWFDetailApplyService {
	private static DictEntryService dictEntryService;
	
	private Logger logger = Logger.getLogger(WFDetailApplyServiceImpl.class);
	
	

	/**
	 * @return the dictEntryService
	 */
	public static DictEntryService getDictEntryService() {
		if (dictEntryService == null) {
			return DictEntryService.getInstance();
		}
		return dictEntryService;
	}
	/**
	* @MethodName: getCommDWFSDetails 
	* @description : 获取工作流详情信息
	* @author：caibingbing 
	* @date： 2013-11-28 上午10:06:35
	* @param entity 实体bean路径
	* @param actionUrl 查询详情地址
	* @param params 查询详情所需要的参数
	* @param sid cas
	* @return
	* @throws IllegalArgumentException
	* @throws UnsupportedEncodingException
	* @throws InstantiationException
	* @throws IllegalAccessException
	* @throws InvocationTargetException Object
	 * @throws ClassNotFoundException 
	 */
	public Object getCommDWFSDetails(Object obj, String actionUrl,Map<String, String> params, String sid)throws IllegalArgumentException, UnsupportedEncodingException,InstantiationException, IllegalAccessException,InvocationTargetException, ClassNotFoundException {
		DWFSWorkItemServiceClient client = new DWFSWorkItemServiceClient();
		return JSONUtil.translateToBean(obj.getClass(),client.postToDWFS(actionUrl, params, sid));
	}
	/**
	* @MethodName: getCommDWFSDetails 
	* @description : 获取工作流特殊actionurl
	* @author：gaoyazhe 
	* @date： 2013-11-28 上午10:06:35
	* @param entity 实体bean路径
	* @param actionUrl 查询详情地址
	* @param params 查询详情所需要的参数
	* @param sid cas
	* @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws UnsupportedEncodingException 
	 * @throws IllegalArgumentException 
	 */
	public String getCommDWFSUrl(String actionUrl,Map<String, String> params, String sid) throws IllegalArgumentException, UnsupportedEncodingException, InstantiationException, IllegalAccessException, InvocationTargetException {
		DWFSWorkItemServiceClient client = new DWFSWorkItemServiceClient();
			//List<String> list = new ArrayList<String>();
			String str = client.postToDWFS(actionUrl, params, sid);
			String busino =  str.substring(1, str.length()-1);
			//list.add(busino);
			
			return busino;
		
	}
	/**
	 * 
	* @MethodName: translateRepairAttendance 
	* @description : 补考勤转换子表类型
	* @author：何玲菠 
	* @date： 2013-11-29 上午10:36:36
	* @param bean
	* @return Object
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IllegalArgumentException 
	 */
	@Override
	public Object translateRepairAttendance(Object bean) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		RepairAttendance entity = (RepairAttendance)bean;
		Map<String, Class> map = new HashMap<String, Class>();
		map.put("repairDetails", RepairAttendanceDetails.class);
		List<RepairAttendanceDetails> list = new ArrayList<RepairAttendanceDetails>();
		for (Object temp : entity.getRepairDetails()) {
			list.add(JSONUtil.translateToBean(new RepairAttendanceDetails().getClass(), JSONObject.fromObject(temp).toString()));
		}
		entity.setRepairDetails(list);
		return entity;
	}
	
	public Object parseQualificationApplyBean (Object bean) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		QualificationApplyBean entity = (QualificationApplyBean) bean;
		List<QualificationapplyChildBean> list = new ArrayList<QualificationapplyChildBean>();
		for (Object temp : entity.getQualificationapplyList()) {
			list.add(JSONUtil.translateToBean(new QualificationapplyChildBean().getClass(), JSONObject.fromObject(temp).toString()));
		}
		entity.setQualificationapplyList(list);
		List<QualificationapplySkillBean> list2 = new ArrayList<QualificationapplySkillBean>();
		for (Object temp : entity.getQualificationapplySkillList()) {
			list2.add(JSONUtil.translateToBean(new QualificationapplySkillBean().getClass(), JSONObject.fromObject(temp).toString()));
		}
		entity.setQualificationapplySkillList(list2);
		return entity;
	}
	
	public Object parseEntity(Object bean){
		AssessReduceBean entity = (AssessReduceBean) bean;
		entity.setReduceType(getDictNameByTypeAndCode("WFS_REDUCETYPE", entity.getReduceType()));
		entity.setAssessmentTeam(getDictNameByTypeAndCode("WFS_ASSESSMENT_TEAM", entity.getAssessmentTeam()));
		entity.setPerformanceManager(getDictNameByTypeAndCode("WFS_ASSESSMENT_AREA", entity.getPerformanceManager()));
		return entity;
	}
	/**
	* @MethodName: parseAssessmentSchemeBeanEntity 
	* @description : 转换实体中业务字典
	* @author：caibingbing 
	* @date： 2013-11-29 下午5:38:40
	* @param entity
	* @return Object
	 */
	@Override
	public Object parseAssessmentSchemeBeanEntity(Object entity) {
		AssessmentSchemeBean en = (AssessmentSchemeBean) entity;
		DictEntryService service = DictEntryService.getInstance();
		en.setIsPerformanceManager(service.getDictEntries("WFS_RADION_TYPE", en.getIsPerformanceManager()).get(0).getDictname());
		en.setArea(service.getDictEntries("DIP_DIVISION_NEW", en.getArea()).get(0).getDictname());
		en.setOrgType(service.getDictEntries("WFS_DEPARTMENT_PROPERTY", en.getOrgType()).get(0).getDictname());
		en.setSeason(service.getDictEntries("WFS_QUARTER", en.getSeason()).get(0).getDictname());
		return en;
	}
	@Override
	public Object parseTrainBean(Object entity) {
		TrainBean en = (TrainBean) entity;
		DictEntryService service = DictEntryService.getInstance();
		en.setPmoProject(service.getDictEntries("WFS_ISORNO", en.getPmoProject()).get(0).getDictname());
		en.setTrainType(service.getDictEntries("WFS_TRAINTYPE", en.getTrainType()).get(0).getDictname());
		en.setTrainGroup(service.getDictEntries("WFS_TRAINORG", en.getTrainGroup()).get(0).getDictname());
		en.setChangeType(service.getDictEntries("WFS_CHANGTYPE", en.getChangeType()).get(0).getDictname());
		en.setIsconsultant(service.getDictEntries("WFS_ISORNO", en.getIsconsultant()).get(0).getDictname());
		return en;
	}
	@Override
	public Object parseMarketActivityBean(Object entity) {
		MarketActivityBean en = (MarketActivityBean) entity;
		DictEntryService service = DictEntryService.getInstance();
		en.setSubOrdinateDivision(service.getDictEntries("DIP_DIVISION_NEW", en.getSubOrdinateDivision()).get(0).getDictname());
//		String type = en.getMarketType();
//		if("lineType".equals(type)){
//			en.setPropagandalineType(service.getDictEntries("WFS_PUBLICITYLINE", en.getPropagandalineType()).get(0).getDictname());
//		}else if ("businessType".equals(type)){
//			en.setPropagandaBusType(service.getDictEntries("WFS_PROPAGANDABUSTYPE", en.getPropagandaBusType()).get(0).getDictname());
//		}else if("guildType".equals(type)){
//			en.setPropagandainDustryType(service.getDictEntries("WFS_PROPAGANDAINDUSTRYTYPE", en.getPropagandainDustryType()).get(0).getDictname());
//		}else{
//			en.setPropaganDaairType(service.getDictEntries("WFS_PROPAGANDAAIRTYPE", en.getPropaganDaairType()).get(0).getDictname());
//		}
		en.setIsRedo(service.getDictEntries("WFS_ISORNO", en.getIsRedo()).get(0).getDictname());
		en.setType(en.getMarketType());
		en.setMarketType(service.getDictEntries("WFS_MARKETTYPE", en.getMarketType()).get(0).getDictname());
		return en;
	}
	
	/**
	 * 管理人员转正实体转换,添加对是否谈判工资是否为空的判断
	 * @param object
	 * @return
	 */
	public static Object parseManagerBean(Object object) {//管理人员转正实体转换
		ManagerGrowthStagePassBean bean = (ManagerGrowthStagePassBean)object;
		bean.setApplyType(getDictEntryService().getDictEntries("WFS_APPLYTYPE_MANAGER", bean.getApplyType()).get(0).getDictname());
		bean.setPositiveType(getDictEntryService().getDictEntries("WFS_POSITIVETYPE", bean.getPositiveType()).get(0).getDictname());
		bean.setGrowthStageType(getDictEntryService().getDictEntries("WFS_GROWTHSTAGETYPE", bean.getGrowthStageType()).get(0).getDictname());
		if(null != bean.getIfNegotiateSalary() && !"".equals(bean.getIfNegotiateSalary())) {
			bean.setIfNegotiateSalary(getDictEntryService().getDictEntries("WFS_ISORNO", bean.getIfNegotiateSalary()).get(0).getDictname());
		}
		return bean;
	}
	
	public static Object parseRecommondNEWEmp(Object object) {
		RecommendNewEmpBean bean = (RecommendNewEmpBean)object;
		bean.setRecommendedEdu(getDictEntryService().getDictEntries("WFS_EDUCATIONLEVEL", bean.getRecommendedEdu()).get(0).getDictname());
		bean.setRecommendedType(getDictEntryService().getDictEntries("WFS_RECOMMENDEDTYPE", bean.getRecommendedType()).get(0).getDictname());
		bean.setRecommendedArea(getDictEntryService().getDictEntries("WFS_PERSONAL", bean.getRecommendedArea()).get(0).getDictname());
		bean.setRecommendedDept(getDictEntryService().getDictEntries("WFS_ENTRYDEPT", bean.getRecommendedDept()).get(0).getDictname());
		return bean;
	}
	
	/**
	 * 辞职申请工作流实体转换
	* @MethodName: translateResign 
	* @description : TODO
	* @author：liming
	* @date： 2013-12-2 下午6:13:24
	* @param bean
	* @return Object
	 */
	@Override
	public Object translateResign(Object bean) {
		DictEntryService service = DictEntryService.getInstance();
		ResignationBean resignBean=(ResignationBean) bean;
		String resignTypeName=service.getDictEntries("WFS_RESIGNTYPE", resignBean.getResignType()).get(0).getDictname();
		resignBean.setResignTypeName(resignTypeName);//辞职类型
		resignBean.setSuperiorDegreeName(service.getDictEntries("WFS_SUPERDEGREE", resignBean.getSuperiorDegree()).get(0).getDictname());//直属上级级别
		resignBean.setPersonnelDeptName(service.getDictEntries("WFS_ALL_PERSONALDEPT", resignBean.getPersonnelDeptCode()).get(0).getDictname());//所在人事部
		resignBean.setPostsortName(service.getDictEntries("WFS_POSTSORT", resignBean.getPostsort()).get(0).getDictname());//岗位类型
		resignBean.setIsManagerName(service.getDictEntries("WFS_ISORNO", resignBean.getIsManager()).get(0).getDictname());//是否管理岗位
		resignBean.setResignReason(service.getDictEntries("WFS_RESIGNREASON", resignBean.getResignReason()).get(0).getDictname());//辞职原因
		return resignBean;
	}
	/**
	 * 
	* @MethodName: translateExternalstudy 
	* @description : 外训申请实体转换
	* @author：liming
	* @date： 2013-11-30 上午11:32:24
	* @param bean
	* @return Object
	 */
	@Override
	public Object translateExternalstudy(Object bean) {
		DictEntryService service = DictEntryService.getInstance();
		Externalstudy externalStudyBean=(Externalstudy) bean;
		externalStudyBean.setIfRecord(service.getDictEntries("WFS_ISORNO",externalStudyBean.getIfRecord()).get(0).getDictname());//是否向培训组备案
		return externalStudyBean;
	}
	/**
	 * 
	* @MethodName: translateBudgedata 
	* @description : 预算数据申请转换
	* @author：liming
	* @date： 2013-11-30 下午01:49:01
	* @param bean
	* @return Object
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IllegalArgumentException 
	 */
	@Override
	public Object translateBudgedata(Object bean) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Budgedata budgeDataBean=(Budgedata) bean;
//		Map<String, Class> map = new HashMap<String, Class>();
//		map.put("repairDetails", BudgeDataChildrenBean.class);
		List<BudgeDataChildrenBean> list = new ArrayList<BudgeDataChildrenBean>();
		for (Object temp : budgeDataBean.getBudgeDataChildren()) {
			list.add(JSONUtil.translateToBean(new BudgeDataChildrenBean().getClass(), JSONObject.fromObject(temp).toString()));
		}
		budgeDataBean.setBudgeDataChildren(list);
		List<BudgeDataChildrenMinusBean> listMinus = new ArrayList<BudgeDataChildrenMinusBean>();
		for (Object temp : budgeDataBean.getBudgeDataChildrenMinus()) {
			listMinus.add(JSONUtil.translateToBean(new BudgeDataChildrenMinusBean().getClass(), JSONObject.fromObject(temp).toString()));
		}
		budgeDataBean.setBudgeDataChildrenMinus(listMinus);
		//预算数据    提交明细
		List<BudgeDataSubmitDetailBean> listDetail = new ArrayList<BudgeDataSubmitDetailBean>();
		for (Object temp : budgeDataBean.getBudgeDataSubmitDetail()) {
			listDetail.add(JSONUtil.translateToBean(new BudgeDataSubmitDetailBean().getClass(), JSONObject.fromObject(temp).toString()));
		}
		budgeDataBean.setBudgeDataSubmitDetail(listDetail);
		
		budgeDataBean.setAdjustmentType(getDictNameByTypeAndCode("WFS_ADJUSTMENT_TYPE", budgeDataBean.getAdjustmentType()));//调整方式
		budgeDataBean.setDepartmentProperty(getDictNameByTypeAndCode("WFS_DEPARTMENT_PROPERTY_NEW", budgeDataBean.getDepartmentProperty()));//部门性质
		budgeDataBean.setBelongOffice(getDictNameByTypeAndCode("WFS_HEADQUARTERS", budgeDataBean.getBelongOffice()));//所属经营本部
		budgeDataBean.setIfYearlyBudget(getDictNameByTypeAndCode("WFS_ISORNO", budgeDataBean.getIfYearlyBudget()));//是否年度预算
		budgeDataBean.setAdjustmentCostItem(getDictNameByTypeAndCode("WFS_ADJUSTMENT_ITEM", budgeDataBean.getAdjustmentCostItem()));//调整成本项
		budgeDataBean.setAddCostItem(getDictNameByTypeAndCode("WFS_ADJUSTMENT_ITEM", budgeDataBean.getAddCostItem()));//调增成本项
		budgeDataBean.setMinusCostItem(getDictNameByTypeAndCode("WFS_ADJUSTMENT_ITEM", budgeDataBean.getMinusCostItem()));//调减成本项
		for (BudgeDataChildrenMinusBean budgeDataChildrenMinusBean : budgeDataBean.getBudgeDataChildrenMinus()) {
			budgeDataChildrenMinusBean.setAdjustmentMonthMinus(getDictNameByTypeAndCode("WFS_MONTH", budgeDataChildrenMinusBean.getAdjustmentMonthMinus()));
			if ("人力成本".equals(budgeDataBean.getMinusCostItem())) {
				budgeDataChildrenMinusBean.setAdjustmentSubjectMinus(getDictNameByTypeAndCode("WFS_ADJUSTMENT_SUBJECT_P", budgeDataChildrenMinusBean.getAdjustmentSubjectMinus()));
			} else if ("物料成本".equals(budgeDataBean.getMinusCostItem())) {
				budgeDataChildrenMinusBean.setAdjustmentSubjectMinus(getDictNameByTypeAndCode("WFS_ADJUSTMENT_SUBJECT_M", budgeDataChildrenMinusBean.getAdjustmentSubjectMinus()));
			} else if ("场地成本".equals(budgeDataBean.getMinusCostItem())) {
				budgeDataChildrenMinusBean.setAdjustmentSubjectMinus(getDictNameByTypeAndCode("WFS_ADJUSTMENT_SUBJECT_S", budgeDataChildrenMinusBean.getAdjustmentSubjectMinus()));
			} else if ("运输成本".equals(budgeDataBean.getMinusCostItem())) {
				budgeDataChildrenMinusBean.setAdjustmentSubjectMinus(getDictNameByTypeAndCode("WFS_ADJUSTMENT_SUBJECT_T", budgeDataChildrenMinusBean.getAdjustmentSubjectMinus()));
			} else if ("其他成本".equals(budgeDataBean.getMinusCostItem())) {
				budgeDataChildrenMinusBean.setAdjustmentSubjectMinus(getDictNameByTypeAndCode("WFS_ADJUSTMENT_SUBJECT_O", budgeDataChildrenMinusBean.getAdjustmentSubjectMinus()));
			}
		}
		for (BudgeDataChildrenBean budgeDataChildrenBean : budgeDataBean.getBudgeDataChildren()) {
			budgeDataChildrenBean.setAdjustmentMonth(getDictNameByTypeAndCode("WFS_MONTH", budgeDataChildrenBean.getAdjustmentMonth()));
			if ("人力成本".equals(budgeDataBean.getAddCostItem())) {
				budgeDataChildrenBean.setAdjustmentSubject(getDictNameByTypeAndCode("WFS_ADJUSTMENT_SUBJECT_P", budgeDataChildrenBean.getAdjustmentSubject()));
			} else if ("物料成本".equals(budgeDataBean.getAddCostItem())) {
				budgeDataChildrenBean.setAdjustmentSubject(getDictNameByTypeAndCode("WFS_ADJUSTMENT_SUBJECT_M", budgeDataChildrenBean.getAdjustmentSubject()));
			} else if ("场地成本".equals(budgeDataBean.getAddCostItem())) {
				budgeDataChildrenBean.setAdjustmentSubject(getDictNameByTypeAndCode("WFS_ADJUSTMENT_SUBJECT_S", budgeDataChildrenBean.getAdjustmentSubject()));
			} else if ("运输成本".equals(budgeDataBean.getAddCostItem())) {
				budgeDataChildrenBean.setAdjustmentSubject(getDictNameByTypeAndCode("WFS_ADJUSTMENT_SUBJECT_T", budgeDataChildrenBean.getAdjustmentSubject()));
			} else if ("其他成本".equals(budgeDataBean.getAddCostItem())) {
				budgeDataChildrenBean.setAdjustmentSubject(getDictNameByTypeAndCode("WFS_ADJUSTMENT_SUBJECT_O", budgeDataChildrenBean.getAdjustmentSubject()));
			}
		}
		
		for (BudgeDataSubmitDetailBean detail : budgeDataBean.getBudgeDataSubmitDetail()) {
			detail.setSubmitDetailCostItem(getDictNameByTypeAndCode("WFS_ADJUSTMENT_ITEM", detail.getSubmitDetailCostItem()));
		}
		return budgeDataBean;
	}
	/**
	 * 
	* @MethodName: translateYardRentBean 
	* @description :场地租赁/转租合同转换
	* @author：liming
	* @date： 2013-11-30 下午03:44:41
	* @param bean
	* @return Object
	 */
	@Override
	public Object translateYardRentBean(Object bean) {
		DictEntryService service = DictEntryService.getInstance();
		YardRentBean yardRentBean=(YardRentBean) bean;
		yardRentBean.setBusiTypeName(service.getDictEntries("WFS_BUSITYPE",yardRentBean.getBusiType()).get(0).getDictname());//业务类型
		yardRentBean.setFinanceName(service.getDictEntries("NEW_FINANCIAL",yardRentBean.getFinanceCode()).get(0).getDictname());//所属财务部
		yardRentBean.setDivisionName(service.getDictEntries("DIP_DIVISION_NEW",yardRentBean.getDivisionCode()).get(0).getDictname());//所属事业部
		yardRentBean.setAffairsName(service.getDictEntries("WFS_AFFAIRSSECTION",yardRentBean.getAffairsCode()).get(0).getDictname());//所属公共事务组
		yardRentBean.setSignTypeName(service.getDictEntries("WFS_SIGNTYPE",yardRentBean.getSignType()).get(0).getDictname());//签订类型
		yardRentBean.setSubComName(service.getDictEntries("SUB_COMPANY",yardRentBean.getSubComCode()).get(0).getDictname());//所属子公司
		yardRentBean.setLeaseNameText(service.getDictEntries("SUB_COMPANY",yardRentBean.getLeaseName()).get(0).getDictname());//承租方名称
		yardRentBean.setYfirstChopName(service.getDictEntries("WFS_FIRSTCHOP",yardRentBean.getYfirstChop()).get(0).getDictname());//承租方名称
		yardRentBean.setLeaseTypeName(service.getDictEntries("WFS_RENTTYPE",yardRentBean.getLeaseType()).get(0).getDictname());//租赁类型
		yardRentBean.setPayTypeName(service.getDictEntries("WFS_PAYTYPE",yardRentBean.getPayType()).get(0).getDictname());//付款方式
		
		
		yardRentBean.setPrentNameText(service.getDictEntries("SUB_COMPANY",yardRentBean.getPrentName()).get(0).getDictname());//出租方名称
		yardRentBean.setIsChangeName(service.getDictEntries("WFS_ISORNO",yardRentBean.getIsChange()).get(0).getDictname());//是否改造
		return yardRentBean;
	}
	
	/**
	 * 
	* @MethodName: translateOverTimePay 
	* @description : 加班/加班工资申请转换
	* @author：liming
	* @date： 2013-12-2 上午11:21:06
	* @param bean
	* @return Object
	 */
	@Override
	public Object translateOverTimePay(Object bean) {
		DictEntryService service = DictEntryService.getInstance();
		OvertimeApplyParentBean entity=(OvertimeApplyParentBean) bean;
		entity.setPersonnelDeptName(service.getDictEntries("WFS_PERSONAL",entity.getPersonnelDept()).get(0).getDictname());//所属人事部
		List<OvertimeApplyChildBean> overTimeInfoList=new ArrayList<OvertimeApplyChildBean>();
		try{
			for(Object tmp:entity.getOverTimeInfoList()){
				overTimeInfoList.add(JSONUtil.translateToBean(new OvertimeApplyChildBean().getClass(),JSONObject.fromObject(tmp).toString()));
			}
		}catch(Exception e){
			this.logger.error("加班/加班工资申请子表转换异常"+e);
		}
		entity.setOverTimeInfoList(overTimeInfoList);
		return entity;
	}
	
	/**
	   * @Title: getDictNameByTypeAndCode 
	   * @Description:根据数据字典Type&&Code返回名称
	   * @date 2014-1-15 上午10:12:45
	 */
	private  String getDictNameByTypeAndCode(String type,String code){
		if(code == null){
			return "";
		}
		
		DictEntryService service = DictEntryService.getInstance();
		List<DictEntry> list = service.getDictEntries(type,code);
		if(null != list && list.size() > 0){
			return list.get(0).getDictname();
		}
		
		return code;
	}
	
	
	/**
	   * @Title: parseDismissalBean 
	   * @Description:免职申请数据字典转换
	   * @date 2014-1-15 上午10:06:48
	 */
	public  Object parseDismissalBean(Object entity) {
		DismissalBean bean = (DismissalBean)entity;
		bean.setDismissalDepartment(getDictNameByTypeAndCode("WFS_DISMISSAL_BELONGAREA",bean.getDismissalDepartment()));
		bean.setManpost(getDictNameByTypeAndCode("WFS_DISMISSAL_POST",bean.getManpost()));
		bean.setPersonnel(getDictNameByTypeAndCode("WFS_DISMISSAL_AREA",bean.getPersonnel()));
		return bean;
	}
	
	/**
	   * @Title: parseLaywerapplyBean 
	   * @Description:免职申请数据字典转换
	   * @date 2014-1-15 上午10:06:48
	 */
	public  Object parseAssessmentSchemeApplyBean(Object entity) {
		AssessmentSchemeApplyBean bean = (AssessmentSchemeApplyBean)entity;
		bean.setSeason(getDictNameByTypeAndCode("WFS_ASSESSMENT_QUARTER",bean.getSeason()));
		bean.setCheckTeamCode(getDictNameByTypeAndCode("WFS_CHECK_TEAM",bean.getCheckTeamCode()));
//		bean.setPersonMappingDeptCode(getDictNameByTypeAndCode("WFS_ASSESSMENT_AREA",bean.getPersonMappingDeptCode()));
		return bean;
	}
	
	   /** 
	   * @Title: parseCurriculumAudit 
	   * @Description:(折扣申请 数据字典转换) 
	   * @param @param entity
	   * @return Object 返回类型 
	   * @throws 
	   * @date 2014-1-16 下午5:01:35 
	   */
	public  Object parseDiscountapplyBean(Object entity) {
	    DiscountapplyBean bean = (DiscountapplyBean)entity;
	    bean.setDiscountTypeCN(getDictNameByTypeAndCode("DWFS_DISCOUNTTYPE",bean.getDiscountType()));
	    bean.setDivisionCode(getDictNameByTypeAndCode("DWFS_BELONG_DIVISION",bean.getDivisionCode()));
	    return bean;
	}
	
	  /** 
	   * @Title: parseCourseAuditBean 
	   * @Description:(课程研发/审核申 数据字典转换) 
	   * @param @param entity
	   * @return Object 返回类型 
	   * @throws 
	   * @date 2014-1-16 下午5:20:35 
	   */
	public Object parseCourseAuditBean(Object entity){
	    CourseDevelopUpdateAuditBean bean = (CourseDevelopUpdateAuditBean)entity;
	    bean.setApplyCourseType(getDictNameByTypeAndCode("WFS_APPLYCOURSETYPE",bean.getApplyCourseType()));
	    bean.setTrainManagementGroup(getDictNameByTypeAndCode("WFS_TRAINMANAGEMENTGROUP",bean.getTrainManagementGroup()));
	    return bean;
	}
	/**
	 * 
	* @MethodName: parseInspectionDataSubmitBean 
	* @description : 考核数据提交业务字典转换
	* @author：何玲菠 
	* @date： 2014-2-12 上午11:27:39
	* @param bean
	* @return Object
	 */
	@Override
	public Object parseInspectionDataSubmitBean(Object bean) {
		InspectionDataSubmitBean entity = (InspectionDataSubmitBean) bean;
		entity.setTarget(getDictNameByTypeAndCode("WFS_DATATARGET", entity.getTarget()));
		return entity;
	}
	
	/**
	 * 
	* @MethodName: parseBankaccount 
	* @description : 银行开户销户申请 实体转换
	* @author：何玲菠 
	* @date： 2014-2-14 上午10:19:56
	* @param bean
	* @return Object
	 */
	@Override
	public Object parseBankaccount(Object bean) {
		Bankaccount entity = (Bankaccount) bean;
		entity.setApplyType(getDictNameByTypeAndCode("WFS_APPLYTYPE", entity.getApplyType()));
		entity.setAccountType(getDictNameByTypeAndCode("WFS_ACCOUNT_TYPE", entity.getAccountType()));
		entity.setAccountAttribute(getDictNameByTypeAndCode("WFS_ACCOUNT_ATTRIBUTE", entity.getAccountAttribute()));
		entity.setOpenAccountBank(getDictNameByTypeAndCode("WFS_OPEN_ACCOUNT_BANK", entity.getOpenAccountBank()));
		entity.setAccountProperty(getDictNameByTypeAndCode("WFS_ACCOUNT_PROPERTY",entity.getAccountProperty()));
		entity.setInOutProperty(getDictNameByTypeAndCode("WFS_IN_OUT_PROPERTY", entity.getInOutProperty()));
		
		return entity;
	}
	
	/**
	 * 
	* @MethodName: parseDeductCargoDict 
	* @description : 扣货申请业务字典转换
	* @author：何玲菠 
	* @date： 2014-3-25 上午11:08:19
	* @param bean
	* @return Object
	 */
	@Override
	public Object parseDeductCargoDict(Object bean) {
		DeductCargo entity = (DeductCargo) bean;
		entity.setBusinessDept(getDictNameByTypeAndCode("DIP_DIVISION_NEW", entity.getBusinessDept()));
		return entity;
	}
	
	/**
	 * 
	* @MethodName: parseSiteFindPointsDict 
	* @description : 场地找点申请业务字段转换
	* @author：何玲菠 
	* @date： 2014-3-25 下午1:49:15
	* @param bean
	* @return Object
	 */
	@Override
	public Object parseSiteFindPointsDict(Object bean) {
		SiteFindPointsBean entity = (SiteFindPointsBean) bean;
		entity.setDivisionCode(getDictNameByTypeAndCode("WFS_FINDPOINT_PESONNEL", entity.getDivisionCode()));
		return entity;
	}
	/**
	 * 
	* @MethodName: parseNewDeptFound 
	* @description : 新部门成立业务字段转换
	* @author：高雅哲
	* @date： 2014-3-28 下午1:49:15
	* @param bean
	* @return Object
	 */
	public Object parseNewDeptFound(Object bean){
		NewDeptApplyBean entity = (NewDeptApplyBean) bean;
		entity.setApplyFlow(getDictNameByTypeAndCode("WFS_WORKFLOW_DIRECTION", entity.getApplyFlow()));
		entity.setApplyReflow(getDictNameByTypeAndCode("WFS_WORKFLOW_DIRECTION", entity.getApplyReflow()));
		return entity;
	}
	
	/**
	 * 
	* @MethodName: parseSystempowerapply 
	* @description : 系统权限申请
	* @author：吴桂平
	* @date： 2014-4-3 下午3:49:15
	* @param bean
	* @return Object
	* @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IllegalArgumentException 
	 */
	@Override
	public Object parseSystempowerapply(Object bean) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		SystempowerapplyParentBean entity = (SystempowerapplyParentBean)bean;
		Map<String, Class> map = new HashMap<String, Class>();
		map.put("sysApplyDetailedList", SystempowerapplyChildBean.class);
		List<SystempowerapplyChildBean> list = new ArrayList<SystempowerapplyChildBean>();
		for (Object temp : entity.getSysApplyDetailedList()) {
			list.add(JSONUtil.translateToBean(new SystempowerapplyChildBean().getClass(), JSONObject.fromObject(temp).toString()));
		}
		entity.setSysApplyDetailedList(list);
		return entity;
	}
	
	/**
	* @MethodName: parsefinancialArchivesLendingBean 
	* @description : 财务档案借阅申请,对业务字典进行转换
	* @author：吴桂平
	* @date： 2014-4-8 下午3:19:15
	* @param object
	* @return Object
	 */
	public Object parsefinancialArchivesLendingBean(Object object) {//财务档案借阅申请
		ArchivesLendingApplyBean bean = (ArchivesLendingApplyBean)object;
		bean.setLendingNature(getDictEntryService().getDictEntries("WFS_LEND_NATURE", bean.getLendingNature()).get(0).getDictname());
		bean.setFinancialType(getDictEntryService().getDictEntries("WFS_CATEGORY", bean.getFinancialType()).get(0).getDictname());
		bean.setFinancialCategory(getDictEntryService().getDictEntries("WFS_ARCHIVE_TYPE", bean.getFinancialCategory()).get(0).getDictname());
		bean.setIsPrint(getDictEntryService().getDictEntries("WFS_ISORNO", bean.getIsPrint()).get(0).getDictname());
		return bean;
	}
	/**
	* @MethodName: parseContractsign 
	* @description : 合同签订申请
	* @author：高雅哲 
	* @date： 2014-4-9 下午4:07:54
	* @param bean
	* @return
	* @throws IllegalArgumentException
	* @throws InstantiationException
	* @throws IllegalAccessException
	* @throws InvocationTargetException Object
	*/
	public Object parseContractsign (Object bean)throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		ContractApplyBean entity = (ContractApplyBean)bean;
		//	是否框架合同
		entity.setIsFrameContract(getDictNameByTypeAndCode("WFS_REFER_FINANCIAL", entity.getIsFrameContract()));
		//所属事业部
		entity.setSubordinateDepartment(getDictNameByTypeAndCode("DIP_DIVISION_NEW_ADD", entity.getSubordinateDepartment()));
		//所属财务部
		entity.setFinanceDept(getDictNameByTypeAndCode("WFS_FINANCIAL", entity.getFinanceDept()));
		//签订类型
		entity.setSignType(getDictNameByTypeAndCode("WFS_SIGNTYPE", entity.getSignType()));
		//合同类型
		entity.setContractType(getDictNameByTypeAndCode("WFS_SIGNCONTRACTTYPE",entity.getContractType()));
		//优先盖章方
		entity.setSeal(getDictNameByTypeAndCode("WFS_FIRSTCHOP", entity.getSeal()));
		return entity;
	}
	/**
	 * 
	* @MethodName: parseProcessManagementBean 
	* @description : 流程管理平台
	* @author：caibingbing 
	* @date： 2014-4-9 下午1:36:22
	* @param object
	* @return Object
	 */
	public Object parseProcessManagementBean(Object object) {//流程管理工作流
		ProcessManagementBean bean = (ProcessManagementBean)object;
		String applyType  = bean.getApplyType();
		if(applyType != null && !"".equals(applyType)){
			bean.setApplyType(getDictEntryService().getDictEntries("WFS_PROCESS_MANAGEMENT_APPLY_TYPE", applyType).get(0).getDictname());
		}
		String billLevel = bean.getBillLevel();
		if(billLevel != null && !"".equals(billLevel)){
			bean.setBillLevel(getDictEntryService().getDictEntries("WFS_BILL_LEVEL", billLevel).get(0).getDictname());
		}
		String billType = bean.getBillType();
		if(billType != null && !"".equals(billType)){
			bean.setBillType(getDictEntryService().getDictEntries("WFS_BILL_TYPE", billType).get(0).getDictname());
		}
		String baselineType = bean.getBaselineType();
		if(baselineType != null && !"".equals(baselineType)){
			bean.setBaselineType(getDictEntryService().getDictEntries("WFS_BASELIN_TYPE", baselineType).get(0).getDictname());
		}
		String supportGroup = bean.getSupportGroup();
		if(supportGroup != null && !"".equals(supportGroup)){
			bean.setSupportGroup(getDictEntryService().getDictEntries("WFS_SUPPORT_GROUP", supportGroup).get(0).getDictname());
		}
		String processImprove = bean.getProcessImprove();
		if(processImprove != null && !"".equals(processImprove)){
			bean.setProcessImprove(getDictEntryService().getDictEntries("WFS_REFER_FINANCIAL", processImprove).get(0).getDictname());
		}
		String processGoalSalchange = bean.getProcessGoalSalchange();
		if(processGoalSalchange != null && !"".equals(processGoalSalchange)){
			bean.setProcessGoalSalchange(getDictEntryService().getDictEntries("WFS_REFER_FINANCIAL", processGoalSalchange).get(0).getDictname());
		}
		String under3level = bean.getUnder3level();
		if(under3level != null && !"".equals(under3level)){
			bean.setUnder3level(getDictEntryService().getDictEntries("WFS_REFER_FINANCIAL", under3level).get(0).getDictname());
		}
		return bean;
	}
	
	/**
	 * @MethodName: parseDiscountBean
	 * @description : 折扣申请
	 * @author：关波
	 * @date： 2014-4-10 下午1:36:22
	 * @param object
	 * @return
	 */
	public Object parseDiscountBean(Object object){
		//折扣类型：DWFS_DISCOUNTTYPE  getDiscountTypeCN
		//所属事业部：DWFS_BELONG_DIVISION  getDivisionCode
		DiscountapplyBean bean = (DiscountapplyBean)object;
		bean.setDiscountTypeCN(getDictEntryService().getDictEntries("DWFS_DISCOUNTTYPE", bean.getDiscountType()).get(0).getDictname());
		bean.setDivisionCode(getDictEntryService().getDictEntries("DWFS_BELONG_DIVISION", bean.getDivisionCode()).get(0).getDictname());
		return bean;
	}
	
	/**
	* @MethodName: parseProjectContractApply 
	* @description : 项目类合同申请
	* @author：吴桂平 
	* @date： 2014-4-12 下午4:07:54
	* @param bean
	* @return
	*/
	public Object parseProjectContractApply(Object object) {
		ProjectContractApplyBean bean = (ProjectContractApplyBean)object;
		bean.setIsPmcProject(getDictEntryService().getDictEntries("WFS_ISORNO", bean.getIsPmcProject()).get(0).getDictname());
		bean.setIsFrameContract(getDictEntryService().getDictEntries("WFS_ISORNO", bean.getIsFrameContract()).get(0).getDictname());
		bean.setSubOrdInateDept(getDictEntryService().getDictEntries("DIP_DIVISION_NEW_ADD", bean.getSubOrdInateDept()).get(0).getDictname());
		bean.setSignType(getDictEntryService().getDictEntries("WFS_SIGNTYPE", bean.getSignType()).get(0).getDictname());
		bean.setContractType(getDictEntryService().getDictEntries("WFS_CONTRACT_TYPE", bean.getContractType()).get(0).getDictname());
		bean.setSeal(getDictEntryService().getDictEntries("WFS_FIRSTCHOP", bean.getSeal()).get(0).getDictname());
		return bean;
	}
	
	/**
	* @MethodName: parseActRegistrationApp 
	* @description : 活动报名申请
	* @author：吴桂平 
	* @date： 2014-4-16 下午3:07:54
	* @param bean
	* @return
	*/
	public Object parseActRegistrationApp(Object object) {
		ActRegistrationBean bean = (ActRegistrationBean)object;
		bean.setDivisionCode(getDictEntryService().getDictEntries("WFS_ACTREGIST_DIVISION", bean.getDivisionCode()).get(0).getDictname());
		bean.setIsInternalStaff(getDictEntryService().getDictEntries("WFS_ISORNO", bean.getIsInternalStaff()).get(0).getDictname());
		bean.setApplyProject(getDictEntryService().getDictEntries("WFS_ACT_PROJECT", bean.getApplyProject()).get(0).getDictname());
		bean.setSpouseDivisionCode(getDictEntryService().getDictEntries("WFS_ACTREGIST_DIVISION", bean.getSpouseDivisionCode()).get(0).getDictname());
		return bean;
	}
	
	/**
	* @MethodName: parseMarketResearch 
	* @description : 市场调研申请
	* @author：吴桂平 
	* @date： 2014-4-18 下午2:07:54
	* @param bean
	* @return
	*/
	public Object parseMarketResearch(Object object) {
		MarketResearchBean bean = (MarketResearchBean)object;
		if(null != bean.getOutSourcing() && !"".equals(bean.getOutSourcing())) {
			bean.setOutSourcing(getDictEntryService().getDictEntries("WFS_OUTSOURCING_YESORNO", bean.getOutSourcing()).get(0).getDictname());
		}
		return bean;
	}
	
	/**
	* @MethodName: parseAdmitApplyBean 
	* @description : 接待申请
	* @author：吴桂平 
	* @date： 2014-4-23 上午9:07:54
	* @param bean
	* @return
	*/
	public Object parseAdmitApplyBean(Object object) {
		AdmitApplyBean bean = (AdmitApplyBean)object;
		bean.setVisitors(getDictEntryService().getDictEntries("WFS_VISITORS", bean.getVisitors()).get(0).getDictname());
		return bean;
	}
	
	/**
	* @MethodName: parseCommissionMakeOrChangeBean 
	* @description : 营运提成单项奖设立与调整申请
	* @author：吴桂平 
	* @date：2014-4-23 上午9:07:54
	* @param bean
	* @return
	*/
	public Object parseCommissionMakeOrChangeBean(Object object) {
		CommissionMakeOrChangeBean bean = (CommissionMakeOrChangeBean)object;
		bean.setOperationDepartment(getDictEntryService().getDictEntries("WFS_HEADQUARTERS", bean.getOperationDepartment()).get(0).getDictname());
		bean.setApplyType(getDictEntryService().getDictEntries("WFS_APPLYTYPE_COMMOSSIONMAKERORCHANGE", bean.getApplyType()).get(0).getDictname());
		bean.setRelateSalary(getDictEntryService().getDictEntries("WFS_RELATE_SALARY", bean.getRelateSalary()).get(0).getDictname());
		return bean;
	}
	
	/**
	* @MethodName: parseProblemFeedbackBean
	* @description : 一线问题反馈
	* @author：吴桂平 
	* @date：2014-4-28 上午11:07:54
	* @param bean
	* @return
	*/
	public Object parseProblemFeedbackBean(Object object) {
		ProblemFeedbackBean bean = (ProblemFeedbackBean)object;
		bean.setDivision(getDictEntryService().getDictEntries("DWFS_DIVISION_PROBLEM_FEEDBACK", bean.getDivision()).get(0).getDictname());
		bean.setOperateDept(getDictEntryService().getDictEntries("DWFS_OPERATE_DEPT", bean.getOperateDept()).get(0).getDictname());
		bean.setProblemType(getDictEntryService().getDictEntries("DWFS_PROBLEM_FEEDBACK_TYPE", bean.getProblemType()).get(0).getDictname());
		return bean;
	}
	/**
	 * @MethodName: parseWelfarePaymentBeanBean
	 * @description : 福利费发放申请
	 * @author：关波
	 * @date： 2014-5-29 下午1:36:22
	 * @param object
	 * @return
	 */
	public Object parseWelfarePaymentBeanBean(Object object) {
		WelfarePaymentBean bean = (WelfarePaymentBean)object;
		//申请发放类型转意WFS_SALARY_TYPE
		bean.setWagesTypeName(getDictEntryService().getDictEntries("WFS_SALARY_TYPE", bean.getWagesType()).get(0).getDictname());
		//申请发放薪资月份WFS_MONTH
		bean.setEarningsMonth(getDictEntryService().getDictEntries("WFS_MONTH", bean.getEarningsMonth()).get(0).getDictname());
		return bean;
	}
	/**
	 * @MethodName: storeRentBean
	 * @description : 商铺租赁合同申请
	 * @author：赵慧
	 * @date：2014-5-21
	 * @param bean
	 * @return
	 * */
	public Object storeRentBean(Object object) {
		StoreRent bean = (StoreRent)object;
		/**
		 * 签订类型    WFS_SIGNTYPE    signType
		 * 所属子公司    SUB_COMPANY    belongSubsidiary
		 * 承租方名称lessee    SUB_COMPANY    lessee
		 * 付款方式    WFS_PAYTYPE    paymentType
		 * */
		bean.setSignType(getDictEntryService().getDictEntries("WFS_SIGNTYPE", bean.getSignType()).get(0).getDictname());
		bean.setBelongSubsidiary(getDictEntryService().getDictEntries("SUB_COMPANY", bean.getBelongSubsidiary()).get(0).getDictname());
		bean.setLessee(getDictEntryService().getDictEntries("SUB_COMPANY", bean.getLessee()).get(0).getDictname());
		bean.setPaymentType(getDictEntryService().getDictEntries("WFS_PAYTYPE", bean.getPaymentType()).get(0).getDictname());
		
		return bean;
	}
	/**
	 * 
	* @MethodName: parseOtherSideLineProxy 
	* @description : 偏线代理合同工作流
	* @author：caibingbing 
	* @date： 2014-5-21 下午1:46:22
	* @param entity
	* @return Object
	 */
	@Override
	public Object parseOtherSideLineProxy(Object entity) {
		OtherSideLineProxy bean = (OtherSideLineProxy)entity;
		bean.setFlowCategory(getDictEntryService().getDictEntries("WFS_PROXY_WFTYPE", bean.getFlowCategory()).get(0).getDictname());
		bean.setFinqnceCode(getDictEntryService().getDictEntries("NEW_FINANCIAL", bean.getFinqnceCode()).get(0).getDictname());
		bean.setBusinessUnitsCode(getDictEntryService().getDictEntries("DIP_DIVISION_NEW", bean.getBusinessUnitsCode()).get(0).getDictname());
		bean.setMarginpayCategory(getDictEntryService().getDictEntries("WFS_PAYMENT", bean.getMarginpayCategory()).get(0).getDictname());
		bean.setStartCostPayCategory(getDictEntryService().getDictEntries("WFS_PAYMENT", bean.getStartCostPayCategory()).get(0).getDictname());
		return bean;
	}
	/**
	 * 
	* @MethodName: parseTruckPartBuyMaintain 
	* @description : 货车配件采购/维修/保养
	* @author：caibingbing 
	* @date： 2014-5-21 下午4:53:04
	* @param entity
	* @return Object
	 */
	@Override
	public Object parseTruckPartBuyMaintain(Object entity) {
		TruckPartBuyMaintainBean bean = (TruckPartBuyMaintainBean)entity;
		bean.setArea(getDictEntryService().getDictEntries("DIP_DIVISION_NEW_ADD", bean.getArea()).get(0).getDictname());
		bean.setCategory(getDictEntryService().getDictEntries("WFS_TRUCK_APPLY_TYPE", bean.getCategory()).get(0).getDictname());
		bean.setTruckType(getDictEntryService().getDictEntries("WFS_TRUCK_TYPE", bean.getTruckType()).get(0).getDictname());
		return bean;
	}
	/**
	 * 
	* @MethodName: parseEmpDormBean 
	* @description : 员工宿舍
	* @author：caibingbing 
	* @date： 2014-5-22 上午9:30:24
	* @param entity
	* @return Object
	 */
	@Override
	public Object parseEmpDormBean(Object entity) {
		EmpDormBean bean = (EmpDormBean)entity;
		bean.setDepartNature(getDictEntryService().getDictEntries("WFS_DEPT_TYPE", bean.getDepartNature()).get(0).getDictname());
		bean.setAreaub(getDictEntryService().getDictEntries("DIP_DIVISION_NEW", bean.getAreaub()).get(0).getDictname());
		return bean;
	}
	/**
	 * 
	* @MethodName: parseProductAdjustmentBean 
	* @description :  节点与产品调整实体B
	* @author：caibingbing 
	* @date： 2014-5-22 下午2:09:38
	* @param entity
	* @return Object
	 */
	@Override
	public Object parseProductAdjustmentBean(Object entity) {
		ProductAdjustmentBean bean = (ProductAdjustmentBean)entity;
		bean.setBusinessDept(getDictEntryService().getDictEntries("DIP_DIVISION_NEW", bean.getBusinessDept()).get(0).getDictname());
		bean.setApplyTypeCar(getDictEntryService().getDictEntries("WFS_APPLYTYPECAR_PRODUCT", bean.getApplyTypeCar()).get(0).getDictname());
		bean.setApplyTypeOpen(getDictEntryService().getDictEntries("WFS_APPLYTYPEOPEN_PRODUCT", bean.getApplyTypeOpen()).get(0).getDictname());
		return bean;
	}
	/**
	 * 
	* @MethodName: parseFoundQueryTeamBean 
	* @description : 成立接送货开单查询组
	* @author：caibingbing 
	* @date： 2014-5-26 下午1:52:45
	* @param entity
	* @return Object
	 */
	@Override
	public Object parseFoundQueryTeamBean(Object entity) {
		FoundQueryTeamBean bean = (FoundQueryTeamBean)entity;
		bean.setLocalPersonnel(getDictEntryService().getDictEntries("WFS_TRAIN", bean.getLocalPersonnel()).get(0).getDictname());
		return bean;
	}
	/**
	* @MethodName: getCommDWFSDetailsWithSubEntity 
	* @description : 获取工作流详情信息
	* @author：caibingbing 
	* @date： 2013-11-28 上午10:06:35
	* @param entity
	* @param actionUrl
	* @param params
	* @param sid
	* @return
	* @throws IllegalArgumentException
	* @throws UnsupportedEncodingException
	* @throws InstantiationException
	* @throws IllegalAccessException
	* @throws InvocationTargetException Object
	 * @throws ClassNotFoundException 
	 */
	@Override
	public Object getCommDWFSDetailsWithSubEntity(Object obj,Map<String, Class> classMap, String actionUrl,Map<String, String> params, String sid)
			throws IllegalArgumentException, UnsupportedEncodingException,InstantiationException, IllegalAccessException,InvocationTargetException, ClassNotFoundException {
		DWFSWorkItemServiceClient client = new DWFSWorkItemServiceClient();
		return JSONUtil.translateToSubBean(obj.getClass(),classMap,client.postToDWFS(actionUrl, params, sid));
	}
	/**
	 * 
	* @MethodName: parseLongDisDriverAgingBreaksBean 
	* @description : 长途司机时效减免申请 分录表
	* @author：caibingbing 
	* @date： 2014-5-26 下午1:52:45
	* @param entity
	* @return Object
	 */
	@Override
	public Object parseLongDisDriverAgingBreaksBean(Object entity) {
		LongDisDriverAgingBreaksBean bean = (LongDisDriverAgingBreaksBean)entity;
		List<LongDisDriversDataDellBean> cells = bean.getDataCells();
		for(LongDisDriversDataDellBean cell:cells){
			cell.setApplyBreaksType(getDictEntryService().getDictEntries("WFS_APPLYBREAKSTYPE", cell.getApplyBreaksType()).get(0).getDictname());
			cell.setTimeoutValue(getDictEntryService().getDictEntries("WFS_TIMEOUTVALUE", cell.getTimeoutValue()).get(0).getDictname());
		}
		return bean;
	}
	/**
	 * @MethodName: translateSignDataBean
	 * @description : 法定代表人/负责人签字申请
	 * @author：赵慧
	 * @date：2014-6-3
	 * @param bean
	 * @return
	 * */
	@Override
	public Object translateSignDataBean(Object bean)
			throws IllegalArgumentException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		LegalSignBean entity = (LegalSignBean)bean;
		List<SignDataBean> list = new ArrayList<SignDataBean>();
		for (Object temp : entity.getDataCells()) {
			list.add(JSONUtil.translateToBean(new SignDataBean().getClass(), JSONObject.fromObject(temp).toString()));
		}
		entity.setDataCells(list);
		return entity;
	}
	/**
	* @MethodName: parseStaffReturnToHr
	* @description : 员工退回人力资源部
	* @author：gaoyazhe
	* @date：2014-4-28 上午11:07:54
	* @param bean
	* @return
	*/
	public Object parseStaffReturnToHr(Object object) {
		StaffReturnToHrBean bean = (StaffReturnToHrBean)object;
		bean.setPersonal(getDictEntryService().getDictEntries("WFS_RESIGN_PERSONNEL", bean.getPersonal()).get(0).getDictname());
		return bean;
	}
	
	/**
	* @MethodName: parseStaffReturnToHr
	* @description : 合同销毁
	* @author：gaoyazhe
	* @date：2014-4-28 上午11:07:54
	* @param bean
	* @return
	*/
	public Object parseDestroyContract(Object object) {
		DestroyContractBean bean = (DestroyContractBean)object;
		bean.setAreaub(getDictEntryService().getDictEntries("DIP_DIVISION_NEW", bean.getAreaub()).get(0).getDictname());
		return bean;
	}
	/**
	 * 
	* @MethodName: parseOnlinBean 
	* @description : 开线申请业务字典字段解析
	* @author：caibingbing 
	* @date： 2014-6-13 上午10:57:52
	* @param entity
	* @return Object
	 */
	@Override
	public Object parseOnlinBean(Object entity) {
		OnlineBean bean = (OnlineBean)entity;
		bean.setOutFieldAre(getDictEntryService().getDictEntries("WFS_ALL_PERSONALDEPT", bean.getOutFieldAre()).get(0).getDictname());
		bean.setInFieldAre(getDictEntryService().getDictEntries("WFS_ALL_PERSONALDEPT", bean.getInFieldAre()).get(0).getDictname());
		bean.setCarType(getDictEntryService().getDictEntries("WFS_ONLINE_CARTYPE", bean.getCarType()).get(0).getDictname());
		bean.setCarModel(getDictEntryService().getDictEntries("WFS_CARMODEL", bean.getCarModel()).get(0).getDictname());
		bean.setLineType(getDictEntryService().getDictEntries("WFS_LINETYPE", bean.getLineType()).get(0).getDictname());
		return bean;
	}
	/**
	* @MethodName: parseCourseDevelopUpdateAudit
	* @description :课程研发
	* @author：gaoyazhe
	* @date：2014-4-28 上午11:07:54
	* @param bean
	* @return
	*/
	public Object parseCourseDevelopUpdateAudit(Object object) {
		CourseDevelopUpdateAuditBean bean = (CourseDevelopUpdateAuditBean)object;
		//bean.setApplyCourseType(getDictEntryService().getDictEntries("WFS_APPLYCOURSETYPE", bean.getApplyCourseType()).get(0).getDictname());
		bean.setTrainManagementGroup(getDictEntryService().getDictEntries("WFS_TRAINMANAGEMENTGROUP", bean.getTrainManagementGroup()).get(0).getDictname());
		return bean;
	}
	/**
	* @MethodName: parseSealCarve
	* @description :刻章申请
	* @author：gaoyazhe
	* @date：2014-4-28 上午11:07:54
	* @param bean
	* @return
	*/
	public Object parseSealCarve(Object object) {
		SealCarveApplyBean bean = (SealCarveApplyBean)object;
		//bean.setApplyCourseType(getDictEntryService().getDictEntries("WFS_APPLYCOURSETYPE", bean.getApplyCourseType()).get(0).getDictname());
		bean.setDivision(getDictEntryService().getDictEntries("WFS_SEALCARVE_DIVISION", bean.getDivision()).get(0).getDictname());
		bean.setFinanceDept(getDictEntryService().getDictEntries("WFS_SEALCARVE_DIVISION", bean.getFinanceDept()).get(0).getDictname());
		bean.setAffairsSection(getDictEntryService().getDictEntries("WFS_SEALCARVE_AFFAIRSSECTION", bean.getAffairsSection()).get(0).getDictname());
		bean.setSealType(getDictEntryService().getDictEntries("WFS_SEALCARVE_SEALTYPE", bean.getSealType()).get(0).getDictname());
		return bean;
	}
	
	/**
	* @MethodName: parseSystemDataChangeApply
	* @description :系统数据变更
	* @author：关波
	* @date：2014-6-26 上午11:07:54
	* @param bean
	* @return
	*/
	public Object parseSystemDataChangeApply(Object object) {
		SystemDataChangeApplyBean bean = (SystemDataChangeApplyBean)object;
		bean.setSystemId(getDictEntryService().getDictEntries("WFS_PROBLEM_BELONG_SYSTEM", bean.getSystemId()).get(0).getDictname());
		bean.setFinancialDicValue(getDictEntryService().getDictEntries("WFS_REFER_FINANCIAL", bean.getFinancialStatus()).get(0).getDictname());
//		bean.setFinancialStatus(getDictEntryService().getDictEntries("WFS_REFER_FINANCIAL", bean.getFinancialStatus()).get(0).getDictname());
		//WFS_PROBLEM_BELONG_SYSTEM
		/*bean.setSystemList(getDictEntryService().getDictEntries("WFS_PROBLEM_BELONG_SYSTEM", null));
		bean.setFinancialDict(getDictEntryService().getDictEntries("WFS_REFER_FINANCIAL", null));
		*/
		return bean;
	}
}
