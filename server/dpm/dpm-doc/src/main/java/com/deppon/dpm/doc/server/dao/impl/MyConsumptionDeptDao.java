package com.deppon.dpm.doc.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import com.deppon.dpm.doc.server.dao.IMyConsumptionDeptDao;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class MyConsumptionDeptDao extends iBatis3DaoImpl implements IMyConsumptionDeptDao{
	
	private static final String NAME_SPACE="com.deppon.dpm.doc.server.dao.DidiOrderDao.";
	
	/**
	 * 根据部查询它的当月累计金额
	 */
	@Override
	public String queryTotalProcieByDept(List<String> deptNameList, String startDate,
			String endDate) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//将参数放入map
		map.put("startDate", startDate);//起始日期
		map.put("endDate", endDate);//结束日期
		map.put("deptNameList", deptNameList);//部门名称;
		String totalPriceMonthByDept = (String) getSqlSession().selectOne(NAME_SPACE+"queryTotalProcieByDept", map);
		if(StringUtils.isNotEmpty(totalPriceMonthByDept)){
			return (String) getSqlSession().selectOne(NAME_SPACE+"queryTotalProcieByDept", map);
		}else{
			return null;
		}
		
	}
	/**
	 * 根据部门查询它的月累计公里
	 */
	@Override
	public String querynormalDistance(List<String> deptNameList, String startDate,
			String endDate) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//将参数放入map
		map.put("startDate", startDate);//起始日期
		map.put("endDate", endDate);//结束日期
		map.put("deptNameList", deptNameList);//部门名称;
		String normalDistanceMonthByDept = (String) getSqlSession().selectOne(NAME_SPACE+"querynormalDistance", map);
		if(StringUtils.isNotEmpty(normalDistanceMonthByDept)){
			return (String) getSqlSession().selectOne(NAME_SPACE+"querynormalDistance", map);
		}else{
			return null;
		}
	}
	/**
	 * 根据部门查询它的月累计订单数
	 */
	@Override
	public String queryCountMonthByDept(List<String> deptNameList, String startDate,
			String endDate) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//将参数放入map
		map.put("startDate", startDate);//起始日期
		map.put("endDate", endDate);//结束日期
		map.put("deptNameList", deptNameList);//部门名称;
		String CountMonthByDept = (String) getSqlSession().selectOne(NAME_SPACE+"queryCountMonthByDept", map);
		if(StringUtils.isNotEmpty(CountMonthByDept)){
			return (String) getSqlSession().selectOne(NAME_SPACE+"queryCountMonthByDept", map);
		}else{
			return null;
		}
		
	}
	/**
	 * 根据部门查询它的当月打车分布情况
	 */
	@Override
	public DidiOrderEntity queryDistributionMonthByDept(List<String> deptNameList,
			String startDate, String endDate) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//将参数放入map
		map.put("startDate", startDate);//起始日期
		map.put("endDate", endDate);//结束日期
		map.put("deptNameList", deptNameList);//部门名称;
		DidiOrderEntity distributionMonthByDept = (DidiOrderEntity) getSqlSession().selectOne(NAME_SPACE+"queryDistributionMonthByDept", map);
		if(distributionMonthByDept!=null){
			return (DidiOrderEntity) getSqlSession().selectOne(NAME_SPACE+"queryDistributionMonthByDept", map);
		}else{
			return null;
		}
		
	}
	/**
	 * 根据部门查询部门概况(这里用DidiOrderEntity对返回数据进行封装)
	 */
	@Override
	public DidiOrderEntity queryDeptSurvey(String deptName, String startDate,
			String endDate) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//将参数放入map
		map.put("startDate", startDate);//起始日期
		map.put("endDate", endDate);//结束日期
		map.put("deptName", deptName);//部门名称;
		return (DidiOrderEntity) getSqlSession().selectOne(NAME_SPACE+"", map);
	}
	/**
	 * 根据部门查询部门每日订单总金额
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DidiOrderEntity> queryVehicleData(List<String> deptNameList, String startDate,
			String endDate) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//将参数放入map
		map.put("startDate", startDate);//起始日期
		map.put("endDate", endDate);//结束日期
		map.put("deptNameList", deptNameList);//部门名称;
		List<DidiOrderEntity>  list=getSqlSession().selectList(NAME_SPACE+"queryVehicleData", map);
		if(list.size()!=0 && list!=null ){
			return list;
		}else{
			return null;
		}
	}
	/**
	 * 根据部门查询部门明细,拿到前5个
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DidiOrderEntity> queryDeptDetail(List<String> deptNameList,
			String startDate, String endDate) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//将参数放入map
		map.put("startDate", startDate);//起始日期
		map.put("endDate", endDate);//结束日期
		map.put("deptNameList", deptNameList);//部门名称;
		List<DidiOrderEntity> list = getSqlSession().selectList(NAME_SPACE+"queryDeptDetail", map);
		if(list.size()!=0 && list!=null){
			return list;
		}else{
			return null;
		}	
	}
	/**
	 * 根据员工号查询个人月累计订单总金额
	 */
	@Override
	public String queryTotalPirceByEmpno(String empNo, String startDate, String endDate) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//将参数放入map
		map.put("startDate", startDate);//起始日期
		map.put("endDate", endDate);//结束日期
		map.put("employeeno", empNo);//部门名称;
		String totalPriceByPerson = (String) getSqlSession().selectOne(NAME_SPACE+"queryTotalPirceByEmpno", map);
		if(totalPriceByPerson!=null){
			return totalPriceByPerson;
		}else{
			return null;
		}
		
	}
	

}
