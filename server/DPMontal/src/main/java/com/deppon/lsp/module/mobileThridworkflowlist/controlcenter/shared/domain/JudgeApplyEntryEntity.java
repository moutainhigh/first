package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;


import java.math.BigDecimal;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 *<pre>
 *
 * 描述：评标申请单-评标物品信息分录
 * @author 李清松
 * @date 2014-2-20 上午午10:17:49
 * @since
 * @version
 *    
 *</pre>
 *
 */
public class JudgeApplyEntryEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1087185392887630714L;
	
	//fid
    private String fid;
    //父类Id
    private String fparentid;
    //物品编码
    private String cfmaterialnumber;
    //物品名称
    private String cfmaterialname;
    //物品类型
    private String cfmaterialtype;
    //物品规格
    private String cfmaterialmodel;
    //计量单位
    private String cfunit;
    //数量
    private BigDecimal cfmaterialamount;
    
    ///数量
    private String cfmaterialamountDto;
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
	 * @return the cfmaterialnumber
	 */
	public String getCfmaterialnumber() {
		return cfmaterialnumber;
	}
	/**
	 * @param cfmaterialnumber the cfmaterialnumber to set
	 */
	public void setCfmaterialnumber(String cfmaterialnumber) {
		this.cfmaterialnumber = cfmaterialnumber;
	}
	/**
	 * @return the cfmaterialname
	 */
	public String getCfmaterialname() {
		return cfmaterialname;
	}
	/**
	 * @param cfmaterialname the cfmaterialname to set
	 */
	public void setCfmaterialname(String cfmaterialname) {
		this.cfmaterialname = cfmaterialname;
	}
	/**
	 * @return the cfmaterialtype
	 */
	public String getCfmaterialtype() {
		return cfmaterialtype;
	}
	/**
	 * @param cfmaterialtype the cfmaterialtype to set
	 */
	public void setCfmaterialtype(String cfmaterialtype) {
		this.cfmaterialtype = cfmaterialtype;
	}
	/**
	 * @return the cfmaterialmodel
	 */
	public String getCfmaterialmodel() {
		return cfmaterialmodel;
	}
	/**
	 * @param cfmaterialmodel the cfmaterialmodel to set
	 */
	public void setCfmaterialmodel(String cfmaterialmodel) {
		this.cfmaterialmodel = cfmaterialmodel;
	}
	/**
	 * @return the cfunit
	 */
	public String getCfunit() {
		return cfunit;
	}
	/**
	 * @param cfunit the cfunit to set
	 */
	public void setCfunit(String cfunit) {
		this.cfunit = cfunit;
	}
	/**
	 * @return the cfmaterialamount
	 */
	public BigDecimal getCfmaterialamount() {
		return cfmaterialamount;
	}
	/**
	 * @param cfmaterialamount the cfmaterialamount to set
	 */
	public void setCfmaterialamount(BigDecimal cfmaterialamount) {
		this.cfmaterialamount = cfmaterialamount;
	}
	public String getCfmaterialamountDto() {
		return cfmaterialamountDto;
	}
	public void setCfmaterialamountDto(String cfmaterialamountDto) {
		this.cfmaterialamountDto = cfmaterialamountDto;
	}

   
}