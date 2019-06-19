/**
 * 
 */
package com.deppon.wfs.workflow.domain;

import java.io.Serializable;

/**
 * 
 * <pre>
 * WFS通用实体类
 * </pre>
 *
 * @since 
 *
 * <pre>
 *	  modify by jiangzimao on 2013年8月19日
 *    fix->1.创建
 * </pre> 
 */
public abstract class Entity implements Serializable{

	private static final long serialVersionUID = -2999305889461220745L;
	//流程定义名称
	private String processDefName;
	
	public Entity() {
	}

	/**
	 * @return processDefName
	 */
	public String getProcessDefName() {
		return this.processDefName;
	}

	/**
	 * @param processDefName 要设置的 processDefName
	 */
	public void setProcessDefName(String processDefName) {
		this.processDefName = processDefName;
	}
}
