package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.math.BigDecimal;

import com.deppon.foss.framework.entity.BaseEntity;
/**
 * 
 * 作者（修改人）：YangMing
 * 修改时间：2013-9-2 下午5:09:25
 * 描述：工程项目申请单分录：办公人员明细 实体
 * 更新记录：
 */
public class ProjectApplyEntryEntity extends BaseEntity {

	/**
	 * TODO（用一句话描述这个变量表示什么）
	 */
	private static final long serialVersionUID = -3546257451540505128L;
	
	private String fid;
	private String fseq;
	private String fparentID;
	private String cfuseDepartmentID;//使用部门名称ID
	private String cfuseDepartment;//使用部门名称
	private String cfdepartmentType;//部门性质
	private String cfstationID;//岗位ID
	private String cfstation;//岗位名称
	private BigDecimal cfnumberOfPeople;//现在人数
	private BigDecimal cfnewNumberPeople;//明年人数
	private BigDecimal peopleNumber;//后年人数
	private String cfremark;//备注
	private BigDecimal cfcurrentofficenum;//现状（办公卡位）
	private BigDecimal cfnextofficenum;//明年（办公卡位）
	private BigDecimal cfafternextoffnum;//后年（办公卡位）
	private BigDecimal cfwindownum;//办单窗口数
	private String fparentName;
	
	
	/****************************************新加字段为BigDecimal对应的转换**************************/
	private String cfnumberOfPeopleDto;//现在人数
	private String cfnewNumberPeopleDto;//明年人数
	private String peopleNumberDto;//后年人数
	private String cfcurrentofficenumDto;//现状（办公卡位）
	private String cfnextofficenumDto;//明年（办公卡位）
	private String cfafternextoffnumDto;//后年（办公卡位）
	private String cfwindownumDto;//办单窗口数
	
	
	
