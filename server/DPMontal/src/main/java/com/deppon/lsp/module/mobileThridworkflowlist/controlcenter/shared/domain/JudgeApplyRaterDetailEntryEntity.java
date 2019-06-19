package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;


import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 *<pre>
 *
 * 描述：评标申请单-评委清单信息分录
 * @author 李清松
 * @date 2014-2-20 上午午10:17:49
 * @since
 * @version
 *    
 *</pre>
 *
 */
public class JudgeApplyRaterDetailEntryEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3245988543147749965L;
	//fid
    private String fid;
    //父类ID
    private String fparentid;
    //评委库编码
    private String cfjudgeinfonum;
    //评委姓名
    private String cfjudgesname;
    //评委类别
    private String cfjudgestype;
    //评委专长
    private String cfjudgesmajor;
    //是否评标组长
    private Long cfisleader;
    //是否选中
    private Long cfisselected;
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
	 * @return the cfjudgeinfonum
	 */
	public String getCfjudgeinfonum() {
		return cfjudgeinfonum;
	}
	/**
	 * @param cfjudgeinfonum the cfjudgeinfonum to set
	 */
	public void setCfjudgeinfonum(String cfjudgeinfonum) {
		this.cfjudgeinfonum = cfjudgeinfonum;
	}
	/**
	 * @return the cfjudgesname
	 */
	public String getCfjudgesname() {
		return cfjudgesname;
	}
	/**
	 * @param cfjudgesname the cfjudgesname to set
	 */
	public void setCfjudgesname(String cfjudgesname) {
		this.cfjudgesname = cfjudgesname;
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
	 * @return the cfjudgesmajor
	 */
	public String getCfjudgesmajor() {
		return cfjudgesmajor;
	}
	/**
	 * @param cfjudgesmajor the cfjudgesmajor to set
	 */
	public void setCfjudgesmajor(String cfjudgesmajor) {
		this.cfjudgesmajor = cfjudgesmajor;
	}
	/**
	 * @return the cfisleader
	 */
	public Long getCfisleader() {
		return cfisleader;
	}
	/**
	 * @param cfisleader the cfisleader to set
	 */
	public void setCfisleader(Long cfisleader) {
		this.cfisleader = cfisleader;
	}
	/**
	 * @return the cfisselected
	 */
	public Long getCfisselected() {
		return cfisselected;
	}
	/**
	 * @param cfisselected the cfisselected to set
	 */
	public void setCfisselected(Long cfisselected) {
		this.cfisselected = cfisselected;
	}

}