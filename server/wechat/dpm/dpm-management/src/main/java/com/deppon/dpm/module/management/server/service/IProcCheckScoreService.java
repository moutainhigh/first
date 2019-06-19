package com.deppon.dpm.module.management.server.service;

import java.util.List;

public interface IProcCheckScoreService {
	/**
     * 保存合格和不合格
     * @param String
     * @return String
     */
	public String savaPassCheck(String stu);
	/**
     * 拉保存合格和不合格数据
     * @param String
     * @return String
     */
	
	public String getProcCheckStandard(String stu);
	/**
     * 修改状态和COPR数据
     * @param String
     * @return String
     */
	
	public String updateCheckRecordAll(String stu)  throws Exception ;
	/**
     * 数据访问量保存
     * @param String
     * @return String
     */
	public String savaCheckControl(String stu);
	// PC的状态
	public String getisSubmit(int i);

	// 初次和最终提交的状态
	public int getnum(int i);
	// 对数据库查询的分割
	public String[] getSplit(String stu);
	// 判读图片不为空
	public void getImg(String r, List<Object> imglist);
}
