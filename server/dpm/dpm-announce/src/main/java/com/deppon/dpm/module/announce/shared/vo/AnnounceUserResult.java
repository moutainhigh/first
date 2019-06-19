/**
 * Entity开发规范
 * 1.必须继承com.deppon.foss.framework.entity.BaseEntity
 * 2.类名必须以Entity结尾
 * 3.必须生成serialVersionUID
 * 4.建议属性名称与数据库字段命名规则一致
 */
package com.deppon.dpm.module.announce.shared.vo;

import java.util.List;

import com.deppon.dpm.module.announce.shared.domain.AnnounceUserEntity;

/**
 * 公告表实体
 * 
 * @author 045925
 * 
 */
public class AnnounceUserResult {
	/**
	 * 公告操作实体集合
	 */
	private List<AnnounceUserEntity> announceUserList;

	/**
	 * get
	 * 
	 * @return
	 */
	public List<AnnounceUserEntity> getAnnounceUserList() {
		return announceUserList;
	}

	/**
	 * set
	 * 
	 * @param announceUserList
	 */
	public void setAnnounceUserList(List<AnnounceUserEntity> announceUserList) {
		this.announceUserList = announceUserList;
	}
}