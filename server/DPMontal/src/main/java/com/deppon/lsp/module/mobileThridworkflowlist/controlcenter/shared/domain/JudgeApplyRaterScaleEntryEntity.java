package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;


import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 *<pre>
 *
 * 描述：评标申请单-评委比例规则分录
 * @author 李清松
 * @date 2014-2-20 上午午10:17:49
 * @since
 * @version
 *    
 *</pre>
 *
 */
public class JudgeApplyRaterScaleEntryEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6587601848435975859L;
	//fid
    private String fid;
    //父类ID
    private String fparentid;
    //评委类别
    private String cfjudgestype;
    //数量
    private Long cfjudgesamount;
	/**
	 * @return the fid
	 */
	public String getFid() {
		return fid;
	}
	/**
	 * @param fid the fid to set
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}
	/**
	 * @return the fparentid
	 */
	public String getFparentid() {
		return fparentid;
	}
	/**
	 * @param fparentid the fparentid to set
	 */
	public void setFparentid(String fparentid) {
		this.fparentid = fparentid;
	}
	/**
	 * @return the cfjudgestype
	 */
	public String getCfjudgestype() {
		return cfjudgestype;
	}
	/**
	 * @param cfjudgestype the cfjudgestype to set
	 */
	public void setCfjudgestype(String cfjudgestype) {
		this.cfjudgestype = cfjudgestype;
	}
	/**
	 * @return the cfjudgesamount
	 */
	public Long getCfjudgesamount() {
		return cfjudgesamount;
	}
	/**
	 * @param cfjudgesamount the cfjudgesamount to set
	 */
	public void setCfjudgesamount(Long cfjudgesamount) {
		this.cfjudgesamount = cfjudgesamount;
	}

}