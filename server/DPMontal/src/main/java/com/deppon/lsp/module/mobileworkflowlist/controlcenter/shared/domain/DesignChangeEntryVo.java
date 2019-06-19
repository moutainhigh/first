package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.montal.util.FormatUtil;

/**
 * 设计变更单分录明细Vo
 * @author jiafangyao
 *
 */
public class DesignChangeEntryVo extends BaseEntity {

	/**
	 * 标识
	 */
	private static final long serialVersionUID = 4291401661263946632L;
	/**
	 * 序号
	 */
	private Long seq;
	/**
	 * 分录id
	 */
	// private String id;
	/**
	 * 分录父ID
	 */
	private String parentId;
	/**
	 * 图纸名称
	 */
	private String drawingName;
	/**
	 * 设计日期
	 */
	private Date designDate;
	/**
	 * 设计负责人ID
	 */
	private String designResponsibl;

	/**
	 * 设计负责人名称
	 */
	private String designResponsiblName;
	/**
	 * 设计项目名称
	 */
	private String desProNameId;
	/**
	 * 设计项目名称
	 */
	private String desProName;
	/**
	 * 单位ID
	 */
	private String unitId;

	/**
	 * 单位名称
	 */
	private String unitName;
	/**
	 * 数量
	 */
	private Double amount;
	/**
	 * 占比
	 */
	private Double proportion;
	/**
	 * 备注
	 */
	private String note;

	public Long getSeq() {
		return seq;
	}
	public String getSeqStr() {
		if (seq == null) {
			return "";
		}
		return (seq + "");
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDrawingName() {
		if (drawingName == null) {
			drawingName = "";
		}
		return drawingName;
	}

	public void setDrawingName(String drawingName) {
		this.drawingName = drawingName;
	}

	public Date getDesignDate() {
		return designDate;
	}
	
	public String getDesignDateStr() {
		return FormatUtil.formatDate(designDate,"yyyy-MM-dd HH:mm:ss");
	}

	public void setDesignDate(Date designDate) {
		this.designDate = designDate;
	}

	public String getDesignResponsibl() {
		return designResponsibl;
	}

	public void setDesignResponsibl(String designResponsibl) {
		this.designResponsibl = designResponsibl;
	}

	public String getDesignResponsiblName() {
		if (designResponsiblName == null){
			designResponsiblName = "";
		}
		return designResponsiblName;
	}

	public void setDesignResponsiblName(String designResponsiblName) {
		this.designResponsiblName = designResponsiblName;
	}

	public String getDesProNameId() {
		return desProNameId;
	}

	public void setDesProNameId(String desProNameId) {
		this.desProNameId = desProNameId;
	}

	public String getDesProName() {
		if (desProName == null) {
			desProName = "";
		}
		return desProName;
	}

	public void setDesProName(String desProName) {
		this.desProName = desProName;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		if (unitName == null) {
			unitName = "";
		}
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Double getAmount() {
		return amount;
	}
	
	public String getAmountStr() {
		if (amount == null) {
			return  "";
		}
		return (amount + "");
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getProportion() {
		return proportion;
	}
	
	public String getProportionStr() {
		if (proportion == null) {
			return "";
		}
		return (proportion + "");
	}

	public void setProportion(Double proportion) {
		this.proportion = proportion;
	}

	public String getNote() {
		if (note == null) {
			note = "";
		}
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
