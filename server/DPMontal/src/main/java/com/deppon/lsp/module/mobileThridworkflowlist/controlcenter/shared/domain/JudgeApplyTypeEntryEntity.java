package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 *<pre>
 *
 * 描述：评标申请单-评标细则分录 -分录
 * @author 李清松
 * @date 2014-2-20 上午午10:17:49
 * @since
 * @version
 *    
 *</pre>
 *
 */
public class JudgeApplyTypeEntryEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2757134133297626461L;
	//fid
	private String fid;
	//fparentid
	private String fparentid;
	//类型名称
	private String typename;
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
	 * @return the typename
	 */
	public String getTypename() {
		return typename;
	}
	/**
	 * @param typename the typename to set
	 */
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
}
