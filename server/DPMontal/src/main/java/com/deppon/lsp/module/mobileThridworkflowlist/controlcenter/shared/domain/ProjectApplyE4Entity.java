package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.MeasureUnit;
/**
 * 
 * 作者（修改人）：YangMing
 * 修改时间：2013-9-4 上午11:05:12
 * 描述：工程项目申请单 办公配套 分录实体
 * 更新记录：
 */
public class ProjectApplyE4Entity extends BaseEntity {

	/**
	 * TODO（用一句话描述这个变量表示什么）
	 */
	private static final long serialVersionUID = 5662745786420093123L;
	/* 分录行id */
	private String fid;
	/* 序号 */
	private String fseq;
	/* 序号 */
	private String cfseq;
	/* 父表id */
	private String fparentID;
	/* 配套名称ID */
	private String cfpackageNameID;
	/* 配套名称 */
	private OfficePackageName cfpackageName;
	/* 现状 */
	private int cfcurrentNum;
	/* 明年 */
	private int cfnextNum;
	/* 后年 */
	private int cfafterNextNum;
	/* 计量单位ID */
	private String cfunitID;
	/* 计量单位名称 */
	private MeasureUnit cfunit;
	/* 备注说明 */
	private String cfcommon;
	/* 父表number */
	private String fparentName;
	/**
	 * 
	 * 描述： fid
	 * @author yangming
	 * @date 2013-9-27 上午9:53:46
	 * @return
	 * 更新记录：
	 */
	public String getFid() {
		return fid;
	}
	/**
	 * 
	 * 描述： fid setter
	 * @author yangming
	 * @date 2013-9-27 上午9:53:46
	 * @return
	 * 更新记录：
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}
	/**
	 * 
	 * 描述： 
	 * @author yangming
	 * @date 2013-9-27 上午9:54:06
	 * @return
	 * 更新记录：
	 */
	public String getFseq() {
		return fseq;
	}
	/**
	 * 
	 * 描述： 
	 * @author yangming
	 * @date 2013-9-27 上午9:54:40
	 * @param fseq
	 * 更新记录：
	 */
	public void setFseq(String fseq) {
		this.fseq = fseq;
	}
	/**
	 * 
	 * 描述： 
	 * @author yangming
	 * @date 2013-9-27 上午9:55:44
	 * @return
	 * 更新记录：
	 */
	public String getCfseq() {
		return cfseq;
	}
	/**
	 * 
	 * 描述： 
	 * @author yangming
	 * @date 2013-9-27 上午9:55:58
	 * @param cfseq
	 * 更新记录：
	 */
	public void setCfseq(String cfseq) {
		this.cfseq = cfseq;
	}
	/**
	 * 
	 * 描述： 表头id
	 * @author yangming
	 * @date 2013-9-27 上午9:57:29
	 * @return
	 * 更新记录：
	 */
	public String getFparentID() {
		return fparentID;
	}
	
