package com.deppon.dpm.module.management.server.service;

import com.deppon.dpm.module.management.shared.domain.YearSummaryEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

/**
 * 2017年度总结
 * @author 276344
 *
 */
public interface IYearSummaryService {
	/**
	 * 获取结果
	 * @param userId
	 * @return
	 */
	public YearSummaryEntity getSummaryByEmpcode(String userId);

	public EmployeeVO getLeaveEmpcode(String userId);

	public YearSummaryEntity getYearSummary(String empCode);
}
