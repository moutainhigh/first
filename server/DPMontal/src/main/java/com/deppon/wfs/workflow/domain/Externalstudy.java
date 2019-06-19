package com.deppon.wfs.workflow.domain;

import java.math.BigDecimal;
import java.util.Date;


/**
* @title: Externalstudy 
* @description：外训申请
* @author： 赵慧
* @date： 2013-10-23 下午10:34:57
*/

public class Externalstudy extends Entity{
    /**
     * id
     */
	
    private String busino;

    /**
     * 工作流号
     */
    private Long processinstid;

    /**
     * 申请人
     */
    private String applyPersonName;

    /**
     *申请人工号
     */
    private String applyPersonId;
    
    /**
     * 申请人部门
     */
    private String applyDepartment;
    
    /**
     * 申请人部门标杆编码
     * */
    private String applyDepartmentFinasyscode;

    /**
     * 参与者
     */
    private String participator;

    /**
     * 课程费用
     */
    private BigDecimal coursePrice;

    /**
     * 所属人事部
     */
    private String belongPersonnelDepartment;

    /**
     * 所属人事部标杆编码
     */
    private String personnelFinasyscode;

    /**
     * 培训地点
     */
    private String courseAddress;

    /**
     * 举办机构
     */
    private String organization;

    /**
     * 是否备案
     */
    private String ifRecord;

    /**
     * 申请事由
     */
    private String applyReason;

    /**
     * 创建时间
     */
    private Date creatTime;

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
    private BigDecimal reserveOne;

    /**
     * 备用字段2
     */
    private String reserveTwo;

    /**
     * 备用字段3
     */
    private String reserveThree;
    
    /**
    * @MethodName: getBusino 
    * @description : id
    * @author：赵慧 
    * @date： 2013-10-23 下午10:25:34
    * @return String
    */
    public String getBusino() {
        return busino;
    }

    /**
    * @MethodName: setBusino 
    * @description : id
    * @author：赵慧 
    * @date： 2013-10-23 下午10:25:47
    * @param busino void
    */
    public void setBusino(String busino) {
        this.busino = busino;
    }

    /**
    * @MethodName: getProcessinstid 
    * @description : 工作流号
    * @author：赵慧 
    * @date： 2013-10-23 下午10:25:51
    * @return BigDecimal
    */
    public Long getProcessinstid() {
        return processinstid;
    }

    /**
    * @MethodName: setProcessinstid 
    * @description : 工作流号
    * @author：赵慧 
    * @date： 2013-10-23 下午10:25:58
    * @param processinstid void
    */
    public void setProcessinstid(Long processinstid) {
        this.processinstid = processinstid;
    }

    /**
    * @MethodName: getApplyPersonName 
    * @description : 申请人
    * @author：赵慧 
    * @date： 2013-10-23 下午10:26:05
    * @return String
    */
    public String getApplyPersonName() {
        return applyPersonName;
    }

    /**
    * @MethodName: setApplyPersonName 
    * @description : 申请人
    * @author：赵慧 
    * @date： 2013-10-23 下午10:26:12
    * @param applyPersonName void
    */
    public void setApplyPersonName(String applyPersonName) {
        this.applyPersonName = applyPersonName;
    }

    /**
    * @MethodName: getApplyPersonId 
    * @description : 申请人工号
    * @author：赵慧 
    * @date： 2013-10-23 下午10:26:20
    * @return String
    */
    public String getApplyPersonId() {
        return applyPersonId;
    }

    /**
    * @MethodName: setApplyPersonId 
    * @description : 申请人工号
    * @author：赵慧 
    * @date： 2013-10-23 下午10:26:26
    * @param applyPersonId void
    */
    public void setApplyPersonId(String applyPersonId) {
        this.applyPersonId = applyPersonId;
    }
    
    /**
    * @MethodName: getParticipator 
    * @description : 参与者
    * @author：赵慧 
    * @date： 2013-10-23 下午10:26:32
    * @return String
    */
    public String getParticipator() {
        return participator;
    }

