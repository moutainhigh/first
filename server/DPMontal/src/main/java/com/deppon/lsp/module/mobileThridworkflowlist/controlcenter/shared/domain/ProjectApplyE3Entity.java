package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;
/**
 * 
 * 作者（修改人）：YangMing
 * 修改时间：2013-9-4 上午11:05:12
 * 描述：工程项目申请单 资源描述 分录实体
 * 更新记录：
 */
public class ProjectApplyE3Entity extends BaseEntity {

	/**
	 * TODO（用一句话描述这个变量表示什么）
	 */
	private static final long serialVersionUID = 5662745786420093123L;
	/* 分录行id */
	private String fid;
	/* 序号 */
	private Long fseq;
	/* 序号 */
	private Long cfseq;
	/* 父表id */
	private String fparentID;
	/* 主控事项ID */
	private String cfmatterID;
	/* 主控事项名称 */
	private MasterEntity cfmatter;
	/* 主控细项ID */
	private String cfminutessID;
	/* 主控细项名称 */
	private MasterItemsEntity cfminutess;
	/* 评判结果 */
	private String cfjudgeResult;
	/* 备注说明 */
	private String cfremark;
	/* 分录标识 */
	private String finPut;
	/* 父表number */
	private String fparentName;
	/**
	 * 
	 * 描述： 父表number
	 * @author yangming
	 * @date 2013-9-27 上午9:39:25
	 * @param fparentName
	 * 更新记录：
	 */
	public String getFparentName() {
		return fparentName;
	}
	/**
	 * 
	 * 描述： 父表number
	 * @author yangming
	 * @date 2013-9-27 上午9:39:25
	 * @param fparentName
	 * 更新记录：
	 */
	public void setFparentName(String fparentName) {
		this.fparentName = fparentName;
	}
	/**
	 * 
	 * 描述： 主控事项名称
	 * @author yangming
	 * @date 2013-9-27 上午9:39:12
	 * @return
	 * 更新记录：
	 */
	public MasterEntity getCfmatter() {
		return cfmatter;
	}
	/**
	 * 
	 * 描述： 主控事项名称
	 * @author yangming
	 * @date 2013-9-27 上午9:39:03
	 * @param cfmatter
	 * 更新记录：
	 */
	public void setCfmatter(MasterEntity cfmatter) {
		this.cfmatter = cfmatter;
	}
	/**
	 * 
	 * 描述： 主控细项名称
	 * @author yangming
	 * @date 2013-9-27 上午9:38:13
	 * @return
	 * 更新记录：
	 */
	public MasterItemsEntity getCfminutess() {
		return cfminutess;
	}
	/**
	 * 
	 * 描述： 主控细项名称
	 * @author yangming
	 * @date 2013-9-27 上午9:37:58
	 * @param cfminutess
	 * 更新记录：
	 */
	public void setCfminutess(MasterItemsEntity cfminutess) {
		this.cfminutess = cfminutess;
	}
	/**
	 * 
	 * 描述：分录行id 
	 * @author yangming
	 * @date 2013-9-27 上午9:28:22
	 * @return
	 * 更新记录：
	 */
	public String getFid() {
		return fid;
	}
	/**
	 * 
	 * 描述：分录行id 
	 * @author yangming
	 * @date 2013-9-27 上午9:28:22
	 * @return
	 * 更新记录：
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}
	/**
	 * 
	 * 描述：单据头id
	 * @author yangming
	 * @date 2013-9-27 上午9:28:22
	 * @return
	 * 更新记录：
	 */
	public String getFparentID() {
		return fparentID;
	}
	/**
	 * 
	 * 描述：单据头id
	 * @author yangming
	 * @date 2013-9-27 上午9:28:22
	 * @return
	 * 更新记录：
	 */
	public void setFparentID(String fparentID) {
		this.fparentID = fparentID;
	}
	/**
	 * 
	 * 描述： 主控事项ID
	 * @author yangming
	 * @date 2013-9-27 上午9:29:19
	 * @return
	 * 更新记录：
	 */
	public String getCfmatterID() {
		return cfmatterID;
	}
	/**
	 * 
	 * 描述： 主控事项ID
	 * @author yangming
	 * @date 2013-9-27 上午9:29:25
	 * @param cfmatterID
	 * 更新记录：
	 */
	public void setCfmatterID(String cfmatterID) {
		this.cfmatterID = cfmatterID;
	}
	/**
	 * 
	 * 描述： 主控细项ID 
	 * @author yangming
	 * @date 2013-9-27 上午9:29:41
	 * @return
	 * 更新记录：
	 */
	public String getCfminutessID() {
		return cfminutessID;
	}
	/**
	 * 
	 * 描述： 主控细项ID 
	 * @author yangming
	 * @date 2013-9-27 上午9:29:47
	 * @param cfminutessID
	 * 更新记录：
	 */
	public void setCfminutessID(String cfminutessID) {
		this.cfminutessID = cfminutessID;
	}
	/**
	 * 
	 * 描述： 评审结果
	 * @author yangming
	 * @date 2013-9-27 上午9:29:53
	 * @return
	 * 更新记录：
	 */
	public String getCfjudgeResult() {
		return cfjudgeResult;
	}
	/**
	 * 
	 * 描述： 评审结果
	 * @author yangming
	 * @date 2013-9-27 上午9:29:53
	 * @return
	 * 更新记录：
	 */
	public void setCfjudgeResult(String cfjudgeResult) {
		this.cfjudgeResult = cfjudgeResult;
	}
	/**
	 * 
	 * 描述： 备注
	 * @author yangming
	 * @date 2013-9-27 上午9:30:17
	 * @return
	 * 更新记录：
	 */
	public String getCfremark() {
		return cfremark;
	}
	/**
	 * 
	 * 描述： 备注
	 * @author yangming
	 * @date 2013-9-27 上午9:30:17
	 * @return
	 * 更新记录：
	 */
	public void setCfremark(String cfremark) {
		this.cfremark = cfremark;
	}
	public String getFinPut() {
		return finPut;
	}
	public void setFinPut(String finPut) {
		this.finPut = finPut;
	}
	/**
	 * 
	 * 描述： 分录序号
	 * @author yangming
	 * @date 2013-9-27 上午9:30:17
	 * @return
	 * 更新记录：
	 */
	public Long getFseq() {
		return fseq;
	}
	/**
	 * 
	 * 描述： 分录序号
	 * @author yangming
	 * @date 2013-9-27 上午9:31:09
	 * @param fseq
	 * 更新记录：
	 */
	public void setFseq(Long fseq) {
		this.fseq = fseq;
	}
	/**
	 * 
	 * 描述： 分录序号
	 * @author yangming
	 * @date 2013-9-27 上午9:34:55
	 * @return
	 * 更新记录：
	 */
	public Long getCfseq() {
		return cfseq;
	}
	/**
	 * 
	 * 描述： 分录序号
	 * @author yangming
	 * @date 2013-9-27 上午9:35:03
	 * @param cfseq
	 * 更新记录：
	 */
	public void setCfseq(Long cfseq) {
		this.cfseq = cfseq;
	}
	
	
}
