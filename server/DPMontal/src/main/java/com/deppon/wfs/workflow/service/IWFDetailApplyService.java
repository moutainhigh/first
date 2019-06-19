package com.deppon.wfs.workflow.service;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface IWFDetailApplyService {
	/**
	* @MethodName: getCommDWFSDetails 
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
	Object getCommDWFSDetails(Object obj, String actionUrl, Map<String, String> params , String sid) throws IllegalArgumentException, UnsupportedEncodingException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException;
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
	Object getCommDWFSDetailsWithSubEntity(Object obj,Map<String, Class> classMap, String actionUrl, Map<String, String> params , String sid) throws IllegalArgumentException, UnsupportedEncodingException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException;
	/**
	* @MethodName: getCommDWFSDetailsWithSubEntity 
	* @description : 获取工作流详情信息
	* @author：gaoyazhe
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
	String getCommDWFSUrl(String actionUrl1, Map<String, String> params2,String attribute) throws IllegalArgumentException, UnsupportedEncodingException, InstantiationException, IllegalAccessException, InvocationTargetException;
	/**
	 * 
	* @MethodName: parseQualificationApplyBean 
	* @description : 任职资格实体转换
	* @author：何玲菠 
	* @date： 2014-2-27 下午3:13:41
	* @param obj
	* @return Object
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IllegalArgumentException 
	 */
	Object parseQualificationApplyBean(Object obj) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException;
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
	Object translateRepairAttendance(Object bean) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException;
	public Object parseEntity(Object entity);
	/**
	* @MethodName: parseAssessmentSchemeBeanEntity 
	* @description : 转换实体中业务字典
	* @author：caibingbing 
	* @date： 2013-11-29 下午5:38:40
	* @param entity
	* @return Object
	 */
	Object parseAssessmentSchemeBeanEntity(Object entity);
	/**
	 * 
	* @MethodName: parseTrainBean 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-11-29 下午5:48:57
	* @param entity
	* @return Object
	 */
	Object parseTrainBean(Object entity);
	/**
	 * 
	* @MethodName: parseMarketActivityBean 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-11-29 下午6:00:48
	* @param entity
	* @return Object
	 */
	Object parseMarketActivityBean(Object entity);
	
	
	/**
	 * 辞职申请工作流实体转换
	* @MethodName: translateResign 
	* @description : TODO
	* @author：liming
	* @date： 2013-12-2 下午6:13:24
	* @param bean
	* @return Object
	 */
	Object translateResign(Object bean);
	
	/**
	 * 
	* @MethodName: translateExternalstudy 
	* @description : 外训申请实体转换
	* @author：liming
	* @date： 2013-11-30 上午11:32:24
	* @param bean
	* @return Object
	 */
	Object translateExternalstudy(Object bean);
	
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
	Object translateBudgedata(Object bean) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException;
	
	/**
	 * 
	* @MethodName: translateYardRentBean 
	* @description :场地租赁/转租合同转换
	* @author：liming
	* @date： 2013-11-30 下午03:44:41
	* @param bean
	* @return Object
	 */
	Object translateYardRentBean(Object bean);
	
	/**
	 * 
	* @MethodName: translateOverTimePay 
	* @description : 加班/加班工资申请转换
	* @author：liming
	* @date： 2013-12-2 上午11:21:06
	* @param bean
	* @return Object
	 */
	Object translateOverTimePay(Object entity);
	
	/**
	   * @Title: parseLaywerapplyBean 
	   * @Description:免职申请数据字典转换
	   * @date 2014-1-15 上午10:06:48
	 */
	Object parseAssessmentSchemeApplyBean(Object entity);
	
	/**
	   * @Title: parseDismissalBean 
	   * @Description:免职申请数据字典转换
	   * @date 2014-1-15 上午10:06:48
	 */
	Object parseDismissalBean(Object bean);
	
        
           /** 
           * @Title: parseDiscountapplyBean 
           * @Description:(折扣申请数据字典转换) 
           * @date 2014-1-16 下午5:08:05 
           */
        Object parseDiscountapplyBean(Object entity);
        
        /** 
         * @Title: parseCourseAuditBean 
         * @Description:(课程研发/审核申请数据字典转换) 
         * @date 2014-1-16 下午5:08:05 
         */
        Object parseCourseAuditBean(Object entity);
        
    	/**
    	 * 
    	* @MethodName: parseInspectionDataSubmitBean 
    	* @description : 考核数据提交业务字典转换
    	* @author：何玲菠 
    	* @date： 2014-2-12 上午11:27:39
    	* @param bean
    	* @return Object
    	 */
    	Object parseInspectionDataSubmitBean(Object bean);
    	
    	/**
    	 * 
    	* @MethodName: parseBankaccount 
    	* @description : 银行开户销户申请 实体转换
    	* @author：何玲菠 
    	* @date： 2014-2-14 上午10:19:56
    	* @param bean
    	* @return Object
    	 */
    	Object parseBankaccount(Object bean);
    	
    	/**
    	 * 
    	* @MethodName: parseDeductCargoDict 
    	* @description : 扣货申请业务字典转换
    	* @author：何玲菠 
    	* @date： 2014-3-25 上午11:08:19
    	* @param bean
    	* @return Object
    	 */
    	Object parseDeductCargoDict(Object bean);
    	
    	/**
    	 * 
    	* @MethodName: parseSiteFindPointsDict 
    	* @description : 场地找点申请业务字段转换
    	* @author：何玲菠 
    	* @date： 2014-3-25 下午1:49:15
    	* @param bean
    	* @return Object
    	 */
    	Object parseSiteFindPointsDict(Object bean);
    	/**
    	 * 
    	* @MethodName: parseNewDeptFound 
    	* @description : 新部门成立业务字段转换
    	* @author：高雅哲
    	* @date： 2014-3-28 下午1:49:15
    	* @param bean
    	* @return Object
    	 */
    	Object parseNewDeptFound(Object bean);
    	
    	/**
    	 * 
    	* @MethodName: parseSystempowerapply 
    	* @description : 系统权限申请
    	* @author：吴桂平
    	* @date： 2014-4-3 下午3:49:15
    	* @param bean
    	* @return Object
    	 */
    	Object parseSystempowerapply(Object bean) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException;
    	
    	/**
    	* @MethodName: parsefinancialArchivesLendingBean 
    	* @description : 财务档案借阅申请,对业务字典进行转换
    	* @author：吴桂平
    	* @date： 2014-4-8 下午3:19:15
    	* @param bean
    	* @return Object
    	 */
    	Object parsefinancialArchivesLendingBean(Object object) ;
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
    	Object parseContractsign (Object bean)throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException;
    	/**
    	 * 
    	* @MethodName: parseProcessManagementBean 
    	* @description : 流程管理平台
    	* @author：caibingbing 
    	* @date： 2014-4-9 下午1:36:22
    	* @param object
    	* @return Object
    	 */
    	Object parseProcessManagementBean(Object object);
    	
    	/**
    	 * @MethodName: parseDiscountBean
    	 * @description : 折扣申请
    	 * @author：关波
    	 * @date： 2014-4-10 下午1:36:22
    	 * @param object
    	 * @return
    	 */
    	Object parseDiscountBean(Object object);
    	
    	/**
    	* @MethodName: parseProjectContractApply 
    	* @description : 项目类合同申请
    	* @author：吴桂平 
    	* @date： 2014-4-12 下午4:07:54
    	* @param bean
    	* @return
    	*/
    	Object parseProjectContractApply(Object bean) ;
    	
    	/**
    	* @MethodName: parseActRegistrationApp 
    	* @description : 活动报名申请
    	* @author：吴桂平 
    	* @date： 2014-4-16 下午3:07:54
    	* @param bean
    	* @return
    	*/
    	Object parseActRegistrationApp(Object bean) ;
    	
    	/**
    	* @MethodName: parseMarketResearch 
    	* @description : 市场调研申请
    	* @author：吴桂平 
    	* @date： 2014-4-18 下午2:07:54
    	* @param bean
    	* @return
    	*/
    	Object parseMarketResearch(Object bean) ;
    	
    	/**
    	* @MethodName: parseAdmitApplyBean 
    	* @description : 接待申请
    	* @author：吴桂平 
    	* @date： 2014-4-23 上午9:07:54
    	* @param bean
    	* @return
    	*/
    	Object parseAdmitApplyBean(Object object) ;
    	
    	/**
    	* @MethodName: parseCommissionMakeOrChangeBean 
    	* @description : 营运提成单项奖设立与调整申请
    	* @author：吴桂平 
    	* @date：2014-4-23 上午9:07:54
    	* @param bean
    	* @return
    	*/
    	Object parseCommissionMakeOrChangeBean(Object object) ;
    	
    	/**
    	* @MethodName: parseProblemFeedbackBean 
    	* @description : 一线问题反馈
    	* @author：吴桂平 
    	* @date：2014-4-28 上午11:07:54
    	* @param bean
    	* @return
    	*/
    	Object parseProblemFeedbackBean(Object object) ;
    	/**
    	 * @MethodName: storeRentBean
    	 * @description : 商铺租赁合同申请
    	 * @author：赵慧
    	 * @date：2014-5-21
    	 * @param bean
    	 * @return
    	 * */
    	Object storeRentBean(Object object);

    	/**
    	 * @MethodName: parseWelfarePaymentBeanBean
    	 * @description : 福利费发放申请
    	 * @author：关波
    	 * @date： 2014-5-29 下午1:36:22
    	 * @param object
    	 * @return
    	 */
    	Object parseWelfarePaymentBeanBean(Object object);
    	/**
    	 * 
    	* @MethodName: parseOtherSideLineProxy 
    	* @description : 偏线代理合同工作流
    	* @author：caibingbing 
    	* @date： 2014-5-21 下午1:46:22
    	* @param entity
    	* @return Object
    	 */
		Object parseOtherSideLineProxy(Object entity);
		/**
		 * 
		* @MethodName: parseTruckPartBuyMaintain 
		* @description : 货车配件采购/维修/保养
		* @author：caibingbing 
		* @date： 2014-5-21 下午4:53:04
		* @param entity
		* @return Object
		 */
		Object parseTruckPartBuyMaintain(Object entity);
		/**
		 * 
		* @MethodName: parseEmpDormBean 
		* @description : 员工宿舍
		* @author：caibingbing 
		* @date： 2014-5-22 上午9:30:24
		* @param entity
		* @return Object
		 */
		Object parseEmpDormBean(Object entity);
		/**
		 * 
		* @MethodName: parseProductAdjustmentBean 
		* @description :  节点与产品调整实体B
		* @author：caibingbing 
		* @date： 2014-5-22 下午2:09:38
		* @param entity
		* @return Object
		 */
		Object parseProductAdjustmentBean(Object entity);
		/**
		 * 
		* @MethodName: parseFoundQueryTeamBean 
		* @description : 成立接送货开单查询组
		* @author：caibingbing 
		* @date： 2014-5-26 下午1:52:45
		* @param entity
		* @return Object
		 */
		Object parseFoundQueryTeamBean(Object entity);
		/**
		 * 
		* @MethodName: parseLongDisDriverAgingBreaksBean 
		* @description : 长途司机时效减免申请
		* @author：caibingbing 
		* @date： 2014-5-26 下午1:52:45
		* @param entity
		* @return Object
		 */
		Object parseLongDisDriverAgingBreaksBean(Object entity);

		/**
    	 * @MethodName: translateSignDataBean
    	 * @description : 法定代表人/负责人签字申请
    	 * @author：赵慧
    	 * @date：2014-6-3
    	 * @param bean
    	 * @return
    	 * */
		Object translateSignDataBean(Object bean) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException;
    	/**
    	* @MethodName: parseStaffReturnToHr
    	* @description : 员工退回人力资源部
    	* @author：gaoyazhe
    	* @date：2014-4-28 上午11:07:54
    	* @param bean
    	* @return
    	*/
    	Object parseStaffReturnToHr(Object object) ;
    	/**
    	* @MethodName: parseDestroyContract
    	* @description : 合同销毁
    	* @author：gaoyazhe
    	* @date：2014-4-28 上午11:07:54
    	* @param bean
    	* @return
    	*/
    	Object parseDestroyContract(Object object) ;
    	/**
    	 * 
    	* @MethodName: parseOnlinBean 
    	* @description : 开线申请业务字典字段解析
    	* @author：caibingbing 
    	* @date： 2014-6-13 上午10:57:52
    	* @param entity
    	* @return Object
    	 */
		Object parseOnlinBean(Object entity);
    	/**
    	* @MethodName: parseCourseDevelopUpdateAudit
    	* @description :课程研发
    	* @author：gaoyazhe
    	* @date：2014-4-28 上午11:07:54
    	* @param bean
    	* @return
    	*/
    	Object parseCourseDevelopUpdateAudit(Object object);
    	/**
    	* @MethodName: parseSealCarve
    	* @description :刻章申请
    	* @author：gaoyazhe
    	* @date：2014-4-28 上午11:07:54
    	* @param bean
    	* @return
    	*/
    	Object parseSealCarve(Object object);
    	
    	/**
    	* @MethodName: parseSystemDataChangeApply
    	* @description :系统数据变更
    	* @author：关波
    	* @date：2014-6-26 上午11:07:54
    	* @param bean
    	* @return
    	*/
    	public Object parseSystemDataChangeApply(Object object);
}
