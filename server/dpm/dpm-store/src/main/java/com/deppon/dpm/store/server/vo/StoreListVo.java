package com.deppon.dpm.store.server.vo;

import java.math.BigDecimal;


/**
 * 榜单Vo,用于显示查询数据
 * @author XiaoTian
 *
 */
public class StoreListVo {
	
	//id
	private String listid;
	//营业部名称
    private String deptname;
    //营业部负责人名称
    private String deptlerdername;
    //营业部编号
    private String deptnum;
    //更新时间
    private String updatetime;
    //排名
    private String ranking;
    //排名上升下降
    private String rankingnum;
    //营业部头像
    private String depticon;
    //点赞数量
    private Long likenum;
    //警告数量
    private Long warningnum;
    //营业部分数
  	private BigDecimal grade;
  	//警告
  	private boolean iswarn =false;
  	//点赞
  	private boolean islike = false;
  	/**
  	 * 
  	 * @return
  	 */
	public BigDecimal getGrade() {
		return grade;
	}
	/**
	 * 
	 * @param grade
	 */
	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}
	/**
	 * 
	 * @return
	 */
	public String getListid() {
		return listid;
	}
	/**
	 * 
	 * @param listid
	 */
	public void setListid(String listid) {
		this.listid = listid;
	}
	/**
	 * 
	 * @return
	 */
	public String getDeptname() {
		return deptname;
	}
	/**
	 * 
	 * @param deptname
	 */
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	/**
	 * 
	 * @return
	 */
	public String getDeptlerdername() {
		return deptlerdername;
	}
	/**
	 * 
	 * @param deptlerdername
	 */
	public void setDeptlerdername(String deptlerdername) {
		this.deptlerdername = deptlerdername;
	}
	/**
	 * 
	 * @return
	 */
	public String getDeptnum() {
		return deptnum;
	}
	/**
	 * 
	 * @param deptnum
	 */
	public void setDeptnum(String deptnum) {
		this.deptnum = deptnum;
	}
	/**
	 * 
	 * @return
	 */
	public String getUpdatetime() {
		return updatetime;
	}
	/**
	 * 
	 * @param updatetime
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 
	 * @return
	 */
	public String getRanking() {
		return ranking;
	}
	/**
	 * 
	 * @param ranking
	 */
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	/**
	 * 
	 * @return
	 */
	public String getRankingnum() {
		return rankingnum;
	}
	/**
	 * 
	 * @param rankingnum
	 */
	public void setRankingnum(String rankingnum) {
		this.rankingnum = rankingnum;
	}
	/**
	 * 
	 * @return
	 */
	public String getDepticon() {
		return depticon;
	}
	/**
	 * 
	 * @param depticon
	 */
	public void setDepticon(String depticon) {
		this.depticon = depticon;
	}
	/**
	 * 
	 * @return
	 */
	public Long getLikenum() {
		return likenum;
	}
	/**
	 * 
	 * @param likenum
	 */
	public void setLikenum(Long likenum) {
		this.likenum = likenum;
	}
	/**
	 * 
	 * @return
	 */
	public Long getWarningnum() {
		return warningnum;
	}
	/**
	 * 
	 * @param warningnum
	 */
	public void setWarningnum(Long warningnum) {
		this.warningnum = warningnum;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isIswarn() {
		return iswarn;
	}
	/**
	 * 
	 * @param iswarn
	 */
	public void setIswarn(boolean iswarn) {
		this.iswarn = iswarn;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isIslike() {
		return islike;
	}
	/**
	 * 
	 * @param islike
	 */
	public void setIslike(boolean islike) {
		this.islike = islike;
	}
	/**
	 * 输出
	 */
	@Override
	public String toString() {
		return "StoreListVo [listid=" + listid + ", deptname=" + deptname
				+ ", deptlerdername=" + deptlerdername + ", deptnum=" + deptnum
				+ ", updatetime=" + updatetime + ", ranking=" + ranking
				+ ", rankingnum=" + rankingnum + ", depticon=" + depticon
				+ ", likenum=" + likenum + ", warningnum=" + warningnum
				+ ", grade=" + grade + ", iswarn=" + iswarn
				+ ", islike=" + islike + "]";
	}
}
