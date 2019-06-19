package com.deppon.wfs.workflow.domain;


import java.util.Date;

/**
 * 合同销毁申请
 * 1.1点击提交，完成此次工作流审批，页面跳转至未审批工作流列表；
1.2点击回退，即可弹出回退选择界面，可选择回退至当前节点前面的任一审批节点
（如存在逐级审批节点，则该节点中的人员不具备回退权限，其他审批节点不可回退至逐级审批的节点）；
1.3点击返回，则退出当前审批页面，跳转至未审批工作流列表；
 2、回退选择页面：
   2.1点击回退，则工作流退回至所选择的节点，当前页面关闭跳转至未审批工作流列表；
   2.2点击取消，则退出当前回退选择页面，返回至该工作流审批界面；
 * 起草人	起草合同销毁工作流			
法律事务部负责人	审核销毁清册中合同是否可以销毁	法律事务部	法律事务部负责人	
合同管理组负责人	审核销毁清册中合同是否可以销毁	合同管理组	合同管理组负责人	
起草人直接上级	审核销毁清册中合同是否可以销毁			

业务功能
业务描述
流程描述：本流程是合同管理中，对合同销毁的具体描述；有合同销毁需求必须通过起草判定工作流并审批同意后才能进行销毁，没有起草工作流和未同意，不能私自销毁合同，促使合同管理员严格按照公司的文件标准执行，相关部门通过工作流的审批监控外围合同现状，使合同销毁的流程合理化、标准化，降低公司法律风险。
流程目标：达到销毁标准的合同，合同管理员起草工作流，经法律事务部负责人、合同管理组负责人、合同管理员的直接上级审批同意后，进行销毁。以达到合同的科学保管。
 * 1、审批工作流界面：
1.1点击提交，完成此次工作流审批，页面跳转至未审批工作流列表；
1.2点击回退，即可弹出回退选择界面，可选择回退至当前节点前面的任一审批节点；
1.3点击返回，则退出当前审批页面，跳转至未审批工作流列表；
 2、回退选择页面：
   2.1点击回退，则工作流退回至所选择的节点，当前页面关闭跳转至未审批工作流列表；
   2.2点击取消，则退出当前回退选择页面，返回至该工作流审批界面；
uc_OA_dd_yt_03+亲情1+1账号提交/更改流程
用例描述
　　流程图：展示整个业务所对应的流程，以及及时显示流程的进度，以便供用户直观的了解所申请的流程、进度；
用例条件
条件类型	描述	引用用例
前置条件	用户身份已被鉴别；
用户具有相应权限；	
后置条件	工作流流向正常；	
操作步骤
序号	基本步骤	补充步骤
1	“亲情1+1账号提交/更改”申请工作流—流程图；	

序号	扩展事件	备注
1	对系统预留事件的描述和系统异常的补充	
业务规则
序号	描述
RULE-A1	开始→起草申请→薪酬专员审批→结束；
RULE-A2	任意节点审批不同意，则此工作流结束，状态为未同意；
RULE-A3	工作流状态变化：
用户提交生成工作流后，工作流状态为“未审批”；
第一个审批人开始审批，审批同意后，状态为“审批中”；
最后一个审批节点审批同意后，工作流状态为“已同意”；
任意一个环节不同意，则该流程结束，状态显示为“未同意”；
任意一个节点选择回退至起草人处，状态显示为“已退回”、回退至其他节点状态为“审批中”；
 */

/**
* @title: DestroyContractBean 
* @description：合同销毁申请实体类
* @author： 高雅哲
* @date： 2013-9-6 下午3:08:08
*/
public class DestroyContractBean extends Entity{
	
	    /**
	* 
	*/
	private static final long serialVersionUID = 1L;

		/**
	     * 主键
	     */
	    private String busino;

	    /**
	     * 流程实例ID
	     */
	    private Long processinstid;

	    /**
	     * 员工（起草人）工号
	     */
	    private String applyPersonId;

	    /**
	     * 员工（起草人）姓名
	     */
	    private String applyPersonName;

	    /**
	     * 所属事业部
	     */
	    private String areaub;

	    /**
	     *合同类型
	     */
	    private String contractType;

	    /**
	     * 销毁合同到期时间段开始
	     */
	    private Date startDate;

