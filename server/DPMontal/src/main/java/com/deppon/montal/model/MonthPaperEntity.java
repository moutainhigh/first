package com.deppon.montal.model;

import java.sql.Clob;

/**
 * 月报实体
 * @author 130346
 *
 */
public class MonthPaperEntity {
	/**
	 * id
	 */
	private int articleId;
	/**
	 * 标题
	 */
	private String articleName;
	/**
	 * 板块ID
	 */
	private int layoutId;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 访问量
	 */
	private int viewsAmount;
	private String picture;
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public int getLayoutId() {
		return layoutId;
	}
	public void setLayoutId(int layoutId) {
		this.layoutId = layoutId;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewsAmount() {
		return viewsAmount;
	}
	public void setViewsAmount(int viewsAmount) {
		this.viewsAmount = viewsAmount;
	}
	
	
}
