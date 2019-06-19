package com.deppon.dpm.login.server.vo;

import com.deppon.dpm.login.server.domain.TreeNode;
import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 功能树节点的实体对象 ClassName: ResourceTreeNode <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2014-8-19 上午10:29:25 <br/>
 * 
 * @author 157229-zxy
 * @version @param <T>
 * @since JDK 1.6
 */
@SuppressWarnings("rawtypes")
public class ResourceTreeNode<T extends BaseEntity> extends
		TreeNode<T, ResourceTreeNode> {
	/**
	 * 连接
	 */
	private String uri;
	/**
	 * 是否可展开
	 */
	private Boolean expandable;
	/**
	 * 是否展开
	 */
	private Boolean expend;
	/**
	 * 显示图标
	 */
	private String iconCls;
	/**
	 * 菜单的CSS
	 */
	private String cls;
	/**
	 * 菜单的显示顺序
	 */
	private String displayOrder;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getCls() {
		return cls;
	}

	/**
	 * set
	 * 
	 * @param cls
	 */
	public void setCls(String cls) {
		this.cls = cls;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getIconCls() {
		return iconCls;
	}

	/**
	 * set
	 * 
	 * @param iconCls
	 */
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Boolean getExpandable() {
		return expandable;
	}

	/**
	 * set
	 * 
	 * @param expandable
	 */
	public void setExpandable(Boolean expandable) {
		this.expandable = expandable;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * set
	 * 
	 * @param uri
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Boolean getExpend() {
		return expend;
	}

	/**
	 * set
	 * 
	 * @param expend
	 */
	public void setExpend(Boolean expend) {
		this.expend = expend;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getDisplayOrder() {
		return displayOrder;
	}

	/**
	 * set
	 * 
	 * @param displayOrder
	 */
	public void setDisplayOrder(String displayOrder) {
		this.displayOrder = displayOrder;
	}
}
