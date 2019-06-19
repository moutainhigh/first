package com.deppon.dpm.doc.server.dao;

import java.util.List;

import com.deppon.dpm.doc.server.entity.DidiOrderEntity;

public interface IMyConsumptionDeptDao {
	/**
	 * 根据部门查询它的当月累计金额
	 * @param deptNameList
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	String queryTotalProcieByDept(List<String> deptNameList, String startDate,
			String endDate);
	/**
	 * 根据部门查询它的月累计公里
	 * @param deptNameList
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	String querynormalDistance(List<String> deptNameList, String startDate, String endDate);
	/**
	 * 根据部门查询它的月累计订单数
	 * @param deptNameList
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	String queryCountMonthByDept(List<String> deptNameList, String startDate,
			String endDate);
	/**
	 * 根据部门查询它的当月打车分布情况
	 * @param deptNameList
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	DidiOrderEntity queryDistributionMonthByDept(List<String> deptNameList,
			String startDate, String endDate);
	/**
	 * 根据部门查询部门概况(这里用DidiOrderEntity对返回数据进行封装)
	 * @param deptName
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	DidiOrderEntity queryDeptSurvey(String deptName, String startDate,
			String endDate);
	/**
	 * 根据部门查询每日总金额
	 * @param deptNameList
	 * @param year
	 * @param month
	 * @return
	 */
	List<DidiOrderEntity> queryVehicleData(List<String> deptNameList, String year,
			String month);
	/**
	 * 根据部门查询部门明细
	 * @param deptNameList
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<DidiOrderEntity> queryDeptDetail(List<String> deptNameList, String startDate,
			String endDate);
	/**
	 * 根据员工号查询个人月累计订单总金额
	 * @param empNo
	 * @param endDate 
	 * @param startDate 
	 * @return
	 */
	String queryTotalPirceByEmpno(String empNo, String startDate, String endDate);
	

}
