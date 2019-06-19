package com.deppon.dpm.store.server.vo;
/**
 * 
 * @author XiaoTian
 *
 */
public class LabelVo {
	//标签名称
	private String tagename;
	//标签是否启用
	private boolean issel;
	/**
	 * 构造器
	 */
	public LabelVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @return
	 */
	public String getTagename() {
		return tagename;
	}
	/**
	 * 
	 * @param tagename
	 */
	public void setTagename(String tagename) {
		this.tagename = tagename;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isIssel() {
		return issel;
	}
	/**
	 * 
	 * @param issel
	 */
	public void setIssel(boolean issel) {
		this.issel = issel;
	}
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "LabelVo [tagename=" + tagename + ", issel=" + issel + "]";
	}
	
	
}
