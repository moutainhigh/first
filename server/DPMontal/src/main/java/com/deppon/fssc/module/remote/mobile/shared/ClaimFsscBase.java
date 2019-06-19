package com.deppon.fssc.module.remote.mobile.shared;


import com.deppon.fssc.module.claimsupport.shared.domain.ClaimBaseEntity;
import com.deppon.montal.conf.F_Constants;

public class ClaimFsscBase extends ClaimBaseEntity{

	private static final long serialVersionUID = -8501647380176613705L;
	private String createDateStr;
	
	private String modifyDateStr;
	private String applyDateStr;
	
	private String draftTimeStr;
	
	private String latestRemitDateStr;
	
	private String voucherCreateDateStr;
	
	private String payDateStr;
	
	private String tallyDateStr;
	
	private String processEndTimeStr;
	
	private String wfCurReceiveDateStr;

	public ClaimFsscBase(){
		
	}	
	public String getCreateDateStr() {
		return createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	public String getModifyDateStr() {
		return modifyDateStr;
	}

	public void setModifyDateStr(String modifyDateStr) {
		this.modifyDateStr = modifyDateStr;
	}
	public String getApplyDateStr() {
		return F_Constants.getDateyyyyMMdd(applyDateStr);
	}

	public void setApplyDateStr(String applyDateStr) {
		this.applyDateStr = applyDateStr;
	}

	public String getDraftTimeStr() {
		return F_Constants.getDateyyyyMMdd(draftTimeStr);
	}

	public void setDraftTimeStr(String draftTimeStr) {
		this.draftTimeStr = draftTimeStr;
	}

	public String getLatestRemitDateStr() {
		return F_Constants.getDateyyyyMMdd(latestRemitDateStr);
	}

	public void setLatestRemitDateStr(String latestRemitDateStr) {
		this.latestRemitDateStr = latestRemitDateStr;
	}

	public String getVoucherCreateDateStr() {
		return voucherCreateDateStr;
	}

	public void setVoucherCreateDateStr(String voucherCreateDateStr) {
		this.voucherCreateDateStr = voucherCreateDateStr;
	}

	public String getPayDateStr() {
		return payDateStr;
	}

	public void setPayDateStr(String payDateStr) {
		this.payDateStr = payDateStr;
	}

	public String getTallyDateStr() {
		return tallyDateStr;
	}

	public void setTallyDateStr(String tallyDateStr) {
		this.tallyDateStr = tallyDateStr;
	}

	public String getProcessEndTimeStr() {
		return processEndTimeStr;
	}

	public void setProcessEndTimeStr(String processEndTimeStr) {
		this.processEndTimeStr = processEndTimeStr;
	}

	public String getWfCurReceiveDateStr() {
		return wfCurReceiveDateStr;
	}

	public void setWfCurReceiveDateStr(String wfCurReceiveDateStr) {
		this.wfCurReceiveDateStr = wfCurReceiveDateStr;
	}
	
	
	
}
