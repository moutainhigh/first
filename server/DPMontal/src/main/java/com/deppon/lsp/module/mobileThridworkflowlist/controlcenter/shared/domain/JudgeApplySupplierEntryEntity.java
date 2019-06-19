package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;


import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 *<pre>
 *
 * 描述：评标申请单-供应商信息分录
 * @author 李清松
 * @date 2014-2-20 上午午10:17:49
 * @since
 * @version
 *    
 *</pre>
 *
 */
public class JudgeApplySupplierEntryEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1453386103954236453L;
	//fid
    private String fid;
    //父类ID
    private String fparentid;
    //供应商编码
    private String cfsuppliernumber;
    //供应商名称
    private String cfsuppliername;
    //供应商状态
    private String cfsupplierstate;
    //评审结果
    private String cfjudgeresult;
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
	 * @return the cfsuppliernumber
	 */
	public String getCfsuppliernumber() {
		return cfsuppliernumber;
	}
	/**
	 * @param cfsuppliernumber the cfsuppliernumber to set
	 */
	public void setCfsuppliernumber(String cfsuppliernumber) {
		this.cfsuppliernumber = cfsuppliernumber;
	}
	/**
	 * @return the cfsuppliername
	 */
	public String getCfsuppliername() {
		return cfsuppliername;
	}
	/**
	 * @param cfsuppliername the cfsuppliername to set
	 */
	public void setCfsuppliername(String cfsuppliername) {
		this.cfsuppliername = cfsuppliername;
	}
	/**
	 * @return the cfsupplierstate
	 */
	public String getCfsupplierstate() {
		return cfsupplierstate;
	}
	/**
	 * @param cfsupplierstate the cfsupplierstate to set
	 */
	public void setCfsupplierstate(String cfsupplierstate) {
		this.cfsupplierstate = cfsupplierstate;
	}
	/**
	 * @return the cfjudgeresult
	 */
	public String getCfjudgeresult() {
		return cfjudgeresult;
	}
	/**
	 * @param cfjudgeresult the cfjudgeresult to set
	 */
	public void setCfjudgeresult(String cfjudgeresult) {
		this.cfjudgeresult = cfjudgeresult;
	}

}