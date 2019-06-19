package com.deppon.dpm.login.server.action;

import com.deppon.foss.framework.server.web.action.AbstractAction;

/**
 * 数据字典Action ClassName: DataDictionaryAction <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2014-8-19 上午9:57:41 <br/>
 * 
 * @author 157229-zxy
 * @version
 * @since JDK 1.6
 */
public class DataDictionaryAction extends AbstractAction {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4387687988772020011L;
	/**
	 * 上次修改时间
	 */
	private long lastModifyTime;

	/**
	 * get
	 * 
	 * @return
	 */
	public long getLastModifyTime() {
		return lastModifyTime;
	}

	/**
	 * set
	 * 
	 * @param lastModifyTime
	 */
	public void setLastModifyTime(long lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
}
