package com.deppon.dpm.doc.server.entity;

import java.io.Serializable;
import java.math.BigDecimal;


public class DDOrderRequestEntity implements Serializable  {


    /**
	 * 
	 */
	private static final long serialVersionUID = 6371771896899613820L;
	private Integer id ;
    //行程单号
    private String billno ;
    //姓名
    private String name ;
    //工号
    private String employeeno ;
    //车型
    private String models ;
    //出发地
    private String fromName ;
    //目的地
    private String toName ;
    //打车日期
    private String taxidate ;
    //上车时间
    private String boardingtime ;
    //下车时间
    private String offtime ;
    //单号状态
    private Integer orderstatus ;
    //订单详细状态码
    private Integer sub_status ;
    //打车总里程
    private String normalDistance ;
    //费用
    private BigDecimal totalPrice ;
    //部门
    private String dept ;
    //所属财务部
    private String financedept ;
    //预计金额
    private BigDecimal estimateAmount;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmployeeno() {
		return employeeno;
	}
	public void setEmployeeno(String employeeno) {
		this.employeeno = employeeno;
	}
	public String getModels() {
		return models;
	}
	public void setModels(String models) {
		this.models = models;
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
	public String getTaxidate() {
		return taxidate;
	}
	public void setTaxidate(String taxidate) {
		this.taxidate = taxidate;
	}
	public String getBoardingtime() {
		return boardingtime;
	}
	public void setBoardingtime(String boardingtime) {
		this.boardingtime = boardingtime;
	}
	public String getOfftime() {
		return offtime;
	}
	public void setOfftime(String offtime) {
		this.offtime = offtime;
	}
	public Integer getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(Integer orderstatus) {
		this.orderstatus = orderstatus;
	}
	public Integer getSub_status() {
		return sub_status;
	}
	public void setSub_status(Integer sub_status) {
		this.sub_status = sub_status;
	}
	public String getNormalDistance() {
		return normalDistance;
	}
	public void setNormalDistance(String normalDistance) {
		this.normalDistance = normalDistance;
	}

	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getFinancedept() {
		return financedept;
	}
	public void setFinancedept(String financedept) {
		this.financedept = financedept;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public BigDecimal getEstimateAmount() {
		return estimateAmount;
	}
	public void setEstimateAmount(BigDecimal estimateAmount) {
		this.estimateAmount = estimateAmount;
	}

    


}
