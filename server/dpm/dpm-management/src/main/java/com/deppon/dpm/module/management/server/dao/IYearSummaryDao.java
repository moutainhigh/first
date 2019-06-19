package com.deppon.dpm.module.management.server.dao;

import com.deppon.dpm.module.management.shared.domain.YearSummaryEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

/**
 * 2017年度总结
 * @author 276344
 *
 */
public interface IYearSummaryDao {
	/**
	 * 根据工号查询结果
	 * @param userId
	 * @return
	 */
	public YearSummaryEntity getYearSummaryByEmpCode(String userId);
	
	public YearSummaryEntity getYearSummary(String empCode);

	public EmployeeVO getLeaveByEmpCode(String userId);
}
