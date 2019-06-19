package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.montal.util.FormatUtil;
public class ProjectStatusEntry extends BaseEntity {
	
	private static final long serialVersionUID = 3589163493434970509L;
	private String fid;						//主键
	private Long fseq;						//序列
	private String fparentId;				//外键
	private String cfWaitMatter;			//待办事项(会议主题)  
	private String cfResponsibleId;			//负责人id
	private Date cfFinishTime;				//完成时间
	private String cfComment;				//备注
	private String cfResponsibleIdAsName;	//负责人名称
	/**
	 * 
	 * @Description : 执行操作getFseq
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:54:51
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public Long getFseq() {
		return fseq;
	}
	/**
	 * 
	 * @Description : 执行操作setFseq
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:54:51
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFseq(Long fseq) {
		this.fseq = fseq;
	}
	/**
	 * 
	 * @Description : 执行操作getFid
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:54:51
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFid() {
		return fid;
	}
	/**
	 * 
	 * @Description : 执行操作setFid
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:54:51
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}
	/**
	 * 
	 * @Description : 执行操作getFparentId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:54:51
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFparentId() {
		return fparentId;
	}
	/**
	 * 
	 * @Description : 执行操作setFparentId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:54:51
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFparentId(String fparentId) {
		this.fparentId = fparentId;
	}
	/**
	 * 
	 * @Description : 执行操作getCfWaitMatter
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:54:51
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getCfWaitMatter() {
		if (cfWaitMatter == null) {
			cfWaitMatter = "";
		}
		return cfWaitMatter;
	}
	/**
	 * 
	 * @Description : 执行操作setCfWaitMatter
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:54:51
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfWaitMatter(String cfWaitMatter) {
		this.cfWaitMatter = cfWaitMatter;
	}
	/**
	 * 
	 * @Description : 执行操作getCfResponsibleId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:54:51
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getCfResponsibleId() {
		return cfResponsibleId;
	}
	/**
	 * 
	 * @Description : 执行操作setCfResponsibleId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:54:51
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfResponsibleId(String cfResponsibleId) {
		this.cfResponsibleId = cfResponsibleId;
	}
	/**
	 * 
	 * @Description : 执行操作getCfFinishTime
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:54:51
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public Date getCfFinishTime() {
		return cfFinishTime;
	}
	
	public String getCfFinishTimeStr() {
		return FormatUtil.formatDate(cfFinishTime,"yyyy-MM-dd");
	}
	/**
	 * 
	 * @Description : 执行操作setCfFinishTime
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:54:51
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfFinishTime(Date cfFinishTime) {
		this.cfFinishTime = cfFinishTime;
	}
	/**
	 * 
	 * @Description : 执行操作getCfComment
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:54:51
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getCfComment() {
		if (cfComment == null){
			cfComment = "";
		}
		return cfComment;
	}
	/**
	 * 
	 * @Description : 执行操作setCfComment
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:54:51
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfComment(String cfComment) {
		this.cfComment = cfComment;
	}
	/**
	 * 
	 * @Description : 执行操作getCfResponsibleIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:54:51
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getCfResponsibleIdAsName() {
		if (cfResponsibleIdAsName == null) {
			cfResponsibleIdAsName = "";
		}
		return cfResponsibleIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作setCfResponsibleIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:54:51
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfResponsibleIdAsName(String cfResponsibleIdAsName) {
		this.cfResponsibleIdAsName = cfResponsibleIdAsName;
	}
	/**
	 * 
	 * @Description:覆盖toString方法
	 * @author jianweiqiang
	 * @date 2014-1-15 上午9:51:32
	 * @return 
	 * @see java.lang.Object#toString()
	 * @version V1.0
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

