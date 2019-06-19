package com.deppon.dpm.doc.server.dao;

import java.util.List;

import com.deppon.dpm.doc.server.vo.DidiOrderVO;

public interface IPageFunctionDao {

	public List<DidiOrderVO> totalRecord(String userId ,int pageSize);
	
	/**
	 * 查询某部门当月的打车信息
	 * @param deptname
	 * @param pageSize
	 * @param taxidate
	 * @return
	 */
	public List<DidiOrderVO> deptRecord(String deptname ,int pageSize,String taxidate);
	
	public List<DidiOrderVO> pageMsg(String userId,int requestBeginNum);

	/**
	 * @Desciption:TODO(个人当月打车消费记录)
	 * @author lvdefu
	 * @param remark 
	 * @date:2018年4月8日16:05:57
	 */
	public List<DidiOrderVO> queryDetailByDate(String userId, String year,String month, String remark);
	/**
	 * @Desciption:TODO(根据年月领导查询部门打车明细)
	 * @author lvdefu
	 * @param employee 
	 * @param remark 
	 * @date:2018年4月8日17:44:27
	 */
	public List<DidiOrderVO> departmentTaxi(List<String> deptNameList,String startDate, String endDate, String remark, String employee);
	
}