	/**
	 * 
	 * 描述： 表头id
	 * @author yangming
	 * @date 2013-9-27 上午9:58:12
	 * @param fparentID
	 * 更新记录：
	 */
	public void setFparentID(String fparentID) {
		this.fparentID = fparentID;
	}
	/**
	 * 
	 * 描述： 配套名称id
	 * @author yangming
	 * @date 2013-9-27 上午9:58:38
	 * @return
	 * 更新记录：
	 */
	public String getCfpackageNameID() {
		return cfpackageNameID;
	}
	/**
	 * 
	 * 描述： 配套名称id setter
	 * @author yangming
	 * @date 2013-9-27 上午9:58:38
	 * @return
	 * 更新记录：
	 */
	public void setCfpackageNameID(String cfpackageNameID) {
		this.cfpackageNameID = cfpackageNameID;
	}
	/**
	 * 
	 * 描述： 计量单位ID
	 * @author yangming
	 * @date 2013-9-27 上午9:59:10
	 * @return
	 * 更新记录：
	 */
	public String getCfunitID() {
		return cfunitID;
	}
	/**
	 * 
	 * 描述： 计量单位ID setter
	 * @author yangming
	 * @date 2013-9-27 上午9:59:10
	 * @return
	 * 更新记录：
	 */
	public void setCfunitID(String cfunitID) {
		this.cfunitID = cfunitID;
	}
	/**
	 * 
	 * 描述：备注说明 
	 * @author yangming
	 * @date 2013-9-27 上午9:59:31
	 * @return
	 * 更新记录：
	 */
	public String getCfcommon() {
		return cfcommon;
	}
	/**
	 * 
	 * 描述：备注说明 
	 * @author yangming
	 * @date 2013-9-27 上午9:59:31
	 * @return
	 * 更新记录：
	 */
	public void setCfcommon(String cfcommon) {
		this.cfcommon = cfcommon;
	}
	/**
	 * 
	 * 描述： 计量单位名称
	 * @author yangming
	 * @date 2013-9-27 上午9:59:52
	 * @return
	 * 更新记录：
	 */
	public MeasureUnit getCfunit() {
		return cfunit;
	}
	/**
	 * 
	 * 描述： 计量单位名称 setter
	 * @author yangming
	 * @date 2013-9-27 上午9:59:52
	 * @return
	 * 更新记录：
	 */
	public void setCfunit(MeasureUnit cfunit) {
		this.cfunit = cfunit;
	}
	/**
	 * 
	 * 描述：  配套名称
	 * @author yangming
	 * @date 2013-9-27 上午10:00:15
	 * @return
	 * 更新记录：
	 */
	public OfficePackageName getCfpackageName() {
		return cfpackageName;
	}
	/**
	 * 
	 * 描述： 配套名称
	 * @author yangming
	 * @date 2013-9-27 上午10:00:15
	 * @return
	 * 更新记录：
	 */
	public void setCfpackageName(OfficePackageName cfpackageName) {
		this.cfpackageName = cfpackageName;
	}
	/**
	 * 
	 * 描述： 现状
	 * @author yangming
	 * @date 2013-9-27 上午10:01:28
	 * @return
	 * 更新记录：
	 */
	public int getCfcurrentNum() {
		return cfcurrentNum;
	}
	/**
	 * 
	 * 描述： 现状
	 * @author yangming
	 * @date 2013-9-27 上午10:01:28
	 * @return
	 * 更新记录：
	 */
	public void setCfcurrentNum(int cfcurrentNum) {
		this.cfcurrentNum = cfcurrentNum;
	}
	/**
	 * 
	 * 描述：明年 
	 * @author yangming
	 * @date 2013-9-27 上午10:01:49
	 * @return
	 * 更新记录：
	 */
	public int getCfnextNum() {
		return cfnextNum;
	}
	/**
	 * 
	 * 描述： 明年
	 * @author yangming
	 * @date 2013-9-27 上午10:01:53
	 * @param cfnextNum
	 * 更新记录：
	 */
	public void setCfnextNum(int cfnextNum) {
		this.cfnextNum = cfnextNum;
	}
	/**
	 * 
	 * 描述： 后年
	 * @author yangming
	 * @date 2013-9-27 上午10:02:00
	 * @return
	 * 更新记录：
	 */
	public int getCfafterNextNum() {
		return cfafterNextNum;
	}
	/**
	 * 
	 * 描述： 后年
	 * @author yangming
	 * @date 2013-9-27 上午10:02:00
	 * @return
	 * 更新记录：
	 */
	public void setCfafterNextNum(int cfafterNextNum) {
		this.cfafterNextNum = cfafterNextNum;
	}
	/**
	 * 
	 * 描述： 父类名称
	 * @author yangming
	 * @date 2013-9-27 上午10:02:17
	 * @return
	 * 更新记录：
	 */
	public String getFparentName() {
		return fparentName;
	}
	/**
	 * 
	 * 描述： 父类名称
	 * @author yangming
	 * @date 2013-9-27 上午10:02:17
	 * @return
	 * 更新记录：
	 */
	public void setFparentName(String fparentName) {
		this.fparentName = fparentName;
	}
	
}
