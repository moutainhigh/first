package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 移动办公评标申请单vo
 * @author 151266
 */
/**
 * @Description : 描述类的职责
 * @author : jianweiqiang
 * @date 2014-8-5 下午3:10:31
 * @since
 * @version v0.1
 */
public class JudgeApplyVo implements Serializable {

	private static final long serialVersionUID = -1291659576911021844L;
	private JudgeApplyEntity entity;
	private JudgeApplyEntryEntity[] entrys;
	private JudgeApplyRaterDetailEntryEntity[] detailEntrys;
	private JudgeApplyRaterRulesEntryEntity[] raterRuleEntrys;
	private JudgeApplyRaterScaleEntryEntity[] raterScaleEntrys;
	private JudgeApplySupplierEntryEntity[] supplierEntrys;

	/**
	 * @Description : 返回 entity属性的值
	 * @date 2014-8-5 下午3:13:05
	 */

	public JudgeApplyEntity getEntity() {
		return entity;
	}

	/**
	 * @param 设置属性
	 *            entity的值
	 */
	public void setEntity(JudgeApplyEntity entity) {
		this.entity = entity;
	}

	/**
	 * @Description : 返回 entrys属性的值
	 * @date 2014-8-5 下午3:13:05
	 */

	public JudgeApplyEntryEntity[] getEntrys() {
		return entrys;
	}

	/**
	 * @param 设置属性
	 *            entrys的值
	 */
	public void setEntrys(JudgeApplyEntryEntity[] entrys) {
		this.entrys = entrys;
	}

	/**
	 * @Description : 返回 detailEntrys属性的值
	 * @date 2014-8-5 下午3:13:05
	 */

	public JudgeApplyRaterDetailEntryEntity[] getDetailEntrys() {
		return detailEntrys;
	}

	/**
	 * @param 设置属性
	 *            detailEntrys的值
	 */
	public void setDetailEntrys(JudgeApplyRaterDetailEntryEntity[] detailEntrys) {
		this.detailEntrys = detailEntrys;
	}

	/**
	 * @Description : 返回 raterRuleEntrys属性的值
	 * @date 2014-8-5 下午3:13:05
	 */

	public JudgeApplyRaterRulesEntryEntity[] getRaterRuleEntrys() {
		return raterRuleEntrys;
	}

	/**
	 * @param 设置属性
	 *            raterRuleEntrys的值
	 */
	public void setRaterRuleEntrys(
			JudgeApplyRaterRulesEntryEntity[] raterRuleEntrys) {
		this.raterRuleEntrys = raterRuleEntrys;
	}

	/**
	 * @Description : 返回 raterScaleEntrys属性的值
	 * @date 2014-8-5 下午3:13:05
	 */

	public JudgeApplyRaterScaleEntryEntity[] getRaterScaleEntrys() {
		return raterScaleEntrys;
	}

	/**
	 * @param 设置属性
	 *            raterScaleEntrys的值
	 */
	public void setRaterScaleEntrys(
			JudgeApplyRaterScaleEntryEntity[] raterScaleEntrys) {
		this.raterScaleEntrys = raterScaleEntrys;
	}

	/**
	 * @Description : 返回 supplierEntrys属性的值
	 * @date 2014-8-5 下午3:13:05
	 */

	public JudgeApplySupplierEntryEntity[] getSupplierEntrys() {
		return supplierEntrys;
	}

	/**
	 * @param 设置属性
	 *            supplierEntrys的值
	 */
	public void setSupplierEntrys(JudgeApplySupplierEntryEntity[] supplierEntrys) {
		this.supplierEntrys = supplierEntrys;
	}

	/**
	 * 
	 * @Description : 覆盖toString
	 * @author : jianweiqiang
	 * @date 2014-8-5 下午3:14:15
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
