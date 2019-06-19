package com.deppon.dpm.doc.server.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
* @ClassName: QueryResponseBudgetEntity 
* @Description: TODO(预算查询返回参数) 
* @author 287306
* @date 2017-11-21 下午8:46:44 
*  
*/
public class QueryResponseBudgetEntity  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//部门名称（员工对应成本中心）
	private String deptName;
	//部门标杆编码
	private String deptCode;
	//员工工号
	private String empCode;
	//本部门今日产生金额
	private BigDecimal toDayAmount;
	//本部门本月产生金额
	private BigDecimal thisMonthAmount;
	//本部门余额
	private BigDecimal leftAmount;
	//查询是否成功
    private String isSuccess;
    //失败原因
    private String failReason;
    //子公司名称
  	private String subCom;
  	//子公司编码
  	private String subComCode;  	
  	
    //月
  	private String month;
  	//日
  	private String day;
  	//时
  	private String hour;
  	//状态
  	private String status;
  	//预算剩余百分比
  	private BigDecimal percent;
  	//创建时间
  	private Date createtime;
    
    /**
	 * 构造方法
	 */
	public QueryResponseBudgetEntity(){
		super();
	}
    
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public BigDecimal getToDayAmount() {
		return toDayAmount;
	}
	public void setToDayAmount(BigDecimal toDayAmount) {
		this.toDayAmount = toDayAmount;
	}
	public BigDecimal getThisMonthAmount() {
		return thisMonthAmount;
	}
	public void setThisMonthAmount(BigDecimal thisMonthAmount) {
		this.thisMonthAmount = thisMonthAmount;
	}
	public BigDecimal getLeftAmount() {
		return leftAmount;
	}
	public void setLeftAmount(BigDecimal leftAmount) {
		this.leftAmount = leftAmount;
	}
	public String getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getFailReason() {
		return failReason;
	}
	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	public String getSubCom() {
		return subCom;
	}

	public void setSubCom(String subCom) {
		this.subCom = subCom;
	}

	public String getSubComCode() {
		return subComCode;
	}

	public void setSubComCode(String subComCode) {
		this.subComCode = subComCode;
	}
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getPercent() {
		return percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	

}