    /**
    * @MethodName: setParticipator 
    * @description : 参与者
    * @author：赵慧 
    * @date： 2013-10-23 下午10:26:40
    * @param participator void
    */
    public void setParticipator(String participator) {
        this.participator = participator;
    }

    /**
    * @MethodName: getCoursePrice 
    * @description : 课程费用
    * @author：赵慧 
    * @date： 2013-10-23 下午10:26:47
    * @return BigDecimal
    */
    public BigDecimal getCoursePrice() {
        return coursePrice;
    }

    /**
    * @MethodName: setCoursePrice 
    * @description : 课程费用
    * @author：赵慧 
    * @date： 2013-10-23 下午10:26:54
    * @param coursePrice void
    */
    public void setCoursePrice(BigDecimal coursePrice) {
        this.coursePrice = coursePrice;
    }

    /**
    * @MethodName: getCourseAddress 
    * @description : 培训地点
    * @author：赵慧 
    * @date： 2013-10-23 下午10:27:25
    * @return String
    */
    public String getCourseAddress() {
        return courseAddress;
    }

    /**
    * @MethodName: setCourseAddress 
    * @description : 培训地点
    * @author：赵慧 
    * @date： 2013-10-23 下午10:27:31
    * @param courseAddress void
    */
    public void setCourseAddress(String courseAddress) {
        this.courseAddress = courseAddress;
    }

    /**
    * @MethodName: getOrganization 
    * @description : 举办机构
    * @author：赵慧 
    * @date： 2013-10-23 下午10:27:36
    * @return String
    */
    public String getOrganization() {
        return organization;
    }

    /**
    * @MethodName: setOrganization 
    * @description : 举办机构
    * @author：赵慧 
    * @date： 2013-10-23 下午10:27:43
    * @param organization void
    */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
    * @MethodName: getIfRecord 
    * @description : 是否备案
    * @author：赵慧 
    * @date： 2013-10-23 下午10:27:48
    * @return String
    */
    public String getIfRecord() {
        return ifRecord;
    }

    /**
    * @MethodName: setIfRecord 
    * @description : 是否备案
    * @author：赵慧 
    * @date： 2013-10-23 下午10:27:54
    * @param ifRecord void
    */
    public void setIfRecord(String ifRecord) {
        this.ifRecord = ifRecord;
    }

    /**
    * @MethodName: getApplyReason 
    * @description : 申请事由
    * @author：赵慧 
    * @date： 2013-10-23 下午10:27:59
    * @return String
    */
    public String getApplyReason() {
        return applyReason;
    }

    /**
    * @MethodName: setApplyReason 
    * @description : 申请事由
    * @author：赵慧 
    * @date： 2013-10-23 下午10:28:04
    * @param applyReason void
    */
    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    /**
    * @MethodName: getCreatTime 
    * @description : 创建时间
    * @author：赵慧 
    * @date： 2013-10-23 下午10:28:10
    * @return Date
    */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
    * @MethodName: setCreatTime 
    * @description : 创建时间
    * @author：赵慧 
    * @date： 2013-10-23 下午10:28:16
    * @param creatTime void
    */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    /**
    * @MethodName: getModifyTime 
    * @description : 修改时间
    * @author：赵慧 
    * @date： 2013-10-23 下午10:28:22
    * @return Date
    */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
    * @MethodName: setModifyTime 
    * @description : 修改时间
    * @author：赵慧 
    * @date： 2013-10-23 下午10:28:27
    * @param modifyTime void
    */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
    * @MethodName: getIsseffective 
    * @description : 业务状态
    * @author：赵慧 
    * @date： 2013-10-23 下午10:28:34
    * @return String
    */
    public String getIsseffective() {
        return isseffective;
    }

    /**
    * @MethodName: setIsseffective 
    * @description : 业务状态
    * @author：赵慧 
    * @date： 2013-10-23 下午10:28:40
    * @param isseffective void
    */
    public void setIsseffective(String isseffective) {
        this.isseffective = isseffective;
    }

    /**
    * @MethodName: getReserveOne 
    * @description : 备用字段1
    * @author：赵慧 
    * @date： 2013-10-23 下午10:28:53
    * @return BigDecimal
    */
    public BigDecimal getReserveOne() {
        return reserveOne;
    }

