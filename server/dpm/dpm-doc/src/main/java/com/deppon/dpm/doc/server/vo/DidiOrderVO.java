package com.deppon.dpm.doc.server.vo;

import java.io.Serializable;


public class DidiOrderVO implements Serializable  {

	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public DidiOrderVO(){
		super();
	}
    //pk
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
    private float totalPrice ;
    //部门
    private String dept ;
    //所属财务部
    private String financedept ;
    //预算完成比
    private String budgetratio ;
    //时间进度
    private String timeschedule ;
    private String remark ;
    private String remarkinfo ;
    private String company ;
    
    /**
     *  pk
     */
    public Integer getId() {
        return id ;
    }

    /**
     *  行程单号
     */
    public String getBillno() {
        return billno ;
    }

    /**
     *  姓名
     */
    public String getName() {
        return name ;
    }

    /**
     *  工号
     */
    public String getEmployeeno() {
        return employeeno ;
    }

    /**
     *  车型
     */
    public String getModels() {
        return models ;
    }

    /**
     *  出发地
     */
    public String getFromName() {
        return fromName ;
    }

    /**
     *  目的地
     */
    public String getToName() {
        return toName ;
    }

    /**
     *  打车日期
     */
    public String getTaxidate() {
        return taxidate ;
    }

    /**
     *  上车时间
     */
    public String getBoardingtime() {
        return boardingtime ;
    }

    /**
     *  下车时间
     */
    public String getOfftime() {
        return offtime ;
    }

    /**
     *  单号状态
     */
    public Integer getOrderstatus() {
        return orderstatus ;
    }

    /**
     *  打车总里程
     */
    public String getNormalDistance() {
        return normalDistance ;
    }

    /**
     *  费用
     */
    public float getTotalPrice() {
        return totalPrice ;
    }

    /**
     *  部门
     */
    public String getDept() {
        return dept ;
    }

    /**
     *  所属财务部
     */
    public String getFinancedept() {
        return financedept ;
    }

    /**
     *  预算完成比
     */
    public String getBudgetratio() {
        return budgetratio ;
    }

    /**
     *  时间进度
     */
    public String getTimeschedule() {
        return timeschedule ;
    }


    /**
     *  pk
     */
    public void setId(Integer id) {
        this.id = id ;
    }

    /**
     *  行程单号
     */
    public void setBillno(String billno) {
        this.billno = billno ;
    }

    /**
     *  姓名
     */
    public void setName(String name) {
        this.name = name ;
    }

    /**
     *  工号
     */
    public void setEmployeeno(String employeeno) {
        this.employeeno = employeeno ;
    }

    /**
     *  车型
     */
    public void setModels(String models) {
        this.models = models ;
    }

    /**
     *  出发地
     */
    public void setFromName(String fromName) {
        this.fromName = fromName ;
    }

    /**
     *  目的地
     */
    public void setToName(String toName) {
        this.toName = toName ;
    }

    /**
     *  打车日期
     */
    public void setTaxidate(String taxidate) {
        this.taxidate = taxidate ;
    }

    /**
     *  上车时间
     */
    public void setBoardingtime(String boardingtime) {
        this.boardingtime = boardingtime ;
    }

    /**
     *  下车时间
     */
    public void setOfftime(String offtime) {
        this.offtime = offtime ;
    }

    /**
     *  单号状态
     */
    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus ;
    }

    /**
     *  打车总里程
     */
    public void setNormalDistance(String normalDistance) {
        this.normalDistance = normalDistance ;
    }

    /**
     *  费用
     */
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice ;
    }

    /**
     *  部门
     */
    public void setDept(String dept) {
        this.dept = dept ;
    }

    /**
     *  所属财务部
     */
    public void setFinancedept(String financedept) {
        this.financedept = financedept ;
    }

    /**
     *  预算完成比
     */
    public void setBudgetratio(String budgetratio) {
        this.budgetratio = budgetratio ;
    }

    /**
     *  时间进度
     */
    public void setTimeschedule(String timeschedule) {
        this.timeschedule = timeschedule ;
    }

    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemarkinfo() {
		return remarkinfo;
	}

	public void setRemarkinfo(String remarkinfo) {
		this.remarkinfo = remarkinfo;
	}

	public Integer getSub_status() {
		return sub_status;
	}

	public void setSub_status(Integer sub_status) {
		this.sub_status = sub_status;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
    public String toString() {
        return " DidiOeder ["
            + " id=" + id 
            + ", billno=" + billno 
            + ", name=" + name 
            + ", employeeno=" + employeeno 
            + ", models=" + models 
            + ", fromName=" + fromName 
            + ", toName=" + toName 
            + ", taxidate=" + taxidate 
            + ", boardingtime=" + boardingtime 
            + ", offtime=" + offtime 
            + ", orderstatus=" + orderstatus 
            + ", sub_status=" + sub_status 
            + ", normalDistance=" + normalDistance 
            + ", totalPrice=" + totalPrice 
            + ", dept=" + dept 
            + ", financedept=" + financedept 
            + ", budgetratio=" + budgetratio 
            + ", timeschedule=" + timeschedule 
            + ", company=" + company 
            + ", remark=" + remark 
            + ", remarkinfo=" + remarkinfo 
            + "]" ;
    }

 
}
