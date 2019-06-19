package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.montal.util.FormatUtil;

/**
 * 工程项目立项单-项目交付范围实体类
 * @author 李清松
 * @date 2013-9-3 下午5:17:49
 * @since
 * @version
 */
public class ProjectApprovalEntryEntity extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5571830350159335494L;
	
	//父单据ID
	private String parentId;
	//交付项
	private String deliveryitem;
	//接受方部门
	private String orgName;
	//预计交付日期
	private Date estideliverydate;
	//备注
	private String noteen;
	
	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * @return the deliveryitem
	 */
	public String getDeliveryitem() {
		if (deliveryitem == null) {
			deliveryitem = "";
		}
		return deliveryitem;
	}
	/**
	 * @param deliveryitem the deliveryitem to set
	 */
	public void setDeliveryitem(String deliveryitem) {
		this.deliveryitem = deliveryitem;
	}
	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		if (orgName == null) {
			orgName = "";
		}
		return orgName;
	}
	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * @return the estideliverydate
	 */
	public Date getEstideliverydate() {
		return estideliverydate;
	}
	public String getEstideliverydateStr() {
		return FormatUtil.formatDate(estideliverydate,"yyyy-MM-dd");
	}
	/**
	 * @param estideliverydate the estideliverydate to set
	 */
	public void setEstideliverydate(Date estideliverydate) {
		this.estideliverydate = estideliverydate;
	}
	/**
	 * @return the noteen
	 */
	public String getNoteen() {
		if (noteen == null) {
			noteen = "";
		}
		return noteen;
	}
	/**
	 * @param noteen the noteen to set
	 */
	public void setNoteen(String noteen) {
		this.noteen = noteen;
	}
}
