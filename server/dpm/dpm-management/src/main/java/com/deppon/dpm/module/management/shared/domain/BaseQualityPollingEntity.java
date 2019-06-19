package com.deppon.dpm.module.management.shared.domain;
import java.util.Date;
import java.util.List;

import com.deppon.foss.framework.entity.BaseEntity;
/**
 * @description 工程项目质量巡检映射表-基础资料
 * @date 2015-04-17
 * @author scr 210397
 *
 */
public class BaseQualityPollingEntity extends BaseEntity{
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	//移动端检查区域id
	private String areaId;
	//移动端检查项目id
	private String proId;
	//检查区域ID
	private String fcheckAreaId;
	//检查区域编号
	private String fcheckAreaCode;
	//检查项目ID
	private String fcheckProjectId;
	//检查项目编号
	private String fcheckProjectCode;
	//维修事项ID
	private String frepairMatterId;
	//维修事项编号
	private String frepairMatterCode;
	//单据ID
	private String fid;
	//单据编码
	private String fnumber;
	//简称
	private String fsimplename;
	//创建人
	private String fcreator;
	//创建时间
	private Date fcreateTime;
	//最后修改人
	private String flastupdateuserid;
	//最后修改时间
	private Date flastupdateTime;
	//检查区域
	private String fcheckArea;
	//检查项目
	private String fcheckProject;
	//维修事项
	private String frepairMatter;
	//评分标准
	private String fscoreStandard;
	//最高分值
	private Double fscore;
	//历史分数
	private Double hisFscore;
	//评分标准数组
	private List<String> arrList;
	//图片地址
	private String iocUrl;
	//历史评分地址总记录数
    private int countStore;
    //历史评分0分总记录数
    private int zeroCount;
    //分数
    private String fscoreId;
	/**
	 * @return 移动端检查区域id
	 */
	public String getAreaId() {
		return areaId;
	}
	/**
	 * @param areaId 移动端检查区域id
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	/**
	 * @return 移动端检查项目id
	 */
	public String getProId() {
		return proId;
	}
	/**
	 * @param proId 移动端检查项目id
	 */
	public void setProId(String proId) {
		this.proId = proId;
	}
	/**
	 * @return 检查区域ID
	 */
	public String getFcheckAreaId() {
		return fcheckAreaId;
	}
	/**
	 * @param fcheckAreaId 检查区域ID
	 */
	public void setFcheckAreaId(String fcheckAreaId) {
		this.fcheckAreaId = fcheckAreaId;
	}
	/**
	 * @return 检查区域编号
	 */
	public String getFcheckAreaCode() {
		return fcheckAreaCode;
	}
	/**
	 * @param fcheckAreaCode 检查区域编号
	 */
	public void setFcheckAreaCode(String fcheckAreaCode) {
		this.fcheckAreaCode = fcheckAreaCode;
	}
	public String getFcheckProjectId() {
		return fcheckProjectId;
	}
	public void setFcheckProjectId(String fcheckProjectId) {
		this.fcheckProjectId = fcheckProjectId;
	}
	public String getFcheckProjectCode() {
		return fcheckProjectCode;
	}
	public void setFcheckProjectCode(String fcheckProjectCode) {
		this.fcheckProjectCode = fcheckProjectCode;
	}
	/**
	 * @return 维修事项ID
	 */
	public String getFrepairMatterId() {
		return frepairMatterId;
	}
	/**
	 * @param frepairMatterId 维修事项ID
	 */
	public void setFrepairMatterId(String frepairMatterId) {
		this.frepairMatterId = frepairMatterId;
	}
	/**
	 * @return 维修事项编号
	 */
	public String getFrepairMatterCode() {
		return frepairMatterCode;
	}
	/**
	 * @param frepairMatterCode 维修事项编号
	 */
	public void setFrepairMatterCode(String frepairMatterCode) {
		this.frepairMatterCode = frepairMatterCode;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFnumber() {
		return fnumber;
	}
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}
	public String getFsimplename() {
		return fsimplename;
	}
	public void setFsimplename(String fsimplename) {
		this.fsimplename = fsimplename;
	}
	/**
	 * @return 创建人
	 */
	public String getFcreator() {
		return fcreator;
	}
	/**
	 * @param fcreator 创建人
	 */
	public void setFcreator(String fcreator) {
		this.fcreator = fcreator;
	}
	/**
	 * @return 创建时间
	 */
	public Date getFcreateTime() {
		return fcreateTime;
	}
	/**
	 * @param fcreateTime 创建时间
	 */
	public void setFcreateTime(Date fcreateTime) {
		this.fcreateTime = fcreateTime;
	}
	/**
	 * @return 最后修改人
	 */
	public String getFlastupdateuserid() {
		return flastupdateuserid;
	}
	/**
	 * @param flastupdateuserid 最后修改人
	 */
	public void setFlastupdateuserid(String flastupdateuserid) {
		this.flastupdateuserid = flastupdateuserid;
	}
	/**
	 * @return 最后修改时间
	 */
	public Date getFlastupdateTime() {
		return flastupdateTime;
	}
	/**
	 * @param flastupdateTime 最后修改时间
	 */
	public void setFlastupdateTime(Date flastupdateTime) {
		this.flastupdateTime = flastupdateTime;
	}
	/**
	 * @return 检查区域
	 */
	public String getFcheckArea() {
		return fcheckArea;
	}
	/**
	 * @param fcheckArea 检查区域
	 */
	public void setFcheckArea(String fcheckArea) {
		this.fcheckArea = fcheckArea;
	}
	public String getFcheckProject() {
		return fcheckProject;
	}
	public void setFcheckProject(String fcheckProject) {
		this.fcheckProject = fcheckProject;
	}
	public String getFrepairMatter() {
		return frepairMatter;
	}
	public void setFrepairMatter(String frepairMatter) {
		this.frepairMatter = frepairMatter;
	}
	public String getFscoreStandard() {
		return fscoreStandard;
	}
	public void setFscoreStandard(String fscoreStandard) {
		this.fscoreStandard = fscoreStandard;
	}
	public Double getFscore() {
		return fscore;
	}
	public void setFscore(Double fscore) {
		this.fscore = fscore;
	}
	public Double getHisFscore() {
		return hisFscore;
	}
	public void setHisFscore(Double hisFscore) {
		this.hisFscore = hisFscore;
	}
	public List<String> getArrList() {
		return arrList;
	}
	public void setArrList(List<String> arrList) {
		this.arrList = arrList;
	}
	public String getIocUrl() {
		return iocUrl;
	}
	public void setIocUrl(String iocUrl) {
		this.iocUrl = iocUrl;
	}
	public int getCountStore() {
		return countStore;
	}
	public void setCountStore(int countStore) {
		this.countStore = countStore;
	}
	/**
	 * @return 历史评分0分总记录数
	 */
	public int getZeroCount() {
		return zeroCount;
	}
	/**
	 * @param zeroCount 历史评分0分总记录数
	 */
	public void setZeroCount(int zeroCount) {
		this.zeroCount = zeroCount;
	}
	public String getFscoreId() {
		return fscoreId;
	}
	public void setFscoreId(String fscoreId) {
		this.fscoreId = fscoreId;
	}
	/**
	 * @return 序列号
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	//组装
	public String toString() {
		return "BaseQualityPollingEntity [areaId=" + areaId + ", proId="
				+ proId + ", fcheckAreaId=" + fcheckAreaId
				+ ", fcheckAreaCode=" + fcheckAreaCode + ", fcheckProjectId="
				+ fcheckProjectId + ", fcheckProjectCode=" + fcheckProjectCode
				+ ", frepairMatterId=" + frepairMatterId
				+ ", frepairMatterCode=" + frepairMatterCode + ", fid=" + fid
				+ ", fnumber=" + fnumber + ", fsimplename=" + fsimplename
				+ ", fcreator=" + fcreator + ", fcreateTime=" + fcreateTime
				+ ", flastupdateuserid=" + flastupdateuserid
				+ ", flastupdateTime=" + flastupdateTime + ", fcheckArea="
				+ fcheckArea + ", fcheckProject=" + fcheckProject
				+ ", frepairMatter=" + frepairMatter + ", fscoreStandard="
				+ fscoreStandard + ", fscore=" + fscore + ", hisFscore="
				+ hisFscore + ", arrList=" + arrList + ", iocUrl=" + iocUrl
				+ ", countStore=" + countStore + ", zeroCount=" + zeroCount
				+ ", fscoreId=" + fscoreId + "]";
	}
	
	
}
