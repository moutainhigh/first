package com.deppon.dpm.doc.server.service;

import java.util.List;

import com.deppon.dpm.doc.server.vo.DidiOrderVO;

public interface IPageFunctionService {
	/**
	 * 查询全部数据
	 * @param PersonalCenter
	 * @return
	 */
	public List<DidiOrderVO> totalRecord(String userId ,int pageSize,boolean islead,String deptname);
	/**
	 * 查询当前页数据
	 * @param PersonalCenter
	 * @return
	 */
	public List<DidiOrderVO> pageMsg(String userId,int requestBeginNum);
	/**
	 * 根据年月查询个人打车明细
	 * @param userId
	 * @param remark 
	 * @param year
	 * @param month
	 * @return
	 */
	public List<DidiOrderVO> queryDetailByDate(String userId, String startDate,String endDate, String remark);
	/**
	 * 根据年月查询部门明细
	 * @param deptNameList
	 * @param startDate
	 * @param endDate
	 * @param employee 
	 * @param remark 
	 * @return
	 */
	public List<DidiOrderVO> departmentTaxi(List<String> deptNameList,String startDate, String endDate, String remark, String employee);
}