    /**
    * @MethodName: setReserveOne 
    * @description : 备用字段1
    * @author：赵慧 
    * @date： 2013-10-23 下午10:29:03
    * @param reserveOne void
    */
    public void setReserveOne(BigDecimal reserveOne) {
        this.reserveOne = reserveOne;
    }

    /**
    * @MethodName: getReserveTwo 
    * @description : 备用字段2
    * @author：赵慧 
    * @date： 2013-10-23 下午10:29:10
    * @return String
    */
    public String getReserveTwo() {
        return reserveTwo;
    }

    /**
    * @MethodName: setReserveTwo 
    * @description : 备用字段2
    * @author：赵慧 
    * @date： 2013-10-23 下午10:29:15
    * @param reserveTwo void
    */
    public void setReserveTwo(String reserveTwo) {
        this.reserveTwo = reserveTwo;
    }

    /**
    * @MethodName: getReserveThree 
    * @description : 备用字段3
    * @author：赵慧 
    * @date： 2013-10-23 下午10:29:21
    * @return String
    */
    public String getReserveThree() {
        return reserveThree;
    }

    /**
    * @MethodName: setReserveThree 
    * @description : 备用字段3
    * @author：赵慧 
    * @date： 2013-10-23 下午10:29:28
    * @param reserveThree void
    */
    public void setReserveThree(String reserveThree) {
        this.reserveThree = reserveThree;
    }
	/**
	* @MethodName: getApplyDepartment 
	* @description : 申请人部门
	* @author：赵慧 
	* @date： 2013-10-24 上午09:50:41
	* @return String
	*/
	public String getApplyDepartment() {
		return applyDepartment;
	}
	/**
	* @MethodName: setApplyDepartment 
	* @description : 申请人部门
	* @author：赵慧 
	* @date： 2013-10-24 上午09:50:45
	* @param applyDepartment void
	*/
	public void setApplyDepartment(String applyDepartment) {
		this.applyDepartment = applyDepartment;
	}

	/**
	* @MethodName: getBelongPersonnelDepartment 
	* @description : 所属人事部
	* @author：赵慧 
	* @date： 2013-10-24 上午10:51:26
	* @return String
	*/
	public String getBelongPersonnelDepartment() {
		return belongPersonnelDepartment;
	}

	/**
	* @MethodName: setBelongPersonnelDepartment 
	* @description : 所属人事部
	* @author：赵慧 
	* @date： 2013-10-24 上午10:51:33
	* @param belongPersonnelDepartment void
	*/
	public void setBelongPersonnelDepartment(String belongPersonnelDepartment) {
		this.belongPersonnelDepartment = belongPersonnelDepartment;
	}

	/**
	* @MethodName: getPersonnelFinasyscode 
	* @description : 所属人事部标杆编码
	* @author：赵慧 
	* @date： 2013-10-24 上午10:51:39
	* @return String
	*/
	public String getPersonnelFinasyscode() {
		return personnelFinasyscode;
	}

	/**
	* @MethodName: setPersonnelFinasyscode 
	* @description : 所属人事部标杆编码
	* @author：赵慧 
	* @date： 2013-10-24 上午10:51:44
	* @param personnelFinasyscode void
	*/
	public void setPersonnelFinasyscode(String personnelFinasyscode) {
		this.personnelFinasyscode = personnelFinasyscode;
	}

	/**
	* @MethodName: getApplyDepartmentFinasyscode 
	* @description : 申请人部门标杆编码
	* @author：赵慧 
	* @date： 2013-10-24 下午12:49:35
	* @return String
	*/
	public String getApplyDepartmentFinasyscode() {
		return applyDepartmentFinasyscode;
	}

	/**
	* @MethodName: setApplyDepartmentFinasyscode 
	* @description : 申请人部门标杆编码
	* @author：赵慧 
	* @date： 2013-10-24 下午12:49:38
	* @param applyDepartmentFinasyscode void
	*/
	public void setApplyDepartmentFinasyscode(String applyDepartmentFinasyscode) {
		this.applyDepartmentFinasyscode = applyDepartmentFinasyscode;
	}
}