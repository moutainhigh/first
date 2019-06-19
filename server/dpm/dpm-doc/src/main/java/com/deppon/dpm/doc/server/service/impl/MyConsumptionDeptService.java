package com.deppon.dpm.doc.server.service.impl;

import java.util.List;
import com.deppon.dpm.doc.server.dao.IMyConsumptionDeptDao;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.service.IMyConsumptionDeptService;

public class MyConsumptionDeptService implements IMyConsumptionDeptService{
	/**
	 * 注入Dao
	 */
	private IMyConsumptionDeptDao myConsumptionDeptDao;

	public IMyConsumptionDeptDao getMyConsumptionDeptDao() {
		return myConsumptionDeptDao;
	}

	public void setMyConsumptionDeptDao(IMyConsumptionDeptDao myConsumptionDeptDao) {
		this.myConsumptionDeptDao = myConsumptionDeptDao;
	}
	/**
	 * 根据部查询它的当月累计金额
	 */
	@Override
	public String queryTotalProcieByDept(List<String> deptNameList, String startDate,
			String endDate) {
		return myConsumptionDeptDao.queryTotalProcieByDept(deptNameList,startDate,endDate);
	}
	/**
	 * 根据部门查询它的月累计公里
	 */
	@Override
	public String querynormalDistance(List<String> deptNameList, String startDate,
			String endDate) {
		return myConsumptionDeptDao.querynormalDistance(deptNameList,startDate,endDate);
	}
	/**
	 * 根据部门查询它的月累计订单数
	 */
	@Override
	public String queryCountMonthByDept(List<String> deptNameList, String startDate,
			String endDate) {
		return myConsumptionDeptDao.queryCountMonthByDept(deptNameList,startDate,endDate);
	}
	/**
	 * 根据部门查询它的当月打车分布情况
	 */
	@Override
	public DidiOrderEntity queryDistributionMonthByDept(List<String> deptNameList,
			String startDate, String endDate) {
		return myConsumptionDeptDao.queryDistributionMonthByDept(deptNameList,startDate,endDate);
	}
	/**
	 * 根据部门查询部门概况(这里用DidiOrderEntity对返回数据进行封装)
	 */
	@Override
	public DidiOrderEntity queryDeptSurvey(String deptName, String startDate,
			String endDate) {
		return myConsumptionDeptDao.queryDeptSurvey(deptName,startDate,endDate);
	}
	/**
	 * 根据部门查询每日总金额
	 */
	@Override
	public List<DidiOrderEntity> queryVehicleData(List<String> deptNameList, String startDate, String endDate) {
		return myConsumptionDeptDao.queryVehicleData(deptNameList,startDate,endDate);
	}
	/**
	 * 根据部门查询部门明细
	 */
	@Override
	public List<DidiOrderEntity> queryDeptDetail(List<String> deptNameList,
			String startDate, String endDate) {
		return myConsumptionDeptDao.queryDeptDetail(deptNameList,startDate,endDate);
	}
	/**
	 * 根据员工号查询个人月累计订单总金额
	 */
	@Override
	public String queryTotalPirceByEmpno(String empNo, String startDate, String endDate) {
		return myConsumptionDeptDao.queryTotalPirceByEmpno(empNo,startDate,endDate);
	}

	
	
	
}
