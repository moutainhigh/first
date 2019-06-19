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
public class AnnounceIndexResult {
	/**
	 * 滚动新闻列表
	 */
	private List<AnnounceEntity> scrollNews;
	/**
	 * 普通新闻列表
	 */
	private List<AnnounceEntity> normalNews;

	/**
	 * get
	 * 
	 * @return
	 */
	public List<AnnounceEntity> getScrollNews() {
		return scrollNews;
	}

	/**
	 * set
	 * 
	 * @param scrollNews
	 */
	public void setScrollNews(List<AnnounceEntity> scrollNews) {
		this.scrollNews = scrollNews;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public List<AnnounceEntity> getNormalNews() {
		return normalNews;
	}

	/**
	 * set
	 * 
	 * @param normalNews
	 */
	public void setNormalNews(List<AnnounceEntity> normalNews) {
		this.normalNews = normalNews;
	}
}