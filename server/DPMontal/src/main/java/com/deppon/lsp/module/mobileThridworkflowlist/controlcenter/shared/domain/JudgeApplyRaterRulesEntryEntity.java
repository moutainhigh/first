package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;


import java.util.List;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 *<pre>
 *
 * 描述：评标申请单-评标细则分录
 * @author 李清松
 * @date 2014-2-20 上午午10:17:49
 * @since
 * @version
 *    
 *</pre>
 *
 */
public class JudgeApplyRaterRulesEntryEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2728102028948692523L;
	//fid
    private String fid;
    //父类ID
    private String fparentid;
    //评标项类别
    private String cfjudgebidtype;
    //评标项
    private String cfjudgeitem;
    //评委类别
    private String cfjudgestype;
    //类型
    private List<JudgeApplyTypeEntryEntity> cfjudgestypelist;
    //分值
    private Long cfjudgescore;
    //评标细则
    private String cfjudgedetail;
    
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
	 * @return the cfjudgebidtype
	 */
	public String getCfjudgebidtype() {
		return cfjudgebidtype;
	}
	/**
	 * @param cfjudgebidtype the cfjudgebidtype to set
	 */
	public void setCfjudgebidtype(String cfjudgebidtype) {
		this.cfjudgebidtype = cfjudgebidtype;
	}
	/**
	 * @return the cfjudgeitem
	 */
	public String getCfjudgeitem() {
		return cfjudgeitem;
	}
	/**
	 * @param cfjudgeitem the cfjudgeitem to set
	 */
	public void setCfjudgeitem(String cfjudgeitem) {
		this.cfjudgeitem = cfjudgeitem;
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
	 * @return the cfjudgescore
	 */
	public Long getCfjudgescore() {
		return cfjudgescore;
	}
	/**
	 * @param cfjudgescore the cfjudgescore to set
	 */
	public void setCfjudgescore(Long cfjudgescore) {
		this.cfjudgescore = cfjudgescore;
	}
	/**
	 * @return the cfjudgedetail
	 */
	public String getCfjudgedetail() {
		return cfjudgedetail;
	}
	/**
	 * @param cfjudgedetail the cfjudgedetail to set
	 */
	public void setCfjudgedetail(String cfjudgedetail) {
		this.cfjudgedetail = cfjudgedetail;
	}
	public List<JudgeApplyTypeEntryEntity> getCfjudgestypelist() {
		return cfjudgestypelist;
	}
	public void setCfjudgestypelist(List<JudgeApplyTypeEntryEntity> cfjudgestypelist) {
		this.cfjudgestypelist = cfjudgestypelist;
	}

}