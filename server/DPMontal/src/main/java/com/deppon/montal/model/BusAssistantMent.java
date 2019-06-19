package com.deppon.montal.model;

import java.math.BigDecimal;
import java.sql.Clob;
import java.util.Date;

/**
 * 出差小助手
 * @author 106460
 *
 */
public class BusAssistantMent {
	
	
    private BigDecimal ID;

    private String TITLE;

    private Clob CONTENT;
    
    private String CONTENTSTR;

    private String PUBLISHTIME;
    
    private String PUBLISHOR;

	public BigDecimal getID() {
		return ID;
	}

	public void setID(BigDecimal iD) {
		ID = iD;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	public Clob getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(Clob cONTENT) {
		CONTENT = cONTENT;
	}

	public String getPUBLISHTIME() {
		return PUBLISHTIME;
	}

	public void setPUBLISHTIME(String pUBLISHTIME) {
		PUBLISHTIME = pUBLISHTIME;
	}

	public String getPUBLISHOR() {
		return PUBLISHOR;
	}

	public void setPUBLISHOR(String pUBLISHOR) {
		PUBLISHOR = pUBLISHOR;
	}

	public String getCONTENTSTR() {
		return CONTENTSTR;
	}

	public void setCONTENTSTR(String cONTENTSTR) {
		CONTENTSTR = cONTENTSTR;
	}

	
	
	
	

    
}