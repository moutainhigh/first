package com.deppon.dpm.module.management.shared.vo;

import java.io.Serializable;
import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ServeOriginatorsInfoEntity;
import com.deppon.dpm.module.management.shared.domain.ServeParticipantsInfoEntity;
/**
 * 封装详情信息
 * @author 293888
 *
 */
public class PcDetailInfoVo implements Serializable {
	/**
	 * 序列
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 成功标示
	 */
	private boolean resultFlag = false;
	ServeOriginatorsInfoEntity serveOriginatorsInfoEntity; //发布信息对象
	private List<ServeParticipantsInfoEntity> serveParticipantsInfoEntities ; //报名者list
	/**
	 * 发布信息对象
	 * @return
	 */
	public ServeOriginatorsInfoEntity getServeOriginatorsInfoEntity() {
		return serveOriginatorsInfoEntity;
	}
	public void setServeOriginatorsInfoEntity(
			ServeOriginatorsInfoEntity serveOriginatorsInfoEntity) {
		this.serveOriginatorsInfoEntity = serveOriginatorsInfoEntity;
	}
	
	/**
	 * 成功标示
	 * @return
	 */
	public boolean isResultFlag() {
		return resultFlag;
	}
	public void setResultFlag(boolean resultFlag) {
		this.resultFlag = resultFlag;
	}
	/**
	 * 报名者list
	 * @return
	 */
	public List<ServeParticipantsInfoEntity> getServeParticipantsInfoEntities() {
		return serveParticipantsInfoEntities;
	}
	public void setServeParticipantsInfoEntities(
			List<ServeParticipantsInfoEntity> serveParticipantsInfoEntities) {
		this.serveParticipantsInfoEntities = serveParticipantsInfoEntities;
	}
}