	    /**
	     * 销毁合同到期时间段结束
	     */
	    private Date endDate;

	    /**
	     *申请事由
	     */
	    private String applyReasons;

	    /**
	     * 创建时间
	     */
	    private Date createTime;

	    /**
	     * 修改时间
	     */
	    private Date modifyTime;

	    /**
	     * 业务状态
	     */
	    private String isseffective;

	    /**
	     * 备用字段1
	     */
	    private Object spareField1;

	    /**
	     * 备用字段2
	     */
	    private Object spareField2;

	    /**
	     * 数字字段（扩展）
	     */
	    private Long subnumber;

		/**
		 * @return the busino
		 */
		public String getBusino() {
			return busino;
		}

		/**
		 * @param busino the busino to set
		 */
		public void setBusino(String busino) {
			this.busino = busino;
		}

		/**
		 * @return the processinstid
		 */
		public Long getProcessinstid() {
			return processinstid;
		}

		/**
		 * @param processinstid the processinstid to set
		 */
		public void setProcessinstid(Long processinstid) {
			this.processinstid = processinstid;
		}

		/**
		 * @return the applyPersonId
		 */
		public String getApplyPersonId() {
			return applyPersonId;
		}

		/**
		 * @param applyPersonId the applyPersonId to set
		 */
		public void setApplyPersonId(String applyPersonId) {
			this.applyPersonId = applyPersonId;
		}

		/**
		 * @return the applyPersonName
		 */
		public String getApplyPersonName() {
			return applyPersonName;
		}

		/**
		 * @param applyPersonName the applyPersonName to set
		 */
		public void setApplyPersonName(String applyPersonName) {
			this.applyPersonName = applyPersonName;
		}

		/**
		 * @return the areaub
		 */
		public String getAreaub() {
			return areaub;
		}

		/**
		 * @param areaub the areaub to set
		 */
		public void setAreaub(String areaub) {
			this.areaub = areaub;
		}

		/**
		 * @return the contractType
		 */
		public String getContractType() {
			return contractType;
		}

		/**
		 * @param contractType the contractType to set
		 */
		public void setContractType(String contractType) {
			this.contractType = contractType;
		}

		/**
		 * @return the startDate
		 */
		public Date getStartDate() {
			return startDate;
		}

		/**
		 * @param startDate the startDate to set
		 */
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		/**
		 * @return the endDate
		 */
		public Date getEndDate() {
			return endDate;
		}

		/**
		 * @param endDate the endDate to set
		 */
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		/**
		 * @return the applyReasons
		 */
		public String getApplyReasons() {
			return applyReasons;
		}

		/**
		 * @param applyReasons the applyReasons to set
		 */
		public void setApplyReasons(String applyReasons) {
			this.applyReasons = applyReasons;
		}

		/**
		 * @return the createTime
		 */
		public Date getCreateTime() {
			return createTime;
		}

		/**
		 * @param createTime the createTime to set
		 */
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		/**
		 * @return the modifyTime
		 */
		public Date getModifyTime() {
			return modifyTime;
		}

		/**
		 * @param modifyTime the modifyTime to set
		 */
		public void setModifyTime(Date modifyTime) {
			this.modifyTime = modifyTime;
		}

		/**
		 * @return the isseffective
		 */
		public String getIsseffective() {
			return isseffective;
		}

		/**
		 * @param isseffective the isseffective to set
		 */
		public void setIsseffective(String isseffective) {
			this.isseffective = isseffective;
		}

		/**
		 * @return the spareField1
		 */
		public Object getSpareField1() {
			return spareField1;
		}

		/**
		 * @param spareField1 the spareField1 to set
		 */
		public void setSpareField1(Object spareField1) {
			this.spareField1 = spareField1;
		}

		/**
		 * @return the spareField2
		 */
		public Object getSpareField2() {
			return spareField2;
		}

		/**
		 * @param spareField2 the spareField2 to set
		 */
		public void setSpareField2(Object spareField2) {
			this.spareField2 = spareField2;
		}

		/**
		 * @return the subnumber
		 */
		public Long getSubnumber() {
			return subnumber;
		}

		/**
		 * @param subnumber the subnumber to set
		 */
		public void setSubnumber(Long subnumber) {
			this.subnumber = subnumber;
		}

	  
}
