package com.deppon.dpm.doc.server.entity;

import java.util.Date;

/**
 * 发单缓存Ticket(DIDI_TICKET) ��Ӧ��domain
 * @author guzf
 * 2017-11-24
 */

public class DidiTicketEntity  {

	/**
	 * 构造方法
	 */
	public DidiTicketEntity(){
		super();
	}
    //pk<id>
    private Integer id ;
    //滴滴订单id
    private String orderId ;
    
    private String ticket ;
    //工号
    private String userid ;
    //名称
    private String username ;
    //电话
    private String usertel ;
    //部门
    private String dept ;
    //所属财务部
    private String financedept ;
    private String company ;
    private String remark ;
    private String remarkinfo ;
    //是否处理标志
    private Integer flag ;
    //自定义信息1
    private String def1 ;
    //自定义信息2
    private String def2 ;
    //自定义信息3
    private String def3 ;
    //自定义信息4
    private String def4 ;
    //自定义信息5
    private String def5 ;
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
    private String phone;//电话
    //差旅工作流号
    private String travelWorkflowNo;
    //真实ip
    private String remoteAddr;
    //创建时间
    private Date createTime;
    
    /**
     * ���� pk<id>
     */
    public Integer getId() {
        return id ;
    }

    /**
     * ���� 滴滴订单id
     */
    public String getOrderId() {
        return orderId ;
    }

    /**
     * ���� 工号
     */
    public String getUserid() {
        return userid ;
    }

    /**
     * ���� 名称
     */
    public String getUsername() {
        return username ;
    }

    /**
     * ���� 电话
     */
    public String getUsertel() {
        return usertel ;
    }

    /**
     * ���� 部门
     */
    public String getDept() {
        return dept ;
    }

    /**
     * ���� 所属财务部
     */
    public String getFinancedept() {
        return financedept ;
    }

    /**
     * ���� 是否处理标志
     */
    public Integer getFlag() {
        return flag ;
    }

    /**
     * ���� 自定义信息1
     */
    public String getDef1() {
        return def1 ;
    }

    /**
     * ���� 自定义信息2
     */
    public String getDef2() {
        return def2 ;
    }

    /**
     * ���� 自定义信息3
     */
    public String getDef3() {
        return def3 ;
    }

    /**
     * ���� 自定义信息4
     */
    public String getDef4() {
        return def4 ;
    }

    /**
     * ���� 自定义信息5
     */
    public String getDef5() {
        return def5 ;
    }


    /**
     * ���� pk<id>
     */
    public void setId(Integer id) {
        this.id = id ;
    }

    /**
     * ���� 滴滴订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId ;
    }

    /**
     * ���� 工号
     */
    public void setUserid(String userid) {
        this.userid = userid ;
    }

    /**
     * ���� 名称
     */
    public void setUsername(String username) {
        this.username = username ;
    }

    /**
     * ���� 电话
     */
    public void setUsertel(String usertel) {
        this.usertel = usertel ;
    }

    /**
     * ���� 部门
     */
    public void setDept(String dept) {
        this.dept = dept ;
    }

    /**
     * ���� 所属财务部
     */
    public void setFinancedept(String financedept) {
        this.financedept = financedept ;
    }

    /**
     * ���� 是否处理标志
     */
    public void setFlag(Integer flag) {
        this.flag = flag ;
    }

    /**
     * ���� 自定义信息1
     */
    public void setDef1(String def1) {
        this.def1 = def1 ;
    }

    /**
     * ���� 自定义信息2
     */
    public void setDef2(String def2) {
        this.def2 = def2 ;
    }

    /**
     * ���� 自定义信息3
     */
    public void setDef3(String def3) {
        this.def3 = def3 ;
    }

    /**
     * ���� 自定义信息4
     */
    public void setDef4(String def4) {
        this.def4 = def4 ;
    }

    /**
     * ���� 自定义信息5
     */
    public void setDef5(String def5) {
        this.def5 = def5 ;
    }
    

    public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	@Override
    public String toString() {
        return " DidiTicket ["
            + " id=" + id 
            + ", orderId=" + orderId 
            + ", ticket=" + ticket 
            + ", userid=" + userid 
            + ", username=" + username 
            + ", usertel=" + usertel 
            + ", dept=" + dept 
            + ", financedept=" + financedept 
            + ", remark=" + remark 
            + ", remarkinfo=" + remarkinfo 
            + ", company=" + company 
            + ", flag=" + flag 
            + ", def1=" + def1 
            + ", def2=" + def2 
            + ", def3=" + def3 
            + ", def4=" + def4 
            + ", def5=" + def5 
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
            + "]" ;
    }

	public String getTravelWorkflowNo() {
		return travelWorkflowNo;
	}

	public void setTravelWorkflowNo(String travelWorkflowNo) {
		this.travelWorkflowNo = travelWorkflowNo;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
    
}