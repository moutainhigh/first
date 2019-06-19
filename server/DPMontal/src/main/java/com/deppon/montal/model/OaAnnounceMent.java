package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.montal.conf.F_Constants;

public class OaAnnounceMent {
    private BigDecimal ggid;

    private BigDecimal lmid;

    private String header;

    private String fbr;

    private Date fbdate;

    private Date savedate;

    private BigDecimal istop;

    private String ggfw;

    private String ggfwname;

    private Date keepdate;

    private BigDecimal jjgg;

    private BigDecimal sfvideo;

    private String videourl;

    private String fbrempid;

    private String fbrempname;

    private BigDecimal iscallsign;

    private BigDecimal isreadsign;

    private String tpsm;

    private String content;
    
    private BigDecimal ckbh;

    public BigDecimal getGgid() {
        return ggid;
    }

    public void setGgid(BigDecimal ggid) {
        this.ggid = ggid;
    }

    public BigDecimal getLmid() {
        return lmid;
    }

    public void setLmid(BigDecimal lmid) {
        this.lmid = lmid;
    }

    public String getHeader() {
        return F_Constants.chageNull(header);
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFbr() {
        return F_Constants.chageNull(fbr);
    }

    public void setFbr(String fbr) {
        this.fbr = fbr;
    }

    public Date getFbdate() {
        return fbdate;
    }

    public void setFbdate(Date fbdate) {
        this.fbdate = fbdate;
    }

    public Date getSavedate() {
        return savedate;
    }

    public void setSavedate(Date savedate) {
        this.savedate = savedate;
    }

    public BigDecimal getIstop() {
        return istop;
    }

    public void setIstop(BigDecimal istop) {
        this.istop = istop;
    }

    public String getGgfw() {
        return F_Constants.chageNull(ggfw);
    }

    public void setGgfw(String ggfw) {
        this.ggfw = ggfw;
    }

    public String getGgfwname() {
        return F_Constants.chageNull(ggfwname);
    }

    public void setGgfwname(String ggfwname) {
        this.ggfwname = ggfwname;
    }

    public Date getKeepdate() {
        return keepdate;
    }

    public void setKeepdate(Date keepdate) {
        this.keepdate = keepdate;
    }

    public BigDecimal getJjgg() {
        return jjgg;
    }

    public void setJjgg(BigDecimal jjgg) {
        this.jjgg = jjgg;
    }

    public BigDecimal getSfvideo() {
        return sfvideo;
    }

    public void setSfvideo(BigDecimal sfvideo) {
        this.sfvideo = sfvideo;
    }

    public String getVideourl() {
        return F_Constants.chageNull(videourl);
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getFbrempid() {
        return F_Constants.chageNull(fbrempid);
    }

    public void setFbrempid(String fbrempid) {
        this.fbrempid = fbrempid;
    }

    public String getFbrempname() {
        return F_Constants.chageNull(fbrempname);
    }

    public void setFbrempname(String fbrempname) {
        this.fbrempname = fbrempname;
    }

    public BigDecimal getIscallsign() {
        return iscallsign;
    }

    public void setIscallsign(BigDecimal iscallsign) {
        this.iscallsign = iscallsign;
    }

    public BigDecimal getIsreadsign() {
        return isreadsign;
    }

    public void setIsreadsign(BigDecimal isreadsign) {
        this.isreadsign = isreadsign;
    }

    public String getTpsm() {
        return F_Constants.chageNull(tpsm);
    }

    public void setTpsm(String tpsm) {
        this.tpsm = tpsm;
    }

    public String getContent() {
        return F_Constants.chageNull(content);
    }

    public void setContent(String content) {
        this.content = content;
    }

	public BigDecimal getCkbh() {
		return ckbh;
	}

	public void setCkbh(BigDecimal ckbh) {
		this.ckbh = ckbh;
	}

}