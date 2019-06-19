package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

public class ProjectdesignassentryVo extends BaseEntity{

	private static final long serialVersionUID = -8652679857579950934L;
	
	private String fid;				//fid
	private String fchargenameid;	//fchargenameid
	private Long cfestimate;		//cfestimate
	private String fchargename;		//fchargename
	private String cfexpensetype;	//cfexpensetype
	/**
	 * 
	 * <pre>方法说明: 执行操作
	 * @author jianghaibin
	 * @date 2013-9-27 下午5:13:14
	 * @return
	 * @see
	 *</pre>
	 */
	public String getFid() {
		return fid;
	}
	/**
	 * 
	 * <pre>方法说明: 执行操作
	 * @author jianghaibin
	 * @date 2013-9-27 下午5:13:14
	 * @return
	 * @see
	 *</pre>
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}
	/**
	 * 
	 * <pre>方法说明: 执行操作
	 * @author jianghaibin
	 * @date 2013-9-27 下午5:13:14
	 * @return
	 * @see
	 *</pre>
	 */
	public String getFchargenameid() {
		return fchargenameid;
	}
	/**
	 * 
	 * <pre>方法说明: 执行操作
	 * @author jianghaibin
	 * @date 2013-9-27 下午5:13:14
	 * @return
	 * @see
	 *</pre>
	 */
	public void setFchargenameid(String fchargenameid) {
		this.fchargenameid = fchargenameid;
	}
	/**
	 * 
	 * <pre>方法说明: 执行操作
	 * @author jianghaibin
	 * @date 2013-9-27 下午5:13:14
	 * @return
	 * @see
	 *</pre>
	 */
	public Long getCfestimate() {
		return cfestimate;
	}
	/**
	 * 
	 * <pre>方法说明: 执行操作
	 * @author jianghaibin
	 * @date 2013-9-27 下午5:13:14
	 * @return
	 * @see
	 *</pre>
	 */
	public void setCfestimate(Long cfestimate) {
		this.cfestimate = cfestimate;
	}
	/**
	 * 
	 * <pre>方法说明: 执行操作
	 * @author jianghaibin
	 * @date 2013-9-27 下午5:13:14
	 * @return
	 * @see
	 *</pre>
	 */
	public String getFchargename() {
		return fchargename;
	}
	/**
	 * 
	 * <pre>方法说明: 执行操作
	 * @author jianghaibin
	 * @date 2013-9-27 下午5:13:14
	 * @return
	 * @see
	 *</pre>
	 */
	public void setFchargename(String fchargename) {
		this.fchargename = fchargename;
	}
	/**
	 * 
	 * <pre>方法说明: 执行操作
	 * @author jianghaibin
	 * @date 2013-9-27 下午5:13:14
	 * @return
	 * @see
	 *</pre>
	 */
	public String getCfexpensetype() {
		return cfexpensetype;
	}
	/**
	 * 
	 * <pre>方法说明: 执行操作
	 * @author jianghaibin
	 * @date 2013-9-27 下午5:13:14
	 * @return
	 * @see
	 *</pre>
	 */
	public void setCfexpensetype(String cfexpensetype) {
		this.cfexpensetype = cfexpensetype;
	}
}