	/**
	 * 
	 * 描述： id
	 * @author yangming
	 * @date 2013-9-27 上午10:40:15
	 * @return
	 * 更新记录：
	 */
	public String getFid() {
		return fid;
	}
	/**
	 * 
	 * 描述： id
	 * @author yangming
	 * @date 2013-9-27 上午10:40:15
	 * @return
	 * 更新记录：
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}
	/**
	 * 
	 * 描述： 序号
	 * @author yangming
	 * @date 2013-9-27 上午10:40:31
	 * @return
	 * 更新记录：
	 */
	public String getFseq() {
		return fseq;
	}
	/**
	 * 
	 * 描述： 序号
	 * @author yangming
	 * @date 2013-9-27 上午10:40:31
	 * @return
	 * 更新记录：
	 */
	public void setFseq(String fseq) {
		this.fseq = fseq;
	}
	/**
	 * 
	 * 描述： 表头id
	 * @author yangming
	 * @date 2013-9-27 上午10:40:31
	 * @return
	 * 更新记录：
	 */
	public String getFparentID() {
		return fparentID;
	}
	/**
	 * 
	 * 描述： 表头id
	 * @author yangming
	 * @date 2013-9-27 上午10:40:31
	 * @return
	 * 更新记录：
	 */
	public void setFparentID(String fparentID) {
		this.fparentID = fparentID;
	}
	/**
	 * 
	 * 描述： 使用部门名称ID
	 * @author yangming
	 * @date 2013-9-27 上午10:41:09
	 * @return
	 * 更新记录：
	 */
	public String getCfuseDepartmentID() {
		return cfuseDepartmentID;
	}
	public void setCfuseDepartmentID(String cfuseDepartmentID) {
		this.cfuseDepartmentID = cfuseDepartmentID;
	}
	/**
	 * 
	 * 描述： 使用部门名称ID
	 * @author yangming
	 * @date 2013-9-27 上午10:41:09
	 * @return
	 * 更新记录：
	 */
	public String getCfuseDepartment() {
		return cfuseDepartment;
	}
	/**
	 * 
	 * 描述： 使用部门名称ID
	 * @author yangming
	 * @date 2013-9-27 上午10:41:22
	 * @param cfuseDepartment
	 * 更新记录：
	 */
	public void setCfuseDepartment(String cfuseDepartment) {
		this.cfuseDepartment = cfuseDepartment;
	}
	/**
	 * 
	 * 描述： 部门性质
	 * @author yangming
	 * @date 2013-9-27 上午10:41:31
	 * @return
	 * 更新记录：
	 */
	public String getCfdepartmentType() {
		return cfdepartmentType;
	}
	/**
	 * 
	 * 描述： 部门性质 setter
	 * @author yangming
	 * @date 2013-9-27 上午10:41:31
	 * @return
	 * 更新记录：
	 */
	public void setCfdepartmentType(String cfdepartmentType) {
		this.cfdepartmentType = cfdepartmentType;
	}
	/**
	 * 
	 * 描述： 岗位ID
	 * @author yangming
	 * @date 2013-9-27 上午10:41:50
	 * @return
	 * 更新记录：
	 */
	public String getCfstationID() {
		return cfstationID;
	}
	/**
	 * 
	 * 描述： 岗位ID
	 * @author yangming
	 * @date 2013-9-27 上午10:41:50
	 * @return
	 * 更新记录：
	 */
	public void setCfstationID(String cfstationID) {
		this.cfstationID = cfstationID;
	}
	/**
	 * 
	 * 描述： 岗位ID getter
	 * @author yangming
	 * @date 2013-9-27 上午10:41:50
	 * @return
	 * 更新记录：
	 */
	public String getCfstation() {
		return cfstation;
	}
	/**
	 * 
	 * 描述： 岗位名称
	 * @author yangming
	 * @date 2013-9-27 上午10:42:16
	 * @param cfstation
	 * 更新记录：
	 */
	public void setCfstation(String cfstation) {
		this.cfstation = cfstation;
	}
	/**
	 * 
	 * 描述： 现在人数
	 * @author yangming
	 * @date 2013-9-27 上午10:42:16
	 * @param cfstation
	 * 更新记录：
	 */
	public BigDecimal getCfnumberOfPeople() {
		return cfnumberOfPeople;
	}
	/**
	 * 
	 * 描述：  现在人数
	 * @author yangming
	 * @date 2013-9-27 上午10:42:38
	 * @param cfnumberOfPeople
	 * 更新记录：
	 */
	public void setCfnumberOfPeople(BigDecimal cfnumberOfPeople) {
		this.cfnumberOfPeople = cfnumberOfPeople;
	}
	/**
	 * 
	 * 描述： 明年人数
	 * @author yangming
	 * @date 2013-9-27 上午10:43:04
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfnewNumberPeople() {
		return cfnewNumberPeople;
	}
	/**
	 * 
	 * 描述： 明年人数 setter
	 * @author yangming
	 * @date 2013-9-27 上午10:43:04
	 * @return
	 * 更新记录：
	 */
	public void setCfnewNumberPeople(BigDecimal cfnewNumberPeople) {
		this.cfnewNumberPeople = cfnewNumberPeople;
	}
	/**
	 * 
	 * 描述： 后年人数
	 * @author yangming
	 * @date 2013-9-27 上午10:43:19
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getPeopleNumber() {
		return peopleNumber;
	}
	/**
	 * 
	 * 描述： 后年人数
	 * @author yangming
	 * @date 2013-9-27 上午10:43:19
	 * @return
	 * 更新记录：
	 */
	public void setPeopleNumber(BigDecimal peopleNumber) {
		this.peopleNumber = peopleNumber;
	}
	/**
	 * 
	 * 描述： 备注
	 * @author yangming
	 * @date 2013-9-27 上午10:43:19
	 * @return
	 * 更新记录：
	 */
	public String getCfremark() {
		return cfremark;
	}
	/**
	 * 
	 * 描述： 备注
	 * @author yangming
	 * @date 2013-9-27 上午10:43:19
	 * @return
	 * 更新记录：
	 */
	public void setCfremark(String cfremark) {
		this.cfremark = cfremark;
	}
	/**
	 * 
	 * 描述： 现状（办公卡位）
	 * @author yangming
	 * @date 2013-9-27 上午10:43:48
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfcurrentofficenum() {
		return cfcurrentofficenum;
	}
	/**
	 * 
	 * 描述： 现状（办公卡位） setter
	 * @author yangming
	 * @date 2013-9-27 上午10:43:48
	 * @return
	 * 更新记录：
	 */
	public void setCfcurrentofficenum(BigDecimal cfcurrentofficenum) {
		this.cfcurrentofficenum = cfcurrentofficenum;
	}
	/**
	 * 
	 * 描述： 明年（办公卡位）
	 * @author yangming
	 * @date 2013-9-27 上午10:44:04
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfnextofficenum() {
		return cfnextofficenum;
	}
	/**
	 * 
	 * 描述： 明年（办公卡位）
	 * @author yangming
	 * @date 2013-9-27 上午10:44:14
	 * @param cfnextofficenum
	 * 更新记录：
	 */
	public void setCfnextofficenum(BigDecimal cfnextofficenum) {
		this.cfnextofficenum = cfnextofficenum;
	}
	/**
	 * 
	 * 描述：后年（办公卡位） 
	 * @author yangming
	 * @date 2013-9-27 上午10:44:25
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfafternextoffnum() {
		return cfafternextoffnum;
	}
	/**
	 * 
	 * 描述： 后年（办公卡位）
	 * @author yangming
	 * @date 2013-9-27 上午10:44:35
	 * @param cfafternextoffnum
	 * 更新记录：
	 */
	public void setCfafternextoffnum(BigDecimal cfafternextoffnum) {
		this.cfafternextoffnum = cfafternextoffnum;
	}
	/**
	 * 
	 * 描述： 办单窗口数
	 * @author yangming
	 * @date 2013-9-27 上午10:44:48
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfwindownum() {
		return cfwindownum;
	}
	/**
	 * 
	 * 描述： 办单窗口数
	 * @author yangming
	 * @date 2013-9-27 上午10:44:57
	 * @param cfwindownum
	 * 更新记录：
	 */
	public void setCfwindownum(BigDecimal cfwindownum) {
		this.cfwindownum = cfwindownum;
	}
	/**
	 * 
	 * 描述： 
	 * @author yangming
	 * @date 2013-9-27 上午10:45:02
	 * @return
	 * 更新记录：
	 */
	public String getFparentName() {
		return fparentName;
	}
	public void setFparentName(String fparentName) {
		this.fparentName = fparentName;
	}
	public String getCfnumberOfPeopleDto() {
		return cfnumberOfPeopleDto;
	}
	public void setCfnumberOfPeopleDto(String cfnumberOfPeopleDto) {
		this.cfnumberOfPeopleDto = cfnumberOfPeopleDto;
	}
	public String getCfnewNumberPeopleDto() {
		return cfnewNumberPeopleDto;
	}
	public void setCfnewNumberPeopleDto(String cfnewNumberPeopleDto) {
		this.cfnewNumberPeopleDto = cfnewNumberPeopleDto;
	}
	public String getPeopleNumberDto() {
		return peopleNumberDto;
	}
	public void setPeopleNumberDto(String peopleNumberDto) {
		this.peopleNumberDto = peopleNumberDto;
	}
	public String getCfcurrentofficenumDto() {
		return cfcurrentofficenumDto;
	}
	public void setCfcurrentofficenumDto(String cfcurrentofficenumDto) {
		this.cfcurrentofficenumDto = cfcurrentofficenumDto;
	}
	public String getCfnextofficenumDto() {
		return cfnextofficenumDto;
	}
	public void setCfnextofficenumDto(String cfnextofficenumDto) {
		this.cfnextofficenumDto = cfnextofficenumDto;
	}
	public String getCfafternextoffnumDto() {
		return cfafternextoffnumDto;
	}
	public void setCfafternextoffnumDto(String cfafternextoffnumDto) {
		this.cfafternextoffnumDto = cfafternextoffnumDto;
	}
	public String getCfwindownumDto() {
		return cfwindownumDto;
	}
	public void setCfwindownumDto(String cfwindownumDto) {
		this.cfwindownumDto = cfwindownumDto;
	}
	
}
