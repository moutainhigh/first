
    package com.deppon.montal.model; 

import java.math.BigDecimal;
   /** 
 * @Title: OaBudgetdataApply.java
 * @Package com.deppon.montal.model 
 * @Description: TODO(预算数据申请业务表) 
 * @author 何玲菠 
 * @date 2013-5-13 下午1:50:10 
 * @version V1.0 
 */
public class OaBudgetdataApply {
	private BigDecimal processinstid;
	private BigDecimal empid;
	private String name;
	private String budgetdyeay;
	private String budgetdquaeter;
	private String budgetorgcode;
	private String budgetorgname;
	private String whyapply;
	private String apptype;
	private String feetype;
	private String rate;
	public BigDecimal getProcessinstid() {
	
		return processinstid;
	}
	public void setProcessinstid(BigDecimal processinstid) {
	
		this.processinstid = processinstid;
	}
	public BigDecimal getEmpid() {
	
		return empid;
	}
	public void setEmpid(BigDecimal empid) {
	
		this.empid = empid;
	}
	public String getName() {
	
		return name;
	}
	public void setName(String name) {
	
		this.name = name;
	}
	public String getBudgetdyeay() {
	
		return budgetdyeay;
	}
	public void setBudgetdyeay(String budgetdyeay) {
	
		this.budgetdyeay = budgetdyeay;
	}
	public String getBudgetdquaeter() {
	
		return budgetdquaeter;
	}
	public void setBudgetdquaeter(String budgetdquaeter) {
	
		this.budgetdquaeter = budgetdquaeter;
	}
	public String getBudgetorgcode() {
	
		return budgetorgcode;
	}
	public void setBudgetorgcode(String budgetorgcode) {
	
		this.budgetorgcode = budgetorgcode;
	}
	public String getBudgetorgname() {
	
		return budgetorgname;
	}
	public void setBudgetorgname(String budgetorgname) {
	
		this.budgetorgname = budgetorgname;
	}
	public String getWhyapply() {
	
		return whyapply;
	}
	public void setWhyapply(String whyapply) {
	
		this.whyapply = whyapply;
	}
	public String getApptype() {
	
		return apptype;
	}
	public void setApptype(String apptype) {
	
		this.apptype = apptype;
	}
	public String getFeetype() {
	
		return feetype;
	}
	public void setFeetype(String feetype) {
	
		this.feetype = feetype;
	}
	public String getRate() {
	
		return rate;
	}
	public void setRate(String rate) {
	
		this.rate = rate;
	}
	
}

