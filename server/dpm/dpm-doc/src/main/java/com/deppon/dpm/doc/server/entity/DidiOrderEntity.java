package com.deppon.dpm.doc.server.entity;


public class DidiOrderEntity {

	/**
	 * 构造方法
	 */
	public DidiOrderEntity(){
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
    //预估价
    private float estimateprice ;
    //客户名称：
    private String customname ;
  //银行卡号：
    private String bankcardnum ;
  //客户手机号：
    private String customtel ;
  //客户编码：
    private String customcode ;
  // 日程会议名称：
    private String meetingname ;
  //出发部门负责人姓名：
    private String frommanagername ;
  //目的部门负责人姓名：
    private String tomanagername ;
  //  目的部门负责人工号：
    private String tomanagercode ;
  //出发部门负责人工号：
    private String frommanagercode ;
  //其他公务审核人工号：
    private String auditorcode ;
  //  其他公务审核人姓名：
    private String auditorname ;
//  用户头像：
    private String userheadpic ;
//  出发时间：
    private String departuretime ;
    //直属上级级别
    private String joblevel;
    //会议名称NEW
    private String newmeetingname;
    //开始时间NEW
    private String newmeetingstart;
    //结束时间NEW
    private String newmeetingend;
    //返款状态
    private String refundprice;
    //返款金额
    private String refundamount;
    //电话
    private String phone;
    
    //司机称呼
    private String driveName;
    //司机真实手机号
    private String driverPhoneReal;
    //司机车型
    private String driverCarType;
    //司机车牌
    private String driverCard;
    //司机星级
    private float driverLevel;
    //司机当前实时经度
    private float dlng;
    //司机当前实时维度
    private float dlat;
    //差旅工作流号
    private String travelWorkflowNo;
    //预估里程
    private String EstimateDistance;
    
   //是否拼车，0-不拼车，1-拼车
  	private int is_carpool;
  	
  	//是否拼车成功,0-未成功，1-成功
  	private int is_carpool_success;
    
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

	public float getEstimateprice() {
		return estimateprice;
	}

	public void setEstimateprice(float estimateprice) {
		this.estimateprice = estimateprice;
	}

	/**
	 * @return the customname
	 */
	public String getCustomname() {
		return customname;
	}

	/**
	 * @param customname the customname to set
	 */
	public void setCustomname(String customname) {
		this.customname = customname;
	}

	/**
	 * @return the bankcardnum
	 */
	public String getBankcardnum() {
		return bankcardnum;
	}

	/**
	 * @param bankcardnum the bankcardnum to set
	 */
	public void setBankcardnum(String bankcardnum) {
		this.bankcardnum = bankcardnum;
	}

	/**
	 * @return the customtel
	 */
	public String getCustomtel() {
		return customtel;
	}

	/**
	 * @param customtel the customtel to set
	 */
	public void setCustomtel(String customtel) {
		this.customtel = customtel;
	}

	/**
	 * @return the customcode
	 */
	public String getCustomcode() {
		return customcode;
	}

	/**
	 * @param customcode the customcode to set
	 */
	public void setCustomcode(String customcode) {
		this.customcode = customcode;
	}

	/**
	 * @return the meetingname
	 */
	public String getMeetingname() {
		return meetingname;
	}

	/**
	 * @param meetingname the meetingname to set
	 */
	public void setMeetingname(String meetingname) {
		this.meetingname = meetingname;
	}

	/**
	 * @return the frommanagername
	 */
	public String getFrommanagername() {
		return frommanagername;
	}

	/**
	 * @param frommanagername the frommanagername to set
	 */
	public void setFrommanagername(String frommanagername) {
		this.frommanagername = frommanagername;
	}

	/**
	 * @return the tomanagername
	 */
	public String getTomanagername() {
		return tomanagername;
	}

	/**
	 * @param tomanagername the tomanagername to set
	 */
	public void setTomanagername(String tomanagername) {
		this.tomanagername = tomanagername;
	}

	/**
	 * @return the tomanagercode
	 */
	public String getTomanagercode() {
		return tomanagercode;
	}

	/**
	 * @param tomanagercode the tomanagercode to set
	 */
	public void setTomanagercode(String tomanagercode) {
		this.tomanagercode = tomanagercode;
	}

	/**
	 * @return the frommanagercode
	 */
	public String getFrommanagercode() {
		return frommanagercode;
	}

	/**
	 * @param frommanagercode the frommanagercode to set
	 */
	public void setFrommanagercode(String frommanagercode) {
		this.frommanagercode = frommanagercode;
	}

	/**
	 * @return the auditorcode
	 */
	public String getAuditorcode() {
		return auditorcode;
	}

	/**
	 * @param auditorcode the auditorcode to set
	 */
	public void setAuditorcode(String auditorcode) {
		this.auditorcode = auditorcode;
	}

	/**
	 * @return the auditorname
	 */
	public String getAuditorname() {
		return auditorname;
	}

	/**
	 * @param auditorname the auditorname to set
	 */
	public void setAuditorname(String auditorname) {
		this.auditorname = auditorname;
	}

	/**
	 * @return the userheadpic
	 */
	public String getUserheadpic() {
		return userheadpic;
	}

	/**
	 * @param userheadpic the userheadpic to set
	 */
	public void setUserheadpic(String userheadpic) {
		this.userheadpic = userheadpic;
	}

	/**
	 * @return the departuretime
	 */
	public String getDeparturetime() {
		return departuretime;
	}

	/**
	 * @param departuretime the departuretime to set
	 */
	public void setDeparturetime(String departuretime) {
		this.departuretime = departuretime;
	}

	/**
	 * @return the joblevel
	 */
	public String getJoblevel() {
		return joblevel;
	}

	/**
	 * @param joblevel the joblevel to set
	 */
	public void setJoblevel(String joblevel) {
		this.joblevel = joblevel;
	}

	/**
	 * @return the newmeetingname
	 */
	public String getNewmeetingname() {
		return newmeetingname;
	}

	/**
	 * @return the newmeetingstart
	 */
	public String getNewmeetingstart() {
		return newmeetingstart;
	}

	/**
	 * @return the newmeetingend
	 */
	public String getNewmeetingend() {
		return newmeetingend;
	}

	/**
	 * @return the refundprice
	 */
	public String getRefundprice() {
		return refundprice;
	}

	/**
	 * @return the refundamount
	 */
	public String getRefundamount() {
		return refundamount;
	}

	/**
	 * @param newmeetingname the newmeetingname to set
	 */
	public void setNewmeetingname(String newmeetingname) {
		this.newmeetingname = newmeetingname;
	}

	/**
	 * @param newmeetingstart the newmeetingstart to set
	 */
	public void setNewmeetingstart(String newmeetingstart) {
		this.newmeetingstart = newmeetingstart;
	}

	/**
	 * @param newmeetingend the newmeetingend to set
	 */
	public void setNewmeetingend(String newmeetingend) {
		this.newmeetingend = newmeetingend;
	}

	/**
	 * @param refundprice the refundprice to set
	 */
	public void setRefundprice(String refundprice) {
		this.refundprice = refundprice;
	}

	/**
	 * @param refundamount the refundamount to set
	 */
	public void setRefundamount(String refundamount) {
		this.refundamount = refundamount;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

	public String getDriveName() {
		return driveName;
	}

	public void setDriveName(String driveName) {
		this.driveName = driveName;
	}

	public String getDriverPhoneReal() {
		return driverPhoneReal;
	}

	public void setDriverPhoneReal(String driverPhoneReal) {
		this.driverPhoneReal = driverPhoneReal;
	}

	public String getDriverCarType() {
		return driverCarType;
	}

	public void setDriverCarType(String driverCarType) {
		this.driverCarType = driverCarType;
	}

	public String getDriverCard() {
		return driverCard;
	}

	public void setDriverCard(String driverCard) {
		this.driverCard = driverCard;
	}

	public float getDriverLevel() {
		return driverLevel;
	}

	public void setDriverLevel(float driverLevel) {
		this.driverLevel = driverLevel;
	}

	public float getDlng() {
		return dlng;
	}

	public void setDlng(float dlng) {
		this.dlng = dlng;
	}

	public float getDlat() {
		return dlat;
	}

	public void setDlat(float dlat) {
		this.dlat = dlat;
	}
	

	public int getIs_carpool() {
		return is_carpool;
	}

	public void setIs_carpool(int is_carpool) {
		this.is_carpool = is_carpool;
	}

	public int getIs_carpool_success() {
		return is_carpool_success;
	}

	public void setIs_carpool_success(int is_carpool_success) {
		this.is_carpool_success = is_carpool_success;
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
            + ", estimateprice=" + estimateprice 
            + ", customname=" + customname 
            + ", bankcardnum=" + bankcardnum 
            + ", customtel=" + customtel 
            + ", customcode=" + customcode 
            + ", meetingname=" + meetingname 
            + ", frommanagername=" + frommanagername 
            + ", tomanagername=" + tomanagername 
            + ", tomanagercode=" + tomanagercode 
            + ", frommanagercode=" + frommanagercode 
            + ", auditorcode=" + auditorcode 
            + ", auditorname=" + auditorname 
            + ", userheadpic=" + userheadpic 
            + ", departuretime=" + departuretime 
            + ", joblevel=" + joblevel 
            + ", newmeetingname=" + newmeetingname 
            + ", newmeetingstart=" + newmeetingstart 
            + ", newmeetingend=" + newmeetingend 
            + ", refundprice=" + refundprice 
            + ", refundamount=" + refundamount 
            + ", phone=" + phone 
            + ", driveName=" + driveName 
            + ", driverPhoneReal=" + driverPhoneReal 
            + ", driverCarType=" + driverCarType 
            + ", driverCard=" + driverCard 
            + ", driverLevel=" + driverLevel 
            + ", dlng=" + dlng 
            + ", dlat=" + dlat 
            + "]" ;
    }

	public String getTravelWorkflowNo() {
		return travelWorkflowNo;
	}

	public void setTravelWorkflowNo(String travelWorkflowNo) {
		this.travelWorkflowNo = travelWorkflowNo;
	}

	public String getEstimateDistance() {
		return EstimateDistance;
	}

	public void setEstimateDistance(String estimateDistance) {
		EstimateDistance = estimateDistance;
	}


}
