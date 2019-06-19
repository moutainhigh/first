package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.AdminOrgUnit;

/**
 * 
 *<pre>
 *
 * 描述：评标申请单单头
 * @author 李清松
 * @date 2014-2-20 上午午10:17:49
 * @since
 * @version
 *    
 *</pre>
 *
 */
public class JudgeApplyEntity extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7650688622338486326L;
	//fid
	private String fid;
	//单据编码
	private String fnumber;
	//评标细则模板号
	private String cfjudgedetailnumber;
	//RFQ单号
	private String cfrfqnumber;
	//申请时间
	private Date cfapplydate;
	//评标时间
	private Date cfjudgedate;
	//评标地点
	private String cfjudgelocation;
	//招标执行组长
	private String cfbidleader;
	//评委数量
	private BigDecimal cfjudgesamount;
	//专业部门ID
	private String cfprofessordeptid;
	//专业部门
	private AdminOrgUnit cfprofessordept;
	//商务标评分
	private BigDecimal cfbusinessscore;
	//技术标评分
	private BigDecimal cftechnologyscore;
	//综合评分
	private BigDecimal cfcompositescore;
	//标的物金额
    private BigDecimal cfdestamount;
    //项目描述
    private String cfprojectdescriber;
    //单据状态
    private String cfbillstate;
    //审核人
    private String fauditorid;
    //审核时间
    private Date fbizdate;
    
    
   //定义字符串变量将用于接收BigDecimal的值
    //评委数量
  	private String cfjudgesamountDto;
  	//商务标评分
  	private String cfbusinessscoreDto;
  	//技术标评分
  	private String cftechnologyscoreDto;
  	//综合评分
  	private String cfcompositescoreDto;
  	//标的物金额
    private String cfdestamountDto;
    
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
	 * @return the fnumber
	 */
	public String getFnumber() {
		return fnumber;
	}
	/**
	 * @param fnumber the fnumber to set
	 */
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}
	/**
	 * @return the cfjudgedetailnumber
	 */
	public String getCfjudgedetailnumber() {
		return cfjudgedetailnumber;
	}
	/**
	 * @param cfjudgedetailnumber the cfjudgedetailnumber to set
	 */
	public void setCfjudgedetailnumber(String cfjudgedetailnumber) {
		this.cfjudgedetailnumber = cfjudgedetailnumber;
	}
	/**
	 * @return the cfrfqnumber
	 */
	public String getCfrfqnumber() {
		return cfrfqnumber;
	}
	/**
	 * @param cfrfqnumber the cfrfqnumber to set
	 */
	public void setCfrfqnumber(String cfrfqnumber) {
		this.cfrfqnumber = cfrfqnumber;
	}
	/**
	 * @return the cfapplydate
	 */
	public Date getCfapplydate() {
		return cfapplydate;
	}
	/**
	 * @param cfapplydate the cfapplydate to set
	 */
	public void setCfapplydate(Date cfapplydate) {
		this.cfapplydate = cfapplydate;
	}
	/**
	 * @return the cfjudgedate
	 */
	public Date getCfjudgedate() {
		return cfjudgedate;
	}
	/**
	 * @param cfjudgedate the cfjudgedate to set
	 */
	public void setCfjudgedate(Date cfjudgedate) {
		this.cfjudgedate = cfjudgedate;
	}
	/**
	 * @return the cfjudgelocation
	 */
	public String getCfjudgelocation() {
		return cfjudgelocation;
	}
	/**
	 * @param cfjudgelocation the cfjudgelocation to set
	 */
	public void setCfjudgelocation(String cfjudgelocation) {
		this.cfjudgelocation = cfjudgelocation;
	}
	/**
	 * @return the cfbidleader
	 */
	public String getCfbidleader() {
		return cfbidleader;
	}
	/**
	 * @param cfbidleader the cfbidleader to set
	 */
	public void setCfbidleader(String cfbidleader) {
		this.cfbidleader = cfbidleader;
	}
	/**
	 * @return the cfjudgesamount
	 */
	public BigDecimal getCfjudgesamount() {
		return cfjudgesamount;
	}
	/**
	 * @param cfjudgesamount the cfjudgesamount to set
	 */
	public void setCfjudgesamount(BigDecimal cfjudgesamount) {
		this.cfjudgesamount = cfjudgesamount;
	}
	
	/**
	 * @return the cfprofessordeptid
	 */
	public String getCfprofessordeptid() {
		return cfprofessordeptid;
	}
	/**
	 * @param cfprofessordeptid the cfprofessordeptid to set
	 */
	public void setCfprofessordeptid(String cfprofessordeptid) {
		this.cfprofessordeptid = cfprofessordeptid;
	}
	/**
	 * @return the cfprofessordept
	 */
	public AdminOrgUnit getCfprofessordept() {
		return cfprofessordept;
	}
	/**
	 * @param cfprofessordept the cfprofessordept to set
	 */
	public void setCfprofessordept(AdminOrgUnit cfprofessordept) {
		this.cfprofessordept = cfprofessordept;
	}
	/**
	 * @return the cfbusinessscore
	 */
	public BigDecimal getCfbusinessscore() {
		return cfbusinessscore;
	}
	/**
	 * @param cfbusinessscore the cfbusinessscore to set
	 */
	public void setCfbusinessscore(BigDecimal cfbusinessscore) {
		this.cfbusinessscore = cfbusinessscore;
	}
	/**
	 * @return the cftechnologyscore
	 */
	public BigDecimal getCftechnologyscore() {
		return cftechnologyscore;
	}
	/**
	 * @param cftechnologyscore the cftechnologyscore to set
	 */
	public void setCftechnologyscore(BigDecimal cftechnologyscore) {
		this.cftechnologyscore = cftechnologyscore;
	}
	/**
	 * @return the cfcompositescore
	 */
	public BigDecimal getCfcompositescore() {
		return cfcompositescore;
	}
	/**
	 * @param cfcompositescore the cfcompositescore to set
	 */
	public void setCfcompositescore(BigDecimal cfcompositescore) {
		this.cfcompositescore = cfcompositescore;
	}
	/**
	 * @return the cfdestamount
	 */
	public BigDecimal getCfdestamount() {
		return cfdestamount;
	}
	/**
	 * @param cfdestamount the cfdestamount to set
	 */
	public void setCfdestamount(BigDecimal cfdestamount) {
		this.cfdestamount = cfdestamount;
	}
	/**
	 * @return the cfprojectdescriber
	 */
	public String getCfprojectdescriber() {
		return cfprojectdescriber;
	}
	/**
	 * @param cfprojectdescriber the cfprojectdescriber to set
	 */
	public void setCfprojectdescriber(String cfprojectdescriber) {
		this.cfprojectdescriber = cfprojectdescriber;
	}
	/**
	 * @return the cfbillstate
	 */
	public String getCfbillstate() {
		return cfbillstate;
	}
	/**
	 * @param cfbillstate the cfbillstate to set
	 */
	public void setCfbillstate(String cfbillstate) {
		this.cfbillstate = cfbillstate;
	}
	/**
	 * @return the fauditorid
	 */
	public String getFauditorid() {
		return fauditorid;
	}
	/**
	 * @param fauditorid the fauditorid to set
	 */
	public void setFauditorid(String fauditorid) {
		this.fauditorid = fauditorid;
	}
	/**
	 * @return the fbizdate
	 */
	public Date getFbizdate() {
		return fbizdate;
	}
	/**
	 * @param fbizdate the fbizdate to set
	 */
	public void setFbizdate(Date fbizdate) {
		this.fbizdate = fbizdate;
	}
	public String getCfjudgesamountDto() {
		return cfjudgesamountDto;
	}
	public void setCfjudgesamountDto(String cfjudgesamountDto) {
		this.cfjudgesamountDto = cfjudgesamountDto;
	}
	public String getCfbusinessscoreDto() {
		return cfbusinessscoreDto;
	}
	public void setCfbusinessscoreDto(String cfbusinessscoreDto) {
		this.cfbusinessscoreDto = cfbusinessscoreDto;
	}
	public String getCftechnologyscoreDto() {
		return cftechnologyscoreDto;
	}
	public void setCftechnologyscoreDto(String cftechnologyscoreDto) {
		this.cftechnologyscoreDto = cftechnologyscoreDto;
	}
	public String getCfcompositescoreDto() {
		return cfcompositescoreDto;
	}
	public void setCfcompositescoreDto(String cfcompositescoreDto) {
		this.cfcompositescoreDto = cfcompositescoreDto;
	}
	public String getCfdestamountDto() {
		return cfdestamountDto;
	}
	public void setCfdestamountDto(String cfdestamountDto) {
		this.cfdestamountDto = cfdestamountDto;
	}
    
}