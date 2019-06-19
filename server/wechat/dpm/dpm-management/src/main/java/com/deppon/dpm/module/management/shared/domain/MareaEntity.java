package com.deppon.dpm.module.management.shared.domain;


import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * TODO(维修区域实体类)
 * 
 * @author jianweiqiang
 * @date 2013-8-29 上午11:44:12
 * @since
 * @version V 0.1
 */
public class MareaEntity extends BaseEntity {
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -1588378565746881088L;
	// 维修区域id
	private String aid;
	// 维修区域名称
	private String aname;
	// 维修区域工号
	private String anumber;
	//维修区域描述
	private String adesc;
	/**
	 * 
	 * <pre>方法说明: 执行操作
	 * @author jianweiqiang
	 * @date 2013-9-27 下午2:49:11
	 * @return
	 * @see
	 *</pre>
	 */
	public String getAid() {
		return aid;
	}
	/**
	 * 
	 * <pre>方法说明: 执行操作
	 * @author jianweiqiang
	 * @date 2013-9-27 下午2:49:16
	 * @param aid
	 * @see
	 *</pre>
	 */
	public void setAid(String aid) {
		this.aid = aid;
	}
	/**
	 * 
	 * <pre>方法说明: 执行操作
	 * @author jianweiqiang
	 * @date 2013-9-27 下午2:49:19
	 * @return
	 * @see
	 *</pre>
	 */
	public String getAname() {
		return aname;
	}
	/**
	 * 
	 * <pre>方法说明: 执行操作
	 * @author jianweiqiang
	 * @date 2013-9-27 下午2:49:23
	 * @param aname
	 * @see
	 *</pre>
	 */
	public void setAname(String aname) {
		this.aname = aname;
	}
	/**
	 * 
	 * <pre>方法说明: 执行操作
	 * @author jianweiqiang
	 * @date 2013-9-27 下午2:49:27
	 * @return
	 * @see
	 *</pre>
	 */
	public String getAnumber() {
		return anumber;
	}
	/**
	 * 
	 * <pre>方法说明: 执行操作
	 * @author jianweiqiang
	 * @date 2013-9-27 下午2:49:32
	 * @param anumber
	 * @see
	 *</pre>
	 */
	public void setAnumber(String anumber) {
		this.anumber = anumber;
	}
	/**
	 * 
	 * <pre>方法说明: 执行操作
	 * @author jianweiqiang
	 * @date 2013-9-27 下午2:49:36
	 * @return
	 * @see
	 *</pre>
	 */
	public String getAdesc() {
		return adesc;
	}
	/**
	 * 
	 * <pre>方法说明: 执行操作
	 * @author jianweiqiang
	 * @date 2013-9-27 下午2:49:40
	 * @param adesc
	 * @see
	 *</pre>
	 */
	public void setAdesc(String adesc) {
		this.adesc = adesc;
	}
	
}
