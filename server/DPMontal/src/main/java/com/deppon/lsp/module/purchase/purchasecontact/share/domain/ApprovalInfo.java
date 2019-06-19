package com.deppon.lsp.module.purchase.purchasecontact.share.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
   * @ClassName: ApprovalInfo 
   * @Description:TODO(流程动态实体 审批信息实体) 
   * @author 何玲菠 
   * @date 2013-11-7 下午2:34:07 
   *
 */
public class ApprovalInfo implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	// 审批单号
	private String approveno;
	// 申请单号
	private String applyno;
	// 审批人姓名
	private String approver;
	// 审批时间
	private Date approvedate;
	// 审批意见
	private String approvever;
	// 审批结果
	private String isagree;
	// 流程实例ID
	private long processinstid;
	// 工号
	private String userid;
	// 工作项ID
	private long workitemid;
	// 业务编号
	private String busino;
	// 当前活动定义ID
	private String currentactivitydefid;
	// 当前活动定义名称
	private String currentactivitydefname;
	// 下一节点活动定义id
	private String nextactivitydefid;
	// 下一节点活动定义名称
	private String nextactivitydefname;
	// 是否有效（0：失效；1.有效）
	private String iseffective;
	//开始时间
	private Date starttime;

	/**
	 * 
	*  获取工作项开始时间
	* @author：lihai
	* @date： 2013-5-6 下午04:18:37
	* @return Date
	 */
	public Date getStarttime() {
		return starttime;
	}
	
	/**
	 * 
	* 设置工作项开始时间
	* @author：lihai
	* @date： 2013-5-6 下午04:18:58
	* @param startTime void
	 */
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	/**
	 * 
	*  获取审批单号
	* @author：lihai
	* @date： 2013-5-6 上午10:27:52
	* @return String
	 */
	public String getApproveno() {
		return approveno;
	}

	/**
	 * 
	* 设置审批单号
	* @author：lihai
	* @date： 2013-5-6 上午10:28:36
	* @param approveno void
	 */
	public void setApproveno(String approveno) {
		this.approveno = approveno;
	}

	/**
	 * 
	* 获取申请单号
	* @author：lihai
	* @date： 2013-5-6 上午10:28:51
	* @return String
	 */
	public String getApplyno() {
		return applyno;
	}

	/**
	 * 
	* 设置申请单号
	* @author：lihai
	* @date： 2013-5-6 上午10:29:07
	* @param applyno void
	 */
	public void setApplyno(String applyno) {
		this.applyno = applyno;
	}

	/**
	 * 
	* 获取审批人姓名
	* @author：lihai
	* @date： 2013-5-6 上午10:29:32
	* @return String
	 */
	public String getApprover() {
		return approver;
	}

	/**
	 * 
	* 设置审批人姓名
	* @author：lihai
	* @date： 2013-5-6 上午10:30:03
	* @param approver void
	 */
	public void setApprover(String approver) {
		this.approver = approver;
	}

	/**
	 * 
	* 获取审批日期
	* @author：lihai
	* @date： 2013-5-6 上午10:30:14
	* @return Date
	 */
	public Date getApprovedate() {
		return approvedate;
	}

	/**
	 * 
	* 设置审批日期
	* @author：lihai
	* @date： 2013-5-6 上午10:30:43
	* @param approvedate void
	 */
	public void setApprovedate(Date approvedate) {
		this.approvedate = approvedate;
	}

	/**
	 * 
	* 获取审批意见
	* @author：lihai
	* @date： 2013-5-6 上午10:31:19
	* @return String
	 */
	public String getApprovever() {
		return approvever;
	}

	/**
	 * 
	* 设置审批意见
	* @author：lihai
	* @date： 2013-5-6 上午10:32:51
	* @param approvever void
	 */
	public void setApprovever(String approvever) {
		this.approvever = approvever;
	}

	/**
	 * 
	* 获取审批结果
	* @author：lihai
	* @date： 2013-5-6 上午10:33:01
	* @return String
	 */
	public String getIsagree() {
		return isagree;
	}

	/**
	 * 
	* 设置审批结果
	* @author：lihai
	* @date： 2013-5-6 上午10:33:24
	* @param isagree void
	 */
	public void setIsagree(String isagree) {
		this.isagree = isagree;
	}

	/**
	 * 
	* 获取流程实例ID
	* @author：lihai
	* @date： 2013-5-6 上午10:33:42
	* @return long
	 */
	public long getProcessinstid() {
		return processinstid;
	}

	/**
	 * 
	* 设置流程实例ID
	* @author：lihai
	* @date： 2013-5-6 上午10:34:08
	* @param processinstid void
	 */
	public void setProcessinstid(long processinstid) {
		this.processinstid = processinstid;
	}

	/**
	 * 
	* 获取审批人工号
	* @author：lihai
	* @date： 2013-5-6 上午10:34:26
	* @return String
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 
	* 设置审批人工号
	* @author：lihai
	* @date： 2013-5-6 上午10:34:56
	* @param userid void
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 
	* 获取工作项ID
	* @author：lihai
	* @date： 2013-5-6 上午10:35:37
	* @return long
	 */
	public long getWorkitemid() {
		return workitemid;
	}

	
	/**
	 * 
	* 设置工作项ID
	* @author：lihai
	* @date： 2013-5-6 上午10:36:06
	* @param workitemid void
	 */
	public void setWorkitemid(long workitemid) {
		this.workitemid = workitemid;
	}

	/**
	 * 
	* 获取业务编号
	* @author：lihai
	* @date： 2013-5-6 上午10:36:25
	* @return String
	 */
	public String getBusino() {
		return busino;
	}

	/**
	 * 
	* 设置业务编号
	* @author：lihai
	* @date： 2013-5-6 上午10:36:49
	* @param busino void
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}

	/**
	 * 
	* 获取当前活动定义ID
	* @author：lihai
	* @date： 2013-5-6 上午10:37:04
	* @return String
	 */
	public String getCurrentactivitydefid() {
		return currentactivitydefid;
	}

	/**
	 * 
	* 设置当前活动定义ID
	* @author：lihai
	* @date： 2013-5-6 上午10:37:35
	* @param currentactivitydefid void
	 */
	public void setCurrentactivitydefid(String currentactivitydefid) {
		this.currentactivitydefid = currentactivitydefid;
	}

	/**
	 * 
	* 获取当前活动定义名称
	* @author：lihai
	* @date： 2013-5-6 上午10:37:59
	* @return String
	 */
	public String getCurrentactivitydefname() {
		return currentactivitydefname;
	}

	/**
	 * 
	* 设置当前活动定义名称
	* @author：lihai
	* @date： 2013-5-6 上午10:38:26
	* @param currentactivitydefname void
	 */
	public void setCurrentactivitydefname(String currentactivitydefname) {
		this.currentactivitydefname = currentactivitydefname;
	}

	/**
	 * 
	* 获取下一活动定义ID
	* @author：lihai
	* @date： 2013-5-6 上午10:39:27
	* @return String
	 */
	public String getNextactivitydefid() {
		return nextactivitydefid;
	}

	/**
	 * 
	* 设置下一活动定义ID
	* @author：lihai
	* @date： 2013-5-6 上午10:39:56
	* @param nextactivitydefid void
	 */
	public void setNextactivitydefid(String nextactivitydefid) {
		this.nextactivitydefid = nextactivitydefid;
	}

	/**
	 * 
	* 获取下一活动定义名称
	* @author：lihai
	* @date： 2013-5-6 上午10:40:31
	* @return String
	 */
	public String getNextactivitydefname() {
		return nextactivitydefname;
	}

	/**
	 * 
	* 设置下一个活动定义名称
	* @author：lihai
	* @date： 2013-5-6 上午10:45:18
	* @param nextactivitydefname void
	 */
	public void setNextactivitydefname(String nextactivitydefname) {
		this.nextactivitydefname = nextactivitydefname;
	}

	/**
	 * 
	* 获取是否有效
	* @author：lihai
	* @date： 2013-5-6 上午10:46:36
	* @return String
	 */
	public String getIseffective() {
		return iseffective;
	}

	/**
	 * 
	* 设置是否有效（0：失效；1.有效）
	* @author：lihai
	* @date： 2013-5-6 上午10:47:07
	* @param iseffective void
	 */
	public void setIseffective(String iseffective) {
		this.iseffective = iseffective;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null) 
			return false;
		if (! (obj instanceof ApprovalInfo)) 
			return false;
		ApprovalInfo o = (ApprovalInfo) obj;
		return this.approveno.equals(o.approveno); 
	}
	@Override
	public int hashCode() {
		return approveno.hashCode();
	}
	public String toString() {
		return "{approveno:"+ this.approveno +
				"applyno:"+ this.applyno+
				"approver:"+this.approver+"approvedate: "+ this.approvedate+
				"approvever:"+this.approvever+
				"isagree:"+this.isagree+
				"processinstid:"+this.processinstid+
				"userid"+this.userid+
				"workitemid:"+this.workitemid+
				"busino:"+this.busino+
				"currentactivitydefid:"+this.currentactivitydefid+
				"nextactivitydefname:"+this.nextactivitydefname+
				"nextactivitydefid:"+this.nextactivitydefid+
				"iseffective:"+this.iseffective+
				"starttime:"+this.starttime+"}";
	}
}
