package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.NewsalesentryEntity;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.NewsalesmaterialapplyEntity;

/**
 * 
 * @Description : 新点物料申请单
 * @author : jianweiqiang
 * @date 2014-5-20 下午5:32:30
 * @since
 * @version v0.1
 */
public class NewsalesmaterialVo {
	// 新点物料申请单主表
	private NewsalesmaterialapplyEntity newsalesmaterialapplyEntity;
	// 新点物料申请单分录
	private NewsalesentryEntity[] newsalesentryEntityList;

	/**
	 * @Description : 返回 newsalesmaterialapplyEntity属性的值
	 * @date 2014-5-21 上午9:06:21
	 */
	
	public NewsalesmaterialapplyEntity getNewsalesmaterialapplyEntity() {
		return newsalesmaterialapplyEntity;
	}

	/**
	 * @param  设置属性 newsalesmaterialapplyEntity的值
	 */
	public void setNewsalesmaterialapplyEntity(
			NewsalesmaterialapplyEntity newsalesmaterialapplyEntity) {
		this.newsalesmaterialapplyEntity = newsalesmaterialapplyEntity;
	}

	/**
	 * @Description : 返回 newsalesentryEntityList属性的值
	 * @date 2014-5-21 上午9:06:21
	 */
	
	public NewsalesentryEntity[] getNewsalesentryEntityList() {
		if (newsalesentryEntityList == null) {
			newsalesentryEntityList = new NewsalesentryEntity[0];
		}
		return newsalesentryEntityList;
	}

	/**
	 * @param  设置属性 newsalesentryEntityList的值
	 */
	public void setNewsalesentryEntityList(
			NewsalesentryEntity[] newsalesentryEntityList) {
		this.newsalesentryEntityList = newsalesentryEntityList;
	}

	/**
	 * 
	 * @Description : 覆盖toString方法
	 * @author : jianweiqiang
	 * @date 2014-5-20 下午5:35:49
	 * @return 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
