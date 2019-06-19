/**
 * Entity开发规范
 * 1.必须继承com.deppon.foss.framework.entity.BaseEntity
 * 2.类名必须以Entity结尾
 * 3.必须生成serialVersionUID
 * 4.建议属性名称与数据库字段命名规则一致
 */
package com.deppon.dpm.module.announce.shared.vo;

import java.util.List;

import com.deppon.dpm.module.announce.shared.domain.AnnounceEntity;

/**
 * 公告表实体
 * 
 * @author 045925
 * 
 */
public class AnnounceResult {
	/**
	 * 公告实体集合
	 */
	private List<AnnounceEntity> announceList;

	/**
	 * get
	 * 
	 * @return
	 */
	public List<AnnounceEntity> getAnnounceList() {
		return announceList;
	}

	/**
	 * set
	 * 
	 * @param announceList
	 */
	public void setAnnounceList(List<AnnounceEntity> announceList) {
		this.announceList = announceList;
	}
}