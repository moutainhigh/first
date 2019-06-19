package com.deppon.dpm.doc.server.entity;

public class DidiStatementEntity {
	private String id;							  //对账单号
	private String sameOrDifference;			  //异同订单
	private String offTime;						  //下车时间
	private String billno;						  //订单号
	private String fromName;					  //起始地
	private String toName;						  //目的地
	private String depponPrice;					  //德邦金额
	private String didiPrice;					  //滴滴金额
	private String difference;					  //差值
	private String lowerPrice;					  //两者取小
	private String company;						  //财务所属子公司
	private String applyEmpName;                  //申请人名称
    private String applyEmpCode;                  //申请人工号
    private String mcName;                        //工作流名称
    private String invoiceTitle;                  //发票抬头
    private String financialDept;                 //所属财务部
    private String accountName;                   //收款方名称
    private String contactInfo;                   //手机号码
    private String expenseIsOvertime;             //报销时效是否超时
    private String costExplain;                   //申请事由及说明
    private String accountNature;                 //账户性质
    private String bankName;                      //开户银行
    private String bankProvinceName;              //开户行省份名称
    private String bankCityName;                  //开户行城市名称
    private String subbankName;					  //开户支行名称
    private String account;						  //银行账号
    private String costCenterName;                //费用承担部门名称
    private String scName;                        //费用类型
    private String scNo;                          //费用类型编码
    private String actualAmount;                  //报账金额
    private String bizOccurDate;                  //业务发生日期
    private String itemCostExplain;               //费用说明
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSameOrDifference() {
		return sameOrDifference;
	}
	public void setSameOrDifference(String sameOrDifference) {
		this.sameOrDifference = sameOrDifference;
	}
	public String getOffTime() {
		return offTime;
	}
	public void setOffTime(String offTime) {
		this.offTime = offTime;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	public String getDepponPrice() {
		return depponPrice;
	}
	public void setDepponPrice(String depponPrice) {
		this.depponPrice = depponPrice;
	}
	public String getDidiPrice() {
		return didiPrice;
	}
	public void setDidiPrice(String didiPrice) {
		this.didiPrice = didiPrice;
	}
	public String getDifference() {
		return difference;
	}
	public void setDifference(String difference) {
		this.difference = difference;
	}
	public String getLowerPrice() {
		return lowerPrice;
	}
	public void setLowerPrice(String lowerPrice) {
		this.lowerPrice = lowerPrice;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getApplyEmpName() {
		return applyEmpName;
	}
	public void setApplyEmpName(String applyEmpName) {
		this.applyEmpName = applyEmpName;
	}
	public String getApplyEmpCode() {
		return applyEmpCode;
	}
	public void setApplyEmpCode(String applyEmpCode) {
		this.applyEmpCode = applyEmpCode;
	}
	public String getMcName() {
		return mcName;
	}
	public void setMcName(String mcName) {
		this.mcName = mcName;
	}
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	public String getFinancialDept() {
		return financialDept;
	}
	public void setFinancialDept(String financialDept) {
		this.financialDept = financialDept;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public String getExpenseIsOvertime() {
		return expenseIsOvertime;
	}
	public void setExpenseIsOvertime(String expenseIsOvertime) {
		this.expenseIsOvertime = expenseIsOvertime;
	}
	public String getCostExplain() {
		return costExplain;
	}
	public void setCostExplain(String costExplain) {
		this.costExplain = costExplain;
	}
	public String getAccountNature() {
		return accountNature;
	}
	public void setAccountNature(String accountNature) {
		this.accountNature = accountNature;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankProvinceName() {
		return bankProvinceName;
	}
	public void setBankProvinceName(String bankProvinceName) {
		this.bankProvinceName = bankProvinceName;
	}
	public String getBankCityName() {
		return bankCityName;
	}
	public void setBankCityName(String bankCityName) {
		this.bankCityName = bankCityName;
	}
	public String getSubbankName() {
		return subbankName;
	}
	public void setSubbankName(String subbankName) {
		this.subbankName = subbankName;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCostCenterName() {
		return costCenterName;
	}
	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}
	public String getScName() {
		return scName;
	}
	public void setScName(String scName) {
		this.scName = scName;
	}
	public String getScNo() {
		return scNo;
	}
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	public String getActualAmount() {
		return actualAmount;
	}
	public void setActualAmount(String actualAmount) {
		this.actualAmount = actualAmount;
	}
	public String getBizOccurDate() {
		return bizOccurDate;
	}
	public void setBizOccurDate(String bizOccurDate) {
		this.bizOccurDate = bizOccurDate;
	}
	public String getItemCostExplain() {
		return itemCostExplain;
	}
	public void setItemCostExplain(String itemCostExplain) {
		this.itemCostExplain = itemCostExplain;
	}
	@Override
	public String toString() {
		return "DidiStatementEntity [id=" + id + ", sameOrDifference="
				+ sameOrDifference + ", offTime=" + offTime + ", billno="
				+ billno + ", fromName=" + fromName + ", toName=" + toName
				+ ", depponPrice=" + depponPrice + ", didiPrice=" + didiPrice
				+ ", difference=" + difference + ", lowerPrice=" + lowerPrice
				+ ", company=" + company + ", applyEmpName=" + applyEmpName
				+ ", applyEmpCode=" + applyEmpCode + ", mcName=" + mcName
				+ ", invoiceTitle=" + invoiceTitle + ", financialDept="
				+ financialDept + ", accountName=" + accountName
				+ ", contactInfo=" + contactInfo + ", expenseIsOvertime="
				+ expenseIsOvertime + ", costExplain=" + costExplain
				+ ", accountNature=" + accountNature + ", bankName=" + bankName
				+ ", bankProvinceName=" + bankProvinceName + ", bankCityName="
				+ bankCityName + ", subbankName=" + subbankName + ", account="
				+ account + ", costCenterName=" + costCenterName + ", scName="
				+ scName + ", scNo=" + scNo + ", actualAmount=" + actualAmount
				+ ", bizOccurDate=" + bizOccurDate + ", itemCostExplain="
				+ itemCostExplain + "]";
	}
    
}
